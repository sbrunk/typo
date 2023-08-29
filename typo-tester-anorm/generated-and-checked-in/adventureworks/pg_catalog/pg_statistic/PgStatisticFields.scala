/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic

import adventureworks.customtypes.TypoAnyArray
import adventureworks.customtypes.TypoShort
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait PgStatisticFields[Row] {
  val starelid: IdField[/* oid */ Long, Row]
  val staattnum: IdField[TypoShort, Row]
  val stainherit: IdField[Boolean, Row]
  val stanullfrac: Field[Float, Row]
  val stawidth: Field[Int, Row]
  val stadistinct: Field[Float, Row]
  val stakind1: Field[TypoShort, Row]
  val stakind2: Field[TypoShort, Row]
  val stakind3: Field[TypoShort, Row]
  val stakind4: Field[TypoShort, Row]
  val stakind5: Field[TypoShort, Row]
  val staop1: Field[/* oid */ Long, Row]
  val staop2: Field[/* oid */ Long, Row]
  val staop3: Field[/* oid */ Long, Row]
  val staop4: Field[/* oid */ Long, Row]
  val staop5: Field[/* oid */ Long, Row]
  val stacoll1: Field[/* oid */ Long, Row]
  val stacoll2: Field[/* oid */ Long, Row]
  val stacoll3: Field[/* oid */ Long, Row]
  val stacoll4: Field[/* oid */ Long, Row]
  val stacoll5: Field[/* oid */ Long, Row]
  val stanumbers1: OptField[Array[Float], Row]
  val stanumbers2: OptField[Array[Float], Row]
  val stanumbers3: OptField[Array[Float], Row]
  val stanumbers4: OptField[Array[Float], Row]
  val stanumbers5: OptField[Array[Float], Row]
  val stavalues1: OptField[TypoAnyArray, Row]
  val stavalues2: OptField[TypoAnyArray, Row]
  val stavalues3: OptField[TypoAnyArray, Row]
  val stavalues4: OptField[TypoAnyArray, Row]
  val stavalues5: OptField[TypoAnyArray, Row]
}
object PgStatisticFields extends PgStatisticStructure[PgStatisticRow](None, identity, (_, x) => x)

