/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package information_schema_catalog_name

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

case class InformationSchemaCatalogNameViewRow(
  catalogName: /* nullability unknown */ Option[String]
)

object InformationSchemaCatalogNameViewRow {
  implicit lazy val reads: Reads[InformationSchemaCatalogNameViewRow] = Reads[InformationSchemaCatalogNameViewRow](json => JsResult.fromTry(
      Try(
        InformationSchemaCatalogNameViewRow(
          catalogName = json.\("catalog_name").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[InformationSchemaCatalogNameViewRow] = RowParser[InformationSchemaCatalogNameViewRow] { row =>
    Success(
      InformationSchemaCatalogNameViewRow(
        catalogName = row(idx + 0)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[InformationSchemaCatalogNameViewRow] = OWrites[InformationSchemaCatalogNameViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "catalog_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.catalogName)
    ))
  )
}
