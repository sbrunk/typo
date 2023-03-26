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
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgNamespaceRow(
  oid: PgNamespaceId,
  nspname: String,
  nspowner: /* oid */ Long,
  nspacl: Option[Array[/* aclitem */ PGobject]]
)

object PgNamespaceRow {
  def rowParser(prefix: String): RowParser[PgNamespaceRow] = { row =>
    Success(
      PgNamespaceRow(
        oid = row[PgNamespaceId](prefix + "oid"),
        nspname = row[String](prefix + "nspname"),
        nspowner = row[/* oid */ Long](prefix + "nspowner"),
        nspacl = row[Option[Array[/* aclitem */ PGobject]]](prefix + "nspacl")
      )
    )
  }

  implicit val oFormat: OFormat[PgNamespaceRow] = new OFormat[PgNamespaceRow]{
    override def writes(o: PgNamespaceRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "nspname" -> o.nspname,
      "nspowner" -> o.nspowner,
      "nspacl" -> o.nspacl
      )

    override def reads(json: JsValue): JsResult[PgNamespaceRow] = {
      JsResult.fromTry(
        Try(
          PgNamespaceRow(
            oid = json.\("oid").as[PgNamespaceId],
            nspname = json.\("nspname").as[String],
            nspowner = json.\("nspowner").as[/* oid */ Long],
            nspacl = json.\("nspacl").toOption.map(_.as[Array[/* aclitem */ PGobject]])
          )
        )
      )
    }
  }
}
