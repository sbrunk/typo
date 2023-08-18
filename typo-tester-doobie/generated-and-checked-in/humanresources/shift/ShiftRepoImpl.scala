/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.TypoLocalTime
import adventureworks.public.Name
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object ShiftRepoImpl extends ShiftRepo {
  override def delete(shiftid: ShiftId): ConnectionIO[Boolean] = {
    sql"delete from humanresources.shift where shiftid = ${fromWrite(shiftid)(Write.fromPut(ShiftId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ShiftFields, ShiftRow] = {
    DeleteBuilder("humanresources.shift", ShiftFields)
  }
  override def insert(unsaved: ShiftRow): ConnectionIO[ShiftRow] = {
    sql"""insert into humanresources.shift(shiftid, "name", starttime, endtime, modifieddate)
          values (${fromWrite(unsaved.shiftid)(Write.fromPut(ShiftId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name", ${fromWrite(unsaved.starttime)(Write.fromPut(TypoLocalTime.put))}::time, ${fromWrite(unsaved.endtime)(Write.fromPut(TypoLocalTime.put))}::time, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning shiftid, "name", starttime::text, endtime::text, modifieddate::text
       """.query(ShiftRow.read).unique
  }
  override def insert(unsaved: ShiftRowUnsaved): ConnectionIO[ShiftRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"""${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name"""")),
      Some((Fragment.const(s"starttime"), fr"${fromWrite(unsaved.starttime)(Write.fromPut(TypoLocalTime.put))}::time")),
      Some((Fragment.const(s"endtime"), fr"${fromWrite(unsaved.endtime)(Write.fromPut(TypoLocalTime.put))}::time")),
      unsaved.shiftid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"shiftid"), fr"${fromWrite(value: ShiftId)(Write.fromPut(ShiftId.put))}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.shift default values
            returning shiftid, "name", starttime::text, endtime::text, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into humanresources.shift(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning shiftid, "name", starttime::text, endtime::text, modifieddate::text
         """
    }
    q.query(ShiftRow.read).unique
    
  }
  override def select: SelectBuilder[ShiftFields, ShiftRow] = {
    SelectBuilderSql("humanresources.shift", ShiftFields, ShiftRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ShiftRow] = {
    sql"""select shiftid, "name", starttime::text, endtime::text, modifieddate::text from humanresources.shift""".query(ShiftRow.read).stream
  }
  override def selectById(shiftid: ShiftId): ConnectionIO[Option[ShiftRow]] = {
    sql"""select shiftid, "name", starttime::text, endtime::text, modifieddate::text from humanresources.shift where shiftid = ${fromWrite(shiftid)(Write.fromPut(ShiftId.put))}""".query(ShiftRow.read).option
  }
  override def selectByIds(shiftids: Array[ShiftId]): Stream[ConnectionIO, ShiftRow] = {
    sql"""select shiftid, "name", starttime::text, endtime::text, modifieddate::text from humanresources.shift where shiftid = ANY(${fromWrite(shiftids)(Write.fromPut(ShiftId.arrayPut))})""".query(ShiftRow.read).stream
  }
  override def update(row: ShiftRow): ConnectionIO[Boolean] = {
    val shiftid = row.shiftid
    sql"""update humanresources.shift
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::"public"."Name",
              starttime = ${fromWrite(row.starttime)(Write.fromPut(TypoLocalTime.put))}::time,
              endtime = ${fromWrite(row.endtime)(Write.fromPut(TypoLocalTime.put))}::time,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where shiftid = ${fromWrite(shiftid)(Write.fromPut(ShiftId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ShiftFields, ShiftRow] = {
    UpdateBuilder("humanresources.shift", ShiftFields, ShiftRow.read)
  }
  override def upsert(unsaved: ShiftRow): ConnectionIO[ShiftRow] = {
    sql"""insert into humanresources.shift(shiftid, "name", starttime, endtime, modifieddate)
          values (
            ${fromWrite(unsaved.shiftid)(Write.fromPut(ShiftId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name",
            ${fromWrite(unsaved.starttime)(Write.fromPut(TypoLocalTime.put))}::time,
            ${fromWrite(unsaved.endtime)(Write.fromPut(TypoLocalTime.put))}::time,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (shiftid)
          do update set
            "name" = EXCLUDED."name",
            starttime = EXCLUDED.starttime,
            endtime = EXCLUDED.endtime,
            modifieddate = EXCLUDED.modifieddate
          returning shiftid, "name", starttime::text, endtime::text, modifieddate::text
       """.query(ShiftRow.read).unique
  }
}
