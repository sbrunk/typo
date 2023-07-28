/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object TransactionhistoryRepoImpl extends TransactionhistoryRepo {
  override def delete(transactionid: TransactionhistoryId)(implicit c: Connection): Boolean = {
    SQL"delete from production.transactionhistory where transactionid = $transactionid".executeUpdate() > 0
  }
  override def insert(unsaved: TransactionhistoryRow)(implicit c: Connection): TransactionhistoryRow = {
    SQL"""insert into production.transactionhistory(transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate)
          values (${unsaved.transactionid}::int4, ${unsaved.productid}::int4, ${unsaved.referenceorderid}::int4, ${unsaved.referenceorderlineid}::int4, ${unsaved.transactiondate}::timestamp, ${unsaved.transactiontype}::bpchar, ${unsaved.quantity}::int4, ${unsaved.actualcost}::numeric, ${unsaved.modifieddate}::timestamp)
          returning transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate
       """
      .executeInsert(TransactionhistoryRow.rowParser(1).single)
  
  }
  override def insert(unsaved: TransactionhistoryRowUnsaved)(implicit c: Connection): TransactionhistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("productid", ParameterValue.from(unsaved.productid)), "::int4")),
      Some((NamedParameter("referenceorderid", ParameterValue.from(unsaved.referenceorderid)), "::int4")),
      Some((NamedParameter("transactiontype", ParameterValue.from(unsaved.transactiontype)), "::bpchar")),
      Some((NamedParameter("quantity", ParameterValue.from(unsaved.quantity)), "::int4")),
      Some((NamedParameter("actualcost", ParameterValue.from(unsaved.actualcost)), "::numeric")),
      unsaved.transactionid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("transactionid", ParameterValue.from[TransactionhistoryId](value)), "::int4"))
      },
      unsaved.referenceorderlineid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("referenceorderlineid", ParameterValue.from[Int](value)), "::int4"))
      },
      unsaved.transactiondate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("transactiondate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.transactionhistory default values
            returning transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate
         """
        .executeInsert(TransactionhistoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.transactionhistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(TransactionhistoryRow.rowParser(1).single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[TransactionhistoryRow] = {
    SQL"""select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate
          from production.transactionhistory
       """.as(TransactionhistoryRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[TransactionhistoryFieldOrIdValue[_]])(implicit c: Connection): List[TransactionhistoryRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case TransactionhistoryFieldValue.transactionid(value) => NamedParameter("transactionid", ParameterValue.from(value))
          case TransactionhistoryFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case TransactionhistoryFieldValue.referenceorderid(value) => NamedParameter("referenceorderid", ParameterValue.from(value))
          case TransactionhistoryFieldValue.referenceorderlineid(value) => NamedParameter("referenceorderlineid", ParameterValue.from(value))
          case TransactionhistoryFieldValue.transactiondate(value) => NamedParameter("transactiondate", ParameterValue.from(value))
          case TransactionhistoryFieldValue.transactiontype(value) => NamedParameter("transactiontype", ParameterValue.from(value))
          case TransactionhistoryFieldValue.quantity(value) => NamedParameter("quantity", ParameterValue.from(value))
          case TransactionhistoryFieldValue.actualcost(value) => NamedParameter("actualcost", ParameterValue.from(value))
          case TransactionhistoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate
                    from production.transactionhistory
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(TransactionhistoryRow.rowParser(1).*)
    }
  
  }
  override def selectById(transactionid: TransactionhistoryId)(implicit c: Connection): Option[TransactionhistoryRow] = {
    SQL"""select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate
          from production.transactionhistory
          where transactionid = $transactionid
       """.as(TransactionhistoryRow.rowParser(1).singleOpt)
  }
  override def selectByIds(transactionids: Array[TransactionhistoryId])(implicit c: Connection): List[TransactionhistoryRow] = {
    implicit val toStatement: ToStatement[Array[TransactionhistoryId]] =
      (s: PreparedStatement, index: Int, v: Array[TransactionhistoryId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate
          from production.transactionhistory
          where transactionid = ANY($transactionids)
       """.as(TransactionhistoryRow.rowParser(1).*)
  
  }
  override def update(row: TransactionhistoryRow)(implicit c: Connection): Boolean = {
    val transactionid = row.transactionid
    SQL"""update production.transactionhistory
          set productid = ${row.productid}::int4,
              referenceorderid = ${row.referenceorderid}::int4,
              referenceorderlineid = ${row.referenceorderlineid}::int4,
              transactiondate = ${row.transactiondate}::timestamp,
              transactiontype = ${row.transactiontype}::bpchar,
              quantity = ${row.quantity}::int4,
              actualcost = ${row.actualcost}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where transactionid = $transactionid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(transactionid: TransactionhistoryId, fieldValues: List[TransactionhistoryFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case TransactionhistoryFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case TransactionhistoryFieldValue.referenceorderid(value) => NamedParameter("referenceorderid", ParameterValue.from(value))
          case TransactionhistoryFieldValue.referenceorderlineid(value) => NamedParameter("referenceorderlineid", ParameterValue.from(value))
          case TransactionhistoryFieldValue.transactiondate(value) => NamedParameter("transactiondate", ParameterValue.from(value))
          case TransactionhistoryFieldValue.transactiontype(value) => NamedParameter("transactiontype", ParameterValue.from(value))
          case TransactionhistoryFieldValue.quantity(value) => NamedParameter("quantity", ParameterValue.from(value))
          case TransactionhistoryFieldValue.actualcost(value) => NamedParameter("actualcost", ParameterValue.from(value))
          case TransactionhistoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update production.transactionhistory
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where transactionid = {transactionid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("transactionid", ParameterValue.from(transactionid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: TransactionhistoryRow)(implicit c: Connection): TransactionhistoryRow = {
    SQL"""insert into production.transactionhistory(transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate)
          values (
            ${unsaved.transactionid}::int4,
            ${unsaved.productid}::int4,
            ${unsaved.referenceorderid}::int4,
            ${unsaved.referenceorderlineid}::int4,
            ${unsaved.transactiondate}::timestamp,
            ${unsaved.transactiontype}::bpchar,
            ${unsaved.quantity}::int4,
            ${unsaved.actualcost}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (transactionid)
          do update set
            productid = EXCLUDED.productid,
            referenceorderid = EXCLUDED.referenceorderid,
            referenceorderlineid = EXCLUDED.referenceorderlineid,
            transactiondate = EXCLUDED.transactiondate,
            transactiontype = EXCLUDED.transactiontype,
            quantity = EXCLUDED.quantity,
            actualcost = EXCLUDED.actualcost,
            modifieddate = EXCLUDED.modifieddate
          returning transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate
       """
      .executeInsert(TransactionhistoryRow.rowParser(1).single)
  
  }
}
