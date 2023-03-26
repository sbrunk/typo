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

case class PgSequenceRow(
  seqrelid: PgSequenceId,
  seqtypid: /* oid */ Long,
  seqstart: Long,
  seqincrement: Long,
  seqmax: Long,
  seqmin: Long,
  seqcache: Long,
  seqcycle: Boolean
)

object PgSequenceRow {
  def rowParser(prefix: String): RowParser[PgSequenceRow] = { row =>
    Success(
      PgSequenceRow(
        seqrelid = row[PgSequenceId](prefix + "seqrelid"),
        seqtypid = row[/* oid */ Long](prefix + "seqtypid"),
        seqstart = row[Long](prefix + "seqstart"),
        seqincrement = row[Long](prefix + "seqincrement"),
        seqmax = row[Long](prefix + "seqmax"),
        seqmin = row[Long](prefix + "seqmin"),
        seqcache = row[Long](prefix + "seqcache"),
        seqcycle = row[Boolean](prefix + "seqcycle")
      )
    )
  }

  implicit val oFormat: OFormat[PgSequenceRow] = new OFormat[PgSequenceRow]{
    override def writes(o: PgSequenceRow): JsObject =
      Json.obj(
        "seqrelid" -> o.seqrelid,
      "seqtypid" -> o.seqtypid,
      "seqstart" -> o.seqstart,
      "seqincrement" -> o.seqincrement,
      "seqmax" -> o.seqmax,
      "seqmin" -> o.seqmin,
      "seqcache" -> o.seqcache,
      "seqcycle" -> o.seqcycle
      )

    override def reads(json: JsValue): JsResult[PgSequenceRow] = {
      JsResult.fromTry(
        Try(
          PgSequenceRow(
            seqrelid = json.\("seqrelid").as[PgSequenceId],
            seqtypid = json.\("seqtypid").as[/* oid */ Long],
            seqstart = json.\("seqstart").as[Long],
            seqincrement = json.\("seqincrement").as[Long],
            seqmax = json.\("seqmax").as[Long],
            seqmin = json.\("seqmin").as[Long],
            seqcache = json.\("seqcache").as[Long],
            seqcycle = json.\("seqcycle").as[Boolean]
          )
        )
      )
    }
  }
}
