/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package psc

import adventureworks.TypoLocalDateTime
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.public.Name
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

case class PscViewRow(
  id: Option[Int],
  /** Points to [[production.productsubcategory.ProductsubcategoryRow.productsubcategoryid]] */
  productsubcategoryid: Option[ProductsubcategoryId],
  /** Points to [[production.productsubcategory.ProductsubcategoryRow.productcategoryid]] */
  productcategoryid: Option[ProductcategoryId],
  /** Points to [[production.productsubcategory.ProductsubcategoryRow.name]] */
  name: Option[Name],
  /** Points to [[production.productsubcategory.ProductsubcategoryRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.productsubcategory.ProductsubcategoryRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PscViewRow {
  implicit lazy val reads: Reads[PscViewRow] = Reads[PscViewRow](json => JsResult.fromTry(
      Try(
        PscViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          productsubcategoryid = json.\("productsubcategoryid").toOption.map(_.as(ProductsubcategoryId.reads)),
          productcategoryid = json.\("productcategoryid").toOption.map(_.as(ProductcategoryId.reads)),
          name = json.\("name").toOption.map(_.as(Name.reads)),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PscViewRow] = RowParser[PscViewRow] { row =>
    Success(
      PscViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        productsubcategoryid = row(idx + 1)(Column.columnToOption(ProductsubcategoryId.column)),
        productcategoryid = row(idx + 2)(Column.columnToOption(ProductcategoryId.column)),
        name = row(idx + 3)(Column.columnToOption(Name.column)),
        rowguid = row(idx + 4)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 5)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[PscViewRow] = OWrites[PscViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "productsubcategoryid" -> Writes.OptionWrites(ProductsubcategoryId.writes).writes(o.productsubcategoryid),
      "productcategoryid" -> Writes.OptionWrites(ProductcategoryId.writes).writes(o.productcategoryid),
      "name" -> Writes.OptionWrites(Name.writes).writes(o.name),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
