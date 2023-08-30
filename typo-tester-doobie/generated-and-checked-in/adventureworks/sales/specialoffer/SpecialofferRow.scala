/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import adventureworks.customtypes.TypoLocalDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class SpecialofferRow(
  /** Primary key for SpecialOffer records. */
  specialofferid: SpecialofferId,
  /** Discount description. */
  description: /* max 255 chars */ String,
  /** Discount precentage.
      Constraint CK_SpecialOffer_DiscountPct affecting columns "discountpct":  ((discountpct >= 0.00)) */
  discountpct: BigDecimal,
  /** Discount type category. */
  `type`: /* max 50 chars */ String,
  /** Group the discount applies to such as Reseller or Customer. */
  category: /* max 50 chars */ String,
  /** Discount start date.
      Constraint CK_SpecialOffer_EndDate affecting columns "startdate", "enddate":  ((enddate >= startdate)) */
  startdate: TypoLocalDateTime,
  /** Discount end date.
      Constraint CK_SpecialOffer_EndDate affecting columns "startdate", "enddate":  ((enddate >= startdate)) */
  enddate: TypoLocalDateTime,
  /** Minimum discount percent allowed.
      Constraint CK_SpecialOffer_MinQty affecting columns "minqty":  ((minqty >= 0)) */
  minqty: Int,
  /** Maximum discount percent allowed.
      Constraint CK_SpecialOffer_MaxQty affecting columns "maxqty":  ((maxqty >= 0)) */
  maxqty: Option[Int],
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object SpecialofferRow {
  implicit lazy val decoder: Decoder[SpecialofferRow] = Decoder.forProduct11[SpecialofferRow, SpecialofferId, /* max 255 chars */ String, BigDecimal, /* max 50 chars */ String, /* max 50 chars */ String, TypoLocalDateTime, TypoLocalDateTime, Int, Option[Int], UUID, TypoLocalDateTime]("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")(SpecialofferRow.apply)(SpecialofferId.decoder, Decoder.decodeString, Decoder.decodeBigDecimal, Decoder.decodeString, Decoder.decodeString, TypoLocalDateTime.decoder, TypoLocalDateTime.decoder, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SpecialofferRow] = Encoder.forProduct11[SpecialofferRow, SpecialofferId, /* max 255 chars */ String, BigDecimal, /* max 50 chars */ String, /* max 50 chars */ String, TypoLocalDateTime, TypoLocalDateTime, Int, Option[Int], UUID, TypoLocalDateTime]("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")(x => (x.specialofferid, x.description, x.discountpct, x.`type`, x.category, x.startdate, x.enddate, x.minqty, x.maxqty, x.rowguid, x.modifieddate))(SpecialofferId.encoder, Encoder.encodeString, Encoder.encodeBigDecimal, Encoder.encodeString, Encoder.encodeString, TypoLocalDateTime.encoder, TypoLocalDateTime.encoder, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SpecialofferRow] = new Read[SpecialofferRow](
    gets = List(
      (SpecialofferId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SpecialofferRow(
      specialofferid = SpecialofferId.get.unsafeGetNonNullable(rs, i + 0),
      description = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      discountpct = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 2),
      `type` = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      category = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 4),
      startdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5),
      enddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6),
      minqty = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 7),
      maxqty = Meta.IntMeta.get.unsafeGetNullable(rs, i + 8),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 9),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 10)
    )
  )
}
