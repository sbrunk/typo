/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package e

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import java.util.UUID
import typo.dsl.SqlExpr.OptField

trait EViewFields[Row] {
  val id: OptField[Int, Row]
  val businessentityid: OptField[BusinessentityId, Row]
  val emailaddressid: OptField[Int, Row]
  val emailaddress: OptField[/* max 50 chars */ String, Row]
  val rowguid: OptField[UUID, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object EViewFields extends EViewStructure[EViewRow](None, identity, (_, x) => x)

