/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salespersonquotahistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `sales.salespersonquotahistory` which has not been persisted yet */
case class SalespersonquotahistoryRowUnsaved(
  /** Sales person identification number. Foreign key to SalesPerson.BusinessEntityID.
      Points to [[salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Sales quota date. */
  quotadate: TypoLocalDateTime,
  /** Sales quota amount.
      Constraint CK_SalesPersonQuotaHistory_SalesQuota affecting columns "salesquota":  ((salesquota > 0.00)) */
  salesquota: BigDecimal,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): SalespersonquotahistoryRow =
    SalespersonquotahistoryRow(
      businessentityid = businessentityid,
      quotadate = quotadate,
      salesquota = salesquota,
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
object SalespersonquotahistoryRowUnsaved {
  implicit lazy val reads: Reads[SalespersonquotahistoryRowUnsaved] = Reads[SalespersonquotahistoryRowUnsaved](json => JsResult.fromTry(
      Try(
        SalespersonquotahistoryRowUnsaved(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          quotadate = json.\("quotadate").as(TypoLocalDateTime.reads),
          salesquota = json.\("salesquota").as(Reads.bigDecReads),
          rowguid = json.\("rowguid").as(Defaulted.reads(TypoUUID.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[SalespersonquotahistoryRowUnsaved] = OWrites[SalespersonquotahistoryRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "quotadate" -> TypoLocalDateTime.writes.writes(o.quotadate),
      "salesquota" -> Writes.BigDecimalWrites.writes(o.salesquota),
      "rowguid" -> Defaulted.writes(TypoUUID.writes).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
