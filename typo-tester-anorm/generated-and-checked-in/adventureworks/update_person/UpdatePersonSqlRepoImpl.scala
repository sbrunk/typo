/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package update_person

import adventureworks.customtypes.TypoLocalDateTime
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection

object UpdatePersonSqlRepoImpl extends UpdatePersonSqlRepo {
  override def apply(suffix: String, cutoff: Option[TypoLocalDateTime])(implicit c: Connection): Int = {
    SQL"""update person.person
          set firstname = firstname || '-' || ${ParameterValue(suffix, null, ToStatement.stringToStatement)}
          where modifieddate < ${ParameterValue(cutoff, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp""".executeUpdate()
  }
}
