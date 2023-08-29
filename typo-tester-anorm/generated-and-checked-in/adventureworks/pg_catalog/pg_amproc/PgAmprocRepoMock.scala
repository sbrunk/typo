/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amproc

import adventureworks.customtypes.TypoShort
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

class PgAmprocRepoMock(map: scala.collection.mutable.Map[PgAmprocId, PgAmprocRow] = scala.collection.mutable.Map.empty) extends PgAmprocRepo {
  override def delete(oid: PgAmprocId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgAmprocFields, PgAmprocRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgAmprocFields, map)
  }
  override def insert(unsaved: PgAmprocRow)(implicit c: Connection): PgAmprocRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgAmprocFields, PgAmprocRow] = {
    SelectBuilderMock(PgAmprocFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgAmprocRow] = {
    map.values.toList
  }
  override def selectById(oid: PgAmprocId)(implicit c: Connection): Option[PgAmprocRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgAmprocId])(implicit c: Connection): List[PgAmprocRow] = {
    oids.flatMap(map.get).toList
  }
  override def selectByUnique(amprocfamily: /* oid */ Long, amproclefttype: /* oid */ Long, amprocrighttype: /* oid */ Long, amprocnum: TypoShort)(implicit c: Connection): Option[PgAmprocRow] = {
    map.values.find(v => amprocfamily == v.amprocfamily && amproclefttype == v.amproclefttype && amprocrighttype == v.amprocrighttype && amprocnum == v.amprocnum)
  }
  override def update(row: PgAmprocRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgAmprocFields, PgAmprocRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgAmprocFields, map)
  }
  override def upsert(unsaved: PgAmprocRow)(implicit c: Connection): PgAmprocRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}
