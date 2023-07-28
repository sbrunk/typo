/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.util.UUID

object SalesterritoryRepoImpl extends SalesterritoryRepo {
  override def delete(territoryid: SalesterritoryId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.salesterritory where territoryid = $territoryid".executeUpdate() > 0
  }
  override def insert(unsaved: SalesterritoryRow)(implicit c: Connection): SalesterritoryRow = {
    SQL"""insert into sales.salesterritory(territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate)
          values (${unsaved.territoryid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.countryregioncode}, ${unsaved.group}, ${unsaved.salesytd}::numeric, ${unsaved.saleslastyear}::numeric, ${unsaved.costytd}::numeric, ${unsaved.costlastyear}::numeric, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate::text
       """
      .executeInsert(SalesterritoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SalesterritoryRowUnsaved)(implicit c: Connection): SalesterritoryRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      Some((NamedParameter("countryregioncode", ParameterValue.from(unsaved.countryregioncode)), "")),
      Some((NamedParameter("group", ParameterValue.from(unsaved.group)), "")),
      unsaved.territoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("territoryid", ParameterValue.from[SalesterritoryId](value)), "::int4"))
      },
      unsaved.salesytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("salesytd", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.saleslastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("saleslastyear", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.costytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("costytd", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.costlastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("costlastyear", ParameterValue.from[BigDecimal](value)), "::numeric"))
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
      SQL"""insert into sales.salesterritory default values
            returning territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate::text
         """
        .executeInsert(SalesterritoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salesterritory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(SalesterritoryRow.rowParser(1).single)
    }
    
  }
  override def selectAll(implicit c: Connection): List[SalesterritoryRow] = {
    SQL"""select territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate::text
          from sales.salesterritory
       """.as(SalesterritoryRow.rowParser(1).*)
  }
  override def selectById(territoryid: SalesterritoryId)(implicit c: Connection): Option[SalesterritoryRow] = {
    SQL"""select territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate::text
          from sales.salesterritory
          where territoryid = $territoryid
       """.as(SalesterritoryRow.rowParser(1).singleOpt)
  }
  override def selectByIds(territoryids: Array[SalesterritoryId])(implicit c: Connection): List[SalesterritoryRow] = {
    SQL"""select territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate::text
          from sales.salesterritory
          where territoryid = ANY($territoryids)
       """.as(SalesterritoryRow.rowParser(1).*)
    
  }
  override def update(row: SalesterritoryRow)(implicit c: Connection): Boolean = {
    val territoryid = row.territoryid
    SQL"""update sales.salesterritory
          set "name" = ${row.name}::"public"."Name",
              countryregioncode = ${row.countryregioncode},
              "group" = ${row.group},
              salesytd = ${row.salesytd}::numeric,
              saleslastyear = ${row.saleslastyear}::numeric,
              costytd = ${row.costytd}::numeric,
              costlastyear = ${row.costlastyear}::numeric,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where territoryid = $territoryid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: SalesterritoryRow)(implicit c: Connection): SalesterritoryRow = {
    SQL"""insert into sales.salesterritory(territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate)
          values (
            ${unsaved.territoryid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.countryregioncode},
            ${unsaved.group},
            ${unsaved.salesytd}::numeric,
            ${unsaved.saleslastyear}::numeric,
            ${unsaved.costytd}::numeric,
            ${unsaved.costlastyear}::numeric,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (territoryid)
          do update set
            "name" = EXCLUDED."name",
            countryregioncode = EXCLUDED.countryregioncode,
            "group" = EXCLUDED."group",
            salesytd = EXCLUDED.salesytd,
            saleslastyear = EXCLUDED.saleslastyear,
            costytd = EXCLUDED.costytd,
            costlastyear = EXCLUDED.costlastyear,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate::text
       """
      .executeInsert(SalesterritoryRow.rowParser(1).single)
    
  }
}
