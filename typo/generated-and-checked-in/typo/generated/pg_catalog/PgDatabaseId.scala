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

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgDatabaseId(value: /* oid */ Long) extends AnyVal
object PgDatabaseId {
  implicit val ordering: Ordering[PgDatabaseId] = Ordering.by(_.value)
  implicit val format: Format[PgDatabaseId] = implicitly[Format[/* oid */ Long]].bimap(PgDatabaseId.apply, _.value)
  implicit val toStatement: ToStatement[PgDatabaseId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgDatabaseId] = implicitly[Column[/* oid */ Long]].map(PgDatabaseId.apply)
  def rowParser(prefix: String): RowParser[PgDatabaseId] = SqlParser.get[PgDatabaseId](prefix + "oid")
}
