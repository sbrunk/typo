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

case class PgTriggerRowUnsaved(
  tgrelid: /* oid */ Long,
  tgparentid: /* oid */ Long,
  tgname: String,
  tgfoid: /* oid */ Long,
  tgtype: Int,
  tgenabled: String,
  tgisinternal: Boolean,
  tgconstrrelid: /* oid */ Long,
  tgconstrindid: /* oid */ Long,
  tgconstraint: /* oid */ Long,
  tgdeferrable: Boolean,
  tginitdeferred: Boolean,
  tgnargs: Int,
  tgattr: /* int2vector */ PGobject,
  tgargs: Array[Byte],
  tgqual: Option[/* pg_node_tree */ PGobject],
  tgoldtable: Option[String],
  tgnewtable: Option[String]
)
object PgTriggerRowUnsaved {
  implicit val oFormat: OFormat[PgTriggerRowUnsaved] = new OFormat[PgTriggerRowUnsaved]{
    override def writes(o: PgTriggerRowUnsaved): JsObject =
      Json.obj(
        "tgrelid" -> o.tgrelid,
      "tgparentid" -> o.tgparentid,
      "tgname" -> o.tgname,
      "tgfoid" -> o.tgfoid,
      "tgtype" -> o.tgtype,
      "tgenabled" -> o.tgenabled,
      "tgisinternal" -> o.tgisinternal,
      "tgconstrrelid" -> o.tgconstrrelid,
      "tgconstrindid" -> o.tgconstrindid,
      "tgconstraint" -> o.tgconstraint,
      "tgdeferrable" -> o.tgdeferrable,
      "tginitdeferred" -> o.tginitdeferred,
      "tgnargs" -> o.tgnargs,
      "tgattr" -> o.tgattr,
      "tgargs" -> o.tgargs,
      "tgqual" -> o.tgqual,
      "tgoldtable" -> o.tgoldtable,
      "tgnewtable" -> o.tgnewtable
      )

    override def reads(json: JsValue): JsResult[PgTriggerRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgTriggerRowUnsaved(
            tgrelid = json.\("tgrelid").as[/* oid */ Long],
            tgparentid = json.\("tgparentid").as[/* oid */ Long],
            tgname = json.\("tgname").as[String],
            tgfoid = json.\("tgfoid").as[/* oid */ Long],
            tgtype = json.\("tgtype").as[Int],
            tgenabled = json.\("tgenabled").as[String],
            tgisinternal = json.\("tgisinternal").as[Boolean],
            tgconstrrelid = json.\("tgconstrrelid").as[/* oid */ Long],
            tgconstrindid = json.\("tgconstrindid").as[/* oid */ Long],
            tgconstraint = json.\("tgconstraint").as[/* oid */ Long],
            tgdeferrable = json.\("tgdeferrable").as[Boolean],
            tginitdeferred = json.\("tginitdeferred").as[Boolean],
            tgnargs = json.\("tgnargs").as[Int],
            tgattr = json.\("tgattr").as[/* int2vector */ PGobject],
            tgargs = json.\("tgargs").as[Array[Byte]],
            tgqual = json.\("tgqual").toOption.map(_.as[/* pg_node_tree */ PGobject]),
            tgoldtable = json.\("tgoldtable").toOption.map(_.as[String]),
            tgnewtable = json.\("tgnewtable").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
