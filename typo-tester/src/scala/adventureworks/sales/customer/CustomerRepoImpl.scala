/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
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

object CustomerRepoImpl extends CustomerRepo {
  override def delete(customerid: CustomerId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.customer where customerid = $customerid".executeUpdate() > 0
  }
  override def insert(unsaved: CustomerRowUnsaved)(implicit c: Connection): CustomerRow = {
    val namedParameters = List(
      Some((NamedParameter("personid", ParameterValue.from(unsaved.personid)), "::int4")),
      Some((NamedParameter("storeid", ParameterValue.from(unsaved.storeid)), "::int4")),
      Some((NamedParameter("territoryid", ParameterValue.from(unsaved.territoryid)), "::int4")),
      unsaved.customerid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("customerid", ParameterValue.from[CustomerId](value)), "::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.customer default values
            returning customerid, personid, storeid, territoryid, rowguid, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into sales.customer(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning customerid, personid, storeid, territoryid, rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[CustomerRow] = {
    SQL"""select customerid, personid, storeid, territoryid, rowguid, modifieddate
          from sales.customer
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CustomerFieldOrIdValue[_]])(implicit c: Connection): List[CustomerRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CustomerFieldValue.customerid(value) => NamedParameter("customerid", ParameterValue.from(value))
          case CustomerFieldValue.personid(value) => NamedParameter("personid", ParameterValue.from(value))
          case CustomerFieldValue.storeid(value) => NamedParameter("storeid", ParameterValue.from(value))
          case CustomerFieldValue.territoryid(value) => NamedParameter("territoryid", ParameterValue.from(value))
          case CustomerFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case CustomerFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select customerid, personid, storeid, territoryid, rowguid, modifieddate
                    from sales.customer
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(customerid: CustomerId)(implicit c: Connection): Option[CustomerRow] = {
    SQL"""select customerid, personid, storeid, territoryid, rowguid, modifieddate
          from sales.customer
          where customerid = $customerid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(customerids: Array[CustomerId])(implicit c: Connection): List[CustomerRow] = {
    implicit val toStatement: ToStatement[Array[CustomerId]] =
      (s: PreparedStatement, index: Int, v: Array[CustomerId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select customerid, personid, storeid, territoryid, rowguid, modifieddate
          from sales.customer
          where customerid = ANY($customerids)
       """.as(rowParser.*)
  
  }
  override def update(row: CustomerRow)(implicit c: Connection): Boolean = {
    val customerid = row.customerid
    SQL"""update sales.customer
          set personid = ${row.personid}::int4,
              storeid = ${row.storeid}::int4,
              territoryid = ${row.territoryid}::int4,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where customerid = $customerid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(customerid: CustomerId, fieldValues: List[CustomerFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CustomerFieldValue.personid(value) => NamedParameter("personid", ParameterValue.from(value))
          case CustomerFieldValue.storeid(value) => NamedParameter("storeid", ParameterValue.from(value))
          case CustomerFieldValue.territoryid(value) => NamedParameter("territoryid", ParameterValue.from(value))
          case CustomerFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case CustomerFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update sales.customer
                    set ${namedParams.map(x => s"${quote}${x.name}${quote} = {${x.name}}").mkString(", ")}
                    where customerid = {customerid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("customerid", ParameterValue.from(customerid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[CustomerRow] =
    RowParser[CustomerRow] { row =>
      Success(
        CustomerRow(
          customerid = row[CustomerId]("customerid"),
          personid = row[Option[BusinessentityId]]("personid"),
          storeid = row[Option[BusinessentityId]]("storeid"),
          territoryid = row[Option[SalesterritoryId]]("territoryid"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
