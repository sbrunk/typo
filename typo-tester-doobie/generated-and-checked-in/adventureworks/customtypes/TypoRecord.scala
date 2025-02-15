/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import cats.data.NonEmptyList
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import org.postgresql.util.PGobject
import typo.dsl.Bijection

/** record (via PGObject) */
case class TypoRecord(value: String)

object TypoRecord {
  implicit lazy val arrayGet: Get[Array[TypoRecord]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_record"))
    .map(_.map(v => TypoRecord(v.asInstanceOf[PGobject].getValue)))
  implicit lazy val arrayPut: Put[Array[TypoRecord]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_record"), "record")
    .contramap(_.map(v => {
                            val obj = new PGobject
                            obj.setType("record")
                            obj.setValue(v.value)
                            obj
                          }))
  implicit lazy val bijection: Bijection[TypoRecord, String] = Bijection[TypoRecord, String](_.value)(TypoRecord.apply)
  implicit lazy val decoder: Decoder[TypoRecord] = Decoder.decodeString.map(TypoRecord.apply)
  implicit lazy val encoder: Encoder[TypoRecord] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[TypoRecord] = Get.Advanced.other[PGobject](NonEmptyList.one("record"))
    .map(v => TypoRecord(v.getValue))
  implicit lazy val ordering: Ordering[TypoRecord] = Ordering.by(_.value)
  implicit lazy val put: Put[TypoRecord] = Put.Advanced.other[PGobject](NonEmptyList.one("record")).contramap(v => {
                                                                            val obj = new PGobject
                                                                            obj.setType("record")
                                                                            obj.setValue(v.value)
                                                                            obj
                                                                          })
}
