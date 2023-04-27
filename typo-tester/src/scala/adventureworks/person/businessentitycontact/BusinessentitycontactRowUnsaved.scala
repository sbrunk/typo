/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentitycontact

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `person.businessentitycontact` which has not been persisted yet */
case class BusinessentitycontactRowUnsaved(
  /** Primary key. Foreign key to BusinessEntity.BusinessEntityID.
      Points to [[businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary key. Foreign key to Person.BusinessEntityID.
      Points to [[person.PersonRow.businessentityid]] */
  personid: BusinessentityId,
  /** Primary key.  Foreign key to ContactType.ContactTypeID.
      Points to [[contacttype.ContacttypeRow.contacttypeid]] */
  contacttypeid: ContacttypeId,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(rowguidDefault: => UUID, modifieddateDefault: => LocalDateTime): BusinessentitycontactRow =
    BusinessentitycontactRow(
      businessentityid = businessentityid,
      personid = personid,
      contacttypeid = contacttypeid,
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
object BusinessentitycontactRowUnsaved {
  implicit val oFormat: OFormat[BusinessentitycontactRowUnsaved] = new OFormat[BusinessentitycontactRowUnsaved]{
    override def writes(o: BusinessentitycontactRowUnsaved): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "personid" -> o.personid,
        "contacttypeid" -> o.contacttypeid,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[BusinessentitycontactRowUnsaved] = {
      JsResult.fromTry(
        Try(
          BusinessentitycontactRowUnsaved(
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            personid = json.\("personid").as[BusinessentityId],
            contacttypeid = json.\("contacttypeid").as[ContacttypeId],
            rowguid = json.\("rowguid").as[Defaulted[UUID]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
