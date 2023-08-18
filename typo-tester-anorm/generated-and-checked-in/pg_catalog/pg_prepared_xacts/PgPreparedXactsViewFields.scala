/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_prepared_xacts

import adventureworks.TypoOffsetDateTime
import adventureworks.TypoXid
import typo.dsl.SqlExpr.OptField

trait PgPreparedXactsViewFields[Row] {
  val transaction: OptField[TypoXid, Row]
  val gid: OptField[String, Row]
  val prepared: OptField[TypoOffsetDateTime, Row]
  val owner: OptField[String, Row]
  val database: OptField[String, Row]
}
object PgPreparedXactsViewFields extends PgPreparedXactsViewStructure[PgPreparedXactsViewRow](None, identity, (_, x) => x)

