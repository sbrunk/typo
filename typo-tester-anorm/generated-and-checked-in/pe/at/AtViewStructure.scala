/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package at

import adventureworks.TypoLocalDateTime
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.public.Name
import java.util.UUID
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class AtViewStructure[Row](val prefix: Option[String], val extract: Row => AtViewRow, val merge: (Row, AtViewRow) => Row)
  extends Relation[AtViewFields, AtViewRow, Row]
    with AtViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val addresstypeid = new OptField[AddresstypeId, Row](prefix, "addresstypeid", None, Some("int4"))(x => extract(x).addresstypeid, (row, value) => merge(row, extract(row).copy(addresstypeid = value)))
  override val name = new OptField[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val rowguid = new OptField[UUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, addresstypeid, name, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => AtViewRow, merge: (NewRow, AtViewRow) => NewRow): AtViewStructure[NewRow] =
    new AtViewStructure(prefix, extract, merge)
}
