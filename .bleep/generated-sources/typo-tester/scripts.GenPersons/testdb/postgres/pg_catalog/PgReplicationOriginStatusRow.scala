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

case class PgReplicationOriginStatusRow(
  localId: Option[/* oid */ Long],
  externalId: Option[String],
  remoteLsn: Option[String],
  localLsn: Option[String]
)

object PgReplicationOriginStatusRow {
  def rowParser(prefix: String): RowParser[PgReplicationOriginStatusRow] = { row =>
    Success(
      PgReplicationOriginStatusRow(
        localId = row[Option[/* oid */ Long]](prefix + "local_id"),
        externalId = row[Option[String]](prefix + "external_id"),
        remoteLsn = row[Option[String]](prefix + "remote_lsn"),
        localLsn = row[Option[String]](prefix + "local_lsn")
      )
    )
  }

  implicit val oFormat: OFormat[PgReplicationOriginStatusRow] = new OFormat[PgReplicationOriginStatusRow]{
    override def writes(o: PgReplicationOriginStatusRow): JsObject =
      Json.obj(
        "local_id" -> o.localId,
      "external_id" -> o.externalId,
      "remote_lsn" -> o.remoteLsn,
      "local_lsn" -> o.localLsn
      )

    override def reads(json: JsValue): JsResult[PgReplicationOriginStatusRow] = {
      JsResult.fromTry(
        Try(
          PgReplicationOriginStatusRow(
            localId = json.\("local_id").toOption.map(_.as[/* oid */ Long]),
            externalId = json.\("external_id").toOption.map(_.as[String]),
            remoteLsn = json.\("remote_lsn").toOption.map(_.as[String]),
            localLsn = json.\("local_lsn").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
