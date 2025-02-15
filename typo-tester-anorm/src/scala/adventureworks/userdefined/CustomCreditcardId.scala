/** File has been automatically generated by `typo`.
  *
  * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
  */
package adventureworks.userdefined

import anorm.{Column, ParameterMetaData, ToStatement}
import play.api.libs.json.{Reads, Writes}
import typo.dsl.Bijection

/** Type for the primary key of table `sales.creditcard` */
case class CustomCreditcardId(value: Int) extends AnyVal
object CustomCreditcardId {
  implicit lazy val arrayColumn: Column[Array[CustomCreditcardId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[CustomCreditcardId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CustomCreditcardId, Int] = Bijection[CustomCreditcardId, Int](_.value)(CustomCreditcardId.apply)
  implicit lazy val column: Column[CustomCreditcardId] = Column.columnToInt.map(CustomCreditcardId.apply)
  implicit lazy val ordering: Ordering[CustomCreditcardId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[CustomCreditcardId] = new ParameterMetaData[CustomCreditcardId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[CustomCreditcardId] = Reads.IntReads.map(CustomCreditcardId.apply)
  implicit lazy val toStatement: ToStatement[CustomCreditcardId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[CustomCreditcardId] = Writes.IntWrites.contramap(_.value)
}
