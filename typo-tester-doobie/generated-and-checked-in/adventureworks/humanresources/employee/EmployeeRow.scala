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
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

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
  implicit lazy val decoder: Decoder[EmployeeRow] = Decoder.forProduct15[EmployeeRow, BusinessentityId, /* max 15 chars */ String, /* max 256 chars */ String, /* max 50 chars */ String, TypoLocalDate, /* bpchar, max 1 chars */ String, /* bpchar, max 1 chars */ String, TypoLocalDate, Flag, TypoShort, TypoShort, Flag, UUID, TypoLocalDateTime, Option[String]]("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode")(EmployeeRow.apply)(BusinessentityId.decoder, Decoder.decodeString, Decoder.decodeString, Decoder.decodeString, TypoLocalDate.decoder, Decoder.decodeString, Decoder.decodeString, TypoLocalDate.decoder, Flag.decoder, TypoShort.decoder, TypoShort.decoder, Flag.decoder, Decoder.decodeUUID, TypoLocalDateTime.decoder, Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[EmployeeRow] = Encoder.forProduct15[EmployeeRow, BusinessentityId, /* max 15 chars */ String, /* max 256 chars */ String, /* max 50 chars */ String, TypoLocalDate, /* bpchar, max 1 chars */ String, /* bpchar, max 1 chars */ String, TypoLocalDate, Flag, TypoShort, TypoShort, Flag, UUID, TypoLocalDateTime, Option[String]]("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode")(x => (x.businessentityid, x.nationalidnumber, x.loginid, x.jobtitle, x.birthdate, x.maritalstatus, x.gender, x.hiredate, x.salariedflag, x.vacationhours, x.sickleavehours, x.currentflag, x.rowguid, x.modifieddate, x.organizationnode))(BusinessentityId.encoder, Encoder.encodeString, Encoder.encodeString, Encoder.encodeString, TypoLocalDate.encoder, Encoder.encodeString, Encoder.encodeString, TypoLocalDate.encoder, Flag.encoder, TypoShort.encoder, TypoShort.encoder, Flag.encoder, Encoder.encodeUUID, TypoLocalDateTime.encoder, Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[EmployeeRow] = new Read[EmployeeRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoLocalDate.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoLocalDate.get, Nullability.NoNulls),
      (Flag.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (Flag.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => EmployeeRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      nationalidnumber = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      loginid = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      jobtitle = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      birthdate = TypoLocalDate.get.unsafeGetNonNullable(rs, i + 4),
      maritalstatus = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 5),
      gender = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 6),
      hiredate = TypoLocalDate.get.unsafeGetNonNullable(rs, i + 7),
      salariedflag = Flag.get.unsafeGetNonNullable(rs, i + 8),
      vacationhours = TypoShort.get.unsafeGetNonNullable(rs, i + 9),
      sickleavehours = TypoShort.get.unsafeGetNonNullable(rs, i + 10),
      currentflag = Flag.get.unsafeGetNonNullable(rs, i + 11),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 12),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 13),
      organizationnode = Meta.StringMeta.get.unsafeGetNullable(rs, i + 14)
    )
  )
}
