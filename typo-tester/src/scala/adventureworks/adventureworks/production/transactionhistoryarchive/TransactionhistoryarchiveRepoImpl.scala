/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object TransactionhistoryarchiveRepoImpl extends TransactionhistoryarchiveRepo {
  override def delete(transactionid: TransactionhistoryarchiveId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.transactionhistoryarchive where transactionid = $transactionid""".executeUpdate() > 0
  }
  override def insert(transactionid: TransactionhistoryarchiveId, unsaved: TransactionhistoryarchiveRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("productid", ParameterValue.from(unsaved.productid))),
      Some(NamedParameter("referenceorderid", ParameterValue.from(unsaved.referenceorderid))),
      unsaved.referenceorderlineid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("referenceorderlineid", ParameterValue.from[Int](value)))
      },
      unsaved.transactiondate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("transactiondate", ParameterValue.from[LocalDateTime](value)))
      },
      Some(NamedParameter("transactiontype", ParameterValue.from(unsaved.transactiontype))),
      Some(NamedParameter("quantity", ParameterValue.from(unsaved.quantity))),
      Some(NamedParameter("actualcost", ParameterValue.from(unsaved.actualcost))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into production.transactionhistoryarchive(transactionid, ${namedParameters.map(_.name).mkString(", ")})
          values (${transactionid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
    """
      .on(namedParameters :_*)
      .execute()
  
  }
  override def selectAll(implicit c: Connection): List[TransactionhistoryarchiveRow] = {
    SQL"""select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate from production.transactionhistoryarchive""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[TransactionhistoryarchiveFieldOrIdValue[_]])(implicit c: Connection): List[TransactionhistoryarchiveRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case TransactionhistoryarchiveFieldValue.transactionid(value) => NamedParameter("transactionid", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.referenceorderid(value) => NamedParameter("referenceorderid", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.referenceorderlineid(value) => NamedParameter("referenceorderlineid", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.transactiondate(value) => NamedParameter("transactiondate", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.transactiontype(value) => NamedParameter("transactiontype", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.quantity(value) => NamedParameter("quantity", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.actualcost(value) => NamedParameter("actualcost", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from production.transactionhistoryarchive where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(transactionid: TransactionhistoryarchiveId)(implicit c: Connection): Option[TransactionhistoryarchiveRow] = {
    SQL"""select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate from production.transactionhistoryarchive where transactionid = $transactionid""".as(rowParser.singleOpt)
  }
  override def selectByIds(transactionids: List[TransactionhistoryarchiveId])(implicit c: Connection): List[TransactionhistoryarchiveRow] = {
    SQL"""select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate from production.transactionhistoryarchive where transactionid in $transactionids""".as(rowParser.*)
  }
  override def update(transactionid: TransactionhistoryarchiveId, row: TransactionhistoryarchiveRow)(implicit c: Connection): Boolean = {
    SQL"""update production.transactionhistoryarchive
          set productid = ${row.productid},
              referenceorderid = ${row.referenceorderid},
              referenceorderlineid = ${row.referenceorderlineid},
              transactiondate = ${row.transactiondate},
              transactiontype = ${row.transactiontype},
              quantity = ${row.quantity},
              actualcost = ${row.actualcost},
              modifieddate = ${row.modifieddate}
          where transactionid = $transactionid""".executeUpdate() > 0
  }
  override def updateFieldValues(transactionid: TransactionhistoryarchiveId, fieldValues: List[TransactionhistoryarchiveFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case TransactionhistoryarchiveFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.referenceorderid(value) => NamedParameter("referenceorderid", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.referenceorderlineid(value) => NamedParameter("referenceorderlineid", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.transactiondate(value) => NamedParameter("transactiondate", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.transactiontype(value) => NamedParameter("transactiontype", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.quantity(value) => NamedParameter("quantity", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.actualcost(value) => NamedParameter("actualcost", ParameterValue.from(value))
          case TransactionhistoryarchiveFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.transactionhistoryarchive
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where transactionid = $transactionid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[TransactionhistoryarchiveRow] =
    RowParser[TransactionhistoryarchiveRow] { row =>
      Success(
        TransactionhistoryarchiveRow(
          transactionid = row[TransactionhistoryarchiveId]("transactionid"),
          productid = row[Int]("productid"),
          referenceorderid = row[Int]("referenceorderid"),
          referenceorderlineid = row[Int]("referenceorderlineid"),
          transactiondate = row[LocalDateTime]("transactiondate"),
          transactiontype = row[/* bpchar */ String]("transactiontype"),
          quantity = row[Int]("quantity"),
          actualcost = row[BigDecimal]("actualcost"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[TransactionhistoryarchiveId] =
    SqlParser.get[TransactionhistoryarchiveId]("transactionid")
}
