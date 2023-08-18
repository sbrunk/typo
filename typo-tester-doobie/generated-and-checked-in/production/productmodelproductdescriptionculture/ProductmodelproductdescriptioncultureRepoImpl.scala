/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.culture.CultureId
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productmodel.ProductmodelId
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

object ProductmodelproductdescriptioncultureRepoImpl extends ProductmodelproductdescriptioncultureRepo {
  override def delete(compositeId: ProductmodelproductdescriptioncultureId): ConnectionIO[Boolean] = {
    sql"delete from production.productmodelproductdescriptionculture where productmodelid = ${fromWrite(compositeId.productmodelid)(Write.fromPut(ProductmodelId.put))} AND productdescriptionid = ${fromWrite(compositeId.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))} AND cultureid = ${fromWrite(compositeId.cultureid)(Write.fromPut(CultureId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    DeleteBuilder("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields)
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRow): ConnectionIO[ProductmodelproductdescriptioncultureRow] = {
    sql"""insert into production.productmodelproductdescriptionculture(productmodelid, productdescriptionid, cultureid, modifieddate)
          values (${fromWrite(unsaved.productmodelid)(Write.fromPut(ProductmodelId.put))}::int4, ${fromWrite(unsaved.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}::int4, ${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning productmodelid, productdescriptionid, cultureid, modifieddate::text
       """.query(ProductmodelproductdescriptioncultureRow.read).unique
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRowUnsaved): ConnectionIO[ProductmodelproductdescriptioncultureRow] = {
    val fs = List(
      Some((Fragment.const(s"productmodelid"), fr"${fromWrite(unsaved.productmodelid)(Write.fromPut(ProductmodelId.put))}::int4")),
      Some((Fragment.const(s"productdescriptionid"), fr"${fromWrite(unsaved.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}::int4")),
      Some((Fragment.const(s"cultureid"), fr"${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productmodelproductdescriptionculture default values
            returning productmodelid, productdescriptionid, cultureid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productmodelproductdescriptionculture(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productmodelid, productdescriptionid, cultureid, modifieddate::text
         """
    }
    q.query(ProductmodelproductdescriptioncultureRow.read).unique
    
  }
  override def select: SelectBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    SelectBuilderSql("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductmodelproductdescriptioncultureRow] = {
    sql"select productmodelid, productdescriptionid, cultureid, modifieddate::text from production.productmodelproductdescriptionculture".query(ProductmodelproductdescriptioncultureRow.read).stream
  }
  override def selectById(compositeId: ProductmodelproductdescriptioncultureId): ConnectionIO[Option[ProductmodelproductdescriptioncultureRow]] = {
    sql"select productmodelid, productdescriptionid, cultureid, modifieddate::text from production.productmodelproductdescriptionculture where productmodelid = ${fromWrite(compositeId.productmodelid)(Write.fromPut(ProductmodelId.put))} AND productdescriptionid = ${fromWrite(compositeId.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))} AND cultureid = ${fromWrite(compositeId.cultureid)(Write.fromPut(CultureId.put))}".query(ProductmodelproductdescriptioncultureRow.read).option
  }
  override def update(row: ProductmodelproductdescriptioncultureRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productmodelproductdescriptionculture
          set modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where productmodelid = ${fromWrite(compositeId.productmodelid)(Write.fromPut(ProductmodelId.put))} AND productdescriptionid = ${fromWrite(compositeId.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))} AND cultureid = ${fromWrite(compositeId.cultureid)(Write.fromPut(CultureId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    UpdateBuilder("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow.read)
  }
  override def upsert(unsaved: ProductmodelproductdescriptioncultureRow): ConnectionIO[ProductmodelproductdescriptioncultureRow] = {
    sql"""insert into production.productmodelproductdescriptionculture(productmodelid, productdescriptionid, cultureid, modifieddate)
          values (
            ${fromWrite(unsaved.productmodelid)(Write.fromPut(ProductmodelId.put))}::int4,
            ${fromWrite(unsaved.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}::int4,
            ${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (productmodelid, productdescriptionid, cultureid)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning productmodelid, productdescriptionid, cultureid, modifieddate::text
       """.query(ProductmodelproductdescriptioncultureRow.read).unique
  }
}
