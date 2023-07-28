/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package sql_features

import anorm.SqlStringInterpolation
import java.sql.Connection

object SqlFeaturesRepoImpl extends SqlFeaturesRepo {
  override def insert(unsaved: SqlFeaturesRow)(implicit c: Connection): SqlFeaturesRow = {
    SQL"""insert into information_schema.sql_features(feature_id, feature_name, sub_feature_id, sub_feature_name, is_supported, is_verified_by, "comments")
          values (${unsaved.featureId}::information_schema.character_data, ${unsaved.featureName}::information_schema.character_data, ${unsaved.subFeatureId}::information_schema.character_data, ${unsaved.subFeatureName}::information_schema.character_data, ${unsaved.isSupported}::information_schema.yes_or_no, ${unsaved.isVerifiedBy}::information_schema.character_data, ${unsaved.comments}::information_schema.character_data)
          returning feature_id, feature_name, sub_feature_id, sub_feature_name, is_supported, is_verified_by, "comments"
       """
      .executeInsert(SqlFeaturesRow.rowParser(1).single)
    
  }
  override def selectAll(implicit c: Connection): List[SqlFeaturesRow] = {
    SQL"""select feature_id, feature_name, sub_feature_id, sub_feature_name, is_supported, is_verified_by, "comments"
          from information_schema.sql_features
       """.as(SqlFeaturesRow.rowParser(1).*)
  }
}
