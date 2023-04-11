/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import adventureworks.Defaulted
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `humanresources.employeepayhistory` which has not been persisted yet */
case class EmployeepayhistoryRowUnsaved(
  rate: BigDecimal,
  payfrequency: Int,
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(compositeId: EmployeepayhistoryId): EmployeepayhistoryRow =
    EmployeepayhistoryRow(
      businessentityid = compositeId.businessentityid,
      ratechangedate = compositeId.ratechangedate,
      rate = rate,
      payfrequency = payfrequency,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object EmployeepayhistoryRowUnsaved {
  implicit val oFormat: OFormat[EmployeepayhistoryRowUnsaved] = new OFormat[EmployeepayhistoryRowUnsaved]{
    override def writes(o: EmployeepayhistoryRowUnsaved): JsObject =
      Json.obj(
        "rate" -> o.rate,
        "payfrequency" -> o.payfrequency,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[EmployeepayhistoryRowUnsaved] = {
      JsResult.fromTry(
        Try(
          EmployeepayhistoryRowUnsaved(
            rate = json.\("rate").as[BigDecimal],
            payfrequency = json.\("payfrequency").as[Int],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
