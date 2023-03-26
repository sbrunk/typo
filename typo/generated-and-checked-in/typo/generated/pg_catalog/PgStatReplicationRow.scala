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
import java.time.ZonedDateTime
import org.postgresql.util.PGInterval
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatReplicationRow(
  pid: Option[Int] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"pid","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  usesysid: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"usesysid","ordinal_position":2,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  usename: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"usename","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  applicationName: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"application_name","ordinal_position":4,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  clientAddr: Option[/* inet */ PGobject] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"client_addr","ordinal_position":5,"is_nullable":"YES","data_type":"inet","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"inet","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  clientHostname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"client_hostname","ordinal_position":6,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  clientPort: Option[Int] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"client_port","ordinal_position":7,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  backendStart: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"backend_start","ordinal_position":8,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  backendXmin: Option[/* xid */ PGobject] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"backend_xmin","ordinal_position":9,"is_nullable":"YES","data_type":"xid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"xid","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  state: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"state","ordinal_position":10,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  sentLsn: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"sent_lsn","ordinal_position":11,"is_nullable":"YES","data_type":"pg_lsn","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"pg_lsn","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  writeLsn: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"write_lsn","ordinal_position":12,"is_nullable":"YES","data_type":"pg_lsn","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"pg_lsn","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  flushLsn: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"flush_lsn","ordinal_position":13,"is_nullable":"YES","data_type":"pg_lsn","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"pg_lsn","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  replayLsn: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"replay_lsn","ordinal_position":14,"is_nullable":"YES","data_type":"pg_lsn","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"pg_lsn","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  writeLag: Option[PGInterval] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"write_lag","ordinal_position":15,"is_nullable":"YES","data_type":"interval","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"interval","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  flushLag: Option[PGInterval] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"flush_lag","ordinal_position":16,"is_nullable":"YES","data_type":"interval","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"interval","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  replayLag: Option[PGInterval] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"replay_lag","ordinal_position":17,"is_nullable":"YES","data_type":"interval","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"interval","dtd_identifier":"17","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  syncPriority: Option[Int] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"sync_priority","ordinal_position":18,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"18","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  syncState: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"sync_state","ordinal_position":19,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"19","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  replyTime: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_replication","column_name":"reply_time","ordinal_position":20,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"20","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatReplicationRow {
  def rowParser(prefix: String): RowParser[PgStatReplicationRow] = { row =>
    Success(
      PgStatReplicationRow(
        pid = row[Option[Int]](prefix + "pid"),
        usesysid = row[Option[/* oid */ Long]](prefix + "usesysid"),
        usename = row[Option[String]](prefix + "usename"),
        applicationName = row[Option[String]](prefix + "application_name"),
        clientAddr = row[Option[/* inet */ PGobject]](prefix + "client_addr"),
        clientHostname = row[Option[String]](prefix + "client_hostname"),
        clientPort = row[Option[Int]](prefix + "client_port"),
        backendStart = row[Option[ZonedDateTime]](prefix + "backend_start"),
        backendXmin = row[Option[/* xid */ PGobject]](prefix + "backend_xmin"),
        state = row[Option[String]](prefix + "state"),
        sentLsn = row[Option[String]](prefix + "sent_lsn"),
        writeLsn = row[Option[String]](prefix + "write_lsn"),
        flushLsn = row[Option[String]](prefix + "flush_lsn"),
        replayLsn = row[Option[String]](prefix + "replay_lsn"),
        writeLag = row[Option[PGInterval]](prefix + "write_lag"),
        flushLag = row[Option[PGInterval]](prefix + "flush_lag"),
        replayLag = row[Option[PGInterval]](prefix + "replay_lag"),
        syncPriority = row[Option[Int]](prefix + "sync_priority"),
        syncState = row[Option[String]](prefix + "sync_state"),
        replyTime = row[Option[ZonedDateTime]](prefix + "reply_time")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatReplicationRow] = new OFormat[PgStatReplicationRow]{
    override def writes(o: PgStatReplicationRow): JsObject =
      Json.obj(
        "pid" -> o.pid,
      "usesysid" -> o.usesysid,
      "usename" -> o.usename,
      "application_name" -> o.applicationName,
      "client_addr" -> o.clientAddr,
      "client_hostname" -> o.clientHostname,
      "client_port" -> o.clientPort,
      "backend_start" -> o.backendStart,
      "backend_xmin" -> o.backendXmin,
      "state" -> o.state,
      "sent_lsn" -> o.sentLsn,
      "write_lsn" -> o.writeLsn,
      "flush_lsn" -> o.flushLsn,
      "replay_lsn" -> o.replayLsn,
      "write_lag" -> o.writeLag,
      "flush_lag" -> o.flushLag,
      "replay_lag" -> o.replayLag,
      "sync_priority" -> o.syncPriority,
      "sync_state" -> o.syncState,
      "reply_time" -> o.replyTime
      )

    override def reads(json: JsValue): JsResult[PgStatReplicationRow] = {
      JsResult.fromTry(
        Try(
          PgStatReplicationRow(
            pid = json.\("pid").toOption.map(_.as[Int]),
            usesysid = json.\("usesysid").toOption.map(_.as[/* oid */ Long]),
            usename = json.\("usename").toOption.map(_.as[String]),
            applicationName = json.\("application_name").toOption.map(_.as[String]),
            clientAddr = json.\("client_addr").toOption.map(_.as[/* inet */ PGobject]),
            clientHostname = json.\("client_hostname").toOption.map(_.as[String]),
            clientPort = json.\("client_port").toOption.map(_.as[Int]),
            backendStart = json.\("backend_start").toOption.map(_.as[ZonedDateTime]),
            backendXmin = json.\("backend_xmin").toOption.map(_.as[/* xid */ PGobject]),
            state = json.\("state").toOption.map(_.as[String]),
            sentLsn = json.\("sent_lsn").toOption.map(_.as[String]),
            writeLsn = json.\("write_lsn").toOption.map(_.as[String]),
            flushLsn = json.\("flush_lsn").toOption.map(_.as[String]),
            replayLsn = json.\("replay_lsn").toOption.map(_.as[String]),
            writeLag = json.\("write_lag").toOption.map(_.as[PGInterval]),
            flushLag = json.\("flush_lag").toOption.map(_.as[PGInterval]),
            replayLag = json.\("replay_lag").toOption.map(_.as[PGInterval]),
            syncPriority = json.\("sync_priority").toOption.map(_.as[Int]),
            syncState = json.\("sync_state").toOption.map(_.as[String]),
            replyTime = json.\("reply_time").toOption.map(_.as[ZonedDateTime])
          )
        )
      )
    }
  }
}
