/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesreason

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

object SalesreasonRepoImpl extends SalesreasonRepo {
  override def delete(salesreasonid: SalesreasonId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.salesreason where salesreasonid = $salesreasonid""".executeUpdate() > 0
  }
  override def insert(unsaved: SalesreasonRowUnsaved)(implicit c: Connection): SalesreasonId = {
    val namedParameters = List(
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
      Some(NamedParameter("reasontype", ParameterValue.from(unsaved.reasontype))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into sales.salesreason(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning salesreasonid
    """
      .on(namedParameters :_*)
      .executeInsert(idRowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[SalesreasonRow] = {
    SQL"""select salesreasonid, name, reasontype, modifieddate from sales.salesreason""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[SalesreasonFieldOrIdValue[_]])(implicit c: Connection): List[SalesreasonRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SalesreasonFieldValue.salesreasonid(value) => NamedParameter("salesreasonid", ParameterValue.from(value))
          case SalesreasonFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case SalesreasonFieldValue.reasontype(value) => NamedParameter("reasontype", ParameterValue.from(value))
          case SalesreasonFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from sales.salesreason where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(salesreasonid: SalesreasonId)(implicit c: Connection): Option[SalesreasonRow] = {
    SQL"""select salesreasonid, name, reasontype, modifieddate from sales.salesreason where salesreasonid = $salesreasonid""".as(rowParser.singleOpt)
  }
  override def selectByIds(salesreasonids: List[SalesreasonId])(implicit c: Connection): List[SalesreasonRow] = {
    SQL"""select salesreasonid, name, reasontype, modifieddate from sales.salesreason where salesreasonid in $salesreasonids""".as(rowParser.*)
  }
  override def update(salesreasonid: SalesreasonId, row: SalesreasonRow)(implicit c: Connection): Boolean = {
    SQL"""update sales.salesreason
          set name = ${row.name},
              reasontype = ${row.reasontype},
              modifieddate = ${row.modifieddate}
          where salesreasonid = $salesreasonid""".executeUpdate() > 0
  }
  override def updateFieldValues(salesreasonid: SalesreasonId, fieldValues: List[SalesreasonFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SalesreasonFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case SalesreasonFieldValue.reasontype(value) => NamedParameter("reasontype", ParameterValue.from(value))
          case SalesreasonFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update sales.salesreason
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where salesreasonid = $salesreasonid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[SalesreasonRow] =
    RowParser[SalesreasonRow] { row =>
      Success(
        SalesreasonRow(
          salesreasonid = row[SalesreasonId]("salesreasonid"),
          name = row[Name]("name"),
          reasontype = row[Name]("reasontype"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[SalesreasonId] =
    SqlParser.get[SalesreasonId]("salesreasonid")
}
