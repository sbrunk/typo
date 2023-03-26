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

case class PgLargeobjectRow(
  loid: /* oid */ Long,
  pageno: Int,
  data: Array[Byte]
){
  val compositeId: PgLargeobjectId = PgLargeobjectId(loid, pageno)
}

object PgLargeobjectRow {
  def rowParser(prefix: String): RowParser[PgLargeobjectRow] = { row =>
    Success(
      PgLargeobjectRow(
        loid = row[/* oid */ Long](prefix + "loid"),
        pageno = row[Int](prefix + "pageno"),
        data = row[Array[Byte]](prefix + "data")
      )
    )
  }

  implicit val oFormat: OFormat[PgLargeobjectRow] = new OFormat[PgLargeobjectRow]{
    override def writes(o: PgLargeobjectRow): JsObject =
      Json.obj(
        "loid" -> o.loid,
      "pageno" -> o.pageno,
      "data" -> o.data
      )

    override def reads(json: JsValue): JsResult[PgLargeobjectRow] = {
      JsResult.fromTry(
        Try(
          PgLargeobjectRow(
            loid = json.\("loid").as[/* oid */ Long],
            pageno = json.\("pageno").as[Int],
            data = json.\("data").as[Array[Byte]]
          )
        )
      )
    }
  }
}
