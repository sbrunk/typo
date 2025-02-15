/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_data_wrappers

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ForeignDataWrappersViewRow(
  /** Points to [[`_pg_foreign_data_wrappers`.PgForeignDataWrappersViewRow.foreignDataWrapperCatalog]] */
  foreignDataWrapperCatalog: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_data_wrappers`.PgForeignDataWrappersViewRow.foreignDataWrapperName]] */
  foreignDataWrapperName: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_data_wrappers`.PgForeignDataWrappersViewRow.authorizationIdentifier]] */
  authorizationIdentifier: Option[/* nullability unknown */ String],
  libraryName: /* nullability unknown */ Option[String],
  /** Points to [[`_pg_foreign_data_wrappers`.PgForeignDataWrappersViewRow.foreignDataWrapperLanguage]] */
  foreignDataWrapperLanguage: Option[/* nullability unknown */ String]
)

object ForeignDataWrappersViewRow {
  implicit lazy val decoder: Decoder[ForeignDataWrappersViewRow] = Decoder.forProduct5[ForeignDataWrappersViewRow, Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], /* nullability unknown */ Option[String], Option[/* nullability unknown */ String]]("foreign_data_wrapper_catalog", "foreign_data_wrapper_name", "authorization_identifier", "library_name", "foreign_data_wrapper_language")(ForeignDataWrappersViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[ForeignDataWrappersViewRow] = Encoder.forProduct5[ForeignDataWrappersViewRow, Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], /* nullability unknown */ Option[String], Option[/* nullability unknown */ String]]("foreign_data_wrapper_catalog", "foreign_data_wrapper_name", "authorization_identifier", "library_name", "foreign_data_wrapper_language")(x => (x.foreignDataWrapperCatalog, x.foreignDataWrapperName, x.authorizationIdentifier, x.libraryName, x.foreignDataWrapperLanguage))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[ForeignDataWrappersViewRow] = new Read[ForeignDataWrappersViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ForeignDataWrappersViewRow(
      foreignDataWrapperCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      foreignDataWrapperName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      authorizationIdentifier = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      libraryName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      foreignDataWrapperLanguage = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4)
    )
  )
}
