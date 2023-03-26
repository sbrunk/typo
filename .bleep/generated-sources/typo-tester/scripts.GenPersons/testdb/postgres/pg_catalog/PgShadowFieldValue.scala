/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.time.ZonedDateTime

sealed abstract class PgShadowFieldValue[T](val name: String, val value: T)

object PgShadowFieldValue {
  case class usename(override val value: Option[String]) extends PgShadowFieldValue("usename", value)
  case class usesysid(override val value: Option[/* oid */ Long]) extends PgShadowFieldValue("usesysid", value)
  case class usecreatedb(override val value: Option[Boolean]) extends PgShadowFieldValue("usecreatedb", value)
  case class usesuper(override val value: Option[Boolean]) extends PgShadowFieldValue("usesuper", value)
  case class userepl(override val value: Option[Boolean]) extends PgShadowFieldValue("userepl", value)
  case class usebypassrls(override val value: Option[Boolean]) extends PgShadowFieldValue("usebypassrls", value)
  case class passwd(override val value: Option[String]) extends PgShadowFieldValue("passwd", value)
  case class valuntil(override val value: Option[ZonedDateTime]) extends PgShadowFieldValue("valuntil", value)
  case class useconfig(override val value: Option[Array[String]]) extends PgShadowFieldValue("useconfig", value)
}
