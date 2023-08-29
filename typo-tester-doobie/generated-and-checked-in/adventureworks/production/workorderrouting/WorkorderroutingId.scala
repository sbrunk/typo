/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.customtypes.TypoShort
import adventureworks.production.workorder.WorkorderId
import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `production.workorderrouting` */
case class WorkorderroutingId(workorderid: WorkorderId, productid: Int, operationsequence: TypoShort)
object WorkorderroutingId {
  implicit lazy val decoder: Decoder[WorkorderroutingId] = Decoder.forProduct3[WorkorderroutingId, WorkorderId, Int, TypoShort]("workorderid", "productid", "operationsequence")(WorkorderroutingId.apply)(WorkorderId.decoder, Decoder.decodeInt, TypoShort.decoder)
  implicit lazy val encoder: Encoder[WorkorderroutingId] = Encoder.forProduct3[WorkorderroutingId, WorkorderId, Int, TypoShort]("workorderid", "productid", "operationsequence")(x => (x.workorderid, x.productid, x.operationsequence))(WorkorderId.encoder, Encoder.encodeInt, TypoShort.encoder)
  implicit def ordering(implicit O0: Ordering[TypoShort]): Ordering[WorkorderroutingId] = Ordering.by(x => (x.workorderid, x.productid, x.operationsequence))
}
