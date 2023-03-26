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

case class PgExtensionId(value: Long) extends AnyVal
object PgExtensionId {
  implicit val ordering: Ordering[PgExtensionId] = Ordering.by(_.value)
  implicit val format: Format[PgExtensionId] = implicitly[Format[Long]].bimap(PgExtensionId.apply, _.value)
  implicit val toStatement: ToStatement[PgExtensionId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgExtensionId] = implicitly[Column[Long]].map(PgExtensionId.apply)
  def rowParser(prefix: String): RowParser[PgExtensionId] = SqlParser.get[PgExtensionId](prefix + "oid")
}
