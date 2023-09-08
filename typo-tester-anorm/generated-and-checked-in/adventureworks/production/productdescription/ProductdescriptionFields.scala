/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait ProductdescriptionFields[Row] {
  val productdescriptionid: IdField[ProductdescriptionId, Row]
  val description: Field[/* max 400 chars */ String, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object ProductdescriptionFields extends ProductdescriptionStructure[ProductdescriptionRow](None, identity, (_, x) => x)

