/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_vacuum

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatProgressVacuumViewRow(
  pid: /* nullability unknown */ Option[Int],
  datid: /* nullability unknown */ Option[/* oid */ Long],
  /** Points to [[pg_database.PgDatabaseRow.datname]] */
  datname: Option[String],
  relid: /* nullability unknown */ Option[/* oid */ Long],
  phase: /* nullability unknown */ Option[String],
  heapBlksTotal: /* nullability unknown */ Option[Long],
  heapBlksScanned: /* nullability unknown */ Option[Long],
  heapBlksVacuumed: /* nullability unknown */ Option[Long],
  indexVacuumCount: /* nullability unknown */ Option[Long],
  maxDeadTuples: /* nullability unknown */ Option[Long],
  numDeadTuples: /* nullability unknown */ Option[Long]
)

object PgStatProgressVacuumViewRow {
  implicit lazy val decoder: Decoder[PgStatProgressVacuumViewRow] = Decoder.forProduct11[PgStatProgressVacuumViewRow, /* nullability unknown */ Option[Int], /* nullability unknown */ Option[/* oid */ Long], Option[String], /* nullability unknown */ Option[/* oid */ Long], /* nullability unknown */ Option[String], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long]]("pid", "datid", "datname", "relid", "phase", "heap_blks_total", "heap_blks_scanned", "heap_blks_vacuumed", "index_vacuum_count", "max_dead_tuples", "num_dead_tuples")(PgStatProgressVacuumViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit lazy val encoder: Encoder[PgStatProgressVacuumViewRow] = Encoder.forProduct11[PgStatProgressVacuumViewRow, /* nullability unknown */ Option[Int], /* nullability unknown */ Option[/* oid */ Long], Option[String], /* nullability unknown */ Option[/* oid */ Long], /* nullability unknown */ Option[String], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long]]("pid", "datid", "datname", "relid", "phase", "heap_blks_total", "heap_blks_scanned", "heap_blks_vacuumed", "index_vacuum_count", "max_dead_tuples", "num_dead_tuples")(x => (x.pid, x.datid, x.datname, x.relid, x.phase, x.heapBlksTotal, x.heapBlksScanned, x.heapBlksVacuumed, x.indexVacuumCount, x.maxDeadTuples, x.numDeadTuples))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit lazy val read: Read[PgStatProgressVacuumViewRow] = new Read[PgStatProgressVacuumViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatProgressVacuumViewRow(
      pid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      datid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 1),
      datname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      relid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      phase = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      heapBlksTotal = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      heapBlksScanned = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6),
      heapBlksVacuumed = Meta.LongMeta.get.unsafeGetNullable(rs, i + 7),
      indexVacuumCount = Meta.LongMeta.get.unsafeGetNullable(rs, i + 8),
      maxDeadTuples = Meta.LongMeta.get.unsafeGetNullable(rs, i + 9),
      numDeadTuples = Meta.LongMeta.get.unsafeGetNullable(rs, i + 10)
    )
  )
}
