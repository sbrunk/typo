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

case class PgShseclabelId(objoid: /* oid */ Long, classoid: /* oid */ Long, provider: String)
object PgShseclabelId {
  implicit val ordering: Ordering[PgShseclabelId] = Ordering.by(x => (x.objoid, x.classoid, x.provider))
  implicit val oFormat: OFormat[PgShseclabelId] = new OFormat[PgShseclabelId]{
    override def writes(o: PgShseclabelId): JsObject =
      Json.obj(
        "objoid" -> o.objoid,
      "classoid" -> o.classoid,
      "provider" -> o.provider
      )

    override def reads(json: JsValue): JsResult[PgShseclabelId] = {
      JsResult.fromTry(
        Try(
          PgShseclabelId(
            objoid = json.\("objoid").as[/* oid */ Long],
            classoid = json.\("classoid").as[/* oid */ Long],
            provider = json.\("provider").as[String]
          )
        )
      )
    }
  }
  def rowParser(prefix: String): RowParser[PgShseclabelId] = { row =>
    Success(
      PgShseclabelId(
        objoid = row[/* oid */ Long](prefix + "objoid"),
        classoid = row[/* oid */ Long](prefix + "classoid"),
        provider = row[String](prefix + "provider")
      )
    )
  }

}
