/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import adventureworks.Defaulted
import adventureworks.public.Name
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `person.addresstype` which has not been persisted yet */
case class AddresstypeRowUnsaved(
  name: Name,
  rowguid: Defaulted[UUID],
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(addresstypeid: AddresstypeId): AddresstypeRow =
    AddresstypeRow(
      addresstypeid = addresstypeid,
      name = name,
      rowguid = rowguid match {
                  case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object AddresstypeRowUnsaved {
  implicit val oFormat: OFormat[AddresstypeRowUnsaved] = new OFormat[AddresstypeRowUnsaved]{
    override def writes(o: AddresstypeRowUnsaved): JsObject =
      Json.obj(
        "name" -> o.name,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[AddresstypeRowUnsaved] = {
      JsResult.fromTry(
        Try(
          AddresstypeRowUnsaved(
            name = json.\("name").as[Name],
            rowguid = json.\("rowguid").as[Defaulted[UUID]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
