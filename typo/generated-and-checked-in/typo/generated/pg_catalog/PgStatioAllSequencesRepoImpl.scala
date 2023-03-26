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

object PgStatioAllSequencesRepoImpl extends PgStatioAllSequencesRepo {
  override def selectAll(implicit c: Connection): List[PgStatioAllSequencesRow] = {
    SQL"""select relid, schemaname, relname, blks_read, blks_hit from pg_catalog.pg_statio_all_sequences""".as(PgStatioAllSequencesRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatioAllSequencesFieldValue[_]])(implicit c: Connection): List[PgStatioAllSequencesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatioAllSequencesFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatioAllSequencesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatioAllSequencesFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgStatioAllSequencesFieldValue.blksRead(value) => NamedParameter("blks_read", ParameterValue.from(value))
          case PgStatioAllSequencesFieldValue.blksHit(value) => NamedParameter("blks_hit", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_statio_all_sequences where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgStatioAllSequencesRow.rowParser("").*)
    }

  }
}
