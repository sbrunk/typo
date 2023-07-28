/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class BillofmaterialsRow(
  /** Primary key for BillOfMaterials records. */
  billofmaterialsid: BillofmaterialsId,
  /** Parent product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productassemblyid: Option[ProductId],
  /** Component identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  componentid: ProductId,
  /** Date the component started being used in the assembly item. */
  startdate: LocalDateTime,
  /** Date the component stopped being used in the assembly item. */
  enddate: Option[LocalDateTime],
  /** Standard code identifying the unit of measure for the quantity.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Indicates the depth the component is from its parent (AssemblyID). */
  bomlevel: Int,
  /** Quantity of the component needed to create the assembly. */
  perassemblyqty: BigDecimal,
  modifieddate: LocalDateTime
)

object BillofmaterialsRow {
  def rowParser(idx: Int): RowParser[BillofmaterialsRow] =
    RowParser[BillofmaterialsRow] { row =>
      Success(
        BillofmaterialsRow(
          billofmaterialsid = row[BillofmaterialsId](idx + 0),
          productassemblyid = row[Option[ProductId]](idx + 1),
          componentid = row[ProductId](idx + 2),
          startdate = row[LocalDateTime](idx + 3),
          enddate = row[Option[LocalDateTime]](idx + 4),
          unitmeasurecode = row[UnitmeasureId](idx + 5),
          bomlevel = row[Int](idx + 6),
          perassemblyqty = row[BigDecimal](idx + 7),
          modifieddate = row[LocalDateTime](idx + 8)
        )
      )
    }
  implicit val oFormat: OFormat[BillofmaterialsRow] = new OFormat[BillofmaterialsRow]{
    override def writes(o: BillofmaterialsRow): JsObject =
      Json.obj(
        "billofmaterialsid" -> o.billofmaterialsid,
        "productassemblyid" -> o.productassemblyid,
        "componentid" -> o.componentid,
        "startdate" -> o.startdate,
        "enddate" -> o.enddate,
        "unitmeasurecode" -> o.unitmeasurecode,
        "bomlevel" -> o.bomlevel,
        "perassemblyqty" -> o.perassemblyqty,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[BillofmaterialsRow] = {
      JsResult.fromTry(
        Try(
          BillofmaterialsRow(
            billofmaterialsid = json.\("billofmaterialsid").as[BillofmaterialsId],
            productassemblyid = json.\("productassemblyid").toOption.map(_.as[ProductId]),
            componentid = json.\("componentid").as[ProductId],
            startdate = json.\("startdate").as[LocalDateTime],
            enddate = json.\("enddate").toOption.map(_.as[LocalDateTime]),
            unitmeasurecode = json.\("unitmeasurecode").as[UnitmeasureId],
            bomlevel = json.\("bomlevel").as[Int],
            perassemblyqty = json.\("perassemblyqty").as[BigDecimal],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
