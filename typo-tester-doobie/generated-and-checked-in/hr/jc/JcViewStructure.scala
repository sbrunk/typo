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
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class JcViewStructure[Row](val prefix: Option[String], val extract: Row => JcViewRow, val merge: (Row, JcViewRow) => Row)
  extends Relation[JcViewFields, JcViewRow, Row]
    with JcViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val jobcandidateid = new OptField[JobcandidateId, Row](prefix, "jobcandidateid", None, Some("int4"))(x => extract(x).jobcandidateid, (row, value) => merge(row, extract(row).copy(jobcandidateid = value)))
  override val businessentityid = new OptField[BusinessentityId, Row](prefix, "businessentityid", None, Some("int4"))(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
  override val resume = new OptField[TypoXml, Row](prefix, "resume", None, Some("xml"))(x => extract(x).resume, (row, value) => merge(row, extract(row).copy(resume = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, jobcandidateid, businessentityid, resume, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => JcViewRow, merge: (NewRow, JcViewRow) => NewRow): JcViewStructure[NewRow] =
    new JcViewStructure(prefix, extract, merge)
}
