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

object PgTypeRepoImpl extends PgTypeRepo {
  override def selectAll(implicit c: Connection): List[PgTypeRow] = {
    SQL"""select oid, typname, typnamespace, typowner, typlen, typbyval, typtype, typcategory, typispreferred, typisdefined, typdelim, typrelid, typsubscript, typelem, typarray, typinput, typoutput, typreceive, typsend, typmodin, typmodout, typanalyze, typalign, typstorage, typnotnull, typbasetype, typtypmod, typndims, typcollation, typdefaultbin, typdefault, typacl from pg_catalog.pg_type""".as(PgTypeRow.rowParser("").*)
  }
  override def selectById(oid: PgTypeId)(implicit c: Connection): Option[PgTypeRow] = {
    SQL"""select oid, typname, typnamespace, typowner, typlen, typbyval, typtype, typcategory, typispreferred, typisdefined, typdelim, typrelid, typsubscript, typelem, typarray, typinput, typoutput, typreceive, typsend, typmodin, typmodout, typanalyze, typalign, typstorage, typnotnull, typbasetype, typtypmod, typndims, typcollation, typdefaultbin, typdefault, typacl from pg_catalog.pg_type where oid = $oid""".as(PgTypeRow.rowParser("").singleOpt)
  }
  override def selectByIds(oids: List[PgTypeId])(implicit c: Connection): List[PgTypeRow] = {
    SQL"""select oid, typname, typnamespace, typowner, typlen, typbyval, typtype, typcategory, typispreferred, typisdefined, typdelim, typrelid, typsubscript, typelem, typarray, typinput, typoutput, typreceive, typsend, typmodin, typmodout, typanalyze, typalign, typstorage, typnotnull, typbasetype, typtypmod, typndims, typcollation, typdefaultbin, typdefault, typacl from pg_catalog.pg_type where oid in $oids""".as(PgTypeRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgTypeFieldValue[_]])(implicit c: Connection): List[PgTypeRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTypeFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTypeFieldValue.typname(value) => NamedParameter("typname", ParameterValue.from(value))
          case PgTypeFieldValue.typnamespace(value) => NamedParameter("typnamespace", ParameterValue.from(value))
          case PgTypeFieldValue.typowner(value) => NamedParameter("typowner", ParameterValue.from(value))
          case PgTypeFieldValue.typlen(value) => NamedParameter("typlen", ParameterValue.from(value))
          case PgTypeFieldValue.typbyval(value) => NamedParameter("typbyval", ParameterValue.from(value))
          case PgTypeFieldValue.typtype(value) => NamedParameter("typtype", ParameterValue.from(value))
          case PgTypeFieldValue.typcategory(value) => NamedParameter("typcategory", ParameterValue.from(value))
          case PgTypeFieldValue.typispreferred(value) => NamedParameter("typispreferred", ParameterValue.from(value))
          case PgTypeFieldValue.typisdefined(value) => NamedParameter("typisdefined", ParameterValue.from(value))
          case PgTypeFieldValue.typdelim(value) => NamedParameter("typdelim", ParameterValue.from(value))
          case PgTypeFieldValue.typrelid(value) => NamedParameter("typrelid", ParameterValue.from(value))
          case PgTypeFieldValue.typsubscript(value) => NamedParameter("typsubscript", ParameterValue.from(value))
          case PgTypeFieldValue.typelem(value) => NamedParameter("typelem", ParameterValue.from(value))
          case PgTypeFieldValue.typarray(value) => NamedParameter("typarray", ParameterValue.from(value))
          case PgTypeFieldValue.typinput(value) => NamedParameter("typinput", ParameterValue.from(value))
          case PgTypeFieldValue.typoutput(value) => NamedParameter("typoutput", ParameterValue.from(value))
          case PgTypeFieldValue.typreceive(value) => NamedParameter("typreceive", ParameterValue.from(value))
          case PgTypeFieldValue.typsend(value) => NamedParameter("typsend", ParameterValue.from(value))
          case PgTypeFieldValue.typmodin(value) => NamedParameter("typmodin", ParameterValue.from(value))
          case PgTypeFieldValue.typmodout(value) => NamedParameter("typmodout", ParameterValue.from(value))
          case PgTypeFieldValue.typanalyze(value) => NamedParameter("typanalyze", ParameterValue.from(value))
          case PgTypeFieldValue.typalign(value) => NamedParameter("typalign", ParameterValue.from(value))
          case PgTypeFieldValue.typstorage(value) => NamedParameter("typstorage", ParameterValue.from(value))
          case PgTypeFieldValue.typnotnull(value) => NamedParameter("typnotnull", ParameterValue.from(value))
          case PgTypeFieldValue.typbasetype(value) => NamedParameter("typbasetype", ParameterValue.from(value))
          case PgTypeFieldValue.typtypmod(value) => NamedParameter("typtypmod", ParameterValue.from(value))
          case PgTypeFieldValue.typndims(value) => NamedParameter("typndims", ParameterValue.from(value))
          case PgTypeFieldValue.typcollation(value) => NamedParameter("typcollation", ParameterValue.from(value))
          case PgTypeFieldValue.typdefaultbin(value) => NamedParameter("typdefaultbin", ParameterValue.from(value))
          case PgTypeFieldValue.typdefault(value) => NamedParameter("typdefault", ParameterValue.from(value))
          case PgTypeFieldValue.typacl(value) => NamedParameter("typacl", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_type where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgTypeRow.rowParser("").*)
    }

  }
  override def updateFieldValues(oid: PgTypeId, fieldValues: List[PgTypeFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTypeFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgTypeFieldValue.typname(value) => NamedParameter("typname", ParameterValue.from(value))
          case PgTypeFieldValue.typnamespace(value) => NamedParameter("typnamespace", ParameterValue.from(value))
          case PgTypeFieldValue.typowner(value) => NamedParameter("typowner", ParameterValue.from(value))
          case PgTypeFieldValue.typlen(value) => NamedParameter("typlen", ParameterValue.from(value))
          case PgTypeFieldValue.typbyval(value) => NamedParameter("typbyval", ParameterValue.from(value))
          case PgTypeFieldValue.typtype(value) => NamedParameter("typtype", ParameterValue.from(value))
          case PgTypeFieldValue.typcategory(value) => NamedParameter("typcategory", ParameterValue.from(value))
          case PgTypeFieldValue.typispreferred(value) => NamedParameter("typispreferred", ParameterValue.from(value))
          case PgTypeFieldValue.typisdefined(value) => NamedParameter("typisdefined", ParameterValue.from(value))
          case PgTypeFieldValue.typdelim(value) => NamedParameter("typdelim", ParameterValue.from(value))
          case PgTypeFieldValue.typrelid(value) => NamedParameter("typrelid", ParameterValue.from(value))
          case PgTypeFieldValue.typsubscript(value) => NamedParameter("typsubscript", ParameterValue.from(value))
          case PgTypeFieldValue.typelem(value) => NamedParameter("typelem", ParameterValue.from(value))
          case PgTypeFieldValue.typarray(value) => NamedParameter("typarray", ParameterValue.from(value))
          case PgTypeFieldValue.typinput(value) => NamedParameter("typinput", ParameterValue.from(value))
          case PgTypeFieldValue.typoutput(value) => NamedParameter("typoutput", ParameterValue.from(value))
          case PgTypeFieldValue.typreceive(value) => NamedParameter("typreceive", ParameterValue.from(value))
          case PgTypeFieldValue.typsend(value) => NamedParameter("typsend", ParameterValue.from(value))
          case PgTypeFieldValue.typmodin(value) => NamedParameter("typmodin", ParameterValue.from(value))
          case PgTypeFieldValue.typmodout(value) => NamedParameter("typmodout", ParameterValue.from(value))
          case PgTypeFieldValue.typanalyze(value) => NamedParameter("typanalyze", ParameterValue.from(value))
          case PgTypeFieldValue.typalign(value) => NamedParameter("typalign", ParameterValue.from(value))
          case PgTypeFieldValue.typstorage(value) => NamedParameter("typstorage", ParameterValue.from(value))
          case PgTypeFieldValue.typnotnull(value) => NamedParameter("typnotnull", ParameterValue.from(value))
          case PgTypeFieldValue.typbasetype(value) => NamedParameter("typbasetype", ParameterValue.from(value))
          case PgTypeFieldValue.typtypmod(value) => NamedParameter("typtypmod", ParameterValue.from(value))
          case PgTypeFieldValue.typndims(value) => NamedParameter("typndims", ParameterValue.from(value))
          case PgTypeFieldValue.typcollation(value) => NamedParameter("typcollation", ParameterValue.from(value))
          case PgTypeFieldValue.typdefaultbin(value) => NamedParameter("typdefaultbin", ParameterValue.from(value))
          case PgTypeFieldValue.typdefault(value) => NamedParameter("typdefault", ParameterValue.from(value))
          case PgTypeFieldValue.typacl(value) => NamedParameter("typacl", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_type
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgTypeId, unsaved: PgTypeRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("typname", ParameterValue.from(unsaved.typname))),
      Some(NamedParameter("typnamespace", ParameterValue.from(unsaved.typnamespace))),
      Some(NamedParameter("typowner", ParameterValue.from(unsaved.typowner))),
      Some(NamedParameter("typlen", ParameterValue.from(unsaved.typlen))),
      Some(NamedParameter("typbyval", ParameterValue.from(unsaved.typbyval))),
      Some(NamedParameter("typtype", ParameterValue.from(unsaved.typtype))),
      Some(NamedParameter("typcategory", ParameterValue.from(unsaved.typcategory))),
      Some(NamedParameter("typispreferred", ParameterValue.from(unsaved.typispreferred))),
      Some(NamedParameter("typisdefined", ParameterValue.from(unsaved.typisdefined))),
      Some(NamedParameter("typdelim", ParameterValue.from(unsaved.typdelim))),
      Some(NamedParameter("typrelid", ParameterValue.from(unsaved.typrelid))),
      Some(NamedParameter("typsubscript", ParameterValue.from(unsaved.typsubscript))),
      Some(NamedParameter("typelem", ParameterValue.from(unsaved.typelem))),
      Some(NamedParameter("typarray", ParameterValue.from(unsaved.typarray))),
      Some(NamedParameter("typinput", ParameterValue.from(unsaved.typinput))),
      Some(NamedParameter("typoutput", ParameterValue.from(unsaved.typoutput))),
      Some(NamedParameter("typreceive", ParameterValue.from(unsaved.typreceive))),
      Some(NamedParameter("typsend", ParameterValue.from(unsaved.typsend))),
      Some(NamedParameter("typmodin", ParameterValue.from(unsaved.typmodin))),
      Some(NamedParameter("typmodout", ParameterValue.from(unsaved.typmodout))),
      Some(NamedParameter("typanalyze", ParameterValue.from(unsaved.typanalyze))),
      Some(NamedParameter("typalign", ParameterValue.from(unsaved.typalign))),
      Some(NamedParameter("typstorage", ParameterValue.from(unsaved.typstorage))),
      Some(NamedParameter("typnotnull", ParameterValue.from(unsaved.typnotnull))),
      Some(NamedParameter("typbasetype", ParameterValue.from(unsaved.typbasetype))),
      Some(NamedParameter("typtypmod", ParameterValue.from(unsaved.typtypmod))),
      Some(NamedParameter("typndims", ParameterValue.from(unsaved.typndims))),
      Some(NamedParameter("typcollation", ParameterValue.from(unsaved.typcollation))),
      Some(NamedParameter("typdefaultbin", ParameterValue.from(unsaved.typdefaultbin))),
      Some(NamedParameter("typdefault", ParameterValue.from(unsaved.typdefault))),
      Some(NamedParameter("typacl", ParameterValue.from(unsaved.typacl)))
    ).flatten

    SQL"""insert into pg_catalog.pg_type(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgTypeId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_type where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUniqueTypnameTypnamespace(typname: String, typnamespace: /* oid */ Long)(implicit c: Connection): Option[PgTypeRow] = {
    selectByFieldValues(List(PgTypeFieldValue.typname(typname), PgTypeFieldValue.typnamespace(typnamespace))).headOption
  }
}
