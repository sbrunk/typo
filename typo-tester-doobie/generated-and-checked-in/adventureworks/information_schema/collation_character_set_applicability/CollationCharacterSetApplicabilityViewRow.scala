/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package collation_character_set_applicability

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class CollationCharacterSetApplicabilityViewRow(
  collationCatalog: /* nullability unknown */ Option[String],
  collationSchema: /* nullability unknown */ Option[String],
  collationName: /* nullability unknown */ Option[String],
  characterSetCatalog: /* nullability unknown */ Option[String],
  characterSetSchema: /* nullability unknown */ Option[String],
  characterSetName: /* nullability unknown */ Option[String]
)

object CollationCharacterSetApplicabilityViewRow {
  implicit lazy val decoder: Decoder[CollationCharacterSetApplicabilityViewRow] = Decoder.forProduct6[CollationCharacterSetApplicabilityViewRow, /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String]]("collation_catalog", "collation_schema", "collation_name", "character_set_catalog", "character_set_schema", "character_set_name")(CollationCharacterSetApplicabilityViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[CollationCharacterSetApplicabilityViewRow] = Encoder.forProduct6[CollationCharacterSetApplicabilityViewRow, /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String]]("collation_catalog", "collation_schema", "collation_name", "character_set_catalog", "character_set_schema", "character_set_name")(x => (x.collationCatalog, x.collationSchema, x.collationName, x.characterSetCatalog, x.characterSetSchema, x.characterSetName))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[CollationCharacterSetApplicabilityViewRow] = new Read[CollationCharacterSetApplicabilityViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CollationCharacterSetApplicabilityViewRow(
      collationCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      collationSchema = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      collationName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      characterSetCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      characterSetSchema = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      characterSetName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5)
    )
  )
}
