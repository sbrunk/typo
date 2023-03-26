/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object AttributesRepoImpl extends AttributesRepo {
  override def selectAll(implicit c: Connection): List[AttributesRow] = {
    SQL"""select udt_catalog, udt_schema, udt_name, attribute_name, ordinal_position, attribute_default, is_nullable, data_type, character_maximum_length, character_octet_length, character_set_catalog, character_set_schema, character_set_name, collation_catalog, collation_schema, collation_name, numeric_precision, numeric_precision_radix, numeric_scale, datetime_precision, interval_type, interval_precision, attribute_udt_catalog, attribute_udt_schema, attribute_udt_name, scope_catalog, scope_schema, scope_name, maximum_cardinality, dtd_identifier, is_derived_reference_attribute from information_schema.attributes""".as(AttributesRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[AttributesFieldValue[_]])(implicit c: Connection): List[AttributesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case AttributesFieldValue.udtCatalog(value) => NamedParameter("udt_catalog", ParameterValue.from(value))
          case AttributesFieldValue.udtSchema(value) => NamedParameter("udt_schema", ParameterValue.from(value))
          case AttributesFieldValue.udtName(value) => NamedParameter("udt_name", ParameterValue.from(value))
          case AttributesFieldValue.attributeName(value) => NamedParameter("attribute_name", ParameterValue.from(value))
          case AttributesFieldValue.ordinalPosition(value) => NamedParameter("ordinal_position", ParameterValue.from(value))
          case AttributesFieldValue.attributeDefault(value) => NamedParameter("attribute_default", ParameterValue.from(value))
          case AttributesFieldValue.isNullable(value) => NamedParameter("is_nullable", ParameterValue.from(value))
          case AttributesFieldValue.dataType(value) => NamedParameter("data_type", ParameterValue.from(value))
          case AttributesFieldValue.characterMaximumLength(value) => NamedParameter("character_maximum_length", ParameterValue.from(value))
          case AttributesFieldValue.characterOctetLength(value) => NamedParameter("character_octet_length", ParameterValue.from(value))
          case AttributesFieldValue.characterSetCatalog(value) => NamedParameter("character_set_catalog", ParameterValue.from(value))
          case AttributesFieldValue.characterSetSchema(value) => NamedParameter("character_set_schema", ParameterValue.from(value))
          case AttributesFieldValue.characterSetName(value) => NamedParameter("character_set_name", ParameterValue.from(value))
          case AttributesFieldValue.collationCatalog(value) => NamedParameter("collation_catalog", ParameterValue.from(value))
          case AttributesFieldValue.collationSchema(value) => NamedParameter("collation_schema", ParameterValue.from(value))
          case AttributesFieldValue.collationName(value) => NamedParameter("collation_name", ParameterValue.from(value))
          case AttributesFieldValue.numericPrecision(value) => NamedParameter("numeric_precision", ParameterValue.from(value))
          case AttributesFieldValue.numericPrecisionRadix(value) => NamedParameter("numeric_precision_radix", ParameterValue.from(value))
          case AttributesFieldValue.numericScale(value) => NamedParameter("numeric_scale", ParameterValue.from(value))
          case AttributesFieldValue.datetimePrecision(value) => NamedParameter("datetime_precision", ParameterValue.from(value))
          case AttributesFieldValue.intervalType(value) => NamedParameter("interval_type", ParameterValue.from(value))
          case AttributesFieldValue.intervalPrecision(value) => NamedParameter("interval_precision", ParameterValue.from(value))
          case AttributesFieldValue.attributeUdtCatalog(value) => NamedParameter("attribute_udt_catalog", ParameterValue.from(value))
          case AttributesFieldValue.attributeUdtSchema(value) => NamedParameter("attribute_udt_schema", ParameterValue.from(value))
          case AttributesFieldValue.attributeUdtName(value) => NamedParameter("attribute_udt_name", ParameterValue.from(value))
          case AttributesFieldValue.scopeCatalog(value) => NamedParameter("scope_catalog", ParameterValue.from(value))
          case AttributesFieldValue.scopeSchema(value) => NamedParameter("scope_schema", ParameterValue.from(value))
          case AttributesFieldValue.scopeName(value) => NamedParameter("scope_name", ParameterValue.from(value))
          case AttributesFieldValue.maximumCardinality(value) => NamedParameter("maximum_cardinality", ParameterValue.from(value))
          case AttributesFieldValue.dtdIdentifier(value) => NamedParameter("dtd_identifier", ParameterValue.from(value))
          case AttributesFieldValue.isDerivedReferenceAttribute(value) => NamedParameter("is_derived_reference_attribute", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.attributes where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(AttributesRow.rowParser("").*)
    }

  }
}
