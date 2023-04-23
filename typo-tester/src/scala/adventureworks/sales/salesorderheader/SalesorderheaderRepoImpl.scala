/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import adventureworks.Defaulted
import adventureworks.person.address.AddressId
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.OrderNumber
import adventureworks.purchasing.shipmethod.ShipmethodId
import adventureworks.sales.creditcard.CreditcardId
import adventureworks.sales.currencyrate.CurrencyrateId
import adventureworks.sales.customer.CustomerId
import adventureworks.sales.salesterritory.SalesterritoryId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime
import java.util.UUID

object SalesorderheaderRepoImpl extends SalesorderheaderRepo {
  override def delete(salesorderid: SalesorderheaderId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.salesorderheader where salesorderid = $salesorderid".executeUpdate() > 0
  }
  override def insert(unsaved: SalesorderheaderRowUnsaved)(implicit c: Connection): SalesorderheaderRow = {
    val namedParameters = List(
      unsaved.revisionnumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("revisionnumber", ParameterValue.from[Int](value)), "::int2"))
      },
      unsaved.orderdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("orderdate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      },
      Some((NamedParameter("duedate", ParameterValue.from(unsaved.duedate)), "::timestamp")),
      Some((NamedParameter("shipdate", ParameterValue.from(unsaved.shipdate)), "::timestamp")),
      unsaved.status match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("status", ParameterValue.from[Int](value)), "::int2"))
      },
      unsaved.onlineorderflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("onlineorderflag", ParameterValue.from[Flag](value)), """::"public"."Flag""""))
      },
      Some((NamedParameter("purchaseordernumber", ParameterValue.from(unsaved.purchaseordernumber)), """::"public".OrderNumber""")),
      Some((NamedParameter("accountnumber", ParameterValue.from(unsaved.accountnumber)), """::"public".AccountNumber""")),
      Some((NamedParameter("customerid", ParameterValue.from(unsaved.customerid)), "::int4")),
      Some((NamedParameter("salespersonid", ParameterValue.from(unsaved.salespersonid)), "::int4")),
      Some((NamedParameter("territoryid", ParameterValue.from(unsaved.territoryid)), "::int4")),
      Some((NamedParameter("billtoaddressid", ParameterValue.from(unsaved.billtoaddressid)), "::int4")),
      Some((NamedParameter("shiptoaddressid", ParameterValue.from(unsaved.shiptoaddressid)), "::int4")),
      Some((NamedParameter("shipmethodid", ParameterValue.from(unsaved.shipmethodid)), "::int4")),
      Some((NamedParameter("creditcardid", ParameterValue.from(unsaved.creditcardid)), "::int4")),
      Some((NamedParameter("creditcardapprovalcode", ParameterValue.from(unsaved.creditcardapprovalcode)), "")),
      Some((NamedParameter("currencyrateid", ParameterValue.from(unsaved.currencyrateid)), "::int4")),
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
      Some((NamedParameter("totaldue", ParameterValue.from(unsaved.totaldue)), "::numeric")),
      Some((NamedParameter("comment", ParameterValue.from(unsaved.comment)), "")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.salesorderheader default values
            returning salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into sales.salesorderheader(${namedParameters.map{case (x, _) => "\"" + x.name + "\""}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[SalesorderheaderRow] = {
    SQL"""select salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate
          from sales.salesorderheader
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[SalesorderheaderFieldOrIdValue[_]])(implicit c: Connection): List[SalesorderheaderRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SalesorderheaderFieldValue.salesorderid(value) => NamedParameter("salesorderid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.revisionnumber(value) => NamedParameter("revisionnumber", ParameterValue.from(value))
          case SalesorderheaderFieldValue.orderdate(value) => NamedParameter("orderdate", ParameterValue.from(value))
          case SalesorderheaderFieldValue.duedate(value) => NamedParameter("duedate", ParameterValue.from(value))
          case SalesorderheaderFieldValue.shipdate(value) => NamedParameter("shipdate", ParameterValue.from(value))
          case SalesorderheaderFieldValue.status(value) => NamedParameter("status", ParameterValue.from(value))
          case SalesorderheaderFieldValue.onlineorderflag(value) => NamedParameter("onlineorderflag", ParameterValue.from(value))
          case SalesorderheaderFieldValue.purchaseordernumber(value) => NamedParameter("purchaseordernumber", ParameterValue.from(value))
          case SalesorderheaderFieldValue.accountnumber(value) => NamedParameter("accountnumber", ParameterValue.from(value))
          case SalesorderheaderFieldValue.customerid(value) => NamedParameter("customerid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.salespersonid(value) => NamedParameter("salespersonid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.territoryid(value) => NamedParameter("territoryid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.billtoaddressid(value) => NamedParameter("billtoaddressid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.shiptoaddressid(value) => NamedParameter("shiptoaddressid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.shipmethodid(value) => NamedParameter("shipmethodid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.creditcardid(value) => NamedParameter("creditcardid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.creditcardapprovalcode(value) => NamedParameter("creditcardapprovalcode", ParameterValue.from(value))
          case SalesorderheaderFieldValue.currencyrateid(value) => NamedParameter("currencyrateid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.subtotal(value) => NamedParameter("subtotal", ParameterValue.from(value))
          case SalesorderheaderFieldValue.taxamt(value) => NamedParameter("taxamt", ParameterValue.from(value))
          case SalesorderheaderFieldValue.freight(value) => NamedParameter("freight", ParameterValue.from(value))
          case SalesorderheaderFieldValue.totaldue(value) => NamedParameter("totaldue", ParameterValue.from(value))
          case SalesorderheaderFieldValue.comment(value) => NamedParameter("comment", ParameterValue.from(value))
          case SalesorderheaderFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate
                    from sales.salesorderheader
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(salesorderid: SalesorderheaderId)(implicit c: Connection): Option[SalesorderheaderRow] = {
    SQL"""select salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate
          from sales.salesorderheader
          where salesorderid = $salesorderid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(salesorderids: Array[SalesorderheaderId])(implicit c: Connection): List[SalesorderheaderRow] = {
    implicit val toStatement: ToStatement[Array[SalesorderheaderId]] =
      (s: PreparedStatement, index: Int, v: Array[SalesorderheaderId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate
          from sales.salesorderheader
          where salesorderid = ANY($salesorderids)
       """.as(rowParser.*)
  
  }
  override def update(row: SalesorderheaderRow)(implicit c: Connection): Boolean = {
    val salesorderid = row.salesorderid
    SQL"""update sales.salesorderheader
          set revisionnumber = ${row.revisionnumber},
              orderdate = ${row.orderdate},
              duedate = ${row.duedate},
              shipdate = ${row.shipdate},
              status = ${row.status},
              onlineorderflag = ${row.onlineorderflag},
              purchaseordernumber = ${row.purchaseordernumber},
              accountnumber = ${row.accountnumber},
              customerid = ${row.customerid},
              salespersonid = ${row.salespersonid},
              territoryid = ${row.territoryid},
              billtoaddressid = ${row.billtoaddressid},
              shiptoaddressid = ${row.shiptoaddressid},
              shipmethodid = ${row.shipmethodid},
              creditcardid = ${row.creditcardid},
              creditcardapprovalcode = ${row.creditcardapprovalcode},
              currencyrateid = ${row.currencyrateid},
              subtotal = ${row.subtotal},
              taxamt = ${row.taxamt},
              freight = ${row.freight},
              totaldue = ${row.totaldue},
              "comment" = ${row.comment},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where salesorderid = $salesorderid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(salesorderid: SalesorderheaderId, fieldValues: List[SalesorderheaderFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SalesorderheaderFieldValue.revisionnumber(value) => NamedParameter("revisionnumber", ParameterValue.from(value))
          case SalesorderheaderFieldValue.orderdate(value) => NamedParameter("orderdate", ParameterValue.from(value))
          case SalesorderheaderFieldValue.duedate(value) => NamedParameter("duedate", ParameterValue.from(value))
          case SalesorderheaderFieldValue.shipdate(value) => NamedParameter("shipdate", ParameterValue.from(value))
          case SalesorderheaderFieldValue.status(value) => NamedParameter("status", ParameterValue.from(value))
          case SalesorderheaderFieldValue.onlineorderflag(value) => NamedParameter("onlineorderflag", ParameterValue.from(value))
          case SalesorderheaderFieldValue.purchaseordernumber(value) => NamedParameter("purchaseordernumber", ParameterValue.from(value))
          case SalesorderheaderFieldValue.accountnumber(value) => NamedParameter("accountnumber", ParameterValue.from(value))
          case SalesorderheaderFieldValue.customerid(value) => NamedParameter("customerid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.salespersonid(value) => NamedParameter("salespersonid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.territoryid(value) => NamedParameter("territoryid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.billtoaddressid(value) => NamedParameter("billtoaddressid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.shiptoaddressid(value) => NamedParameter("shiptoaddressid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.shipmethodid(value) => NamedParameter("shipmethodid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.creditcardid(value) => NamedParameter("creditcardid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.creditcardapprovalcode(value) => NamedParameter("creditcardapprovalcode", ParameterValue.from(value))
          case SalesorderheaderFieldValue.currencyrateid(value) => NamedParameter("currencyrateid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.subtotal(value) => NamedParameter("subtotal", ParameterValue.from(value))
          case SalesorderheaderFieldValue.taxamt(value) => NamedParameter("taxamt", ParameterValue.from(value))
          case SalesorderheaderFieldValue.freight(value) => NamedParameter("freight", ParameterValue.from(value))
          case SalesorderheaderFieldValue.totaldue(value) => NamedParameter("totaldue", ParameterValue.from(value))
          case SalesorderheaderFieldValue.comment(value) => NamedParameter("comment", ParameterValue.from(value))
          case SalesorderheaderFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SalesorderheaderFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update sales.salesorderheader
                    set ${namedParams.map(x => s"\"${x.name}\" = {${x.name}}").mkString(", ")}
                    where salesorderid = {salesorderid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("salesorderid", ParameterValue.from(salesorderid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[SalesorderheaderRow] =
    RowParser[SalesorderheaderRow] { row =>
      Success(
        SalesorderheaderRow(
          salesorderid = row[SalesorderheaderId]("salesorderid"),
          revisionnumber = row[Int]("revisionnumber"),
          orderdate = row[LocalDateTime]("orderdate"),
          duedate = row[LocalDateTime]("duedate"),
          shipdate = row[Option[LocalDateTime]]("shipdate"),
          status = row[Int]("status"),
          onlineorderflag = row[Flag]("onlineorderflag"),
          purchaseordernumber = row[Option[OrderNumber]]("purchaseordernumber"),
          accountnumber = row[Option[AccountNumber]]("accountnumber"),
          customerid = row[CustomerId]("customerid"),
          salespersonid = row[Option[BusinessentityId]]("salespersonid"),
          territoryid = row[Option[SalesterritoryId]]("territoryid"),
          billtoaddressid = row[AddressId]("billtoaddressid"),
          shiptoaddressid = row[AddressId]("shiptoaddressid"),
          shipmethodid = row[ShipmethodId]("shipmethodid"),
          creditcardid = row[Option[CreditcardId]]("creditcardid"),
          creditcardapprovalcode = row[Option[String]]("creditcardapprovalcode"),
          currencyrateid = row[Option[CurrencyrateId]]("currencyrateid"),
          subtotal = row[BigDecimal]("subtotal"),
          taxamt = row[BigDecimal]("taxamt"),
          freight = row[BigDecimal]("freight"),
          totaldue = row[Option[BigDecimal]]("totaldue"),
          comment = row[Option[String]]("comment"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
