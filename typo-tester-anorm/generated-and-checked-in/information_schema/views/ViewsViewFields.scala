/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package views

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.OptField

trait ViewsViewFields[Row] {
  val tableCatalog: OptField[SqlIdentifier, Row]
  val tableSchema: OptField[SqlIdentifier, Row]
  val tableName: OptField[SqlIdentifier, Row]
  val viewDefinition: OptField[CharacterData, Row]
  val checkOption: OptField[CharacterData, Row]
  val isUpdatable: OptField[YesOrNo, Row]
  val isInsertableInto: OptField[YesOrNo, Row]
  val isTriggerUpdatable: OptField[YesOrNo, Row]
  val isTriggerDeletable: OptField[YesOrNo, Row]
  val isTriggerInsertableInto: OptField[YesOrNo, Row]
}
object ViewsViewFields extends ViewsViewStructure[ViewsViewRow](None, identity, (_, x) => x)

