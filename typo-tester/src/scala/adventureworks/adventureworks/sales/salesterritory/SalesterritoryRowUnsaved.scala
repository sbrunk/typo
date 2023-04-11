/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import adventureworks.Defaulted
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `sales.salesterritory` which has not been persisted yet */
case class SalesterritoryRowUnsaved(
  name: Name,
  countryregioncode: CountryregionId,
  group: String,
  salesytd: Defaulted[BigDecimal],
  saleslastyear: Defaulted[BigDecimal],
  costytd: Defaulted[BigDecimal],
  costlastyear: Defaulted[BigDecimal],
  rowguid: Defaulted[UUID],
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(territoryid: SalesterritoryId): SalesterritoryRow =
    SalesterritoryRow(
      territoryid = territoryid,
      name = name,
      countryregioncode = countryregioncode,
      group = group,
      salesytd = salesytd match {
                   case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                   case Defaulted.Provided(value) => value
                 },
      saleslastyear = saleslastyear match {
                        case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                        case Defaulted.Provided(value) => value
                      },
      costytd = costytd match {
                  case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                  case Defaulted.Provided(value) => value
                },
      costlastyear = costlastyear match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     },
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
object SalesterritoryRowUnsaved {
  implicit val oFormat: OFormat[SalesterritoryRowUnsaved] = new OFormat[SalesterritoryRowUnsaved]{
    override def writes(o: SalesterritoryRowUnsaved): JsObject =
      Json.obj(
        "name" -> o.name,
        "countryregioncode" -> o.countryregioncode,
        "group" -> o.group,
        "salesytd" -> o.salesytd,
        "saleslastyear" -> o.saleslastyear,
        "costytd" -> o.costytd,
        "costlastyear" -> o.costlastyear,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SalesterritoryRowUnsaved] = {
      JsResult.fromTry(
        Try(
          SalesterritoryRowUnsaved(
            name = json.\("name").as[Name],
            countryregioncode = json.\("countryregioncode").as[CountryregionId],
            group = json.\("group").as[String],
            salesytd = json.\("salesytd").as[Defaulted[BigDecimal]],
            saleslastyear = json.\("saleslastyear").as[Defaulted[BigDecimal]],
            costytd = json.\("costytd").as[Defaulted[BigDecimal]],
            costlastyear = json.\("costlastyear").as[Defaulted[BigDecimal]],
            rowguid = json.\("rowguid").as[Defaulted[UUID]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
