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

case class AdministrableRoleAuthorizationsRow(
  grantee: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"administrable_role_authorizations","column_name":"grantee","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  roleName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"administrable_role_authorizations","column_name":"role_name","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  isGrantable: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"administrable_role_authorizations","column_name":"is_grantable","ordinal_position":3,"is_nullable":"YES","data_type":"character varying","character_maximum_length":3,"character_octet_length":12,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"yes_or_no","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object AdministrableRoleAuthorizationsRow {
  def rowParser(prefix: String): RowParser[AdministrableRoleAuthorizationsRow] = { row =>
    Success(
      AdministrableRoleAuthorizationsRow(
        grantee = row[Option[String]](prefix + "grantee"),
        roleName = row[Option[String]](prefix + "role_name"),
        isGrantable = row[Option[String]](prefix + "is_grantable")
      )
    )
  }

  implicit val oFormat: OFormat[AdministrableRoleAuthorizationsRow] = new OFormat[AdministrableRoleAuthorizationsRow]{
    override def writes(o: AdministrableRoleAuthorizationsRow): JsObject =
      Json.obj(
        "grantee" -> o.grantee,
      "role_name" -> o.roleName,
      "is_grantable" -> o.isGrantable
      )

    override def reads(json: JsValue): JsResult[AdministrableRoleAuthorizationsRow] = {
      JsResult.fromTry(
        Try(
          AdministrableRoleAuthorizationsRow(
            grantee = json.\("grantee").toOption.map(_.as[String]),
            roleName = json.\("role_name").toOption.map(_.as[String]),
            isGrantable = json.\("is_grantable").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
