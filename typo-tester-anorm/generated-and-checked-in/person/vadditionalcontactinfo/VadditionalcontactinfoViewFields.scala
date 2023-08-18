/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package vadditionalcontactinfo

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import java.util.UUID
import typo.dsl.SqlExpr.OptField

trait VadditionalcontactinfoViewFields[Row] {
  val businessentityid: OptField[BusinessentityId, Row]
  val firstname: OptField[Name, Row]
  val middlename: OptField[Name, Row]
  val lastname: OptField[Name, Row]
  val telephonenumber: OptField[TypoXml, Row]
  val telephonespecialinstructions: OptField[String, Row]
  val street: OptField[TypoXml, Row]
  val city: OptField[TypoXml, Row]
  val stateprovince: OptField[TypoXml, Row]
  val postalcode: OptField[TypoXml, Row]
  val countryregion: OptField[TypoXml, Row]
  val homeaddressspecialinstructions: OptField[TypoXml, Row]
  val emailaddress: OptField[TypoXml, Row]
  val emailspecialinstructions: OptField[String, Row]
  val emailtelephonenumber: OptField[TypoXml, Row]
  val rowguid: OptField[UUID, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object VadditionalcontactinfoViewFields extends VadditionalcontactinfoViewStructure[VadditionalcontactinfoViewRow](None, identity, (_, x) => x)

