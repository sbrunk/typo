/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package columns

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.DecodingFailure
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import scala.util.Try

case class ColumnsViewRow(
  tableCatalog: /* nullability unknown */ Option[String],
  tableSchema: /* nullability unknown */ Option[String],
  tableName: /* nullability unknown */ Option[String],
  columnName: /* nullability unknown */ Option[String],
  ordinalPosition: /* nullability unknown */ Option[Int],
  columnDefault: /* nullability unknown */ Option[String],
  isNullable: /* nullability unknown */ Option[/* max 3 chars */ String],
  dataType: /* nullability unknown */ Option[String],
  characterMaximumLength: /* nullability unknown */ Option[Int],
  characterOctetLength: /* nullability unknown */ Option[Int],
  numericPrecision: /* nullability unknown */ Option[Int],
  numericPrecisionRadix: /* nullability unknown */ Option[Int],
  numericScale: /* nullability unknown */ Option[Int],
  datetimePrecision: /* nullability unknown */ Option[Int],
  intervalType: /* nullability unknown */ Option[String],
  intervalPrecision: /* nullability unknown */ Option[Int],
  characterSetCatalog: /* nullability unknown */ Option[String],
  characterSetSchema: /* nullability unknown */ Option[String],
  characterSetName: /* nullability unknown */ Option[String],
  collationCatalog: /* nullability unknown */ Option[String],
  collationSchema: /* nullability unknown */ Option[String],
  collationName: /* nullability unknown */ Option[String],
  domainCatalog: /* nullability unknown */ Option[String],
  domainSchema: /* nullability unknown */ Option[String],
  domainName: /* nullability unknown */ Option[String],
  udtCatalog: /* nullability unknown */ Option[String],
  udtSchema: /* nullability unknown */ Option[String],
  udtName: /* nullability unknown */ Option[String],
  scopeCatalog: /* nullability unknown */ Option[String],
  scopeSchema: /* nullability unknown */ Option[String],
  scopeName: /* nullability unknown */ Option[String],
  maximumCardinality: /* nullability unknown */ Option[Int],
  dtdIdentifier: /* nullability unknown */ Option[String],
  isSelfReferencing: /* nullability unknown */ Option[/* max 3 chars */ String],
  isIdentity: /* nullability unknown */ Option[/* max 3 chars */ String],
  identityGeneration: /* nullability unknown */ Option[String],
  identityStart: /* nullability unknown */ Option[String],
  identityIncrement: /* nullability unknown */ Option[String],
  identityMaximum: /* nullability unknown */ Option[String],
  identityMinimum: /* nullability unknown */ Option[String],
  identityCycle: /* nullability unknown */ Option[/* max 3 chars */ String],
  isGenerated: /* nullability unknown */ Option[String],
  generationExpression: /* nullability unknown */ Option[String],
  isUpdatable: /* nullability unknown */ Option[/* max 3 chars */ String]
)

object ColumnsViewRow {
  implicit lazy val decoder: Decoder[ColumnsViewRow] = Decoder.instanceTry[ColumnsViewRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      ColumnsViewRow(
        tableCatalog = orThrow(c.get("table_catalog")(Decoder.decodeOption(Decoder.decodeString))),
        tableSchema = orThrow(c.get("table_schema")(Decoder.decodeOption(Decoder.decodeString))),
        tableName = orThrow(c.get("table_name")(Decoder.decodeOption(Decoder.decodeString))),
        columnName = orThrow(c.get("column_name")(Decoder.decodeOption(Decoder.decodeString))),
        ordinalPosition = orThrow(c.get("ordinal_position")(Decoder.decodeOption(Decoder.decodeInt))),
        columnDefault = orThrow(c.get("column_default")(Decoder.decodeOption(Decoder.decodeString))),
        isNullable = orThrow(c.get("is_nullable")(Decoder.decodeOption(Decoder.decodeString))),
        dataType = orThrow(c.get("data_type")(Decoder.decodeOption(Decoder.decodeString))),
        characterMaximumLength = orThrow(c.get("character_maximum_length")(Decoder.decodeOption(Decoder.decodeInt))),
        characterOctetLength = orThrow(c.get("character_octet_length")(Decoder.decodeOption(Decoder.decodeInt))),
        numericPrecision = orThrow(c.get("numeric_precision")(Decoder.decodeOption(Decoder.decodeInt))),
        numericPrecisionRadix = orThrow(c.get("numeric_precision_radix")(Decoder.decodeOption(Decoder.decodeInt))),
        numericScale = orThrow(c.get("numeric_scale")(Decoder.decodeOption(Decoder.decodeInt))),
        datetimePrecision = orThrow(c.get("datetime_precision")(Decoder.decodeOption(Decoder.decodeInt))),
        intervalType = orThrow(c.get("interval_type")(Decoder.decodeOption(Decoder.decodeString))),
        intervalPrecision = orThrow(c.get("interval_precision")(Decoder.decodeOption(Decoder.decodeInt))),
        characterSetCatalog = orThrow(c.get("character_set_catalog")(Decoder.decodeOption(Decoder.decodeString))),
        characterSetSchema = orThrow(c.get("character_set_schema")(Decoder.decodeOption(Decoder.decodeString))),
        characterSetName = orThrow(c.get("character_set_name")(Decoder.decodeOption(Decoder.decodeString))),
        collationCatalog = orThrow(c.get("collation_catalog")(Decoder.decodeOption(Decoder.decodeString))),
        collationSchema = orThrow(c.get("collation_schema")(Decoder.decodeOption(Decoder.decodeString))),
        collationName = orThrow(c.get("collation_name")(Decoder.decodeOption(Decoder.decodeString))),
        domainCatalog = orThrow(c.get("domain_catalog")(Decoder.decodeOption(Decoder.decodeString))),
        domainSchema = orThrow(c.get("domain_schema")(Decoder.decodeOption(Decoder.decodeString))),
        domainName = orThrow(c.get("domain_name")(Decoder.decodeOption(Decoder.decodeString))),
        udtCatalog = orThrow(c.get("udt_catalog")(Decoder.decodeOption(Decoder.decodeString))),
        udtSchema = orThrow(c.get("udt_schema")(Decoder.decodeOption(Decoder.decodeString))),
        udtName = orThrow(c.get("udt_name")(Decoder.decodeOption(Decoder.decodeString))),
        scopeCatalog = orThrow(c.get("scope_catalog")(Decoder.decodeOption(Decoder.decodeString))),
        scopeSchema = orThrow(c.get("scope_schema")(Decoder.decodeOption(Decoder.decodeString))),
        scopeName = orThrow(c.get("scope_name")(Decoder.decodeOption(Decoder.decodeString))),
        maximumCardinality = orThrow(c.get("maximum_cardinality")(Decoder.decodeOption(Decoder.decodeInt))),
        dtdIdentifier = orThrow(c.get("dtd_identifier")(Decoder.decodeOption(Decoder.decodeString))),
        isSelfReferencing = orThrow(c.get("is_self_referencing")(Decoder.decodeOption(Decoder.decodeString))),
        isIdentity = orThrow(c.get("is_identity")(Decoder.decodeOption(Decoder.decodeString))),
        identityGeneration = orThrow(c.get("identity_generation")(Decoder.decodeOption(Decoder.decodeString))),
        identityStart = orThrow(c.get("identity_start")(Decoder.decodeOption(Decoder.decodeString))),
        identityIncrement = orThrow(c.get("identity_increment")(Decoder.decodeOption(Decoder.decodeString))),
        identityMaximum = orThrow(c.get("identity_maximum")(Decoder.decodeOption(Decoder.decodeString))),
        identityMinimum = orThrow(c.get("identity_minimum")(Decoder.decodeOption(Decoder.decodeString))),
        identityCycle = orThrow(c.get("identity_cycle")(Decoder.decodeOption(Decoder.decodeString))),
        isGenerated = orThrow(c.get("is_generated")(Decoder.decodeOption(Decoder.decodeString))),
        generationExpression = orThrow(c.get("generation_expression")(Decoder.decodeOption(Decoder.decodeString))),
        isUpdatable = orThrow(c.get("is_updatable")(Decoder.decodeOption(Decoder.decodeString)))
      )
    }
  )
  implicit lazy val encoder: Encoder[ColumnsViewRow] = Encoder[ColumnsViewRow](row =>
    Json.obj(
      "table_catalog" -> Encoder.encodeOption(Encoder.encodeString).apply(row.tableCatalog),
      "table_schema" -> Encoder.encodeOption(Encoder.encodeString).apply(row.tableSchema),
      "table_name" -> Encoder.encodeOption(Encoder.encodeString).apply(row.tableName),
      "column_name" -> Encoder.encodeOption(Encoder.encodeString).apply(row.columnName),
      "ordinal_position" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.ordinalPosition),
      "column_default" -> Encoder.encodeOption(Encoder.encodeString).apply(row.columnDefault),
      "is_nullable" -> Encoder.encodeOption(Encoder.encodeString).apply(row.isNullable),
      "data_type" -> Encoder.encodeOption(Encoder.encodeString).apply(row.dataType),
      "character_maximum_length" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.characterMaximumLength),
      "character_octet_length" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.characterOctetLength),
      "numeric_precision" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.numericPrecision),
      "numeric_precision_radix" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.numericPrecisionRadix),
      "numeric_scale" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.numericScale),
      "datetime_precision" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.datetimePrecision),
      "interval_type" -> Encoder.encodeOption(Encoder.encodeString).apply(row.intervalType),
      "interval_precision" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.intervalPrecision),
      "character_set_catalog" -> Encoder.encodeOption(Encoder.encodeString).apply(row.characterSetCatalog),
      "character_set_schema" -> Encoder.encodeOption(Encoder.encodeString).apply(row.characterSetSchema),
      "character_set_name" -> Encoder.encodeOption(Encoder.encodeString).apply(row.characterSetName),
      "collation_catalog" -> Encoder.encodeOption(Encoder.encodeString).apply(row.collationCatalog),
      "collation_schema" -> Encoder.encodeOption(Encoder.encodeString).apply(row.collationSchema),
      "collation_name" -> Encoder.encodeOption(Encoder.encodeString).apply(row.collationName),
      "domain_catalog" -> Encoder.encodeOption(Encoder.encodeString).apply(row.domainCatalog),
      "domain_schema" -> Encoder.encodeOption(Encoder.encodeString).apply(row.domainSchema),
      "domain_name" -> Encoder.encodeOption(Encoder.encodeString).apply(row.domainName),
      "udt_catalog" -> Encoder.encodeOption(Encoder.encodeString).apply(row.udtCatalog),
      "udt_schema" -> Encoder.encodeOption(Encoder.encodeString).apply(row.udtSchema),
      "udt_name" -> Encoder.encodeOption(Encoder.encodeString).apply(row.udtName),
      "scope_catalog" -> Encoder.encodeOption(Encoder.encodeString).apply(row.scopeCatalog),
      "scope_schema" -> Encoder.encodeOption(Encoder.encodeString).apply(row.scopeSchema),
      "scope_name" -> Encoder.encodeOption(Encoder.encodeString).apply(row.scopeName),
      "maximum_cardinality" -> Encoder.encodeOption(Encoder.encodeInt).apply(row.maximumCardinality),
      "dtd_identifier" -> Encoder.encodeOption(Encoder.encodeString).apply(row.dtdIdentifier),
      "is_self_referencing" -> Encoder.encodeOption(Encoder.encodeString).apply(row.isSelfReferencing),
      "is_identity" -> Encoder.encodeOption(Encoder.encodeString).apply(row.isIdentity),
      "identity_generation" -> Encoder.encodeOption(Encoder.encodeString).apply(row.identityGeneration),
      "identity_start" -> Encoder.encodeOption(Encoder.encodeString).apply(row.identityStart),
      "identity_increment" -> Encoder.encodeOption(Encoder.encodeString).apply(row.identityIncrement),
      "identity_maximum" -> Encoder.encodeOption(Encoder.encodeString).apply(row.identityMaximum),
      "identity_minimum" -> Encoder.encodeOption(Encoder.encodeString).apply(row.identityMinimum),
      "identity_cycle" -> Encoder.encodeOption(Encoder.encodeString).apply(row.identityCycle),
      "is_generated" -> Encoder.encodeOption(Encoder.encodeString).apply(row.isGenerated),
      "generation_expression" -> Encoder.encodeOption(Encoder.encodeString).apply(row.generationExpression),
      "is_updatable" -> Encoder.encodeOption(Encoder.encodeString).apply(row.isUpdatable)
    )
  )
  implicit lazy val read: Read[ColumnsViewRow] = new Read[ColumnsViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ColumnsViewRow(
      tableCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      tableSchema = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      tableName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      columnName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      ordinalPosition = Meta.IntMeta.get.unsafeGetNullable(rs, i + 4),
      columnDefault = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      isNullable = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      dataType = Meta.StringMeta.get.unsafeGetNullable(rs, i + 7),
      characterMaximumLength = Meta.IntMeta.get.unsafeGetNullable(rs, i + 8),
      characterOctetLength = Meta.IntMeta.get.unsafeGetNullable(rs, i + 9),
      numericPrecision = Meta.IntMeta.get.unsafeGetNullable(rs, i + 10),
      numericPrecisionRadix = Meta.IntMeta.get.unsafeGetNullable(rs, i + 11),
      numericScale = Meta.IntMeta.get.unsafeGetNullable(rs, i + 12),
      datetimePrecision = Meta.IntMeta.get.unsafeGetNullable(rs, i + 13),
      intervalType = Meta.StringMeta.get.unsafeGetNullable(rs, i + 14),
      intervalPrecision = Meta.IntMeta.get.unsafeGetNullable(rs, i + 15),
      characterSetCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 16),
      characterSetSchema = Meta.StringMeta.get.unsafeGetNullable(rs, i + 17),
      characterSetName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 18),
      collationCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 19),
      collationSchema = Meta.StringMeta.get.unsafeGetNullable(rs, i + 20),
      collationName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 21),
      domainCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 22),
      domainSchema = Meta.StringMeta.get.unsafeGetNullable(rs, i + 23),
      domainName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 24),
      udtCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 25),
      udtSchema = Meta.StringMeta.get.unsafeGetNullable(rs, i + 26),
      udtName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 27),
      scopeCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 28),
      scopeSchema = Meta.StringMeta.get.unsafeGetNullable(rs, i + 29),
      scopeName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 30),
      maximumCardinality = Meta.IntMeta.get.unsafeGetNullable(rs, i + 31),
      dtdIdentifier = Meta.StringMeta.get.unsafeGetNullable(rs, i + 32),
      isSelfReferencing = Meta.StringMeta.get.unsafeGetNullable(rs, i + 33),
      isIdentity = Meta.StringMeta.get.unsafeGetNullable(rs, i + 34),
      identityGeneration = Meta.StringMeta.get.unsafeGetNullable(rs, i + 35),
      identityStart = Meta.StringMeta.get.unsafeGetNullable(rs, i + 36),
      identityIncrement = Meta.StringMeta.get.unsafeGetNullable(rs, i + 37),
      identityMaximum = Meta.StringMeta.get.unsafeGetNullable(rs, i + 38),
      identityMinimum = Meta.StringMeta.get.unsafeGetNullable(rs, i + 39),
      identityCycle = Meta.StringMeta.get.unsafeGetNullable(rs, i + 40),
      isGenerated = Meta.StringMeta.get.unsafeGetNullable(rs, i + 41),
      generationExpression = Meta.StringMeta.get.unsafeGetNullable(rs, i + 42),
      isUpdatable = Meta.StringMeta.get.unsafeGetNullable(rs, i + 43)
    )
  )
}
