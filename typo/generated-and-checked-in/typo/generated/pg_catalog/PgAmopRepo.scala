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

trait PgAmopRepo {
  def selectAll(implicit c: Connection): List[PgAmopRow]
  def selectById(oid: PgAmopId)(implicit c: Connection): Option[PgAmopRow]
  def selectByIds(oids: List[PgAmopId])(implicit c: Connection): List[PgAmopRow]
  def selectByFieldValues(fieldValues: List[PgAmopFieldValue[_]])(implicit c: Connection): List[PgAmopRow]
  def updateFieldValues(oid: PgAmopId, fieldValues: List[PgAmopFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgAmopId, unsaved: PgAmopRowUnsaved)(implicit c: Connection): Boolean
  def delete(oid: PgAmopId)(implicit c: Connection): Boolean
  def selectByUniqueAmopfamilyAmoplefttypeAmoprighttypeAmopstrategy(amopfamily: Long, amoplefttype: Long, amoprighttype: Long, amopstrategy: Int)(implicit c: Connection): Option[PgAmopRow]
  def selectByUniqueAmopoprAmoppurposeAmopfamily(amopopr: Long, amoppurpose: String, amopfamily: Long)(implicit c: Connection): Option[PgAmopRow]
}
