/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ProductmodelRow(
  /** Primary key for ProductModel records. */
  productmodelid: ProductmodelId,
  /** Product model description. */
  name: Name,
  /** Detailed product catalog information in xml format. */
  catalogdescription: Option[TypoXml],
  /** Manufacturing instructions in xml format. */
  instructions: Option[TypoXml],
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
)

object ProductmodelRow {
  implicit lazy val decoder: Decoder[ProductmodelRow] = Decoder.forProduct6[ProductmodelRow, ProductmodelId, Name, Option[TypoXml], Option[TypoXml], TypoUUID, TypoLocalDateTime]("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")(ProductmodelRow.apply)(ProductmodelId.decoder, Name.decoder, Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[ProductmodelRow] = Encoder.forProduct6[ProductmodelRow, ProductmodelId, Name, Option[TypoXml], Option[TypoXml], TypoUUID, TypoLocalDateTime]("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")(x => (x.productmodelid, x.name, x.catalogdescription, x.instructions, x.rowguid, x.modifieddate))(ProductmodelId.encoder, Name.encoder, Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[ProductmodelRow] = new Read[ProductmodelRow](
    gets = List(
      (ProductmodelId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ProductmodelRow(
      productmodelid = ProductmodelId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      catalogdescription = TypoXml.get.unsafeGetNullable(rs, i + 2),
      instructions = TypoXml.get.unsafeGetNullable(rs, i + 3),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
}
