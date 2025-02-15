/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package triggers

import adventureworks.customtypes.TypoInstant
import typo.dsl.SqlExpr.OptField

trait TriggersViewFields[Row] {
  val triggerCatalog: OptField[String, Row]
  val triggerSchema: OptField[String, Row]
  val triggerName: OptField[String, Row]
  val eventManipulation: OptField[String, Row]
  val eventObjectCatalog: OptField[String, Row]
  val eventObjectSchema: OptField[String, Row]
  val eventObjectTable: OptField[String, Row]
  val actionOrder: OptField[Int, Row]
  val actionCondition: OptField[String, Row]
  val actionStatement: OptField[String, Row]
  val actionOrientation: OptField[String, Row]
  val actionTiming: OptField[String, Row]
  val actionReferenceOldTable: OptField[String, Row]
  val actionReferenceNewTable: OptField[String, Row]
  val actionReferenceOldRow: OptField[String, Row]
  val actionReferenceNewRow: OptField[String, Row]
  val created: OptField[TypoInstant, Row]
}
object TriggersViewFields extends TriggersViewStructure[TriggersViewRow](None, identity, (_, x) => x)

