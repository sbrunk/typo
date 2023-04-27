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
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement

object FootballClubRepoImpl extends FootballClubRepo {
  override def delete(id: FootballClubId)(implicit c: Connection): Boolean = {
    SQL"""delete from myschema.football_club where "id" = $id""".executeUpdate() > 0
  }
  override def insert(unsaved: FootballClubRow)(implicit c: Connection): FootballClubRow = {
    SQL"""insert into myschema.football_club("id", "name")
          values (${unsaved.id}::int8, ${unsaved.name})
          returning "id", "name"
       """
      .executeInsert(rowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[FootballClubRow] = {
    SQL"""select "id", "name"
          from myschema.football_club
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[FootballClubFieldOrIdValue[_]])(implicit c: Connection): List[FootballClubRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case FootballClubFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case FootballClubFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
        }
        val q = s"""select "id", "name"
                    from myschema.football_club
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(id: FootballClubId)(implicit c: Connection): Option[FootballClubRow] = {
    SQL"""select "id", "name"
          from myschema.football_club
          where "id" = $id
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(ids: Array[FootballClubId])(implicit c: Connection): List[FootballClubRow] = {
    implicit val toStatement: ToStatement[Array[FootballClubId]] =
      (s: PreparedStatement, index: Int, v: Array[FootballClubId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int8", v.map(x => x.value: java.lang.Long)))
    
    SQL"""select "id", "name"
          from myschema.football_club
          where "id" = ANY($ids)
       """.as(rowParser.*)
  
  }
  override def update(row: FootballClubRow)(implicit c: Connection): Boolean = {
    val id = row.id
    SQL"""update myschema.football_club
          set "name" = ${row.name}
          where "id" = $id
       """.executeUpdate() > 0
  }
  override def updateFieldValues(id: FootballClubId, fieldValues: List[FootballClubFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case FootballClubFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update myschema.football_club
                    set ${namedParams.map(x => s"${quote}${x.name}${quote} = {${x.name}}").mkString(", ")}
                    where "id" = {id}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("id", ParameterValue.from(id)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[FootballClubRow] =
    RowParser[FootballClubRow] { row =>
      Success(
        FootballClubRow(
          id = row[FootballClubId]("id"),
          name = row[String]("name")
        )
      )
    }
}
