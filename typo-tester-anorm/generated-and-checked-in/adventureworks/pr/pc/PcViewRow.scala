/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pc

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class PcViewRow(
  /** Points to [[production.productcategory.ProductcategoryRow.productcategoryid]] */
  id: ProductcategoryId,
  /** Points to [[production.productcategory.ProductcategoryRow.productcategoryid]] */
  productcategoryid: ProductcategoryId,
  /** Points to [[production.productcategory.ProductcategoryRow.name]] */
  name: Name,
  /** Points to [[production.productcategory.ProductcategoryRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[production.productcategory.ProductcategoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PcViewRow {
  implicit lazy val reads: Reads[PcViewRow] = Reads[PcViewRow](json => JsResult.fromTry(
      Try(
        PcViewRow(
          id = json.\("id").as(ProductcategoryId.reads),
          productcategoryid = json.\("productcategoryid").as(ProductcategoryId.reads),
          name = json.\("name").as(Name.reads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PcViewRow] = RowParser[PcViewRow] { row =>
    Success(
      PcViewRow(
        id = row(idx + 0)(ProductcategoryId.column),
        productcategoryid = row(idx + 1)(ProductcategoryId.column),
        name = row(idx + 2)(Name.column),
        rowguid = row(idx + 3)(TypoUUID.column),
        modifieddate = row(idx + 4)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[PcViewRow] = OWrites[PcViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> ProductcategoryId.writes.writes(o.id),
      "productcategoryid" -> ProductcategoryId.writes.writes(o.productcategoryid),
      "name" -> Name.writes.writes(o.name),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
