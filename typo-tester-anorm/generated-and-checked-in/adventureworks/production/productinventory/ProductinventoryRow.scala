/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class ProductinventoryRow(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Inventory location identification number. Foreign key to Location.LocationID.
      Points to [[location.LocationRow.locationid]] */
  locationid: LocationId,
  /** Storage compartment within an inventory location. */
  shelf: /* max 10 chars */ String,
  /** Storage container on a shelf in an inventory location.
      Constraint CK_ProductInventory_Bin affecting columns "bin":  (((bin >= 0) AND (bin <= 100))) */
  bin: TypoShort,
  /** Quantity of products in the inventory location. */
  quantity: TypoShort,
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductinventoryId = ProductinventoryId(productid, locationid)
 }

object ProductinventoryRow {
  implicit lazy val reads: Reads[ProductinventoryRow] = Reads[ProductinventoryRow](json => JsResult.fromTry(
      Try(
        ProductinventoryRow(
          productid = json.\("productid").as(ProductId.reads),
          locationid = json.\("locationid").as(LocationId.reads),
          shelf = json.\("shelf").as(Reads.StringReads),
          bin = json.\("bin").as(TypoShort.reads),
          quantity = json.\("quantity").as(TypoShort.reads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductinventoryRow] = RowParser[ProductinventoryRow] { row =>
    Success(
      ProductinventoryRow(
        productid = row(idx + 0)(ProductId.column),
        locationid = row(idx + 1)(LocationId.column),
        shelf = row(idx + 2)(Column.columnToString),
        bin = row(idx + 3)(TypoShort.column),
        quantity = row(idx + 4)(TypoShort.column),
        rowguid = row(idx + 5)(TypoUUID.column),
        modifieddate = row(idx + 6)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[ProductinventoryRow] = OWrites[ProductinventoryRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "locationid" -> LocationId.writes.writes(o.locationid),
      "shelf" -> Writes.StringWrites.writes(o.shelf),
      "bin" -> TypoShort.writes.writes(o.bin),
      "quantity" -> TypoShort.writes.writes(o.quantity),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
