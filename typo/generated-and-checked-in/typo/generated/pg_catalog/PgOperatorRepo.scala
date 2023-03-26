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

trait PgOperatorRepo {
  def selectAll(implicit c: Connection): List[PgOperatorRow]
  def selectById(oid: PgOperatorId)(implicit c: Connection): Option[PgOperatorRow]
  def selectByIds(oids: List[PgOperatorId])(implicit c: Connection): List[PgOperatorRow]
  def selectByFieldValues(fieldValues: List[PgOperatorFieldValue[_]])(implicit c: Connection): List[PgOperatorRow]
  def updateFieldValues(oid: PgOperatorId, fieldValues: List[PgOperatorFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgOperatorId, unsaved: PgOperatorRowUnsaved)(implicit c: Connection): Boolean
  def delete(oid: PgOperatorId)(implicit c: Connection): Boolean
  def selectByUniqueOprnameOprleftOprrightOprnamespace(oprname: String, oprleft: /* oid */ Long, oprright: /* oid */ Long, oprnamespace: /* oid */ Long)(implicit c: Connection): Option[PgOperatorRow]
}
