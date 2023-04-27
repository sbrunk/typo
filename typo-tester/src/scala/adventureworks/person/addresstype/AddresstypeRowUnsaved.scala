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
  /** Address type description. For example, Billing, Home, or Shipping. */
  name: Name,
  /** Default: nextval('person.addresstype_addresstypeid_seq'::regclass)
      Primary key for AddressType records. */
  addresstypeid: Defaulted[AddresstypeId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(addresstypeidDefault: => AddresstypeId, rowguidDefault: => UUID, modifieddateDefault: => LocalDateTime): AddresstypeRow =
    AddresstypeRow(
      name = name,
      addresstypeid = addresstypeid match {
                        case Defaulted.UseDefault => addresstypeidDefault
                        case Defaulted.Provided(value) => value
                      },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object AddresstypeRowUnsaved {
  implicit val oFormat: OFormat[AddresstypeRowUnsaved] = new OFormat[AddresstypeRowUnsaved]{
    override def writes(o: AddresstypeRowUnsaved): JsObject =
      Json.obj(
        "name" -> o.name,
        "addresstypeid" -> o.addresstypeid,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[AddresstypeRowUnsaved] = {
      JsResult.fromTry(
        Try(
          AddresstypeRowUnsaved(
            name = json.\("name").as[Name],
            addresstypeid = json.\("addresstypeid").as[Defaulted[AddresstypeId]],
            rowguid = json.\("rowguid").as[Defaulted[UUID]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
