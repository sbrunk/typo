/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class BusinessentityRow(
  /** Primary key for all customers, vendors, and employees. */
  businessentityid: BusinessentityId,
  rowguid: UUID,
  modifieddate: LocalDateTime
)

object BusinessentityRow {
  def rowParser(idx: Int): RowParser[BusinessentityRow] =
    RowParser[BusinessentityRow] { row =>
      Success(
        BusinessentityRow(
          businessentityid = row[BusinessentityId](idx + 0),
          rowguid = row[UUID](idx + 1),
          modifieddate = row[LocalDateTime](idx + 2)
        )
      )
    }
  implicit val oFormat: OFormat[BusinessentityRow] = new OFormat[BusinessentityRow]{
    override def writes(o: BusinessentityRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[BusinessentityRow] = {
      JsResult.fromTry(
        Try(
          BusinessentityRow(
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            rowguid = json.\("rowguid").as[UUID],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
