/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.TypoLocalDateTime
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

case class ScrapreasonRow(
  /** Primary key for ScrapReason records. */
  scrapreasonid: ScrapreasonId,
  /** Failure description. */
  name: Name,
  modifieddate: TypoLocalDateTime
)

object ScrapreasonRow {
  implicit lazy val reads: Reads[ScrapreasonRow] = Reads[ScrapreasonRow](json => JsResult.fromTry(
      Try(
        ScrapreasonRow(
          scrapreasonid = json.\("scrapreasonid").as(ScrapreasonId.reads),
          name = json.\("name").as(Name.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ScrapreasonRow] = RowParser[ScrapreasonRow] { row =>
    Success(
      ScrapreasonRow(
        scrapreasonid = row(idx + 0)(ScrapreasonId.column),
        name = row(idx + 1)(Name.column),
        modifieddate = row(idx + 2)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[ScrapreasonRow] = OWrites[ScrapreasonRow](o =>
    new JsObject(ListMap[String, JsValue](
      "scrapreasonid" -> ScrapreasonId.writes.writes(o.scrapreasonid),
      "name" -> Name.writes.writes(o.name),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
