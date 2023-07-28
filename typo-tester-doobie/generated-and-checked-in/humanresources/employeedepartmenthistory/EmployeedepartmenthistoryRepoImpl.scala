/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import adventureworks.Defaulted
import adventureworks.TypoLocalDate
import adventureworks.TypoLocalDateTime
import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.shift.ShiftId
import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream

object EmployeedepartmenthistoryRepoImpl extends EmployeedepartmenthistoryRepo {
  override def delete(compositeId: EmployeedepartmenthistoryId): ConnectionIO[Boolean] = {
    sql"delete from humanresources.employeedepartmenthistory where businessentityid = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND startdate = ${fromWrite(compositeId.startdate)(Write.fromPut(TypoLocalDate.put))} AND departmentid = ${fromWrite(compositeId.departmentid)(Write.fromPut(DepartmentId.put))} AND shiftid = ${fromWrite(compositeId.shiftid)(Write.fromPut(ShiftId.put))}".update.run.map(_ > 0)
  }
  override def insert(unsaved: EmployeedepartmenthistoryRow): ConnectionIO[EmployeedepartmenthistoryRow] = {
    sql"""insert into humanresources.employeedepartmenthistory(businessentityid, departmentid, shiftid, startdate, enddate, modifieddate)
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.departmentid)(Write.fromPut(DepartmentId.put))}::int2, ${fromWrite(unsaved.shiftid)(Write.fromPut(ShiftId.put))}::int2, ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDate.put))}::date, ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDate.put))}::date, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text
       """.query(EmployeedepartmenthistoryRow.read).unique
  }
  override def insert(unsaved: EmployeedepartmenthistoryRowUnsaved): ConnectionIO[EmployeedepartmenthistoryRow] = {
    val fs = List(
      Some((Fragment.const(s"businessentityid"), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s"departmentid"), fr"${fromWrite(unsaved.departmentid)(Write.fromPut(DepartmentId.put))}::int2")),
      Some((Fragment.const(s"shiftid"), fr"${fromWrite(unsaved.shiftid)(Write.fromPut(ShiftId.put))}::int2")),
      Some((Fragment.const(s"startdate"), fr"${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDate.put))}::date")),
      Some((Fragment.const(s"enddate"), fr"${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDate.put))}::date")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.employeedepartmenthistory default values
            returning businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into humanresources.employeedepartmenthistory(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text
         """
    }
    q.query(EmployeedepartmenthistoryRow.read).unique
    
  }
  override def selectAll: Stream[ConnectionIO, EmployeedepartmenthistoryRow] = {
    sql"select businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text from humanresources.employeedepartmenthistory".query(EmployeedepartmenthistoryRow.read).stream
  }
  override def selectById(compositeId: EmployeedepartmenthistoryId): ConnectionIO[Option[EmployeedepartmenthistoryRow]] = {
    sql"select businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text from humanresources.employeedepartmenthistory where businessentityid = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND startdate = ${fromWrite(compositeId.startdate)(Write.fromPut(TypoLocalDate.put))} AND departmentid = ${fromWrite(compositeId.departmentid)(Write.fromPut(DepartmentId.put))} AND shiftid = ${fromWrite(compositeId.shiftid)(Write.fromPut(ShiftId.put))}".query(EmployeedepartmenthistoryRow.read).option
  }
  override def update(row: EmployeedepartmenthistoryRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update humanresources.employeedepartmenthistory
          set enddate = ${fromWrite(row.enddate)(Write.fromPutOption(TypoLocalDate.put))}::date,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where businessentityid = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND startdate = ${fromWrite(compositeId.startdate)(Write.fromPut(TypoLocalDate.put))} AND departmentid = ${fromWrite(compositeId.departmentid)(Write.fromPut(DepartmentId.put))} AND shiftid = ${fromWrite(compositeId.shiftid)(Write.fromPut(ShiftId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: EmployeedepartmenthistoryRow): ConnectionIO[EmployeedepartmenthistoryRow] = {
    sql"""insert into humanresources.employeedepartmenthistory(businessentityid, departmentid, shiftid, startdate, enddate, modifieddate)
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.departmentid)(Write.fromPut(DepartmentId.put))}::int2,
            ${fromWrite(unsaved.shiftid)(Write.fromPut(ShiftId.put))}::int2,
            ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDate.put))}::date,
            ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDate.put))}::date,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (businessentityid, startdate, departmentid, shiftid)
          do update set
            enddate = EXCLUDED.enddate,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text
       """.query(EmployeedepartmenthistoryRow.read).unique
  }
}
