/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_rel

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_publication_rel` */
case class PgPublicationRelId(value: /* oid */ Long) extends AnyVal
object PgPublicationRelId {
  implicit lazy val arrayGet: Get[Array[PgPublicationRelId]] = adventureworks.LongArrayMeta.get.map(_.map(PgPublicationRelId.apply))
  implicit lazy val arrayPut: Put[Array[PgPublicationRelId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgPublicationRelId, /* oid */ Long] = Bijection[PgPublicationRelId, /* oid */ Long](_.value)(PgPublicationRelId.apply)
  implicit lazy val decoder: Decoder[PgPublicationRelId] = Decoder.decodeLong.map(PgPublicationRelId.apply)
  implicit lazy val encoder: Encoder[PgPublicationRelId] = Encoder.encodeLong.contramap(_.value)
  implicit lazy val get: Get[PgPublicationRelId] = Meta.LongMeta.get.map(PgPublicationRelId.apply)
  implicit lazy val ordering: Ordering[PgPublicationRelId] = Ordering.by(_.value)
  implicit lazy val put: Put[PgPublicationRelId] = Meta.LongMeta.put.contramap(_.value)
}
