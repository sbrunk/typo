/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `purchasing.vendor` which has not been persisted yet */
case class VendorRowUnsaved(
  /** Primary key for Vendor records.  Foreign key to BusinessEntity.BusinessEntityID
      Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Vendor account (identification) number. */
  accountnumber: AccountNumber,
  /** Company name. */
  name: Name,
  /** 1 = Superior, 2 = Excellent, 3 = Above average, 4 = Average, 5 = Below average */
  creditrating: Int,
  /** Vendor URL. */
  purchasingwebserviceurl: Option[/* max 1024 chars */ String],
  /** Default: true
      0 = Do not use if another vendor is available. 1 = Preferred over other vendors supplying the same product. */
  preferredvendorstatus: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: true
      0 = Vendor no longer used. 1 = Vendor is actively used. */
  activeflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(preferredvendorstatusDefault: => Flag, activeflagDefault: => Flag, modifieddateDefault: => TypoLocalDateTime): VendorRow =
    VendorRow(
      businessentityid = businessentityid,
      accountnumber = accountnumber,
      name = name,
      creditrating = creditrating,
      purchasingwebserviceurl = purchasingwebserviceurl,
      preferredvendorstatus = preferredvendorstatus match {
                                case Defaulted.UseDefault => preferredvendorstatusDefault
                                case Defaulted.Provided(value) => value
                              },
      activeflag = activeflag match {
                     case Defaulted.UseDefault => activeflagDefault
                     case Defaulted.Provided(value) => value
                   },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object VendorRowUnsaved {
  implicit lazy val reads: Reads[VendorRowUnsaved] = Reads[VendorRowUnsaved](json => JsResult.fromTry(
      Try(
        VendorRowUnsaved(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          accountnumber = json.\("accountnumber").as(AccountNumber.reads),
          name = json.\("name").as(Name.reads),
          creditrating = json.\("creditrating").as(Reads.IntReads),
          purchasingwebserviceurl = json.\("purchasingwebserviceurl").toOption.map(_.as(Reads.StringReads)),
          preferredvendorstatus = json.\("preferredvendorstatus").as(Defaulted.reads(Flag.reads)),
          activeflag = json.\("activeflag").as(Defaulted.reads(Flag.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[VendorRowUnsaved] = OWrites[VendorRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "accountnumber" -> AccountNumber.writes.writes(o.accountnumber),
      "name" -> Name.writes.writes(o.name),
      "creditrating" -> Writes.IntWrites.writes(o.creditrating),
      "purchasingwebserviceurl" -> Writes.OptionWrites(Writes.StringWrites).writes(o.purchasingwebserviceurl),
      "preferredvendorstatus" -> Defaulted.writes(Flag.writes).writes(o.preferredvendorstatus),
      "activeflag" -> Defaulted.writes(Flag.writes).writes(o.activeflag),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
