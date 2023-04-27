/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.Defaulted
import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `production.productinventory` which has not been persisted yet */
case class ProductinventoryRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Inventory location identification number. Foreign key to Location.LocationID.
      Points to [[location.LocationRow.locationid]] */
  locationid: LocationId,
  /** Storage compartment within an inventory location. */
  shelf: String,
  /** Storage container on a shelf in an inventory location. */
  bin: Int,
  /** Default: 0
      Quantity of products in the inventory location. */
  quantity: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(quantityDefault: => Int, rowguidDefault: => UUID, modifieddateDefault: => LocalDateTime): ProductinventoryRow =
    ProductinventoryRow(
      productid = productid,
      locationid = locationid,
      shelf = shelf,
      bin = bin,
      quantity = quantity match {
                   case Defaulted.UseDefault => quantityDefault
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
object ProductinventoryRowUnsaved {
  implicit val oFormat: OFormat[ProductinventoryRowUnsaved] = new OFormat[ProductinventoryRowUnsaved]{
    override def writes(o: ProductinventoryRowUnsaved): JsObject =
      Json.obj(
        "productid" -> o.productid,
        "locationid" -> o.locationid,
        "shelf" -> o.shelf,
        "bin" -> o.bin,
        "quantity" -> o.quantity,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductinventoryRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ProductinventoryRowUnsaved(
            productid = json.\("productid").as[ProductId],
            locationid = json.\("locationid").as[LocationId],
            shelf = json.\("shelf").as[String],
            bin = json.\("bin").as[Int],
            quantity = json.\("quantity").as[Defaulted[Int]],
            rowguid = json.\("rowguid").as[Defaulted[UUID]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
