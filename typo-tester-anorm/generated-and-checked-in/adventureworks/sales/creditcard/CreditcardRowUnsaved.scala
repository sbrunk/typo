/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.userdefined.CustomCreditcardId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `sales.creditcard` which has not been persisted yet */
case class CreditcardRowUnsaved(
  /** Credit card name. */
  cardtype: /* max 50 chars */ String,
  /** Credit card number. */
  cardnumber: /* max 25 chars */ String,
  /** Credit card expiration month. */
  expmonth: TypoShort,
  /** Credit card expiration year. */
  expyear: TypoShort,
  /** Default: nextval('sales.creditcard_creditcardid_seq'::regclass)
      Primary key for CreditCard records. */
  creditcardid: Defaulted[/* user-picked */ CustomCreditcardId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(creditcardidDefault: => /* user-picked */ CustomCreditcardId, modifieddateDefault: => TypoLocalDateTime): CreditcardRow =
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
  implicit lazy val reads: Reads[CreditcardRowUnsaved] = Reads[CreditcardRowUnsaved](json => JsResult.fromTry(
      Try(
        CreditcardRowUnsaved(
          cardtype = json.\("cardtype").as(Reads.StringReads),
          cardnumber = json.\("cardnumber").as(Reads.StringReads),
          expmonth = json.\("expmonth").as(TypoShort.reads),
          expyear = json.\("expyear").as(TypoShort.reads),
          creditcardid = json.\("creditcardid").as(Defaulted.reads(CustomCreditcardId.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[CreditcardRowUnsaved] = OWrites[CreditcardRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "cardtype" -> Writes.StringWrites.writes(o.cardtype),
      "cardnumber" -> Writes.StringWrites.writes(o.cardnumber),
      "expmonth" -> TypoShort.writes.writes(o.expmonth),
      "expyear" -> TypoShort.writes.writes(o.expyear),
      "creditcardid" -> Defaulted.writes(CustomCreditcardId.writes).writes(o.creditcardid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
