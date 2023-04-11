/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

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

object CurrencyRepoImpl extends CurrencyRepo {
  override def delete(currencycode: CurrencyId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.currency where currencycode = $currencycode""".executeUpdate() > 0
  }
  override def insert(currencycode: CurrencyId, unsaved: CurrencyRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into sales.currency(currencycode, ${namedParameters.map(_.name).mkString(", ")})
          values (${currencycode}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
    """
      .on(namedParameters :_*)
      .execute()
  
  }
  override def selectAll(implicit c: Connection): List[CurrencyRow] = {
    SQL"""select currencycode, name, modifieddate from sales.currency""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CurrencyFieldOrIdValue[_]])(implicit c: Connection): List[CurrencyRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CurrencyFieldValue.currencycode(value) => NamedParameter("currencycode", ParameterValue.from(value))
          case CurrencyFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case CurrencyFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from sales.currency where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(currencycode: CurrencyId)(implicit c: Connection): Option[CurrencyRow] = {
    SQL"""select currencycode, name, modifieddate from sales.currency where currencycode = $currencycode""".as(rowParser.singleOpt)
  }
  override def selectByIds(currencycodes: List[CurrencyId])(implicit c: Connection): List[CurrencyRow] = {
    SQL"""select currencycode, name, modifieddate from sales.currency where currencycode in $currencycodes""".as(rowParser.*)
  }
  override def update(currencycode: CurrencyId, row: CurrencyRow)(implicit c: Connection): Boolean = {
    SQL"""update sales.currency
          set name = ${row.name},
              modifieddate = ${row.modifieddate}
          where currencycode = $currencycode""".executeUpdate() > 0
  }
  override def updateFieldValues(currencycode: CurrencyId, fieldValues: List[CurrencyFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CurrencyFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case CurrencyFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update sales.currency
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where currencycode = $currencycode"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[CurrencyRow] =
    RowParser[CurrencyRow] { row =>
      Success(
        CurrencyRow(
          currencycode = row[CurrencyId]("currencycode"),
          name = row[Name]("name"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[CurrencyId] =
    SqlParser.get[CurrencyId]("currencycode")
}
