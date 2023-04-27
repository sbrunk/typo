/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import adventureworks.Defaulted
import adventureworks.public.Name
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
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
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(locationidDefault: => LocationId, costrateDefault: => BigDecimal, availabilityDefault: => BigDecimal, modifieddateDefault: => LocalDateTime): LocationRow =
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
  implicit val oFormat: OFormat[LocationRowUnsaved] = new OFormat[LocationRowUnsaved]{
    override def writes(o: LocationRowUnsaved): JsObject =
      Json.obj(
        "name" -> o.name,
        "locationid" -> o.locationid,
        "costrate" -> o.costrate,
        "availability" -> o.availability,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[LocationRowUnsaved] = {
      JsResult.fromTry(
        Try(
          LocationRowUnsaved(
            name = json.\("name").as[Name],
            locationid = json.\("locationid").as[Defaulted[LocationId]],
            costrate = json.\("costrate").as[Defaulted[BigDecimal]],
            availability = json.\("availability").as[Defaulted[BigDecimal]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
