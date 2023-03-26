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

object PgStatProgressVacuumRepoImpl extends PgStatProgressVacuumRepo {
  override def selectAll(implicit c: Connection): List[PgStatProgressVacuumRow] = {
    SQL"""select pid, datid, datname, relid, phase, heap_blks_total, heap_blks_scanned, heap_blks_vacuumed, index_vacuum_count, max_dead_tuples, num_dead_tuples from pg_catalog.pg_stat_progress_vacuum""".as(PgStatProgressVacuumRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatProgressVacuumFieldValue[_]])(implicit c: Connection): List[PgStatProgressVacuumRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatProgressVacuumFieldValue.pid(value) => NamedParameter("pid", ParameterValue.from(value))
          case PgStatProgressVacuumFieldValue.datid(value) => NamedParameter("datid", ParameterValue.from(value))
          case PgStatProgressVacuumFieldValue.datname(value) => NamedParameter("datname", ParameterValue.from(value))
          case PgStatProgressVacuumFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatProgressVacuumFieldValue.phase(value) => NamedParameter("phase", ParameterValue.from(value))
          case PgStatProgressVacuumFieldValue.heapBlksTotal(value) => NamedParameter("heap_blks_total", ParameterValue.from(value))
          case PgStatProgressVacuumFieldValue.heapBlksScanned(value) => NamedParameter("heap_blks_scanned", ParameterValue.from(value))
          case PgStatProgressVacuumFieldValue.heapBlksVacuumed(value) => NamedParameter("heap_blks_vacuumed", ParameterValue.from(value))
          case PgStatProgressVacuumFieldValue.indexVacuumCount(value) => NamedParameter("index_vacuum_count", ParameterValue.from(value))
          case PgStatProgressVacuumFieldValue.maxDeadTuples(value) => NamedParameter("max_dead_tuples", ParameterValue.from(value))
          case PgStatProgressVacuumFieldValue.numDeadTuples(value) => NamedParameter("num_dead_tuples", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_stat_progress_vacuum where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgStatProgressVacuumRow.rowParser("").*)
    }

  }
}
