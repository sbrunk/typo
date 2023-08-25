/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_class

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgClassRepo {
  def delete(oid: PgClassId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgClassFields, PgClassRow]
  def insert(unsaved: PgClassRow): ConnectionIO[PgClassRow]
  def select: SelectBuilder[PgClassFields, PgClassRow]
  def selectAll: Stream[ConnectionIO, PgClassRow]
  def selectById(oid: PgClassId): ConnectionIO[Option[PgClassRow]]
  def selectByIds(oids: Array[PgClassId]): Stream[ConnectionIO, PgClassRow]
  def selectByUnique(relname: String, relnamespace: /* oid */ Long): ConnectionIO[Option[PgClassRow]]
  def update(row: PgClassRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgClassFields, PgClassRow]
  def upsert(unsaved: PgClassRow): ConnectionIO[PgClassRow]
}
