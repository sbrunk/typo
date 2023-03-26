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

object PgTsConfigRepoImpl extends PgTsConfigRepo {
  override def selectAll(implicit c: Connection): List[PgTsConfigRow] = {
    SQL"""select oid, cfgname, cfgnamespace, cfgowner, cfgparser from pg_catalog.pg_ts_config""".as(PgTsConfigRow.rowParser("").*)
  }
  override def selectById(oid: PgTsConfigId)(implicit c: Connection): Option[PgTsConfigRow] = {
    SQL"""select oid, cfgname, cfgnamespace, cfgowner, cfgparser from pg_catalog.pg_ts_config where oid = $oid""".as(PgTsConfigRow.rowParser("").singleOpt)
  }
  override def selectByIds(oids: List[PgTsConfigId])(implicit c: Connection): List[PgTsConfigRow] = {
    SQL"""select oid, cfgname, cfgnamespace, cfgowner, cfgparser from pg_catalog.pg_ts_config where oid in $oids""".as(PgTsConfigRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgTsConfigFieldValue[_]])(implicit c: Connection): List[PgTsConfigRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTsConfigFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTsConfigFieldValue.cfgname(value) => NamedParameter("cfgname", ParameterValue.from(value))
          case PgTsConfigFieldValue.cfgnamespace(value) => NamedParameter("cfgnamespace", ParameterValue.from(value))
          case PgTsConfigFieldValue.cfgowner(value) => NamedParameter("cfgowner", ParameterValue.from(value))
          case PgTsConfigFieldValue.cfgparser(value) => NamedParameter("cfgparser", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_ts_config where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgTsConfigRow.rowParser("").*)
    }

  }
  override def updateFieldValues(oid: PgTsConfigId, fieldValues: List[PgTsConfigFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTsConfigFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTsConfigFieldValue.cfgname(value) => NamedParameter("cfgname", ParameterValue.from(value))
          case PgTsConfigFieldValue.cfgnamespace(value) => NamedParameter("cfgnamespace", ParameterValue.from(value))
          case PgTsConfigFieldValue.cfgowner(value) => NamedParameter("cfgowner", ParameterValue.from(value))
          case PgTsConfigFieldValue.cfgparser(value) => NamedParameter("cfgparser", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_ts_config
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgTsConfigId, unsaved: PgTsConfigRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("cfgname", ParameterValue.from(unsaved.cfgname))),
      Some(NamedParameter("cfgnamespace", ParameterValue.from(unsaved.cfgnamespace))),
      Some(NamedParameter("cfgowner", ParameterValue.from(unsaved.cfgowner))),
      Some(NamedParameter("cfgparser", ParameterValue.from(unsaved.cfgparser)))
    ).flatten

    SQL"""insert into pg_catalog.pg_ts_config(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgTsConfigId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_ts_config where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUniqueCfgnameCfgnamespace(cfgname: String, cfgnamespace: Long)(implicit c: Connection): Option[PgTsConfigRow] = {
    selectByFieldValues(List(PgTsConfigFieldValue.cfgname(cfgname), PgTsConfigFieldValue.cfgnamespace(cfgnamespace))).headOption
  }
}
