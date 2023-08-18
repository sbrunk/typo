/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package character_sets

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class CharacterSetsViewRow(
  characterSetCatalog: Option[SqlIdentifier],
  characterSetSchema: Option[SqlIdentifier],
  characterSetName: Option[SqlIdentifier],
  characterRepertoire: Option[SqlIdentifier],
  formOfUse: Option[SqlIdentifier],
  defaultCollateCatalog: Option[SqlIdentifier],
  defaultCollateSchema: Option[SqlIdentifier],
  defaultCollateName: Option[SqlIdentifier]
)

object CharacterSetsViewRow {
  implicit lazy val decoder: Decoder[CharacterSetsViewRow] = Decoder.forProduct8[CharacterSetsViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("character_set_catalog", "character_set_schema", "character_set_name", "character_repertoire", "form_of_use", "default_collate_catalog", "default_collate_schema", "default_collate_name")(CharacterSetsViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder))
  implicit lazy val encoder: Encoder[CharacterSetsViewRow] = Encoder.forProduct8[CharacterSetsViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("character_set_catalog", "character_set_schema", "character_set_name", "character_repertoire", "form_of_use", "default_collate_catalog", "default_collate_schema", "default_collate_name")(x => (x.characterSetCatalog, x.characterSetSchema, x.characterSetName, x.characterRepertoire, x.formOfUse, x.defaultCollateCatalog, x.defaultCollateSchema, x.defaultCollateName))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder))
  implicit lazy val read: Read[CharacterSetsViewRow] = new Read[CharacterSetsViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CharacterSetsViewRow(
      characterSetCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      characterSetSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      characterSetName = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      characterRepertoire = SqlIdentifier.get.unsafeGetNullable(rs, i + 3),
      formOfUse = SqlIdentifier.get.unsafeGetNullable(rs, i + 4),
      defaultCollateCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 5),
      defaultCollateSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 6),
      defaultCollateName = SqlIdentifier.get.unsafeGetNullable(rs, i + 7)
    )
  )
}
