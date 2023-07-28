/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_am

import adventureworks.TypoRegproc
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream

object PgAmRepoImpl extends PgAmRepo {
  override def delete(oid: PgAmId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_am where oid = ${fromWrite(oid)(Write.fromPut(PgAmId.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgAmRow): ConnectionIO[PgAmRow] = {
    sql"""insert into pg_catalog.pg_am(oid, amname, amhandler, amtype)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgAmId.put))}::oid, ${fromWrite(unsaved.amname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.amhandler)(Write.fromPut(TypoRegproc.put))}::regproc, ${fromWrite(unsaved.amtype)(Write.fromPut(Meta.StringMeta.put))}::char)
          returning oid, amname, amhandler, amtype
       """.query(PgAmRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgAmRow] = {
    sql"select oid, amname, amhandler, amtype from pg_catalog.pg_am".query(PgAmRow.read).stream
  }
  override def selectById(oid: PgAmId): ConnectionIO[Option[PgAmRow]] = {
    sql"select oid, amname, amhandler, amtype from pg_catalog.pg_am where oid = ${fromWrite(oid)(Write.fromPut(PgAmId.put))}".query(PgAmRow.read).option
  }
  override def selectByIds(oids: Array[PgAmId]): Stream[ConnectionIO, PgAmRow] = {
    sql"select oid, amname, amhandler, amtype from pg_catalog.pg_am where oid = ANY(${fromWrite(oids)(Write.fromPut(PgAmId.arrayPut))})".query(PgAmRow.read).stream
  }
  override def update(row: PgAmRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_am
          set amname = ${fromWrite(row.amname)(Write.fromPut(Meta.StringMeta.put))}::name,
              amhandler = ${fromWrite(row.amhandler)(Write.fromPut(TypoRegproc.put))}::regproc,
              amtype = ${fromWrite(row.amtype)(Write.fromPut(Meta.StringMeta.put))}::char
          where oid = ${fromWrite(oid)(Write.fromPut(PgAmId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgAmRow): ConnectionIO[PgAmRow] = {
    sql"""insert into pg_catalog.pg_am(oid, amname, amhandler, amtype)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgAmId.put))}::oid,
            ${fromWrite(unsaved.amname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.amhandler)(Write.fromPut(TypoRegproc.put))}::regproc,
            ${fromWrite(unsaved.amtype)(Write.fromPut(Meta.StringMeta.put))}::char
          )
          on conflict (oid)
          do update set
            amname = EXCLUDED.amname,
            amhandler = EXCLUDED.amhandler,
            amtype = EXCLUDED.amtype
          returning oid, amname, amhandler, amtype
       """.query(PgAmRow.read).unique
  }
}
