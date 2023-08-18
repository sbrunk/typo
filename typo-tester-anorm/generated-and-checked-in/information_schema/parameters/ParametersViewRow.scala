/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package parameters

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class ParametersViewRow(
  specificCatalog: Option[SqlIdentifier],
  specificSchema: Option[SqlIdentifier],
  specificName: Option[SqlIdentifier],
  ordinalPosition: Option[CardinalNumber],
  parameterMode: Option[CharacterData],
  isResult: Option[YesOrNo],
  asLocator: Option[YesOrNo],
  parameterName: Option[SqlIdentifier],
  dataType: Option[CharacterData],
  characterMaximumLength: Option[CardinalNumber],
  characterOctetLength: Option[CardinalNumber],
  characterSetCatalog: Option[SqlIdentifier],
  characterSetSchema: Option[SqlIdentifier],
  characterSetName: Option[SqlIdentifier],
  collationCatalog: Option[SqlIdentifier],
  collationSchema: Option[SqlIdentifier],
  collationName: Option[SqlIdentifier],
  numericPrecision: Option[CardinalNumber],
  numericPrecisionRadix: Option[CardinalNumber],
  numericScale: Option[CardinalNumber],
  datetimePrecision: Option[CardinalNumber],
  intervalType: Option[CharacterData],
  intervalPrecision: Option[CardinalNumber],
  udtCatalog: Option[SqlIdentifier],
  udtSchema: Option[SqlIdentifier],
  udtName: Option[SqlIdentifier],
  scopeCatalog: Option[SqlIdentifier],
  scopeSchema: Option[SqlIdentifier],
  scopeName: Option[SqlIdentifier],
  maximumCardinality: Option[CardinalNumber],
  dtdIdentifier: Option[SqlIdentifier],
  parameterDefault: Option[CharacterData]
)

object ParametersViewRow {
  implicit lazy val reads: Reads[ParametersViewRow] = Reads[ParametersViewRow](json => JsResult.fromTry(
      Try(
        ParametersViewRow(
          specificCatalog = json.\("specific_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          specificSchema = json.\("specific_schema").toOption.map(_.as(SqlIdentifier.reads)),
          specificName = json.\("specific_name").toOption.map(_.as(SqlIdentifier.reads)),
          ordinalPosition = json.\("ordinal_position").toOption.map(_.as(CardinalNumber.reads)),
          parameterMode = json.\("parameter_mode").toOption.map(_.as(CharacterData.reads)),
          isResult = json.\("is_result").toOption.map(_.as(YesOrNo.reads)),
          asLocator = json.\("as_locator").toOption.map(_.as(YesOrNo.reads)),
          parameterName = json.\("parameter_name").toOption.map(_.as(SqlIdentifier.reads)),
          dataType = json.\("data_type").toOption.map(_.as(CharacterData.reads)),
          characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as(CardinalNumber.reads)),
          characterOctetLength = json.\("character_octet_length").toOption.map(_.as(CardinalNumber.reads)),
          characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          characterSetSchema = json.\("character_set_schema").toOption.map(_.as(SqlIdentifier.reads)),
          characterSetName = json.\("character_set_name").toOption.map(_.as(SqlIdentifier.reads)),
          collationCatalog = json.\("collation_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          collationSchema = json.\("collation_schema").toOption.map(_.as(SqlIdentifier.reads)),
          collationName = json.\("collation_name").toOption.map(_.as(SqlIdentifier.reads)),
          numericPrecision = json.\("numeric_precision").toOption.map(_.as(CardinalNumber.reads)),
          numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as(CardinalNumber.reads)),
          numericScale = json.\("numeric_scale").toOption.map(_.as(CardinalNumber.reads)),
          datetimePrecision = json.\("datetime_precision").toOption.map(_.as(CardinalNumber.reads)),
          intervalType = json.\("interval_type").toOption.map(_.as(CharacterData.reads)),
          intervalPrecision = json.\("interval_precision").toOption.map(_.as(CardinalNumber.reads)),
          udtCatalog = json.\("udt_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          udtSchema = json.\("udt_schema").toOption.map(_.as(SqlIdentifier.reads)),
          udtName = json.\("udt_name").toOption.map(_.as(SqlIdentifier.reads)),
          scopeCatalog = json.\("scope_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          scopeSchema = json.\("scope_schema").toOption.map(_.as(SqlIdentifier.reads)),
          scopeName = json.\("scope_name").toOption.map(_.as(SqlIdentifier.reads)),
          maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as(CardinalNumber.reads)),
          dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as(SqlIdentifier.reads)),
          parameterDefault = json.\("parameter_default").toOption.map(_.as(CharacterData.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ParametersViewRow] = RowParser[ParametersViewRow] { row =>
    Success(
      ParametersViewRow(
        specificCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        specificSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        specificName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        ordinalPosition = row(idx + 3)(Column.columnToOption(CardinalNumber.column)),
        parameterMode = row(idx + 4)(Column.columnToOption(CharacterData.column)),
        isResult = row(idx + 5)(Column.columnToOption(YesOrNo.column)),
        asLocator = row(idx + 6)(Column.columnToOption(YesOrNo.column)),
        parameterName = row(idx + 7)(Column.columnToOption(SqlIdentifier.column)),
        dataType = row(idx + 8)(Column.columnToOption(CharacterData.column)),
        characterMaximumLength = row(idx + 9)(Column.columnToOption(CardinalNumber.column)),
        characterOctetLength = row(idx + 10)(Column.columnToOption(CardinalNumber.column)),
        characterSetCatalog = row(idx + 11)(Column.columnToOption(SqlIdentifier.column)),
        characterSetSchema = row(idx + 12)(Column.columnToOption(SqlIdentifier.column)),
        characterSetName = row(idx + 13)(Column.columnToOption(SqlIdentifier.column)),
        collationCatalog = row(idx + 14)(Column.columnToOption(SqlIdentifier.column)),
        collationSchema = row(idx + 15)(Column.columnToOption(SqlIdentifier.column)),
        collationName = row(idx + 16)(Column.columnToOption(SqlIdentifier.column)),
        numericPrecision = row(idx + 17)(Column.columnToOption(CardinalNumber.column)),
        numericPrecisionRadix = row(idx + 18)(Column.columnToOption(CardinalNumber.column)),
        numericScale = row(idx + 19)(Column.columnToOption(CardinalNumber.column)),
        datetimePrecision = row(idx + 20)(Column.columnToOption(CardinalNumber.column)),
        intervalType = row(idx + 21)(Column.columnToOption(CharacterData.column)),
        intervalPrecision = row(idx + 22)(Column.columnToOption(CardinalNumber.column)),
        udtCatalog = row(idx + 23)(Column.columnToOption(SqlIdentifier.column)),
        udtSchema = row(idx + 24)(Column.columnToOption(SqlIdentifier.column)),
        udtName = row(idx + 25)(Column.columnToOption(SqlIdentifier.column)),
        scopeCatalog = row(idx + 26)(Column.columnToOption(SqlIdentifier.column)),
        scopeSchema = row(idx + 27)(Column.columnToOption(SqlIdentifier.column)),
        scopeName = row(idx + 28)(Column.columnToOption(SqlIdentifier.column)),
        maximumCardinality = row(idx + 29)(Column.columnToOption(CardinalNumber.column)),
        dtdIdentifier = row(idx + 30)(Column.columnToOption(SqlIdentifier.column)),
        parameterDefault = row(idx + 31)(Column.columnToOption(CharacterData.column))
      )
    )
  }
  implicit lazy val writes: OWrites[ParametersViewRow] = OWrites[ParametersViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "specific_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.specificCatalog),
      "specific_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.specificSchema),
      "specific_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.specificName),
      "ordinal_position" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.ordinalPosition),
      "parameter_mode" -> Writes.OptionWrites(CharacterData.writes).writes(o.parameterMode),
      "is_result" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isResult),
      "as_locator" -> Writes.OptionWrites(YesOrNo.writes).writes(o.asLocator),
      "parameter_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.parameterName),
      "data_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.dataType),
      "character_maximum_length" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.characterMaximumLength),
      "character_octet_length" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.characterOctetLength),
      "character_set_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.characterSetCatalog),
      "character_set_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.characterSetSchema),
      "character_set_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.characterSetName),
      "collation_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.collationCatalog),
      "collation_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.collationSchema),
      "collation_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.collationName),
      "numeric_precision" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.numericPrecision),
      "numeric_precision_radix" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.numericPrecisionRadix),
      "numeric_scale" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.numericScale),
      "datetime_precision" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.datetimePrecision),
      "interval_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.intervalType),
      "interval_precision" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.intervalPrecision),
      "udt_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtCatalog),
      "udt_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtSchema),
      "udt_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtName),
      "scope_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.scopeCatalog),
      "scope_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.scopeSchema),
      "scope_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.scopeName),
      "maximum_cardinality" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.maximumCardinality),
      "dtd_identifier" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.dtdIdentifier),
      "parameter_default" -> Writes.OptionWrites(CharacterData.writes).writes(o.parameterDefault)
    ))
  )
}
