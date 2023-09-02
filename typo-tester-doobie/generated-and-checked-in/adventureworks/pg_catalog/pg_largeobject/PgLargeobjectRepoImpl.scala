/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject

import adventureworks.customtypes.TypoBytea
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgLargeobjectRepoImpl extends PgLargeobjectRepo {
  override def delete(compositeId: PgLargeobjectId): ConnectionIO[Boolean] = {
    sql"""delete from pg_catalog.pg_largeobject where "loid" = ${fromWrite(compositeId.loid)(Write.fromPut(Meta.LongMeta.put))} AND "pageno" = ${fromWrite(compositeId.pageno)(Write.fromPut(Meta.IntMeta.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgLargeobjectFields, PgLargeobjectRow] = {
    DeleteBuilder("pg_catalog.pg_largeobject", PgLargeobjectFields)
  }
  override def insert(unsaved: PgLargeobjectRow): ConnectionIO[PgLargeobjectRow] = {
    sql"""insert into pg_catalog.pg_largeobject("loid", "pageno", "data")
          values (${fromWrite(unsaved.loid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.pageno)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.data)(Write.fromPut(TypoBytea.put))}::bytea)
          returning "loid", "pageno", "data"
       """.query(PgLargeobjectRow.read).unique
  }
  override def select: SelectBuilder[PgLargeobjectFields, PgLargeobjectRow] = {
    SelectBuilderSql("pg_catalog.pg_largeobject", PgLargeobjectFields, PgLargeobjectRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgLargeobjectRow] = {
    sql"""select "loid", "pageno", "data" from pg_catalog.pg_largeobject""".query(PgLargeobjectRow.read).stream
  }
  override def selectById(compositeId: PgLargeobjectId): ConnectionIO[Option[PgLargeobjectRow]] = {
    sql"""select "loid", "pageno", "data" from pg_catalog.pg_largeobject where "loid" = ${fromWrite(compositeId.loid)(Write.fromPut(Meta.LongMeta.put))} AND "pageno" = ${fromWrite(compositeId.pageno)(Write.fromPut(Meta.IntMeta.put))}""".query(PgLargeobjectRow.read).option
  }
  override def update(row: PgLargeobjectRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update pg_catalog.pg_largeobject
          set "data" = ${fromWrite(row.data)(Write.fromPut(TypoBytea.put))}::bytea
          where "loid" = ${fromWrite(compositeId.loid)(Write.fromPut(Meta.LongMeta.put))} AND "pageno" = ${fromWrite(compositeId.pageno)(Write.fromPut(Meta.IntMeta.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgLargeobjectFields, PgLargeobjectRow] = {
    UpdateBuilder("pg_catalog.pg_largeobject", PgLargeobjectFields, PgLargeobjectRow.read)
  }
  override def upsert(unsaved: PgLargeobjectRow): ConnectionIO[PgLargeobjectRow] = {
    sql"""insert into pg_catalog.pg_largeobject("loid", "pageno", "data")
          values (
            ${fromWrite(unsaved.loid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.pageno)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.data)(Write.fromPut(TypoBytea.put))}::bytea
          )
          on conflict ("loid", "pageno")
          do update set
            "data" = EXCLUDED."data"
          returning "loid", "pageno", "data"
       """.query(PgLargeobjectRow.read).unique
  }
}
