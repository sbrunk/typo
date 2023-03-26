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

case class PgStatisticExtId(value: Long) extends AnyVal
object PgStatisticExtId {
  implicit val ordering: Ordering[PgStatisticExtId] = Ordering.by(_.value)
  implicit val format: Format[PgStatisticExtId] = implicitly[Format[Long]].bimap(PgStatisticExtId.apply, _.value)
  implicit val toStatement: ToStatement[PgStatisticExtId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgStatisticExtId] = implicitly[Column[Long]].map(PgStatisticExtId.apply)
  def rowParser(prefix: String): RowParser[PgStatisticExtId] = SqlParser.get[PgStatisticExtId](prefix + "oid")
}
