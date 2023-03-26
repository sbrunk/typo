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

case class PgAttrdefId(value: /* oid */ Long) extends AnyVal
object PgAttrdefId {
  implicit val ordering: Ordering[PgAttrdefId] = Ordering.by(_.value)
  implicit val format: Format[PgAttrdefId] = implicitly[Format[/* oid */ Long]].bimap(PgAttrdefId.apply, _.value)
  implicit val toStatement: ToStatement[PgAttrdefId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgAttrdefId] = implicitly[Column[/* oid */ Long]].map(PgAttrdefId.apply)
  def rowParser(prefix: String): RowParser[PgAttrdefId] = SqlParser.get[PgAttrdefId](prefix + "oid")
}
