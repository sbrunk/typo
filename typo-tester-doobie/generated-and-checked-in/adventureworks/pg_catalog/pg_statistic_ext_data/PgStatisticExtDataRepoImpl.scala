/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext_data

import adventureworks.customtypes.TypoUnknownPgDependencies
import adventureworks.customtypes.TypoUnknownPgMcvList
import adventureworks.customtypes.TypoUnknownPgNdistinct
import adventureworks.customtypes.TypoUnknownPgStatistic
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgStatisticExtDataRepoImpl extends PgStatisticExtDataRepo {
  override def delete(stxoid: PgStatisticExtDataId): ConnectionIO[Boolean] = {
    sql"""delete from pg_catalog.pg_statistic_ext_data where "stxoid" = ${fromWrite(stxoid)(Write.fromPut(PgStatisticExtDataId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgStatisticExtDataFields, PgStatisticExtDataRow] = {
    DeleteBuilder("pg_catalog.pg_statistic_ext_data", PgStatisticExtDataFields)
  }
  override def insert(unsaved: PgStatisticExtDataRow): ConnectionIO[PgStatisticExtDataRow] = {
    sql"""insert into pg_catalog.pg_statistic_ext_data("stxoid", "stxdndistinct", "stxddependencies", "stxdmcv", "stxdexpr")
          values (${fromWrite(unsaved.stxoid)(Write.fromPut(PgStatisticExtDataId.put))}::oid, ${fromWrite(unsaved.stxdndistinct)(Write.fromPutOption(TypoUnknownPgNdistinct.put))}::pg_ndistinct, ${fromWrite(unsaved.stxddependencies)(Write.fromPutOption(TypoUnknownPgDependencies.put))}::pg_dependencies, ${fromWrite(unsaved.stxdmcv)(Write.fromPutOption(TypoUnknownPgMcvList.put))}::pg_mcv_list, ${fromWrite(unsaved.stxdexpr)(Write.fromPutOption(TypoUnknownPgStatistic.arrayPut))}::_pg_statistic)
          returning "stxoid", "stxdndistinct"::text, "stxddependencies"::text, "stxdmcv"::text, "stxdexpr"::text[]
       """.query(PgStatisticExtDataRow.read).unique
  }
  override def select: SelectBuilder[PgStatisticExtDataFields, PgStatisticExtDataRow] = {
    SelectBuilderSql("pg_catalog.pg_statistic_ext_data", PgStatisticExtDataFields, PgStatisticExtDataRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgStatisticExtDataRow] = {
    sql"""select "stxoid", "stxdndistinct"::text, "stxddependencies"::text, "stxdmcv"::text, "stxdexpr"::text[] from pg_catalog.pg_statistic_ext_data""".query(PgStatisticExtDataRow.read).stream
  }
  override def selectById(stxoid: PgStatisticExtDataId): ConnectionIO[Option[PgStatisticExtDataRow]] = {
    sql"""select "stxoid", "stxdndistinct"::text, "stxddependencies"::text, "stxdmcv"::text, "stxdexpr"::text[] from pg_catalog.pg_statistic_ext_data where "stxoid" = ${fromWrite(stxoid)(Write.fromPut(PgStatisticExtDataId.put))}""".query(PgStatisticExtDataRow.read).option
  }
  override def selectByIds(stxoids: Array[PgStatisticExtDataId]): Stream[ConnectionIO, PgStatisticExtDataRow] = {
    sql"""select "stxoid", "stxdndistinct"::text, "stxddependencies"::text, "stxdmcv"::text, "stxdexpr"::text[] from pg_catalog.pg_statistic_ext_data where "stxoid" = ANY(${stxoids})""".query(PgStatisticExtDataRow.read).stream
  }
  override def update(row: PgStatisticExtDataRow): ConnectionIO[Boolean] = {
    val stxoid = row.stxoid
    sql"""update pg_catalog.pg_statistic_ext_data
          set "stxdndistinct" = ${fromWrite(row.stxdndistinct)(Write.fromPutOption(TypoUnknownPgNdistinct.put))}::pg_ndistinct,
              "stxddependencies" = ${fromWrite(row.stxddependencies)(Write.fromPutOption(TypoUnknownPgDependencies.put))}::pg_dependencies,
              "stxdmcv" = ${fromWrite(row.stxdmcv)(Write.fromPutOption(TypoUnknownPgMcvList.put))}::pg_mcv_list,
              "stxdexpr" = ${fromWrite(row.stxdexpr)(Write.fromPutOption(TypoUnknownPgStatistic.arrayPut))}::_pg_statistic
          where "stxoid" = ${fromWrite(stxoid)(Write.fromPut(PgStatisticExtDataId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgStatisticExtDataFields, PgStatisticExtDataRow] = {
    UpdateBuilder("pg_catalog.pg_statistic_ext_data", PgStatisticExtDataFields, PgStatisticExtDataRow.read)
  }
  override def upsert(unsaved: PgStatisticExtDataRow): ConnectionIO[PgStatisticExtDataRow] = {
    sql"""insert into pg_catalog.pg_statistic_ext_data("stxoid", "stxdndistinct", "stxddependencies", "stxdmcv", "stxdexpr")
          values (
            ${fromWrite(unsaved.stxoid)(Write.fromPut(PgStatisticExtDataId.put))}::oid,
            ${fromWrite(unsaved.stxdndistinct)(Write.fromPutOption(TypoUnknownPgNdistinct.put))}::pg_ndistinct,
            ${fromWrite(unsaved.stxddependencies)(Write.fromPutOption(TypoUnknownPgDependencies.put))}::pg_dependencies,
            ${fromWrite(unsaved.stxdmcv)(Write.fromPutOption(TypoUnknownPgMcvList.put))}::pg_mcv_list,
            ${fromWrite(unsaved.stxdexpr)(Write.fromPutOption(TypoUnknownPgStatistic.arrayPut))}::_pg_statistic
          )
          on conflict ("stxoid")
          do update set
            "stxdndistinct" = EXCLUDED."stxdndistinct",
            "stxddependencies" = EXCLUDED."stxddependencies",
            "stxdmcv" = EXCLUDED."stxdmcv",
            "stxdexpr" = EXCLUDED."stxdexpr"
          returning "stxoid", "stxdndistinct"::text, "stxddependencies"::text, "stxdmcv"::text, "stxdexpr"::text[]
       """.query(PgStatisticExtDataRow.read).unique
  }
}
