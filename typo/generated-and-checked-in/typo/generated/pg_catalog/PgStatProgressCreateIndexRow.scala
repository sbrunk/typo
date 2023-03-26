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

case class PgStatProgressCreateIndexRow(
  pid: Option[Int] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"pid","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  datid: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"datid","ordinal_position":2,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  datname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"datname","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  relid: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"relid","ordinal_position":4,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  indexRelid: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"index_relid","ordinal_position":5,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  command: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"command","ordinal_position":6,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  phase: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"phase","ordinal_position":7,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  lockersTotal: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"lockers_total","ordinal_position":8,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  lockersDone: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"lockers_done","ordinal_position":9,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  currentLockerPid: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"current_locker_pid","ordinal_position":10,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  blocksTotal: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"blocks_total","ordinal_position":11,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  blocksDone: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"blocks_done","ordinal_position":12,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tuplesTotal: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"tuples_total","ordinal_position":13,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tuplesDone: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"tuples_done","ordinal_position":14,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  partitionsTotal: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"partitions_total","ordinal_position":15,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  partitionsDone: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_progress_create_index","column_name":"partitions_done","ordinal_position":16,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatProgressCreateIndexRow {
  def rowParser(prefix: String): RowParser[PgStatProgressCreateIndexRow] = { row =>
    Success(
      PgStatProgressCreateIndexRow(
        pid = row[Option[Int]](prefix + "pid"),
        datid = row[Option[Long]](prefix + "datid"),
        datname = row[Option[String]](prefix + "datname"),
        relid = row[Option[Long]](prefix + "relid"),
        indexRelid = row[Option[Long]](prefix + "index_relid"),
        command = row[Option[String]](prefix + "command"),
        phase = row[Option[String]](prefix + "phase"),
        lockersTotal = row[Option[Long]](prefix + "lockers_total"),
        lockersDone = row[Option[Long]](prefix + "lockers_done"),
        currentLockerPid = row[Option[Long]](prefix + "current_locker_pid"),
        blocksTotal = row[Option[Long]](prefix + "blocks_total"),
        blocksDone = row[Option[Long]](prefix + "blocks_done"),
        tuplesTotal = row[Option[Long]](prefix + "tuples_total"),
        tuplesDone = row[Option[Long]](prefix + "tuples_done"),
        partitionsTotal = row[Option[Long]](prefix + "partitions_total"),
        partitionsDone = row[Option[Long]](prefix + "partitions_done")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatProgressCreateIndexRow] = new OFormat[PgStatProgressCreateIndexRow]{
    override def writes(o: PgStatProgressCreateIndexRow): JsObject =
      Json.obj(
        "pid" -> o.pid,
      "datid" -> o.datid,
      "datname" -> o.datname,
      "relid" -> o.relid,
      "index_relid" -> o.indexRelid,
      "command" -> o.command,
      "phase" -> o.phase,
      "lockers_total" -> o.lockersTotal,
      "lockers_done" -> o.lockersDone,
      "current_locker_pid" -> o.currentLockerPid,
      "blocks_total" -> o.blocksTotal,
      "blocks_done" -> o.blocksDone,
      "tuples_total" -> o.tuplesTotal,
      "tuples_done" -> o.tuplesDone,
      "partitions_total" -> o.partitionsTotal,
      "partitions_done" -> o.partitionsDone
      )

    override def reads(json: JsValue): JsResult[PgStatProgressCreateIndexRow] = {
      JsResult.fromTry(
        Try(
          PgStatProgressCreateIndexRow(
            pid = json.\("pid").toOption.map(_.as[Int]),
            datid = json.\("datid").toOption.map(_.as[Long]),
            datname = json.\("datname").toOption.map(_.as[String]),
            relid = json.\("relid").toOption.map(_.as[Long]),
            indexRelid = json.\("index_relid").toOption.map(_.as[Long]),
            command = json.\("command").toOption.map(_.as[String]),
            phase = json.\("phase").toOption.map(_.as[String]),
            lockersTotal = json.\("lockers_total").toOption.map(_.as[Long]),
            lockersDone = json.\("lockers_done").toOption.map(_.as[Long]),
            currentLockerPid = json.\("current_locker_pid").toOption.map(_.as[Long]),
            blocksTotal = json.\("blocks_total").toOption.map(_.as[Long]),
            blocksDone = json.\("blocks_done").toOption.map(_.as[Long]),
            tuplesTotal = json.\("tuples_total").toOption.map(_.as[Long]),
            tuplesDone = json.\("tuples_done").toOption.map(_.as[Long]),
            partitionsTotal = json.\("partitions_total").toOption.map(_.as[Long]),
            partitionsDone = json.\("partitions_done").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}
