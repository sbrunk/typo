/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class EmailaddressRow(
  /** Primary key. Person associated with this email address.  Foreign key to Person.BusinessEntityID
      Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary key. ID of this email address. */
  emailaddressid: Int,
  /** E-mail address for the person. */
  emailaddress: Option[/* max 50 chars */ String],
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
){
   val compositeId: EmailaddressId = EmailaddressId(businessentityid, emailaddressid)
 }

object EmailaddressRow {
  implicit lazy val decoder: Decoder[EmailaddressRow] = Decoder.forProduct5[EmailaddressRow, BusinessentityId, Int, Option[/* max 50 chars */ String], TypoUUID, TypoLocalDateTime]("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")(EmailaddressRow.apply)(BusinessentityId.decoder, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeString), TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[EmailaddressRow] = Encoder.forProduct5[EmailaddressRow, BusinessentityId, Int, Option[/* max 50 chars */ String], TypoUUID, TypoLocalDateTime]("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")(x => (x.businessentityid, x.emailaddressid, x.emailaddress, x.rowguid, x.modifieddate))(BusinessentityId.encoder, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeString), TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[EmailaddressRow] = new Read[EmailaddressRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => EmailaddressRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      emailaddressid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 1),
      emailaddress = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
}
