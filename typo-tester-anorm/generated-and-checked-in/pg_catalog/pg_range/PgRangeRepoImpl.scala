/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_range

import adventureworks.TypoRegproc
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgRangeRepoImpl extends PgRangeRepo {
  override def delete(rngtypid: PgRangeId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_range where rngtypid = ${ParameterValue(rngtypid, null, PgRangeId.toStatement)}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgRangeFields, PgRangeRow] = {
    DeleteBuilder("pg_catalog.pg_range", PgRangeFields)
  }
  override def insert(unsaved: PgRangeRow)(implicit c: Connection): PgRangeRow = {
    SQL"""insert into pg_catalog.pg_range(rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff)
          values (${ParameterValue(unsaved.rngtypid, null, PgRangeId.toStatement)}::oid, ${ParameterValue(unsaved.rngsubtype, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.rngmultitypid, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.rngcollation, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.rngsubopc, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.rngcanonical, null, TypoRegproc.toStatement)}::regproc, ${ParameterValue(unsaved.rngsubdiff, null, TypoRegproc.toStatement)}::regproc)
          returning rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff
       """
      .executeInsert(PgRangeRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgRangeFields, PgRangeRow] = {
    SelectBuilderSql("pg_catalog.pg_range", PgRangeFields, PgRangeRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgRangeRow] = {
    SQL"""select rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff
          from pg_catalog.pg_range
       """.as(PgRangeRow.rowParser(1).*)
  }
  override def selectById(rngtypid: PgRangeId)(implicit c: Connection): Option[PgRangeRow] = {
    SQL"""select rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff
          from pg_catalog.pg_range
          where rngtypid = ${ParameterValue(rngtypid, null, PgRangeId.toStatement)}
       """.as(PgRangeRow.rowParser(1).singleOpt)
  }
  override def selectByIds(rngtypids: Array[PgRangeId])(implicit c: Connection): List[PgRangeRow] = {
    SQL"""select rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff
          from pg_catalog.pg_range
          where rngtypid = ANY(${rngtypids})
       """.as(PgRangeRow.rowParser(1).*)
    
  }
  override def selectByUnique(rngmultitypid: /* oid */ Long)(implicit c: Connection): Option[PgRangeRow] = {
    SQL"""select rngmultitypid
          from pg_catalog.pg_range
          where rngmultitypid = ${ParameterValue(rngmultitypid, null, ToStatement.longToStatement)}
       """.as(PgRangeRow.rowParser(1).singleOpt)
    
  }
  override def update(row: PgRangeRow)(implicit c: Connection): Boolean = {
    val rngtypid = row.rngtypid
    SQL"""update pg_catalog.pg_range
          set rngsubtype = ${ParameterValue(row.rngsubtype, null, ToStatement.longToStatement)}::oid,
              rngmultitypid = ${ParameterValue(row.rngmultitypid, null, ToStatement.longToStatement)}::oid,
              rngcollation = ${ParameterValue(row.rngcollation, null, ToStatement.longToStatement)}::oid,
              rngsubopc = ${ParameterValue(row.rngsubopc, null, ToStatement.longToStatement)}::oid,
              rngcanonical = ${ParameterValue(row.rngcanonical, null, TypoRegproc.toStatement)}::regproc,
              rngsubdiff = ${ParameterValue(row.rngsubdiff, null, TypoRegproc.toStatement)}::regproc
          where rngtypid = ${ParameterValue(rngtypid, null, PgRangeId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgRangeFields, PgRangeRow] = {
    UpdateBuilder("pg_catalog.pg_range", PgRangeFields, PgRangeRow.rowParser)
  }
  override def upsert(unsaved: PgRangeRow)(implicit c: Connection): PgRangeRow = {
    SQL"""insert into pg_catalog.pg_range(rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff)
          values (
            ${ParameterValue(unsaved.rngtypid, null, PgRangeId.toStatement)}::oid,
            ${ParameterValue(unsaved.rngsubtype, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.rngmultitypid, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.rngcollation, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.rngsubopc, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.rngcanonical, null, TypoRegproc.toStatement)}::regproc,
            ${ParameterValue(unsaved.rngsubdiff, null, TypoRegproc.toStatement)}::regproc
          )
          on conflict (rngtypid)
          do update set
            rngsubtype = EXCLUDED.rngsubtype,
            rngmultitypid = EXCLUDED.rngmultitypid,
            rngcollation = EXCLUDED.rngcollation,
            rngsubopc = EXCLUDED.rngsubopc,
            rngcanonical = EXCLUDED.rngcanonical,
            rngsubdiff = EXCLUDED.rngsubdiff
          returning rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff
       """
      .executeInsert(PgRangeRow.rowParser(1).single)
    
  }
}
