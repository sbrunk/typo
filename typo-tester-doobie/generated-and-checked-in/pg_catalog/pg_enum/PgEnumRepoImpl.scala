/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_enum

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

object PgEnumRepoImpl extends PgEnumRepo {
  override def delete(oid: PgEnumId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_enum where oid = ${fromWrite(oid)(Write.fromPut(PgEnumId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgEnumFields, PgEnumRow] = {
    DeleteBuilder("pg_catalog.pg_enum", PgEnumFields)
  }
  override def insert(unsaved: PgEnumRow): ConnectionIO[PgEnumRow] = {
    sql"""insert into pg_catalog.pg_enum(oid, enumtypid, enumsortorder, enumlabel)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgEnumId.put))}::oid, ${fromWrite(unsaved.enumtypid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.enumsortorder)(Write.fromPut(Meta.FloatMeta.put))}::float4, ${fromWrite(unsaved.enumlabel)(Write.fromPut(Meta.StringMeta.put))}::name)
          returning oid, enumtypid, enumsortorder, enumlabel
       """.query(PgEnumRow.read).unique
  }
  override def select: SelectBuilder[PgEnumFields, PgEnumRow] = {
    SelectBuilderSql("pg_catalog.pg_enum", PgEnumFields, PgEnumRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgEnumRow] = {
    sql"select oid, enumtypid, enumsortorder, enumlabel from pg_catalog.pg_enum".query(PgEnumRow.read).stream
  }
  override def selectById(oid: PgEnumId): ConnectionIO[Option[PgEnumRow]] = {
    sql"select oid, enumtypid, enumsortorder, enumlabel from pg_catalog.pg_enum where oid = ${fromWrite(oid)(Write.fromPut(PgEnumId.put))}".query(PgEnumRow.read).option
  }
  override def selectByIds(oids: Array[PgEnumId]): Stream[ConnectionIO, PgEnumRow] = {
    sql"select oid, enumtypid, enumsortorder, enumlabel from pg_catalog.pg_enum where oid = ANY(${oids})".query(PgEnumRow.read).stream
  }
  override def selectByUnique(enumtypid: /* oid */ Long, enumlabel: String): ConnectionIO[Option[PgEnumRow]] = {
    sql"""select enumtypid, enumlabel
          from pg_catalog.pg_enum
          where enumtypid = ${fromWrite(enumtypid)(Write.fromPut(Meta.LongMeta.put))} AND enumlabel = ${fromWrite(enumlabel)(Write.fromPut(Meta.StringMeta.put))}
       """.query(PgEnumRow.read).option
  }
  override def selectByUnique(enumtypid: /* oid */ Long, enumsortorder: Float): ConnectionIO[Option[PgEnumRow]] = {
    sql"""select enumtypid, enumsortorder
          from pg_catalog.pg_enum
          where enumtypid = ${fromWrite(enumtypid)(Write.fromPut(Meta.LongMeta.put))} AND enumsortorder = ${fromWrite(enumsortorder)(Write.fromPut(Meta.FloatMeta.put))}
       """.query(PgEnumRow.read).option
  }
  override def update(row: PgEnumRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_enum
          set enumtypid = ${fromWrite(row.enumtypid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              enumsortorder = ${fromWrite(row.enumsortorder)(Write.fromPut(Meta.FloatMeta.put))}::float4,
              enumlabel = ${fromWrite(row.enumlabel)(Write.fromPut(Meta.StringMeta.put))}::name
          where oid = ${fromWrite(oid)(Write.fromPut(PgEnumId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgEnumFields, PgEnumRow] = {
    UpdateBuilder("pg_catalog.pg_enum", PgEnumFields, PgEnumRow.read)
  }
  override def upsert(unsaved: PgEnumRow): ConnectionIO[PgEnumRow] = {
    sql"""insert into pg_catalog.pg_enum(oid, enumtypid, enumsortorder, enumlabel)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgEnumId.put))}::oid,
            ${fromWrite(unsaved.enumtypid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.enumsortorder)(Write.fromPut(Meta.FloatMeta.put))}::float4,
            ${fromWrite(unsaved.enumlabel)(Write.fromPut(Meta.StringMeta.put))}::name
          )
          on conflict (oid)
          do update set
            enumtypid = EXCLUDED.enumtypid,
            enumsortorder = EXCLUDED.enumsortorder,
            enumlabel = EXCLUDED.enumlabel
          returning oid, enumtypid, enumsortorder, enumlabel
       """.query(PgEnumRow.read).unique
  }
}
