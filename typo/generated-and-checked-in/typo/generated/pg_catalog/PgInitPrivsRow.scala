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
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgInitPrivsRow(
  objoid: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_init_privs","column_name":"objoid","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  classoid: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_init_privs","column_name":"classoid","ordinal_position":2,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  objsubid: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_init_privs","column_name":"objsubid","ordinal_position":3,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  privtype: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_init_privs","column_name":"privtype","ordinal_position":4,"is_nullable":"NO","data_type":"\"char\"","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"char","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  initprivs: Array[PGobject] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_init_privs","column_name":"initprivs","ordinal_position":5,"is_nullable":"NO","data_type":"ARRAY","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_aclitem","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
){
  val compositeId: PgInitPrivsId = PgInitPrivsId(objoid, classoid, objsubid)
}

object PgInitPrivsRow {
  def rowParser(prefix: String): RowParser[PgInitPrivsRow] = { row =>
    Success(
      PgInitPrivsRow(
        objoid = row[Long](prefix + "objoid"),
        classoid = row[Long](prefix + "classoid"),
        objsubid = row[Int](prefix + "objsubid"),
        privtype = row[String](prefix + "privtype"),
        initprivs = row[Array[PGobject]](prefix + "initprivs")
      )
    )
  }

  implicit val oFormat: OFormat[PgInitPrivsRow] = new OFormat[PgInitPrivsRow]{
    override def writes(o: PgInitPrivsRow): JsObject =
      Json.obj(
        "objoid" -> o.objoid,
      "classoid" -> o.classoid,
      "objsubid" -> o.objsubid,
      "privtype" -> o.privtype,
      "initprivs" -> o.initprivs
      )

    override def reads(json: JsValue): JsResult[PgInitPrivsRow] = {
      JsResult.fromTry(
        Try(
          PgInitPrivsRow(
            objoid = json.\("objoid").as[Long],
            classoid = json.\("classoid").as[Long],
            objsubid = json.\("objsubid").as[Int],
            privtype = json.\("privtype").as[String],
            initprivs = json.\("initprivs").as[Array[PGobject]]
          )
        )
      )
    }
  }
}
