/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pc

import adventureworks.TypoLocalDateTime
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.Name
import java.util.UUID
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PcViewStructure[Row](val prefix: Option[String], val extract: Row => PcViewRow, val merge: (Row, PcViewRow) => Row)
  extends Relation[PcViewFields, PcViewRow, Row]
    with PcViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val productcategoryid = new OptField[ProductcategoryId, Row](prefix, "productcategoryid", None, Some("int4"))(x => extract(x).productcategoryid, (row, value) => merge(row, extract(row).copy(productcategoryid = value)))
  override val name = new OptField[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val rowguid = new OptField[UUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, productcategoryid, name, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PcViewRow, merge: (NewRow, PcViewRow) => NewRow): PcViewStructure[NewRow] =
    new PcViewStructure(prefix, extract, merge)
}
