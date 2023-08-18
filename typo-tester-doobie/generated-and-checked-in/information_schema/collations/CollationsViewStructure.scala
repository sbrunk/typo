/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package collations

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class CollationsViewStructure[Row](val prefix: Option[String], val extract: Row => CollationsViewRow, val merge: (Row, CollationsViewRow) => Row)
  extends Relation[CollationsViewFields, CollationsViewRow, Row]
    with CollationsViewFields[Row] { outer =>

  override val collationCatalog = new OptField[SqlIdentifier, Row](prefix, "collation_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).collationCatalog, (row, value) => merge(row, extract(row).copy(collationCatalog = value)))
  override val collationSchema = new OptField[SqlIdentifier, Row](prefix, "collation_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).collationSchema, (row, value) => merge(row, extract(row).copy(collationSchema = value)))
  override val collationName = new OptField[SqlIdentifier, Row](prefix, "collation_name", None, Some("information_schema.sql_identifier"))(x => extract(x).collationName, (row, value) => merge(row, extract(row).copy(collationName = value)))
  override val padAttribute = new OptField[CharacterData, Row](prefix, "pad_attribute", None, Some("information_schema.character_data"))(x => extract(x).padAttribute, (row, value) => merge(row, extract(row).copy(padAttribute = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](collationCatalog, collationSchema, collationName, padAttribute)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => CollationsViewRow, merge: (NewRow, CollationsViewRow) => NewRow): CollationsViewStructure[NewRow] =
    new CollationsViewStructure(prefix, extract, merge)
}
