/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package vadditionalcontactinfo

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.userdefined.FirstName
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class VadditionalcontactinfoViewRow(
  /** Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.PersonRow.firstname]] */
  firstname: /* user-picked */ FirstName,
  /** Points to [[person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.PersonRow.lastname]] */
  lastname: Name,
  telephonenumber: /* nullability unknown */ Option[TypoXml],
  telephonespecialinstructions: /* nullability unknown */ Option[String],
  street: /* nullability unknown */ Option[TypoXml],
  city: /* nullability unknown */ Option[TypoXml],
  stateprovince: /* nullability unknown */ Option[TypoXml],
  postalcode: /* nullability unknown */ Option[TypoXml],
  countryregion: /* nullability unknown */ Option[TypoXml],
  homeaddressspecialinstructions: /* nullability unknown */ Option[TypoXml],
  emailaddress: /* nullability unknown */ Option[TypoXml],
  emailspecialinstructions: /* nullability unknown */ Option[String],
  emailtelephonenumber: /* nullability unknown */ Option[TypoXml],
  /** Points to [[person.PersonRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[person.PersonRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object VadditionalcontactinfoViewRow {
  implicit lazy val decoder: Decoder[VadditionalcontactinfoViewRow] = Decoder.forProduct17[VadditionalcontactinfoViewRow, BusinessentityId, /* user-picked */ FirstName, Option[Name], Name, /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[String], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[String], /* nullability unknown */ Option[TypoXml], TypoUUID, TypoLocalDateTime]("businessentityid", "firstname", "middlename", "lastname", "telephonenumber", "telephonespecialinstructions", "street", "city", "stateprovince", "postalcode", "countryregion", "homeaddressspecialinstructions", "emailaddress", "emailspecialinstructions", "emailtelephonenumber", "rowguid", "modifieddate")(VadditionalcontactinfoViewRow.apply)(BusinessentityId.decoder, FirstName.decoder, Decoder.decodeOption(Name.decoder), Name.decoder, Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoXml.decoder), TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[VadditionalcontactinfoViewRow] = Encoder.forProduct17[VadditionalcontactinfoViewRow, BusinessentityId, /* user-picked */ FirstName, Option[Name], Name, /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[String], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[TypoXml], /* nullability unknown */ Option[String], /* nullability unknown */ Option[TypoXml], TypoUUID, TypoLocalDateTime]("businessentityid", "firstname", "middlename", "lastname", "telephonenumber", "telephonespecialinstructions", "street", "city", "stateprovince", "postalcode", "countryregion", "homeaddressspecialinstructions", "emailaddress", "emailspecialinstructions", "emailtelephonenumber", "rowguid", "modifieddate")(x => (x.businessentityid, x.firstname, x.middlename, x.lastname, x.telephonenumber, x.telephonespecialinstructions, x.street, x.city, x.stateprovince, x.postalcode, x.countryregion, x.homeaddressspecialinstructions, x.emailaddress, x.emailspecialinstructions, x.emailtelephonenumber, x.rowguid, x.modifieddate))(BusinessentityId.encoder, FirstName.encoder, Encoder.encodeOption(Name.encoder), Name.encoder, Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoXml.encoder), TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[VadditionalcontactinfoViewRow] = new Read[VadditionalcontactinfoViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (/* user-picked */ FirstName.get, Nullability.NoNulls),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.NoNulls),
      (TypoXml.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VadditionalcontactinfoViewRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      firstname = /* user-picked */ FirstName.get.unsafeGetNonNullable(rs, i + 1),
      middlename = Name.get.unsafeGetNullable(rs, i + 2),
      lastname = Name.get.unsafeGetNonNullable(rs, i + 3),
      telephonenumber = TypoXml.get.unsafeGetNullable(rs, i + 4),
      telephonespecialinstructions = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      street = TypoXml.get.unsafeGetNullable(rs, i + 6),
      city = TypoXml.get.unsafeGetNullable(rs, i + 7),
      stateprovince = TypoXml.get.unsafeGetNullable(rs, i + 8),
      postalcode = TypoXml.get.unsafeGetNullable(rs, i + 9),
      countryregion = TypoXml.get.unsafeGetNullable(rs, i + 10),
      homeaddressspecialinstructions = TypoXml.get.unsafeGetNullable(rs, i + 11),
      emailaddress = TypoXml.get.unsafeGetNullable(rs, i + 12),
      emailspecialinstructions = Meta.StringMeta.get.unsafeGetNullable(rs, i + 13),
      emailtelephonenumber = TypoXml.get.unsafeGetNullable(rs, i + 14),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 15),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 16)
    )
  )
}
