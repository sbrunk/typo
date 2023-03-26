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

case class PgTypeId(value: /* oid */ Long) extends AnyVal
object PgTypeId {
  implicit val ordering: Ordering[PgTypeId] = Ordering.by(_.value)
  implicit val format: Format[PgTypeId] = implicitly[Format[/* oid */ Long]].bimap(PgTypeId.apply, _.value)
  implicit val toStatement: ToStatement[PgTypeId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgTypeId] = implicitly[Column[/* oid */ Long]].map(PgTypeId.apply)
  def rowParser(prefix: String): RowParser[PgTypeId] = SqlParser.get[PgTypeId](prefix + "oid")
}
