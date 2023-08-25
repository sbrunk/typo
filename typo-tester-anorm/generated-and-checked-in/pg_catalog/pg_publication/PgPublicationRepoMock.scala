/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication

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

class PgPublicationRepoMock(map: scala.collection.mutable.Map[PgPublicationId, PgPublicationRow] = scala.collection.mutable.Map.empty) extends PgPublicationRepo {
  override def delete(oid: PgPublicationId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgPublicationFields, PgPublicationRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgPublicationFields, map)
  }
  override def insert(unsaved: PgPublicationRow)(implicit c: Connection): PgPublicationRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgPublicationFields, PgPublicationRow] = {
    SelectBuilderMock(PgPublicationFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgPublicationRow] = {
    map.values.toList
  }
  override def selectById(oid: PgPublicationId)(implicit c: Connection): Option[PgPublicationRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgPublicationId])(implicit c: Connection): List[PgPublicationRow] = {
    oids.flatMap(map.get).toList
  }
  override def selectByUnique(pubname: String)(implicit c: Connection): Option[PgPublicationRow] = {
    map.values.find(v => pubname == v.pubname)
  }
  override def update(row: PgPublicationRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgPublicationFields, PgPublicationRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgPublicationFields, map)
  }
  override def upsert(unsaved: PgPublicationRow)(implicit c: Connection): PgPublicationRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}
