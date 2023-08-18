/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import adventureworks.TypoLocalDateTime
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

case class ProductdescriptionRow(
  /** Primary key for ProductDescription records. */
  productdescriptionid: ProductdescriptionId,
  /** Description of the product. */
  description: /* max 400 chars */ String,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object ProductdescriptionRow {
  implicit lazy val reads: Reads[ProductdescriptionRow] = Reads[ProductdescriptionRow](json => JsResult.fromTry(
      Try(
        ProductdescriptionRow(
          productdescriptionid = json.\("productdescriptionid").as(ProductdescriptionId.reads),
          description = json.\("description").as(Reads.StringReads),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductdescriptionRow] = RowParser[ProductdescriptionRow] { row =>
    Success(
      ProductdescriptionRow(
        productdescriptionid = row(idx + 0)(ProductdescriptionId.column),
        description = row(idx + 1)(Column.columnToString),
        rowguid = row(idx + 2)(Column.columnToUUID),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[ProductdescriptionRow] = OWrites[ProductdescriptionRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productdescriptionid" -> ProductdescriptionId.writes.writes(o.productdescriptionid),
      "description" -> Writes.StringWrites.writes(o.description),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
