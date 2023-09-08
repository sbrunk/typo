/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressId
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class BusinessentityaddressStructure[Row](val prefix: Option[String], val extract: Row => BusinessentityaddressRow, val merge: (Row, BusinessentityaddressRow) => Row)
  extends Relation[BusinessentityaddressFields, BusinessentityaddressRow, Row]
    with BusinessentityaddressFields[Row] { outer =>

  override val businessentityid = new IdField[BusinessentityId, Row](prefix, "businessentityid", None, Some("int4"))(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
  override val addressid = new IdField[AddressId, Row](prefix, "addressid", None, Some("int4"))(x => extract(x).addressid, (row, value) => merge(row, extract(row).copy(addressid = value)))
  override val addresstypeid = new IdField[AddresstypeId, Row](prefix, "addresstypeid", None, Some("int4"))(x => extract(x).addresstypeid, (row, value) => merge(row, extract(row).copy(addresstypeid = value)))
  override val rowguid = new Field[TypoUUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](businessentityid, addressid, addresstypeid, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => BusinessentityaddressRow, merge: (NewRow, BusinessentityaddressRow) => NewRow): BusinessentityaddressStructure[NewRow] =
    new BusinessentityaddressStructure(prefix, extract, merge)
}
