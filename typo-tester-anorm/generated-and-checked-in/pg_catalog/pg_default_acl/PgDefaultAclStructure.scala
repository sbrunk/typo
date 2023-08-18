/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_default_acl

import adventureworks.TypoAclItem
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class PgDefaultAclStructure[Row](val prefix: Option[String], val extract: Row => PgDefaultAclRow, val merge: (Row, PgDefaultAclRow) => Row)
  extends Relation[PgDefaultAclFields, PgDefaultAclRow, Row]
    with PgDefaultAclFields[Row] { outer =>

  override val oid = new IdField[PgDefaultAclId, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val defaclrole = new Field[/* oid */ Long, Row](prefix, "defaclrole", None, Some("oid"))(x => extract(x).defaclrole, (row, value) => merge(row, extract(row).copy(defaclrole = value)))
  override val defaclnamespace = new Field[/* oid */ Long, Row](prefix, "defaclnamespace", None, Some("oid"))(x => extract(x).defaclnamespace, (row, value) => merge(row, extract(row).copy(defaclnamespace = value)))
  override val defaclobjtype = new Field[String, Row](prefix, "defaclobjtype", None, Some("char"))(x => extract(x).defaclobjtype, (row, value) => merge(row, extract(row).copy(defaclobjtype = value)))
  override val defaclacl = new Field[Array[TypoAclItem], Row](prefix, "defaclacl", None, Some("_aclitem"))(x => extract(x).defaclacl, (row, value) => merge(row, extract(row).copy(defaclacl = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgDefaultAclRow, merge: (NewRow, PgDefaultAclRow) => NewRow): PgDefaultAclStructure[NewRow] =
    new PgDefaultAclStructure(prefix, extract, merge)
}
