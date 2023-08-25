/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_parser

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

class PgTsParserRepoMock(map: scala.collection.mutable.Map[PgTsParserId, PgTsParserRow] = scala.collection.mutable.Map.empty) extends PgTsParserRepo {
  override def delete(oid: PgTsParserId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgTsParserFields, PgTsParserRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgTsParserFields, map)
  }
  override def insert(unsaved: PgTsParserRow): ConnectionIO[PgTsParserRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def select: SelectBuilder[PgTsParserFields, PgTsParserRow] = {
    SelectBuilderMock(PgTsParserFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PgTsParserRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgTsParserId): ConnectionIO[Option[PgTsParserRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgTsParserId]): Stream[ConnectionIO, PgTsParserRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def selectByUnique(prsname: String, prsnamespace: /* oid */ Long): ConnectionIO[Option[PgTsParserRow]] = {
    delay(map.values.find(v => prsname == v.prsname && prsnamespace == v.prsnamespace))
  }
  override def update(row: PgTsParserRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[PgTsParserFields, PgTsParserRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgTsParserFields, map)
  }
  override def upsert(unsaved: PgTsParserRow): ConnectionIO[PgTsParserRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}
