/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.Defaulted
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `sales.creditcard` which has not been persisted yet */
case class CreditcardRowUnsaved(
  /** Credit card name. */
  cardtype: String,
  /** Credit card number. */
  cardnumber: String,
  /** Credit card expiration month. */
  expmonth: Int,
  /** Credit card expiration year. */
  expyear: Int,
  /** Default: nextval('sales.creditcard_creditcardid_seq'::regclass)
      Primary key for CreditCard records. */
  creditcardid: Defaulted[CreditcardId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(creditcardidDefault: => CreditcardId, modifieddateDefault: => LocalDateTime): CreditcardRow =
    CreditcardRow(
      cardtype = cardtype,
      cardnumber = cardnumber,
      expmonth = expmonth,
      expyear = expyear,
      creditcardid = creditcardid match {
                       case Defaulted.UseDefault => creditcardidDefault
                       case Defaulted.Provided(value) => value
                     },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object CreditcardRowUnsaved {
  implicit val oFormat: OFormat[CreditcardRowUnsaved] = new OFormat[CreditcardRowUnsaved]{
    override def writes(o: CreditcardRowUnsaved): JsObject =
      Json.obj(
        "cardtype" -> o.cardtype,
        "cardnumber" -> o.cardnumber,
        "expmonth" -> o.expmonth,
        "expyear" -> o.expyear,
        "creditcardid" -> o.creditcardid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[CreditcardRowUnsaved] = {
      JsResult.fromTry(
        Try(
          CreditcardRowUnsaved(
            cardtype = json.\("cardtype").as[String],
            cardnumber = json.\("cardnumber").as[String],
            expmonth = json.\("expmonth").as[Int],
            expyear = json.\("expyear").as[Int],
            creditcardid = json.\("creditcardid").as[Defaulted[CreditcardId]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
