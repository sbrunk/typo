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

case class PgConstraintId(value: /* oid */ Long) extends AnyVal
object PgConstraintId {
  implicit val ordering: Ordering[PgConstraintId] = Ordering.by(_.value)
  implicit val format: Format[PgConstraintId] = implicitly[Format[/* oid */ Long]].bimap(PgConstraintId.apply, _.value)
  implicit val toStatement: ToStatement[PgConstraintId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgConstraintId] = implicitly[Column[/* oid */ Long]].map(PgConstraintId.apply)
  def rowParser(prefix: String): RowParser[PgConstraintId] = SqlParser.get[PgConstraintId](prefix + "oid")
}
