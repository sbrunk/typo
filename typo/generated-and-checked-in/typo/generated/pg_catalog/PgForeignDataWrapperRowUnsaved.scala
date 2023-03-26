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

import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgForeignDataWrapperRowUnsaved(
  fdwname: String,
  fdwowner: /* oid */ Long,
  fdwhandler: /* oid */ Long,
  fdwvalidator: /* oid */ Long,
  fdwacl: Option[Array[/* aclitem */ PGobject]],
  fdwoptions: Option[Array[String]]
)
object PgForeignDataWrapperRowUnsaved {
  implicit val oFormat: OFormat[PgForeignDataWrapperRowUnsaved] = new OFormat[PgForeignDataWrapperRowUnsaved]{
    override def writes(o: PgForeignDataWrapperRowUnsaved): JsObject =
      Json.obj(
        "fdwname" -> o.fdwname,
      "fdwowner" -> o.fdwowner,
      "fdwhandler" -> o.fdwhandler,
      "fdwvalidator" -> o.fdwvalidator,
      "fdwacl" -> o.fdwacl,
      "fdwoptions" -> o.fdwoptions
      )

    override def reads(json: JsValue): JsResult[PgForeignDataWrapperRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgForeignDataWrapperRowUnsaved(
            fdwname = json.\("fdwname").as[String],
            fdwowner = json.\("fdwowner").as[/* oid */ Long],
            fdwhandler = json.\("fdwhandler").as[/* oid */ Long],
            fdwvalidator = json.\("fdwvalidator").as[/* oid */ Long],
            fdwacl = json.\("fdwacl").toOption.map(_.as[Array[/* aclitem */ PGobject]]),
            fdwoptions = json.\("fdwoptions").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
