/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext_data

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_statistic_ext_data` */
case class PgStatisticExtDataId(value: /* oid */ Long) extends AnyVal
object PgStatisticExtDataId {
  implicit lazy val arrayGet: Get[Array[PgStatisticExtDataId]] = adventureworks.LongArrayMeta.get.map(_.map(PgStatisticExtDataId.apply))
  implicit lazy val arrayPut: Put[Array[PgStatisticExtDataId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgStatisticExtDataId, /* oid */ Long] = Bijection[PgStatisticExtDataId, /* oid */ Long](_.value)(PgStatisticExtDataId.apply)
  implicit lazy val decoder: Decoder[PgStatisticExtDataId] = Decoder.decodeLong.map(PgStatisticExtDataId.apply)
  implicit lazy val encoder: Encoder[PgStatisticExtDataId] = Encoder.encodeLong.contramap(_.value)
  implicit lazy val get: Get[PgStatisticExtDataId] = Meta.LongMeta.get.map(PgStatisticExtDataId.apply)
  implicit lazy val ordering: Ordering[PgStatisticExtDataId] = Ordering.by(_.value)
  implicit lazy val put: Put[PgStatisticExtDataId] = Meta.LongMeta.put.contramap(_.value)
}
