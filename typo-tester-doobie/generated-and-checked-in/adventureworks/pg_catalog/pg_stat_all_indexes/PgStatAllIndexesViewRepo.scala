/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_all_indexes

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PgStatAllIndexesViewRepo {
  def select: SelectBuilder[PgStatAllIndexesViewFields, PgStatAllIndexesViewRow]
  def selectAll: Stream[ConnectionIO, PgStatAllIndexesViewRow]
}
