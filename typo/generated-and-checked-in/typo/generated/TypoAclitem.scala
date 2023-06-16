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
import anorm.MetaDataItem
import anorm.ParameterMetaData
import anorm.SqlRequestError
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.PreparedStatement
import java.sql.Types
import org.postgresql.jdbc.PgArray
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** aclitem (via PGObject) */
case class TypoAclItem(value: String)
object TypoAclItem {
  implicit val oFormat: OFormat[TypoAclItem] = new OFormat[TypoAclItem]{
    override def writes(o: TypoAclItem): JsObject =
      Json.obj(
        "value" -> o.value
      )
  
    override def reads(json: JsValue): JsResult[TypoAclItem] = {
      JsResult.fromTry(
        Try(
          TypoAclItem(
            value = json.\("value").as[String]
          )
        )
      )
    }
  }
  implicit val TypoAclItemDb: ToStatement[TypoAclItem] with ParameterMetaData[TypoAclItem] with Column[TypoAclItem] = new ToStatement[TypoAclItem] with ParameterMetaData[TypoAclItem] with Column[TypoAclItem] {
    override def sqlType: String = "aclitem"
    override def jdbcType: Int = Types.OTHER
    override def set(s: PreparedStatement, index: Int, v: TypoAclItem): Unit =
      s.setObject(index, {
                           val obj = new PGobject
                           obj.setType("aclitem")
                           obj.setValue(v.value)
                           obj
                         })
    override def apply(v: Any, v2: MetaDataItem): Either[SqlRequestError, TypoAclItem] =
      v match {
        case v: PGobject => Right(TypoAclItem(v.getValue))
        case other => Left(TypeDoesNotMatch(s"Expected instance of PGobject from JDBC to produce a TypoAclItem, got ${other.getClass.getName}"))
      }
  }
  
  implicit val TypoAclItemDbArray: ToStatement[Array[TypoAclItem]] with ParameterMetaData[Array[TypoAclItem]] with Column[Array[TypoAclItem]] = new ToStatement[Array[TypoAclItem]] with ParameterMetaData[Array[TypoAclItem]] with Column[Array[TypoAclItem]] {
    override def sqlType: String = "_aclitem"
    override def jdbcType: Int = Types.ARRAY
    override def set(s: PreparedStatement, index: Int, v: Array[TypoAclItem]): Unit =
      s.setArray(index, s.getConnection.createArrayOf("aclitem", v.map(v => {
                                                                              val obj = new PGobject
                                                                              obj.setType("aclitem")
                                                                              obj.setValue(v.value)
                                                                              obj
                                                                            })))
    override def apply(v: Any, v2: MetaDataItem): Either[SqlRequestError, Array[TypoAclItem]] =
      v match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[_] =>
             Right(v.map(v => TypoAclItem(v.asInstanceOf[String])))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoAclItem, got ${other.getClass.getName}"))
         }
        case other => Left(TypeDoesNotMatch(s"Expected PgArray from JDBC to produce an array of TypoAclItem, got ${other.getClass.getName}"))
      }
  }

}
