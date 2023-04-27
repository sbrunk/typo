/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.Defaulted
import adventureworks.public.Name
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

object ScrapreasonRepoImpl extends ScrapreasonRepo {
  override def delete(scrapreasonid: ScrapreasonId)(implicit c: Connection): Boolean = {
    SQL"delete from production.scrapreason where scrapreasonid = $scrapreasonid".executeUpdate() > 0
  }
  override def insert(unsaved: ScrapreasonRowUnsaved)(implicit c: Connection): ScrapreasonRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.scrapreasonid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("scrapreasonid", ParameterValue.from[ScrapreasonId](value)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.scrapreason default values
            returning scrapreasonid, "name", modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into production.scrapreason(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning scrapreasonid, "name", modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[ScrapreasonRow] = {
    SQL"""select scrapreasonid, "name", modifieddate
          from production.scrapreason
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ScrapreasonFieldOrIdValue[_]])(implicit c: Connection): List[ScrapreasonRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ScrapreasonFieldValue.scrapreasonid(value) => NamedParameter("scrapreasonid", ParameterValue.from(value))
          case ScrapreasonFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ScrapreasonFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select scrapreasonid, "name", modifieddate
                    from production.scrapreason
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(scrapreasonid: ScrapreasonId)(implicit c: Connection): Option[ScrapreasonRow] = {
    SQL"""select scrapreasonid, "name", modifieddate
          from production.scrapreason
          where scrapreasonid = $scrapreasonid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(scrapreasonids: Array[ScrapreasonId])(implicit c: Connection): List[ScrapreasonRow] = {
    implicit val toStatement: ToStatement[Array[ScrapreasonId]] =
      (s: PreparedStatement, index: Int, v: Array[ScrapreasonId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select scrapreasonid, "name", modifieddate
          from production.scrapreason
          where scrapreasonid = ANY($scrapreasonids)
       """.as(rowParser.*)
  
  }
  override def update(row: ScrapreasonRow)(implicit c: Connection): Boolean = {
    val scrapreasonid = row.scrapreasonid
    SQL"""update production.scrapreason
          set "name" = ${row.name}::"public"."Name",
              modifieddate = ${row.modifieddate}::timestamp
          where scrapreasonid = $scrapreasonid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(scrapreasonid: ScrapreasonId, fieldValues: List[ScrapreasonFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ScrapreasonFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ScrapreasonFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update production.scrapreason
                    set ${namedParams.map(x => s"${quote}${x.name}${quote} = {${x.name}}").mkString(", ")}
                    where scrapreasonid = {scrapreasonid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("scrapreasonid", ParameterValue.from(scrapreasonid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ScrapreasonRow] =
    RowParser[ScrapreasonRow] { row =>
      Success(
        ScrapreasonRow(
          scrapreasonid = row[ScrapreasonId]("scrapreasonid"),
          name = row[Name]("name"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
