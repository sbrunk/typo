/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.person.businessentity.BusinessentityId
import java.sql.Connection

trait PasswordRepo {
  def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean
  def insert(businessentityid: BusinessentityId, unsaved: PasswordRowUnsaved)(implicit c: Connection): Boolean
  def selectAll(implicit c: Connection): List[PasswordRow]
  def selectByFieldValues(fieldValues: List[PasswordFieldOrIdValue[_]])(implicit c: Connection): List[PasswordRow]
  def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[PasswordRow]
  def selectByIds(businessentityids: List[BusinessentityId])(implicit c: Connection): List[PasswordRow]
  def update(businessentityid: BusinessentityId, row: PasswordRow)(implicit c: Connection): Boolean
  def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[PasswordFieldValue[_]])(implicit c: Connection): Boolean
}
