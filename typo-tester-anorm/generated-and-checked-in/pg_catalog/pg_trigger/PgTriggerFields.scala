/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_trigger

import adventureworks.TypoInt2Vector
import adventureworks.TypoPgNodeTree
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait PgTriggerFields[Row] {
  val oid: IdField[PgTriggerId, Row]
  val tgrelid: Field[/* oid */ Long, Row]
  val tgparentid: Field[/* oid */ Long, Row]
  val tgname: Field[String, Row]
  val tgfoid: Field[/* oid */ Long, Row]
  val tgtype: Field[Int, Row]
  val tgenabled: Field[String, Row]
  val tgisinternal: Field[Boolean, Row]
  val tgconstrrelid: Field[/* oid */ Long, Row]
  val tgconstrindid: Field[/* oid */ Long, Row]
  val tgconstraint: Field[/* oid */ Long, Row]
  val tgdeferrable: Field[Boolean, Row]
  val tginitdeferred: Field[Boolean, Row]
  val tgnargs: Field[Int, Row]
  val tgattr: Field[TypoInt2Vector, Row]
  val tgargs: Field[Array[Byte], Row]
  val tgqual: OptField[TypoPgNodeTree, Row]
  val tgoldtable: OptField[String, Row]
  val tgnewtable: OptField[String, Row]
}
object PgTriggerFields extends PgTriggerStructure[PgTriggerRow](None, identity, (_, x) => x)

