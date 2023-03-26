/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import org.postgresql.util.PGobject

sealed abstract class PgStatsFieldValue[T](val name: String, val value: T)

object PgStatsFieldValue {
  case class schemaname(override val value: Option[String]) extends PgStatsFieldValue("schemaname", value)
  case class tablename(override val value: Option[String]) extends PgStatsFieldValue("tablename", value)
  case class attname(override val value: Option[String]) extends PgStatsFieldValue("attname", value)
  case class inherited(override val value: Option[Boolean]) extends PgStatsFieldValue("inherited", value)
  case class nullFrac(override val value: Option[Float]) extends PgStatsFieldValue("null_frac", value)
  case class avgWidth(override val value: Option[Int]) extends PgStatsFieldValue("avg_width", value)
  case class nDistinct(override val value: Option[Float]) extends PgStatsFieldValue("n_distinct", value)
  case class mostCommonVals(override val value: Option[/* anyarray */ PGobject]) extends PgStatsFieldValue("most_common_vals", value)
  case class mostCommonFreqs(override val value: Option[Array[Float]]) extends PgStatsFieldValue("most_common_freqs", value)
  case class histogramBounds(override val value: Option[/* anyarray */ PGobject]) extends PgStatsFieldValue("histogram_bounds", value)
  case class correlation(override val value: Option[Float]) extends PgStatsFieldValue("correlation", value)
  case class mostCommonElems(override val value: Option[/* anyarray */ PGobject]) extends PgStatsFieldValue("most_common_elems", value)
  case class mostCommonElemFreqs(override val value: Option[Array[Float]]) extends PgStatsFieldValue("most_common_elem_freqs", value)
  case class elemCountHistogram(override val value: Option[Array[Float]]) extends PgStatsFieldValue("elem_count_histogram", value)
}
