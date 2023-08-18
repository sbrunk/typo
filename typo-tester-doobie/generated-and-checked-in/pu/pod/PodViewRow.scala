/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package pod

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PodViewRow(
  id: Option[Int],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.purchaseorderid]] */
  purchaseorderid: Option[PurchaseorderheaderId],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.purchaseorderdetailid]] */
  purchaseorderdetailid: Option[Int],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.duedate]] */
  duedate: Option[TypoLocalDateTime],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.orderqty]] */
  orderqty: Option[Int],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.unitprice]] */
  unitprice: Option[BigDecimal],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.receivedqty]] */
  receivedqty: Option[BigDecimal],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.rejectedqty]] */
  rejectedqty: Option[BigDecimal],
  /** Points to [[purchasing.purchaseorderdetail.PurchaseorderdetailRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PodViewRow {
  implicit lazy val decoder: Decoder[PodViewRow] = Decoder.forProduct10[PodViewRow, Option[Int], Option[PurchaseorderheaderId], Option[Int], Option[TypoLocalDateTime], Option[Int], Option[ProductId], Option[BigDecimal], Option[BigDecimal], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "purchaseorderid", "purchaseorderdetailid", "duedate", "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate")(PodViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(PurchaseorderheaderId.decoder), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(ProductId.decoder), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[PodViewRow] = Encoder.forProduct10[PodViewRow, Option[Int], Option[PurchaseorderheaderId], Option[Int], Option[TypoLocalDateTime], Option[Int], Option[ProductId], Option[BigDecimal], Option[BigDecimal], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "purchaseorderid", "purchaseorderdetailid", "duedate", "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate")(x => (x.id, x.purchaseorderid, x.purchaseorderdetailid, x.duedate, x.orderqty, x.productid, x.unitprice, x.receivedqty, x.rejectedqty, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(PurchaseorderheaderId.encoder), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(ProductId.encoder), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit lazy val read: Read[PodViewRow] = new Read[PodViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (PurchaseorderheaderId.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (ProductId.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PodViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      purchaseorderid = PurchaseorderheaderId.get.unsafeGetNullable(rs, i + 1),
      purchaseorderdetailid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 2),
      duedate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 3),
      orderqty = Meta.IntMeta.get.unsafeGetNullable(rs, i + 4),
      productid = ProductId.get.unsafeGetNullable(rs, i + 5),
      unitprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 6),
      receivedqty = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 7),
      rejectedqty = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 8),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 9)
    )
  )
}
