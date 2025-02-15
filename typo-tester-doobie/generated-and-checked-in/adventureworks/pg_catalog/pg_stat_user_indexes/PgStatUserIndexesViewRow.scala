/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_user_indexes

import adventureworks.pg_catalog.pg_class.PgClassId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatUserIndexesViewRow(
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.relid]] */
  relid: Option[PgClassId],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.indexrelid]] */
  indexrelid: Option[PgClassId],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.indexrelname]] */
  indexrelname: Option[String],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.idxScan]] */
  idxScan: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.idxTupRead]] */
  idxTupRead: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.idxTupFetch]] */
  idxTupFetch: Option[/* nullability unknown */ Long]
)

object PgStatUserIndexesViewRow {
  implicit lazy val decoder: Decoder[PgStatUserIndexesViewRow] = Decoder.forProduct8[PgStatUserIndexesViewRow, Option[PgClassId], Option[PgClassId], Option[String], Option[String], Option[String], Option[/* nullability unknown */ Long], Option[/* nullability unknown */ Long], Option[/* nullability unknown */ Long]]("relid", "indexrelid", "schemaname", "relname", "indexrelname", "idx_scan", "idx_tup_read", "idx_tup_fetch")(PgStatUserIndexesViewRow.apply)(Decoder.decodeOption(PgClassId.decoder), Decoder.decodeOption(PgClassId.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit lazy val encoder: Encoder[PgStatUserIndexesViewRow] = Encoder.forProduct8[PgStatUserIndexesViewRow, Option[PgClassId], Option[PgClassId], Option[String], Option[String], Option[String], Option[/* nullability unknown */ Long], Option[/* nullability unknown */ Long], Option[/* nullability unknown */ Long]]("relid", "indexrelid", "schemaname", "relname", "indexrelname", "idx_scan", "idx_tup_read", "idx_tup_fetch")(x => (x.relid, x.indexrelid, x.schemaname, x.relname, x.indexrelname, x.idxScan, x.idxTupRead, x.idxTupFetch))(Encoder.encodeOption(PgClassId.encoder), Encoder.encodeOption(PgClassId.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit lazy val read: Read[PgStatUserIndexesViewRow] = new Read[PgStatUserIndexesViewRow](
    gets = List(
      (PgClassId.get, Nullability.Nullable),
      (PgClassId.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatUserIndexesViewRow(
      relid = PgClassId.get.unsafeGetNullable(rs, i + 0),
      indexrelid = PgClassId.get.unsafeGetNullable(rs, i + 1),
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      relname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      indexrelname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      idxScan = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      idxTupRead = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6),
      idxTupFetch = Meta.LongMeta.get.unsafeGetNullable(rs, i + 7)
    )
  )
}
