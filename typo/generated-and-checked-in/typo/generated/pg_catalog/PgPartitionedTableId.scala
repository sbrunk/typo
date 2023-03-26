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

case class PgPartitionedTableId(value: /* oid */ Long) extends AnyVal
object PgPartitionedTableId {
  implicit val ordering: Ordering[PgPartitionedTableId] = Ordering.by(_.value)
  implicit val format: Format[PgPartitionedTableId] = implicitly[Format[/* oid */ Long]].bimap(PgPartitionedTableId.apply, _.value)
  implicit val toStatement: ToStatement[PgPartitionedTableId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgPartitionedTableId] = implicitly[Column[/* oid */ Long]].map(PgPartitionedTableId.apply)
  def rowParser(prefix: String): RowParser[PgPartitionedTableId] = SqlParser.get[PgPartitionedTableId](prefix + "partrelid")
}
