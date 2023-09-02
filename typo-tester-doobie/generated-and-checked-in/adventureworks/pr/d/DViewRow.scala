/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package d

import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.document.DocumentId
import adventureworks.public.Flag
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class DViewRow(
  /** Points to [[production.document.DocumentRow.title]] */
  title: /* max 50 chars */ String,
  /** Points to [[production.document.DocumentRow.owner]] */
  owner: BusinessentityId,
  /** Points to [[production.document.DocumentRow.folderflag]] */
  folderflag: Flag,
  /** Points to [[production.document.DocumentRow.filename]] */
  filename: /* max 400 chars */ String,
  /** Points to [[production.document.DocumentRow.fileextension]] */
  fileextension: Option[/* max 8 chars */ String],
  /** Points to [[production.document.DocumentRow.revision]] */
  revision: /* bpchar, max 5 chars */ String,
  /** Points to [[production.document.DocumentRow.changenumber]] */
  changenumber: Int,
  /** Points to [[production.document.DocumentRow.status]] */
  status: TypoShort,
  /** Points to [[production.document.DocumentRow.documentsummary]] */
  documentsummary: Option[String],
  /** Points to [[production.document.DocumentRow.document]] */
  document: Option[TypoBytea],
  /** Points to [[production.document.DocumentRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[production.document.DocumentRow.modifieddate]] */
  modifieddate: TypoLocalDateTime,
  /** Points to [[production.document.DocumentRow.documentnode]] */
  documentnode: DocumentId
)

object DViewRow {
  implicit lazy val decoder: Decoder[DViewRow] = Decoder.forProduct13[DViewRow, /* max 50 chars */ String, BusinessentityId, Flag, /* max 400 chars */ String, Option[/* max 8 chars */ String], /* bpchar, max 5 chars */ String, Int, TypoShort, Option[String], Option[TypoBytea], UUID, TypoLocalDateTime, DocumentId]("title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate", "documentnode")(DViewRow.apply)(Decoder.decodeString, BusinessentityId.decoder, Flag.decoder, Decoder.decodeString, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, Decoder.decodeInt, TypoShort.decoder, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoBytea.decoder), Decoder.decodeUUID, TypoLocalDateTime.decoder, DocumentId.decoder)
  implicit lazy val encoder: Encoder[DViewRow] = Encoder.forProduct13[DViewRow, /* max 50 chars */ String, BusinessentityId, Flag, /* max 400 chars */ String, Option[/* max 8 chars */ String], /* bpchar, max 5 chars */ String, Int, TypoShort, Option[String], Option[TypoBytea], UUID, TypoLocalDateTime, DocumentId]("title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate", "documentnode")(x => (x.title, x.owner, x.folderflag, x.filename, x.fileextension, x.revision, x.changenumber, x.status, x.documentsummary, x.document, x.rowguid, x.modifieddate, x.documentnode))(Encoder.encodeString, BusinessentityId.encoder, Flag.encoder, Encoder.encodeString, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, Encoder.encodeInt, TypoShort.encoder, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoBytea.encoder), Encoder.encodeUUID, TypoLocalDateTime.encoder, DocumentId.encoder)
  implicit lazy val read: Read[DViewRow] = new Read[DViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (Flag.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoBytea.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (DocumentId.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => DViewRow(
      title = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 0),
      owner = BusinessentityId.get.unsafeGetNonNullable(rs, i + 1),
      folderflag = Flag.get.unsafeGetNonNullable(rs, i + 2),
      filename = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      fileextension = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      revision = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 5),
      changenumber = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 6),
      status = TypoShort.get.unsafeGetNonNullable(rs, i + 7),
      documentsummary = Meta.StringMeta.get.unsafeGetNullable(rs, i + 8),
      document = TypoBytea.get.unsafeGetNullable(rs, i + 9),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 10),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 11),
      documentnode = DocumentId.get.unsafeGetNonNullable(rs, i + 12)
    )
  )
}
