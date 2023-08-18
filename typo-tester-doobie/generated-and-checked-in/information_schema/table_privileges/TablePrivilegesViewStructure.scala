/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package table_privileges

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class TablePrivilegesViewStructure[Row](val prefix: Option[String], val extract: Row => TablePrivilegesViewRow, val merge: (Row, TablePrivilegesViewRow) => Row)
  extends Relation[TablePrivilegesViewFields, TablePrivilegesViewRow, Row]
    with TablePrivilegesViewFields[Row] { outer =>

  override val grantor = new OptField[SqlIdentifier, Row](prefix, "grantor", None, Some("information_schema.sql_identifier"))(x => extract(x).grantor, (row, value) => merge(row, extract(row).copy(grantor = value)))
  override val grantee = new OptField[SqlIdentifier, Row](prefix, "grantee", None, Some("information_schema.sql_identifier"))(x => extract(x).grantee, (row, value) => merge(row, extract(row).copy(grantee = value)))
  override val tableCatalog = new OptField[SqlIdentifier, Row](prefix, "table_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).tableCatalog, (row, value) => merge(row, extract(row).copy(tableCatalog = value)))
  override val tableSchema = new OptField[SqlIdentifier, Row](prefix, "table_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).tableSchema, (row, value) => merge(row, extract(row).copy(tableSchema = value)))
  override val tableName = new OptField[SqlIdentifier, Row](prefix, "table_name", None, Some("information_schema.sql_identifier"))(x => extract(x).tableName, (row, value) => merge(row, extract(row).copy(tableName = value)))
  override val privilegeType = new OptField[CharacterData, Row](prefix, "privilege_type", None, Some("information_schema.character_data"))(x => extract(x).privilegeType, (row, value) => merge(row, extract(row).copy(privilegeType = value)))
  override val isGrantable = new OptField[YesOrNo, Row](prefix, "is_grantable", None, Some("information_schema.yes_or_no"))(x => extract(x).isGrantable, (row, value) => merge(row, extract(row).copy(isGrantable = value)))
  override val withHierarchy = new OptField[YesOrNo, Row](prefix, "with_hierarchy", None, Some("information_schema.yes_or_no"))(x => extract(x).withHierarchy, (row, value) => merge(row, extract(row).copy(withHierarchy = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](grantor, grantee, tableCatalog, tableSchema, tableName, privilegeType, isGrantable, withHierarchy)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => TablePrivilegesViewRow, merge: (NewRow, TablePrivilegesViewRow) => NewRow): TablePrivilegesViewStructure[NewRow] =
    new TablePrivilegesViewStructure(prefix, extract, merge)
}
