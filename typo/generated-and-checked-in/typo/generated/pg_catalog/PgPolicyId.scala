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

case class PgPolicyId(value: /* oid */ Long) extends AnyVal
object PgPolicyId {
  implicit val ordering: Ordering[PgPolicyId] = Ordering.by(_.value)
  implicit val format: Format[PgPolicyId] = implicitly[Format[/* oid */ Long]].bimap(PgPolicyId.apply, _.value)
  implicit val toStatement: ToStatement[PgPolicyId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgPolicyId] = implicitly[Column[/* oid */ Long]].map(PgPolicyId.apply)
  def rowParser(prefix: String): RowParser[PgPolicyId] = SqlParser.get[PgPolicyId](prefix + "oid")
}
