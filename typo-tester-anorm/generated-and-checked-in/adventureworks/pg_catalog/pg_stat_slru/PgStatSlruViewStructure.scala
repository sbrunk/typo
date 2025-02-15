/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_slru

import adventureworks.customtypes.TypoInstant
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgStatSlruViewStructure[Row](val prefix: Option[String], val extract: Row => PgStatSlruViewRow, val merge: (Row, PgStatSlruViewRow) => Row)
  extends Relation[PgStatSlruViewFields, PgStatSlruViewRow, Row]
    with PgStatSlruViewFields[Row] { outer =>

  override val name = new OptField[String, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val blksZeroed = new OptField[Long, Row](prefix, "blks_zeroed", None, None)(x => extract(x).blksZeroed, (row, value) => merge(row, extract(row).copy(blksZeroed = value)))
  override val blksHit = new OptField[Long, Row](prefix, "blks_hit", None, None)(x => extract(x).blksHit, (row, value) => merge(row, extract(row).copy(blksHit = value)))
  override val blksRead = new OptField[Long, Row](prefix, "blks_read", None, None)(x => extract(x).blksRead, (row, value) => merge(row, extract(row).copy(blksRead = value)))
  override val blksWritten = new OptField[Long, Row](prefix, "blks_written", None, None)(x => extract(x).blksWritten, (row, value) => merge(row, extract(row).copy(blksWritten = value)))
  override val blksExists = new OptField[Long, Row](prefix, "blks_exists", None, None)(x => extract(x).blksExists, (row, value) => merge(row, extract(row).copy(blksExists = value)))
  override val flushes = new OptField[Long, Row](prefix, "flushes", None, None)(x => extract(x).flushes, (row, value) => merge(row, extract(row).copy(flushes = value)))
  override val truncates = new OptField[Long, Row](prefix, "truncates", None, None)(x => extract(x).truncates, (row, value) => merge(row, extract(row).copy(truncates = value)))
  override val statsReset = new OptField[TypoInstant, Row](prefix, "stats_reset", Some("text"), None)(x => extract(x).statsReset, (row, value) => merge(row, extract(row).copy(statsReset = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](name, blksZeroed, blksHit, blksRead, blksWritten, blksExists, flushes, truncates, statsReset)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatSlruViewRow, merge: (NewRow, PgStatSlruViewRow) => NewRow): PgStatSlruViewStructure[NewRow] =
    new PgStatSlruViewStructure(prefix, extract, merge)
}
