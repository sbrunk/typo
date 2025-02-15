/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SalesorderheaderRepo {
  def delete(salesorderid: SalesorderheaderId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def insert(unsaved: SalesorderheaderRow)(implicit c: Connection): SalesorderheaderRow
  def insert(unsaved: SalesorderheaderRowUnsaved)(implicit c: Connection): SalesorderheaderRow
  def select: SelectBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def selectAll(implicit c: Connection): List[SalesorderheaderRow]
  def selectById(salesorderid: SalesorderheaderId)(implicit c: Connection): Option[SalesorderheaderRow]
  def selectByIds(salesorderids: Array[SalesorderheaderId])(implicit c: Connection): List[SalesorderheaderRow]
  def update(row: SalesorderheaderRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def upsert(unsaved: SalesorderheaderRow)(implicit c: Connection): SalesorderheaderRow
}
