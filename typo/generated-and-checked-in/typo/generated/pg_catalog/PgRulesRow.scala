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

case class PgRulesRow(
  schemaname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_rules","column_name":"schemaname","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  tablename: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_rules","column_name":"tablename","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rulename: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_rules","column_name":"rulename","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  definition: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_rules","column_name":"definition","ordinal_position":4,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgRulesRow {
  def rowParser(prefix: String): RowParser[PgRulesRow] = { row =>
    Success(
      PgRulesRow(
        schemaname = row[Option[String]](prefix + "schemaname"),
        tablename = row[Option[String]](prefix + "tablename"),
        rulename = row[Option[String]](prefix + "rulename"),
        definition = row[Option[String]](prefix + "definition")
      )
    )
  }

  implicit val oFormat: OFormat[PgRulesRow] = new OFormat[PgRulesRow]{
    override def writes(o: PgRulesRow): JsObject =
      Json.obj(
        "schemaname" -> o.schemaname,
      "tablename" -> o.tablename,
      "rulename" -> o.rulename,
      "definition" -> o.definition
      )

    override def reads(json: JsValue): JsResult[PgRulesRow] = {
      JsResult.fromTry(
        Try(
          PgRulesRow(
            schemaname = json.\("schemaname").toOption.map(_.as[String]),
            tablename = json.\("tablename").toOption.map(_.as[String]),
            rulename = json.\("rulename").toOption.map(_.as[String]),
            definition = json.\("definition").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
