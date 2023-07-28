/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Flag
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.util.UUID

object StateprovinceRepoImpl extends StateprovinceRepo {
  override def delete(stateprovinceid: StateprovinceId)(implicit c: Connection): Boolean = {
    SQL"delete from person.stateprovince where stateprovinceid = $stateprovinceid".executeUpdate() > 0
  }
  override def insert(unsaved: StateprovinceRow)(implicit c: Connection): StateprovinceRow = {
    SQL"""insert into person.stateprovince(stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, "name", territoryid, rowguid, modifieddate)
          values (${unsaved.stateprovinceid}::int4, ${unsaved.stateprovincecode}::bpchar, ${unsaved.countryregioncode}, ${unsaved.isonlystateprovinceflag}::"public"."Flag", ${unsaved.name}::"public"."Name", ${unsaved.territoryid}::int4, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, "name", territoryid, rowguid, modifieddate::text
       """
      .executeInsert(StateprovinceRow.rowParser(1).single)
    
  }
  override def insert(unsaved: StateprovinceRowUnsaved)(implicit c: Connection): StateprovinceRow = {
    val namedParameters = List(
      Some((NamedParameter("stateprovincecode", ParameterValue.from(unsaved.stateprovincecode)), "::bpchar")),
      Some((NamedParameter("countryregioncode", ParameterValue.from(unsaved.countryregioncode)), "")),
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      Some((NamedParameter("territoryid", ParameterValue.from(unsaved.territoryid)), "::int4")),
      unsaved.stateprovinceid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("stateprovinceid", ParameterValue.from[StateprovinceId](value)), "::int4"))
      },
      unsaved.isonlystateprovinceflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("isonlystateprovinceflag", ParameterValue.from[Flag](value)), """::"public"."Flag""""))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into person.stateprovince default values
            returning stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, "name", territoryid, rowguid, modifieddate::text
         """
        .executeInsert(StateprovinceRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.stateprovince(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, "name", territoryid, rowguid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(StateprovinceRow.rowParser(1).single)
    }
    
  }
  override def selectAll(implicit c: Connection): List[StateprovinceRow] = {
    SQL"""select stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, "name", territoryid, rowguid, modifieddate::text
          from person.stateprovince
       """.as(StateprovinceRow.rowParser(1).*)
  }
  override def selectById(stateprovinceid: StateprovinceId)(implicit c: Connection): Option[StateprovinceRow] = {
    SQL"""select stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, "name", territoryid, rowguid, modifieddate::text
          from person.stateprovince
          where stateprovinceid = $stateprovinceid
       """.as(StateprovinceRow.rowParser(1).singleOpt)
  }
  override def selectByIds(stateprovinceids: Array[StateprovinceId])(implicit c: Connection): List[StateprovinceRow] = {
    SQL"""select stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, "name", territoryid, rowguid, modifieddate::text
          from person.stateprovince
          where stateprovinceid = ANY($stateprovinceids)
       """.as(StateprovinceRow.rowParser(1).*)
    
  }
  override def update(row: StateprovinceRow)(implicit c: Connection): Boolean = {
    val stateprovinceid = row.stateprovinceid
    SQL"""update person.stateprovince
          set stateprovincecode = ${row.stateprovincecode}::bpchar,
              countryregioncode = ${row.countryregioncode},
              isonlystateprovinceflag = ${row.isonlystateprovinceflag}::"public"."Flag",
              "name" = ${row.name}::"public"."Name",
              territoryid = ${row.territoryid}::int4,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where stateprovinceid = $stateprovinceid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: StateprovinceRow)(implicit c: Connection): StateprovinceRow = {
    SQL"""insert into person.stateprovince(stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, "name", territoryid, rowguid, modifieddate)
          values (
            ${unsaved.stateprovinceid}::int4,
            ${unsaved.stateprovincecode}::bpchar,
            ${unsaved.countryregioncode},
            ${unsaved.isonlystateprovinceflag}::"public"."Flag",
            ${unsaved.name}::"public"."Name",
            ${unsaved.territoryid}::int4,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (stateprovinceid)
          do update set
            stateprovincecode = EXCLUDED.stateprovincecode,
            countryregioncode = EXCLUDED.countryregioncode,
            isonlystateprovinceflag = EXCLUDED.isonlystateprovinceflag,
            "name" = EXCLUDED."name",
            territoryid = EXCLUDED.territoryid,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, "name", territoryid, rowguid, modifieddate::text
       """
      .executeInsert(StateprovinceRow.rowParser(1).single)
    
  }
}
