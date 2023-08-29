/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Name
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

object SalestaxrateRepoImpl extends SalestaxrateRepo {
  override def delete(salestaxrateid: SalestaxrateId): ConnectionIO[Boolean] = {
    sql"""delete from sales.salestaxrate where "salestaxrateid" = ${fromWrite(salestaxrateid)(Write.fromPut(SalestaxrateId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[SalestaxrateFields, SalestaxrateRow] = {
    DeleteBuilder("sales.salestaxrate", SalestaxrateFields)
  }
  override def insert(unsaved: SalestaxrateRow): ConnectionIO[SalestaxrateRow] = {
    sql"""insert into sales.salestaxrate("salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.salestaxrateid)(Write.fromPut(SalestaxrateId.put))}::int4, ${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4, ${fromWrite(unsaved.taxtype)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.taxrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
       """.query(SalestaxrateRow.read).unique
  }
  override def insert(unsaved: SalestaxrateRowUnsaved): ConnectionIO[SalestaxrateRow] = {
    val fs = List(
      Some((Fragment.const(s""""stateprovinceid""""), fr"${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4")),
      Some((Fragment.const(s""""taxtype""""), fr"${fromWrite(unsaved.taxtype)(Write.fromPut(TypoShort.put))}::int2")),
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      unsaved.salestaxrateid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""salestaxrateid""""), fr"${fromWrite(value: SalestaxrateId)(Write.fromPut(SalestaxrateId.put))}::int4"))
      },
      unsaved.taxrate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""taxrate""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""rowguid""""), fr"${fromWrite(value: UUID)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.salestaxrate default values
            returning "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.salestaxrate(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
         """
    }
    q.query(SalestaxrateRow.read).unique
    
  }
  override def select: SelectBuilder[SalestaxrateFields, SalestaxrateRow] = {
    SelectBuilderSql("sales.salestaxrate", SalestaxrateFields, SalestaxrateRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SalestaxrateRow] = {
    sql"""select "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text from sales.salestaxrate""".query(SalestaxrateRow.read).stream
  }
  override def selectById(salestaxrateid: SalestaxrateId): ConnectionIO[Option[SalestaxrateRow]] = {
    sql"""select "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text from sales.salestaxrate where "salestaxrateid" = ${fromWrite(salestaxrateid)(Write.fromPut(SalestaxrateId.put))}""".query(SalestaxrateRow.read).option
  }
  override def selectByIds(salestaxrateids: Array[SalestaxrateId]): Stream[ConnectionIO, SalestaxrateRow] = {
    sql"""select "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text from sales.salestaxrate where "salestaxrateid" = ANY(${salestaxrateids})""".query(SalestaxrateRow.read).stream
  }
  override def update(row: SalestaxrateRow): ConnectionIO[Boolean] = {
    val salestaxrateid = row.salestaxrateid
    sql"""update sales.salestaxrate
          set "stateprovinceid" = ${fromWrite(row.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4,
              "taxtype" = ${fromWrite(row.taxtype)(Write.fromPut(TypoShort.put))}::int2,
              "taxrate" = ${fromWrite(row.taxrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "salestaxrateid" = ${fromWrite(salestaxrateid)(Write.fromPut(SalestaxrateId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[SalestaxrateFields, SalestaxrateRow] = {
    UpdateBuilder("sales.salestaxrate", SalestaxrateFields, SalestaxrateRow.read)
  }
  override def upsert(unsaved: SalestaxrateRow): ConnectionIO[SalestaxrateRow] = {
    sql"""insert into sales.salestaxrate("salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.salestaxrateid)(Write.fromPut(SalestaxrateId.put))}::int4,
            ${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4,
            ${fromWrite(unsaved.taxtype)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.taxrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("salestaxrateid")
          do update set
            "stateprovinceid" = EXCLUDED."stateprovinceid",
            "taxtype" = EXCLUDED."taxtype",
            "taxrate" = EXCLUDED."taxrate",
            "name" = EXCLUDED."name",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
       """.query(SalestaxrateRow.read).unique
  }
}
