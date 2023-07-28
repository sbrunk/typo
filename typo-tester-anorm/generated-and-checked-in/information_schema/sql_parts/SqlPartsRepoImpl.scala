/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package sql_parts

import anorm.SqlStringInterpolation
import java.sql.Connection

object SqlPartsRepoImpl extends SqlPartsRepo {
  override def insert(unsaved: SqlPartsRow)(implicit c: Connection): SqlPartsRow = {
    SQL"""insert into information_schema.sql_parts(feature_id, feature_name, is_supported, is_verified_by, "comments")
          values (${unsaved.featureId}::information_schema.character_data, ${unsaved.featureName}::information_schema.character_data, ${unsaved.isSupported}::information_schema.yes_or_no, ${unsaved.isVerifiedBy}::information_schema.character_data, ${unsaved.comments}::information_schema.character_data)
          returning feature_id, feature_name, is_supported, is_verified_by, "comments"
       """
      .executeInsert(SqlPartsRow.rowParser(1).single)
    
  }
  override def selectAll(implicit c: Connection): List[SqlPartsRow] = {
    SQL"""select feature_id, feature_name, is_supported, is_verified_by, "comments"
          from information_schema.sql_parts
       """.as(SqlPartsRow.rowParser(1).*)
  }
}
