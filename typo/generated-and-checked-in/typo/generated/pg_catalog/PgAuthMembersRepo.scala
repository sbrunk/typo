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

trait PgAuthMembersRepo {
  def selectAll(implicit c: Connection): List[PgAuthMembersRow]
  def selectById(compositeId: PgAuthMembersId)(implicit c: Connection): Option[PgAuthMembersRow]
  def selectByFieldValues(fieldValues: List[PgAuthMembersFieldValue[_]])(implicit c: Connection): List[PgAuthMembersRow]
  def updateFieldValues(compositeId: PgAuthMembersId, fieldValues: List[PgAuthMembersFieldValue[_]])(implicit c: Connection): Int
  def insert(compositeId: PgAuthMembersId, unsaved: PgAuthMembersRowUnsaved)(implicit c: Connection): Boolean
  def delete(compositeId: PgAuthMembersId)(implicit c: Connection): Boolean
  def selectByUniqueMemberRoleid(member: Long, roleid: Long)(implicit c: Connection): Option[PgAuthMembersRow]
}
