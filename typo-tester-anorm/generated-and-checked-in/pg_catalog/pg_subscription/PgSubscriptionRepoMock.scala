/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_subscription

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

class PgSubscriptionRepoMock(map: scala.collection.mutable.Map[PgSubscriptionId, PgSubscriptionRow] = scala.collection.mutable.Map.empty) extends PgSubscriptionRepo {
  override def delete(oid: PgSubscriptionId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgSubscriptionFields, PgSubscriptionRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgSubscriptionFields, map)
  }
  override def insert(unsaved: PgSubscriptionRow)(implicit c: Connection): PgSubscriptionRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgSubscriptionFields, PgSubscriptionRow] = {
    SelectBuilderMock(PgSubscriptionFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgSubscriptionRow] = {
    map.values.toList
  }
  override def selectById(oid: PgSubscriptionId)(implicit c: Connection): Option[PgSubscriptionRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgSubscriptionId])(implicit c: Connection): List[PgSubscriptionRow] = {
    oids.flatMap(map.get).toList
  }
  override def selectByUnique(subdbid: /* oid */ Long, subname: String)(implicit c: Connection): Option[PgSubscriptionRow] = {
    map.values.find(v => subdbid == v.subdbid && subname == v.subname)
  }
  override def update(row: PgSubscriptionRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgSubscriptionFields, PgSubscriptionRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgSubscriptionFields, map)
  }
  override def upsert(unsaved: PgSubscriptionRow)(implicit c: Connection): PgSubscriptionRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}
