/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_am

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgAmRepo {
  def delete(oid: PgAmId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgAmFields, PgAmRow]
  def insert(unsaved: PgAmRow)(implicit c: Connection): PgAmRow
  def select: SelectBuilder[PgAmFields, PgAmRow]
  def selectAll(implicit c: Connection): List[PgAmRow]
  def selectById(oid: PgAmId)(implicit c: Connection): Option[PgAmRow]
  def selectByIds(oids: Array[PgAmId])(implicit c: Connection): List[PgAmRow]
  def selectByUnique(amname: String)(implicit c: Connection): Option[PgAmRow]
  def update(row: PgAmRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgAmFields, PgAmRow]
  def upsert(unsaved: PgAmRow)(implicit c: Connection): PgAmRow
}
