/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog



sealed abstract class PgSeclabelsFieldValue[T](val name: String, val value: T)

object PgSeclabelsFieldValue {
  case class objoid(override val value: Option[/* oid */ Long]) extends PgSeclabelsFieldValue("objoid", value)
  case class classoid(override val value: Option[/* oid */ Long]) extends PgSeclabelsFieldValue("classoid", value)
  case class objsubid(override val value: Option[Int]) extends PgSeclabelsFieldValue("objsubid", value)
  case class objtype(override val value: Option[String]) extends PgSeclabelsFieldValue("objtype", value)
  case class objnamespace(override val value: Option[/* oid */ Long]) extends PgSeclabelsFieldValue("objnamespace", value)
  case class objname(override val value: Option[String]) extends PgSeclabelsFieldValue("objname", value)
  case class provider(override val value: Option[String]) extends PgSeclabelsFieldValue("provider", value)
  case class label(override val value: Option[String]) extends PgSeclabelsFieldValue("label", value)
}
