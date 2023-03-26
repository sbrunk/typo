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

object PgInitPrivsRepoImpl extends PgInitPrivsRepo {
  override def selectAll(implicit c: Connection): List[PgInitPrivsRow] = {
    SQL"""select objoid, classoid, objsubid, privtype, initprivs from pg_catalog.pg_init_privs""".as(PgInitPrivsRow.rowParser("").*)
  }
  override def selectById(compositeId: PgInitPrivsId)(implicit c: Connection): Option[PgInitPrivsRow] = {
    SQL"""select objoid, classoid, objsubid, privtype, initprivs from pg_catalog.pg_init_privs where objoid = ${compositeId.objoid}, classoid = ${compositeId.classoid}, objsubid = ${compositeId.objsubid}""".as(PgInitPrivsRow.rowParser("").singleOpt)
  }
  override def selectByFieldValues(fieldValues: List[PgInitPrivsFieldValue[_]])(implicit c: Connection): List[PgInitPrivsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgInitPrivsFieldValue.objoid(value) => NamedParameter("objoid", ParameterValue.from(value))
          case PgInitPrivsFieldValue.classoid(value) => NamedParameter("classoid", ParameterValue.from(value))
          case PgInitPrivsFieldValue.objsubid(value) => NamedParameter("objsubid", ParameterValue.from(value))
          case PgInitPrivsFieldValue.privtype(value) => NamedParameter("privtype", ParameterValue.from(value))
          case PgInitPrivsFieldValue.initprivs(value) => NamedParameter("initprivs", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_init_privs where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgInitPrivsRow.rowParser("").*)
    }

  }
  override def updateFieldValues(compositeId: PgInitPrivsId, fieldValues: List[PgInitPrivsFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgInitPrivsFieldValue.objoid(value) => NamedParameter("objoid", ParameterValue.from(value))
          case PgInitPrivsFieldValue.classoid(value) => NamedParameter("classoid", ParameterValue.from(value))
          case PgInitPrivsFieldValue.objsubid(value) => NamedParameter("objsubid", ParameterValue.from(value))
          case PgInitPrivsFieldValue.privtype(value) => NamedParameter("privtype", ParameterValue.from(value))
          case PgInitPrivsFieldValue.initprivs(value) => NamedParameter("initprivs", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_init_privs
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where objoid = ${compositeId.objoid}, classoid = ${compositeId.classoid}, objsubid = ${compositeId.objsubid}"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(compositeId: PgInitPrivsId, unsaved: PgInitPrivsRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("privtype", ParameterValue.from(unsaved.privtype))),
      Some(NamedParameter("initprivs", ParameterValue.from(unsaved.initprivs)))
    ).flatten

    SQL"""insert into pg_catalog.pg_init_privs(objoid, classoid, objsubid, ${namedParameters.map(_.name).mkString(", ")})
      values (${compositeId.objoid}, ${compositeId.classoid}, ${compositeId.objsubid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(compositeId: PgInitPrivsId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_init_privs where objoid = ${compositeId.objoid}, classoid = ${compositeId.classoid}, objsubid = ${compositeId.objsubid}""".executeUpdate() > 0
  }
}
