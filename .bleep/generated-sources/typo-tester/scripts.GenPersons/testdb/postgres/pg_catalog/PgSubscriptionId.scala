/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgSubscriptionId(value: /* oid */ Long) extends AnyVal
object PgSubscriptionId {
  implicit val ordering: Ordering[PgSubscriptionId] = Ordering.by(_.value)
  implicit val format: Format[PgSubscriptionId] = implicitly[Format[/* oid */ Long]].bimap(PgSubscriptionId.apply, _.value)
  implicit val toStatement: ToStatement[PgSubscriptionId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgSubscriptionId] = implicitly[Column[/* oid */ Long]].map(PgSubscriptionId.apply)
  def rowParser(prefix: String): RowParser[PgSubscriptionId] = SqlParser.get[PgSubscriptionId](prefix + "oid")
}
