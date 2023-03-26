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

case class PgUserRow(
  usename: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user","column_name":"usename","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  usesysid: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user","column_name":"usesysid","ordinal_position":2,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  usecreatedb: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user","column_name":"usecreatedb","ordinal_position":3,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  usesuper: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user","column_name":"usesuper","ordinal_position":4,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  userepl: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user","column_name":"userepl","ordinal_position":5,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  usebypassrls: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user","column_name":"usebypassrls","ordinal_position":6,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  passwd: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user","column_name":"passwd","ordinal_position":7,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  valuntil: Option[ZonedDateTime] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user","column_name":"valuntil","ordinal_position":8,"is_nullable":"YES","data_type":"timestamp with time zone","datetime_precision":6,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"timestamptz","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  useconfig: Option[Array[String]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user","column_name":"useconfig","ordinal_position":9,"is_nullable":"YES","data_type":"ARRAY","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_text","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgUserRow {
  def rowParser(prefix: String): RowParser[PgUserRow] = { row =>
    Success(
      PgUserRow(
        usename = row[Option[String]](prefix + "usename"),
        usesysid = row[Option[/* oid */ Long]](prefix + "usesysid"),
        usecreatedb = row[Option[Boolean]](prefix + "usecreatedb"),
        usesuper = row[Option[Boolean]](prefix + "usesuper"),
        userepl = row[Option[Boolean]](prefix + "userepl"),
        usebypassrls = row[Option[Boolean]](prefix + "usebypassrls"),
        passwd = row[Option[String]](prefix + "passwd"),
        valuntil = row[Option[ZonedDateTime]](prefix + "valuntil"),
        useconfig = row[Option[Array[String]]](prefix + "useconfig")
      )
    )
  }

  implicit val oFormat: OFormat[PgUserRow] = new OFormat[PgUserRow]{
    override def writes(o: PgUserRow): JsObject =
      Json.obj(
        "usename" -> o.usename,
      "usesysid" -> o.usesysid,
      "usecreatedb" -> o.usecreatedb,
      "usesuper" -> o.usesuper,
      "userepl" -> o.userepl,
      "usebypassrls" -> o.usebypassrls,
      "passwd" -> o.passwd,
      "valuntil" -> o.valuntil,
      "useconfig" -> o.useconfig
      )

    override def reads(json: JsValue): JsResult[PgUserRow] = {
      JsResult.fromTry(
        Try(
          PgUserRow(
            usename = json.\("usename").toOption.map(_.as[String]),
            usesysid = json.\("usesysid").toOption.map(_.as[/* oid */ Long]),
            usecreatedb = json.\("usecreatedb").toOption.map(_.as[Boolean]),
            usesuper = json.\("usesuper").toOption.map(_.as[Boolean]),
            userepl = json.\("userepl").toOption.map(_.as[Boolean]),
            usebypassrls = json.\("usebypassrls").toOption.map(_.as[Boolean]),
            passwd = json.\("passwd").toOption.map(_.as[String]),
            valuntil = json.\("valuntil").toOption.map(_.as[ZonedDateTime]),
            useconfig = json.\("useconfig").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
