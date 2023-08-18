/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package s

import adventureworks.TypoLocalDateTime
import adventureworks.TypoLocalTime
import adventureworks.humanresources.shift.ShiftId
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

case class SViewRow(
  id: Option[Int],
  /** Points to [[humanresources.shift.ShiftRow.shiftid]] */
  shiftid: Option[ShiftId],
  /** Points to [[humanresources.shift.ShiftRow.name]] */
  name: Option[Name],
  /** Points to [[humanresources.shift.ShiftRow.starttime]] */
  starttime: Option[TypoLocalTime],
  /** Points to [[humanresources.shift.ShiftRow.endtime]] */
  endtime: Option[TypoLocalTime],
  /** Points to [[humanresources.shift.ShiftRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object SViewRow {
  implicit lazy val reads: Reads[SViewRow] = Reads[SViewRow](json => JsResult.fromTry(
      Try(
        SViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          shiftid = json.\("shiftid").toOption.map(_.as(ShiftId.reads)),
          name = json.\("name").toOption.map(_.as(Name.reads)),
          starttime = json.\("starttime").toOption.map(_.as(TypoLocalTime.reads)),
          endtime = json.\("endtime").toOption.map(_.as(TypoLocalTime.reads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SViewRow] = RowParser[SViewRow] { row =>
    Success(
      SViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        shiftid = row(idx + 1)(Column.columnToOption(ShiftId.column)),
        name = row(idx + 2)(Column.columnToOption(Name.column)),
        starttime = row(idx + 3)(Column.columnToOption(TypoLocalTime.column)),
        endtime = row(idx + 4)(Column.columnToOption(TypoLocalTime.column)),
        modifieddate = row(idx + 5)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[SViewRow] = OWrites[SViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "shiftid" -> Writes.OptionWrites(ShiftId.writes).writes(o.shiftid),
      "name" -> Writes.OptionWrites(Name.writes).writes(o.name),
      "starttime" -> Writes.OptionWrites(TypoLocalTime.writes).writes(o.starttime),
      "endtime" -> Writes.OptionWrites(TypoLocalTime.writes).writes(o.endtime),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
