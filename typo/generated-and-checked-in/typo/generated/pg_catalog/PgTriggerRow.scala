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

case class PgTriggerRow(
  oid: PgTriggerId,
  tgrelid: Long,
  tgparentid: Long,
  tgname: String,
  tgfoid: Long,
  tgtype: Short,
  tgenabled: String,
  tgisinternal: Boolean,
  tgconstrrelid: Long,
  tgconstrindid: Long,
  tgconstraint: Long,
  tgdeferrable: Boolean,
  tginitdeferred: Boolean,
  tgnargs: Short,
  tgattr: Array[Short],
  tgargs: String,
  tgqual: Option[String],
  tgoldtable: Option[String],
  tgnewtable: Option[String]
)

object PgTriggerRow {
  implicit val rowParser: RowParser[PgTriggerRow] = { row =>
    Success(
      PgTriggerRow(
        oid = row[PgTriggerId]("oid"),
        tgrelid = row[Long]("tgrelid"),
        tgparentid = row[Long]("tgparentid"),
        tgname = row[String]("tgname"),
        tgfoid = row[Long]("tgfoid"),
        tgtype = row[Short]("tgtype"),
        tgenabled = row[String]("tgenabled"),
        tgisinternal = row[Boolean]("tgisinternal"),
        tgconstrrelid = row[Long]("tgconstrrelid"),
        tgconstrindid = row[Long]("tgconstrindid"),
        tgconstraint = row[Long]("tgconstraint"),
        tgdeferrable = row[Boolean]("tgdeferrable"),
        tginitdeferred = row[Boolean]("tginitdeferred"),
        tgnargs = row[Short]("tgnargs"),
        tgattr = row[Array[Short]]("tgattr"),
        tgargs = row[String]("tgargs"),
        tgqual = row[Option[String]]("tgqual"),
        tgoldtable = row[Option[String]]("tgoldtable"),
        tgnewtable = row[Option[String]]("tgnewtable")
      )
    )
  }

  
}
