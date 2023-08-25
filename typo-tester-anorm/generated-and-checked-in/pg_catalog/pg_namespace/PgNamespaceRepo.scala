/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_namespace

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgNamespaceRepo {
  def delete(oid: PgNamespaceId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgNamespaceFields, PgNamespaceRow]
  def insert(unsaved: PgNamespaceRow)(implicit c: Connection): PgNamespaceRow
  def select: SelectBuilder[PgNamespaceFields, PgNamespaceRow]
  def selectAll(implicit c: Connection): List[PgNamespaceRow]
  def selectById(oid: PgNamespaceId)(implicit c: Connection): Option[PgNamespaceRow]
  def selectByIds(oids: Array[PgNamespaceId])(implicit c: Connection): List[PgNamespaceRow]
  def selectByUnique(nspname: String)(implicit c: Connection): Option[PgNamespaceRow]
  def update(row: PgNamespaceRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgNamespaceFields, PgNamespaceRow]
  def upsert(unsaved: PgNamespaceRow)(implicit c: Connection): PgNamespaceRow
}
