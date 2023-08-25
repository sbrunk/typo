/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_enum

import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgEnumRepoImpl extends PgEnumRepo {
  override def delete(oid: PgEnumId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_enum where oid = ${ParameterValue(oid, null, PgEnumId.toStatement)}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgEnumFields, PgEnumRow] = {
    DeleteBuilder("pg_catalog.pg_enum", PgEnumFields)
  }
  override def insert(unsaved: PgEnumRow)(implicit c: Connection): PgEnumRow = {
    SQL"""insert into pg_catalog.pg_enum(oid, enumtypid, enumsortorder, enumlabel)
          values (${ParameterValue(unsaved.oid, null, PgEnumId.toStatement)}::oid, ${ParameterValue(unsaved.enumtypid, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.enumsortorder, null, ToStatement.floatToStatement)}::float4, ${ParameterValue(unsaved.enumlabel, null, ToStatement.stringToStatement)}::name)
          returning oid, enumtypid, enumsortorder, enumlabel
       """
      .executeInsert(PgEnumRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgEnumFields, PgEnumRow] = {
    SelectBuilderSql("pg_catalog.pg_enum", PgEnumFields, PgEnumRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgEnumRow] = {
    SQL"""select oid, enumtypid, enumsortorder, enumlabel
          from pg_catalog.pg_enum
       """.as(PgEnumRow.rowParser(1).*)
  }
  override def selectById(oid: PgEnumId)(implicit c: Connection): Option[PgEnumRow] = {
    SQL"""select oid, enumtypid, enumsortorder, enumlabel
          from pg_catalog.pg_enum
          where oid = ${ParameterValue(oid, null, PgEnumId.toStatement)}
       """.as(PgEnumRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgEnumId])(implicit c: Connection): List[PgEnumRow] = {
    SQL"""select oid, enumtypid, enumsortorder, enumlabel
          from pg_catalog.pg_enum
          where oid = ANY(${oids})
       """.as(PgEnumRow.rowParser(1).*)
    
  }
  override def selectByUnique(enumtypid: /* oid */ Long, enumlabel: String)(implicit c: Connection): Option[PgEnumRow] = {
    SQL"""select enumtypid, enumlabel
          from pg_catalog.pg_enum
          where enumtypid = ${ParameterValue(enumtypid, null, ToStatement.longToStatement)} AND enumlabel = ${ParameterValue(enumlabel, null, ToStatement.stringToStatement)}
       """.as(PgEnumRow.rowParser(1).singleOpt)
    
  }
  override def selectByUnique(enumtypid: /* oid */ Long, enumsortorder: Float)(implicit c: Connection): Option[PgEnumRow] = {
    SQL"""select enumtypid, enumsortorder
          from pg_catalog.pg_enum
          where enumtypid = ${ParameterValue(enumtypid, null, ToStatement.longToStatement)} AND enumsortorder = ${ParameterValue(enumsortorder, null, ToStatement.floatToStatement)}
       """.as(PgEnumRow.rowParser(1).singleOpt)
    
  }
  override def update(row: PgEnumRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_enum
          set enumtypid = ${ParameterValue(row.enumtypid, null, ToStatement.longToStatement)}::oid,
              enumsortorder = ${ParameterValue(row.enumsortorder, null, ToStatement.floatToStatement)}::float4,
              enumlabel = ${ParameterValue(row.enumlabel, null, ToStatement.stringToStatement)}::name
          where oid = ${ParameterValue(oid, null, PgEnumId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgEnumFields, PgEnumRow] = {
    UpdateBuilder("pg_catalog.pg_enum", PgEnumFields, PgEnumRow.rowParser)
  }
  override def upsert(unsaved: PgEnumRow)(implicit c: Connection): PgEnumRow = {
    SQL"""insert into pg_catalog.pg_enum(oid, enumtypid, enumsortorder, enumlabel)
          values (
            ${ParameterValue(unsaved.oid, null, PgEnumId.toStatement)}::oid,
            ${ParameterValue(unsaved.enumtypid, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.enumsortorder, null, ToStatement.floatToStatement)}::float4,
            ${ParameterValue(unsaved.enumlabel, null, ToStatement.stringToStatement)}::name
          )
          on conflict (oid)
          do update set
            enumtypid = EXCLUDED.enumtypid,
            enumsortorder = EXCLUDED.enumsortorder,
            enumlabel = EXCLUDED.enumlabel
          returning oid, enumtypid, enumsortorder, enumlabel
       """
      .executeInsert(PgEnumRow.rowParser(1).single)
    
  }
}
