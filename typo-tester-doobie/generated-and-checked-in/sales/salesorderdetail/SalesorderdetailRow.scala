/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class SalesorderdetailRow(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Primary key. One incremental unique number per product sold. */
  salesorderdetailid: Int,
  /** Shipment tracking number supplied by the shipper. */
  carriertrackingnumber: Option[/* max 25 chars */ String],
  /** Quantity ordered per product. */
  orderqty: Int,
  /** Product sold to customer. Foreign key to Product.ProductID.
      Points to [[specialofferproduct.SpecialofferproductRow.productid]] */
  productid: ProductId,
  /** Promotional code. Foreign key to SpecialOffer.SpecialOfferID.
      Points to [[specialofferproduct.SpecialofferproductRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Selling price of a single product. */
  unitprice: BigDecimal,
  /** Discount amount. */
  unitpricediscount: BigDecimal,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalesorderdetailId = SalesorderdetailId(salesorderid, salesorderdetailid)
 }

object SalesorderdetailRow {
  implicit lazy val decoder: Decoder[SalesorderdetailRow] = Decoder.forProduct10[SalesorderdetailRow, SalesorderheaderId, Int, Option[/* max 25 chars */ String], Int, ProductId, SpecialofferId, BigDecimal, BigDecimal, UUID, TypoLocalDateTime]("salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate")(SalesorderdetailRow.apply)(SalesorderheaderId.decoder, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeInt, ProductId.decoder, SpecialofferId.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SalesorderdetailRow] = Encoder.forProduct10[SalesorderdetailRow, SalesorderheaderId, Int, Option[/* max 25 chars */ String], Int, ProductId, SpecialofferId, BigDecimal, BigDecimal, UUID, TypoLocalDateTime]("salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate")(x => (x.salesorderid, x.salesorderdetailid, x.carriertrackingnumber, x.orderqty, x.productid, x.specialofferid, x.unitprice, x.unitpricediscount, x.rowguid, x.modifieddate))(SalesorderheaderId.encoder, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeInt, ProductId.encoder, SpecialofferId.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SalesorderdetailRow] = new Read[SalesorderdetailRow](
    gets = List(
      (SalesorderheaderId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (SpecialofferId.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SalesorderdetailRow(
      salesorderid = SalesorderheaderId.get.unsafeGetNonNullable(rs, i + 0),
      salesorderdetailid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 1),
      carriertrackingnumber = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      orderqty = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 3),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 4),
      specialofferid = SpecialofferId.get.unsafeGetNonNullable(rs, i + 5),
      unitprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 6),
      unitpricediscount = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 7),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 8),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 9)
    )
  )
}
