/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user_mapping

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgUserMappingRepo {
  def delete(oid: PgUserMappingId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[PgUserMappingFields, PgUserMappingRow]
  def insert(unsaved: PgUserMappingRow)(implicit c: Connection): PgUserMappingRow
  def select: SelectBuilder[PgUserMappingFields, PgUserMappingRow]
  def selectAll(implicit c: Connection): List[PgUserMappingRow]
  def selectById(oid: PgUserMappingId)(implicit c: Connection): Option[PgUserMappingRow]
  def selectByIds(oids: Array[PgUserMappingId])(implicit c: Connection): List[PgUserMappingRow]
  def selectByUnique(umuser: /* oid */ Long, umserver: /* oid */ Long)(implicit c: Connection): Option[PgUserMappingRow]
  def update(row: PgUserMappingRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[PgUserMappingFields, PgUserMappingRow]
  def upsert(unsaved: PgUserMappingRow)(implicit c: Connection): PgUserMappingRow
}
