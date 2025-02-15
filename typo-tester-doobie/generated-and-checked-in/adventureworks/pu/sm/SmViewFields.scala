/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package sm

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import adventureworks.purchasing.shipmethod.ShipmethodId
import typo.dsl.SqlExpr.Field

trait SmViewFields[Row] {
  val id: Field[ShipmethodId, Row]
  val shipmethodid: Field[ShipmethodId, Row]
  val name: Field[Name, Row]
  val shipbase: Field[BigDecimal, Row]
  val shiprate: Field[BigDecimal, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object SmViewFields extends SmViewStructure[SmViewRow](None, identity, (_, x) => x)

