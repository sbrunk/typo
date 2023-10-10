/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class WorkorderroutingRow(
  /** Primary key. Foreign key to WorkOrder.WorkOrderID.
      Points to [[workorder.WorkorderRow.workorderid]] */
  workorderid: WorkorderId,
  /** Primary key. Foreign key to Product.ProductID. */
  productid: Int,
  /** Primary key. Indicates the manufacturing process sequence. */
  operationsequence: TypoShort,
  /** Manufacturing location where the part is processed. Foreign key to Location.LocationID.
      Points to [[location.LocationRow.locationid]] */
  locationid: LocationId,
  /** Planned manufacturing start date.
      Constraint CK_WorkOrderRouting_ScheduledEndDate affecting columns "scheduledenddate", "scheduledstartdate":  ((scheduledenddate >= scheduledstartdate)) */
  scheduledstartdate: TypoLocalDateTime,
  /** Planned manufacturing end date.
      Constraint CK_WorkOrderRouting_ScheduledEndDate affecting columns "scheduledenddate", "scheduledstartdate":  ((scheduledenddate >= scheduledstartdate)) */
  scheduledenddate: TypoLocalDateTime,
  /** Actual start date.
      Constraint CK_WorkOrderRouting_ActualEndDate affecting columns "actualenddate", "actualstartdate":  (((actualenddate >= actualstartdate) OR (actualenddate IS NULL) OR (actualstartdate IS NULL))) */
  actualstartdate: Option[TypoLocalDateTime],
  /** Actual end date.
      Constraint CK_WorkOrderRouting_ActualEndDate affecting columns "actualenddate", "actualstartdate":  (((actualenddate >= actualstartdate) OR (actualenddate IS NULL) OR (actualstartdate IS NULL))) */
  actualenddate: Option[TypoLocalDateTime],
  /** Number of manufacturing hours used.
      Constraint CK_WorkOrderRouting_ActualResourceHrs affecting columns "actualresourcehrs":  ((actualresourcehrs >= 0.0000)) */
  actualresourcehrs: Option[BigDecimal],
  /** Estimated manufacturing cost.
      Constraint CK_WorkOrderRouting_PlannedCost affecting columns "plannedcost":  ((plannedcost > 0.00)) */
  plannedcost: BigDecimal,
  /** Actual manufacturing cost.
      Constraint CK_WorkOrderRouting_ActualCost affecting columns "actualcost":  ((actualcost > 0.00)) */
  actualcost: Option[BigDecimal],
  modifieddate: TypoLocalDateTime
){
   val compositeId: WorkorderroutingId = WorkorderroutingId(workorderid, productid, operationsequence)
 }

object WorkorderroutingRow {
  implicit lazy val reads: Reads[WorkorderroutingRow] = Reads[WorkorderroutingRow](json => JsResult.fromTry(
      Try(
        WorkorderroutingRow(
          workorderid = json.\("workorderid").as(WorkorderId.reads),
          productid = json.\("productid").as(Reads.IntReads),
          operationsequence = json.\("operationsequence").as(TypoShort.reads),
          locationid = json.\("locationid").as(LocationId.reads),
          scheduledstartdate = json.\("scheduledstartdate").as(TypoLocalDateTime.reads),
          scheduledenddate = json.\("scheduledenddate").as(TypoLocalDateTime.reads),
          actualstartdate = json.\("actualstartdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          actualenddate = json.\("actualenddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          actualresourcehrs = json.\("actualresourcehrs").toOption.map(_.as(Reads.bigDecReads)),
          plannedcost = json.\("plannedcost").as(Reads.bigDecReads),
          actualcost = json.\("actualcost").toOption.map(_.as(Reads.bigDecReads)),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[WorkorderroutingRow] = RowParser[WorkorderroutingRow] { row =>
    Success(
      WorkorderroutingRow(
        workorderid = row(idx + 0)(WorkorderId.column),
        productid = row(idx + 1)(Column.columnToInt),
        operationsequence = row(idx + 2)(TypoShort.column),
        locationid = row(idx + 3)(LocationId.column),
        scheduledstartdate = row(idx + 4)(TypoLocalDateTime.column),
        scheduledenddate = row(idx + 5)(TypoLocalDateTime.column),
        actualstartdate = row(idx + 6)(Column.columnToOption(TypoLocalDateTime.column)),
        actualenddate = row(idx + 7)(Column.columnToOption(TypoLocalDateTime.column)),
        actualresourcehrs = row(idx + 8)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        plannedcost = row(idx + 9)(Column.columnToScalaBigDecimal),
        actualcost = row(idx + 10)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        modifieddate = row(idx + 11)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[WorkorderroutingRow] = OWrites[WorkorderroutingRow](o =>
    new JsObject(ListMap[String, JsValue](
      "workorderid" -> WorkorderId.writes.writes(o.workorderid),
      "productid" -> Writes.IntWrites.writes(o.productid),
      "operationsequence" -> TypoShort.writes.writes(o.operationsequence),
      "locationid" -> LocationId.writes.writes(o.locationid),
      "scheduledstartdate" -> TypoLocalDateTime.writes.writes(o.scheduledstartdate),
      "scheduledenddate" -> TypoLocalDateTime.writes.writes(o.scheduledenddate),
      "actualstartdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.actualstartdate),
      "actualenddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.actualenddate),
      "actualresourcehrs" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.actualresourcehrs),
      "plannedcost" -> Writes.BigDecimalWrites.writes(o.plannedcost),
      "actualcost" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.actualcost),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
