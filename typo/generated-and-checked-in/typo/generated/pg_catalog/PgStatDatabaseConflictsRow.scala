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

case class PgStatDatabaseConflictsRow(
  datid: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database_conflicts","column_name":"datid","ordinal_position":1,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  datname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database_conflicts","column_name":"datname","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  conflTablespace: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database_conflicts","column_name":"confl_tablespace","ordinal_position":3,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  conflLock: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database_conflicts","column_name":"confl_lock","ordinal_position":4,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  conflSnapshot: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database_conflicts","column_name":"confl_snapshot","ordinal_position":5,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  conflBufferpin: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database_conflicts","column_name":"confl_bufferpin","ordinal_position":6,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  conflDeadlock: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_database_conflicts","column_name":"confl_deadlock","ordinal_position":7,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatDatabaseConflictsRow {
  def rowParser(prefix: String): RowParser[PgStatDatabaseConflictsRow] = { row =>
    Success(
      PgStatDatabaseConflictsRow(
        datid = row[Option[/* oid */ Long]](prefix + "datid"),
        datname = row[Option[String]](prefix + "datname"),
        conflTablespace = row[Option[Long]](prefix + "confl_tablespace"),
        conflLock = row[Option[Long]](prefix + "confl_lock"),
        conflSnapshot = row[Option[Long]](prefix + "confl_snapshot"),
        conflBufferpin = row[Option[Long]](prefix + "confl_bufferpin"),
        conflDeadlock = row[Option[Long]](prefix + "confl_deadlock")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatDatabaseConflictsRow] = new OFormat[PgStatDatabaseConflictsRow]{
    override def writes(o: PgStatDatabaseConflictsRow): JsObject =
      Json.obj(
        "datid" -> o.datid,
      "datname" -> o.datname,
      "confl_tablespace" -> o.conflTablespace,
      "confl_lock" -> o.conflLock,
      "confl_snapshot" -> o.conflSnapshot,
      "confl_bufferpin" -> o.conflBufferpin,
      "confl_deadlock" -> o.conflDeadlock
      )

    override def reads(json: JsValue): JsResult[PgStatDatabaseConflictsRow] = {
      JsResult.fromTry(
        Try(
          PgStatDatabaseConflictsRow(
            datid = json.\("datid").toOption.map(_.as[/* oid */ Long]),
            datname = json.\("datname").toOption.map(_.as[String]),
            conflTablespace = json.\("confl_tablespace").toOption.map(_.as[Long]),
            conflLock = json.\("confl_lock").toOption.map(_.as[Long]),
            conflSnapshot = json.\("confl_snapshot").toOption.map(_.as[Long]),
            conflBufferpin = json.\("confl_bufferpin").toOption.map(_.as[Long]),
            conflDeadlock = json.\("confl_deadlock").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}
