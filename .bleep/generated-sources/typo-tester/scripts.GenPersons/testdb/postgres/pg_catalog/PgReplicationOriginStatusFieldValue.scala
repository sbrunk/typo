/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog



sealed abstract class PgReplicationOriginStatusFieldValue[T](val name: String, val value: T)

object PgReplicationOriginStatusFieldValue {
  case class localId(override val value: Option[/* oid */ Long]) extends PgReplicationOriginStatusFieldValue("local_id", value)
  case class externalId(override val value: Option[String]) extends PgReplicationOriginStatusFieldValue("external_id", value)
  case class remoteLsn(override val value: Option[String]) extends PgReplicationOriginStatusFieldValue("remote_lsn", value)
  case class localLsn(override val value: Option[String]) extends PgReplicationOriginStatusFieldValue("local_lsn", value)
}
