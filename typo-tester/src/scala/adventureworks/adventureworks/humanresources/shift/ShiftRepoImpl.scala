/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import adventureworks.Defaulted
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.time.LocalTime

object ShiftRepoImpl extends ShiftRepo {
  override def delete(shiftid: ShiftId)(implicit c: Connection): Boolean = {
    SQL"""delete from humanresources.shift where shiftid = $shiftid""".executeUpdate() > 0
  }
  override def insert(unsaved: ShiftRowUnsaved)(implicit c: Connection): ShiftId = {
    val namedParameters = List(
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
      Some(NamedParameter("starttime", ParameterValue.from(unsaved.starttime))),
      Some(NamedParameter("endtime", ParameterValue.from(unsaved.endtime))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into humanresources.shift(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning shiftid
    """
      .on(namedParameters :_*)
      .executeInsert(idRowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[ShiftRow] = {
    SQL"""select shiftid, name, starttime, endtime, modifieddate from humanresources.shift""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ShiftFieldOrIdValue[_]])(implicit c: Connection): List[ShiftRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ShiftFieldValue.shiftid(value) => NamedParameter("shiftid", ParameterValue.from(value))
          case ShiftFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ShiftFieldValue.starttime(value) => NamedParameter("starttime", ParameterValue.from(value))
          case ShiftFieldValue.endtime(value) => NamedParameter("endtime", ParameterValue.from(value))
          case ShiftFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from humanresources.shift where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(shiftid: ShiftId)(implicit c: Connection): Option[ShiftRow] = {
    SQL"""select shiftid, name, starttime, endtime, modifieddate from humanresources.shift where shiftid = $shiftid""".as(rowParser.singleOpt)
  }
  override def selectByIds(shiftids: List[ShiftId])(implicit c: Connection): List[ShiftRow] = {
    SQL"""select shiftid, name, starttime, endtime, modifieddate from humanresources.shift where shiftid in $shiftids""".as(rowParser.*)
  }
  override def update(shiftid: ShiftId, row: ShiftRow)(implicit c: Connection): Boolean = {
    SQL"""update humanresources.shift
          set name = ${row.name},
              starttime = ${row.starttime},
              endtime = ${row.endtime},
              modifieddate = ${row.modifieddate}
          where shiftid = $shiftid""".executeUpdate() > 0
  }
  override def updateFieldValues(shiftid: ShiftId, fieldValues: List[ShiftFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ShiftFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ShiftFieldValue.starttime(value) => NamedParameter("starttime", ParameterValue.from(value))
          case ShiftFieldValue.endtime(value) => NamedParameter("endtime", ParameterValue.from(value))
          case ShiftFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update humanresources.shift
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where shiftid = $shiftid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ShiftRow] =
    RowParser[ShiftRow] { row =>
      Success(
        ShiftRow(
          shiftid = row[ShiftId]("shiftid"),
          name = row[Name]("name"),
          starttime = row[LocalTime]("starttime"),
          endtime = row[LocalTime]("endtime"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[ShiftId] =
    SqlParser.get[ShiftId]("shiftid")
}
