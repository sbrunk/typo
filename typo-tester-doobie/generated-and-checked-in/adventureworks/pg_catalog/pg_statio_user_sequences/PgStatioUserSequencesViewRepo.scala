/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_user_sequences

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.SelectBuilder

trait PgStatioUserSequencesViewRepo {
  def select: SelectBuilder[PgStatioUserSequencesViewFields, PgStatioUserSequencesViewRow]
  def selectAll: Stream[ConnectionIO, PgStatioUserSequencesViewRow]
}
