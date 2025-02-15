/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package applicable_roles

import typo.dsl.SqlExpr.OptField

trait ApplicableRolesViewFields[Row] {
  val grantee: OptField[String, Row]
  val roleName: OptField[String, Row]
  val isGrantable: OptField[/* max 3 chars */ String, Row]
}
object ApplicableRolesViewFields extends ApplicableRolesViewStructure[ApplicableRolesViewRow](None, identity, (_, x) => x)

