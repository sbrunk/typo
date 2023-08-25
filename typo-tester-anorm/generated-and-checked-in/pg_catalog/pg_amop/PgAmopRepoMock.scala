/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amop

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

class PgAmopRepoMock(map: scala.collection.mutable.Map[PgAmopId, PgAmopRow] = scala.collection.mutable.Map.empty) extends PgAmopRepo {
  override def delete(oid: PgAmopId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgAmopFields, PgAmopRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgAmopFields, map)
  }
  override def insert(unsaved: PgAmopRow)(implicit c: Connection): PgAmopRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgAmopFields, PgAmopRow] = {
    SelectBuilderMock(PgAmopFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgAmopRow] = {
    map.values.toList
  }
  override def selectById(oid: PgAmopId)(implicit c: Connection): Option[PgAmopRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgAmopId])(implicit c: Connection): List[PgAmopRow] = {
    oids.flatMap(map.get).toList
  }
  override def selectByUnique(amopfamily: /* oid */ Long, amoplefttype: /* oid */ Long, amoprighttype: /* oid */ Long, amopstrategy: Int)(implicit c: Connection): Option[PgAmopRow] = {
    map.values.find(v => amopfamily == v.amopfamily && amoplefttype == v.amoplefttype && amoprighttype == v.amoprighttype && amopstrategy == v.amopstrategy)
  }
  override def selectByUnique(amopopr: /* oid */ Long, amoppurpose: String, amopfamily: /* oid */ Long)(implicit c: Connection): Option[PgAmopRow] = {
    map.values.find(v => amopopr == v.amopopr && amoppurpose == v.amoppurpose && amopfamily == v.amopfamily)
  }
  override def update(row: PgAmopRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgAmopFields, PgAmopRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgAmopFields, map)
  }
  override def upsert(unsaved: PgAmopRow)(implicit c: Connection): PgAmopRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}
