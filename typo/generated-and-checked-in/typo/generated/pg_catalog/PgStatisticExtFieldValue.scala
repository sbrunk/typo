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



sealed abstract class PgStatisticExtFieldValue[T](val name: String, val value: T)

object PgStatisticExtFieldValue {
  case class oid(override val value: PgStatisticExtId) extends PgStatisticExtFieldValue("oid", value)
  case class stxrelid(override val value: Long) extends PgStatisticExtFieldValue("stxrelid", value)
  case class stxname(override val value: String) extends PgStatisticExtFieldValue("stxname", value)
  case class stxnamespace(override val value: Long) extends PgStatisticExtFieldValue("stxnamespace", value)
  case class stxowner(override val value: Long) extends PgStatisticExtFieldValue("stxowner", value)
  case class stxstattarget(override val value: Int) extends PgStatisticExtFieldValue("stxstattarget", value)
  case class stxkeys(override val value: Array[Short]) extends PgStatisticExtFieldValue("stxkeys", value)
  case class stxkind(override val value: Array[String]) extends PgStatisticExtFieldValue("stxkind", value)
  case class stxexprs(override val value: Option[String]) extends PgStatisticExtFieldValue("stxexprs", value)
}
