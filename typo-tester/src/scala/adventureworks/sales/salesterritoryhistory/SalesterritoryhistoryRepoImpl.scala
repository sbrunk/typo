/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object SalesterritoryhistoryRepoImpl extends SalesterritoryhistoryRepo {
  override def delete(compositeId: SalesterritoryhistoryId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.salesterritoryhistory where businessentityid = ${compositeId.businessentityid} AND startdate = ${compositeId.startdate} AND territoryid = ${compositeId.territoryid}".executeUpdate() > 0
  }
  override def insert(unsaved: SalesterritoryhistoryRowUnsaved)(implicit c: Connection): SalesterritoryhistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("territoryid", ParameterValue.from(unsaved.territoryid)), "::int4")),
      Some((NamedParameter("startdate", ParameterValue.from(unsaved.startdate)), "::timestamp")),
      Some((NamedParameter("enddate", ParameterValue.from(unsaved.enddate)), "::timestamp")),
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
      SQL"""insert into sales.salesterritoryhistory default values
            returning businessentityid, territoryid, startdate, enddate, rowguid, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into sales.salesterritoryhistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, territoryid, startdate, enddate, rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[SalesterritoryhistoryRow] = {
    SQL"""select businessentityid, territoryid, startdate, enddate, rowguid, modifieddate
          from sales.salesterritoryhistory
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[SalesterritoryhistoryFieldOrIdValue[_]])(implicit c: Connection): List[SalesterritoryhistoryRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SalesterritoryhistoryFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case SalesterritoryhistoryFieldValue.territoryid(value) => NamedParameter("territoryid", ParameterValue.from(value))
          case SalesterritoryhistoryFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case SalesterritoryhistoryFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case SalesterritoryhistoryFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SalesterritoryhistoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select businessentityid, territoryid, startdate, enddate, rowguid, modifieddate
                    from sales.salesterritoryhistory
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(compositeId: SalesterritoryhistoryId)(implicit c: Connection): Option[SalesterritoryhistoryRow] = {
    SQL"""select businessentityid, territoryid, startdate, enddate, rowguid, modifieddate
          from sales.salesterritoryhistory
          where businessentityid = ${compositeId.businessentityid} AND startdate = ${compositeId.startdate} AND territoryid = ${compositeId.territoryid}
       """.as(rowParser.singleOpt)
  }
  override def update(row: SalesterritoryhistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.salesterritoryhistory
          set enddate = ${row.enddate}::timestamp,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND startdate = ${compositeId.startdate} AND territoryid = ${compositeId.territoryid}
       """.executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: SalesterritoryhistoryId, fieldValues: List[SalesterritoryhistoryFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SalesterritoryhistoryFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case SalesterritoryhistoryFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SalesterritoryhistoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update sales.salesterritoryhistory
                    set ${namedParams.map(x => s"${quote}${x.name}${quote} = {${x.name}}").mkString(", ")}
                    where businessentityid = {businessentityid} AND startdate = {startdate} AND territoryid = {territoryid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("businessentityid", ParameterValue.from(compositeId.businessentityid)), NamedParameter("startdate", ParameterValue.from(compositeId.startdate)), NamedParameter("territoryid", ParameterValue.from(compositeId.territoryid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[SalesterritoryhistoryRow] =
    RowParser[SalesterritoryhistoryRow] { row =>
      Success(
        SalesterritoryhistoryRow(
          businessentityid = row[BusinessentityId]("businessentityid"),
          territoryid = row[SalesterritoryId]("territoryid"),
          startdate = row[LocalDateTime]("startdate"),
          enddate = row[Option[LocalDateTime]]("enddate"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
