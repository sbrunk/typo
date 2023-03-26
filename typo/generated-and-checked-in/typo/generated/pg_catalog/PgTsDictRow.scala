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

case class PgTsDictRow(
  oid: PgTsDictId /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_ts_dict","column_name":"oid","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  dictname: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_ts_dict","column_name":"dictname","ordinal_position":2,"is_nullable":"NO","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  dictnamespace: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_ts_dict","column_name":"dictnamespace","ordinal_position":3,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  dictowner: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_ts_dict","column_name":"dictowner","ordinal_position":4,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  dicttemplate: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_ts_dict","column_name":"dicttemplate","ordinal_position":5,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  dictinitoption: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_ts_dict","column_name":"dictinitoption","ordinal_position":6,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object PgTsDictRow {
  def rowParser(prefix: String): RowParser[PgTsDictRow] = { row =>
    Success(
      PgTsDictRow(
        oid = row[PgTsDictId](prefix + "oid"),
        dictname = row[String](prefix + "dictname"),
        dictnamespace = row[Long](prefix + "dictnamespace"),
        dictowner = row[Long](prefix + "dictowner"),
        dicttemplate = row[Long](prefix + "dicttemplate"),
        dictinitoption = row[Option[String]](prefix + "dictinitoption")
      )
    )
  }

  implicit val oFormat: OFormat[PgTsDictRow] = new OFormat[PgTsDictRow]{
    override def writes(o: PgTsDictRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "dictname" -> o.dictname,
      "dictnamespace" -> o.dictnamespace,
      "dictowner" -> o.dictowner,
      "dicttemplate" -> o.dicttemplate,
      "dictinitoption" -> o.dictinitoption
      )

    override def reads(json: JsValue): JsResult[PgTsDictRow] = {
      JsResult.fromTry(
        Try(
          PgTsDictRow(
            oid = json.\("oid").as[PgTsDictId],
            dictname = json.\("dictname").as[String],
            dictnamespace = json.\("dictnamespace").as[Long],
            dictowner = json.\("dictowner").as[Long],
            dicttemplate = json.\("dicttemplate").as[Long],
            dictinitoption = json.\("dictinitoption").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
