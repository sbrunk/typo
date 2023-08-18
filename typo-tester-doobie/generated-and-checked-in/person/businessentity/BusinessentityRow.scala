/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import adventureworks.TypoLocalDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class BusinessentityRow(
  /** Primary key for all customers, vendors, and employees. */
  businessentityid: BusinessentityId,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object BusinessentityRow {
  implicit lazy val decoder: Decoder[BusinessentityRow] = Decoder.forProduct3[BusinessentityRow, BusinessentityId, UUID, TypoLocalDateTime]("businessentityid", "rowguid", "modifieddate")(BusinessentityRow.apply)(BusinessentityId.decoder, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[BusinessentityRow] = Encoder.forProduct3[BusinessentityRow, BusinessentityId, UUID, TypoLocalDateTime]("businessentityid", "rowguid", "modifieddate")(x => (x.businessentityid, x.rowguid, x.modifieddate))(BusinessentityId.encoder, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[BusinessentityRow] = new Read[BusinessentityRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => BusinessentityRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 1),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2)
    )
  )
}
