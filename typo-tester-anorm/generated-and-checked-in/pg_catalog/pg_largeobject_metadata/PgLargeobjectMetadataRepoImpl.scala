/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject_metadata

import anorm.SqlStringInterpolation
import java.sql.Connection

object PgLargeobjectMetadataRepoImpl extends PgLargeobjectMetadataRepo {
  override def delete(oid: PgLargeobjectMetadataId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_largeobject_metadata where oid = $oid".executeUpdate() > 0
  }
  override def insert(unsaved: PgLargeobjectMetadataRow)(implicit c: Connection): PgLargeobjectMetadataRow = {
    SQL"""insert into pg_catalog.pg_largeobject_metadata(oid, lomowner, lomacl)
          values (${unsaved.oid}::oid, ${unsaved.lomowner}::oid, ${unsaved.lomacl}::_aclitem)
          returning oid, lomowner, lomacl
       """
      .executeInsert(PgLargeobjectMetadataRow.rowParser(1).single)
    
  }
  override def selectAll(implicit c: Connection): List[PgLargeobjectMetadataRow] = {
    SQL"""select oid, lomowner, lomacl
          from pg_catalog.pg_largeobject_metadata
       """.as(PgLargeobjectMetadataRow.rowParser(1).*)
  }
  override def selectById(oid: PgLargeobjectMetadataId)(implicit c: Connection): Option[PgLargeobjectMetadataRow] = {
    SQL"""select oid, lomowner, lomacl
          from pg_catalog.pg_largeobject_metadata
          where oid = $oid
       """.as(PgLargeobjectMetadataRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgLargeobjectMetadataId])(implicit c: Connection): List[PgLargeobjectMetadataRow] = {
    SQL"""select oid, lomowner, lomacl
          from pg_catalog.pg_largeobject_metadata
          where oid = ANY($oids)
       """.as(PgLargeobjectMetadataRow.rowParser(1).*)
    
  }
  override def update(row: PgLargeobjectMetadataRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_largeobject_metadata
          set lomowner = ${row.lomowner}::oid,
              lomacl = ${row.lomacl}::_aclitem
          where oid = $oid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: PgLargeobjectMetadataRow)(implicit c: Connection): PgLargeobjectMetadataRow = {
    SQL"""insert into pg_catalog.pg_largeobject_metadata(oid, lomowner, lomacl)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.lomowner}::oid,
            ${unsaved.lomacl}::_aclitem
          )
          on conflict (oid)
          do update set
            lomowner = EXCLUDED.lomowner,
            lomacl = EXCLUDED.lomacl
          returning oid, lomowner, lomacl
       """
      .executeInsert(PgLargeobjectMetadataRow.rowParser(1).single)
    
  }
}
