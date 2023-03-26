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

case class PgStatUserFunctionsRow(
  funcid: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_user_functions","column_name":"funcid","ordinal_position":1,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  schemaname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_user_functions","column_name":"schemaname","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  funcname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_user_functions","column_name":"funcname","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  calls: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_user_functions","column_name":"calls","ordinal_position":4,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  totalTime: Option[Double] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_user_functions","column_name":"total_time","ordinal_position":5,"is_nullable":"YES","data_type":"double precision","numeric_precision":53,"numeric_precision_radix":2,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"float8","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  selfTime: Option[Double] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_stat_user_functions","column_name":"self_time","ordinal_position":6,"is_nullable":"YES","data_type":"double precision","numeric_precision":53,"numeric_precision_radix":2,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"float8","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgStatUserFunctionsRow {
  def rowParser(prefix: String): RowParser[PgStatUserFunctionsRow] = { row =>
    Success(
      PgStatUserFunctionsRow(
        funcid = row[Option[Long]](prefix + "funcid"),
        schemaname = row[Option[String]](prefix + "schemaname"),
        funcname = row[Option[String]](prefix + "funcname"),
        calls = row[Option[Long]](prefix + "calls"),
        totalTime = row[Option[Double]](prefix + "total_time"),
        selfTime = row[Option[Double]](prefix + "self_time")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatUserFunctionsRow] = new OFormat[PgStatUserFunctionsRow]{
    override def writes(o: PgStatUserFunctionsRow): JsObject =
      Json.obj(
        "funcid" -> o.funcid,
      "schemaname" -> o.schemaname,
      "funcname" -> o.funcname,
      "calls" -> o.calls,
      "total_time" -> o.totalTime,
      "self_time" -> o.selfTime
      )

    override def reads(json: JsValue): JsResult[PgStatUserFunctionsRow] = {
      JsResult.fromTry(
        Try(
          PgStatUserFunctionsRow(
            funcid = json.\("funcid").toOption.map(_.as[Long]),
            schemaname = json.\("schemaname").toOption.map(_.as[String]),
            funcname = json.\("funcname").toOption.map(_.as[String]),
            calls = json.\("calls").toOption.map(_.as[Long]),
            totalTime = json.\("total_time").toOption.map(_.as[Double]),
            selfTime = json.\("self_time").toOption.map(_.as[Double])
          )
        )
      )
    }
  }
}
