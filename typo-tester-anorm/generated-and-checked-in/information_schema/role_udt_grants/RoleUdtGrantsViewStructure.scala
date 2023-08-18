/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package role_udt_grants

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class RoleUdtGrantsViewStructure[Row](val prefix: Option[String], val extract: Row => RoleUdtGrantsViewRow, val merge: (Row, RoleUdtGrantsViewRow) => Row)
  extends Relation[RoleUdtGrantsViewFields, RoleUdtGrantsViewRow, Row]
    with RoleUdtGrantsViewFields[Row] { outer =>

  override val grantor = new OptField[SqlIdentifier, Row](prefix, "grantor", None, Some("information_schema.sql_identifier"))(x => extract(x).grantor, (row, value) => merge(row, extract(row).copy(grantor = value)))
  override val grantee = new OptField[SqlIdentifier, Row](prefix, "grantee", None, Some("information_schema.sql_identifier"))(x => extract(x).grantee, (row, value) => merge(row, extract(row).copy(grantee = value)))
  override val udtCatalog = new OptField[SqlIdentifier, Row](prefix, "udt_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).udtCatalog, (row, value) => merge(row, extract(row).copy(udtCatalog = value)))
  override val udtSchema = new OptField[SqlIdentifier, Row](prefix, "udt_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).udtSchema, (row, value) => merge(row, extract(row).copy(udtSchema = value)))
  override val udtName = new OptField[SqlIdentifier, Row](prefix, "udt_name", None, Some("information_schema.sql_identifier"))(x => extract(x).udtName, (row, value) => merge(row, extract(row).copy(udtName = value)))
  override val privilegeType = new OptField[CharacterData, Row](prefix, "privilege_type", None, Some("information_schema.character_data"))(x => extract(x).privilegeType, (row, value) => merge(row, extract(row).copy(privilegeType = value)))
  override val isGrantable = new OptField[YesOrNo, Row](prefix, "is_grantable", None, Some("information_schema.yes_or_no"))(x => extract(x).isGrantable, (row, value) => merge(row, extract(row).copy(isGrantable = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](grantor, grantee, udtCatalog, udtSchema, udtName, privilegeType, isGrantable)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => RoleUdtGrantsViewRow, merge: (NewRow, RoleUdtGrantsViewRow) => NewRow): RoleUdtGrantsViewStructure[NewRow] =
    new RoleUdtGrantsViewStructure(prefix, extract, merge)
}
