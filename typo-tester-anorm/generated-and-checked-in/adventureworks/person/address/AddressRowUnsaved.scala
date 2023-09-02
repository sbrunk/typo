/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.stateprovince.StateprovinceId
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `person.address` which has not been persisted yet */
case class AddressRowUnsaved(
  /** First street address line. */
  addressline1: /* max 60 chars */ String,
  /** Second street address line. */
  addressline2: Option[/* max 60 chars */ String],
  /** Name of the city. */
  city: /* max 30 chars */ String,
  /** Unique identification number for the state or province. Foreign key to StateProvince table.
      Points to [[stateprovince.StateprovinceRow.stateprovinceid]] */
  stateprovinceid: StateprovinceId,
  /** Postal code for the street address. */
  postalcode: /* max 15 chars */ String,
  /** Latitude and longitude of this address. */
  spatiallocation: Option[TypoBytea],
  /** Default: nextval('person.address_addressid_seq'::regclass)
      Primary key for Address records. */
  addressid: Defaulted[AddressId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(addressidDefault: => AddressId, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): AddressRow =
    AddressRow(
      addressline1 = addressline1,
      addressline2 = addressline2,
      city = city,
      stateprovinceid = stateprovinceid,
      postalcode = postalcode,
      spatiallocation = spatiallocation,
      addressid = addressid match {
                    case Defaulted.UseDefault => addressidDefault
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
object AddressRowUnsaved {
  implicit lazy val reads: Reads[AddressRowUnsaved] = Reads[AddressRowUnsaved](json => JsResult.fromTry(
      Try(
        AddressRowUnsaved(
          addressline1 = json.\("addressline1").as(Reads.StringReads),
          addressline2 = json.\("addressline2").toOption.map(_.as(Reads.StringReads)),
          city = json.\("city").as(Reads.StringReads),
          stateprovinceid = json.\("stateprovinceid").as(StateprovinceId.reads),
          postalcode = json.\("postalcode").as(Reads.StringReads),
          spatiallocation = json.\("spatiallocation").toOption.map(_.as(TypoBytea.reads)),
          addressid = json.\("addressid").as(Defaulted.reads(AddressId.reads)),
          rowguid = json.\("rowguid").as(Defaulted.reads(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[AddressRowUnsaved] = OWrites[AddressRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "addressline1" -> Writes.StringWrites.writes(o.addressline1),
      "addressline2" -> Writes.OptionWrites(Writes.StringWrites).writes(o.addressline2),
      "city" -> Writes.StringWrites.writes(o.city),
      "stateprovinceid" -> StateprovinceId.writes.writes(o.stateprovinceid),
      "postalcode" -> Writes.StringWrites.writes(o.postalcode),
      "spatiallocation" -> Writes.OptionWrites(TypoBytea.writes).writes(o.spatiallocation),
      "addressid" -> Defaulted.writes(AddressId.writes).writes(o.addressid),
      "rowguid" -> Defaulted.writes(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
