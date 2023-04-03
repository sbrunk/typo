/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema
package referential_constraints

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ReferentialConstraintsRow(
  constraintCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"constraint_catalog","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  constraintSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"constraint_schema","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  constraintName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"constraint_name","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  uniqueConstraintCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"unique_constraint_catalog","ordinal_position":4,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  uniqueConstraintSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"unique_constraint_schema","ordinal_position":5,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  uniqueConstraintName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"unique_constraint_name","ordinal_position":6,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  matchOption: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"match_option","ordinal_position":7,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  updateRule: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"update_rule","ordinal_position":8,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  deleteRule: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"delete_rule","ordinal_position":9,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object ReferentialConstraintsRow {
  def rowParser(prefix: String): RowParser[ReferentialConstraintsRow] = { row =>
    Success(
      ReferentialConstraintsRow(
        constraintCatalog = row[Option[String]](prefix + "constraint_catalog"),
        constraintSchema = row[Option[String]](prefix + "constraint_schema"),
        constraintName = row[Option[String]](prefix + "constraint_name"),
        uniqueConstraintCatalog = row[Option[String]](prefix + "unique_constraint_catalog"),
        uniqueConstraintSchema = row[Option[String]](prefix + "unique_constraint_schema"),
        uniqueConstraintName = row[Option[String]](prefix + "unique_constraint_name"),
        matchOption = row[Option[String]](prefix + "match_option"),
        updateRule = row[Option[String]](prefix + "update_rule"),
        deleteRule = row[Option[String]](prefix + "delete_rule")
      )
    )
  }

  implicit val oFormat: OFormat[ReferentialConstraintsRow] = new OFormat[ReferentialConstraintsRow]{
    override def writes(o: ReferentialConstraintsRow): JsObject =
      Json.obj(
        "constraint_catalog" -> o.constraintCatalog,
        "constraint_schema" -> o.constraintSchema,
        "constraint_name" -> o.constraintName,
        "unique_constraint_catalog" -> o.uniqueConstraintCatalog,
        "unique_constraint_schema" -> o.uniqueConstraintSchema,
        "unique_constraint_name" -> o.uniqueConstraintName,
        "match_option" -> o.matchOption,
        "update_rule" -> o.updateRule,
        "delete_rule" -> o.deleteRule
      )
  
    override def reads(json: JsValue): JsResult[ReferentialConstraintsRow] = {
      JsResult.fromTry(
        Try(
          ReferentialConstraintsRow(
            constraintCatalog = json.\("constraint_catalog").toOption.map(_.as[String]),
            constraintSchema = json.\("constraint_schema").toOption.map(_.as[String]),
            constraintName = json.\("constraint_name").toOption.map(_.as[String]),
            uniqueConstraintCatalog = json.\("unique_constraint_catalog").toOption.map(_.as[String]),
            uniqueConstraintSchema = json.\("unique_constraint_schema").toOption.map(_.as[String]),
            uniqueConstraintName = json.\("unique_constraint_name").toOption.map(_.as[String]),
            matchOption = json.\("match_option").toOption.map(_.as[String]),
            updateRule = json.\("update_rule").toOption.map(_.as[String]),
            deleteRule = json.\("delete_rule").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
