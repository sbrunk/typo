/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_template

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_ts_template` */
case class PgTsTemplateId(value: /* oid */ Long) extends AnyVal
object PgTsTemplateId {
  implicit lazy val arrayColumn: Column[Array[PgTsTemplateId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgTsTemplateId]] = adventureworks.LongArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgTsTemplateId, /* oid */ Long] = Bijection[PgTsTemplateId, /* oid */ Long](_.value)(PgTsTemplateId.apply)
  implicit lazy val column: Column[PgTsTemplateId] = Column.columnToLong.map(PgTsTemplateId.apply)
  implicit lazy val ordering: Ordering[PgTsTemplateId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgTsTemplateId] = new ParameterMetaData[PgTsTemplateId] {
    override def sqlType: String = ParameterMetaData.LongParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.LongParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[PgTsTemplateId] = Reads.LongReads.map(PgTsTemplateId.apply)
  implicit lazy val toStatement: ToStatement[PgTsTemplateId] = ToStatement.longToStatement.contramap(_.value)
  implicit lazy val writes: Writes[PgTsTemplateId] = Writes.LongWrites.contramap(_.value)
}
