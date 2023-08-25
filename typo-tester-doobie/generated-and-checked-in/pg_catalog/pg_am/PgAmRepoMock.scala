/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_am

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

class PgAmRepoMock(map: scala.collection.mutable.Map[PgAmId, PgAmRow] = scala.collection.mutable.Map.empty) extends PgAmRepo {
  override def delete(oid: PgAmId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgAmFields, PgAmRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgAmFields, map)
  }
  override def insert(unsaved: PgAmRow): ConnectionIO[PgAmRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def select: SelectBuilder[PgAmFields, PgAmRow] = {
    SelectBuilderMock(PgAmFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgAmRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgAmId): ConnectionIO[Option[PgAmRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgAmId]): Stream[ConnectionIO, PgAmRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def selectByUnique(amname: String): ConnectionIO[Option[PgAmRow]] = {
    delay(map.values.find(v => amname == v.amname))
  }
  override def update(row: PgAmRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PgAmFields, PgAmRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgAmFields, map)
  }
  override def upsert(unsaved: PgAmRow): ConnectionIO[PgAmRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}
