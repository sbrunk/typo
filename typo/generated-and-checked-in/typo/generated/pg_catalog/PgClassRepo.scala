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

import java.sql.Connection

trait PgClassRepo {
  def selectAll(implicit c: Connection): List[PgClassRow]
  def selectById(oid: PgClassId)(implicit c: Connection): Option[PgClassRow]
  def selectByIds(oids: List[PgClassId])(implicit c: Connection): List[PgClassRow]
  def selectByFieldValues(fieldValues: List[PgClassFieldValue[_]])(implicit c: Connection): List[PgClassRow]
  def updateFieldValues(oid: PgClassId, fieldValues: List[PgClassFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgClassId, unsaved: PgClassRowUnsaved)(implicit c: Connection): Boolean
  def delete(oid: PgClassId)(implicit c: Connection): Boolean
  def selectByUniqueRelnameRelnamespace(relname: String, relnamespace: Long)(implicit c: Connection): Option[PgClassRow]
}
