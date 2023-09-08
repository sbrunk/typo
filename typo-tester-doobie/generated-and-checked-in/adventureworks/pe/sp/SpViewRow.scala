/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package sp

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.countryregion.CountryregionId
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class SpViewRow(
  /** Points to [[person.stateprovince.StateprovinceRow.stateprovinceid]] */
  id: StateprovinceId,
  /** Points to [[person.stateprovince.StateprovinceRow.stateprovinceid]] */
  stateprovinceid: StateprovinceId,
  /** Points to [[person.stateprovince.StateprovinceRow.stateprovincecode]] */
  stateprovincecode: /* bpchar, max 3 chars */ String,
  /** Points to [[person.stateprovince.StateprovinceRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** Points to [[person.stateprovince.StateprovinceRow.isonlystateprovinceflag]] */
  isonlystateprovinceflag: Flag,
  /** Points to [[person.stateprovince.StateprovinceRow.name]] */
  name: Name,
  /** Points to [[person.stateprovince.StateprovinceRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Points to [[person.stateprovince.StateprovinceRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[person.stateprovince.StateprovinceRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SpViewRow {
  implicit lazy val decoder: Decoder[SpViewRow] = Decoder.forProduct9[SpViewRow, StateprovinceId, StateprovinceId, /* bpchar, max 3 chars */ String, CountryregionId, Flag, Name, SalesterritoryId, TypoUUID, TypoLocalDateTime]("id", "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate")(SpViewRow.apply)(StateprovinceId.decoder, StateprovinceId.decoder, Decoder.decodeString, CountryregionId.decoder, Flag.decoder, Name.decoder, SalesterritoryId.decoder, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SpViewRow] = Encoder.forProduct9[SpViewRow, StateprovinceId, StateprovinceId, /* bpchar, max 3 chars */ String, CountryregionId, Flag, Name, SalesterritoryId, TypoUUID, TypoLocalDateTime]("id", "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate")(x => (x.id, x.stateprovinceid, x.stateprovincecode, x.countryregioncode, x.isonlystateprovinceflag, x.name, x.territoryid, x.rowguid, x.modifieddate))(StateprovinceId.encoder, StateprovinceId.encoder, Encoder.encodeString, CountryregionId.encoder, Flag.encoder, Name.encoder, SalesterritoryId.encoder, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SpViewRow] = new Read[SpViewRow](
    gets = List(
      (StateprovinceId.get, Nullability.NoNulls),
      (StateprovinceId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (CountryregionId.get, Nullability.NoNulls),
      (Flag.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (SalesterritoryId.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SpViewRow(
      id = StateprovinceId.get.unsafeGetNonNullable(rs, i + 0),
      stateprovinceid = StateprovinceId.get.unsafeGetNonNullable(rs, i + 1),
      stateprovincecode = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      countryregioncode = CountryregionId.get.unsafeGetNonNullable(rs, i + 3),
      isonlystateprovinceflag = Flag.get.unsafeGetNonNullable(rs, i + 4),
      name = Name.get.unsafeGetNonNullable(rs, i + 5),
      territoryid = SalesterritoryId.get.unsafeGetNonNullable(rs, i + 6),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 7),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
}
