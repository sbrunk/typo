/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package th

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.transactionhistory.TransactionhistoryId
import typo.dsl.SqlExpr.Field

trait ThViewFields[Row] {
  val id: Field[TransactionhistoryId, Row]
  val transactionid: Field[TransactionhistoryId, Row]
  val productid: Field[ProductId, Row]
  val referenceorderid: Field[Int, Row]
  val referenceorderlineid: Field[Int, Row]
  val transactiondate: Field[TypoLocalDateTime, Row]
  val transactiontype: Field[/* bpchar, max 1 chars */ String, Row]
  val quantity: Field[Int, Row]
  val actualcost: Field[BigDecimal, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object ThViewFields extends ThViewStructure[ThViewRow](None, identity, (_, x) => x)

