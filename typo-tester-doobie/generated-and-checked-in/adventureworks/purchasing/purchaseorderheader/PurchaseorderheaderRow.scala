/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderheader

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.purchasing.shipmethod.ShipmethodId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PurchaseorderheaderRow(
  /** Primary key. */
  purchaseorderid: PurchaseorderheaderId,
  /** Incremental number to track changes to the purchase order over time. */
  revisionnumber: TypoShort,
  /** Order current status. 1 = Pending; 2 = Approved; 3 = Rejected; 4 = Complete */
  status: TypoShort,
  /** Employee who created the purchase order. Foreign key to Employee.BusinessEntityID.
      Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  employeeid: BusinessentityId,
  /** Vendor with whom the purchase order is placed. Foreign key to Vendor.BusinessEntityID.
      Points to [[vendor.VendorRow.businessentityid]] */
  vendorid: BusinessentityId,
  /** Shipping method. Foreign key to ShipMethod.ShipMethodID.
      Points to [[shipmethod.ShipmethodRow.shipmethodid]] */
  shipmethodid: ShipmethodId,
  /** Purchase order creation date. */
  orderdate: TypoLocalDateTime,
  /** Estimated shipment date from the vendor. */
  shipdate: Option[TypoLocalDateTime],
  /** Purchase order subtotal. Computed as SUM(PurchaseOrderDetail.LineTotal)for the appropriate PurchaseOrderID. */
  subtotal: BigDecimal,
  /** Tax amount. */
  taxamt: BigDecimal,
  /** Shipping cost. */
  freight: BigDecimal,
  modifieddate: TypoLocalDateTime
)

object PurchaseorderheaderRow {
  implicit lazy val decoder: Decoder[PurchaseorderheaderRow] = Decoder.forProduct12[PurchaseorderheaderRow, PurchaseorderheaderId, TypoShort, TypoShort, BusinessentityId, BusinessentityId, ShipmethodId, TypoLocalDateTime, Option[TypoLocalDateTime], BigDecimal, BigDecimal, BigDecimal, TypoLocalDateTime]("purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate")(PurchaseorderheaderRow.apply)(PurchaseorderheaderId.decoder, TypoShort.decoder, TypoShort.decoder, BusinessentityId.decoder, BusinessentityId.decoder, ShipmethodId.decoder, TypoLocalDateTime.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PurchaseorderheaderRow] = Encoder.forProduct12[PurchaseorderheaderRow, PurchaseorderheaderId, TypoShort, TypoShort, BusinessentityId, BusinessentityId, ShipmethodId, TypoLocalDateTime, Option[TypoLocalDateTime], BigDecimal, BigDecimal, BigDecimal, TypoLocalDateTime]("purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate")(x => (x.purchaseorderid, x.revisionnumber, x.status, x.employeeid, x.vendorid, x.shipmethodid, x.orderdate, x.shipdate, x.subtotal, x.taxamt, x.freight, x.modifieddate))(PurchaseorderheaderId.encoder, TypoShort.encoder, TypoShort.encoder, BusinessentityId.encoder, BusinessentityId.encoder, ShipmethodId.encoder, TypoLocalDateTime.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PurchaseorderheaderRow] = new Read[PurchaseorderheaderRow](
    gets = List(
      (PurchaseorderheaderId.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (ShipmethodId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PurchaseorderheaderRow(
      purchaseorderid = PurchaseorderheaderId.get.unsafeGetNonNullable(rs, i + 0),
      revisionnumber = TypoShort.get.unsafeGetNonNullable(rs, i + 1),
      status = TypoShort.get.unsafeGetNonNullable(rs, i + 2),
      employeeid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 3),
      vendorid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 4),
      shipmethodid = ShipmethodId.get.unsafeGetNonNullable(rs, i + 5),
      orderdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6),
      shipdate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 7),
      subtotal = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 8),
      taxamt = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 9),
      freight = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 10),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 11)
    )
  )
}
