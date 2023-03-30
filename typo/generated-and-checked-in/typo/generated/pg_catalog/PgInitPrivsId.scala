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

case class PgInitPrivsId(objoid: /* oid */ Long, classoid: /* oid */ Long, objsubid: Int)
object PgInitPrivsId {
  implicit def ordering: Ordering[PgInitPrivsId] = Ordering.by(x => (x.objoid, x.classoid, x.objsubid))
  implicit val oFormat: OFormat[PgInitPrivsId] = new OFormat[PgInitPrivsId]{
    override def writes(o: PgInitPrivsId): JsObject =
      Json.obj(
        "objoid" -> o.objoid,
      "classoid" -> o.classoid,
      "objsubid" -> o.objsubid
      )

    override def reads(json: JsValue): JsResult[PgInitPrivsId] = {
      JsResult.fromTry(
        Try(
          PgInitPrivsId(
            objoid = json.\("objoid").as[/* oid */ Long],
            classoid = json.\("classoid").as[/* oid */ Long],
            objsubid = json.\("objsubid").as[Int]
          )
        )
      )
    }
  }
  def rowParser(prefix: String): RowParser[PgInitPrivsId] = { row =>
    Success(
      PgInitPrivsId(
        objoid = row[/* oid */ Long](prefix + "objoid"),
        classoid = row[/* oid */ Long](prefix + "classoid"),
        objsubid = row[Int](prefix + "objsubid")
      )
    )
  }

}
