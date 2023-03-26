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

object PgGroupRepoImpl extends PgGroupRepo {
  override def selectAll(implicit c: Connection): List[PgGroupRow] = {
    SQL"""select groname, grosysid, grolist from pg_catalog.pg_group""".as(PgGroupRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgGroupFieldValue[_]])(implicit c: Connection): List[PgGroupRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgGroupFieldValue.groname(value) => NamedParameter("groname", ParameterValue.from(value))
          case PgGroupFieldValue.grosysid(value) => NamedParameter("grosysid", ParameterValue.from(value))
          case PgGroupFieldValue.grolist(value) => NamedParameter("grolist", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_group where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgGroupRow.rowParser("").*)
    }

  }
}
