/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package referential_constraints

import typo.dsl.SqlExpr.OptField

trait ReferentialConstraintsViewFields[Row] {
  val constraintCatalog: OptField[String, Row]
  val constraintSchema: OptField[String, Row]
  val constraintName: OptField[String, Row]
  val uniqueConstraintCatalog: OptField[String, Row]
  val uniqueConstraintSchema: OptField[String, Row]
  val uniqueConstraintName: OptField[String, Row]
  val matchOption: OptField[String, Row]
  val updateRule: OptField[String, Row]
  val deleteRule: OptField[String, Row]
}
object ReferentialConstraintsViewFields extends ReferentialConstraintsViewStructure[ReferentialConstraintsViewRow](None, identity, (_, x) => x)

