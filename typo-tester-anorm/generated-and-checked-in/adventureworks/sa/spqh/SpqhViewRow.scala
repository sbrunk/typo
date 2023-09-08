/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package spqh

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
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

case class SpqhViewRow(
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.quotadate]] */
  quotadate: TypoLocalDateTime,
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.salesquota]] */
  salesquota: BigDecimal,
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SpqhViewRow {
  implicit lazy val reads: Reads[SpqhViewRow] = Reads[SpqhViewRow](json => JsResult.fromTry(
      Try(
        SpqhViewRow(
          id = json.\("id").as(BusinessentityId.reads),
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          quotadate = json.\("quotadate").as(TypoLocalDateTime.reads),
          salesquota = json.\("salesquota").as(Reads.bigDecReads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SpqhViewRow] = RowParser[SpqhViewRow] { row =>
    Success(
      SpqhViewRow(
        id = row(idx + 0)(BusinessentityId.column),
        businessentityid = row(idx + 1)(BusinessentityId.column),
        quotadate = row(idx + 2)(TypoLocalDateTime.column),
        salesquota = row(idx + 3)(Column.columnToScalaBigDecimal),
        rowguid = row(idx + 4)(TypoUUID.column),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[SpqhViewRow] = OWrites[SpqhViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> BusinessentityId.writes.writes(o.id),
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "quotadate" -> TypoLocalDateTime.writes.writes(o.quotadate),
      "salesquota" -> Writes.BigDecimalWrites.writes(o.salesquota),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
