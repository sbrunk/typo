/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package custom
package domains

import anorm.SqlStringInterpolation
import java.sql.Connection

object DomainsSqlRepoImpl extends DomainsSqlRepo {
  override def apply()(implicit c: Connection): List[DomainsSqlRow] = {
    val sql =
      SQL"""SELECT nsp.nspname                   as "schema",
                   typ.typname                   as "name",
                   tt.typname                    as "type",
                   pc.collname                   as "collation",
                   typ.typnotnull                as "isNotNull",
                   typ.typdefault                as "default",
                   con.conname                   as "constraintName",
                   pg_get_constraintdef(con.oid) as "constraintDefinition"
            FROM pg_catalog.pg_type typ
                     inner join pg_catalog.pg_namespace nsp ON nsp.oid = typ.typnamespace
                     inner join pg_catalog.pg_type tt on typ.typbasetype = tt.oid
                     left join pg_collation pc on typ.typcollation = pc.oid
                     left JOIN pg_catalog.pg_constraint con ON con.contypid = typ.oid
         """
    sql.as(DomainsSqlRow.rowParser(1).*)
  
  }
}
