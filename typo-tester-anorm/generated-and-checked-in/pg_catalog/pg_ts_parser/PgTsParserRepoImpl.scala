/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_parser

import adventureworks.TypoRegproc
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgTsParserRepoImpl extends PgTsParserRepo {
  override def delete(oid: PgTsParserId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_ts_parser where oid = ${ParameterValue(oid, null, PgTsParserId.toStatement)}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgTsParserFields, PgTsParserRow] = {
    DeleteBuilder("pg_catalog.pg_ts_parser", PgTsParserFields)
  }
  override def insert(unsaved: PgTsParserRow)(implicit c: Connection): PgTsParserRow = {
    SQL"""insert into pg_catalog.pg_ts_parser(oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype)
          values (${ParameterValue(unsaved.oid, null, PgTsParserId.toStatement)}::oid, ${ParameterValue(unsaved.prsname, null, ToStatement.stringToStatement)}::name, ${ParameterValue(unsaved.prsnamespace, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.prsstart, null, TypoRegproc.toStatement)}::regproc, ${ParameterValue(unsaved.prstoken, null, TypoRegproc.toStatement)}::regproc, ${ParameterValue(unsaved.prsend, null, TypoRegproc.toStatement)}::regproc, ${ParameterValue(unsaved.prsheadline, null, TypoRegproc.toStatement)}::regproc, ${ParameterValue(unsaved.prslextype, null, TypoRegproc.toStatement)}::regproc)
          returning oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype
       """
      .executeInsert(PgTsParserRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgTsParserFields, PgTsParserRow] = {
    SelectBuilderSql("pg_catalog.pg_ts_parser", PgTsParserFields, PgTsParserRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgTsParserRow] = {
    SQL"""select oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype
          from pg_catalog.pg_ts_parser
       """.as(PgTsParserRow.rowParser(1).*)
  }
  override def selectById(oid: PgTsParserId)(implicit c: Connection): Option[PgTsParserRow] = {
    SQL"""select oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype
          from pg_catalog.pg_ts_parser
          where oid = ${ParameterValue(oid, null, PgTsParserId.toStatement)}
       """.as(PgTsParserRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgTsParserId])(implicit c: Connection): List[PgTsParserRow] = {
    SQL"""select oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype
          from pg_catalog.pg_ts_parser
          where oid = ANY(${oids})
       """.as(PgTsParserRow.rowParser(1).*)
    
  }
  override def selectByUnique(prsname: String, prsnamespace: /* oid */ Long)(implicit c: Connection): Option[PgTsParserRow] = {
    SQL"""select prsname, prsnamespace
          from pg_catalog.pg_ts_parser
          where prsname = ${ParameterValue(prsname, null, ToStatement.stringToStatement)} AND prsnamespace = ${ParameterValue(prsnamespace, null, ToStatement.longToStatement)}
       """.as(PgTsParserRow.rowParser(1).singleOpt)
    
  }
  override def update(row: PgTsParserRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_ts_parser
          set prsname = ${ParameterValue(row.prsname, null, ToStatement.stringToStatement)}::name,
              prsnamespace = ${ParameterValue(row.prsnamespace, null, ToStatement.longToStatement)}::oid,
              prsstart = ${ParameterValue(row.prsstart, null, TypoRegproc.toStatement)}::regproc,
              prstoken = ${ParameterValue(row.prstoken, null, TypoRegproc.toStatement)}::regproc,
              prsend = ${ParameterValue(row.prsend, null, TypoRegproc.toStatement)}::regproc,
              prsheadline = ${ParameterValue(row.prsheadline, null, TypoRegproc.toStatement)}::regproc,
              prslextype = ${ParameterValue(row.prslextype, null, TypoRegproc.toStatement)}::regproc
          where oid = ${ParameterValue(oid, null, PgTsParserId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgTsParserFields, PgTsParserRow] = {
    UpdateBuilder("pg_catalog.pg_ts_parser", PgTsParserFields, PgTsParserRow.rowParser)
  }
  override def upsert(unsaved: PgTsParserRow)(implicit c: Connection): PgTsParserRow = {
    SQL"""insert into pg_catalog.pg_ts_parser(oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype)
          values (
            ${ParameterValue(unsaved.oid, null, PgTsParserId.toStatement)}::oid,
            ${ParameterValue(unsaved.prsname, null, ToStatement.stringToStatement)}::name,
            ${ParameterValue(unsaved.prsnamespace, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.prsstart, null, TypoRegproc.toStatement)}::regproc,
            ${ParameterValue(unsaved.prstoken, null, TypoRegproc.toStatement)}::regproc,
            ${ParameterValue(unsaved.prsend, null, TypoRegproc.toStatement)}::regproc,
            ${ParameterValue(unsaved.prsheadline, null, TypoRegproc.toStatement)}::regproc,
            ${ParameterValue(unsaved.prslextype, null, TypoRegproc.toStatement)}::regproc
          )
          on conflict (oid)
          do update set
            prsname = EXCLUDED.prsname,
            prsnamespace = EXCLUDED.prsnamespace,
            prsstart = EXCLUDED.prsstart,
            prstoken = EXCLUDED.prstoken,
            prsend = EXCLUDED.prsend,
            prsheadline = EXCLUDED.prsheadline,
            prslextype = EXCLUDED.prslextype
          returning oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype
       """
      .executeInsert(PgTsParserRow.rowParser(1).single)
    
  }
}
