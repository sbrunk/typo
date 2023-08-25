/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgPublicationRepo {
  def delete(oid: PgPublicationId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgPublicationFields, PgPublicationRow]
  def insert(unsaved: PgPublicationRow): ConnectionIO[PgPublicationRow]
  def select: SelectBuilder[PgPublicationFields, PgPublicationRow]
  def selectAll: Stream[ConnectionIO, PgPublicationRow]
  def selectById(oid: PgPublicationId): ConnectionIO[Option[PgPublicationRow]]
  def selectByIds(oids: Array[PgPublicationId]): Stream[ConnectionIO, PgPublicationRow]
  def selectByUnique(pubname: String): ConnectionIO[Option[PgPublicationRow]]
  def update(row: PgPublicationRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgPublicationFields, PgPublicationRow]
  def upsert(unsaved: PgPublicationRow): ConnectionIO[PgPublicationRow]
}
