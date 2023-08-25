/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_enum

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class PgEnumRepoMock(map: scala.collection.mutable.Map[PgEnumId, PgEnumRow] = scala.collection.mutable.Map.empty) extends PgEnumRepo {
  override def delete(oid: PgEnumId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgEnumFields, PgEnumRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgEnumFields, map)
  }
  override def insert(unsaved: PgEnumRow): ConnectionIO[PgEnumRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def select: SelectBuilder[PgEnumFields, PgEnumRow] = {
    SelectBuilderMock(PgEnumFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgEnumRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgEnumId): ConnectionIO[Option[PgEnumRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgEnumId]): Stream[ConnectionIO, PgEnumRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def selectByUnique(enumtypid: /* oid */ Long, enumlabel: String): ConnectionIO[Option[PgEnumRow]] = {
    delay(map.values.find(v => enumtypid == v.enumtypid && enumlabel == v.enumlabel))
  }
  override def selectByUnique(enumtypid: /* oid */ Long, enumsortorder: Float): ConnectionIO[Option[PgEnumRow]] = {
    delay(map.values.find(v => enumtypid == v.enumtypid && enumsortorder == v.enumsortorder))
  }
  override def update(row: PgEnumRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.oid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.oid, row)
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PgEnumFields, PgEnumRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgEnumFields, map)
  }
  override def upsert(unsaved: PgEnumRow): ConnectionIO[PgEnumRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}
