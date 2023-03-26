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

case class PgTablesRow(
  schemaname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_tables","column_name":"schemaname","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tablename: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_tables","column_name":"tablename","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tableowner: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_tables","column_name":"tableowner","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tablespace: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_tables","column_name":"tablespace","ordinal_position":4,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  hasindexes: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_tables","column_name":"hasindexes","ordinal_position":5,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  hasrules: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_tables","column_name":"hasrules","ordinal_position":6,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  hastriggers: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_tables","column_name":"hastriggers","ordinal_position":7,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rowsecurity: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_tables","column_name":"rowsecurity","ordinal_position":8,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgTablesRow {
  def rowParser(prefix: String): RowParser[PgTablesRow] = { row =>
    Success(
      PgTablesRow(
        schemaname = row[Option[String]](prefix + "schemaname"),
        tablename = row[Option[String]](prefix + "tablename"),
        tableowner = row[Option[String]](prefix + "tableowner"),
        tablespace = row[Option[String]](prefix + "tablespace"),
        hasindexes = row[Option[Boolean]](prefix + "hasindexes"),
        hasrules = row[Option[Boolean]](prefix + "hasrules"),
        hastriggers = row[Option[Boolean]](prefix + "hastriggers"),
        rowsecurity = row[Option[Boolean]](prefix + "rowsecurity")
      )
    )
  }

  implicit val oFormat: OFormat[PgTablesRow] = new OFormat[PgTablesRow]{
    override def writes(o: PgTablesRow): JsObject =
      Json.obj(
        "schemaname" -> o.schemaname,
      "tablename" -> o.tablename,
      "tableowner" -> o.tableowner,
      "tablespace" -> o.tablespace,
      "hasindexes" -> o.hasindexes,
      "hasrules" -> o.hasrules,
      "hastriggers" -> o.hastriggers,
      "rowsecurity" -> o.rowsecurity
      )

    override def reads(json: JsValue): JsResult[PgTablesRow] = {
      JsResult.fromTry(
        Try(
          PgTablesRow(
            schemaname = json.\("schemaname").toOption.map(_.as[String]),
            tablename = json.\("tablename").toOption.map(_.as[String]),
            tableowner = json.\("tableowner").toOption.map(_.as[String]),
            tablespace = json.\("tablespace").toOption.map(_.as[String]),
            hasindexes = json.\("hasindexes").toOption.map(_.as[Boolean]),
            hasrules = json.\("hasrules").toOption.map(_.as[Boolean]),
            hastriggers = json.\("hastriggers").toOption.map(_.as[Boolean]),
            rowsecurity = json.\("rowsecurity").toOption.map(_.as[Boolean])
          )
        )
      )
    }
  }
}
