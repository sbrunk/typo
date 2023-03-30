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

case class PgInheritsId(inhrelid: /* oid */ Long, inhseqno: Int)
object PgInheritsId {
  implicit def ordering: Ordering[PgInheritsId] = Ordering.by(x => (x.inhrelid, x.inhseqno))
  implicit val oFormat: OFormat[PgInheritsId] = new OFormat[PgInheritsId]{
    override def writes(o: PgInheritsId): JsObject =
      Json.obj(
        "inhrelid" -> o.inhrelid,
      "inhseqno" -> o.inhseqno
      )

    override def reads(json: JsValue): JsResult[PgInheritsId] = {
      JsResult.fromTry(
        Try(
          PgInheritsId(
            inhrelid = json.\("inhrelid").as[/* oid */ Long],
            inhseqno = json.\("inhseqno").as[Int]
          )
        )
      )
    }
  }
  def rowParser(prefix: String): RowParser[PgInheritsId] = { row =>
    Success(
      PgInheritsId(
        inhrelid = row[/* oid */ Long](prefix + "inhrelid"),
        inhseqno = row[Int](prefix + "inhseqno")
      )
    )
  }

}
