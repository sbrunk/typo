/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sp

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait SpViewFields[Row] {
  val id: Field[BusinessentityId, Row]
  val businessentityid: Field[BusinessentityId, Row]
  val territoryid: OptField[SalesterritoryId, Row]
  val salesquota: OptField[BigDecimal, Row]
  val bonus: Field[BigDecimal, Row]
  val commissionpct: Field[BigDecimal, Row]
  val salesytd: Field[BigDecimal, Row]
  val saleslastyear: Field[BigDecimal, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object SpViewFields extends SpViewStructure[SpViewRow](None, identity, (_, x) => x)

