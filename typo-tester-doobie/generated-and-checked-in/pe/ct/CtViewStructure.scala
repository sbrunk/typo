/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package ct

import adventureworks.TypoLocalDateTime
import adventureworks.person.contacttype.ContacttypeId
import adventureworks.public.Name
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class CtViewStructure[Row](val prefix: Option[String], val extract: Row => CtViewRow, val merge: (Row, CtViewRow) => Row)
  extends Relation[CtViewFields, CtViewRow, Row]
    with CtViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val contacttypeid = new OptField[ContacttypeId, Row](prefix, "contacttypeid", None, Some("int4"))(x => extract(x).contacttypeid, (row, value) => merge(row, extract(row).copy(contacttypeid = value)))
  override val name = new OptField[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, contacttypeid, name, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => CtViewRow, merge: (NewRow, CtViewRow) => NewRow): CtViewStructure[NewRow] =
    new CtViewStructure(prefix, extract, merge)
}
