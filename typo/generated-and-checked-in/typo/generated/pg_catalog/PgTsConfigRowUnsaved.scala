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

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTsConfigRowUnsaved(
  cfgname: String,
  cfgnamespace: /* oid */ Long,
  cfgowner: /* oid */ Long,
  cfgparser: /* oid */ Long
)
object PgTsConfigRowUnsaved {
  implicit val oFormat: OFormat[PgTsConfigRowUnsaved] = new OFormat[PgTsConfigRowUnsaved]{
    override def writes(o: PgTsConfigRowUnsaved): JsObject =
      Json.obj(
        "cfgname" -> o.cfgname,
      "cfgnamespace" -> o.cfgnamespace,
      "cfgowner" -> o.cfgowner,
      "cfgparser" -> o.cfgparser
      )

    override def reads(json: JsValue): JsResult[PgTsConfigRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgTsConfigRowUnsaved(
            cfgname = json.\("cfgname").as[String],
            cfgnamespace = json.\("cfgnamespace").as[/* oid */ Long],
            cfgowner = json.\("cfgowner").as[/* oid */ Long],
            cfgparser = json.\("cfgparser").as[/* oid */ Long]
          )
        )
      )
    }
  }
}
