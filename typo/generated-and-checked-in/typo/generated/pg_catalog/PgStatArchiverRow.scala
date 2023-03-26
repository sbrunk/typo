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

case class PgStatArchiverRow(
  archivedCount: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_archiver","column_name":"archived_count","ordinal_position":1,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  lastArchivedWal: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_archiver","column_name":"last_archived_wal","ordinal_position":2,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  lastArchivedTime: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_archiver","column_name":"last_archived_time","ordinal_position":3,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  failedCount: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_archiver","column_name":"failed_count","ordinal_position":4,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  lastFailedWal: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_archiver","column_name":"last_failed_wal","ordinal_position":5,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  lastFailedTime: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_archiver","column_name":"last_failed_time","ordinal_position":6,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  statsReset: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_archiver","column_name":"stats_reset","ordinal_position":7,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatArchiverRow {
  def rowParser(prefix: String): RowParser[PgStatArchiverRow] = { row =>
    Success(
      PgStatArchiverRow(
        archivedCount = row[Option[Long]](prefix + "archived_count"),
        lastArchivedWal = row[Option[String]](prefix + "last_archived_wal"),
        lastArchivedTime = row[Option[ZonedDateTime]](prefix + "last_archived_time"),
        failedCount = row[Option[Long]](prefix + "failed_count"),
        lastFailedWal = row[Option[String]](prefix + "last_failed_wal"),
        lastFailedTime = row[Option[ZonedDateTime]](prefix + "last_failed_time"),
        statsReset = row[Option[ZonedDateTime]](prefix + "stats_reset")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatArchiverRow] = new OFormat[PgStatArchiverRow]{
    override def writes(o: PgStatArchiverRow): JsObject =
      Json.obj(
        "archived_count" -> o.archivedCount,
      "last_archived_wal" -> o.lastArchivedWal,
      "last_archived_time" -> o.lastArchivedTime,
      "failed_count" -> o.failedCount,
      "last_failed_wal" -> o.lastFailedWal,
      "last_failed_time" -> o.lastFailedTime,
      "stats_reset" -> o.statsReset
      )

    override def reads(json: JsValue): JsResult[PgStatArchiverRow] = {
      JsResult.fromTry(
        Try(
          PgStatArchiverRow(
            archivedCount = json.\("archived_count").toOption.map(_.as[Long]),
            lastArchivedWal = json.\("last_archived_wal").toOption.map(_.as[String]),
            lastArchivedTime = json.\("last_archived_time").toOption.map(_.as[ZonedDateTime]),
            failedCount = json.\("failed_count").toOption.map(_.as[Long]),
            lastFailedWal = json.\("last_failed_wal").toOption.map(_.as[String]),
            lastFailedTime = json.\("last_failed_time").toOption.map(_.as[ZonedDateTime]),
            statsReset = json.\("stats_reset").toOption.map(_.as[ZonedDateTime])
          )
        )
      )
    }
  }
}
