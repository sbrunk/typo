/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement

object MaritalStatusRepoImpl extends MaritalStatusRepo {
  override def delete(id: MaritalStatusId)(implicit c: Connection): Boolean = {
    SQL"""delete from myschema.marital_status where "id" = $id""".executeUpdate() > 0
  }
  override def insert(unsaved: MaritalStatusRow)(implicit c: Connection): MaritalStatusRow = {
    SQL"""insert into myschema.marital_status("id")
          values (${unsaved.id}::int8)
          returning "id"
       """
      .executeInsert(rowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[MaritalStatusRow] = {
    SQL"""select "id"
          from myschema.marital_status
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[MaritalStatusFieldOrIdValue[_]])(implicit c: Connection): List[MaritalStatusRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case MaritalStatusFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
        }
        val q = s"""select "id"
                    from myschema.marital_status
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(id: MaritalStatusId)(implicit c: Connection): Option[MaritalStatusRow] = {
    SQL"""select "id"
          from myschema.marital_status
          where "id" = $id
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(ids: Array[MaritalStatusId])(implicit c: Connection): List[MaritalStatusRow] = {
    implicit val toStatement: ToStatement[Array[MaritalStatusId]] =
      (s: PreparedStatement, index: Int, v: Array[MaritalStatusId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int8", v.map(x => x.value: java.lang.Long)))
    
    SQL"""select "id"
          from myschema.marital_status
          where "id" = ANY($ids)
       """.as(rowParser.*)
  
  }
  val rowParser: RowParser[MaritalStatusRow] =
    RowParser[MaritalStatusRow] { row =>
      Success(
        MaritalStatusRow(
          id = row[MaritalStatusId]("id")
        )
      )
    }
}
