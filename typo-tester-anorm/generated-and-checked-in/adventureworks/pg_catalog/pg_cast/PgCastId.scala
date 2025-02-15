/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_cast

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_cast` */
case class PgCastId(value: /* oid */ Long) extends AnyVal
object PgCastId {
  implicit lazy val arrayColumn: Column[Array[PgCastId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgCastId]] = adventureworks.LongArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgCastId, /* oid */ Long] = Bijection[PgCastId, /* oid */ Long](_.value)(PgCastId.apply)
  implicit lazy val column: Column[PgCastId] = Column.columnToLong.map(PgCastId.apply)
  implicit lazy val ordering: Ordering[PgCastId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgCastId] = new ParameterMetaData[PgCastId] {
    override def sqlType: String = ParameterMetaData.LongParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.LongParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[PgCastId] = Reads.LongReads.map(PgCastId.apply)
  implicit lazy val toStatement: ToStatement[PgCastId] = ToStatement.longToStatement.contramap(_.value)
  implicit lazy val writes: Writes[PgCastId] = Writes.LongWrites.contramap(_.value)
}
