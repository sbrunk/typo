/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `sales.salesorderdetail` which has not been persisted yet */
case class SalesorderdetailRowUnsaved(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Shipment tracking number supplied by the shipper. */
  carriertrackingnumber: Option[/* max 25 chars */ String],
  /** Quantity ordered per product.
      Constraint CK_SalesOrderDetail_OrderQty affecting columns "orderqty":  ((orderqty > 0)) */
  orderqty: TypoShort,
  /** Product sold to customer. Foreign key to Product.ProductID.
      Points to [[specialofferproduct.SpecialofferproductRow.productid]] */
  productid: ProductId,
  /** Promotional code. Foreign key to SpecialOffer.SpecialOfferID.
      Points to [[specialofferproduct.SpecialofferproductRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Selling price of a single product.
      Constraint CK_SalesOrderDetail_UnitPrice affecting columns "unitprice":  ((unitprice >= 0.00)) */
  unitprice: BigDecimal,
  /** Default: nextval('sales.salesorderdetail_salesorderdetailid_seq'::regclass)
      Primary key. One incremental unique number per product sold. */
  salesorderdetailid: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: 0.0
      Discount amount.
      Constraint CK_SalesOrderDetail_UnitPriceDiscount affecting columns "unitpricediscount":  ((unitpricediscount >= 0.00)) */
  unitpricediscount: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(salesorderdetailidDefault: => Int, unitpricediscountDefault: => BigDecimal, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): SalesorderdetailRow =
    SalesorderdetailRow(
      salesorderid = salesorderid,
      carriertrackingnumber = carriertrackingnumber,
      orderqty = orderqty,
      productid = productid,
      specialofferid = specialofferid,
      unitprice = unitprice,
      salesorderdetailid = salesorderdetailid match {
                             case Defaulted.UseDefault => salesorderdetailidDefault
                             case Defaulted.Provided(value) => value
                           },
      unitpricediscount = unitpricediscount match {
                            case Defaulted.UseDefault => unitpricediscountDefault
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
object SalesorderdetailRowUnsaved {
  implicit lazy val reads: Reads[SalesorderdetailRowUnsaved] = Reads[SalesorderdetailRowUnsaved](json => JsResult.fromTry(
      Try(
        SalesorderdetailRowUnsaved(
          salesorderid = json.\("salesorderid").as(SalesorderheaderId.reads),
          carriertrackingnumber = json.\("carriertrackingnumber").toOption.map(_.as(Reads.StringReads)),
          orderqty = json.\("orderqty").as(TypoShort.reads),
          productid = json.\("productid").as(ProductId.reads),
          specialofferid = json.\("specialofferid").as(SpecialofferId.reads),
          unitprice = json.\("unitprice").as(Reads.bigDecReads),
          salesorderdetailid = json.\("salesorderdetailid").as(Defaulted.reads(Reads.IntReads)),
          unitpricediscount = json.\("unitpricediscount").as(Defaulted.reads(Reads.bigDecReads)),
          rowguid = json.\("rowguid").as(Defaulted.reads(TypoUUID.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[SalesorderdetailRowUnsaved] = OWrites[SalesorderdetailRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "salesorderid" -> SalesorderheaderId.writes.writes(o.salesorderid),
      "carriertrackingnumber" -> Writes.OptionWrites(Writes.StringWrites).writes(o.carriertrackingnumber),
      "orderqty" -> TypoShort.writes.writes(o.orderqty),
      "productid" -> ProductId.writes.writes(o.productid),
      "specialofferid" -> SpecialofferId.writes.writes(o.specialofferid),
      "unitprice" -> Writes.BigDecimalWrites.writes(o.unitprice),
      "salesorderdetailid" -> Defaulted.writes(Writes.IntWrites).writes(o.salesorderdetailid),
      "unitpricediscount" -> Defaulted.writes(Writes.BigDecimalWrites).writes(o.unitpricediscount),
      "rowguid" -> Defaulted.writes(TypoUUID.writes).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
