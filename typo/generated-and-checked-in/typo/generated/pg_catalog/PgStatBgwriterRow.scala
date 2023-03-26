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
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatBgwriterRow(
  checkpointsTimed: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_bgwriter","column_name":"checkpoints_timed","ordinal_position":1,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  checkpointsReq: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_bgwriter","column_name":"checkpoints_req","ordinal_position":2,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  checkpointWriteTime: Option[Double] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_bgwriter","column_name":"checkpoint_write_time","ordinal_position":3,"is_nullable":"YES","data_type":"double precision","numeric_precision":53,"numeric_precision_radix":2,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"float8","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  checkpointSyncTime: Option[Double] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_bgwriter","column_name":"checkpoint_sync_time","ordinal_position":4,"is_nullable":"YES","data_type":"double precision","numeric_precision":53,"numeric_precision_radix":2,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"float8","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  buffersCheckpoint: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_bgwriter","column_name":"buffers_checkpoint","ordinal_position":5,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  buffersClean: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_bgwriter","column_name":"buffers_clean","ordinal_position":6,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  maxwrittenClean: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_bgwriter","column_name":"maxwritten_clean","ordinal_position":7,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  buffersBackend: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_bgwriter","column_name":"buffers_backend","ordinal_position":8,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  buffersBackendFsync: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_bgwriter","column_name":"buffers_backend_fsync","ordinal_position":9,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  buffersAlloc: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_bgwriter","column_name":"buffers_alloc","ordinal_position":10,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  statsReset: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_bgwriter","column_name":"stats_reset","ordinal_position":11,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatBgwriterRow {
  def rowParser(prefix: String): RowParser[PgStatBgwriterRow] = { row =>
    Success(
      PgStatBgwriterRow(
        checkpointsTimed = row[Option[Long]](prefix + "checkpoints_timed"),
        checkpointsReq = row[Option[Long]](prefix + "checkpoints_req"),
        checkpointWriteTime = row[Option[Double]](prefix + "checkpoint_write_time"),
        checkpointSyncTime = row[Option[Double]](prefix + "checkpoint_sync_time"),
        buffersCheckpoint = row[Option[Long]](prefix + "buffers_checkpoint"),
        buffersClean = row[Option[Long]](prefix + "buffers_clean"),
        maxwrittenClean = row[Option[Long]](prefix + "maxwritten_clean"),
        buffersBackend = row[Option[Long]](prefix + "buffers_backend"),
        buffersBackendFsync = row[Option[Long]](prefix + "buffers_backend_fsync"),
        buffersAlloc = row[Option[Long]](prefix + "buffers_alloc"),
        statsReset = row[Option[ZonedDateTime]](prefix + "stats_reset")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatBgwriterRow] = new OFormat[PgStatBgwriterRow]{
    override def writes(o: PgStatBgwriterRow): JsObject =
      Json.obj(
        "checkpoints_timed" -> o.checkpointsTimed,
      "checkpoints_req" -> o.checkpointsReq,
      "checkpoint_write_time" -> o.checkpointWriteTime,
      "checkpoint_sync_time" -> o.checkpointSyncTime,
      "buffers_checkpoint" -> o.buffersCheckpoint,
      "buffers_clean" -> o.buffersClean,
      "maxwritten_clean" -> o.maxwrittenClean,
      "buffers_backend" -> o.buffersBackend,
      "buffers_backend_fsync" -> o.buffersBackendFsync,
      "buffers_alloc" -> o.buffersAlloc,
      "stats_reset" -> o.statsReset
      )

    override def reads(json: JsValue): JsResult[PgStatBgwriterRow] = {
      JsResult.fromTry(
        Try(
          PgStatBgwriterRow(
            checkpointsTimed = json.\("checkpoints_timed").toOption.map(_.as[Long]),
            checkpointsReq = json.\("checkpoints_req").toOption.map(_.as[Long]),
            checkpointWriteTime = json.\("checkpoint_write_time").toOption.map(_.as[Double]),
            checkpointSyncTime = json.\("checkpoint_sync_time").toOption.map(_.as[Double]),
            buffersCheckpoint = json.\("buffers_checkpoint").toOption.map(_.as[Long]),
            buffersClean = json.\("buffers_clean").toOption.map(_.as[Long]),
            maxwrittenClean = json.\("maxwritten_clean").toOption.map(_.as[Long]),
            buffersBackend = json.\("buffers_backend").toOption.map(_.as[Long]),
            buffersBackendFsync = json.\("buffers_backend_fsync").toOption.map(_.as[Long]),
            buffersAlloc = json.\("buffers_alloc").toOption.map(_.as[Long]),
            statsReset = json.\("stats_reset").toOption.map(_.as[ZonedDateTime])
          )
        )
      )
    }
  }
}
