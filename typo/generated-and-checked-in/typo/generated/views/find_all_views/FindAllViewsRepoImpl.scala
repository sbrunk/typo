/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package views
package find_all_views

import anorm.SqlStringInterpolation
import java.sql.Connection

object FindAllViewsRepoImpl extends FindAllViewsRepo {
  override def apply()(implicit c: Connection): List[FindAllViewsRow] = {
    val sql = SQL"""SELECT
                  nc.oid as table_oid,
                  nc.nspname::information_schema.sql_identifier         AS table_schema,
                     c.relname::information_schema.sql_identifier          AS table_name,
                     c.relkind,
                     CASE
                         WHEN pg_has_role(c.relowner, 'USAGE'::text) THEN pg_get_viewdef(c.oid)
                         ELSE NULL::text
                         END::information_schema.character_data            AS view_definition
              FROM pg_namespace nc,
                   pg_class c
              WHERE c.relnamespace = nc.oid
                AND c.relkind in ('m'::"char", 'v'::char)
              order by 1,2,3
              """
    sql.as(FindAllViewsRow.rowParser("").*)
  
  }
}
