/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package v

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class VViewRow(
  /** Points to [[purchasing.vendor.VendorRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[purchasing.vendor.VendorRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[purchasing.vendor.VendorRow.accountnumber]] */
  accountnumber: AccountNumber,
  /** Points to [[purchasing.vendor.VendorRow.name]] */
  name: Name,
  /** Points to [[purchasing.vendor.VendorRow.creditrating]] */
  creditrating: TypoShort,
  /** Points to [[purchasing.vendor.VendorRow.preferredvendorstatus]] */
  preferredvendorstatus: Flag,
  /** Points to [[purchasing.vendor.VendorRow.activeflag]] */
  activeflag: Flag,
  /** Points to [[purchasing.vendor.VendorRow.purchasingwebserviceurl]] */
  purchasingwebserviceurl: Option[/* max 1024 chars */ String],
  /** Points to [[purchasing.vendor.VendorRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object VViewRow {
  implicit lazy val decoder: Decoder[VViewRow] = Decoder.forProduct9[VViewRow, BusinessentityId, BusinessentityId, AccountNumber, Name, TypoShort, Flag, Flag, Option[/* max 1024 chars */ String], TypoLocalDateTime]("id", "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate")(VViewRow.apply)(BusinessentityId.decoder, BusinessentityId.decoder, AccountNumber.decoder, Name.decoder, TypoShort.decoder, Flag.decoder, Flag.decoder, Decoder.decodeOption(Decoder.decodeString), TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[VViewRow] = Encoder.forProduct9[VViewRow, BusinessentityId, BusinessentityId, AccountNumber, Name, TypoShort, Flag, Flag, Option[/* max 1024 chars */ String], TypoLocalDateTime]("id", "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate")(x => (x.id, x.businessentityid, x.accountnumber, x.name, x.creditrating, x.preferredvendorstatus, x.activeflag, x.purchasingwebserviceurl, x.modifieddate))(BusinessentityId.encoder, BusinessentityId.encoder, AccountNumber.encoder, Name.encoder, TypoShort.encoder, Flag.encoder, Flag.encoder, Encoder.encodeOption(Encoder.encodeString), TypoLocalDateTime.encoder)
  implicit lazy val read: Read[VViewRow] = new Read[VViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (AccountNumber.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (Flag.get, Nullability.NoNulls),
      (Flag.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VViewRow(
      id = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 1),
      accountnumber = AccountNumber.get.unsafeGetNonNullable(rs, i + 2),
      name = Name.get.unsafeGetNonNullable(rs, i + 3),
      creditrating = TypoShort.get.unsafeGetNonNullable(rs, i + 4),
      preferredvendorstatus = Flag.get.unsafeGetNonNullable(rs, i + 5),
      activeflag = Flag.get.unsafeGetNonNullable(rs, i + 6),
      purchasingwebserviceurl = Meta.StringMeta.get.unsafeGetNullable(rs, i + 7),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
}
