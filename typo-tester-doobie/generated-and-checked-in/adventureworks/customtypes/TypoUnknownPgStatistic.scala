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

/** This is a type typo does not know how to handle yet. This falls back to casting to string and crossing fingers. Time to file an issue! :] */
case class TypoUnknownPgStatistic(value: String)

object TypoUnknownPgStatistic {
  implicit lazy val arrayGet: Get[Array[TypoUnknownPgStatistic]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_pg_statistic"))
    .map(_.map(v => TypoUnknownPgStatistic(v.asInstanceOf[String])))
  implicit lazy val arrayPut: Put[Array[TypoUnknownPgStatistic]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_pg_statistic"), "pg_statistic")
    .contramap(_.map(v => v.value))
  implicit lazy val bijection: Bijection[TypoUnknownPgStatistic, String] = Bijection[TypoUnknownPgStatistic, String](_.value)(TypoUnknownPgStatistic.apply)
  implicit lazy val decoder: Decoder[TypoUnknownPgStatistic] = Decoder.decodeString.map(TypoUnknownPgStatistic.apply)
  implicit lazy val encoder: Encoder[TypoUnknownPgStatistic] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[TypoUnknownPgStatistic] = Get.Advanced.other[String](NonEmptyList.one("pg_statistic"))
    .map(v => TypoUnknownPgStatistic(v))
  implicit lazy val ordering: Ordering[TypoUnknownPgStatistic] = Ordering.by(_.value)
  implicit lazy val put: Put[TypoUnknownPgStatistic] = Put.Advanced.other[String](NonEmptyList.one("pg_statistic")).contramap(v => v.value)
}
