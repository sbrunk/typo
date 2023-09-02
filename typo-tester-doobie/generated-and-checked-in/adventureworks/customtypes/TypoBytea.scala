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
import typo.dsl.Bijection

/** This represents the bytea datatype in PostgreSQL */
case class TypoBytea(value: Array[Byte])

object TypoBytea {
  implicit lazy val arrayGet: Get[Array[TypoBytea]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_bytea"))
    .map(_.map(v => TypoBytea(v.asInstanceOf[Array[Byte]])))
  implicit lazy val arrayPut: Put[Array[TypoBytea]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_bytea"), "bytea")
    .contramap(_.map(v => v.value))
  implicit lazy val bijection: Bijection[TypoBytea, Array[Byte]] = Bijection[TypoBytea, Array[Byte]](_.value)(TypoBytea.apply)
  implicit lazy val decoder: Decoder[TypoBytea] = Decoder.decodeArray[Byte](Decoder.decodeByte, implicitly).map(TypoBytea.apply)
  implicit lazy val encoder: Encoder[TypoBytea] = Encoder.encodeIterable[Byte, Array](Encoder.encodeByte, implicitly).contramap(_.value)
  implicit lazy val get: Get[TypoBytea] = Get.Advanced.other[Array[Byte]](NonEmptyList.one("bytea"))
    .map(v => TypoBytea(v))
  implicit def ordering(implicit O0: Ordering[Array[Byte]]): Ordering[TypoBytea] = Ordering.by(_.value)
  implicit lazy val put: Put[TypoBytea] = Put.Advanced.other[Array[Byte]](NonEmptyList.one("bytea")).contramap(v => v.value)
}
