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



sealed abstract class PgStatXactUserFunctionsFieldValue[T](val name: String, val value: T)

object PgStatXactUserFunctionsFieldValue {
  case class funcid(override val value: Option[/* oid */ Long]) extends PgStatXactUserFunctionsFieldValue("funcid", value)
  case class schemaname(override val value: Option[String]) extends PgStatXactUserFunctionsFieldValue("schemaname", value)
  case class funcname(override val value: Option[String]) extends PgStatXactUserFunctionsFieldValue("funcname", value)
  case class calls(override val value: Option[Long]) extends PgStatXactUserFunctionsFieldValue("calls", value)
  case class totalTime(override val value: Option[Double]) extends PgStatXactUserFunctionsFieldValue("total_time", value)
  case class selfTime(override val value: Option[Double]) extends PgStatXactUserFunctionsFieldValue("self_time", value)
}
