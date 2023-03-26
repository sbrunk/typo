/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgPublicationRelRow(
  oid: PgPublicationRelId,
  prpubid: /* oid */ Long,
  prrelid: /* oid */ Long
)

object PgPublicationRelRow {
  def rowParser(prefix: String): RowParser[PgPublicationRelRow] = { row =>
    Success(
      PgPublicationRelRow(
        oid = row[PgPublicationRelId](prefix + "oid"),
        prpubid = row[/* oid */ Long](prefix + "prpubid"),
        prrelid = row[/* oid */ Long](prefix + "prrelid")
      )
    )
  }

  implicit val oFormat: OFormat[PgPublicationRelRow] = new OFormat[PgPublicationRelRow]{
    override def writes(o: PgPublicationRelRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "prpubid" -> o.prpubid,
      "prrelid" -> o.prrelid
      )

    override def reads(json: JsValue): JsResult[PgPublicationRelRow] = {
      JsResult.fromTry(
        Try(
          PgPublicationRelRow(
            oid = json.\("oid").as[PgPublicationRelId],
            prpubid = json.\("prpubid").as[/* oid */ Long],
            prrelid = json.\("prrelid").as[/* oid */ Long]
          )
        )
      )
    }
  }
}
