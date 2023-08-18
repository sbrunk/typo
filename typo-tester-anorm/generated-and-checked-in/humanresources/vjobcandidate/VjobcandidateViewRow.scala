/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidate

import adventureworks.TypoLocalDateTime
import adventureworks.humanresources.jobcandidate.JobcandidateId
import adventureworks.person.businessentity.BusinessentityId
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

case class VjobcandidateViewRow(
  /** Points to [[jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: Option[JobcandidateId],
  /** Points to [[jobcandidate.JobcandidateRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  `Name.Prefix`: Option[/* max 30 chars */ String],
  `Name.First`: Option[/* max 30 chars */ String],
  `Name.Middle`: Option[/* max 30 chars */ String],
  `Name.Last`: Option[/* max 30 chars */ String],
  `Name.Suffix`: Option[/* max 30 chars */ String],
  Skills: Option[String],
  `Addr.Type`: Option[/* max 30 chars */ String],
  `Addr.Loc.CountryRegion`: Option[/* max 100 chars */ String],
  `Addr.Loc.State`: Option[/* max 100 chars */ String],
  `Addr.Loc.City`: Option[/* max 100 chars */ String],
  `Addr.PostalCode`: Option[/* max 20 chars */ String],
  EMail: Option[String],
  WebSite: Option[String],
  /** Points to [[jobcandidate.JobcandidateRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object VjobcandidateViewRow {
  implicit lazy val reads: Reads[VjobcandidateViewRow] = Reads[VjobcandidateViewRow](json => JsResult.fromTry(
      Try(
        VjobcandidateViewRow(
          jobcandidateid = json.\("jobcandidateid").toOption.map(_.as(JobcandidateId.reads)),
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          `Name.Prefix` = json.\("Name.Prefix").toOption.map(_.as(Reads.StringReads)),
          `Name.First` = json.\("Name.First").toOption.map(_.as(Reads.StringReads)),
          `Name.Middle` = json.\("Name.Middle").toOption.map(_.as(Reads.StringReads)),
          `Name.Last` = json.\("Name.Last").toOption.map(_.as(Reads.StringReads)),
          `Name.Suffix` = json.\("Name.Suffix").toOption.map(_.as(Reads.StringReads)),
          Skills = json.\("Skills").toOption.map(_.as(Reads.StringReads)),
          `Addr.Type` = json.\("Addr.Type").toOption.map(_.as(Reads.StringReads)),
          `Addr.Loc.CountryRegion` = json.\("Addr.Loc.CountryRegion").toOption.map(_.as(Reads.StringReads)),
          `Addr.Loc.State` = json.\("Addr.Loc.State").toOption.map(_.as(Reads.StringReads)),
          `Addr.Loc.City` = json.\("Addr.Loc.City").toOption.map(_.as(Reads.StringReads)),
          `Addr.PostalCode` = json.\("Addr.PostalCode").toOption.map(_.as(Reads.StringReads)),
          EMail = json.\("EMail").toOption.map(_.as(Reads.StringReads)),
          WebSite = json.\("WebSite").toOption.map(_.as(Reads.StringReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VjobcandidateViewRow] = RowParser[VjobcandidateViewRow] { row =>
    Success(
      VjobcandidateViewRow(
        jobcandidateid = row(idx + 0)(Column.columnToOption(JobcandidateId.column)),
        businessentityid = row(idx + 1)(Column.columnToOption(BusinessentityId.column)),
        `Name.Prefix` = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        `Name.First` = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        `Name.Middle` = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        `Name.Last` = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        `Name.Suffix` = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        Skills = row(idx + 7)(Column.columnToOption(Column.columnToString)),
        `Addr.Type` = row(idx + 8)(Column.columnToOption(Column.columnToString)),
        `Addr.Loc.CountryRegion` = row(idx + 9)(Column.columnToOption(Column.columnToString)),
        `Addr.Loc.State` = row(idx + 10)(Column.columnToOption(Column.columnToString)),
        `Addr.Loc.City` = row(idx + 11)(Column.columnToOption(Column.columnToString)),
        `Addr.PostalCode` = row(idx + 12)(Column.columnToOption(Column.columnToString)),
        EMail = row(idx + 13)(Column.columnToOption(Column.columnToString)),
        WebSite = row(idx + 14)(Column.columnToOption(Column.columnToString)),
        modifieddate = row(idx + 15)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[VjobcandidateViewRow] = OWrites[VjobcandidateViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "jobcandidateid" -> Writes.OptionWrites(JobcandidateId.writes).writes(o.jobcandidateid),
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "Name.Prefix" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Name.Prefix`),
      "Name.First" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Name.First`),
      "Name.Middle" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Name.Middle`),
      "Name.Last" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Name.Last`),
      "Name.Suffix" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Name.Suffix`),
      "Skills" -> Writes.OptionWrites(Writes.StringWrites).writes(o.Skills),
      "Addr.Type" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Addr.Type`),
      "Addr.Loc.CountryRegion" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Addr.Loc.CountryRegion`),
      "Addr.Loc.State" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Addr.Loc.State`),
      "Addr.Loc.City" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Addr.Loc.City`),
      "Addr.PostalCode" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`Addr.PostalCode`),
      "EMail" -> Writes.OptionWrites(Writes.StringWrites).writes(o.EMail),
      "WebSite" -> Writes.OptionWrites(Writes.StringWrites).writes(o.WebSite),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
