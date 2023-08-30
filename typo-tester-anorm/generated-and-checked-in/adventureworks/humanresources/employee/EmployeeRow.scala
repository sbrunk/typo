/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employee

import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import anorm.Column
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class EmployeeRow(
  /** Primary key for Employee records.  Foreign key to BusinessEntity.BusinessEntityID.
      Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Unique national identification number such as a social security number. */
  nationalidnumber: /* max 15 chars */ String,
  /** Network login. */
  loginid: /* max 256 chars */ String,
  /** Work title such as Buyer or Sales Representative. */
  jobtitle: /* max 50 chars */ String,
  /** Date of birth.
      Constraint CK_Employee_BirthDate affecting columns "birthdate":  (((birthdate >= '1930-01-01'::date) AND (birthdate <= (now() - '18 years'::interval)))) */
  birthdate: TypoLocalDate,
  /** M = Married, S = Single
      Constraint CK_Employee_MaritalStatus affecting columns "maritalstatus":  ((upper((maritalstatus)::text) = ANY (ARRAY['M'::text, 'S'::text]))) */
  maritalstatus: /* bpchar, max 1 chars */ String,
  /** M = Male, F = Female
      Constraint CK_Employee_Gender affecting columns "gender":  ((upper((gender)::text) = ANY (ARRAY['M'::text, 'F'::text]))) */
  gender: /* bpchar, max 1 chars */ String,
  /** Employee hired on this date.
      Constraint CK_Employee_HireDate affecting columns "hiredate":  (((hiredate >= '1996-07-01'::date) AND (hiredate <= (now() + '1 day'::interval)))) */
  hiredate: TypoLocalDate,
  /** Job classification. 0 = Hourly, not exempt from collective bargaining. 1 = Salaried, exempt from collective bargaining. */
  salariedflag: Flag,
  /** Number of available vacation hours.
      Constraint CK_Employee_VacationHours affecting columns "vacationhours":  (((vacationhours >= '-40'::integer) AND (vacationhours <= 240))) */
  vacationhours: TypoShort,
  /** Number of available sick leave hours.
      Constraint CK_Employee_SickLeaveHours affecting columns "sickleavehours":  (((sickleavehours >= 0) AND (sickleavehours <= 120))) */
  sickleavehours: TypoShort,
  /** 0 = Inactive, 1 = Active */
  currentflag: Flag,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime,
  /** Where the employee is located in corporate hierarchy. */
  organizationnode: Option[String]
)

object EmployeeRow {
  implicit lazy val reads: Reads[EmployeeRow] = Reads[EmployeeRow](json => JsResult.fromTry(
      Try(
        EmployeeRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          nationalidnumber = json.\("nationalidnumber").as(Reads.StringReads),
          loginid = json.\("loginid").as(Reads.StringReads),
          jobtitle = json.\("jobtitle").as(Reads.StringReads),
          birthdate = json.\("birthdate").as(TypoLocalDate.reads),
          maritalstatus = json.\("maritalstatus").as(Reads.StringReads),
          gender = json.\("gender").as(Reads.StringReads),
          hiredate = json.\("hiredate").as(TypoLocalDate.reads),
          salariedflag = json.\("salariedflag").as(Flag.reads),
          vacationhours = json.\("vacationhours").as(TypoShort.reads),
          sickleavehours = json.\("sickleavehours").as(TypoShort.reads),
          currentflag = json.\("currentflag").as(Flag.reads),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads),
          organizationnode = json.\("organizationnode").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[EmployeeRow] = RowParser[EmployeeRow] { row =>
    Success(
      EmployeeRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        nationalidnumber = row(idx + 1)(Column.columnToString),
        loginid = row(idx + 2)(Column.columnToString),
        jobtitle = row(idx + 3)(Column.columnToString),
        birthdate = row(idx + 4)(TypoLocalDate.column),
        maritalstatus = row(idx + 5)(Column.columnToString),
        gender = row(idx + 6)(Column.columnToString),
        hiredate = row(idx + 7)(TypoLocalDate.column),
        salariedflag = row(idx + 8)(Flag.column),
        vacationhours = row(idx + 9)(TypoShort.column),
        sickleavehours = row(idx + 10)(TypoShort.column),
        currentflag = row(idx + 11)(Flag.column),
        rowguid = row(idx + 12)(Column.columnToUUID),
        modifieddate = row(idx + 13)(TypoLocalDateTime.column),
        organizationnode = row(idx + 14)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[EmployeeRow] = OWrites[EmployeeRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "nationalidnumber" -> Writes.StringWrites.writes(o.nationalidnumber),
      "loginid" -> Writes.StringWrites.writes(o.loginid),
      "jobtitle" -> Writes.StringWrites.writes(o.jobtitle),
      "birthdate" -> TypoLocalDate.writes.writes(o.birthdate),
      "maritalstatus" -> Writes.StringWrites.writes(o.maritalstatus),
      "gender" -> Writes.StringWrites.writes(o.gender),
      "hiredate" -> TypoLocalDate.writes.writes(o.hiredate),
      "salariedflag" -> Flag.writes.writes(o.salariedflag),
      "vacationhours" -> TypoShort.writes.writes(o.vacationhours),
      "sickleavehours" -> TypoShort.writes.writes(o.sickleavehours),
      "currentflag" -> Flag.writes.writes(o.currentflag),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate),
      "organizationnode" -> Writes.OptionWrites(Writes.StringWrites).writes(o.organizationnode)
    ))
  )
}
