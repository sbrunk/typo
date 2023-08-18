/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `sales.salesterritoryhistory` */
case class SalesterritoryhistoryId(businessentityid: BusinessentityId, startdate: TypoLocalDateTime, territoryid: SalesterritoryId)
object SalesterritoryhistoryId {
  implicit lazy val decoder: Decoder[SalesterritoryhistoryId] = Decoder.forProduct3[SalesterritoryhistoryId, BusinessentityId, TypoLocalDateTime, SalesterritoryId]("businessentityid", "startdate", "territoryid")(SalesterritoryhistoryId.apply)(BusinessentityId.decoder, TypoLocalDateTime.decoder, SalesterritoryId.decoder)
  implicit lazy val encoder: Encoder[SalesterritoryhistoryId] = Encoder.forProduct3[SalesterritoryhistoryId, BusinessentityId, TypoLocalDateTime, SalesterritoryId]("businessentityid", "startdate", "territoryid")(x => (x.businessentityid, x.startdate, x.territoryid))(BusinessentityId.encoder, TypoLocalDateTime.encoder, SalesterritoryId.encoder)
  implicit def ordering(implicit O0: Ordering[TypoLocalDateTime]): Ordering[SalesterritoryhistoryId] = Ordering.by(x => (x.businessentityid, x.startdate, x.territoryid))
}
