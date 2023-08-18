/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package w

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import adventureworks.production.workorder.WorkorderId
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

case class WViewRow(
  id: Option[Int],
  /** Points to [[production.workorder.WorkorderRow.workorderid]] */
  workorderid: Option[WorkorderId],
  /** Points to [[production.workorder.WorkorderRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.workorder.WorkorderRow.orderqty]] */
  orderqty: Option[Int],
  /** Points to [[production.workorder.WorkorderRow.scrappedqty]] */
  scrappedqty: Option[Int],
  /** Points to [[production.workorder.WorkorderRow.startdate]] */
  startdate: Option[TypoLocalDateTime],
  /** Points to [[production.workorder.WorkorderRow.enddate]] */
  enddate: Option[TypoLocalDateTime],
  /** Points to [[production.workorder.WorkorderRow.duedate]] */
  duedate: Option[TypoLocalDateTime],
  /** Points to [[production.workorder.WorkorderRow.scrapreasonid]] */
  scrapreasonid: Option[ScrapreasonId],
  /** Points to [[production.workorder.WorkorderRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object WViewRow {
  implicit lazy val reads: Reads[WViewRow] = Reads[WViewRow](json => JsResult.fromTry(
      Try(
        WViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          workorderid = json.\("workorderid").toOption.map(_.as(WorkorderId.reads)),
          productid = json.\("productid").toOption.map(_.as(ProductId.reads)),
          orderqty = json.\("orderqty").toOption.map(_.as(Reads.IntReads)),
          scrappedqty = json.\("scrappedqty").toOption.map(_.as(Reads.IntReads)),
          startdate = json.\("startdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          duedate = json.\("duedate").toOption.map(_.as(TypoLocalDateTime.reads)),
          scrapreasonid = json.\("scrapreasonid").toOption.map(_.as(ScrapreasonId.reads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[WViewRow] = RowParser[WViewRow] { row =>
    Success(
      WViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        workorderid = row(idx + 1)(Column.columnToOption(WorkorderId.column)),
        productid = row(idx + 2)(Column.columnToOption(ProductId.column)),
        orderqty = row(idx + 3)(Column.columnToOption(Column.columnToInt)),
        scrappedqty = row(idx + 4)(Column.columnToOption(Column.columnToInt)),
        startdate = row(idx + 5)(Column.columnToOption(TypoLocalDateTime.column)),
        enddate = row(idx + 6)(Column.columnToOption(TypoLocalDateTime.column)),
        duedate = row(idx + 7)(Column.columnToOption(TypoLocalDateTime.column)),
        scrapreasonid = row(idx + 8)(Column.columnToOption(ScrapreasonId.column)),
        modifieddate = row(idx + 9)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[WViewRow] = OWrites[WViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "workorderid" -> Writes.OptionWrites(WorkorderId.writes).writes(o.workorderid),
      "productid" -> Writes.OptionWrites(ProductId.writes).writes(o.productid),
      "orderqty" -> Writes.OptionWrites(Writes.IntWrites).writes(o.orderqty),
      "scrappedqty" -> Writes.OptionWrites(Writes.IntWrites).writes(o.scrappedqty),
      "startdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.enddate),
      "duedate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.duedate),
      "scrapreasonid" -> Writes.OptionWrites(ScrapreasonId.writes).writes(o.scrapreasonid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
