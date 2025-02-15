/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_language

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_language` */
case class PgLanguageId(value: /* oid */ Long) extends AnyVal
object PgLanguageId {
  implicit lazy val arrayColumn: Column[Array[PgLanguageId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgLanguageId]] = adventureworks.LongArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgLanguageId, /* oid */ Long] = Bijection[PgLanguageId, /* oid */ Long](_.value)(PgLanguageId.apply)
  implicit lazy val column: Column[PgLanguageId] = Column.columnToLong.map(PgLanguageId.apply)
  implicit lazy val ordering: Ordering[PgLanguageId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgLanguageId] = new ParameterMetaData[PgLanguageId] {
    override def sqlType: String = ParameterMetaData.LongParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.LongParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[PgLanguageId] = Reads.LongReads.map(PgLanguageId.apply)
  implicit lazy val toStatement: ToStatement[PgLanguageId] = ToStatement.longToStatement.contramap(_.value)
  implicit lazy val writes: Writes[PgLanguageId] = Writes.LongWrites.contramap(_.value)
}
