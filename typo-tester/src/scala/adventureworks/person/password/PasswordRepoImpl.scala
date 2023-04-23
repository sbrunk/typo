/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime
import java.util.UUID

object PasswordRepoImpl extends PasswordRepo {
  override def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = {
    SQL"""delete from person."password" where businessentityid = $businessentityid""".executeUpdate() > 0
  }
  override def insert(businessentityid: BusinessentityId, unsaved: PasswordRowUnsaved)(implicit c: Connection): PasswordRow = {
    val namedParameters = List(
      Some((NamedParameter("passwordhash", ParameterValue.from(unsaved.passwordhash)), "")),
      Some((NamedParameter("passwordsalt", ParameterValue.from(unsaved.passwordsalt)), "")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val q = s"""insert into person."password"(businessentityid, ${namedParameters.map(x => "\"" + x._1.name + "\"").mkString(", ")})
                values ({businessentityid}::int4, ${namedParameters.map{case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                returning businessentityid, passwordhash, passwordsalt, rowguid, modifieddate
             """
    // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
    import anorm._
    SQL(q)
      .on(namedParameters.map(_._1) :_*)
      .on(NamedParameter("businessentityid", ParameterValue.from(businessentityid)))
      .executeInsert(rowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[PasswordRow] = {
    SQL"""select businessentityid, passwordhash, passwordsalt, rowguid, modifieddate
          from person."password"
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PasswordFieldOrIdValue[_]])(implicit c: Connection): List[PasswordRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PasswordFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case PasswordFieldValue.passwordhash(value) => NamedParameter("passwordhash", ParameterValue.from(value))
          case PasswordFieldValue.passwordsalt(value) => NamedParameter("passwordsalt", ParameterValue.from(value))
          case PasswordFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case PasswordFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select businessentityid, passwordhash, passwordsalt, rowguid, modifieddate
                    from person."password"
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[PasswordRow] = {
    SQL"""select businessentityid, passwordhash, passwordsalt, rowguid, modifieddate
          from person."password"
          where businessentityid = $businessentityid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[PasswordRow] = {
    implicit val toStatement: ToStatement[Array[BusinessentityId]] =
      (s: PreparedStatement, index: Int, v: Array[BusinessentityId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select businessentityid, passwordhash, passwordsalt, rowguid, modifieddate
          from person."password"
          where businessentityid = ANY($businessentityids)
       """.as(rowParser.*)
  
  }
  override def update(row: PasswordRow)(implicit c: Connection): Boolean = {
    val businessentityid = row.businessentityid
    SQL"""update person."password"
          set passwordhash = ${row.passwordhash},
              passwordsalt = ${row.passwordsalt},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where businessentityid = $businessentityid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[PasswordFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PasswordFieldValue.passwordhash(value) => NamedParameter("passwordhash", ParameterValue.from(value))
          case PasswordFieldValue.passwordsalt(value) => NamedParameter("passwordsalt", ParameterValue.from(value))
          case PasswordFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case PasswordFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update person."password"
                    set ${namedParams.map(x => s"\"${x.name}\" = {${x.name}}").mkString(", ")}
                    where businessentityid = {businessentityid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("businessentityid", ParameterValue.from(businessentityid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[PasswordRow] =
    RowParser[PasswordRow] { row =>
      Success(
        PasswordRow(
          businessentityid = row[BusinessentityId]("businessentityid"),
          passwordhash = row[String]("passwordhash"),
          passwordsalt = row[String]("passwordsalt"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
