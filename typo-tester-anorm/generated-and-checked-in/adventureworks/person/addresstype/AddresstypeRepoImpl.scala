/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object AddresstypeRepoImpl extends AddresstypeRepo {
  override def delete(addresstypeid: AddresstypeId)(implicit c: Connection): Boolean = {
    SQL"""delete from person.addresstype where "addresstypeid" = ${ParameterValue(addresstypeid, null, AddresstypeId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[AddresstypeFields, AddresstypeRow] = {
    DeleteBuilder("person.addresstype", AddresstypeFields)
  }
  override def insert(unsaved: AddresstypeRow)(implicit c: Connection): AddresstypeRow = {
    SQL"""insert into person.addresstype("addresstypeid", "name", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.addresstypeid, null, AddresstypeId.toStatement)}::int4, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "addresstypeid", "name", "rowguid", "modifieddate"::text
       """
      .executeInsert(AddresstypeRow.rowParser(1).single)
    
  }
  override def insert(unsaved: AddresstypeRowUnsaved)(implicit c: Connection): AddresstypeRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      unsaved.addresstypeid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("addresstypeid", ParameterValue(value, null, AddresstypeId.toStatement)), "::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue(value, null, TypoUUID.toStatement)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into person.addresstype default values
            returning "addresstypeid", "name", "rowguid", "modifieddate"::text
         """
        .executeInsert(AddresstypeRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.addresstype(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "addresstypeid", "name", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(AddresstypeRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[AddresstypeFields, AddresstypeRow] = {
    SelectBuilderSql("person.addresstype", AddresstypeFields, AddresstypeRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[AddresstypeRow] = {
    SQL"""select "addresstypeid", "name", "rowguid", "modifieddate"::text
          from person.addresstype
       """.as(AddresstypeRow.rowParser(1).*)
  }
  override def selectById(addresstypeid: AddresstypeId)(implicit c: Connection): Option[AddresstypeRow] = {
    SQL"""select "addresstypeid", "name", "rowguid", "modifieddate"::text
          from person.addresstype
          where "addresstypeid" = ${ParameterValue(addresstypeid, null, AddresstypeId.toStatement)}
       """.as(AddresstypeRow.rowParser(1).singleOpt)
  }
  override def selectByIds(addresstypeids: Array[AddresstypeId])(implicit c: Connection): List[AddresstypeRow] = {
    SQL"""select "addresstypeid", "name", "rowguid", "modifieddate"::text
          from person.addresstype
          where "addresstypeid" = ANY(${addresstypeids})
       """.as(AddresstypeRow.rowParser(1).*)
    
  }
  override def update(row: AddresstypeRow)(implicit c: Connection): Boolean = {
    val addresstypeid = row.addresstypeid
    SQL"""update person.addresstype
          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "addresstypeid" = ${ParameterValue(addresstypeid, null, AddresstypeId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[AddresstypeFields, AddresstypeRow] = {
    UpdateBuilder("person.addresstype", AddresstypeFields, AddresstypeRow.rowParser)
  }
  override def upsert(unsaved: AddresstypeRow)(implicit c: Connection): AddresstypeRow = {
    SQL"""insert into person.addresstype("addresstypeid", "name", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.addresstypeid, null, AddresstypeId.toStatement)}::int4,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("addresstypeid")
          do update set
            "name" = EXCLUDED."name",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "addresstypeid", "name", "rowguid", "modifieddate"::text
       """
      .executeInsert(AddresstypeRow.rowParser(1).single)
    
  }
}
