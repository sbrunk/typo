/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
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

case class LocationRow(
  /** Primary key for Location records. */
  locationid: LocationId,
  /** Location description. */
  name: Name,
  /** Standard hourly cost of the manufacturing location. */
  costrate: BigDecimal,
  /** Work capacity (in hours) of the manufacturing location. */
  availability: BigDecimal,
  modifieddate: TypoLocalDateTime
)

object LocationRow {
  implicit lazy val reads: Reads[LocationRow] = Reads[LocationRow](json => JsResult.fromTry(
      Try(
        LocationRow(
          locationid = json.\("locationid").as(LocationId.reads),
          name = json.\("name").as(Name.reads),
          costrate = json.\("costrate").as(Reads.bigDecReads),
          availability = json.\("availability").as(Reads.bigDecReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[LocationRow] = RowParser[LocationRow] { row =>
    Success(
      LocationRow(
        locationid = row(idx + 0)(LocationId.column),
        name = row(idx + 1)(Name.column),
        costrate = row(idx + 2)(Column.columnToScalaBigDecimal),
        availability = row(idx + 3)(Column.columnToScalaBigDecimal),
        modifieddate = row(idx + 4)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[LocationRow] = OWrites[LocationRow](o =>
    new JsObject(ListMap[String, JsValue](
      "locationid" -> LocationId.writes.writes(o.locationid),
      "name" -> Name.writes.writes(o.name),
      "costrate" -> Writes.BigDecimalWrites.writes(o.costrate),
      "availability" -> Writes.BigDecimalWrites.writes(o.availability),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
