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

trait PgOpfamilyRepo {
  def selectAll(implicit c: Connection): List[PgOpfamilyRow]
  def selectById(oid: PgOpfamilyId)(implicit c: Connection): Option[PgOpfamilyRow]
  def selectByIds(oids: List[PgOpfamilyId])(implicit c: Connection): List[PgOpfamilyRow]
  def selectByFieldValues(fieldValues: List[PgOpfamilyFieldValue[_]])(implicit c: Connection): List[PgOpfamilyRow]
  def updateFieldValues(oid: PgOpfamilyId, fieldValues: List[PgOpfamilyFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgOpfamilyId, unsaved: PgOpfamilyRowUnsaved)(implicit c: Connection): Boolean
  def delete(oid: PgOpfamilyId)(implicit c: Connection): Boolean
  def selectByUniqueOpfmethodOpfnameOpfnamespace(opfmethod: Long, opfname: String, opfnamespace: Long)(implicit c: Connection): Option[PgOpfamilyRow]
}
