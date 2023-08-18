/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

import adventureworks.TypoLocalDateTime
import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ProductmodelillustrationRow(
  /** Primary key. Foreign key to ProductModel.ProductModelID.
      Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Primary key. Foreign key to Illustration.IllustrationID.
      Points to [[illustration.IllustrationRow.illustrationid]] */
  illustrationid: IllustrationId,
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductmodelillustrationId = ProductmodelillustrationId(productmodelid, illustrationid)
 }

object ProductmodelillustrationRow {
  implicit lazy val decoder: Decoder[ProductmodelillustrationRow] = Decoder.forProduct3[ProductmodelillustrationRow, ProductmodelId, IllustrationId, TypoLocalDateTime]("productmodelid", "illustrationid", "modifieddate")(ProductmodelillustrationRow.apply)(ProductmodelId.decoder, IllustrationId.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[ProductmodelillustrationRow] = Encoder.forProduct3[ProductmodelillustrationRow, ProductmodelId, IllustrationId, TypoLocalDateTime]("productmodelid", "illustrationid", "modifieddate")(x => (x.productmodelid, x.illustrationid, x.modifieddate))(ProductmodelId.encoder, IllustrationId.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[ProductmodelillustrationRow] = new Read[ProductmodelillustrationRow](
    gets = List(
      (ProductmodelId.get, Nullability.NoNulls),
      (IllustrationId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ProductmodelillustrationRow(
      productmodelid = ProductmodelId.get.unsafeGetNonNullable(rs, i + 0),
      illustrationid = IllustrationId.get.unsafeGetNonNullable(rs, i + 1),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2)
    )
  )
}
