/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgTsTemplateRepoImpl extends PgTsTemplateRepo {
  override def selectAll(implicit c: Connection): List[PgTsTemplateRow] = {
    SQL"""select oid, tmplname, tmplnamespace, tmplinit, tmpllexize from pg_catalog.pg_ts_template""".as(PgTsTemplateRow.rowParser("").*)
  }
  override def selectById(oid: PgTsTemplateId)(implicit c: Connection): Option[PgTsTemplateRow] = {
    SQL"""select oid, tmplname, tmplnamespace, tmplinit, tmpllexize from pg_catalog.pg_ts_template where oid = $oid""".as(PgTsTemplateRow.rowParser("").singleOpt)
  }
  override def selectByIds(oids: List[PgTsTemplateId])(implicit c: Connection): List[PgTsTemplateRow] = {
    SQL"""select oid, tmplname, tmplnamespace, tmplinit, tmpllexize from pg_catalog.pg_ts_template where oid in $oids""".as(PgTsTemplateRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgTsTemplateFieldValue[_]])(implicit c: Connection): List[PgTsTemplateRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTsTemplateFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTsTemplateFieldValue.tmplname(value) => NamedParameter("tmplname", ParameterValue.from(value))
          case PgTsTemplateFieldValue.tmplnamespace(value) => NamedParameter("tmplnamespace", ParameterValue.from(value))
          case PgTsTemplateFieldValue.tmplinit(value) => NamedParameter("tmplinit", ParameterValue.from(value))
          case PgTsTemplateFieldValue.tmpllexize(value) => NamedParameter("tmpllexize", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_ts_template where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgTsTemplateRow.rowParser("").*)
    }

  }
  override def updateFieldValues(oid: PgTsTemplateId, fieldValues: List[PgTsTemplateFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTsTemplateFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTsTemplateFieldValue.tmplname(value) => NamedParameter("tmplname", ParameterValue.from(value))
          case PgTsTemplateFieldValue.tmplnamespace(value) => NamedParameter("tmplnamespace", ParameterValue.from(value))
          case PgTsTemplateFieldValue.tmplinit(value) => NamedParameter("tmplinit", ParameterValue.from(value))
          case PgTsTemplateFieldValue.tmpllexize(value) => NamedParameter("tmpllexize", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_ts_template
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgTsTemplateId, unsaved: PgTsTemplateRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("tmplname", ParameterValue.from(unsaved.tmplname))),
      Some(NamedParameter("tmplnamespace", ParameterValue.from(unsaved.tmplnamespace))),
      Some(NamedParameter("tmplinit", ParameterValue.from(unsaved.tmplinit))),
      Some(NamedParameter("tmpllexize", ParameterValue.from(unsaved.tmpllexize)))
    ).flatten

    SQL"""insert into pg_catalog.pg_ts_template(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgTsTemplateId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_ts_template where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUniqueTmplnameTmplnamespace(tmplname: String, tmplnamespace: /* oid */ Long)(implicit c: Connection): Option[PgTsTemplateRow] = {
    selectByFieldValues(List(PgTsTemplateFieldValue.tmplname(tmplname), PgTsTemplateFieldValue.tmplnamespace(tmplnamespace))).headOption
  }
}
