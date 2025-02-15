/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductphotoRepo {
  def delete(productphotoid: ProductphotoId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[ProductphotoFields, ProductphotoRow]
  def insert(unsaved: ProductphotoRow): ConnectionIO[ProductphotoRow]
  def insert(unsaved: ProductphotoRowUnsaved): ConnectionIO[ProductphotoRow]
  def select: SelectBuilder[ProductphotoFields, ProductphotoRow]
  def selectAll: Stream[ConnectionIO, ProductphotoRow]
  def selectById(productphotoid: ProductphotoId): ConnectionIO[Option[ProductphotoRow]]
  def selectByIds(productphotoids: Array[ProductphotoId]): Stream[ConnectionIO, ProductphotoRow]
  def update(row: ProductphotoRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[ProductphotoFields, ProductphotoRow]
  def upsert(unsaved: ProductphotoRow): ConnectionIO[ProductphotoRow]
}
