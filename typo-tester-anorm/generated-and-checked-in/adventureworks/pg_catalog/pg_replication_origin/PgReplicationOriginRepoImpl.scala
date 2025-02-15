/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_replication_origin

import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgReplicationOriginRepoImpl extends PgReplicationOriginRepo {
  override def delete(roident: PgReplicationOriginId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_replication_origin where "roident" = ${ParameterValue(roident, null, PgReplicationOriginId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgReplicationOriginFields, PgReplicationOriginRow] = {
    DeleteBuilder("pg_catalog.pg_replication_origin", PgReplicationOriginFields)
  }
  override def insert(unsaved: PgReplicationOriginRow)(implicit c: Connection): PgReplicationOriginRow = {
    SQL"""insert into pg_catalog.pg_replication_origin("roident", "roname")
          values (${ParameterValue(unsaved.roident, null, PgReplicationOriginId.toStatement)}::oid, ${ParameterValue(unsaved.roname, null, ToStatement.stringToStatement)})
          returning "roident", "roname"
       """
      .executeInsert(PgReplicationOriginRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgReplicationOriginFields, PgReplicationOriginRow] = {
    SelectBuilderSql("pg_catalog.pg_replication_origin", PgReplicationOriginFields, PgReplicationOriginRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgReplicationOriginRow] = {
    SQL"""select "roident", "roname"
          from pg_catalog.pg_replication_origin
       """.as(PgReplicationOriginRow.rowParser(1).*)
  }
  override def selectById(roident: PgReplicationOriginId)(implicit c: Connection): Option[PgReplicationOriginRow] = {
    SQL"""select "roident", "roname"
          from pg_catalog.pg_replication_origin
          where "roident" = ${ParameterValue(roident, null, PgReplicationOriginId.toStatement)}
       """.as(PgReplicationOriginRow.rowParser(1).singleOpt)
  }
  override def selectByIds(roidents: Array[PgReplicationOriginId])(implicit c: Connection): List[PgReplicationOriginRow] = {
    SQL"""select "roident", "roname"
          from pg_catalog.pg_replication_origin
          where "roident" = ANY(${roidents})
       """.as(PgReplicationOriginRow.rowParser(1).*)
    
  }
  override def selectByUnique(roname: String)(implicit c: Connection): Option[PgReplicationOriginRow] = {
    SQL"""select "roname"
          from pg_catalog.pg_replication_origin
          where "roname" = ${ParameterValue(roname, null, ToStatement.stringToStatement)}
       """.as(PgReplicationOriginRow.rowParser(1).singleOpt)
    
  }
  override def update(row: PgReplicationOriginRow)(implicit c: Connection): Boolean = {
    val roident = row.roident
    SQL"""update pg_catalog.pg_replication_origin
          set "roname" = ${ParameterValue(row.roname, null, ToStatement.stringToStatement)}
          where "roident" = ${ParameterValue(roident, null, PgReplicationOriginId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgReplicationOriginFields, PgReplicationOriginRow] = {
    UpdateBuilder("pg_catalog.pg_replication_origin", PgReplicationOriginFields, PgReplicationOriginRow.rowParser)
  }
  override def upsert(unsaved: PgReplicationOriginRow)(implicit c: Connection): PgReplicationOriginRow = {
    SQL"""insert into pg_catalog.pg_replication_origin("roident", "roname")
          values (
            ${ParameterValue(unsaved.roident, null, PgReplicationOriginId.toStatement)}::oid,
            ${ParameterValue(unsaved.roname, null, ToStatement.stringToStatement)}
          )
          on conflict ("roident")
          do update set
            "roname" = EXCLUDED."roname"
          returning "roident", "roname"
       """
      .executeInsert(PgReplicationOriginRow.rowParser(1).single)
    
  }
}
