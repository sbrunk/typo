/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_conversion

import anorm.SqlStringInterpolation
import java.sql.Connection

object PgConversionRepoImpl extends PgConversionRepo {
  override def delete(oid: PgConversionId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_conversion where oid = $oid".executeUpdate() > 0
  }
  override def insert(unsaved: PgConversionRow)(implicit c: Connection): PgConversionRow = {
    SQL"""insert into pg_catalog.pg_conversion(oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault)
          values (${unsaved.oid}::oid, ${unsaved.conname}::name, ${unsaved.connamespace}::oid, ${unsaved.conowner}::oid, ${unsaved.conforencoding}::int4, ${unsaved.contoencoding}::int4, ${unsaved.conproc}::regproc, ${unsaved.condefault})
          returning oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault
       """
      .executeInsert(PgConversionRow.rowParser(1).single)
    
  }
  override def selectAll(implicit c: Connection): List[PgConversionRow] = {
    SQL"""select oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault
          from pg_catalog.pg_conversion
       """.as(PgConversionRow.rowParser(1).*)
  }
  override def selectById(oid: PgConversionId)(implicit c: Connection): Option[PgConversionRow] = {
    SQL"""select oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault
          from pg_catalog.pg_conversion
          where oid = $oid
       """.as(PgConversionRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgConversionId])(implicit c: Connection): List[PgConversionRow] = {
    SQL"""select oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault
          from pg_catalog.pg_conversion
          where oid = ANY($oids)
       """.as(PgConversionRow.rowParser(1).*)
    
  }
  override def update(row: PgConversionRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_conversion
          set conname = ${row.conname}::name,
              connamespace = ${row.connamespace}::oid,
              conowner = ${row.conowner}::oid,
              conforencoding = ${row.conforencoding}::int4,
              contoencoding = ${row.contoencoding}::int4,
              conproc = ${row.conproc}::regproc,
              condefault = ${row.condefault}
          where oid = $oid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: PgConversionRow)(implicit c: Connection): PgConversionRow = {
    SQL"""insert into pg_catalog.pg_conversion(oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.conname}::name,
            ${unsaved.connamespace}::oid,
            ${unsaved.conowner}::oid,
            ${unsaved.conforencoding}::int4,
            ${unsaved.contoencoding}::int4,
            ${unsaved.conproc}::regproc,
            ${unsaved.condefault}
          )
          on conflict (oid)
          do update set
            conname = EXCLUDED.conname,
            connamespace = EXCLUDED.connamespace,
            conowner = EXCLUDED.conowner,
            conforencoding = EXCLUDED.conforencoding,
            contoencoding = EXCLUDED.contoencoding,
            conproc = EXCLUDED.conproc,
            condefault = EXCLUDED.condefault
          returning oid, conname, connamespace, conowner, conforencoding, contoencoding, conproc, condefault
       """
      .executeInsert(PgConversionRow.rowParser(1).single)
    
  }
}
