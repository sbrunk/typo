/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_trigger

import adventureworks.customtypes.TypoInt2Vector
import adventureworks.customtypes.TypoPgNodeTree
import adventureworks.customtypes.TypoShort
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgTriggerStructure[Row](val prefix: Option[String], val extract: Row => PgTriggerRow, val merge: (Row, PgTriggerRow) => Row)
  extends Relation[PgTriggerFields, PgTriggerRow, Row]
    with PgTriggerFields[Row] { outer =>

  override val oid = new IdField[PgTriggerId, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val tgrelid = new Field[/* oid */ Long, Row](prefix, "tgrelid", None, Some("oid"))(x => extract(x).tgrelid, (row, value) => merge(row, extract(row).copy(tgrelid = value)))
  override val tgparentid = new Field[/* oid */ Long, Row](prefix, "tgparentid", None, Some("oid"))(x => extract(x).tgparentid, (row, value) => merge(row, extract(row).copy(tgparentid = value)))
  override val tgname = new Field[String, Row](prefix, "tgname", None, Some("name"))(x => extract(x).tgname, (row, value) => merge(row, extract(row).copy(tgname = value)))
  override val tgfoid = new Field[/* oid */ Long, Row](prefix, "tgfoid", None, Some("oid"))(x => extract(x).tgfoid, (row, value) => merge(row, extract(row).copy(tgfoid = value)))
  override val tgtype = new Field[TypoShort, Row](prefix, "tgtype", None, Some("int2"))(x => extract(x).tgtype, (row, value) => merge(row, extract(row).copy(tgtype = value)))
  override val tgenabled = new Field[String, Row](prefix, "tgenabled", None, Some("char"))(x => extract(x).tgenabled, (row, value) => merge(row, extract(row).copy(tgenabled = value)))
  override val tgisinternal = new Field[Boolean, Row](prefix, "tgisinternal", None, None)(x => extract(x).tgisinternal, (row, value) => merge(row, extract(row).copy(tgisinternal = value)))
  override val tgconstrrelid = new Field[/* oid */ Long, Row](prefix, "tgconstrrelid", None, Some("oid"))(x => extract(x).tgconstrrelid, (row, value) => merge(row, extract(row).copy(tgconstrrelid = value)))
  override val tgconstrindid = new Field[/* oid */ Long, Row](prefix, "tgconstrindid", None, Some("oid"))(x => extract(x).tgconstrindid, (row, value) => merge(row, extract(row).copy(tgconstrindid = value)))
  override val tgconstraint = new Field[/* oid */ Long, Row](prefix, "tgconstraint", None, Some("oid"))(x => extract(x).tgconstraint, (row, value) => merge(row, extract(row).copy(tgconstraint = value)))
  override val tgdeferrable = new Field[Boolean, Row](prefix, "tgdeferrable", None, None)(x => extract(x).tgdeferrable, (row, value) => merge(row, extract(row).copy(tgdeferrable = value)))
  override val tginitdeferred = new Field[Boolean, Row](prefix, "tginitdeferred", None, None)(x => extract(x).tginitdeferred, (row, value) => merge(row, extract(row).copy(tginitdeferred = value)))
  override val tgnargs = new Field[TypoShort, Row](prefix, "tgnargs", None, Some("int2"))(x => extract(x).tgnargs, (row, value) => merge(row, extract(row).copy(tgnargs = value)))
  override val tgattr = new Field[TypoInt2Vector, Row](prefix, "tgattr", None, Some("int2vector"))(x => extract(x).tgattr, (row, value) => merge(row, extract(row).copy(tgattr = value)))
  override val tgargs = new Field[Array[Byte], Row](prefix, "tgargs", None, Some("bytea"))(x => extract(x).tgargs, (row, value) => merge(row, extract(row).copy(tgargs = value)))
  override val tgqual = new OptField[TypoPgNodeTree, Row](prefix, "tgqual", None, Some("pg_node_tree"))(x => extract(x).tgqual, (row, value) => merge(row, extract(row).copy(tgqual = value)))
  override val tgoldtable = new OptField[String, Row](prefix, "tgoldtable", None, Some("name"))(x => extract(x).tgoldtable, (row, value) => merge(row, extract(row).copy(tgoldtable = value)))
  override val tgnewtable = new OptField[String, Row](prefix, "tgnewtable", None, Some("name"))(x => extract(x).tgnewtable, (row, value) => merge(row, extract(row).copy(tgnewtable = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, tgrelid, tgparentid, tgname, tgfoid, tgtype, tgenabled, tgisinternal, tgconstrrelid, tgconstrindid, tgconstraint, tgdeferrable, tginitdeferred, tgnargs, tgattr, tgargs, tgqual, tgoldtable, tgnewtable)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgTriggerRow, merge: (NewRow, PgTriggerRow) => NewRow): PgTriggerStructure[NewRow] =
    new PgTriggerStructure(prefix, extract, merge)
}
