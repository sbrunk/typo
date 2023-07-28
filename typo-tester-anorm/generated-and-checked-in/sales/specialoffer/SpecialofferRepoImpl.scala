/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.util.UUID

object SpecialofferRepoImpl extends SpecialofferRepo {
  override def delete(specialofferid: SpecialofferId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.specialoffer where specialofferid = $specialofferid".executeUpdate() > 0
  }
  override def insert(unsaved: SpecialofferRow)(implicit c: Connection): SpecialofferRow = {
    SQL"""insert into sales.specialoffer(specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate)
          values (${unsaved.specialofferid}::int4, ${unsaved.description}, ${unsaved.discountpct}::numeric, ${unsaved.`type`}, ${unsaved.category}, ${unsaved.startdate}::timestamp, ${unsaved.enddate}::timestamp, ${unsaved.minqty}::int4, ${unsaved.maxqty}::int4, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning specialofferid, description, discountpct, "type", category, startdate::text, enddate::text, minqty, maxqty, rowguid, modifieddate::text
       """
      .executeInsert(SpecialofferRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SpecialofferRowUnsaved)(implicit c: Connection): SpecialofferRow = {
    val namedParameters = List(
      Some((NamedParameter("description", ParameterValue.from(unsaved.description)), "")),
      Some((NamedParameter("type", ParameterValue.from(unsaved.`type`)), "")),
      Some((NamedParameter("category", ParameterValue.from(unsaved.category)), "")),
      Some((NamedParameter("startdate", ParameterValue.from(unsaved.startdate)), "::timestamp")),
      Some((NamedParameter("enddate", ParameterValue.from(unsaved.enddate)), "::timestamp")),
      Some((NamedParameter("maxqty", ParameterValue.from(unsaved.maxqty)), "::int4")),
      unsaved.specialofferid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("specialofferid", ParameterValue.from[SpecialofferId](value)), "::int4"))
      },
      unsaved.discountpct match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("discountpct", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.minqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("minqty", ParameterValue.from[Int](value)), "::int4"))
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
      SQL"""insert into sales.specialoffer default values
            returning specialofferid, description, discountpct, "type", category, startdate::text, enddate::text, minqty, maxqty, rowguid, modifieddate::text
         """
        .executeInsert(SpecialofferRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.specialoffer(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning specialofferid, description, discountpct, "type", category, startdate::text, enddate::text, minqty, maxqty, rowguid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(SpecialofferRow.rowParser(1).single)
    }
    
  }
  override def selectAll(implicit c: Connection): List[SpecialofferRow] = {
    SQL"""select specialofferid, description, discountpct, "type", category, startdate::text, enddate::text, minqty, maxqty, rowguid, modifieddate::text
          from sales.specialoffer
       """.as(SpecialofferRow.rowParser(1).*)
  }
  override def selectById(specialofferid: SpecialofferId)(implicit c: Connection): Option[SpecialofferRow] = {
    SQL"""select specialofferid, description, discountpct, "type", category, startdate::text, enddate::text, minqty, maxqty, rowguid, modifieddate::text
          from sales.specialoffer
          where specialofferid = $specialofferid
       """.as(SpecialofferRow.rowParser(1).singleOpt)
  }
  override def selectByIds(specialofferids: Array[SpecialofferId])(implicit c: Connection): List[SpecialofferRow] = {
    SQL"""select specialofferid, description, discountpct, "type", category, startdate::text, enddate::text, minqty, maxqty, rowguid, modifieddate::text
          from sales.specialoffer
          where specialofferid = ANY($specialofferids)
       """.as(SpecialofferRow.rowParser(1).*)
    
  }
  override def update(row: SpecialofferRow)(implicit c: Connection): Boolean = {
    val specialofferid = row.specialofferid
    SQL"""update sales.specialoffer
          set description = ${row.description},
              discountpct = ${row.discountpct}::numeric,
              "type" = ${row.`type`},
              category = ${row.category},
              startdate = ${row.startdate}::timestamp,
              enddate = ${row.enddate}::timestamp,
              minqty = ${row.minqty}::int4,
              maxqty = ${row.maxqty}::int4,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where specialofferid = $specialofferid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: SpecialofferRow)(implicit c: Connection): SpecialofferRow = {
    SQL"""insert into sales.specialoffer(specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate)
          values (
            ${unsaved.specialofferid}::int4,
            ${unsaved.description},
            ${unsaved.discountpct}::numeric,
            ${unsaved.`type`},
            ${unsaved.category},
            ${unsaved.startdate}::timestamp,
            ${unsaved.enddate}::timestamp,
            ${unsaved.minqty}::int4,
            ${unsaved.maxqty}::int4,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (specialofferid)
          do update set
            description = EXCLUDED.description,
            discountpct = EXCLUDED.discountpct,
            "type" = EXCLUDED."type",
            category = EXCLUDED.category,
            startdate = EXCLUDED.startdate,
            enddate = EXCLUDED.enddate,
            minqty = EXCLUDED.minqty,
            maxqty = EXCLUDED.maxqty,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning specialofferid, description, discountpct, "type", category, startdate::text, enddate::text, minqty, maxqty, rowguid, modifieddate::text
       """
      .executeInsert(SpecialofferRow.rowParser(1).single)
    
  }
}
