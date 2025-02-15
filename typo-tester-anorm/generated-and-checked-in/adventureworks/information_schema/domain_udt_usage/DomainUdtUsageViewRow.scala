/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package domain_udt_usage

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

case class DomainUdtUsageViewRow(
  udtCatalog: /* nullability unknown */ Option[String],
  udtSchema: /* nullability unknown */ Option[String],
  udtName: /* nullability unknown */ Option[String],
  domainCatalog: /* nullability unknown */ Option[String],
  domainSchema: /* nullability unknown */ Option[String],
  domainName: /* nullability unknown */ Option[String]
)

object DomainUdtUsageViewRow {
  implicit lazy val reads: Reads[DomainUdtUsageViewRow] = Reads[DomainUdtUsageViewRow](json => JsResult.fromTry(
      Try(
        DomainUdtUsageViewRow(
          udtCatalog = json.\("udt_catalog").toOption.map(_.as(Reads.StringReads)),
          udtSchema = json.\("udt_schema").toOption.map(_.as(Reads.StringReads)),
          udtName = json.\("udt_name").toOption.map(_.as(Reads.StringReads)),
          domainCatalog = json.\("domain_catalog").toOption.map(_.as(Reads.StringReads)),
          domainSchema = json.\("domain_schema").toOption.map(_.as(Reads.StringReads)),
          domainName = json.\("domain_name").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[DomainUdtUsageViewRow] = RowParser[DomainUdtUsageViewRow] { row =>
    Success(
      DomainUdtUsageViewRow(
        udtCatalog = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        udtSchema = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        udtName = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        domainCatalog = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        domainSchema = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        domainName = row(idx + 5)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[DomainUdtUsageViewRow] = OWrites[DomainUdtUsageViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "udt_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.udtCatalog),
      "udt_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.udtSchema),
      "udt_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.udtName),
      "domain_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.domainCatalog),
      "domain_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.domainSchema),
      "domain_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.domainName)
    ))
  )
}
