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
import typo.dsl.SqlExpr.OptField

trait VjobcandidateViewFields[Row] {
  val jobcandidateid: OptField[JobcandidateId, Row]
  val businessentityid: OptField[BusinessentityId, Row]
  val `Name.Prefix`: OptField[/* max 30 chars */ String, Row]
  val `Name.First`: OptField[/* max 30 chars */ String, Row]
  val `Name.Middle`: OptField[/* max 30 chars */ String, Row]
  val `Name.Last`: OptField[/* max 30 chars */ String, Row]
  val `Name.Suffix`: OptField[/* max 30 chars */ String, Row]
  val Skills: OptField[String, Row]
  val `Addr.Type`: OptField[/* max 30 chars */ String, Row]
  val `Addr.Loc.CountryRegion`: OptField[/* max 100 chars */ String, Row]
  val `Addr.Loc.State`: OptField[/* max 100 chars */ String, Row]
  val `Addr.Loc.City`: OptField[/* max 100 chars */ String, Row]
  val `Addr.PostalCode`: OptField[/* max 20 chars */ String, Row]
  val EMail: OptField[String, Row]
  val WebSite: OptField[String, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object VjobcandidateViewFields extends VjobcandidateViewStructure[VjobcandidateViewRow](None, identity, (_, x) => x)

