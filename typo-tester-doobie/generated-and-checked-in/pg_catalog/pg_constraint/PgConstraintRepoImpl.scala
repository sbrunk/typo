/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_constraint

import adventureworks.TypoPgNodeTree
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

object PgConstraintRepoImpl extends PgConstraintRepo {
  override def delete(oid: PgConstraintId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_constraint where oid = ${fromWrite(oid)(Write.fromPut(PgConstraintId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgConstraintFields, PgConstraintRow] = {
    DeleteBuilder("pg_catalog.pg_constraint", PgConstraintFields)
  }
  override def insert(unsaved: PgConstraintRow): ConnectionIO[PgConstraintRow] = {
    sql"""insert into pg_catalog.pg_constraint(oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgConstraintId.put))}::oid, ${fromWrite(unsaved.conname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.connamespace)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.contype)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.condeferrable)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.condeferred)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.convalidated)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.conrelid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.contypid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.conindid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.conparentid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.confrelid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.confupdtype)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.confdeltype)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.confmatchtype)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.conislocal)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.coninhcount)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.connoinherit)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.conkey)(Write.fromPutOption(adventureworks.IntegerArrayMeta.put))}::_int2, ${fromWrite(unsaved.confkey)(Write.fromPutOption(adventureworks.IntegerArrayMeta.put))}::_int2, ${fromWrite(unsaved.conpfeqop)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::_oid, ${fromWrite(unsaved.conppeqop)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::_oid, ${fromWrite(unsaved.conffeqop)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::_oid, ${fromWrite(unsaved.conexclop)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::_oid, ${fromWrite(unsaved.conbin)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree)
          returning oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin
       """.query(PgConstraintRow.read).unique
  }
  override def select: SelectBuilder[PgConstraintFields, PgConstraintRow] = {
    SelectBuilderSql("pg_catalog.pg_constraint", PgConstraintFields, PgConstraintRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgConstraintRow] = {
    sql"select oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin from pg_catalog.pg_constraint".query(PgConstraintRow.read).stream
  }
  override def selectById(oid: PgConstraintId): ConnectionIO[Option[PgConstraintRow]] = {
    sql"select oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin from pg_catalog.pg_constraint where oid = ${fromWrite(oid)(Write.fromPut(PgConstraintId.put))}".query(PgConstraintRow.read).option
  }
  override def selectByIds(oids: Array[PgConstraintId]): Stream[ConnectionIO, PgConstraintRow] = {
    sql"select oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin from pg_catalog.pg_constraint where oid = ANY(${oids})".query(PgConstraintRow.read).stream
  }
  override def selectByUnique(conrelid: /* oid */ Long, contypid: /* oid */ Long, conname: String): ConnectionIO[Option[PgConstraintRow]] = {
    sql"""select conrelid, contypid, conname
          from pg_catalog.pg_constraint
          where conrelid = ${fromWrite(conrelid)(Write.fromPut(Meta.LongMeta.put))} AND contypid = ${fromWrite(contypid)(Write.fromPut(Meta.LongMeta.put))} AND conname = ${fromWrite(conname)(Write.fromPut(Meta.StringMeta.put))}
       """.query(PgConstraintRow.read).option
  }
  override def update(row: PgConstraintRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_constraint
          set conname = ${fromWrite(row.conname)(Write.fromPut(Meta.StringMeta.put))}::name,
              connamespace = ${fromWrite(row.connamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
              contype = ${fromWrite(row.contype)(Write.fromPut(Meta.StringMeta.put))}::char,
              condeferrable = ${fromWrite(row.condeferrable)(Write.fromPut(Meta.BooleanMeta.put))},
              condeferred = ${fromWrite(row.condeferred)(Write.fromPut(Meta.BooleanMeta.put))},
              convalidated = ${fromWrite(row.convalidated)(Write.fromPut(Meta.BooleanMeta.put))},
              conrelid = ${fromWrite(row.conrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              contypid = ${fromWrite(row.contypid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              conindid = ${fromWrite(row.conindid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              conparentid = ${fromWrite(row.conparentid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              confrelid = ${fromWrite(row.confrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              confupdtype = ${fromWrite(row.confupdtype)(Write.fromPut(Meta.StringMeta.put))}::char,
              confdeltype = ${fromWrite(row.confdeltype)(Write.fromPut(Meta.StringMeta.put))}::char,
              confmatchtype = ${fromWrite(row.confmatchtype)(Write.fromPut(Meta.StringMeta.put))}::char,
              conislocal = ${fromWrite(row.conislocal)(Write.fromPut(Meta.BooleanMeta.put))},
              coninhcount = ${fromWrite(row.coninhcount)(Write.fromPut(Meta.IntMeta.put))}::int4,
              connoinherit = ${fromWrite(row.connoinherit)(Write.fromPut(Meta.BooleanMeta.put))},
              conkey = ${fromWrite(row.conkey)(Write.fromPutOption(adventureworks.IntegerArrayMeta.put))}::_int2,
              confkey = ${fromWrite(row.confkey)(Write.fromPutOption(adventureworks.IntegerArrayMeta.put))}::_int2,
              conpfeqop = ${fromWrite(row.conpfeqop)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::_oid,
              conppeqop = ${fromWrite(row.conppeqop)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::_oid,
              conffeqop = ${fromWrite(row.conffeqop)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::_oid,
              conexclop = ${fromWrite(row.conexclop)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::_oid,
              conbin = ${fromWrite(row.conbin)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree
          where oid = ${fromWrite(oid)(Write.fromPut(PgConstraintId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgConstraintFields, PgConstraintRow] = {
    UpdateBuilder("pg_catalog.pg_constraint", PgConstraintFields, PgConstraintRow.read)
  }
  override def upsert(unsaved: PgConstraintRow): ConnectionIO[PgConstraintRow] = {
    sql"""insert into pg_catalog.pg_constraint(oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgConstraintId.put))}::oid,
            ${fromWrite(unsaved.conname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.connamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.contype)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.condeferrable)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.condeferred)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.convalidated)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.conrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.contypid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.conindid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.conparentid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.confrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.confupdtype)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.confdeltype)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.confmatchtype)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.conislocal)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.coninhcount)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.connoinherit)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.conkey)(Write.fromPutOption(adventureworks.IntegerArrayMeta.put))}::_int2,
            ${fromWrite(unsaved.confkey)(Write.fromPutOption(adventureworks.IntegerArrayMeta.put))}::_int2,
            ${fromWrite(unsaved.conpfeqop)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::_oid,
            ${fromWrite(unsaved.conppeqop)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::_oid,
            ${fromWrite(unsaved.conffeqop)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::_oid,
            ${fromWrite(unsaved.conexclop)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::_oid,
            ${fromWrite(unsaved.conbin)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree
          )
          on conflict (oid)
          do update set
            conname = EXCLUDED.conname,
            connamespace = EXCLUDED.connamespace,
            contype = EXCLUDED.contype,
            condeferrable = EXCLUDED.condeferrable,
            condeferred = EXCLUDED.condeferred,
            convalidated = EXCLUDED.convalidated,
            conrelid = EXCLUDED.conrelid,
            contypid = EXCLUDED.contypid,
            conindid = EXCLUDED.conindid,
            conparentid = EXCLUDED.conparentid,
            confrelid = EXCLUDED.confrelid,
            confupdtype = EXCLUDED.confupdtype,
            confdeltype = EXCLUDED.confdeltype,
            confmatchtype = EXCLUDED.confmatchtype,
            conislocal = EXCLUDED.conislocal,
            coninhcount = EXCLUDED.coninhcount,
            connoinherit = EXCLUDED.connoinherit,
            conkey = EXCLUDED.conkey,
            confkey = EXCLUDED.confkey,
            conpfeqop = EXCLUDED.conpfeqop,
            conppeqop = EXCLUDED.conppeqop,
            conffeqop = EXCLUDED.conffeqop,
            conexclop = EXCLUDED.conexclop,
            conbin = EXCLUDED.conbin
          returning oid, conname, connamespace, contype, condeferrable, condeferred, convalidated, conrelid, contypid, conindid, conparentid, confrelid, confupdtype, confdeltype, confmatchtype, conislocal, coninhcount, connoinherit, conkey, confkey, conpfeqop, conppeqop, conffeqop, conexclop, conbin
       """.query(PgConstraintRow.read).unique
  }
}
