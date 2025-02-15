/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats

import adventureworks.customtypes.TypoAnyArray
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait PgStatsViewFields[Row] {
  val schemaname: OptField[String, Row]
  val tablename: Field[String, Row]
  val attname: Field[String, Row]
  val inherited: Field[Boolean, Row]
  val nullFrac: Field[Float, Row]
  val avgWidth: Field[Int, Row]
  val nDistinct: Field[Float, Row]
  val mostCommonVals: OptField[TypoAnyArray, Row]
  val mostCommonFreqs: OptField[Array[Float], Row]
  val histogramBounds: OptField[TypoAnyArray, Row]
  val correlation: OptField[Float, Row]
  val mostCommonElems: OptField[TypoAnyArray, Row]
  val mostCommonElemFreqs: OptField[Array[Float], Row]
  val elemCountHistogram: OptField[Array[Float], Row]
}
object PgStatsViewFields extends PgStatsViewStructure[PgStatsViewRow](None, identity, (_, x) => x)

