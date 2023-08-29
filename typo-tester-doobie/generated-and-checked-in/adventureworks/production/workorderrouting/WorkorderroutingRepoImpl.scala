/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object WorkorderroutingRepoImpl extends WorkorderroutingRepo {
  override def delete(compositeId: WorkorderroutingId): ConnectionIO[Boolean] = {
    sql"""delete from production.workorderrouting where "workorderid" = ${fromWrite(compositeId.workorderid)(Write.fromPut(WorkorderId.put))} AND "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(Meta.IntMeta.put))} AND "operationsequence" = ${fromWrite(compositeId.operationsequence)(Write.fromPut(TypoShort.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    DeleteBuilder("production.workorderrouting", WorkorderroutingFields)
  }
  override def insert(unsaved: WorkorderroutingRow): ConnectionIO[WorkorderroutingRow] = {
    sql"""insert into production.workorderrouting("workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate", "scheduledenddate", "actualstartdate", "actualenddate", "actualresourcehrs", "plannedcost", "actualcost", "modifieddate")
          values (${fromWrite(unsaved.workorderid)(Write.fromPut(WorkorderId.put))}::int4, ${fromWrite(unsaved.productid)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.operationsequence)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.locationid)(Write.fromPut(LocationId.put))}::int2, ${fromWrite(unsaved.scheduledstartdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.scheduledenddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.actualstartdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.actualenddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.actualresourcehrs)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.plannedcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.actualcost)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text
       """.query(WorkorderroutingRow.read).unique
  }
  override def insert(unsaved: WorkorderroutingRowUnsaved): ConnectionIO[WorkorderroutingRow] = {
    val fs = List(
      Some((Fragment.const(s""""workorderid""""), fr"${fromWrite(unsaved.workorderid)(Write.fromPut(WorkorderId.put))}::int4")),
      Some((Fragment.const(s""""productid""""), fr"${fromWrite(unsaved.productid)(Write.fromPut(Meta.IntMeta.put))}::int4")),
      Some((Fragment.const(s""""operationsequence""""), fr"${fromWrite(unsaved.operationsequence)(Write.fromPut(TypoShort.put))}::int2")),
      Some((Fragment.const(s""""locationid""""), fr"${fromWrite(unsaved.locationid)(Write.fromPut(LocationId.put))}::int2")),
      Some((Fragment.const(s""""scheduledstartdate""""), fr"${fromWrite(unsaved.scheduledstartdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""scheduledenddate""""), fr"${fromWrite(unsaved.scheduledenddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""actualstartdate""""), fr"${fromWrite(unsaved.actualstartdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""actualenddate""""), fr"${fromWrite(unsaved.actualenddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""actualresourcehrs""""), fr"${fromWrite(unsaved.actualresourcehrs)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const(s""""plannedcost""""), fr"${fromWrite(unsaved.plannedcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const(s""""actualcost""""), fr"${fromWrite(unsaved.actualcost)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.workorderrouting default values
            returning "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.workorderrouting(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text
         """
    }
    q.query(WorkorderroutingRow.read).unique
    
  }
  override def select: SelectBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    SelectBuilderSql("production.workorderrouting", WorkorderroutingFields, WorkorderroutingRow.read)
  }
  override def selectAll: Stream[ConnectionIO, WorkorderroutingRow] = {
    sql"""select "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text from production.workorderrouting""".query(WorkorderroutingRow.read).stream
  }
  override def selectById(compositeId: WorkorderroutingId): ConnectionIO[Option[WorkorderroutingRow]] = {
    sql"""select "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text from production.workorderrouting where "workorderid" = ${fromWrite(compositeId.workorderid)(Write.fromPut(WorkorderId.put))} AND "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(Meta.IntMeta.put))} AND "operationsequence" = ${fromWrite(compositeId.operationsequence)(Write.fromPut(TypoShort.put))}""".query(WorkorderroutingRow.read).option
  }
  override def update(row: WorkorderroutingRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.workorderrouting
          set "locationid" = ${fromWrite(row.locationid)(Write.fromPut(LocationId.put))}::int2,
              "scheduledstartdate" = ${fromWrite(row.scheduledstartdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "scheduledenddate" = ${fromWrite(row.scheduledenddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "actualstartdate" = ${fromWrite(row.actualstartdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              "actualenddate" = ${fromWrite(row.actualenddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              "actualresourcehrs" = ${fromWrite(row.actualresourcehrs)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "plannedcost" = ${fromWrite(row.plannedcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "actualcost" = ${fromWrite(row.actualcost)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "workorderid" = ${fromWrite(compositeId.workorderid)(Write.fromPut(WorkorderId.put))} AND "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(Meta.IntMeta.put))} AND "operationsequence" = ${fromWrite(compositeId.operationsequence)(Write.fromPut(TypoShort.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    UpdateBuilder("production.workorderrouting", WorkorderroutingFields, WorkorderroutingRow.read)
  }
  override def upsert(unsaved: WorkorderroutingRow): ConnectionIO[WorkorderroutingRow] = {
    sql"""insert into production.workorderrouting("workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate", "scheduledenddate", "actualstartdate", "actualenddate", "actualresourcehrs", "plannedcost", "actualcost", "modifieddate")
          values (
            ${fromWrite(unsaved.workorderid)(Write.fromPut(WorkorderId.put))}::int4,
            ${fromWrite(unsaved.productid)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.operationsequence)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.locationid)(Write.fromPut(LocationId.put))}::int2,
            ${fromWrite(unsaved.scheduledstartdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.scheduledenddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.actualstartdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.actualenddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.actualresourcehrs)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.plannedcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.actualcost)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("workorderid", "productid", "operationsequence")
          do update set
            "locationid" = EXCLUDED."locationid",
            "scheduledstartdate" = EXCLUDED."scheduledstartdate",
            "scheduledenddate" = EXCLUDED."scheduledenddate",
            "actualstartdate" = EXCLUDED."actualstartdate",
            "actualenddate" = EXCLUDED."actualenddate",
            "actualresourcehrs" = EXCLUDED."actualresourcehrs",
            "plannedcost" = EXCLUDED."plannedcost",
            "actualcost" = EXCLUDED."actualcost",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text
       """.query(WorkorderroutingRow.read).unique
  }
}
