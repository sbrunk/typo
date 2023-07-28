/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object PhonenumbertypeRepoImpl extends PhonenumbertypeRepo {
  override def delete(phonenumbertypeid: PhonenumbertypeId)(implicit c: Connection): Boolean = {
    SQL"delete from person.phonenumbertype where phonenumbertypeid = $phonenumbertypeid".executeUpdate() > 0
  }
  override def insert(unsaved: PhonenumbertypeRow)(implicit c: Connection): PhonenumbertypeRow = {
    SQL"""insert into person.phonenumbertype(phonenumbertypeid, "name", modifieddate)
          values (${unsaved.phonenumbertypeid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.modifieddate}::timestamp)
          returning phonenumbertypeid, "name", modifieddate::text
       """
      .executeInsert(PhonenumbertypeRow.rowParser(1).single)
    
  }
  override def insert(unsaved: PhonenumbertypeRowUnsaved)(implicit c: Connection): PhonenumbertypeRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.phonenumbertypeid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("phonenumbertypeid", ParameterValue.from[PhonenumbertypeId](value)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into person.phonenumbertype default values
            returning phonenumbertypeid, "name", modifieddate::text
         """
        .executeInsert(PhonenumbertypeRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.phonenumbertype(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning phonenumbertypeid, "name", modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(PhonenumbertypeRow.rowParser(1).single)
    }
    
  }
  override def selectAll(implicit c: Connection): List[PhonenumbertypeRow] = {
    SQL"""select phonenumbertypeid, "name", modifieddate::text
          from person.phonenumbertype
       """.as(PhonenumbertypeRow.rowParser(1).*)
  }
  override def selectById(phonenumbertypeid: PhonenumbertypeId)(implicit c: Connection): Option[PhonenumbertypeRow] = {
    SQL"""select phonenumbertypeid, "name", modifieddate::text
          from person.phonenumbertype
          where phonenumbertypeid = $phonenumbertypeid
       """.as(PhonenumbertypeRow.rowParser(1).singleOpt)
  }
  override def selectByIds(phonenumbertypeids: Array[PhonenumbertypeId])(implicit c: Connection): List[PhonenumbertypeRow] = {
    SQL"""select phonenumbertypeid, "name", modifieddate::text
          from person.phonenumbertype
          where phonenumbertypeid = ANY($phonenumbertypeids)
       """.as(PhonenumbertypeRow.rowParser(1).*)
    
  }
  override def update(row: PhonenumbertypeRow)(implicit c: Connection): Boolean = {
    val phonenumbertypeid = row.phonenumbertypeid
    SQL"""update person.phonenumbertype
          set "name" = ${row.name}::"public"."Name",
              modifieddate = ${row.modifieddate}::timestamp
          where phonenumbertypeid = $phonenumbertypeid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: PhonenumbertypeRow)(implicit c: Connection): PhonenumbertypeRow = {
    SQL"""insert into person.phonenumbertype(phonenumbertypeid, "name", modifieddate)
          values (
            ${unsaved.phonenumbertypeid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (phonenumbertypeid)
          do update set
            "name" = EXCLUDED."name",
            modifieddate = EXCLUDED.modifieddate
          returning phonenumbertypeid, "name", modifieddate::text
       """
      .executeInsert(PhonenumbertypeRow.rowParser(1).single)
    
  }
}
