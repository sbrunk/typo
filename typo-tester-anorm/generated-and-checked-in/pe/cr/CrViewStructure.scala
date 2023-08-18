/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package cr

import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class CrViewStructure[Row](val prefix: Option[String], val extract: Row => CrViewRow, val merge: (Row, CrViewRow) => Row)
  extends Relation[CrViewFields, CrViewRow, Row]
    with CrViewFields[Row] { outer =>

  override val countryregioncode = new OptField[CountryregionId, Row](prefix, "countryregioncode", None, None)(x => extract(x).countryregioncode, (row, value) => merge(row, extract(row).copy(countryregioncode = value)))
  override val name = new OptField[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](countryregioncode, name, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => CrViewRow, merge: (NewRow, CrViewRow) => NewRow): CrViewStructure[NewRow] =
    new CrViewStructure(prefix, extract, merge)
}
