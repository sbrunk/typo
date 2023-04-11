/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

import adventureworks.Defaulted
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `production.productmodelillustration` which has not been persisted yet */
case class ProductmodelillustrationRowUnsaved(
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(compositeId: ProductmodelillustrationId): ProductmodelillustrationRow =
    ProductmodelillustrationRow(
      productmodelid = compositeId.productmodelid,
      illustrationid = compositeId.illustrationid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductmodelillustrationRowUnsaved {
  implicit val oFormat: OFormat[ProductmodelillustrationRowUnsaved] = new OFormat[ProductmodelillustrationRowUnsaved]{
    override def writes(o: ProductmodelillustrationRowUnsaved): JsObject =
      Json.obj(
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductmodelillustrationRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ProductmodelillustrationRowUnsaved(
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
