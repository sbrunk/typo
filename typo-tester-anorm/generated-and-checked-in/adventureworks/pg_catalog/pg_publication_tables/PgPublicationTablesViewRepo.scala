/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_tables

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgPublicationTablesViewRepo {
  def select: SelectBuilder[PgPublicationTablesViewFields, PgPublicationTablesViewRow]
  def selectAll(implicit c: Connection): List[PgPublicationTablesViewRow]
}
