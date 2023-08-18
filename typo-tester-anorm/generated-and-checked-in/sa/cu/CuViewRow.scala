/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cu

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import adventureworks.sales.currency.CurrencyId
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

case class CuViewRow(
  id: Option[/* bpchar, max 3 chars */ String],
  /** Points to [[sales.currency.CurrencyRow.currencycode]] */
  currencycode: Option[CurrencyId],
  /** Points to [[sales.currency.CurrencyRow.name]] */
  name: Option[Name],
  /** Points to [[sales.currency.CurrencyRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object CuViewRow {
  implicit lazy val reads: Reads[CuViewRow] = Reads[CuViewRow](json => JsResult.fromTry(
      Try(
        CuViewRow(
          id = json.\("id").toOption.map(_.as(Reads.StringReads)),
          currencycode = json.\("currencycode").toOption.map(_.as(CurrencyId.reads)),
          name = json.\("name").toOption.map(_.as(Name.reads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CuViewRow] = RowParser[CuViewRow] { row =>
    Success(
      CuViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        currencycode = row(idx + 1)(Column.columnToOption(CurrencyId.column)),
        name = row(idx + 2)(Column.columnToOption(Name.column)),
        modifieddate = row(idx + 3)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[CuViewRow] = OWrites[CuViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.StringWrites).writes(o.id),
      "currencycode" -> Writes.OptionWrites(CurrencyId.writes).writes(o.currencycode),
      "name" -> Writes.OptionWrites(Name.writes).writes(o.name),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
