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

case class PgShseclabelRow(
  objoid: /* oid */ Long,
  classoid: /* oid */ Long,
  provider: String,
  label: String
){
  val compositeId: PgShseclabelId = PgShseclabelId(objoid, classoid, provider)
}

object PgShseclabelRow {
  def rowParser(prefix: String): RowParser[PgShseclabelRow] = { row =>
    Success(
      PgShseclabelRow(
        objoid = row[/* oid */ Long](prefix + "objoid"),
        classoid = row[/* oid */ Long](prefix + "classoid"),
        provider = row[String](prefix + "provider"),
        label = row[String](prefix + "label")
      )
    )
  }

  implicit val oFormat: OFormat[PgShseclabelRow] = new OFormat[PgShseclabelRow]{
    override def writes(o: PgShseclabelRow): JsObject =
      Json.obj(
        "objoid" -> o.objoid,
      "classoid" -> o.classoid,
      "provider" -> o.provider,
      "label" -> o.label
      )

    override def reads(json: JsValue): JsResult[PgShseclabelRow] = {
      JsResult.fromTry(
        Try(
          PgShseclabelRow(
            objoid = json.\("objoid").as[/* oid */ Long],
            classoid = json.\("classoid").as[/* oid */ Long],
            provider = json.\("provider").as[String],
            label = json.\("label").as[String]
          )
        )
      )
    }
  }
}
