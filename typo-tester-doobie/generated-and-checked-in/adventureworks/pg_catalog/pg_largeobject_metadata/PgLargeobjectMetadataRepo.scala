/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject_metadata

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgLargeobjectMetadataRepo {
  def delete(oid: PgLargeobjectMetadataId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[PgLargeobjectMetadataFields, PgLargeobjectMetadataRow]
  def insert(unsaved: PgLargeobjectMetadataRow): ConnectionIO[PgLargeobjectMetadataRow]
  def select: SelectBuilder[PgLargeobjectMetadataFields, PgLargeobjectMetadataRow]
  def selectAll: Stream[ConnectionIO, PgLargeobjectMetadataRow]
  def selectById(oid: PgLargeobjectMetadataId): ConnectionIO[Option[PgLargeobjectMetadataRow]]
  def selectByIds(oids: Array[PgLargeobjectMetadataId]): Stream[ConnectionIO, PgLargeobjectMetadataRow]
  def update(row: PgLargeobjectMetadataRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[PgLargeobjectMetadataFields, PgLargeobjectMetadataRow]
  def upsert(unsaved: PgLargeobjectMetadataRow): ConnectionIO[PgLargeobjectMetadataRow]
}
