/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_enum

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait PgEnumFields[Row] {
  val oid: IdField[PgEnumId, Row]
  val enumtypid: Field[/* oid */ Long, Row]
  val enumsortorder: Field[Float, Row]
  val enumlabel: Field[String, Row]
}
object PgEnumFields extends PgEnumStructure[PgEnumRow](None, identity, (_, x) => x)

