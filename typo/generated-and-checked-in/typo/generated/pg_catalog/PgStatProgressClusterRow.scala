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

case class PgStatProgressClusterRow(
  pid: Option[Int] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_cluster","column_name":"pid","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  datid: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_cluster","column_name":"datid","ordinal_position":2,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  datname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_cluster","column_name":"datname","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  relid: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_cluster","column_name":"relid","ordinal_position":4,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  command: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_cluster","column_name":"command","ordinal_position":5,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  phase: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_cluster","column_name":"phase","ordinal_position":6,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  clusterIndexRelid: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_cluster","column_name":"cluster_index_relid","ordinal_position":7,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  heapTuplesScanned: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_cluster","column_name":"heap_tuples_scanned","ordinal_position":8,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  heapTuplesWritten: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_cluster","column_name":"heap_tuples_written","ordinal_position":9,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  heapBlksTotal: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_cluster","column_name":"heap_blks_total","ordinal_position":10,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  heapBlksScanned: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_cluster","column_name":"heap_blks_scanned","ordinal_position":11,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  indexRebuildCount: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_cluster","column_name":"index_rebuild_count","ordinal_position":12,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatProgressClusterRow {
  def rowParser(prefix: String): RowParser[PgStatProgressClusterRow] = { row =>
    Success(
      PgStatProgressClusterRow(
        pid = row[Option[Int]](prefix + "pid"),
        datid = row[Option[/* oid */ Long]](prefix + "datid"),
        datname = row[Option[String]](prefix + "datname"),
        relid = row[Option[/* oid */ Long]](prefix + "relid"),
        command = row[Option[String]](prefix + "command"),
        phase = row[Option[String]](prefix + "phase"),
        clusterIndexRelid = row[Option[/* oid */ Long]](prefix + "cluster_index_relid"),
        heapTuplesScanned = row[Option[Long]](prefix + "heap_tuples_scanned"),
        heapTuplesWritten = row[Option[Long]](prefix + "heap_tuples_written"),
        heapBlksTotal = row[Option[Long]](prefix + "heap_blks_total"),
        heapBlksScanned = row[Option[Long]](prefix + "heap_blks_scanned"),
        indexRebuildCount = row[Option[Long]](prefix + "index_rebuild_count")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatProgressClusterRow] = new OFormat[PgStatProgressClusterRow]{
    override def writes(o: PgStatProgressClusterRow): JsObject =
      Json.obj(
        "pid" -> o.pid,
      "datid" -> o.datid,
      "datname" -> o.datname,
      "relid" -> o.relid,
      "command" -> o.command,
      "phase" -> o.phase,
      "cluster_index_relid" -> o.clusterIndexRelid,
      "heap_tuples_scanned" -> o.heapTuplesScanned,
      "heap_tuples_written" -> o.heapTuplesWritten,
      "heap_blks_total" -> o.heapBlksTotal,
      "heap_blks_scanned" -> o.heapBlksScanned,
      "index_rebuild_count" -> o.indexRebuildCount
      )

    override def reads(json: JsValue): JsResult[PgStatProgressClusterRow] = {
      JsResult.fromTry(
        Try(
          PgStatProgressClusterRow(
            pid = json.\("pid").toOption.map(_.as[Int]),
            datid = json.\("datid").toOption.map(_.as[/* oid */ Long]),
            datname = json.\("datname").toOption.map(_.as[String]),
            relid = json.\("relid").toOption.map(_.as[/* oid */ Long]),
            command = json.\("command").toOption.map(_.as[String]),
            phase = json.\("phase").toOption.map(_.as[String]),
            clusterIndexRelid = json.\("cluster_index_relid").toOption.map(_.as[/* oid */ Long]),
            heapTuplesScanned = json.\("heap_tuples_scanned").toOption.map(_.as[Long]),
            heapTuplesWritten = json.\("heap_tuples_written").toOption.map(_.as[Long]),
            heapBlksTotal = json.\("heap_blks_total").toOption.map(_.as[Long]),
            heapBlksScanned = json.\("heap_blks_scanned").toOption.map(_.as[Long]),
            indexRebuildCount = json.\("index_rebuild_count").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}
