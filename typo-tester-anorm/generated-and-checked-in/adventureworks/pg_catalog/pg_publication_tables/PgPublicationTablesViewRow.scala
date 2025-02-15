/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_tables

import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class PgPublicationTablesViewRow(
  /** Points to [[pg_publication.PgPublicationRow.pubname]] */
  pubname: String,
  /** Points to [[pg_namespace.PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[pg_class.PgClassRow.relname]] */
  tablename: String
)

object PgPublicationTablesViewRow {
  implicit lazy val reads: Reads[PgPublicationTablesViewRow] = Reads[PgPublicationTablesViewRow](json => JsResult.fromTry(
      Try(
        PgPublicationTablesViewRow(
          pubname = json.\("pubname").as(Reads.StringReads),
          schemaname = json.\("schemaname").as(Reads.StringReads),
          tablename = json.\("tablename").as(Reads.StringReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgPublicationTablesViewRow] = RowParser[PgPublicationTablesViewRow] { row =>
    Success(
      PgPublicationTablesViewRow(
        pubname = row(idx + 0)(Column.columnToString),
        schemaname = row(idx + 1)(Column.columnToString),
        tablename = row(idx + 2)(Column.columnToString)
      )
    )
  }
  implicit lazy val writes: OWrites[PgPublicationTablesViewRow] = OWrites[PgPublicationTablesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "pubname" -> Writes.StringWrites.writes(o.pubname),
      "schemaname" -> Writes.StringWrites.writes(o.schemaname),
      "tablename" -> Writes.StringWrites.writes(o.tablename)
    ))
  )
}
