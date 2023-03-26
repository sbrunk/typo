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

case class PgHbaFileRulesRow(
  lineNumber: Option[Int] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_hba_file_rules","column_name":"line_number","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  `type`: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_hba_file_rules","column_name":"type","ordinal_position":2,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  database: Option[Array[String]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_hba_file_rules","column_name":"database","ordinal_position":3,"is_nullable":"YES","data_type":"ARRAY","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_text","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  userName: Option[Array[String]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_hba_file_rules","column_name":"user_name","ordinal_position":4,"is_nullable":"YES","data_type":"ARRAY","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_text","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  address: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_hba_file_rules","column_name":"address","ordinal_position":5,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  netmask: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_hba_file_rules","column_name":"netmask","ordinal_position":6,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  authMethod: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_hba_file_rules","column_name":"auth_method","ordinal_position":7,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  options: Option[Array[String]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_hba_file_rules","column_name":"options","ordinal_position":8,"is_nullable":"YES","data_type":"ARRAY","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_text","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  error: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_hba_file_rules","column_name":"error","ordinal_position":9,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgHbaFileRulesRow {
  def rowParser(prefix: String): RowParser[PgHbaFileRulesRow] = { row =>
    Success(
      PgHbaFileRulesRow(
        lineNumber = row[Option[Int]](prefix + "line_number"),
        `type` = row[Option[String]](prefix + "type"),
        database = row[Option[Array[String]]](prefix + "database"),
        userName = row[Option[Array[String]]](prefix + "user_name"),
        address = row[Option[String]](prefix + "address"),
        netmask = row[Option[String]](prefix + "netmask"),
        authMethod = row[Option[String]](prefix + "auth_method"),
        options = row[Option[Array[String]]](prefix + "options"),
        error = row[Option[String]](prefix + "error")
      )
    )
  }

  implicit val oFormat: OFormat[PgHbaFileRulesRow] = new OFormat[PgHbaFileRulesRow]{
    override def writes(o: PgHbaFileRulesRow): JsObject =
      Json.obj(
        "line_number" -> o.lineNumber,
      "type" -> o.`type`,
      "database" -> o.database,
      "user_name" -> o.userName,
      "address" -> o.address,
      "netmask" -> o.netmask,
      "auth_method" -> o.authMethod,
      "options" -> o.options,
      "error" -> o.error
      )

    override def reads(json: JsValue): JsResult[PgHbaFileRulesRow] = {
      JsResult.fromTry(
        Try(
          PgHbaFileRulesRow(
            lineNumber = json.\("line_number").toOption.map(_.as[Int]),
            `type` = json.\("type").toOption.map(_.as[String]),
            database = json.\("database").toOption.map(_.as[Array[String]]),
            userName = json.\("user_name").toOption.map(_.as[Array[String]]),
            address = json.\("address").toOption.map(_.as[String]),
            netmask = json.\("netmask").toOption.map(_.as[String]),
            authMethod = json.\("auth_method").toOption.map(_.as[String]),
            options = json.\("options").toOption.map(_.as[Array[String]]),
            error = json.\("error").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
