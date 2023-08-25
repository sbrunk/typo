/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attrdef

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgAttrdefRepo {
  def delete(oid: PgAttrdefId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgAttrdefFields, PgAttrdefRow]
  def insert(unsaved: PgAttrdefRow)(implicit c: Connection): PgAttrdefRow
  def select: SelectBuilder[PgAttrdefFields, PgAttrdefRow]
  def selectAll(implicit c: Connection): List[PgAttrdefRow]
  def selectById(oid: PgAttrdefId)(implicit c: Connection): Option[PgAttrdefRow]
  def selectByIds(oids: Array[PgAttrdefId])(implicit c: Connection): List[PgAttrdefRow]
  def selectByUnique(adrelid: /* oid */ Long, adnum: Int)(implicit c: Connection): Option[PgAttrdefRow]
  def update(row: PgAttrdefRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgAttrdefFields, PgAttrdefRow]
  def upsert(unsaved: PgAttrdefRow)(implicit c: Connection): PgAttrdefRow
}
