/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package a

import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.address.AddressId
import adventureworks.person.stateprovince.StateprovinceId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class AViewRow(
  /** Points to [[person.address.AddressRow.addressid]] */
  id: AddressId,
  /** Points to [[person.address.AddressRow.addressid]] */
  addressid: AddressId,
  /** Points to [[person.address.AddressRow.addressline1]] */
  addressline1: /* max 60 chars */ String,
  /** Points to [[person.address.AddressRow.addressline2]] */
  addressline2: Option[/* max 60 chars */ String],
  /** Points to [[person.address.AddressRow.city]] */
  city: /* max 30 chars */ String,
  /** Points to [[person.address.AddressRow.stateprovinceid]] */
  stateprovinceid: StateprovinceId,
  /** Points to [[person.address.AddressRow.postalcode]] */
  postalcode: /* max 15 chars */ String,
  /** Points to [[person.address.AddressRow.spatiallocation]] */
  spatiallocation: Option[TypoBytea],
  /** Points to [[person.address.AddressRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[person.address.AddressRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object AViewRow {
  implicit lazy val decoder: Decoder[AViewRow] = Decoder.forProduct10[AViewRow, AddressId, AddressId, /* max 60 chars */ String, Option[/* max 60 chars */ String], /* max 30 chars */ String, StateprovinceId, /* max 15 chars */ String, Option[TypoBytea], UUID, TypoLocalDateTime]("id", "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate")(AViewRow.apply)(AddressId.decoder, AddressId.decoder, Decoder.decodeString, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, StateprovinceId.decoder, Decoder.decodeString, Decoder.decodeOption(TypoBytea.decoder), Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[AViewRow] = Encoder.forProduct10[AViewRow, AddressId, AddressId, /* max 60 chars */ String, Option[/* max 60 chars */ String], /* max 30 chars */ String, StateprovinceId, /* max 15 chars */ String, Option[TypoBytea], UUID, TypoLocalDateTime]("id", "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate")(x => (x.id, x.addressid, x.addressline1, x.addressline2, x.city, x.stateprovinceid, x.postalcode, x.spatiallocation, x.rowguid, x.modifieddate))(AddressId.encoder, AddressId.encoder, Encoder.encodeString, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, StateprovinceId.encoder, Encoder.encodeString, Encoder.encodeOption(TypoBytea.encoder), Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[AViewRow] = new Read[AViewRow](
    gets = List(
      (AddressId.get, Nullability.NoNulls),
      (AddressId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (StateprovinceId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoBytea.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => AViewRow(
      id = AddressId.get.unsafeGetNonNullable(rs, i + 0),
      addressid = AddressId.get.unsafeGetNonNullable(rs, i + 1),
      addressline1 = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      addressline2 = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      city = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 4),
      stateprovinceid = StateprovinceId.get.unsafeGetNonNullable(rs, i + 5),
      postalcode = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 6),
      spatiallocation = TypoBytea.get.unsafeGetNullable(rs, i + 7),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 8),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 9)
    )
  )
}
