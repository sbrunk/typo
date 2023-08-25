/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_policy

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

class PgPolicyRepoMock(map: scala.collection.mutable.Map[PgPolicyId, PgPolicyRow] = scala.collection.mutable.Map.empty) extends PgPolicyRepo {
  override def delete(oid: PgPolicyId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgPolicyFields, PgPolicyRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgPolicyFields, map)
  }
  override def insert(unsaved: PgPolicyRow): ConnectionIO[PgPolicyRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def select: SelectBuilder[PgPolicyFields, PgPolicyRow] = {
    SelectBuilderMock(PgPolicyFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgPolicyRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgPolicyId): ConnectionIO[Option[PgPolicyRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgPolicyId]): Stream[ConnectionIO, PgPolicyRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def selectByUnique(polrelid: /* oid */ Long, polname: String): ConnectionIO[Option[PgPolicyRow]] = {
    delay(map.values.find(v => polrelid == v.polrelid && polname == v.polname))
  }
  override def update(row: PgPolicyRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PgPolicyFields, PgPolicyRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgPolicyFields, map)
  }
  override def upsert(unsaved: PgPolicyRow): ConnectionIO[PgPolicyRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}
