/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sci

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.shoppingcartitem.ShoppingcartitemId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class SciViewRow(
  id: Option[Int],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.shoppingcartitemid]] */
  shoppingcartitemid: Option[ShoppingcartitemId],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.shoppingcartid]] */
  shoppingcartid: Option[/* max 50 chars */ String],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.quantity]] */
  quantity: Option[Int],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.datecreated]] */
  datecreated: Option[TypoLocalDateTime],
  /** Points to [[sales.shoppingcartitem.ShoppingcartitemRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object SciViewRow {
  implicit lazy val decoder: Decoder[SciViewRow] = Decoder.forProduct7[SciViewRow, Option[Int], Option[ShoppingcartitemId], Option[/* max 50 chars */ String], Option[Int], Option[ProductId], Option[TypoLocalDateTime], Option[TypoLocalDateTime]]("id", "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated", "modifieddate")(SciViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(ShoppingcartitemId.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(ProductId.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[SciViewRow] = Encoder.forProduct7[SciViewRow, Option[Int], Option[ShoppingcartitemId], Option[/* max 50 chars */ String], Option[Int], Option[ProductId], Option[TypoLocalDateTime], Option[TypoLocalDateTime]]("id", "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated", "modifieddate")(x => (x.id, x.shoppingcartitemid, x.shoppingcartid, x.quantity, x.productid, x.datecreated, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(ShoppingcartitemId.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(ProductId.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit lazy val read: Read[SciViewRow] = new Read[SciViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (ShoppingcartitemId.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (ProductId.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SciViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      shoppingcartitemid = ShoppingcartitemId.get.unsafeGetNullable(rs, i + 1),
      shoppingcartid = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      quantity = Meta.IntMeta.get.unsafeGetNullable(rs, i + 3),
      productid = ProductId.get.unsafeGetNullable(rs, i + 4),
      datecreated = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
