/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait IllustrationRepo {
  def delete(illustrationid: IllustrationId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[IllustrationFields, IllustrationRow]
  def insert(unsaved: IllustrationRow): ConnectionIO[IllustrationRow]
  def insert(unsaved: IllustrationRowUnsaved): ConnectionIO[IllustrationRow]
  def select: SelectBuilder[IllustrationFields, IllustrationRow]
  def selectAll: Stream[ConnectionIO, IllustrationRow]
  def selectById(illustrationid: IllustrationId): ConnectionIO[Option[IllustrationRow]]
  def selectByIds(illustrationids: Array[IllustrationId]): Stream[ConnectionIO, IllustrationRow]
  def update(row: IllustrationRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[IllustrationFields, IllustrationRow]
  def upsert(unsaved: IllustrationRow): ConnectionIO[IllustrationRow]
}
