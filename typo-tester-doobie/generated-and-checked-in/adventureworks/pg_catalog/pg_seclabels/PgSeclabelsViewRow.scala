/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_seclabels

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgSeclabelsViewRow(
  objoid: /* nullability unknown */ Option[/* oid */ Long],
  classoid: /* nullability unknown */ Option[/* oid */ Long],
  objsubid: /* nullability unknown */ Option[Int],
  objtype: /* nullability unknown */ Option[String],
  objnamespace: /* nullability unknown */ Option[/* oid */ Long],
  objname: /* nullability unknown */ Option[String],
  provider: /* nullability unknown */ Option[String],
  label: /* nullability unknown */ Option[String]
)

object PgSeclabelsViewRow {
  implicit lazy val decoder: Decoder[PgSeclabelsViewRow] = Decoder.forProduct8[PgSeclabelsViewRow, /* nullability unknown */ Option[/* oid */ Long], /* nullability unknown */ Option[/* oid */ Long], /* nullability unknown */ Option[Int], /* nullability unknown */ Option[String], /* nullability unknown */ Option[/* oid */ Long], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String]]("objoid", "classoid", "objsubid", "objtype", "objnamespace", "objname", "provider", "label")(PgSeclabelsViewRow.apply)(Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[PgSeclabelsViewRow] = Encoder.forProduct8[PgSeclabelsViewRow, /* nullability unknown */ Option[/* oid */ Long], /* nullability unknown */ Option[/* oid */ Long], /* nullability unknown */ Option[Int], /* nullability unknown */ Option[String], /* nullability unknown */ Option[/* oid */ Long], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String]]("objoid", "classoid", "objsubid", "objtype", "objnamespace", "objname", "provider", "label")(x => (x.objoid, x.classoid, x.objsubid, x.objtype, x.objnamespace, x.objname, x.provider, x.label))(Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[PgSeclabelsViewRow] = new Read[PgSeclabelsViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgSeclabelsViewRow(
      objoid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 0),
      classoid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 1),
      objsubid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 2),
      objtype = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      objnamespace = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4),
      objname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      provider = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      label = Meta.StringMeta.get.unsafeGetNullable(rs, i + 7)
    )
  )
}
