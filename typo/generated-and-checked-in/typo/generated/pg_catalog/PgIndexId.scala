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

case class PgIndexId(value: /* oid */ Long) extends AnyVal
object PgIndexId {
  implicit val ordering: Ordering[PgIndexId] = Ordering.by(_.value)
  implicit val format: Format[PgIndexId] = implicitly[Format[/* oid */ Long]].bimap(PgIndexId.apply, _.value)
  implicit val toStatement: ToStatement[PgIndexId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgIndexId] = implicitly[Column[/* oid */ Long]].map(PgIndexId.apply)
  def rowParser(prefix: String): RowParser[PgIndexId] = SqlParser.get[PgIndexId](prefix + "indexrelid")
}
