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

case class PgTsDictRow(
  oid: PgTsDictId,
  dictname: String,
  dictnamespace: /* oid */ Long,
  dictowner: /* oid */ Long,
  dicttemplate: /* oid */ Long,
  dictinitoption: Option[String]
)

object PgTsDictRow {
  def rowParser(prefix: String): RowParser[PgTsDictRow] = { row =>
    Success(
      PgTsDictRow(
        oid = row[PgTsDictId](prefix + "oid"),
        dictname = row[String](prefix + "dictname"),
        dictnamespace = row[/* oid */ Long](prefix + "dictnamespace"),
        dictowner = row[/* oid */ Long](prefix + "dictowner"),
        dicttemplate = row[/* oid */ Long](prefix + "dicttemplate"),
        dictinitoption = row[Option[String]](prefix + "dictinitoption")
      )
    )
  }

  implicit val oFormat: OFormat[PgTsDictRow] = new OFormat[PgTsDictRow]{
    override def writes(o: PgTsDictRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "dictname" -> o.dictname,
      "dictnamespace" -> o.dictnamespace,
      "dictowner" -> o.dictowner,
      "dicttemplate" -> o.dicttemplate,
      "dictinitoption" -> o.dictinitoption
      )

    override def reads(json: JsValue): JsResult[PgTsDictRow] = {
      JsResult.fromTry(
        Try(
          PgTsDictRow(
            oid = json.\("oid").as[PgTsDictId],
            dictname = json.\("dictname").as[String],
            dictnamespace = json.\("dictnamespace").as[/* oid */ Long],
            dictowner = json.\("dictowner").as[/* oid */ Long],
            dicttemplate = json.\("dicttemplate").as[/* oid */ Long],
            dictinitoption = json.\("dictinitoption").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
