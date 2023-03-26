/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTsConfigMapRow(
  mapcfg: /* oid */ Long,
  maptokentype: Int,
  mapseqno: Int,
  mapdict: /* oid */ Long
){
  val compositeId: PgTsConfigMapId = PgTsConfigMapId(mapcfg, maptokentype, mapseqno)
}

object PgTsConfigMapRow {
  def rowParser(prefix: String): RowParser[PgTsConfigMapRow] = { row =>
    Success(
      PgTsConfigMapRow(
        mapcfg = row[/* oid */ Long](prefix + "mapcfg"),
        maptokentype = row[Int](prefix + "maptokentype"),
        mapseqno = row[Int](prefix + "mapseqno"),
        mapdict = row[/* oid */ Long](prefix + "mapdict")
      )
    )
  }

  implicit val oFormat: OFormat[PgTsConfigMapRow] = new OFormat[PgTsConfigMapRow]{
    override def writes(o: PgTsConfigMapRow): JsObject =
      Json.obj(
        "mapcfg" -> o.mapcfg,
      "maptokentype" -> o.maptokentype,
      "mapseqno" -> o.mapseqno,
      "mapdict" -> o.mapdict
      )

    override def reads(json: JsValue): JsResult[PgTsConfigMapRow] = {
      JsResult.fromTry(
        Try(
          PgTsConfigMapRow(
            mapcfg = json.\("mapcfg").as[/* oid */ Long],
            maptokentype = json.\("maptokentype").as[Int],
            mapseqno = json.\("mapseqno").as[Int],
            mapdict = json.\("mapdict").as[/* oid */ Long]
          )
        )
      )
    }
  }
}
