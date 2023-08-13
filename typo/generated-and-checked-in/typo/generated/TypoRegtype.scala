/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import org.postgresql.jdbc.PgArray
import org.postgresql.util.PGobject
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** regtype (via PGObject) */
case class TypoRegtype(value: String)

object TypoRegtype {
  implicit lazy val arrayColumn: Column[Array[TypoRegtype]] = Column.nonNull[Array[TypoRegtype]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoRegtype(v.asInstanceOf[String])))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoRegtype, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayParameterMetaData: ParameterMetaData[Array[TypoRegtype]] = new ParameterMetaData[Array[TypoRegtype]] {
    override def sqlType: String = "_regtype"
    override def jdbcType: Int = Types.ARRAY
  }
  implicit lazy val arrayToStatement: ToStatement[Array[TypoRegtype]] = ToStatement[Array[TypoRegtype]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("regtype", v.map(v => {
                                                                                                                           val obj = new PGobject
                                                                                                                           obj.setType("regtype")
                                                                                                                           obj.setValue(v.value)
                                                                                                                           obj
                                                                                                                         }))))
  implicit lazy val column: Column[TypoRegtype] = Column.nonNull[TypoRegtype]((v1: Any, _) =>
    v1 match {
      case v: PGobject => Right(TypoRegtype(v.getValue))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.util.PGobject, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val ordering: Ordering[TypoRegtype] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoRegtype] = new ParameterMetaData[TypoRegtype] {
    override def sqlType: String = "regtype"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoRegtype] = Reads.StringReads.map(TypoRegtype.apply)
  implicit lazy val toStatement: ToStatement[TypoRegtype] = ToStatement[TypoRegtype]((s, index, v) => s.setObject(index, {
                                                                 val obj = new PGobject
                                                                 obj.setType("regtype")
                                                                 obj.setValue(v.value)
                                                                 obj
                                                               }))
  implicit lazy val writes: Writes[TypoRegtype] = Writes.StringWrites.contramap(_.value)
}
