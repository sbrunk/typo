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

case class PgEventTriggerRow(
  oid: PgEventTriggerId /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_event_trigger","column_name":"oid","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  evtname: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_event_trigger","column_name":"evtname","ordinal_position":2,"is_nullable":"NO","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  evtevent: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_event_trigger","column_name":"evtevent","ordinal_position":3,"is_nullable":"NO","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  evtowner: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_event_trigger","column_name":"evtowner","ordinal_position":4,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  evtfoid: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_event_trigger","column_name":"evtfoid","ordinal_position":5,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  evtenabled: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_event_trigger","column_name":"evtenabled","ordinal_position":6,"is_nullable":"NO","data_type":"\"char\"","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"char","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  evttags: Option[Array[String]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_event_trigger","column_name":"evttags","ordinal_position":7,"is_nullable":"YES","data_type":"ARRAY","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_text","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object PgEventTriggerRow {
  def rowParser(prefix: String): RowParser[PgEventTriggerRow] = { row =>
    Success(
      PgEventTriggerRow(
        oid = row[PgEventTriggerId](prefix + "oid"),
        evtname = row[String](prefix + "evtname"),
        evtevent = row[String](prefix + "evtevent"),
        evtowner = row[Long](prefix + "evtowner"),
        evtfoid = row[Long](prefix + "evtfoid"),
        evtenabled = row[String](prefix + "evtenabled"),
        evttags = row[Option[Array[String]]](prefix + "evttags")
      )
    )
  }

  implicit val oFormat: OFormat[PgEventTriggerRow] = new OFormat[PgEventTriggerRow]{
    override def writes(o: PgEventTriggerRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "evtname" -> o.evtname,
      "evtevent" -> o.evtevent,
      "evtowner" -> o.evtowner,
      "evtfoid" -> o.evtfoid,
      "evtenabled" -> o.evtenabled,
      "evttags" -> o.evttags
      )

    override def reads(json: JsValue): JsResult[PgEventTriggerRow] = {
      JsResult.fromTry(
        Try(
          PgEventTriggerRow(
            oid = json.\("oid").as[PgEventTriggerId],
            evtname = json.\("evtname").as[String],
            evtevent = json.\("evtevent").as[String],
            evtowner = json.\("evtowner").as[Long],
            evtfoid = json.\("evtfoid").as[Long],
            evtenabled = json.\("evtenabled").as[String],
            evttags = json.\("evttags").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
