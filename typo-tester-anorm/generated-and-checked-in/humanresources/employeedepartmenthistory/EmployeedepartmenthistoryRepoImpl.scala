/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object EmployeedepartmenthistoryRepoImpl extends EmployeedepartmenthistoryRepo {
  override def delete(compositeId: EmployeedepartmenthistoryId)(implicit c: Connection): Boolean = {
    SQL"delete from humanresources.employeedepartmenthistory where businessentityid = ${compositeId.businessentityid} AND startdate = ${compositeId.startdate} AND departmentid = ${compositeId.departmentid} AND shiftid = ${compositeId.shiftid}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = {
    DeleteBuilder("humanresources.employeedepartmenthistory", EmployeedepartmenthistoryFields)
  }
  override def insert(unsaved: EmployeedepartmenthistoryRow)(implicit c: Connection): EmployeedepartmenthistoryRow = {
    SQL"""insert into humanresources.employeedepartmenthistory(businessentityid, departmentid, shiftid, startdate, enddate, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.departmentid}::int2, ${unsaved.shiftid}::int2, ${unsaved.startdate}::date, ${unsaved.enddate}::date, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text
       """
      .executeInsert(EmployeedepartmenthistoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: EmployeedepartmenthistoryRowUnsaved)(implicit c: Connection): EmployeedepartmenthistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("departmentid", ParameterValue.from(unsaved.departmentid)), "::int2")),
      Some((NamedParameter("shiftid", ParameterValue.from(unsaved.shiftid)), "::int2")),
      Some((NamedParameter("startdate", ParameterValue.from(unsaved.startdate)), "::date")),
      Some((NamedParameter("enddate", ParameterValue.from(unsaved.enddate)), "::date")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into humanresources.employeedepartmenthistory default values
            returning businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text
         """
        .executeInsert(EmployeedepartmenthistoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into humanresources.employeedepartmenthistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser(Success(_)))
        .executeInsert(EmployeedepartmenthistoryRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = {
    SelectBuilderSql("humanresources.employeedepartmenthistory", EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[EmployeedepartmenthistoryRow] = {
    SQL"""select businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text
          from humanresources.employeedepartmenthistory
       """.as(EmployeedepartmenthistoryRow.rowParser(1).*)
  }
  override def selectById(compositeId: EmployeedepartmenthistoryId)(implicit c: Connection): Option[EmployeedepartmenthistoryRow] = {
    SQL"""select businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text
          from humanresources.employeedepartmenthistory
          where businessentityid = ${compositeId.businessentityid} AND startdate = ${compositeId.startdate} AND departmentid = ${compositeId.departmentid} AND shiftid = ${compositeId.shiftid}
       """.as(EmployeedepartmenthistoryRow.rowParser(1).singleOpt)
  }
  override def update(row: EmployeedepartmenthistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update humanresources.employeedepartmenthistory
          set enddate = ${row.enddate}::date,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND startdate = ${compositeId.startdate} AND departmentid = ${compositeId.departmentid} AND shiftid = ${compositeId.shiftid}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = {
    UpdateBuilder("humanresources.employeedepartmenthistory", EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow.rowParser)
  }
  override def upsert(unsaved: EmployeedepartmenthistoryRow)(implicit c: Connection): EmployeedepartmenthistoryRow = {
    SQL"""insert into humanresources.employeedepartmenthistory(businessentityid, departmentid, shiftid, startdate, enddate, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.departmentid}::int2,
            ${unsaved.shiftid}::int2,
            ${unsaved.startdate}::date,
            ${unsaved.enddate}::date,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, startdate, departmentid, shiftid)
          do update set
            enddate = EXCLUDED.enddate,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text
       """
      .executeInsert(EmployeedepartmenthistoryRow.rowParser(1).single)
    
  }
}
