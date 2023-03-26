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

object PgCollationRepoImpl extends PgCollationRepo {
  override def selectAll(implicit c: Connection): List[PgCollationRow] = {
    SQL"""select oid, collname, collnamespace, collowner, collprovider, collisdeterministic, collencoding, collcollate, collctype, collversion from pg_catalog.pg_collation""".as(PgCollationRow.rowParser("").*)
  }
  override def selectById(oid: PgCollationId)(implicit c: Connection): Option[PgCollationRow] = {
    SQL"""select oid, collname, collnamespace, collowner, collprovider, collisdeterministic, collencoding, collcollate, collctype, collversion from pg_catalog.pg_collation where oid = $oid""".as(PgCollationRow.rowParser("").singleOpt)
  }
  override def selectByIds(oids: List[PgCollationId])(implicit c: Connection): List[PgCollationRow] = {
    SQL"""select oid, collname, collnamespace, collowner, collprovider, collisdeterministic, collencoding, collcollate, collctype, collversion from pg_catalog.pg_collation where oid in $oids""".as(PgCollationRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgCollationFieldValue[_]])(implicit c: Connection): List[PgCollationRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgCollationFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgCollationFieldValue.collname(value) => NamedParameter("collname", ParameterValue.from(value))
          case PgCollationFieldValue.collnamespace(value) => NamedParameter("collnamespace", ParameterValue.from(value))
          case PgCollationFieldValue.collowner(value) => NamedParameter("collowner", ParameterValue.from(value))
          case PgCollationFieldValue.collprovider(value) => NamedParameter("collprovider", ParameterValue.from(value))
          case PgCollationFieldValue.collisdeterministic(value) => NamedParameter("collisdeterministic", ParameterValue.from(value))
          case PgCollationFieldValue.collencoding(value) => NamedParameter("collencoding", ParameterValue.from(value))
          case PgCollationFieldValue.collcollate(value) => NamedParameter("collcollate", ParameterValue.from(value))
          case PgCollationFieldValue.collctype(value) => NamedParameter("collctype", ParameterValue.from(value))
          case PgCollationFieldValue.collversion(value) => NamedParameter("collversion", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_collation where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgCollationRow.rowParser("").*)
    }

  }
  override def updateFieldValues(oid: PgCollationId, fieldValues: List[PgCollationFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgCollationFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgCollationFieldValue.collname(value) => NamedParameter("collname", ParameterValue.from(value))
          case PgCollationFieldValue.collnamespace(value) => NamedParameter("collnamespace", ParameterValue.from(value))
          case PgCollationFieldValue.collowner(value) => NamedParameter("collowner", ParameterValue.from(value))
          case PgCollationFieldValue.collprovider(value) => NamedParameter("collprovider", ParameterValue.from(value))
          case PgCollationFieldValue.collisdeterministic(value) => NamedParameter("collisdeterministic", ParameterValue.from(value))
          case PgCollationFieldValue.collencoding(value) => NamedParameter("collencoding", ParameterValue.from(value))
          case PgCollationFieldValue.collcollate(value) => NamedParameter("collcollate", ParameterValue.from(value))
          case PgCollationFieldValue.collctype(value) => NamedParameter("collctype", ParameterValue.from(value))
          case PgCollationFieldValue.collversion(value) => NamedParameter("collversion", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_collation
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgCollationId, unsaved: PgCollationRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("collname", ParameterValue.from(unsaved.collname))),
      Some(NamedParameter("collnamespace", ParameterValue.from(unsaved.collnamespace))),
      Some(NamedParameter("collowner", ParameterValue.from(unsaved.collowner))),
      Some(NamedParameter("collprovider", ParameterValue.from(unsaved.collprovider))),
      Some(NamedParameter("collisdeterministic", ParameterValue.from(unsaved.collisdeterministic))),
      Some(NamedParameter("collencoding", ParameterValue.from(unsaved.collencoding))),
      Some(NamedParameter("collcollate", ParameterValue.from(unsaved.collcollate))),
      Some(NamedParameter("collctype", ParameterValue.from(unsaved.collctype))),
      Some(NamedParameter("collversion", ParameterValue.from(unsaved.collversion)))
    ).flatten

    SQL"""insert into pg_catalog.pg_collation(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgCollationId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_collation where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUniqueCollnameCollencodingCollnamespace(collname: String, collencoding: Int, collnamespace: /* oid */ Long)(implicit c: Connection): Option[PgCollationRow] = {
    selectByFieldValues(List(PgCollationFieldValue.collname(collname), PgCollationFieldValue.collencoding(collencoding), PgCollationFieldValue.collnamespace(collnamespace))).headOption
  }
}
