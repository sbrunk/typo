/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_database_conflicts

import adventureworks.pg_catalog.pg_database.PgDatabaseId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatDatabaseConflictsViewRow(
  /** Points to [[pg_database.PgDatabaseRow.oid]] */
  datid: PgDatabaseId,
  /** Points to [[pg_database.PgDatabaseRow.datname]] */
  datname: String,
  conflTablespace: /* nullability unknown */ Option[Long],
  conflLock: /* nullability unknown */ Option[Long],
  conflSnapshot: /* nullability unknown */ Option[Long],
  conflBufferpin: /* nullability unknown */ Option[Long],
  conflDeadlock: /* nullability unknown */ Option[Long]
)

object PgStatDatabaseConflictsViewRow {
  implicit lazy val decoder: Decoder[PgStatDatabaseConflictsViewRow] = Decoder.forProduct7[PgStatDatabaseConflictsViewRow, PgDatabaseId, String, /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long]]("datid", "datname", "confl_tablespace", "confl_lock", "confl_snapshot", "confl_bufferpin", "confl_deadlock")(PgStatDatabaseConflictsViewRow.apply)(PgDatabaseId.decoder, Decoder.decodeString, Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit lazy val encoder: Encoder[PgStatDatabaseConflictsViewRow] = Encoder.forProduct7[PgStatDatabaseConflictsViewRow, PgDatabaseId, String, /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long]]("datid", "datname", "confl_tablespace", "confl_lock", "confl_snapshot", "confl_bufferpin", "confl_deadlock")(x => (x.datid, x.datname, x.conflTablespace, x.conflLock, x.conflSnapshot, x.conflBufferpin, x.conflDeadlock))(PgDatabaseId.encoder, Encoder.encodeString, Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit lazy val read: Read[PgStatDatabaseConflictsViewRow] = new Read[PgStatDatabaseConflictsViewRow](
    gets = List(
      (PgDatabaseId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatDatabaseConflictsViewRow(
      datid = PgDatabaseId.get.unsafeGetNonNullable(rs, i + 0),
      datname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      conflTablespace = Meta.LongMeta.get.unsafeGetNullable(rs, i + 2),
      conflLock = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      conflSnapshot = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4),
      conflBufferpin = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      conflDeadlock = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
