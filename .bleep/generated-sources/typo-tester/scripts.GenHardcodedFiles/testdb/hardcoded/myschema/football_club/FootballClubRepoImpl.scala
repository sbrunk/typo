/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object FootballClubRepoImpl extends FootballClubRepo {
  override def selectAll(implicit c: Connection): List[FootballClubRow] = {
    SQL"""select id, name from myschema.football_club""".as(FootballClubRow.rowParser("").*)
  }
  override def selectById(id: FootballClubId)(implicit c: Connection): Option[FootballClubRow] = {
    SQL"""select id, name from myschema.football_club where id = $id""".as(FootballClubRow.rowParser("").singleOpt)
  }
  override def selectByIds(ids: List[FootballClubId])(implicit c: Connection): List[FootballClubRow] = {
    SQL"""select id, name from myschema.football_club where id in $ids""".as(FootballClubRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[FootballClubFieldOrIdValue[_]])(implicit c: Connection): List[FootballClubRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case FootballClubFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case FootballClubFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
        }
        val q = s"""select * from myschema.football_club where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(FootballClubRow.rowParser("").*)
    }
  
  }
  override def updateFieldValues(id: FootballClubId, fieldValues: List[FootballClubFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case FootballClubFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
        }
        val q = s"""update myschema.football_club
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where id = $id"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }
  
  }
  override def insert(id: FootballClubId, unsaved: FootballClubRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("name", ParameterValue.from(unsaved.name)))
    ).flatten
    
    SQL"""insert into myschema.football_club(id, ${namedParameters.map(_.name).mkString(", ")})
          values (${id}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
    """
      .on(namedParameters :_*)
      .execute()
  
  }
  override def delete(id: FootballClubId)(implicit c: Connection): Boolean = {
    SQL"""delete from myschema.football_club where id = $id""".executeUpdate() > 0
  }
}
