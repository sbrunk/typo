/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressId
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.OrderNumber
import adventureworks.purchasing.shipmethod.ShipmethodId
import adventureworks.sales.currencyrate.CurrencyrateId
import adventureworks.sales.customer.CustomerId
import adventureworks.sales.salesterritory.SalesterritoryId
import adventureworks.userdefined.CustomCreditcardId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `sales.salesorderheader` which has not been persisted yet */
case class SalesorderheaderRowUnsaved(
  /** Date the order is due to the customer.
      Constraint CK_SalesOrderHeader_DueDate affecting columns "duedate", "orderdate":  ((duedate >= orderdate)) */
  duedate: TypoLocalDateTime,
  /** Date the order was shipped to the customer.
      Constraint CK_SalesOrderHeader_ShipDate affecting columns "orderdate", "shipdate":  (((shipdate >= orderdate) OR (shipdate IS NULL))) */
  shipdate: Option[TypoLocalDateTime],
  /** Customer purchase order number reference. */
  purchaseordernumber: Option[OrderNumber],
  /** Financial accounting number reference. */
  accountnumber: Option[AccountNumber],
  /** Customer identification number. Foreign key to Customer.BusinessEntityID.
      Points to [[customer.CustomerRow.customerid]] */
  customerid: CustomerId,
  /** Sales person who created the sales order. Foreign key to SalesPerson.BusinessEntityID.
      Points to [[salesperson.SalespersonRow.businessentityid]] */
  salespersonid: Option[BusinessentityId],
  /** Territory in which the sale was made. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Customer billing address. Foreign key to Address.AddressID.
      Points to [[person.address.AddressRow.addressid]] */
  billtoaddressid: AddressId,
  /** Customer shipping address. Foreign key to Address.AddressID.
      Points to [[person.address.AddressRow.addressid]] */
  shiptoaddressid: AddressId,
  /** Shipping method. Foreign key to ShipMethod.ShipMethodID.
      Points to [[purchasing.shipmethod.ShipmethodRow.shipmethodid]] */
  shipmethodid: ShipmethodId,
  /** Credit card identification number. Foreign key to CreditCard.CreditCardID.
      Points to [[creditcard.CreditcardRow.creditcardid]] */
  creditcardid: Option[/* user-picked */ CustomCreditcardId],
  /** Approval code provided by the credit card company. */
  creditcardapprovalcode: Option[/* max 15 chars */ String],
  /** Currency exchange rate used. Foreign key to CurrencyRate.CurrencyRateID.
      Points to [[currencyrate.CurrencyrateRow.currencyrateid]] */
  currencyrateid: Option[CurrencyrateId],
  /** Total due from customer. Computed as Subtotal + TaxAmt + Freight. */
  totaldue: Option[BigDecimal],
  /** Sales representative comments. */
  comment: Option[/* max 128 chars */ String],
  /** Default: nextval('sales.salesorderheader_salesorderid_seq'::regclass)
      Primary key. */
  salesorderid: Defaulted[SalesorderheaderId] = Defaulted.UseDefault,
  /** Default: 0
      Incremental number to track changes to the sales order over time. */
  revisionnumber: Defaulted[TypoShort] = Defaulted.UseDefault,
  /** Default: now()
      Dates the sales order was created.
      Constraint CK_SalesOrderHeader_DueDate affecting columns "duedate", "orderdate":  ((duedate >= orderdate))
      Constraint CK_SalesOrderHeader_ShipDate affecting columns "orderdate", "shipdate":  (((shipdate >= orderdate) OR (shipdate IS NULL))) */
  orderdate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: 1
      Order current status. 1 = In process; 2 = Approved; 3 = Backordered; 4 = Rejected; 5 = Shipped; 6 = Cancelled
      Constraint CK_SalesOrderHeader_Status affecting columns "status":  (((status >= 0) AND (status <= 8))) */
  status: Defaulted[TypoShort] = Defaulted.UseDefault,
  /** Default: true
      0 = Order placed by sales person. 1 = Order placed online by customer. */
  onlineorderflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: 0.00
      Sales subtotal. Computed as SUM(SalesOrderDetail.LineTotal)for the appropriate SalesOrderID.
      Constraint CK_SalesOrderHeader_SubTotal affecting columns "subtotal":  ((subtotal >= 0.00)) */
  subtotal: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Tax amount.
      Constraint CK_SalesOrderHeader_TaxAmt affecting columns "taxamt":  ((taxamt >= 0.00)) */
  taxamt: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Shipping cost.
      Constraint CK_SalesOrderHeader_Freight affecting columns "freight":  ((freight >= 0.00)) */
  freight: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(salesorderidDefault: => SalesorderheaderId, revisionnumberDefault: => TypoShort, orderdateDefault: => TypoLocalDateTime, statusDefault: => TypoShort, onlineorderflagDefault: => Flag, subtotalDefault: => BigDecimal, taxamtDefault: => BigDecimal, freightDefault: => BigDecimal, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): SalesorderheaderRow =
    SalesorderheaderRow(
      duedate = duedate,
      shipdate = shipdate,
      purchaseordernumber = purchaseordernumber,
      accountnumber = accountnumber,
      customerid = customerid,
      salespersonid = salespersonid,
      territoryid = territoryid,
      billtoaddressid = billtoaddressid,
      shiptoaddressid = shiptoaddressid,
      shipmethodid = shipmethodid,
      creditcardid = creditcardid,
      creditcardapprovalcode = creditcardapprovalcode,
      currencyrateid = currencyrateid,
      totaldue = totaldue,
      comment = comment,
      salesorderid = salesorderid match {
                       case Defaulted.UseDefault => salesorderidDefault
                       case Defaulted.Provided(value) => value
                     },
      revisionnumber = revisionnumber match {
                         case Defaulted.UseDefault => revisionnumberDefault
                         case Defaulted.Provided(value) => value
                       },
      orderdate = orderdate match {
                    case Defaulted.UseDefault => orderdateDefault
                    case Defaulted.Provided(value) => value
                  },
      status = status match {
                 case Defaulted.UseDefault => statusDefault
                 case Defaulted.Provided(value) => value
               },
      onlineorderflag = onlineorderflag match {
                          case Defaulted.UseDefault => onlineorderflagDefault
                          case Defaulted.Provided(value) => value
                        },
      subtotal = subtotal match {
                   case Defaulted.UseDefault => subtotalDefault
                   case Defaulted.Provided(value) => value
                 },
      taxamt = taxamt match {
                 case Defaulted.UseDefault => taxamtDefault
                 case Defaulted.Provided(value) => value
               },
      freight = freight match {
                  case Defaulted.UseDefault => freightDefault
                  case Defaulted.Provided(value) => value
                },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object SalesorderheaderRowUnsaved {
  implicit lazy val reads: Reads[SalesorderheaderRowUnsaved] = Reads[SalesorderheaderRowUnsaved](json => JsResult.fromTry(
      Try(
        SalesorderheaderRowUnsaved(
          duedate = json.\("duedate").as(TypoLocalDateTime.reads),
          shipdate = json.\("shipdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          purchaseordernumber = json.\("purchaseordernumber").toOption.map(_.as(OrderNumber.reads)),
          accountnumber = json.\("accountnumber").toOption.map(_.as(AccountNumber.reads)),
          customerid = json.\("customerid").as(CustomerId.reads),
          salespersonid = json.\("salespersonid").toOption.map(_.as(BusinessentityId.reads)),
          territoryid = json.\("territoryid").toOption.map(_.as(SalesterritoryId.reads)),
          billtoaddressid = json.\("billtoaddressid").as(AddressId.reads),
          shiptoaddressid = json.\("shiptoaddressid").as(AddressId.reads),
          shipmethodid = json.\("shipmethodid").as(ShipmethodId.reads),
          creditcardid = json.\("creditcardid").toOption.map(_.as(CustomCreditcardId.reads)),
          creditcardapprovalcode = json.\("creditcardapprovalcode").toOption.map(_.as(Reads.StringReads)),
          currencyrateid = json.\("currencyrateid").toOption.map(_.as(CurrencyrateId.reads)),
          totaldue = json.\("totaldue").toOption.map(_.as(Reads.bigDecReads)),
          comment = json.\("comment").toOption.map(_.as(Reads.StringReads)),
          salesorderid = json.\("salesorderid").as(Defaulted.reads(SalesorderheaderId.reads)),
          revisionnumber = json.\("revisionnumber").as(Defaulted.reads(TypoShort.reads)),
          orderdate = json.\("orderdate").as(Defaulted.reads(TypoLocalDateTime.reads)),
          status = json.\("status").as(Defaulted.reads(TypoShort.reads)),
          onlineorderflag = json.\("onlineorderflag").as(Defaulted.reads(Flag.reads)),
          subtotal = json.\("subtotal").as(Defaulted.reads(Reads.bigDecReads)),
          taxamt = json.\("taxamt").as(Defaulted.reads(Reads.bigDecReads)),
          freight = json.\("freight").as(Defaulted.reads(Reads.bigDecReads)),
          rowguid = json.\("rowguid").as(Defaulted.reads(TypoUUID.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[SalesorderheaderRowUnsaved] = OWrites[SalesorderheaderRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "duedate" -> TypoLocalDateTime.writes.writes(o.duedate),
      "shipdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.shipdate),
      "purchaseordernumber" -> Writes.OptionWrites(OrderNumber.writes).writes(o.purchaseordernumber),
      "accountnumber" -> Writes.OptionWrites(AccountNumber.writes).writes(o.accountnumber),
      "customerid" -> CustomerId.writes.writes(o.customerid),
      "salespersonid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.salespersonid),
      "territoryid" -> Writes.OptionWrites(SalesterritoryId.writes).writes(o.territoryid),
      "billtoaddressid" -> AddressId.writes.writes(o.billtoaddressid),
      "shiptoaddressid" -> AddressId.writes.writes(o.shiptoaddressid),
      "shipmethodid" -> ShipmethodId.writes.writes(o.shipmethodid),
      "creditcardid" -> Writes.OptionWrites(CustomCreditcardId.writes).writes(o.creditcardid),
      "creditcardapprovalcode" -> Writes.OptionWrites(Writes.StringWrites).writes(o.creditcardapprovalcode),
      "currencyrateid" -> Writes.OptionWrites(CurrencyrateId.writes).writes(o.currencyrateid),
      "totaldue" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.totaldue),
      "comment" -> Writes.OptionWrites(Writes.StringWrites).writes(o.comment),
      "salesorderid" -> Defaulted.writes(SalesorderheaderId.writes).writes(o.salesorderid),
      "revisionnumber" -> Defaulted.writes(TypoShort.writes).writes(o.revisionnumber),
      "orderdate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.orderdate),
      "status" -> Defaulted.writes(TypoShort.writes).writes(o.status),
      "onlineorderflag" -> Defaulted.writes(Flag.writes).writes(o.onlineorderflag),
      "subtotal" -> Defaulted.writes(Writes.BigDecimalWrites).writes(o.subtotal),
      "taxamt" -> Defaulted.writes(Writes.BigDecimalWrites).writes(o.taxamt),
      "freight" -> Defaulted.writes(Writes.BigDecimalWrites).writes(o.freight),
      "rowguid" -> Defaulted.writes(TypoUUID.writes).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
