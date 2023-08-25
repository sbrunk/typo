/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_constraint

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class PgConstraintRepoMock(map: scala.collection.mutable.Map[PgConstraintId, PgConstraintRow] = scala.collection.mutable.Map.empty) extends PgConstraintRepo {
  override def delete(oid: PgConstraintId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgConstraintFields, PgConstraintRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgConstraintFields, map)
  }
  override def insert(unsaved: PgConstraintRow)(implicit c: Connection): PgConstraintRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgConstraintFields, PgConstraintRow] = {
    SelectBuilderMock(PgConstraintFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgConstraintRow] = {
    map.values.toList
  }
  override def selectById(oid: PgConstraintId)(implicit c: Connection): Option[PgConstraintRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgConstraintId])(implicit c: Connection): List[PgConstraintRow] = {
    oids.flatMap(map.get).toList
  }
  override def selectByUnique(conrelid: /* oid */ Long, contypid: /* oid */ Long, conname: String)(implicit c: Connection): Option[PgConstraintRow] = {
    map.values.find(v => conrelid == v.conrelid && contypid == v.contypid && conname == v.conname)
  }
  override def update(row: PgConstraintRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgConstraintFields, PgConstraintRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgConstraintFields, map)
  }
  override def upsert(unsaved: PgConstraintRow)(implicit c: Connection): PgConstraintRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}
