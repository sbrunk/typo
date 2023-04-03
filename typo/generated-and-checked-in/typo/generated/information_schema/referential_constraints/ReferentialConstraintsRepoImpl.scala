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

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object ReferentialConstraintsRepoImpl extends ReferentialConstraintsRepo {
  override def selectAll(implicit c: Connection): List[ReferentialConstraintsRow] = {
    SQL"""select constraint_catalog, constraint_schema, constraint_name, unique_constraint_catalog, unique_constraint_schema, unique_constraint_name, match_option, update_rule, delete_rule from information_schema.referential_constraints""".as(ReferentialConstraintsRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[ReferentialConstraintsFieldOrIdValue[_]])(implicit c: Connection): List[ReferentialConstraintsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ReferentialConstraintsFieldValue.constraintCatalog(value) => NamedParameter("constraint_catalog", ParameterValue.from(value))
          case ReferentialConstraintsFieldValue.constraintSchema(value) => NamedParameter("constraint_schema", ParameterValue.from(value))
          case ReferentialConstraintsFieldValue.constraintName(value) => NamedParameter("constraint_name", ParameterValue.from(value))
          case ReferentialConstraintsFieldValue.uniqueConstraintCatalog(value) => NamedParameter("unique_constraint_catalog", ParameterValue.from(value))
          case ReferentialConstraintsFieldValue.uniqueConstraintSchema(value) => NamedParameter("unique_constraint_schema", ParameterValue.from(value))
          case ReferentialConstraintsFieldValue.uniqueConstraintName(value) => NamedParameter("unique_constraint_name", ParameterValue.from(value))
          case ReferentialConstraintsFieldValue.matchOption(value) => NamedParameter("match_option", ParameterValue.from(value))
          case ReferentialConstraintsFieldValue.updateRule(value) => NamedParameter("update_rule", ParameterValue.from(value))
          case ReferentialConstraintsFieldValue.deleteRule(value) => NamedParameter("delete_rule", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.referential_constraints where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(ReferentialConstraintsRow.rowParser("").*)
    }
  
  }
}
