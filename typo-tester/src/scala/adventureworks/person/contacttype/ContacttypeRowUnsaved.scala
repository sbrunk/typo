/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import adventureworks.Defaulted
import adventureworks.public.Name
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `person.contacttype` which has not been persisted yet */
case class ContacttypeRowUnsaved(
  /** Contact type description. */
  name: Name,
  /** Default: nextval('person.contacttype_contacttypeid_seq'::regclass)
      Primary key for ContactType records. */
  contacttypeid: Defaulted[ContacttypeId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(contacttypeidDefault: => ContacttypeId, modifieddateDefault: => LocalDateTime): ContacttypeRow =
    ContacttypeRow(
      name = name,
      contacttypeid = contacttypeid match {
                        case Defaulted.UseDefault => contacttypeidDefault
                        case Defaulted.Provided(value) => value
                      },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ContacttypeRowUnsaved {
  implicit val oFormat: OFormat[ContacttypeRowUnsaved] = new OFormat[ContacttypeRowUnsaved]{
    override def writes(o: ContacttypeRowUnsaved): JsObject =
      Json.obj(
        "name" -> o.name,
        "contacttypeid" -> o.contacttypeid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ContacttypeRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ContacttypeRowUnsaved(
            name = json.\("name").as[Name],
            contacttypeid = json.\("contacttypeid").as[Defaulted[ContacttypeId]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
