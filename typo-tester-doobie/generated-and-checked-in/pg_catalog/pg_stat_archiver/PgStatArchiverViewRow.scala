/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_archiver

import adventureworks.TypoOffsetDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatArchiverViewRow(
  archivedCount: Option[Long],
  lastArchivedWal: Option[String],
  lastArchivedTime: Option[TypoOffsetDateTime],
  failedCount: Option[Long],
  lastFailedWal: Option[String],
  lastFailedTime: Option[TypoOffsetDateTime],
  statsReset: Option[TypoOffsetDateTime]
)

object PgStatArchiverViewRow {
  implicit lazy val decoder: Decoder[PgStatArchiverViewRow] = Decoder.forProduct7[PgStatArchiverViewRow, Option[Long], Option[String], Option[TypoOffsetDateTime], Option[Long], Option[String], Option[TypoOffsetDateTime], Option[TypoOffsetDateTime]]("archived_count", "last_archived_wal", "last_archived_time", "failed_count", "last_failed_wal", "last_failed_time", "stats_reset")(PgStatArchiverViewRow.apply)(Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoOffsetDateTime.decoder), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoOffsetDateTime.decoder), Decoder.decodeOption(TypoOffsetDateTime.decoder))
  implicit lazy val encoder: Encoder[PgStatArchiverViewRow] = Encoder.forProduct7[PgStatArchiverViewRow, Option[Long], Option[String], Option[TypoOffsetDateTime], Option[Long], Option[String], Option[TypoOffsetDateTime], Option[TypoOffsetDateTime]]("archived_count", "last_archived_wal", "last_archived_time", "failed_count", "last_failed_wal", "last_failed_time", "stats_reset")(x => (x.archivedCount, x.lastArchivedWal, x.lastArchivedTime, x.failedCount, x.lastFailedWal, x.lastFailedTime, x.statsReset))(Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoOffsetDateTime.encoder), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoOffsetDateTime.encoder), Encoder.encodeOption(TypoOffsetDateTime.encoder))
  implicit lazy val read: Read[PgStatArchiverViewRow] = new Read[PgStatArchiverViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatArchiverViewRow(
      archivedCount = Meta.LongMeta.get.unsafeGetNullable(rs, i + 0),
      lastArchivedWal = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      lastArchivedTime = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 2),
      failedCount = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      lastFailedWal = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      lastFailedTime = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 5),
      statsReset = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
