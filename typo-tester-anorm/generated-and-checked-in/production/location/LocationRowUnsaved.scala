/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `production.location` which has not been persisted yet */
case class LocationRowUnsaved(
  /** Location description. */
  name: Name,
  /** Default: nextval('production.location_locationid_seq'::regclass)
      Primary key for Location records. */
  locationid: Defaulted[LocationId] = Defaulted.UseDefault,
  /** Default: 0.00
      Standard hourly cost of the manufacturing location. */
  costrate: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Work capacity (in hours) of the manufacturing location. */
  availability: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(locationidDefault: => LocationId, costrateDefault: => BigDecimal, availabilityDefault: => BigDecimal, modifieddateDefault: => TypoLocalDateTime): LocationRow =
    LocationRow(
      name = name,
      locationid = locationid match {
                     case Defaulted.UseDefault => locationidDefault
                     case Defaulted.Provided(value) => value
                   },
      costrate = costrate match {
                   case Defaulted.UseDefault => costrateDefault
                   case Defaulted.Provided(value) => value
                 },
      availability = availability match {
                       case Defaulted.UseDefault => availabilityDefault
                       case Defaulted.Provided(value) => value
                     },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object LocationRowUnsaved {
  implicit lazy val reads: Reads[LocationRowUnsaved] = Reads[LocationRowUnsaved](json => JsResult.fromTry(
      Try(
        LocationRowUnsaved(
          name = json.\("name").as(Name.reads),
          locationid = json.\("locationid").as(Defaulted.reads(LocationId.reads)),
          costrate = json.\("costrate").as(Defaulted.reads(Reads.bigDecReads)),
          availability = json.\("availability").as(Defaulted.reads(Reads.bigDecReads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[LocationRowUnsaved] = OWrites[LocationRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Name.writes.writes(o.name),
      "locationid" -> Defaulted.writes(LocationId.writes).writes(o.locationid),
      "costrate" -> Defaulted.writes(Writes.BigDecimalWrites).writes(o.costrate),
      "availability" -> Defaulted.writes(Writes.BigDecimalWrites).writes(o.availability),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
