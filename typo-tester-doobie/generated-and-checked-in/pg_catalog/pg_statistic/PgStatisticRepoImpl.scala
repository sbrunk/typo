/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic

import adventureworks.TypoAnyArray
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream

object PgStatisticRepoImpl extends PgStatisticRepo {
  override def delete(compositeId: PgStatisticId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_statistic where starelid = ${fromWrite(compositeId.starelid)(Write.fromPut(Meta.LongMeta.put))} AND staattnum = ${fromWrite(compositeId.staattnum)(Write.fromPut(Meta.IntMeta.put))} AND stainherit = ${fromWrite(compositeId.stainherit)(Write.fromPut(Meta.BooleanMeta.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgStatisticRow): ConnectionIO[PgStatisticRow] = {
    sql"""insert into pg_catalog.pg_statistic(starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5)
          values (${fromWrite(unsaved.starelid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.staattnum)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.stainherit)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.stanullfrac)(Write.fromPut(Meta.FloatMeta.put))}::float4, ${fromWrite(unsaved.stawidth)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.stadistinct)(Write.fromPut(Meta.FloatMeta.put))}::float4, ${fromWrite(unsaved.stakind1)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.stakind2)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.stakind3)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.stakind4)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.stakind5)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.staop1)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.staop2)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.staop3)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.staop4)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.staop5)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.stacoll1)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.stacoll2)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.stacoll3)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.stacoll4)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.stacoll5)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.stanumbers1)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4, ${fromWrite(unsaved.stanumbers2)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4, ${fromWrite(unsaved.stanumbers3)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4, ${fromWrite(unsaved.stanumbers4)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4, ${fromWrite(unsaved.stanumbers5)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4, ${fromWrite(unsaved.stavalues1)(Write.fromPutOption(TypoAnyArray.put))}::anyarray, ${fromWrite(unsaved.stavalues2)(Write.fromPutOption(TypoAnyArray.put))}::anyarray, ${fromWrite(unsaved.stavalues3)(Write.fromPutOption(TypoAnyArray.put))}::anyarray, ${fromWrite(unsaved.stavalues4)(Write.fromPutOption(TypoAnyArray.put))}::anyarray, ${fromWrite(unsaved.stavalues5)(Write.fromPutOption(TypoAnyArray.put))}::anyarray)
          returning starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5
       """.query(PgStatisticRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgStatisticRow] = {
    sql"select starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5 from pg_catalog.pg_statistic".query(PgStatisticRow.read).stream
  }
  override def selectById(compositeId: PgStatisticId): ConnectionIO[Option[PgStatisticRow]] = {
    sql"select starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5 from pg_catalog.pg_statistic where starelid = ${fromWrite(compositeId.starelid)(Write.fromPut(Meta.LongMeta.put))} AND staattnum = ${fromWrite(compositeId.staattnum)(Write.fromPut(Meta.IntMeta.put))} AND stainherit = ${fromWrite(compositeId.stainherit)(Write.fromPut(Meta.BooleanMeta.put))}".query(PgStatisticRow.read).option
  }
  override def update(row: PgStatisticRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update pg_catalog.pg_statistic
          set stanullfrac = ${fromWrite(row.stanullfrac)(Write.fromPut(Meta.FloatMeta.put))}::float4,
              stawidth = ${fromWrite(row.stawidth)(Write.fromPut(Meta.IntMeta.put))}::int4,
              stadistinct = ${fromWrite(row.stadistinct)(Write.fromPut(Meta.FloatMeta.put))}::float4,
              stakind1 = ${fromWrite(row.stakind1)(Write.fromPut(Meta.IntMeta.put))}::int2,
              stakind2 = ${fromWrite(row.stakind2)(Write.fromPut(Meta.IntMeta.put))}::int2,
              stakind3 = ${fromWrite(row.stakind3)(Write.fromPut(Meta.IntMeta.put))}::int2,
              stakind4 = ${fromWrite(row.stakind4)(Write.fromPut(Meta.IntMeta.put))}::int2,
              stakind5 = ${fromWrite(row.stakind5)(Write.fromPut(Meta.IntMeta.put))}::int2,
              staop1 = ${fromWrite(row.staop1)(Write.fromPut(Meta.LongMeta.put))}::oid,
              staop2 = ${fromWrite(row.staop2)(Write.fromPut(Meta.LongMeta.put))}::oid,
              staop3 = ${fromWrite(row.staop3)(Write.fromPut(Meta.LongMeta.put))}::oid,
              staop4 = ${fromWrite(row.staop4)(Write.fromPut(Meta.LongMeta.put))}::oid,
              staop5 = ${fromWrite(row.staop5)(Write.fromPut(Meta.LongMeta.put))}::oid,
              stacoll1 = ${fromWrite(row.stacoll1)(Write.fromPut(Meta.LongMeta.put))}::oid,
              stacoll2 = ${fromWrite(row.stacoll2)(Write.fromPut(Meta.LongMeta.put))}::oid,
              stacoll3 = ${fromWrite(row.stacoll3)(Write.fromPut(Meta.LongMeta.put))}::oid,
              stacoll4 = ${fromWrite(row.stacoll4)(Write.fromPut(Meta.LongMeta.put))}::oid,
              stacoll5 = ${fromWrite(row.stacoll5)(Write.fromPut(Meta.LongMeta.put))}::oid,
              stanumbers1 = ${fromWrite(row.stanumbers1)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4,
              stanumbers2 = ${fromWrite(row.stanumbers2)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4,
              stanumbers3 = ${fromWrite(row.stanumbers3)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4,
              stanumbers4 = ${fromWrite(row.stanumbers4)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4,
              stanumbers5 = ${fromWrite(row.stanumbers5)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4,
              stavalues1 = ${fromWrite(row.stavalues1)(Write.fromPutOption(TypoAnyArray.put))}::anyarray,
              stavalues2 = ${fromWrite(row.stavalues2)(Write.fromPutOption(TypoAnyArray.put))}::anyarray,
              stavalues3 = ${fromWrite(row.stavalues3)(Write.fromPutOption(TypoAnyArray.put))}::anyarray,
              stavalues4 = ${fromWrite(row.stavalues4)(Write.fromPutOption(TypoAnyArray.put))}::anyarray,
              stavalues5 = ${fromWrite(row.stavalues5)(Write.fromPutOption(TypoAnyArray.put))}::anyarray
          where starelid = ${fromWrite(compositeId.starelid)(Write.fromPut(Meta.LongMeta.put))} AND staattnum = ${fromWrite(compositeId.staattnum)(Write.fromPut(Meta.IntMeta.put))} AND stainherit = ${fromWrite(compositeId.stainherit)(Write.fromPut(Meta.BooleanMeta.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgStatisticRow): ConnectionIO[PgStatisticRow] = {
    sql"""insert into pg_catalog.pg_statistic(starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5)
          values (
            ${fromWrite(unsaved.starelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.staattnum)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.stainherit)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.stanullfrac)(Write.fromPut(Meta.FloatMeta.put))}::float4,
            ${fromWrite(unsaved.stawidth)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.stadistinct)(Write.fromPut(Meta.FloatMeta.put))}::float4,
            ${fromWrite(unsaved.stakind1)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.stakind2)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.stakind3)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.stakind4)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.stakind5)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.staop1)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.staop2)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.staop3)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.staop4)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.staop5)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.stacoll1)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.stacoll2)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.stacoll3)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.stacoll4)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.stacoll5)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.stanumbers1)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4,
            ${fromWrite(unsaved.stanumbers2)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4,
            ${fromWrite(unsaved.stanumbers3)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4,
            ${fromWrite(unsaved.stanumbers4)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4,
            ${fromWrite(unsaved.stanumbers5)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::_float4,
            ${fromWrite(unsaved.stavalues1)(Write.fromPutOption(TypoAnyArray.put))}::anyarray,
            ${fromWrite(unsaved.stavalues2)(Write.fromPutOption(TypoAnyArray.put))}::anyarray,
            ${fromWrite(unsaved.stavalues3)(Write.fromPutOption(TypoAnyArray.put))}::anyarray,
            ${fromWrite(unsaved.stavalues4)(Write.fromPutOption(TypoAnyArray.put))}::anyarray,
            ${fromWrite(unsaved.stavalues5)(Write.fromPutOption(TypoAnyArray.put))}::anyarray
          )
          on conflict (starelid, staattnum, stainherit)
          do update set
            stanullfrac = EXCLUDED.stanullfrac,
            stawidth = EXCLUDED.stawidth,
            stadistinct = EXCLUDED.stadistinct,
            stakind1 = EXCLUDED.stakind1,
            stakind2 = EXCLUDED.stakind2,
            stakind3 = EXCLUDED.stakind3,
            stakind4 = EXCLUDED.stakind4,
            stakind5 = EXCLUDED.stakind5,
            staop1 = EXCLUDED.staop1,
            staop2 = EXCLUDED.staop2,
            staop3 = EXCLUDED.staop3,
            staop4 = EXCLUDED.staop4,
            staop5 = EXCLUDED.staop5,
            stacoll1 = EXCLUDED.stacoll1,
            stacoll2 = EXCLUDED.stacoll2,
            stacoll3 = EXCLUDED.stacoll3,
            stacoll4 = EXCLUDED.stacoll4,
            stacoll5 = EXCLUDED.stacoll5,
            stanumbers1 = EXCLUDED.stanumbers1,
            stanumbers2 = EXCLUDED.stanumbers2,
            stanumbers3 = EXCLUDED.stanumbers3,
            stanumbers4 = EXCLUDED.stanumbers4,
            stanumbers5 = EXCLUDED.stanumbers5,
            stavalues1 = EXCLUDED.stavalues1,
            stavalues2 = EXCLUDED.stavalues2,
            stavalues3 = EXCLUDED.stavalues3,
            stavalues4 = EXCLUDED.stavalues4,
            stavalues5 = EXCLUDED.stavalues5
          returning starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5
       """.query(PgStatisticRow.read).unique
  }
}
