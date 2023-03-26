/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgTsTemplateRepo {
  def selectAll(implicit c: Connection): List[PgTsTemplateRow]
  def selectById(oid: PgTsTemplateId)(implicit c: Connection): Option[PgTsTemplateRow]
  def selectByIds(oids: List[PgTsTemplateId])(implicit c: Connection): List[PgTsTemplateRow]
  def selectByFieldValues(fieldValues: List[PgTsTemplateFieldValue[_]])(implicit c: Connection): List[PgTsTemplateRow]
  def updateFieldValues(oid: PgTsTemplateId, fieldValues: List[PgTsTemplateFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgTsTemplateId, unsaved: PgTsTemplateRowUnsaved)(implicit c: Connection): Boolean
  def delete(oid: PgTsTemplateId)(implicit c: Connection): Boolean
  def selectByUniqueTmplnameTmplnamespace(tmplname: String, tmplnamespace: /* oid */ Long)(implicit c: Connection): Option[PgTsTemplateRow]
}
