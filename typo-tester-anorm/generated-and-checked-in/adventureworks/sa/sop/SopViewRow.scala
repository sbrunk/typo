/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sop

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class SopViewRow(
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.specialofferid]] */
  id: SpecialofferId,
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.productid]] */
  productid: ProductId,
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SopViewRow {
  implicit lazy val reads: Reads[SopViewRow] = Reads[SopViewRow](json => JsResult.fromTry(
      Try(
        SopViewRow(
          id = json.\("id").as(SpecialofferId.reads),
          specialofferid = json.\("specialofferid").as(SpecialofferId.reads),
          productid = json.\("productid").as(ProductId.reads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SopViewRow] = RowParser[SopViewRow] { row =>
    Success(
      SopViewRow(
        id = row(idx + 0)(SpecialofferId.column),
        specialofferid = row(idx + 1)(SpecialofferId.column),
        productid = row(idx + 2)(ProductId.column),
        rowguid = row(idx + 3)(TypoUUID.column),
        modifieddate = row(idx + 4)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[SopViewRow] = OWrites[SopViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> SpecialofferId.writes.writes(o.id),
      "specialofferid" -> SpecialofferId.writes.writes(o.specialofferid),
      "productid" -> ProductId.writes.writes(o.productid),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
