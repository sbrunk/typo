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

case class PgTsTemplateId(value: /* oid */ Long) extends AnyVal
object PgTsTemplateId {
  implicit val ordering: Ordering[PgTsTemplateId] = Ordering.by(_.value)
  implicit val format: Format[PgTsTemplateId] = implicitly[Format[/* oid */ Long]].bimap(PgTsTemplateId.apply, _.value)
  implicit val toStatement: ToStatement[PgTsTemplateId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgTsTemplateId] = implicitly[Column[/* oid */ Long]].map(PgTsTemplateId.apply)
  def rowParser(prefix: String): RowParser[PgTsTemplateId] = SqlParser.get[PgTsTemplateId](prefix + "oid")
}
