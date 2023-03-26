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

case class PgConversionId(value: Long) extends AnyVal
object PgConversionId {
  implicit val ordering: Ordering[PgConversionId] = Ordering.by(_.value)
  implicit val format: Format[PgConversionId] = implicitly[Format[Long]].bimap(PgConversionId.apply, _.value)
  implicit val toStatement: ToStatement[PgConversionId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgConversionId] = implicitly[Column[Long]].map(PgConversionId.apply)
  def rowParser(prefix: String): RowParser[PgConversionId] = SqlParser.get[PgConversionId](prefix + "oid")
}
