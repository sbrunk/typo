/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_replication

import adventureworks.customtypes.TypoInet
import adventureworks.customtypes.TypoInstant
import adventureworks.customtypes.TypoInterval
import adventureworks.customtypes.TypoXid
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatReplicationViewRow(
  pid: /* nullability unknown */ Option[Int],
  usesysid: /* nullability unknown */ Option[/* oid */ Long],
  /** Points to [[pg_authid.PgAuthidRow.rolname]] */
  usename: Option[String],
  applicationName: /* nullability unknown */ Option[String],
  clientAddr: /* nullability unknown */ Option[TypoInet],
  clientHostname: /* nullability unknown */ Option[String],
  clientPort: /* nullability unknown */ Option[Int],
  backendStart: /* nullability unknown */ Option[TypoInstant],
  backendXmin: /* nullability unknown */ Option[TypoXid],
  state: /* nullability unknown */ Option[String],
  sentLsn: /* nullability unknown */ Option[/* pg_lsn */ Long],
  writeLsn: /* nullability unknown */ Option[/* pg_lsn */ Long],
  flushLsn: /* nullability unknown */ Option[/* pg_lsn */ Long],
  replayLsn: /* nullability unknown */ Option[/* pg_lsn */ Long],
  writeLag: /* nullability unknown */ Option[TypoInterval],
  flushLag: /* nullability unknown */ Option[TypoInterval],
  replayLag: /* nullability unknown */ Option[TypoInterval],
  syncPriority: /* nullability unknown */ Option[Int],
  syncState: /* nullability unknown */ Option[String],
  replyTime: /* nullability unknown */ Option[TypoInstant]
)

object PgStatReplicationViewRow {
  implicit lazy val decoder: Decoder[PgStatReplicationViewRow] = Decoder.forProduct20[PgStatReplicationViewRow, /* nullability unknown */ Option[Int], /* nullability unknown */ Option[/* oid */ Long], Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[TypoInet], /* nullability unknown */ Option[String], /* nullability unknown */ Option[Int], /* nullability unknown */ Option[TypoInstant], /* nullability unknown */ Option[TypoXid], /* nullability unknown */ Option[String], /* nullability unknown */ Option[/* pg_lsn */ Long], /* nullability unknown */ Option[/* pg_lsn */ Long], /* nullability unknown */ Option[/* pg_lsn */ Long], /* nullability unknown */ Option[/* pg_lsn */ Long], /* nullability unknown */ Option[TypoInterval], /* nullability unknown */ Option[TypoInterval], /* nullability unknown */ Option[TypoInterval], /* nullability unknown */ Option[Int], /* nullability unknown */ Option[String], /* nullability unknown */ Option[TypoInstant]]("pid", "usesysid", "usename", "application_name", "client_addr", "client_hostname", "client_port", "backend_start", "backend_xmin", "state", "sent_lsn", "write_lsn", "flush_lsn", "replay_lsn", "write_lag", "flush_lag", "replay_lag", "sync_priority", "sync_state", "reply_time")(PgStatReplicationViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoInet.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(TypoInstant.decoder), Decoder.decodeOption(TypoXid.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(TypoInterval.decoder), Decoder.decodeOption(TypoInterval.decoder), Decoder.decodeOption(TypoInterval.decoder), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoInstant.decoder))
  implicit lazy val encoder: Encoder[PgStatReplicationViewRow] = Encoder.forProduct20[PgStatReplicationViewRow, /* nullability unknown */ Option[Int], /* nullability unknown */ Option[/* oid */ Long], Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[TypoInet], /* nullability unknown */ Option[String], /* nullability unknown */ Option[Int], /* nullability unknown */ Option[TypoInstant], /* nullability unknown */ Option[TypoXid], /* nullability unknown */ Option[String], /* nullability unknown */ Option[/* pg_lsn */ Long], /* nullability unknown */ Option[/* pg_lsn */ Long], /* nullability unknown */ Option[/* pg_lsn */ Long], /* nullability unknown */ Option[/* pg_lsn */ Long], /* nullability unknown */ Option[TypoInterval], /* nullability unknown */ Option[TypoInterval], /* nullability unknown */ Option[TypoInterval], /* nullability unknown */ Option[Int], /* nullability unknown */ Option[String], /* nullability unknown */ Option[TypoInstant]]("pid", "usesysid", "usename", "application_name", "client_addr", "client_hostname", "client_port", "backend_start", "backend_xmin", "state", "sent_lsn", "write_lsn", "flush_lsn", "replay_lsn", "write_lag", "flush_lag", "replay_lag", "sync_priority", "sync_state", "reply_time")(x => (x.pid, x.usesysid, x.usename, x.applicationName, x.clientAddr, x.clientHostname, x.clientPort, x.backendStart, x.backendXmin, x.state, x.sentLsn, x.writeLsn, x.flushLsn, x.replayLsn, x.writeLag, x.flushLag, x.replayLag, x.syncPriority, x.syncState, x.replyTime))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoInet.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(TypoInstant.encoder), Encoder.encodeOption(TypoXid.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(TypoInterval.encoder), Encoder.encodeOption(TypoInterval.encoder), Encoder.encodeOption(TypoInterval.encoder), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoInstant.encoder))
  implicit lazy val read: Read[PgStatReplicationViewRow] = new Read[PgStatReplicationViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoInet.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (TypoInstant.get, Nullability.Nullable),
      (TypoXid.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (TypoInterval.get, Nullability.Nullable),
      (TypoInterval.get, Nullability.Nullable),
      (TypoInterval.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoInstant.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatReplicationViewRow(
      pid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      usesysid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 1),
      usename = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      applicationName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      clientAddr = TypoInet.get.unsafeGetNullable(rs, i + 4),
      clientHostname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      clientPort = Meta.IntMeta.get.unsafeGetNullable(rs, i + 6),
      backendStart = TypoInstant.get.unsafeGetNullable(rs, i + 7),
      backendXmin = TypoXid.get.unsafeGetNullable(rs, i + 8),
      state = Meta.StringMeta.get.unsafeGetNullable(rs, i + 9),
      sentLsn = Meta.LongMeta.get.unsafeGetNullable(rs, i + 10),
      writeLsn = Meta.LongMeta.get.unsafeGetNullable(rs, i + 11),
      flushLsn = Meta.LongMeta.get.unsafeGetNullable(rs, i + 12),
      replayLsn = Meta.LongMeta.get.unsafeGetNullable(rs, i + 13),
      writeLag = TypoInterval.get.unsafeGetNullable(rs, i + 14),
      flushLag = TypoInterval.get.unsafeGetNullable(rs, i + 15),
      replayLag = TypoInterval.get.unsafeGetNullable(rs, i + 16),
      syncPriority = Meta.IntMeta.get.unsafeGetNullable(rs, i + 17),
      syncState = Meta.StringMeta.get.unsafeGetNullable(rs, i + 18),
      replyTime = TypoInstant.get.unsafeGetNullable(rs, i + 19)
    )
  )
}
