/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderheader

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.purchasing.shipmethod.ShipmethodId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `purchasing.purchaseorderheader` which has not been persisted yet */
case class PurchaseorderheaderRowUnsaved(
  /** Employee who created the purchase order. Foreign key to Employee.BusinessEntityID.
      Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  employeeid: BusinessentityId,
  /** Vendor with whom the purchase order is placed. Foreign key to Vendor.BusinessEntityID.
      Points to [[vendor.VendorRow.businessentityid]] */
  vendorid: BusinessentityId,
  /** Shipping method. Foreign key to ShipMethod.ShipMethodID.
      Points to [[shipmethod.ShipmethodRow.shipmethodid]] */
  shipmethodid: ShipmethodId,
  /** Estimated shipment date from the vendor. */
  shipdate: Option[TypoLocalDateTime],
  /** Default: nextval('purchasing.purchaseorderheader_purchaseorderid_seq'::regclass)
      Primary key. */
  purchaseorderid: Defaulted[PurchaseorderheaderId] = Defaulted.UseDefault,
  /** Default: 0
      Incremental number to track changes to the purchase order over time. */
  revisionnumber: Defaulted[TypoShort] = Defaulted.UseDefault,
  /** Default: 1
      Order current status. 1 = Pending; 2 = Approved; 3 = Rejected; 4 = Complete */
  status: Defaulted[TypoShort] = Defaulted.UseDefault,
  /** Default: now()
      Purchase order creation date. */
  orderdate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: 0.00
      Purchase order subtotal. Computed as SUM(PurchaseOrderDetail.LineTotal)for the appropriate PurchaseOrderID. */
  subtotal: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Tax amount. */
  taxamt: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Shipping cost. */
  freight: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(purchaseorderidDefault: => PurchaseorderheaderId, revisionnumberDefault: => TypoShort, statusDefault: => TypoShort, orderdateDefault: => TypoLocalDateTime, subtotalDefault: => BigDecimal, taxamtDefault: => BigDecimal, freightDefault: => BigDecimal, modifieddateDefault: => TypoLocalDateTime): PurchaseorderheaderRow =
    PurchaseorderheaderRow(
      employeeid = employeeid,
      vendorid = vendorid,
      shipmethodid = shipmethodid,
      shipdate = shipdate,
      purchaseorderid = purchaseorderid match {
                          case Defaulted.UseDefault => purchaseorderidDefault
                          case Defaulted.Provided(value) => value
                        },
      revisionnumber = revisionnumber match {
                         case Defaulted.UseDefault => revisionnumberDefault
                         case Defaulted.Provided(value) => value
                       },
      status = status match {
                 case Defaulted.UseDefault => statusDefault
                 case Defaulted.Provided(value) => value
               },
      orderdate = orderdate match {
                    case Defaulted.UseDefault => orderdateDefault
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
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object PurchaseorderheaderRowUnsaved {
  implicit lazy val reads: Reads[PurchaseorderheaderRowUnsaved] = Reads[PurchaseorderheaderRowUnsaved](json => JsResult.fromTry(
      Try(
        PurchaseorderheaderRowUnsaved(
          employeeid = json.\("employeeid").as(BusinessentityId.reads),
          vendorid = json.\("vendorid").as(BusinessentityId.reads),
          shipmethodid = json.\("shipmethodid").as(ShipmethodId.reads),
          shipdate = json.\("shipdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          purchaseorderid = json.\("purchaseorderid").as(Defaulted.reads(PurchaseorderheaderId.reads)),
          revisionnumber = json.\("revisionnumber").as(Defaulted.reads(TypoShort.reads)),
          status = json.\("status").as(Defaulted.reads(TypoShort.reads)),
          orderdate = json.\("orderdate").as(Defaulted.reads(TypoLocalDateTime.reads)),
          subtotal = json.\("subtotal").as(Defaulted.reads(Reads.bigDecReads)),
          taxamt = json.\("taxamt").as(Defaulted.reads(Reads.bigDecReads)),
          freight = json.\("freight").as(Defaulted.reads(Reads.bigDecReads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[PurchaseorderheaderRowUnsaved] = OWrites[PurchaseorderheaderRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "employeeid" -> BusinessentityId.writes.writes(o.employeeid),
      "vendorid" -> BusinessentityId.writes.writes(o.vendorid),
      "shipmethodid" -> ShipmethodId.writes.writes(o.shipmethodid),
      "shipdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.shipdate),
      "purchaseorderid" -> Defaulted.writes(PurchaseorderheaderId.writes).writes(o.purchaseorderid),
      "revisionnumber" -> Defaulted.writes(TypoShort.writes).writes(o.revisionnumber),
      "status" -> Defaulted.writes(TypoShort.writes).writes(o.status),
      "orderdate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.orderdate),
      "subtotal" -> Defaulted.writes(Writes.BigDecimalWrites).writes(o.subtotal),
      "taxamt" -> Defaulted.writes(Writes.BigDecimalWrites).writes(o.taxamt),
      "freight" -> Defaulted.writes(Writes.BigDecimalWrites).writes(o.freight),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
