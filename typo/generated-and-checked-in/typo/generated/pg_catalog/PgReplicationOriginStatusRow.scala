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

case class PgReplicationOriginStatusRow(
  localId: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_origin_status","column_name":"local_id","ordinal_position":1,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  externalId: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_origin_status","column_name":"external_id","ordinal_position":2,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  remoteLsn: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_origin_status","column_name":"remote_lsn","ordinal_position":3,"is_nullable":"YES","data_type":"pg_lsn","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"pg_lsn","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  localLsn: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_origin_status","column_name":"local_lsn","ordinal_position":4,"is_nullable":"YES","data_type":"pg_lsn","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"pg_lsn","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgReplicationOriginStatusRow {
  def rowParser(prefix: String): RowParser[PgReplicationOriginStatusRow] = { row =>
    Success(
      PgReplicationOriginStatusRow(
        localId = row[Option[/* oid */ Long]](prefix + "local_id"),
        externalId = row[Option[String]](prefix + "external_id"),
        remoteLsn = row[Option[String]](prefix + "remote_lsn"),
        localLsn = row[Option[String]](prefix + "local_lsn")
      )
    )
  }

  implicit val oFormat: OFormat[PgReplicationOriginStatusRow] = new OFormat[PgReplicationOriginStatusRow]{
    override def writes(o: PgReplicationOriginStatusRow): JsObject =
      Json.obj(
        "local_id" -> o.localId,
      "external_id" -> o.externalId,
      "remote_lsn" -> o.remoteLsn,
      "local_lsn" -> o.localLsn
      )

    override def reads(json: JsValue): JsResult[PgReplicationOriginStatusRow] = {
      JsResult.fromTry(
        Try(
          PgReplicationOriginStatusRow(
            localId = json.\("local_id").toOption.map(_.as[/* oid */ Long]),
            externalId = json.\("external_id").toOption.map(_.as[String]),
            remoteLsn = json.\("remote_lsn").toOption.map(_.as[String]),
            localLsn = json.\("local_lsn").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
