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

case class PgStatioSysTablesRow(
  relid: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_tables","column_name":"relid","ordinal_position":1,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  schemaname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_tables","column_name":"schemaname","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  relname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_tables","column_name":"relname","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  heapBlksRead: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_tables","column_name":"heap_blks_read","ordinal_position":4,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  heapBlksHit: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_tables","column_name":"heap_blks_hit","ordinal_position":5,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  idxBlksRead: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_tables","column_name":"idx_blks_read","ordinal_position":6,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  idxBlksHit: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_tables","column_name":"idx_blks_hit","ordinal_position":7,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  toastBlksRead: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_tables","column_name":"toast_blks_read","ordinal_position":8,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  toastBlksHit: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_tables","column_name":"toast_blks_hit","ordinal_position":9,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tidxBlksRead: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_tables","column_name":"tidx_blks_read","ordinal_position":10,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tidxBlksHit: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_tables","column_name":"tidx_blks_hit","ordinal_position":11,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatioSysTablesRow {
  def rowParser(prefix: String): RowParser[PgStatioSysTablesRow] = { row =>
    Success(
      PgStatioSysTablesRow(
        relid = row[Option[Long]](prefix + "relid"),
        schemaname = row[Option[String]](prefix + "schemaname"),
        relname = row[Option[String]](prefix + "relname"),
        heapBlksRead = row[Option[Long]](prefix + "heap_blks_read"),
        heapBlksHit = row[Option[Long]](prefix + "heap_blks_hit"),
        idxBlksRead = row[Option[Long]](prefix + "idx_blks_read"),
        idxBlksHit = row[Option[Long]](prefix + "idx_blks_hit"),
        toastBlksRead = row[Option[Long]](prefix + "toast_blks_read"),
        toastBlksHit = row[Option[Long]](prefix + "toast_blks_hit"),
        tidxBlksRead = row[Option[Long]](prefix + "tidx_blks_read"),
        tidxBlksHit = row[Option[Long]](prefix + "tidx_blks_hit")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatioSysTablesRow] = new OFormat[PgStatioSysTablesRow]{
    override def writes(o: PgStatioSysTablesRow): JsObject =
      Json.obj(
        "relid" -> o.relid,
      "schemaname" -> o.schemaname,
      "relname" -> o.relname,
      "heap_blks_read" -> o.heapBlksRead,
      "heap_blks_hit" -> o.heapBlksHit,
      "idx_blks_read" -> o.idxBlksRead,
      "idx_blks_hit" -> o.idxBlksHit,
      "toast_blks_read" -> o.toastBlksRead,
      "toast_blks_hit" -> o.toastBlksHit,
      "tidx_blks_read" -> o.tidxBlksRead,
      "tidx_blks_hit" -> o.tidxBlksHit
      )

    override def reads(json: JsValue): JsResult[PgStatioSysTablesRow] = {
      JsResult.fromTry(
        Try(
          PgStatioSysTablesRow(
            relid = json.\("relid").toOption.map(_.as[Long]),
            schemaname = json.\("schemaname").toOption.map(_.as[String]),
            relname = json.\("relname").toOption.map(_.as[String]),
            heapBlksRead = json.\("heap_blks_read").toOption.map(_.as[Long]),
            heapBlksHit = json.\("heap_blks_hit").toOption.map(_.as[Long]),
            idxBlksRead = json.\("idx_blks_read").toOption.map(_.as[Long]),
            idxBlksHit = json.\("idx_blks_hit").toOption.map(_.as[Long]),
            toastBlksRead = json.\("toast_blks_read").toOption.map(_.as[Long]),
            toastBlksHit = json.\("toast_blks_hit").toOption.map(_.as[Long]),
            tidxBlksRead = json.\("tidx_blks_read").toOption.map(_.as[Long]),
            tidxBlksHit = json.\("tidx_blks_hit").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}
