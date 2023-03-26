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

case class PgGroupRow(
  groname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_group","column_name":"groname","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  grosysid: Option[/* oid */ Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_group","column_name":"grosysid","ordinal_position":2,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  grolist: Option[Array[/* oid */ Long]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_group","column_name":"grolist","ordinal_position":3,"is_nullable":"YES","data_type":"ARRAY","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_oid","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgGroupRow {
  def rowParser(prefix: String): RowParser[PgGroupRow] = { row =>
    Success(
      PgGroupRow(
        groname = row[Option[String]](prefix + "groname"),
        grosysid = row[Option[/* oid */ Long]](prefix + "grosysid"),
        grolist = row[Option[Array[/* oid */ Long]]](prefix + "grolist")
      )
    )
  }

  implicit val oFormat: OFormat[PgGroupRow] = new OFormat[PgGroupRow]{
    override def writes(o: PgGroupRow): JsObject =
      Json.obj(
        "groname" -> o.groname,
      "grosysid" -> o.grosysid,
      "grolist" -> o.grolist
      )

    override def reads(json: JsValue): JsResult[PgGroupRow] = {
      JsResult.fromTry(
        Try(
          PgGroupRow(
            groname = json.\("groname").toOption.map(_.as[String]),
            grosysid = json.\("grosysid").toOption.map(_.as[/* oid */ Long]),
            grolist = json.\("grolist").toOption.map(_.as[Array[/* oid */ Long]])
          )
        )
      )
    }
  }
}
