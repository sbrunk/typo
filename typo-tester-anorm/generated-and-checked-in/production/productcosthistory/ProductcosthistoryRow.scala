/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

import adventureworks.production.product.ProductId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ProductcosthistoryRow(
  /** Product identification number. Foreign key to Product.ProductID
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Product cost start date. */
  startdate: LocalDateTime,
  /** Product cost end date. */
  enddate: Option[LocalDateTime],
  /** Standard cost of the product. */
  standardcost: BigDecimal,
  modifieddate: LocalDateTime
){
   val compositeId: ProductcosthistoryId = ProductcosthistoryId(productid, startdate)
 }

object ProductcosthistoryRow {
  def rowParser(idx: Int): RowParser[ProductcosthistoryRow] =
    RowParser[ProductcosthistoryRow] { row =>
      Success(
        ProductcosthistoryRow(
          productid = row[ProductId](idx + 0),
          startdate = row[LocalDateTime](idx + 1),
          enddate = row[Option[LocalDateTime]](idx + 2),
          standardcost = row[BigDecimal](idx + 3),
          modifieddate = row[LocalDateTime](idx + 4)
        )
      )
    }
  implicit val oFormat: OFormat[ProductcosthistoryRow] = new OFormat[ProductcosthistoryRow]{
    override def writes(o: ProductcosthistoryRow): JsObject =
      Json.obj(
        "productid" -> o.productid,
        "startdate" -> o.startdate,
        "enddate" -> o.enddate,
        "standardcost" -> o.standardcost,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductcosthistoryRow] = {
      JsResult.fromTry(
        Try(
          ProductcosthistoryRow(
            productid = json.\("productid").as[ProductId],
            startdate = json.\("startdate").as[LocalDateTime],
            enddate = json.\("enddate").toOption.map(_.as[LocalDateTime]),
            standardcost = json.\("standardcost").as[BigDecimal],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
