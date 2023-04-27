/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog
package pg_namespace

import java.sql.Connection

trait PgNamespaceRepo {
  def delete(oid: PgNamespaceId)(implicit c: Connection): Boolean
  def insert(unsaved: PgNamespaceRow)(implicit c: Connection): PgNamespaceRow
  def selectAll(implicit c: Connection): List[PgNamespaceRow]
  def selectByFieldValues(fieldValues: List[PgNamespaceFieldOrIdValue[_]])(implicit c: Connection): List[PgNamespaceRow]
  def selectById(oid: PgNamespaceId)(implicit c: Connection): Option[PgNamespaceRow]
  def selectByIds(oids: Array[PgNamespaceId])(implicit c: Connection): List[PgNamespaceRow]
  def selectByUnique(nspname: String)(implicit c: Connection): Option[PgNamespaceRow]
  def update(row: PgNamespaceRow)(implicit c: Connection): Boolean
  def updateFieldValues(oid: PgNamespaceId, fieldValues: List[PgNamespaceFieldValue[_]])(implicit c: Connection): Boolean
}
