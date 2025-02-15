/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shdepend

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class PgShdependStructure[Row](val prefix: Option[String], val extract: Row => PgShdependRow, val merge: (Row, PgShdependRow) => Row)
  extends Relation[PgShdependFields, PgShdependRow, Row]
    with PgShdependFields[Row] { outer =>

  override val dbid = new Field[/* oid */ Long, Row](prefix, "dbid", None, Some("oid"))(x => extract(x).dbid, (row, value) => merge(row, extract(row).copy(dbid = value)))
  override val classid = new Field[/* oid */ Long, Row](prefix, "classid", None, Some("oid"))(x => extract(x).classid, (row, value) => merge(row, extract(row).copy(classid = value)))
  override val objid = new Field[/* oid */ Long, Row](prefix, "objid", None, Some("oid"))(x => extract(x).objid, (row, value) => merge(row, extract(row).copy(objid = value)))
  override val objsubid = new Field[Int, Row](prefix, "objsubid", None, Some("int4"))(x => extract(x).objsubid, (row, value) => merge(row, extract(row).copy(objsubid = value)))
  override val refclassid = new Field[/* oid */ Long, Row](prefix, "refclassid", None, Some("oid"))(x => extract(x).refclassid, (row, value) => merge(row, extract(row).copy(refclassid = value)))
  override val refobjid = new Field[/* oid */ Long, Row](prefix, "refobjid", None, Some("oid"))(x => extract(x).refobjid, (row, value) => merge(row, extract(row).copy(refobjid = value)))
  override val deptype = new Field[String, Row](prefix, "deptype", None, Some("char"))(x => extract(x).deptype, (row, value) => merge(row, extract(row).copy(deptype = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](dbid, classid, objid, objsubid, refclassid, refobjid, deptype)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgShdependRow, merge: (NewRow, PgShdependRow) => NewRow): PgShdependStructure[NewRow] =
    new PgShdependStructure(prefix, extract, merge)
}
