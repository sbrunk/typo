/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_authid

import adventureworks.TypoOffsetDateTime
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream

object PgAuthidRepoImpl extends PgAuthidRepo {
  override def delete(oid: PgAuthidId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_authid where oid = ${fromWrite(oid)(Write.fromPut(PgAuthidId.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgAuthidRow): ConnectionIO[PgAuthidRow] = {
    sql"""insert into pg_catalog.pg_authid(oid, rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolbypassrls, rolconnlimit, rolpassword, rolvaliduntil)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgAuthidId.put))}::oid, ${fromWrite(unsaved.rolname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.rolsuper)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.rolinherit)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.rolcreaterole)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.rolcreatedb)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.rolcanlogin)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.rolreplication)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.rolbypassrls)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.rolconnlimit)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.rolpassword)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.rolvaliduntil)(Write.fromPutOption(TypoOffsetDateTime.put))}::timestamptz)
          returning oid, rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolbypassrls, rolconnlimit, rolpassword, rolvaliduntil::text
       """.query(PgAuthidRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgAuthidRow] = {
    sql"select oid, rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolbypassrls, rolconnlimit, rolpassword, rolvaliduntil::text from pg_catalog.pg_authid".query(PgAuthidRow.read).stream
  }
  override def selectById(oid: PgAuthidId): ConnectionIO[Option[PgAuthidRow]] = {
    sql"select oid, rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolbypassrls, rolconnlimit, rolpassword, rolvaliduntil::text from pg_catalog.pg_authid where oid = ${fromWrite(oid)(Write.fromPut(PgAuthidId.put))}".query(PgAuthidRow.read).option
  }
  override def selectByIds(oids: Array[PgAuthidId]): Stream[ConnectionIO, PgAuthidRow] = {
    sql"select oid, rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolbypassrls, rolconnlimit, rolpassword, rolvaliduntil::text from pg_catalog.pg_authid where oid = ANY(${fromWrite(oids)(Write.fromPut(PgAuthidId.arrayPut))})".query(PgAuthidRow.read).stream
  }
  override def update(row: PgAuthidRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_authid
          set rolname = ${fromWrite(row.rolname)(Write.fromPut(Meta.StringMeta.put))}::name,
              rolsuper = ${fromWrite(row.rolsuper)(Write.fromPut(Meta.BooleanMeta.put))},
              rolinherit = ${fromWrite(row.rolinherit)(Write.fromPut(Meta.BooleanMeta.put))},
              rolcreaterole = ${fromWrite(row.rolcreaterole)(Write.fromPut(Meta.BooleanMeta.put))},
              rolcreatedb = ${fromWrite(row.rolcreatedb)(Write.fromPut(Meta.BooleanMeta.put))},
              rolcanlogin = ${fromWrite(row.rolcanlogin)(Write.fromPut(Meta.BooleanMeta.put))},
              rolreplication = ${fromWrite(row.rolreplication)(Write.fromPut(Meta.BooleanMeta.put))},
              rolbypassrls = ${fromWrite(row.rolbypassrls)(Write.fromPut(Meta.BooleanMeta.put))},
              rolconnlimit = ${fromWrite(row.rolconnlimit)(Write.fromPut(Meta.IntMeta.put))}::int4,
              rolpassword = ${fromWrite(row.rolpassword)(Write.fromPutOption(Meta.StringMeta.put))},
              rolvaliduntil = ${fromWrite(row.rolvaliduntil)(Write.fromPutOption(TypoOffsetDateTime.put))}::timestamptz
          where oid = ${fromWrite(oid)(Write.fromPut(PgAuthidId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgAuthidRow): ConnectionIO[PgAuthidRow] = {
    sql"""insert into pg_catalog.pg_authid(oid, rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolbypassrls, rolconnlimit, rolpassword, rolvaliduntil)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgAuthidId.put))}::oid,
            ${fromWrite(unsaved.rolname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.rolsuper)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.rolinherit)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.rolcreaterole)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.rolcreatedb)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.rolcanlogin)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.rolreplication)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.rolbypassrls)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.rolconnlimit)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.rolpassword)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.rolvaliduntil)(Write.fromPutOption(TypoOffsetDateTime.put))}::timestamptz
          )
          on conflict (oid)
          do update set
            rolname = EXCLUDED.rolname,
            rolsuper = EXCLUDED.rolsuper,
            rolinherit = EXCLUDED.rolinherit,
            rolcreaterole = EXCLUDED.rolcreaterole,
            rolcreatedb = EXCLUDED.rolcreatedb,
            rolcanlogin = EXCLUDED.rolcanlogin,
            rolreplication = EXCLUDED.rolreplication,
            rolbypassrls = EXCLUDED.rolbypassrls,
            rolconnlimit = EXCLUDED.rolconnlimit,
            rolpassword = EXCLUDED.rolpassword,
            rolvaliduntil = EXCLUDED.rolvaliduntil
          returning oid, rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolbypassrls, rolconnlimit, rolpassword, rolvaliduntil::text
       """.query(PgAuthidRow.read).unique
  }
}
