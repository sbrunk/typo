/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_init_privs

import adventureworks.TypoAclItem
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgInitPrivsRow(
  objoid: /* oid */ Long,
  classoid: /* oid */ Long,
  objsubid: Int,
  privtype: String,
  initprivs: Array[TypoAclItem]
){
   val compositeId: PgInitPrivsId = PgInitPrivsId(objoid, classoid, objsubid)
 }

object PgInitPrivsRow {
  implicit lazy val decoder: Decoder[PgInitPrivsRow] = Decoder.forProduct5[PgInitPrivsRow, /* oid */ Long, /* oid */ Long, Int, String, Array[TypoAclItem]]("objoid", "classoid", "objsubid", "privtype", "initprivs")(PgInitPrivsRow.apply)(Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeInt, Decoder.decodeString, Decoder.decodeArray[TypoAclItem](TypoAclItem.decoder, implicitly))
  implicit lazy val encoder: Encoder[PgInitPrivsRow] = Encoder.forProduct5[PgInitPrivsRow, /* oid */ Long, /* oid */ Long, Int, String, Array[TypoAclItem]]("objoid", "classoid", "objsubid", "privtype", "initprivs")(x => (x.objoid, x.classoid, x.objsubid, x.privtype, x.initprivs))(Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeInt, Encoder.encodeString, Encoder.encodeIterable[TypoAclItem, Array](TypoAclItem.encoder, implicitly))
  implicit lazy val read: Read[PgInitPrivsRow] = new Read[PgInitPrivsRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoAclItem.arrayGet, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgInitPrivsRow(
      objoid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 0),
      classoid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      objsubid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 2),
      privtype = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      initprivs = TypoAclItem.arrayGet.unsafeGetNonNullable(rs, i + 4)
    )
  )
}
