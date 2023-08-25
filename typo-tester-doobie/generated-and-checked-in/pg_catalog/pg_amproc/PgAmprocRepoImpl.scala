/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amproc

import adventureworks.TypoRegproc
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

object PgAmprocRepoImpl extends PgAmprocRepo {
  override def delete(oid: PgAmprocId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_amproc where oid = ${fromWrite(oid)(Write.fromPut(PgAmprocId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgAmprocFields, PgAmprocRow] = {
    DeleteBuilder("pg_catalog.pg_amproc", PgAmprocFields)
  }
  override def insert(unsaved: PgAmprocRow): ConnectionIO[PgAmprocRow] = {
    sql"""insert into pg_catalog.pg_amproc(oid, amprocfamily, amproclefttype, amprocrighttype, amprocnum, amproc)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgAmprocId.put))}::oid, ${fromWrite(unsaved.amprocfamily)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.amproclefttype)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.amprocrighttype)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.amprocnum)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.amproc)(Write.fromPut(TypoRegproc.put))}::regproc)
          returning oid, amprocfamily, amproclefttype, amprocrighttype, amprocnum, amproc
       """.query(PgAmprocRow.read).unique
  }
  override def select: SelectBuilder[PgAmprocFields, PgAmprocRow] = {
    SelectBuilderSql("pg_catalog.pg_amproc", PgAmprocFields, PgAmprocRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgAmprocRow] = {
    sql"select oid, amprocfamily, amproclefttype, amprocrighttype, amprocnum, amproc from pg_catalog.pg_amproc".query(PgAmprocRow.read).stream
  }
  override def selectById(oid: PgAmprocId): ConnectionIO[Option[PgAmprocRow]] = {
    sql"select oid, amprocfamily, amproclefttype, amprocrighttype, amprocnum, amproc from pg_catalog.pg_amproc where oid = ${fromWrite(oid)(Write.fromPut(PgAmprocId.put))}".query(PgAmprocRow.read).option
  }
  override def selectByIds(oids: Array[PgAmprocId]): Stream[ConnectionIO, PgAmprocRow] = {
    sql"select oid, amprocfamily, amproclefttype, amprocrighttype, amprocnum, amproc from pg_catalog.pg_amproc where oid = ANY(${oids})".query(PgAmprocRow.read).stream
  }
  override def selectByUnique(amprocfamily: /* oid */ Long, amproclefttype: /* oid */ Long, amprocrighttype: /* oid */ Long, amprocnum: Int): ConnectionIO[Option[PgAmprocRow]] = {
    sql"""select amprocfamily, amproclefttype, amprocrighttype, amprocnum
          from pg_catalog.pg_amproc
          where amprocfamily = ${fromWrite(amprocfamily)(Write.fromPut(Meta.LongMeta.put))} AND amproclefttype = ${fromWrite(amproclefttype)(Write.fromPut(Meta.LongMeta.put))} AND amprocrighttype = ${fromWrite(amprocrighttype)(Write.fromPut(Meta.LongMeta.put))} AND amprocnum = ${fromWrite(amprocnum)(Write.fromPut(Meta.IntMeta.put))}
       """.query(PgAmprocRow.read).option
  }
  override def update(row: PgAmprocRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_amproc
          set amprocfamily = ${fromWrite(row.amprocfamily)(Write.fromPut(Meta.LongMeta.put))}::oid,
              amproclefttype = ${fromWrite(row.amproclefttype)(Write.fromPut(Meta.LongMeta.put))}::oid,
              amprocrighttype = ${fromWrite(row.amprocrighttype)(Write.fromPut(Meta.LongMeta.put))}::oid,
              amprocnum = ${fromWrite(row.amprocnum)(Write.fromPut(Meta.IntMeta.put))}::int2,
              amproc = ${fromWrite(row.amproc)(Write.fromPut(TypoRegproc.put))}::regproc
          where oid = ${fromWrite(oid)(Write.fromPut(PgAmprocId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgAmprocFields, PgAmprocRow] = {
    UpdateBuilder("pg_catalog.pg_amproc", PgAmprocFields, PgAmprocRow.read)
  }
  override def upsert(unsaved: PgAmprocRow): ConnectionIO[PgAmprocRow] = {
    sql"""insert into pg_catalog.pg_amproc(oid, amprocfamily, amproclefttype, amprocrighttype, amprocnum, amproc)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgAmprocId.put))}::oid,
            ${fromWrite(unsaved.amprocfamily)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.amproclefttype)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.amprocrighttype)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.amprocnum)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.amproc)(Write.fromPut(TypoRegproc.put))}::regproc
          )
          on conflict (oid)
          do update set
            amprocfamily = EXCLUDED.amprocfamily,
            amproclefttype = EXCLUDED.amproclefttype,
            amprocrighttype = EXCLUDED.amprocrighttype,
            amprocnum = EXCLUDED.amprocnum,
            amproc = EXCLUDED.amproc
          returning oid, amprocfamily, amproclefttype, amprocrighttype, amprocnum, amproc
       """.query(PgAmprocRow.read).unique
  }
}
