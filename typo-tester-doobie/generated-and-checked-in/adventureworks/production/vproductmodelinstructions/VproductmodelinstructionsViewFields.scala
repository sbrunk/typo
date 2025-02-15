/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductmodelinstructions

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait VproductmodelinstructionsViewFields[Row] {
  val productmodelid: Field[ProductmodelId, Row]
  val name: Field[Name, Row]
  val instructions: OptField[String, Row]
  val LocationID: OptField[Int, Row]
  val SetupHours: OptField[BigDecimal, Row]
  val MachineHours: OptField[BigDecimal, Row]
  val LaborHours: OptField[BigDecimal, Row]
  val LotSize: OptField[Int, Row]
  val Step: OptField[/* max 1024 chars */ String, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object VproductmodelinstructionsViewFields extends VproductmodelinstructionsViewStructure[VproductmodelinstructionsViewRow](None, identity, (_, x) => x)

