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
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTriggerRow(
  oid: PgTriggerId /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"oid","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgrelid: /* oid */ Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgrelid","ordinal_position":2,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgparentid: /* oid */ Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgparentid","ordinal_position":3,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgname: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgname","ordinal_position":4,"is_nullable":"NO","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgfoid: /* oid */ Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgfoid","ordinal_position":5,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgtype: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgtype","ordinal_position":6,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgenabled: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgenabled","ordinal_position":7,"is_nullable":"NO","data_type":"\"char\"","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"char","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgisinternal: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgisinternal","ordinal_position":8,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgconstrrelid: /* oid */ Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgconstrrelid","ordinal_position":9,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgconstrindid: /* oid */ Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgconstrindid","ordinal_position":10,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgconstraint: /* oid */ Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgconstraint","ordinal_position":11,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgdeferrable: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgdeferrable","ordinal_position":12,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tginitdeferred: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tginitdeferred","ordinal_position":13,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgnargs: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgnargs","ordinal_position":14,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgattr: /* int2vector */ PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgattr","ordinal_position":15,"is_nullable":"NO","data_type":"ARRAY","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int2vector","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgargs: Array[Byte] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgargs","ordinal_position":16,"is_nullable":"NO","data_type":"bytea","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bytea","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgqual: Option[/* pg_node_tree */ PGobject] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgqual","ordinal_position":17,"is_nullable":"YES","data_type":"pg_node_tree","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"pg_node_tree","dtd_identifier":"17","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgoldtable: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgoldtable","ordinal_position":18,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"18","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  tgnewtable: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_trigger","column_name":"tgnewtable","ordinal_position":19,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"19","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object PgTriggerRow {
  def rowParser(prefix: String): RowParser[PgTriggerRow] = { row =>
    Success(
      PgTriggerRow(
        oid = row[PgTriggerId](prefix + "oid"),
        tgrelid = row[/* oid */ Long](prefix + "tgrelid"),
        tgparentid = row[/* oid */ Long](prefix + "tgparentid"),
        tgname = row[String](prefix + "tgname"),
        tgfoid = row[/* oid */ Long](prefix + "tgfoid"),
        tgtype = row[Int](prefix + "tgtype"),
        tgenabled = row[String](prefix + "tgenabled"),
        tgisinternal = row[Boolean](prefix + "tgisinternal"),
        tgconstrrelid = row[/* oid */ Long](prefix + "tgconstrrelid"),
        tgconstrindid = row[/* oid */ Long](prefix + "tgconstrindid"),
        tgconstraint = row[/* oid */ Long](prefix + "tgconstraint"),
        tgdeferrable = row[Boolean](prefix + "tgdeferrable"),
        tginitdeferred = row[Boolean](prefix + "tginitdeferred"),
        tgnargs = row[Int](prefix + "tgnargs"),
        tgattr = row[/* int2vector */ PGobject](prefix + "tgattr"),
        tgargs = row[Array[Byte]](prefix + "tgargs"),
        tgqual = row[Option[/* pg_node_tree */ PGobject]](prefix + "tgqual"),
        tgoldtable = row[Option[String]](prefix + "tgoldtable"),
        tgnewtable = row[Option[String]](prefix + "tgnewtable")
      )
    )
  }

  implicit val oFormat: OFormat[PgTriggerRow] = new OFormat[PgTriggerRow]{
    override def writes(o: PgTriggerRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
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

    override def reads(json: JsValue): JsResult[PgTriggerRow] = {
      JsResult.fromTry(
        Try(
          PgTriggerRow(
            oid = json.\("oid").as[PgTriggerId],
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
