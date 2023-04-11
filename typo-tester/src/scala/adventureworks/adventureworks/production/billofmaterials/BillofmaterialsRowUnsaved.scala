/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `production.billofmaterials` which has not been persisted yet */
case class BillofmaterialsRowUnsaved(
  productassemblyid: Option[ProductId],
  componentid: ProductId,
  startdate: Defaulted[LocalDateTime],
  enddate: Option[LocalDateTime],
  unitmeasurecode: UnitmeasureId,
  bomlevel: Int,
  perassemblyqty: Defaulted[BigDecimal],
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(billofmaterialsid: BillofmaterialsId): BillofmaterialsRow =
    BillofmaterialsRow(
      billofmaterialsid = billofmaterialsid,
      productassemblyid = productassemblyid,
      componentid = componentid,
      startdate = startdate match {
                    case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                    case Defaulted.Provided(value) => value
                  },
      enddate = enddate,
      unitmeasurecode = unitmeasurecode,
      bomlevel = bomlevel,
      perassemblyqty = perassemblyqty match {
                         case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                         case Defaulted.Provided(value) => value
                       },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object BillofmaterialsRowUnsaved {
  implicit val oFormat: OFormat[BillofmaterialsRowUnsaved] = new OFormat[BillofmaterialsRowUnsaved]{
    override def writes(o: BillofmaterialsRowUnsaved): JsObject =
      Json.obj(
        "productassemblyid" -> o.productassemblyid,
        "componentid" -> o.componentid,
        "startdate" -> o.startdate,
        "enddate" -> o.enddate,
        "unitmeasurecode" -> o.unitmeasurecode,
        "bomlevel" -> o.bomlevel,
        "perassemblyqty" -> o.perassemblyqty,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[BillofmaterialsRowUnsaved] = {
      JsResult.fromTry(
        Try(
          BillofmaterialsRowUnsaved(
            productassemblyid = json.\("productassemblyid").toOption.map(_.as[ProductId]),
            componentid = json.\("componentid").as[ProductId],
            startdate = json.\("startdate").as[Defaulted[LocalDateTime]],
            enddate = json.\("enddate").toOption.map(_.as[LocalDateTime]),
            unitmeasurecode = json.\("unitmeasurecode").as[UnitmeasureId],
            bomlevel = json.\("bomlevel").as[Int],
            perassemblyqty = json.\("perassemblyqty").as[Defaulted[BigDecimal]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
