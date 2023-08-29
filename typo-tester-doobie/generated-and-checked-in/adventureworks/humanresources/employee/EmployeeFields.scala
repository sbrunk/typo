/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employee

import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait EmployeeFields[Row] {
  val businessentityid: IdField[BusinessentityId, Row]
  val nationalidnumber: Field[/* max 15 chars */ String, Row]
  val loginid: Field[/* max 256 chars */ String, Row]
  val jobtitle: Field[/* max 50 chars */ String, Row]
  val birthdate: Field[TypoLocalDate, Row]
  val maritalstatus: Field[/* bpchar, max 1 chars */ String, Row]
  val gender: Field[/* bpchar, max 1 chars */ String, Row]
  val hiredate: Field[TypoLocalDate, Row]
  val salariedflag: Field[Flag, Row]
  val vacationhours: Field[TypoShort, Row]
  val sickleavehours: Field[TypoShort, Row]
  val currentflag: Field[Flag, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
  val organizationnode: OptField[String, Row]
}
object EmployeeFields extends EmployeeStructure[EmployeeRow](None, identity, (_, x) => x)

