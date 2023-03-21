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

import anorm.RowParser
import anorm.Success

case class PgPartitionedTableRow(
  partrelid: PgPartitionedTableId,
  partstrat: String,
  partnatts: Short,
  partdefid: Long,
  partattrs: Array[Short],
  partclass: Array[Long],
  partcollation: Array[Long],
  partexprs: Option[String]
)

object PgPartitionedTableRow {
  implicit val rowParser: RowParser[PgPartitionedTableRow] = { row =>
    Success(
      PgPartitionedTableRow(
        partrelid = row[PgPartitionedTableId]("partrelid"),
        partstrat = row[String]("partstrat"),
        partnatts = row[Short]("partnatts"),
        partdefid = row[Long]("partdefid"),
        partattrs = row[Array[Short]]("partattrs"),
        partclass = row[Array[Long]]("partclass"),
        partcollation = row[Array[Long]]("partcollation"),
        partexprs = row[Option[String]]("partexprs")
      )
    )
  }

  
}
