/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tables

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait PgTablesViewFields[Row] {
  val schemaname: OptField[String, Row]
  val tablename: Field[String, Row]
  val tableowner: OptField[String, Row]
  val tablespace: OptField[String, Row]
  val hasindexes: Field[Boolean, Row]
  val hasrules: Field[Boolean, Row]
  val hastriggers: Field[Boolean, Row]
  val rowsecurity: Field[Boolean, Row]
}
object PgTablesViewFields extends PgTablesViewStructure[PgTablesViewRow](None, identity, (_, x) => x)

