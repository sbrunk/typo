/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgStatSlruRepoImpl extends PgStatSlruRepo {
  override def selectAll(implicit c: Connection): List[PgStatSlruRow] = {
    SQL"""select name, blks_zeroed, blks_hit, blks_read, blks_written, blks_exists, flushes, truncates, stats_reset from pg_catalog.pg_stat_slru""".as(PgStatSlruRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatSlruFieldValue[_]])(implicit c: Connection): List[PgStatSlruRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatSlruFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PgStatSlruFieldValue.blksZeroed(value) => NamedParameter("blks_zeroed", ParameterValue.from(value))
          case PgStatSlruFieldValue.blksHit(value) => NamedParameter("blks_hit", ParameterValue.from(value))
          case PgStatSlruFieldValue.blksRead(value) => NamedParameter("blks_read", ParameterValue.from(value))
          case PgStatSlruFieldValue.blksWritten(value) => NamedParameter("blks_written", ParameterValue.from(value))
          case PgStatSlruFieldValue.blksExists(value) => NamedParameter("blks_exists", ParameterValue.from(value))
          case PgStatSlruFieldValue.flushes(value) => NamedParameter("flushes", ParameterValue.from(value))
          case PgStatSlruFieldValue.truncates(value) => NamedParameter("truncates", ParameterValue.from(value))
          case PgStatSlruFieldValue.statsReset(value) => NamedParameter("stats_reset", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_stat_slru where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgStatSlruRow.rowParser("").*)
    }

  }
}
