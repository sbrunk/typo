/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderheader

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PurchaseorderheaderRepoImpl extends PurchaseorderheaderRepo {
  override def delete(purchaseorderid: PurchaseorderheaderId)(implicit c: Connection): Boolean = {
    SQL"delete from purchasing.purchaseorderheader where purchaseorderid = $purchaseorderid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    DeleteBuilder("purchasing.purchaseorderheader", PurchaseorderheaderFields)
  }
  override def insert(unsaved: PurchaseorderheaderRow)(implicit c: Connection): PurchaseorderheaderRow = {
    SQL"""insert into purchasing.purchaseorderheader(purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate, shipdate, subtotal, taxamt, freight, modifieddate)
          values (${unsaved.purchaseorderid}::int4, ${unsaved.revisionnumber}::int2, ${unsaved.status}::int2, ${unsaved.employeeid}::int4, ${unsaved.vendorid}::int4, ${unsaved.shipmethodid}::int4, ${unsaved.orderdate}::timestamp, ${unsaved.shipdate}::timestamp, ${unsaved.subtotal}::numeric, ${unsaved.taxamt}::numeric, ${unsaved.freight}::numeric, ${unsaved.modifieddate}::timestamp)
          returning purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate::text, shipdate::text, subtotal, taxamt, freight, modifieddate::text
       """
      .executeInsert(PurchaseorderheaderRow.rowParser(1).single)
    
  }
  override def insert(unsaved: PurchaseorderheaderRowUnsaved)(implicit c: Connection): PurchaseorderheaderRow = {
    val namedParameters = List(
      Some((NamedParameter("employeeid", ParameterValue.from(unsaved.employeeid)), "::int4")),
      Some((NamedParameter("vendorid", ParameterValue.from(unsaved.vendorid)), "::int4")),
      Some((NamedParameter("shipmethodid", ParameterValue.from(unsaved.shipmethodid)), "::int4")),
      Some((NamedParameter("shipdate", ParameterValue.from(unsaved.shipdate)), "::timestamp")),
      unsaved.purchaseorderid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("purchaseorderid", ParameterValue.from[PurchaseorderheaderId](value)), "::int4"))
      },
      unsaved.revisionnumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("revisionnumber", ParameterValue.from[Int](value)), "::int2"))
      },
      unsaved.status match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("status", ParameterValue.from[Int](value)), "::int2"))
      },
      unsaved.orderdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("orderdate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      },
      unsaved.subtotal match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("subtotal", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.taxamt match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("taxamt", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.freight match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("freight", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into purchasing.purchaseorderheader default values
            returning purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate::text, shipdate::text, subtotal, taxamt, freight, modifieddate::text
         """
        .executeInsert(PurchaseorderheaderRow.rowParser(1).single)
    } else {
      val q = s"""insert into purchasing.purchaseorderheader(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate::text, shipdate::text, subtotal, taxamt, freight, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser(Success(_)))
        .executeInsert(PurchaseorderheaderRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    SelectBuilderSql("purchasing.purchaseorderheader", PurchaseorderheaderFields, PurchaseorderheaderRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PurchaseorderheaderRow] = {
    SQL"""select purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate::text, shipdate::text, subtotal, taxamt, freight, modifieddate::text
          from purchasing.purchaseorderheader
       """.as(PurchaseorderheaderRow.rowParser(1).*)
  }
  override def selectById(purchaseorderid: PurchaseorderheaderId)(implicit c: Connection): Option[PurchaseorderheaderRow] = {
    SQL"""select purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate::text, shipdate::text, subtotal, taxamt, freight, modifieddate::text
          from purchasing.purchaseorderheader
          where purchaseorderid = $purchaseorderid
       """.as(PurchaseorderheaderRow.rowParser(1).singleOpt)
  }
  override def selectByIds(purchaseorderids: Array[PurchaseorderheaderId])(implicit c: Connection): List[PurchaseorderheaderRow] = {
    SQL"""select purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate::text, shipdate::text, subtotal, taxamt, freight, modifieddate::text
          from purchasing.purchaseorderheader
          where purchaseorderid = ANY($purchaseorderids)
       """.as(PurchaseorderheaderRow.rowParser(1).*)
    
  }
  override def update(row: PurchaseorderheaderRow)(implicit c: Connection): Boolean = {
    val purchaseorderid = row.purchaseorderid
    SQL"""update purchasing.purchaseorderheader
          set revisionnumber = ${row.revisionnumber}::int2,
              status = ${row.status}::int2,
              employeeid = ${row.employeeid}::int4,
              vendorid = ${row.vendorid}::int4,
              shipmethodid = ${row.shipmethodid}::int4,
              orderdate = ${row.orderdate}::timestamp,
              shipdate = ${row.shipdate}::timestamp,
              subtotal = ${row.subtotal}::numeric,
              taxamt = ${row.taxamt}::numeric,
              freight = ${row.freight}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where purchaseorderid = $purchaseorderid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    UpdateBuilder("purchasing.purchaseorderheader", PurchaseorderheaderFields, PurchaseorderheaderRow.rowParser)
  }
  override def upsert(unsaved: PurchaseorderheaderRow)(implicit c: Connection): PurchaseorderheaderRow = {
    SQL"""insert into purchasing.purchaseorderheader(purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate, shipdate, subtotal, taxamt, freight, modifieddate)
          values (
            ${unsaved.purchaseorderid}::int4,
            ${unsaved.revisionnumber}::int2,
            ${unsaved.status}::int2,
            ${unsaved.employeeid}::int4,
            ${unsaved.vendorid}::int4,
            ${unsaved.shipmethodid}::int4,
            ${unsaved.orderdate}::timestamp,
            ${unsaved.shipdate}::timestamp,
            ${unsaved.subtotal}::numeric,
            ${unsaved.taxamt}::numeric,
            ${unsaved.freight}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (purchaseorderid)
          do update set
            revisionnumber = EXCLUDED.revisionnumber,
            status = EXCLUDED.status,
            employeeid = EXCLUDED.employeeid,
            vendorid = EXCLUDED.vendorid,
            shipmethodid = EXCLUDED.shipmethodid,
            orderdate = EXCLUDED.orderdate,
            shipdate = EXCLUDED.shipdate,
            subtotal = EXCLUDED.subtotal,
            taxamt = EXCLUDED.taxamt,
            freight = EXCLUDED.freight,
            modifieddate = EXCLUDED.modifieddate
          returning purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate::text, shipdate::text, subtotal, taxamt, freight, modifieddate::text
       """
      .executeInsert(PurchaseorderheaderRow.rowParser(1).single)
    
  }
}
