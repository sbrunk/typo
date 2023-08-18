/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package user_defined_types

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.OptField

trait UserDefinedTypesViewFields[Row] {
  val userDefinedTypeCatalog: OptField[SqlIdentifier, Row]
  val userDefinedTypeSchema: OptField[SqlIdentifier, Row]
  val userDefinedTypeName: OptField[SqlIdentifier, Row]
  val userDefinedTypeCategory: OptField[CharacterData, Row]
  val isInstantiable: OptField[YesOrNo, Row]
  val isFinal: OptField[YesOrNo, Row]
  val orderingForm: OptField[CharacterData, Row]
  val orderingCategory: OptField[CharacterData, Row]
  val orderingRoutineCatalog: OptField[SqlIdentifier, Row]
  val orderingRoutineSchema: OptField[SqlIdentifier, Row]
  val orderingRoutineName: OptField[SqlIdentifier, Row]
  val referenceType: OptField[CharacterData, Row]
  val dataType: OptField[CharacterData, Row]
  val characterMaximumLength: OptField[CardinalNumber, Row]
  val characterOctetLength: OptField[CardinalNumber, Row]
  val characterSetCatalog: OptField[SqlIdentifier, Row]
  val characterSetSchema: OptField[SqlIdentifier, Row]
  val characterSetName: OptField[SqlIdentifier, Row]
  val collationCatalog: OptField[SqlIdentifier, Row]
  val collationSchema: OptField[SqlIdentifier, Row]
  val collationName: OptField[SqlIdentifier, Row]
  val numericPrecision: OptField[CardinalNumber, Row]
  val numericPrecisionRadix: OptField[CardinalNumber, Row]
  val numericScale: OptField[CardinalNumber, Row]
  val datetimePrecision: OptField[CardinalNumber, Row]
  val intervalType: OptField[CharacterData, Row]
  val intervalPrecision: OptField[CardinalNumber, Row]
  val sourceDtdIdentifier: OptField[SqlIdentifier, Row]
  val refDtdIdentifier: OptField[SqlIdentifier, Row]
}
object UserDefinedTypesViewFields extends UserDefinedTypesViewStructure[UserDefinedTypesViewRow](None, identity, (_, x) => x)

