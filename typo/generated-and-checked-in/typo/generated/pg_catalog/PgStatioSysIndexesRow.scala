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

case class PgStatioSysIndexesRow(
  relid: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_indexes","column_name":"relid","ordinal_position":1,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  indexrelid: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_indexes","column_name":"indexrelid","ordinal_position":2,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  schemaname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_indexes","column_name":"schemaname","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  relname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_indexes","column_name":"relname","ordinal_position":4,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  indexrelname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_indexes","column_name":"indexrelname","ordinal_position":5,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  idxBlksRead: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_indexes","column_name":"idx_blks_read","ordinal_position":6,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  idxBlksHit: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_statio_sys_indexes","column_name":"idx_blks_hit","ordinal_position":7,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatioSysIndexesRow {
  def rowParser(prefix: String): RowParser[PgStatioSysIndexesRow] = { row =>
    Success(
      PgStatioSysIndexesRow(
        relid = row[Option[/* oid */ Long]](prefix + "relid"),
        indexrelid = row[Option[/* oid */ Long]](prefix + "indexrelid"),
        schemaname = row[Option[String]](prefix + "schemaname"),
        relname = row[Option[String]](prefix + "relname"),
        indexrelname = row[Option[String]](prefix + "indexrelname"),
        idxBlksRead = row[Option[Long]](prefix + "idx_blks_read"),
        idxBlksHit = row[Option[Long]](prefix + "idx_blks_hit")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatioSysIndexesRow] = new OFormat[PgStatioSysIndexesRow]{
    override def writes(o: PgStatioSysIndexesRow): JsObject =
      Json.obj(
        "relid" -> o.relid,
      "indexrelid" -> o.indexrelid,
      "schemaname" -> o.schemaname,
      "relname" -> o.relname,
      "indexrelname" -> o.indexrelname,
      "idx_blks_read" -> o.idxBlksRead,
      "idx_blks_hit" -> o.idxBlksHit
      )

    override def reads(json: JsValue): JsResult[PgStatioSysIndexesRow] = {
      JsResult.fromTry(
        Try(
          PgStatioSysIndexesRow(
            relid = json.\("relid").toOption.map(_.as[/* oid */ Long]),
            indexrelid = json.\("indexrelid").toOption.map(_.as[/* oid */ Long]),
            schemaname = json.\("schemaname").toOption.map(_.as[String]),
            relname = json.\("relname").toOption.map(_.as[String]),
            indexrelname = json.\("indexrelname").toOption.map(_.as[String]),
            idxBlksRead = json.\("idx_blks_read").toOption.map(_.as[Long]),
            idxBlksHit = json.\("idx_blks_hit").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}
