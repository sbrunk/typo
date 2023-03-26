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
import java.time.ZonedDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgRolesRow(
  rolname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"rolname","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rolsuper: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"rolsuper","ordinal_position":2,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rolinherit: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"rolinherit","ordinal_position":3,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rolcreaterole: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"rolcreaterole","ordinal_position":4,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rolcreatedb: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"rolcreatedb","ordinal_position":5,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rolcanlogin: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"rolcanlogin","ordinal_position":6,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rolreplication: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"rolreplication","ordinal_position":7,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rolconnlimit: Option[Int] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"rolconnlimit","ordinal_position":8,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rolpassword: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"rolpassword","ordinal_position":9,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rolvaliduntil: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"rolvaliduntil","ordinal_position":10,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rolbypassrls: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"rolbypassrls","ordinal_position":11,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  rolconfig: Option[Array[String]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"rolconfig","ordinal_position":12,"is_nullable":"YES","data_type":"ARRAY","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_text","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  oid: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_roles","column_name":"oid","ordinal_position":13,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgRolesRow {
  def rowParser(prefix: String): RowParser[PgRolesRow] = { row =>
    Success(
      PgRolesRow(
        rolname = row[Option[String]](prefix + "rolname"),
        rolsuper = row[Option[Boolean]](prefix + "rolsuper"),
        rolinherit = row[Option[Boolean]](prefix + "rolinherit"),
        rolcreaterole = row[Option[Boolean]](prefix + "rolcreaterole"),
        rolcreatedb = row[Option[Boolean]](prefix + "rolcreatedb"),
        rolcanlogin = row[Option[Boolean]](prefix + "rolcanlogin"),
        rolreplication = row[Option[Boolean]](prefix + "rolreplication"),
        rolconnlimit = row[Option[Int]](prefix + "rolconnlimit"),
        rolpassword = row[Option[String]](prefix + "rolpassword"),
        rolvaliduntil = row[Option[ZonedDateTime]](prefix + "rolvaliduntil"),
        rolbypassrls = row[Option[Boolean]](prefix + "rolbypassrls"),
        rolconfig = row[Option[Array[String]]](prefix + "rolconfig"),
        oid = row[Option[/* oid */ Long]](prefix + "oid")
      )
    )
  }

  implicit val oFormat: OFormat[PgRolesRow] = new OFormat[PgRolesRow]{
    override def writes(o: PgRolesRow): JsObject =
      Json.obj(
        "rolname" -> o.rolname,
      "rolsuper" -> o.rolsuper,
      "rolinherit" -> o.rolinherit,
      "rolcreaterole" -> o.rolcreaterole,
      "rolcreatedb" -> o.rolcreatedb,
      "rolcanlogin" -> o.rolcanlogin,
      "rolreplication" -> o.rolreplication,
      "rolconnlimit" -> o.rolconnlimit,
      "rolpassword" -> o.rolpassword,
      "rolvaliduntil" -> o.rolvaliduntil,
      "rolbypassrls" -> o.rolbypassrls,
      "rolconfig" -> o.rolconfig,
      "oid" -> o.oid
      )

    override def reads(json: JsValue): JsResult[PgRolesRow] = {
      JsResult.fromTry(
        Try(
          PgRolesRow(
            rolname = json.\("rolname").toOption.map(_.as[String]),
            rolsuper = json.\("rolsuper").toOption.map(_.as[Boolean]),
            rolinherit = json.\("rolinherit").toOption.map(_.as[Boolean]),
            rolcreaterole = json.\("rolcreaterole").toOption.map(_.as[Boolean]),
            rolcreatedb = json.\("rolcreatedb").toOption.map(_.as[Boolean]),
            rolcanlogin = json.\("rolcanlogin").toOption.map(_.as[Boolean]),
            rolreplication = json.\("rolreplication").toOption.map(_.as[Boolean]),
            rolconnlimit = json.\("rolconnlimit").toOption.map(_.as[Int]),
            rolpassword = json.\("rolpassword").toOption.map(_.as[String]),
            rolvaliduntil = json.\("rolvaliduntil").toOption.map(_.as[ZonedDateTime]),
            rolbypassrls = json.\("rolbypassrls").toOption.map(_.as[Boolean]),
            rolconfig = json.\("rolconfig").toOption.map(_.as[Array[String]]),
            oid = json.\("oid").toOption.map(_.as[/* oid */ Long])
          )
        )
      )
    }
  }
}
