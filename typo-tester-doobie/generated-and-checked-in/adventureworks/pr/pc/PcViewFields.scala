/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pc

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field

trait PcViewFields[Row] {
  val id: Field[ProductcategoryId, Row]
  val productcategoryid: Field[ProductcategoryId, Row]
  val name: Field[Name, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object PcViewFields extends PcViewStructure[PcViewRow](None, identity, (_, x) => x)

