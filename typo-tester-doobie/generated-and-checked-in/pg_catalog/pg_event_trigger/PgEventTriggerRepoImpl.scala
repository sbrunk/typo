/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_event_trigger

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

object PgEventTriggerRepoImpl extends PgEventTriggerRepo {
  override def delete(oid: PgEventTriggerId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_event_trigger where oid = ${fromWrite(oid)(Write.fromPut(PgEventTriggerId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgEventTriggerFields, PgEventTriggerRow] = {
    DeleteBuilder("pg_catalog.pg_event_trigger", PgEventTriggerFields)
  }
  override def insert(unsaved: PgEventTriggerRow): ConnectionIO[PgEventTriggerRow] = {
    sql"""insert into pg_catalog.pg_event_trigger(oid, evtname, evtevent, evtowner, evtfoid, evtenabled, evttags)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgEventTriggerId.put))}::oid, ${fromWrite(unsaved.evtname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.evtevent)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.evtowner)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.evtfoid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.evtenabled)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.evttags)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text)
          returning oid, evtname, evtevent, evtowner, evtfoid, evtenabled, evttags
       """.query(PgEventTriggerRow.read).unique
  }
  override def select: SelectBuilder[PgEventTriggerFields, PgEventTriggerRow] = {
    SelectBuilderSql("pg_catalog.pg_event_trigger", PgEventTriggerFields, PgEventTriggerRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgEventTriggerRow] = {
    sql"select oid, evtname, evtevent, evtowner, evtfoid, evtenabled, evttags from pg_catalog.pg_event_trigger".query(PgEventTriggerRow.read).stream
  }
  override def selectById(oid: PgEventTriggerId): ConnectionIO[Option[PgEventTriggerRow]] = {
    sql"select oid, evtname, evtevent, evtowner, evtfoid, evtenabled, evttags from pg_catalog.pg_event_trigger where oid = ${fromWrite(oid)(Write.fromPut(PgEventTriggerId.put))}".query(PgEventTriggerRow.read).option
  }
  override def selectByIds(oids: Array[PgEventTriggerId]): Stream[ConnectionIO, PgEventTriggerRow] = {
    sql"select oid, evtname, evtevent, evtowner, evtfoid, evtenabled, evttags from pg_catalog.pg_event_trigger where oid = ANY(${oids})".query(PgEventTriggerRow.read).stream
  }
  override def selectByUnique(evtname: String): ConnectionIO[Option[PgEventTriggerRow]] = {
    sql"""select evtname
          from pg_catalog.pg_event_trigger
          where evtname = ${fromWrite(evtname)(Write.fromPut(Meta.StringMeta.put))}
       """.query(PgEventTriggerRow.read).option
  }
  override def update(row: PgEventTriggerRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_event_trigger
          set evtname = ${fromWrite(row.evtname)(Write.fromPut(Meta.StringMeta.put))}::name,
              evtevent = ${fromWrite(row.evtevent)(Write.fromPut(Meta.StringMeta.put))}::name,
              evtowner = ${fromWrite(row.evtowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
              evtfoid = ${fromWrite(row.evtfoid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              evtenabled = ${fromWrite(row.evtenabled)(Write.fromPut(Meta.StringMeta.put))}::char,
              evttags = ${fromWrite(row.evttags)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text
          where oid = ${fromWrite(oid)(Write.fromPut(PgEventTriggerId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgEventTriggerFields, PgEventTriggerRow] = {
    UpdateBuilder("pg_catalog.pg_event_trigger", PgEventTriggerFields, PgEventTriggerRow.read)
  }
  override def upsert(unsaved: PgEventTriggerRow): ConnectionIO[PgEventTriggerRow] = {
    sql"""insert into pg_catalog.pg_event_trigger(oid, evtname, evtevent, evtowner, evtfoid, evtenabled, evttags)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgEventTriggerId.put))}::oid,
            ${fromWrite(unsaved.evtname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.evtevent)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.evtowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.evtfoid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.evtenabled)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.evttags)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text
          )
          on conflict (oid)
          do update set
            evtname = EXCLUDED.evtname,
            evtevent = EXCLUDED.evtevent,
            evtowner = EXCLUDED.evtowner,
            evtfoid = EXCLUDED.evtfoid,
            evtenabled = EXCLUDED.evtenabled,
            evttags = EXCLUDED.evttags
          returning oid, evtname, evtevent, evtowner, evtfoid, evtenabled, evttags
       """.query(PgEventTriggerRow.read).unique
  }
}
