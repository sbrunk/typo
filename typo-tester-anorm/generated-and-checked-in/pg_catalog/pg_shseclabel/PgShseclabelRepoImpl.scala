/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shseclabel

import anorm.SqlStringInterpolation
import java.sql.Connection

object PgShseclabelRepoImpl extends PgShseclabelRepo {
  override def delete(compositeId: PgShseclabelId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_shseclabel where objoid = ${compositeId.objoid} AND classoid = ${compositeId.classoid} AND provider = ${compositeId.provider}".executeUpdate() > 0
  }
  override def insert(unsaved: PgShseclabelRow)(implicit c: Connection): PgShseclabelRow = {
    SQL"""insert into pg_catalog.pg_shseclabel(objoid, classoid, provider, "label")
          values (${unsaved.objoid}::oid, ${unsaved.classoid}::oid, ${unsaved.provider}, ${unsaved.label})
          returning objoid, classoid, provider, "label"
       """
      .executeInsert(PgShseclabelRow.rowParser(1).single)
    
  }
  override def selectAll(implicit c: Connection): List[PgShseclabelRow] = {
    SQL"""select objoid, classoid, provider, "label"
          from pg_catalog.pg_shseclabel
       """.as(PgShseclabelRow.rowParser(1).*)
  }
  override def selectById(compositeId: PgShseclabelId)(implicit c: Connection): Option[PgShseclabelRow] = {
    SQL"""select objoid, classoid, provider, "label"
          from pg_catalog.pg_shseclabel
          where objoid = ${compositeId.objoid} AND classoid = ${compositeId.classoid} AND provider = ${compositeId.provider}
       """.as(PgShseclabelRow.rowParser(1).singleOpt)
  }
  override def update(row: PgShseclabelRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update pg_catalog.pg_shseclabel
          set "label" = ${row.label}
          where objoid = ${compositeId.objoid} AND classoid = ${compositeId.classoid} AND provider = ${compositeId.provider}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: PgShseclabelRow)(implicit c: Connection): PgShseclabelRow = {
    SQL"""insert into pg_catalog.pg_shseclabel(objoid, classoid, provider, "label")
          values (
            ${unsaved.objoid}::oid,
            ${unsaved.classoid}::oid,
            ${unsaved.provider},
            ${unsaved.label}
          )
          on conflict (objoid, classoid, provider)
          do update set
            "label" = EXCLUDED."label"
          returning objoid, classoid, provider, "label"
       """
      .executeInsert(PgShseclabelRow.rowParser(1).single)
    
  }
}
