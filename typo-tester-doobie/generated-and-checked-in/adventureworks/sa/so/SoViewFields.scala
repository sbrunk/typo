/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package so

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.sales.specialoffer.SpecialofferId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait SoViewFields[Row] {
  val id: Field[SpecialofferId, Row]
  val specialofferid: Field[SpecialofferId, Row]
  val description: Field[/* max 255 chars */ String, Row]
  val discountpct: Field[BigDecimal, Row]
  val `type`: Field[/* max 50 chars */ String, Row]
  val category: Field[/* max 50 chars */ String, Row]
  val startdate: Field[TypoLocalDateTime, Row]
  val enddate: Field[TypoLocalDateTime, Row]
  val minqty: Field[Int, Row]
  val maxqty: OptField[Int, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object SoViewFields extends SoViewStructure[SoViewRow](None, identity, (_, x) => x)

