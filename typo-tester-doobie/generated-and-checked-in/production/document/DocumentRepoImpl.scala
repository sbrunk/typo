/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object DocumentRepoImpl extends DocumentRepo {
  override def delete(documentnode: DocumentId): ConnectionIO[Boolean] = {
    sql"""delete from production."document" where documentnode = ${fromWrite(documentnode)(Write.fromPut(DocumentId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[DocumentFields, DocumentRow] = {
    DeleteBuilder("production.document", DocumentFields)
  }
  override def insert(unsaved: DocumentRow): ConnectionIO[DocumentRow] = {
    sql"""insert into production."document"(title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate, documentnode)
          values (${fromWrite(unsaved.title)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.owner)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.folderflag)(Write.fromPut(Flag.put))}::"public"."Flag", ${fromWrite(unsaved.filename)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.fileextension)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.revision)(Write.fromPut(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.changenumber)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.status)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.documentsummary)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.document)(Write.fromPutOption(Meta.ByteArrayMeta.put))}::bytea, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.documentnode)(Write.fromPut(DocumentId.put))})
          returning title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode
       """.query(DocumentRow.read).unique
  }
  override def insert(unsaved: DocumentRowUnsaved): ConnectionIO[DocumentRow] = {
    val fs = List(
      Some((Fragment.const(s"title"), fr"${fromWrite(unsaved.title)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""owner""""), fr"${fromWrite(unsaved.owner)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s"filename"), fr"${fromWrite(unsaved.filename)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"fileextension"), fr"${fromWrite(unsaved.fileextension)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"revision"), fr"${fromWrite(unsaved.revision)(Write.fromPut(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const(s"status"), fr"${fromWrite(unsaved.status)(Write.fromPut(Meta.IntMeta.put))}::int2")),
      Some((Fragment.const(s"documentsummary"), fr"${fromWrite(unsaved.documentsummary)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""document""""), fr"${fromWrite(unsaved.document)(Write.fromPutOption(Meta.ByteArrayMeta.put))}::bytea")),
      unsaved.folderflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"folderflag"), fr"""${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::"public"."Flag""""))
      },
      unsaved.changenumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"changenumber"), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${fromWrite(value: UUID)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      },
      unsaved.documentnode match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"documentnode"), fr"${fromWrite(value: DocumentId)(Write.fromPut(DocumentId.put))}"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production."document" default values
            returning title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production."document"(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode
         """
    }
    q.query(DocumentRow.read).unique
    
  }
  override def select: SelectBuilder[DocumentFields, DocumentRow] = {
    SelectBuilderSql("production.document", DocumentFields, DocumentRow.read)
  }
  override def selectAll: Stream[ConnectionIO, DocumentRow] = {
    sql"""select title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode from production."document"""".query(DocumentRow.read).stream
  }
  override def selectById(documentnode: DocumentId): ConnectionIO[Option[DocumentRow]] = {
    sql"""select title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode from production."document" where documentnode = ${fromWrite(documentnode)(Write.fromPut(DocumentId.put))}""".query(DocumentRow.read).option
  }
  override def selectByIds(documentnodes: Array[DocumentId]): Stream[ConnectionIO, DocumentRow] = {
    sql"""select title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode from production."document" where documentnode = ANY(${fromWrite(documentnodes)(Write.fromPut(DocumentId.arrayPut))})""".query(DocumentRow.read).stream
  }
  override def update(row: DocumentRow): ConnectionIO[Boolean] = {
    val documentnode = row.documentnode
    sql"""update production."document"
          set title = ${fromWrite(row.title)(Write.fromPut(Meta.StringMeta.put))},
              "owner" = ${fromWrite(row.owner)(Write.fromPut(BusinessentityId.put))}::int4,
              folderflag = ${fromWrite(row.folderflag)(Write.fromPut(Flag.put))}::"public"."Flag",
              filename = ${fromWrite(row.filename)(Write.fromPut(Meta.StringMeta.put))},
              fileextension = ${fromWrite(row.fileextension)(Write.fromPutOption(Meta.StringMeta.put))},
              revision = ${fromWrite(row.revision)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
              changenumber = ${fromWrite(row.changenumber)(Write.fromPut(Meta.IntMeta.put))}::int4,
              status = ${fromWrite(row.status)(Write.fromPut(Meta.IntMeta.put))}::int2,
              documentsummary = ${fromWrite(row.documentsummary)(Write.fromPutOption(Meta.StringMeta.put))},
              "document" = ${fromWrite(row.document)(Write.fromPutOption(Meta.ByteArrayMeta.put))}::bytea,
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where documentnode = ${fromWrite(documentnode)(Write.fromPut(DocumentId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[DocumentFields, DocumentRow] = {
    UpdateBuilder("production.document", DocumentFields, DocumentRow.read)
  }
  override def upsert(unsaved: DocumentRow): ConnectionIO[DocumentRow] = {
    sql"""insert into production."document"(title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate, documentnode)
          values (
            ${fromWrite(unsaved.title)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.owner)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.folderflag)(Write.fromPut(Flag.put))}::"public"."Flag",
            ${fromWrite(unsaved.filename)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.fileextension)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.revision)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.changenumber)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.status)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.documentsummary)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.document)(Write.fromPutOption(Meta.ByteArrayMeta.put))}::bytea,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.documentnode)(Write.fromPut(DocumentId.put))}
          )
          on conflict (documentnode)
          do update set
            title = EXCLUDED.title,
            "owner" = EXCLUDED."owner",
            folderflag = EXCLUDED.folderflag,
            filename = EXCLUDED.filename,
            fileextension = EXCLUDED.fileextension,
            revision = EXCLUDED.revision,
            changenumber = EXCLUDED.changenumber,
            status = EXCLUDED.status,
            documentsummary = EXCLUDED.documentsummary,
            "document" = EXCLUDED."document",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate::text, documentnode
       """.query(DocumentRow.read).unique
  }
}
