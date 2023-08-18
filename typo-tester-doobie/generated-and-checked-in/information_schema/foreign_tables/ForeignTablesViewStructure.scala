/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_tables

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class ForeignTablesViewStructure[Row](val prefix: Option[String], val extract: Row => ForeignTablesViewRow, val merge: (Row, ForeignTablesViewRow) => Row)
  extends Relation[ForeignTablesViewFields, ForeignTablesViewRow, Row]
    with ForeignTablesViewFields[Row] { outer =>

  override val foreignTableCatalog = new OptField[SqlIdentifier, Row](prefix, "foreign_table_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).foreignTableCatalog, (row, value) => merge(row, extract(row).copy(foreignTableCatalog = value)))
  override val foreignTableSchema = new OptField[SqlIdentifier, Row](prefix, "foreign_table_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).foreignTableSchema, (row, value) => merge(row, extract(row).copy(foreignTableSchema = value)))
  override val foreignTableName = new OptField[SqlIdentifier, Row](prefix, "foreign_table_name", None, Some("information_schema.sql_identifier"))(x => extract(x).foreignTableName, (row, value) => merge(row, extract(row).copy(foreignTableName = value)))
  override val foreignServerCatalog = new OptField[SqlIdentifier, Row](prefix, "foreign_server_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).foreignServerCatalog, (row, value) => merge(row, extract(row).copy(foreignServerCatalog = value)))
  override val foreignServerName = new OptField[SqlIdentifier, Row](prefix, "foreign_server_name", None, Some("information_schema.sql_identifier"))(x => extract(x).foreignServerName, (row, value) => merge(row, extract(row).copy(foreignServerName = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](foreignTableCatalog, foreignTableSchema, foreignTableName, foreignServerCatalog, foreignServerName)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ForeignTablesViewRow, merge: (NewRow, ForeignTablesViewRow) => NewRow): ForeignTablesViewStructure[NewRow] =
    new ForeignTablesViewStructure(prefix, extract, merge)
}
