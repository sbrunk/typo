/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package jc

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.humanresources.jobcandidate.JobcandidateId
import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.SqlExpr.OptField

trait JcViewFields[Row] {
  val id: OptField[Int, Row]
  val jobcandidateid: OptField[JobcandidateId, Row]
  val businessentityid: OptField[BusinessentityId, Row]
  val resume: OptField[TypoXml, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object JcViewFields extends JcViewStructure[JcViewRow](None, identity, (_, x) => x)

