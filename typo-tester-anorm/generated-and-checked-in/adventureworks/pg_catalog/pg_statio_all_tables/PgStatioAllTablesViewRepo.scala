/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_all_tables

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgStatioAllTablesViewRepo {
  def select: SelectBuilder[PgStatioAllTablesViewFields, PgStatioAllTablesViewRow]
  def selectAll(implicit c: Connection): List[PgStatioAllTablesViewRow]
}
