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

trait PgTransformRepo {
  def selectAll(implicit c: Connection): List[PgTransformRow]
  def selectById(oid: PgTransformId)(implicit c: Connection): Option[PgTransformRow]
  def selectByIds(oids: List[PgTransformId])(implicit c: Connection): List[PgTransformRow]
  def selectByFieldValues(fieldValues: List[PgTransformFieldValue[_]])(implicit c: Connection): List[PgTransformRow]
  def updateFieldValues(oid: PgTransformId, fieldValues: List[PgTransformFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgTransformId, unsaved: PgTransformRowUnsaved)(implicit c: Connection): Boolean
  def delete(oid: PgTransformId)(implicit c: Connection): Boolean
  def selectByUniqueTrftypeTrflang(trftype: /* oid */ Long, trflang: /* oid */ Long)(implicit c: Connection): Option[PgTransformRow]
}
