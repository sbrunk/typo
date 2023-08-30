/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
import anorm.Column
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class SalesorderdetailRow(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Primary key. One incremental unique number per product sold. */
  salesorderdetailid: Int,
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
  /** Discount amount.
      Constraint CK_SalesOrderDetail_UnitPriceDiscount affecting columns "unitpricediscount":  ((unitpricediscount >= 0.00)) */
  unitpricediscount: BigDecimal,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalesorderdetailId = SalesorderdetailId(salesorderid, salesorderdetailid)
 }

object SalesorderdetailRow {
  implicit lazy val reads: Reads[SalesorderdetailRow] = Reads[SalesorderdetailRow](json => JsResult.fromTry(
      Try(
        SalesorderdetailRow(
          salesorderid = json.\("salesorderid").as(SalesorderheaderId.reads),
          salesorderdetailid = json.\("salesorderdetailid").as(Reads.IntReads),
          carriertrackingnumber = json.\("carriertrackingnumber").toOption.map(_.as(Reads.StringReads)),
          orderqty = json.\("orderqty").as(TypoShort.reads),
          productid = json.\("productid").as(ProductId.reads),
          specialofferid = json.\("specialofferid").as(SpecialofferId.reads),
          unitprice = json.\("unitprice").as(Reads.bigDecReads),
          unitpricediscount = json.\("unitpricediscount").as(Reads.bigDecReads),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SalesorderdetailRow] = RowParser[SalesorderdetailRow] { row =>
    Success(
      SalesorderdetailRow(
        salesorderid = row(idx + 0)(SalesorderheaderId.column),
        salesorderdetailid = row(idx + 1)(Column.columnToInt),
        carriertrackingnumber = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        orderqty = row(idx + 3)(TypoShort.column),
        productid = row(idx + 4)(ProductId.column),
        specialofferid = row(idx + 5)(SpecialofferId.column),
        unitprice = row(idx + 6)(Column.columnToScalaBigDecimal),
        unitpricediscount = row(idx + 7)(Column.columnToScalaBigDecimal),
        rowguid = row(idx + 8)(Column.columnToUUID),
        modifieddate = row(idx + 9)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[SalesorderdetailRow] = OWrites[SalesorderdetailRow](o =>
    new JsObject(ListMap[String, JsValue](
      "salesorderid" -> SalesorderheaderId.writes.writes(o.salesorderid),
      "salesorderdetailid" -> Writes.IntWrites.writes(o.salesorderdetailid),
      "carriertrackingnumber" -> Writes.OptionWrites(Writes.StringWrites).writes(o.carriertrackingnumber),
      "orderqty" -> TypoShort.writes.writes(o.orderqty),
      "productid" -> ProductId.writes.writes(o.productid),
      "specialofferid" -> SpecialofferId.writes.writes(o.specialofferid),
      "unitprice" -> Writes.BigDecimalWrites.writes(o.unitprice),
      "unitpricediscount" -> Writes.BigDecimalWrites.writes(o.unitpricediscount),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
