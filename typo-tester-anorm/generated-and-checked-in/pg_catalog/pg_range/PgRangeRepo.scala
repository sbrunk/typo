/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_range

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgRangeRepo {
  def delete(rngtypid: PgRangeId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgRangeFields, PgRangeRow]
  def insert(unsaved: PgRangeRow)(implicit c: Connection): PgRangeRow
  def select: SelectBuilder[PgRangeFields, PgRangeRow]
  def selectAll(implicit c: Connection): List[PgRangeRow]
  def selectById(rngtypid: PgRangeId)(implicit c: Connection): Option[PgRangeRow]
  def selectByIds(rngtypids: Array[PgRangeId])(implicit c: Connection): List[PgRangeRow]
  def selectByUnique(rngmultitypid: /* oid */ Long)(implicit c: Connection): Option[PgRangeRow]
  def update(row: PgRangeRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgRangeFields, PgRangeRow]
  def upsert(unsaved: PgRangeRow)(implicit c: Connection): PgRangeRow
}
