/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import java.util.UUID

object PasswordRepoImpl extends PasswordRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"""delete from person."password" where businessentityid = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".update.run.map(_ > 0)
  }
  override def insert(unsaved: PasswordRow): ConnectionIO[PasswordRow] = {
    sql"""insert into person."password"(businessentityid, passwordhash, passwordsalt, rowguid, modifieddate)
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.passwordhash)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.passwordsalt)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning businessentityid, passwordhash, passwordsalt, rowguid, modifieddate::text
       """.query(PasswordRow.read).unique
  }
  override def insert(unsaved: PasswordRowUnsaved): ConnectionIO[PasswordRow] = {
    val fs = List(
      Some((Fragment.const(s"businessentityid"), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s"passwordhash"), fr"${fromWrite(unsaved.passwordhash)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"passwordsalt"), fr"${fromWrite(unsaved.passwordsalt)(Write.fromPut(Meta.StringMeta.put))}")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${fromWrite(value: UUID)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person."password" default values
            returning businessentityid, passwordhash, passwordsalt, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person."password"(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, passwordhash, passwordsalt, rowguid, modifieddate::text
         """
    }
    q.query(PasswordRow.read).unique
    
  }
  override def selectAll: Stream[ConnectionIO, PasswordRow] = {
    sql"""select businessentityid, passwordhash, passwordsalt, rowguid, modifieddate::text from person."password"""".query(PasswordRow.read).stream
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[PasswordRow]] = {
    sql"""select businessentityid, passwordhash, passwordsalt, rowguid, modifieddate::text from person."password" where businessentityid = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".query(PasswordRow.read).option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, PasswordRow] = {
    sql"""select businessentityid, passwordhash, passwordsalt, rowguid, modifieddate::text from person."password" where businessentityid = ANY(${fromWrite(businessentityids)(Write.fromPut(BusinessentityId.arrayPut))})""".query(PasswordRow.read).stream
  }
  override def update(row: PasswordRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update person."password"
          set passwordhash = ${fromWrite(row.passwordhash)(Write.fromPut(Meta.StringMeta.put))},
              passwordsalt = ${fromWrite(row.passwordsalt)(Write.fromPut(Meta.StringMeta.put))},
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where businessentityid = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PasswordRow): ConnectionIO[PasswordRow] = {
    sql"""insert into person."password"(businessentityid, passwordhash, passwordsalt, rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.passwordhash)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.passwordsalt)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (businessentityid)
          do update set
            passwordhash = EXCLUDED.passwordhash,
            passwordsalt = EXCLUDED.passwordsalt,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, passwordhash, passwordsalt, rowguid, modifieddate::text
       """.query(PasswordRow.read).unique
  }
}
