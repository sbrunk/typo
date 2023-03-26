/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ForeignTablesRow(
  foreignTableCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"foreign_tables","column_name":"foreign_table_catalog","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  foreignTableSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"foreign_tables","column_name":"foreign_table_schema","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  foreignTableName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"foreign_tables","column_name":"foreign_table_name","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  foreignServerCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"foreign_tables","column_name":"foreign_server_catalog","ordinal_position":4,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  foreignServerName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"foreign_tables","column_name":"foreign_server_name","ordinal_position":5,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object ForeignTablesRow {
  def rowParser(prefix: String): RowParser[ForeignTablesRow] = { row =>
    Success(
      ForeignTablesRow(
        foreignTableCatalog = row[Option[String]](prefix + "foreign_table_catalog"),
        foreignTableSchema = row[Option[String]](prefix + "foreign_table_schema"),
        foreignTableName = row[Option[String]](prefix + "foreign_table_name"),
        foreignServerCatalog = row[Option[String]](prefix + "foreign_server_catalog"),
        foreignServerName = row[Option[String]](prefix + "foreign_server_name")
      )
    )
  }

  implicit val oFormat: OFormat[ForeignTablesRow] = new OFormat[ForeignTablesRow]{
    override def writes(o: ForeignTablesRow): JsObject =
      Json.obj(
        "foreign_table_catalog" -> o.foreignTableCatalog,
      "foreign_table_schema" -> o.foreignTableSchema,
      "foreign_table_name" -> o.foreignTableName,
      "foreign_server_catalog" -> o.foreignServerCatalog,
      "foreign_server_name" -> o.foreignServerName
      )

    override def reads(json: JsValue): JsResult[ForeignTablesRow] = {
      JsResult.fromTry(
        Try(
          ForeignTablesRow(
            foreignTableCatalog = json.\("foreign_table_catalog").toOption.map(_.as[String]),
            foreignTableSchema = json.\("foreign_table_schema").toOption.map(_.as[String]),
            foreignTableName = json.\("foreign_table_name").toOption.map(_.as[String]),
            foreignServerCatalog = json.\("foreign_server_catalog").toOption.map(_.as[String]),
            foreignServerName = json.\("foreign_server_name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
