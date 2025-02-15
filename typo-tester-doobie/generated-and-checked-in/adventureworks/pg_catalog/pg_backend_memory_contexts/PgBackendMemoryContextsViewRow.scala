/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_backend_memory_contexts

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgBackendMemoryContextsViewRow(
  name: /* nullability unknown */ Option[String],
  ident: /* nullability unknown */ Option[String],
  parent: /* nullability unknown */ Option[String],
  level: /* nullability unknown */ Option[Int],
  totalBytes: /* nullability unknown */ Option[Long],
  totalNblocks: /* nullability unknown */ Option[Long],
  freeBytes: /* nullability unknown */ Option[Long],
  freeChunks: /* nullability unknown */ Option[Long],
  usedBytes: /* nullability unknown */ Option[Long]
)

object PgBackendMemoryContextsViewRow {
  implicit lazy val decoder: Decoder[PgBackendMemoryContextsViewRow] = Decoder.forProduct9[PgBackendMemoryContextsViewRow, /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[Int], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long]]("name", "ident", "parent", "level", "total_bytes", "total_nblocks", "free_bytes", "free_chunks", "used_bytes")(PgBackendMemoryContextsViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit lazy val encoder: Encoder[PgBackendMemoryContextsViewRow] = Encoder.forProduct9[PgBackendMemoryContextsViewRow, /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[Int], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long], /* nullability unknown */ Option[Long]]("name", "ident", "parent", "level", "total_bytes", "total_nblocks", "free_bytes", "free_chunks", "used_bytes")(x => (x.name, x.ident, x.parent, x.level, x.totalBytes, x.totalNblocks, x.freeBytes, x.freeChunks, x.usedBytes))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit lazy val read: Read[PgBackendMemoryContextsViewRow] = new Read[PgBackendMemoryContextsViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgBackendMemoryContextsViewRow(
      name = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      ident = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      parent = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      level = Meta.IntMeta.get.unsafeGetNullable(rs, i + 3),
      totalBytes = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4),
      totalNblocks = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      freeBytes = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6),
      freeChunks = Meta.LongMeta.get.unsafeGetNullable(rs, i + 7),
      usedBytes = Meta.LongMeta.get.unsafeGetNullable(rs, i + 8)
    )
  )
}
