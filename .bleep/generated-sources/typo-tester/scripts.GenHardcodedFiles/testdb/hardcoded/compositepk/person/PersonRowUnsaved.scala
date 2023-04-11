/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package compositepk
package person

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `compositepk.person` which has not been persisted yet */
case class PersonRowUnsaved(
  name: Option[String]
) {
  def unsafeToRow(compositeId: PersonId): PersonRow =
    PersonRow(
      one = compositeId.one,
      two = compositeId.two,
      name = name
    )
}
object PersonRowUnsaved {
  implicit val oFormat: OFormat[PersonRowUnsaved] = new OFormat[PersonRowUnsaved]{
    override def writes(o: PersonRowUnsaved): JsObject =
      Json.obj(
        "name" -> o.name
      )
  
    override def reads(json: JsValue): JsResult[PersonRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PersonRowUnsaved(
            name = json.\("name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
