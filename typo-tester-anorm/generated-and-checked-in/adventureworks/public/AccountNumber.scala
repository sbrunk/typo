/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Domain `public.AccountNumber`
  * No constraint
  */
case class AccountNumber(value: String) extends AnyVal
object AccountNumber {
  implicit lazy val arrayColumn: Column[Array[AccountNumber]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[AccountNumber]] = ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData).contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[AccountNumber, String] = Bijection[AccountNumber, String](_.value)(AccountNumber.apply)
  implicit lazy val column: Column[AccountNumber] = Column.columnToString.map(AccountNumber.apply)
  implicit lazy val ordering: Ordering[AccountNumber] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[AccountNumber] = new ParameterMetaData[AccountNumber] {
    override def sqlType: String = ParameterMetaData.StringParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.StringParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[AccountNumber] = Reads.StringReads.map(AccountNumber.apply)
  implicit lazy val toStatement: ToStatement[AccountNumber] = ToStatement.stringToStatement.contramap(_.value)
  implicit lazy val writes: Writes[AccountNumber] = Writes.StringWrites.contramap(_.value)
}