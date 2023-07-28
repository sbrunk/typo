/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package sql_sizing

import anorm.SqlStringInterpolation
import java.sql.Connection

object SqlSizingRepoImpl extends SqlSizingRepo {
  override def insert(unsaved: SqlSizingRow)(implicit c: Connection): SqlSizingRow = {
    SQL"""insert into information_schema.sql_sizing(sizing_id, sizing_name, supported_value, "comments")
          values (${unsaved.sizingId}::information_schema.cardinal_number, ${unsaved.sizingName}::information_schema.character_data, ${unsaved.supportedValue}::information_schema.cardinal_number, ${unsaved.comments}::information_schema.character_data)
          returning sizing_id, sizing_name, supported_value, "comments"
       """
      .executeInsert(SqlSizingRow.rowParser(1).single)
    
  }
  override def selectAll(implicit c: Connection): List[SqlSizingRow] = {
    SQL"""select sizing_id, sizing_name, supported_value, "comments"
          from information_schema.sql_sizing
       """.as(SqlSizingRow.rowParser(1).*)
  }
}
