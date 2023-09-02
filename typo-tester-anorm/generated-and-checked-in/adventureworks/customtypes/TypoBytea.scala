/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import org.postgresql.jdbc.PgArray
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** This represents the bytea datatype in PostgreSQL */
case class TypoBytea(value: Array[Byte])

object TypoBytea {
  implicit lazy val arrayColumn: Column[Array[TypoBytea]] = Column.nonNull[Array[TypoBytea]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoBytea(v.asInstanceOf[Array[Byte]])))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoBytea, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoBytea]] = ToStatement[Array[TypoBytea]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("bytea", v.map(v => v.value))))
  implicit lazy val bijection: Bijection[TypoBytea, Array[Byte]] = Bijection[TypoBytea, Array[Byte]](_.value)(TypoBytea.apply)
  implicit lazy val column: Column[TypoBytea] = Column.nonNull[TypoBytea]((v1: Any, _) =>
    v1 match {
      case v: Array[Byte] => Right(TypoBytea(v))
      case other => Left(TypeDoesNotMatch(s"Expected instance of scala.Array[scala.Byte], got ${other.getClass.getName}"))
    }
  )
  implicit def ordering(implicit O0: Ordering[Array[Byte]]): Ordering[TypoBytea] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoBytea] = new ParameterMetaData[TypoBytea] {
    override def sqlType: String = "bytea"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoBytea] = Reads.ArrayReads[Byte](Reads.ByteReads, implicitly).map(TypoBytea.apply)
  implicit lazy val toStatement: ToStatement[TypoBytea] = ToStatement[TypoBytea]((s, index, v) => s.setObject(index, v.value))
  implicit lazy val writes: Writes[TypoBytea] = Writes.arrayWrites[Byte](implicitly, Writes.ByteWrites).contramap(_.value)
}
