/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatisticId(starelid: /* oid */ Long, staattnum: Int, stainherit: Boolean)
object PgStatisticId {
  implicit def ordering: Ordering[PgStatisticId] = Ordering.by(x => (x.starelid, x.staattnum, x.stainherit))
  implicit val oFormat: OFormat[PgStatisticId] = new OFormat[PgStatisticId]{
    override def writes(o: PgStatisticId): JsObject =
      Json.obj(
        "starelid" -> o.starelid,
      "staattnum" -> o.staattnum,
      "stainherit" -> o.stainherit
      )

    override def reads(json: JsValue): JsResult[PgStatisticId] = {
      JsResult.fromTry(
        Try(
          PgStatisticId(
            starelid = json.\("starelid").as[/* oid */ Long],
            staattnum = json.\("staattnum").as[Int],
            stainherit = json.\("stainherit").as[Boolean]
          )
        )
      )
    }
  }
  def rowParser(prefix: String): RowParser[PgStatisticId] = { row =>
    Success(
      PgStatisticId(
        starelid = row[/* oid */ Long](prefix + "starelid"),
        staattnum = row[Int](prefix + "staattnum"),
        stainherit = row[Boolean](prefix + "stainherit")
      )
    )
  }

}
