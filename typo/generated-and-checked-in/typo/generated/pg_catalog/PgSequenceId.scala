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

case class PgSequenceId(value: Long) extends AnyVal
object PgSequenceId {
  implicit val ordering: Ordering[PgSequenceId] = Ordering.by(_.value)
  implicit val format: Format[PgSequenceId] = implicitly[Format[Long]].bimap(PgSequenceId.apply, _.value)
  implicit val toStatement: ToStatement[PgSequenceId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgSequenceId] = implicitly[Column[Long]].map(PgSequenceId.apply)
  def rowParser(prefix: String): RowParser[PgSequenceId] = SqlParser.get[PgSequenceId](prefix + "seqrelid")
}
