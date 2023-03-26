/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.sql.Connection
import org.postgresql.util.PGobject

trait PgProcRepo {
  def selectAll(implicit c: Connection): List[PgProcRow]
  def selectById(oid: PgProcId)(implicit c: Connection): Option[PgProcRow]
  def selectByIds(oids: List[PgProcId])(implicit c: Connection): List[PgProcRow]
  def selectByFieldValues(fieldValues: List[PgProcFieldValue[_]])(implicit c: Connection): List[PgProcRow]
  def updateFieldValues(oid: PgProcId, fieldValues: List[PgProcFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgProcId, unsaved: PgProcRowUnsaved)(implicit c: Connection): Boolean
  def delete(oid: PgProcId)(implicit c: Connection): Boolean
  def selectByUniquePronameProargtypesPronamespace(proname: String, proargtypes: /* oidvector */ PGobject, pronamespace: /* oid */ Long)(implicit c: Connection): Option[PgProcRow]
}
