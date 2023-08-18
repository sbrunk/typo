/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_tables

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ForeignTablesViewRow(
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignTableCatalog]] */
  foreignTableCatalog: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignTableSchema]] */
  foreignTableSchema: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignTableName]] */
  foreignTableName: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignServerName]] */
  foreignServerName: Option[SqlIdentifier]
)

object ForeignTablesViewRow {
  implicit lazy val decoder: Decoder[ForeignTablesViewRow] = Decoder.forProduct5[ForeignTablesViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("foreign_table_catalog", "foreign_table_schema", "foreign_table_name", "foreign_server_catalog", "foreign_server_name")(ForeignTablesViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder))
  implicit lazy val encoder: Encoder[ForeignTablesViewRow] = Encoder.forProduct5[ForeignTablesViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("foreign_table_catalog", "foreign_table_schema", "foreign_table_name", "foreign_server_catalog", "foreign_server_name")(x => (x.foreignTableCatalog, x.foreignTableSchema, x.foreignTableName, x.foreignServerCatalog, x.foreignServerName))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder))
  implicit lazy val read: Read[ForeignTablesViewRow] = new Read[ForeignTablesViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ForeignTablesViewRow(
      foreignTableCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      foreignTableSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      foreignTableName = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      foreignServerCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 3),
      foreignServerName = SqlIdentifier.get.unsafeGetNullable(rs, i + 4)
    )
  )
}
