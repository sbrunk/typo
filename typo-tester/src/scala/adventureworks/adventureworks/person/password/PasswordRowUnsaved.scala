/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `person.password` which has not been persisted yet */
case class PasswordRowUnsaved(
  passwordhash: String,
  passwordsalt: String,
  rowguid: Defaulted[UUID],
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(businessentityid: BusinessentityId): PasswordRow =
    PasswordRow(
      businessentityid = businessentityid,
      passwordhash = passwordhash,
      passwordsalt = passwordsalt,
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
object PasswordRowUnsaved {
  implicit val oFormat: OFormat[PasswordRowUnsaved] = new OFormat[PasswordRowUnsaved]{
    override def writes(o: PasswordRowUnsaved): JsObject =
      Json.obj(
        "passwordhash" -> o.passwordhash,
        "passwordsalt" -> o.passwordsalt,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PasswordRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PasswordRowUnsaved(
            passwordhash = json.\("passwordhash").as[String],
            passwordsalt = json.\("passwordsalt").as[String],
            rowguid = json.\("rowguid").as[Defaulted[UUID]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
