/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

import adventureworks.person.businessentity.BusinessentityId
import java.sql.Connection

trait PersonRepo {
  def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean
  def insert(businessentityid: BusinessentityId, unsaved: PersonRowUnsaved)(implicit c: Connection): Boolean
  def selectAll(implicit c: Connection): List[PersonRow]
  def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[_]])(implicit c: Connection): List[PersonRow]
  def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[PersonRow]
  def selectByIds(businessentityids: List[BusinessentityId])(implicit c: Connection): List[PersonRow]
  def update(businessentityid: BusinessentityId, row: PersonRow)(implicit c: Connection): Boolean
  def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[PersonFieldValue[_]])(implicit c: Connection): Boolean
}
