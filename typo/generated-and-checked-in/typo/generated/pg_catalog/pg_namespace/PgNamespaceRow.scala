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
package pg_namespace

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try
import typo.generated.TypoAclItem

case class PgNamespaceRow(
  /** debug: {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_namespace","column_name":"oid","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  oid: PgNamespaceId,
  /** debug: {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_namespace","column_name":"nspname","ordinal_position":2,"is_nullable":"NO","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  nspname: String,
  /** debug: {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_namespace","column_name":"nspowner","ordinal_position":3,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  nspowner: /* oid */ Long,
  /** debug: {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_namespace","column_name":"nspacl","ordinal_position":4,"is_nullable":"YES","data_type":"ARRAY","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_aclitem","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  nspacl: Option[Array[TypoAclItem]]
)

object PgNamespaceRow {
  implicit val oFormat: OFormat[PgNamespaceRow] = new OFormat[PgNamespaceRow]{
    override def writes(o: PgNamespaceRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
        "nspname" -> o.nspname,
        "nspowner" -> o.nspowner,
        "nspacl" -> o.nspacl
      )
  
    override def reads(json: JsValue): JsResult[PgNamespaceRow] = {
      JsResult.fromTry(
        Try(
          PgNamespaceRow(
            oid = json.\("oid").as[PgNamespaceId],
            nspname = json.\("nspname").as[String],
            nspowner = json.\("nspowner").as[/* oid */ Long],
            nspacl = json.\("nspacl").toOption.map(_.as[Array[TypoAclItem]])
          )
        )
      )
    }
  }
}
