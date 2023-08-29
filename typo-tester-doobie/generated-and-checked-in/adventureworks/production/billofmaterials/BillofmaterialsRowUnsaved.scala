/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.billofmaterials` which has not been persisted yet */
case class BillofmaterialsRowUnsaved(
  /** Parent product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productassemblyid: Option[ProductId],
  /** Component identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  componentid: ProductId,
  /** Date the component stopped being used in the assembly item. */
  enddate: Option[TypoLocalDateTime],
  /** Standard code identifying the unit of measure for the quantity.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Indicates the depth the component is from its parent (AssemblyID). */
  bomlevel: TypoShort,
  /** Default: nextval('production.billofmaterials_billofmaterialsid_seq'::regclass)
      Primary key for BillOfMaterials records. */
  billofmaterialsid: Defaulted[BillofmaterialsId] = Defaulted.UseDefault,
  /** Default: now()
      Date the component started being used in the assembly item. */
  startdate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: 1.00
      Quantity of the component needed to create the assembly. */
  perassemblyqty: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(billofmaterialsidDefault: => BillofmaterialsId, startdateDefault: => TypoLocalDateTime, perassemblyqtyDefault: => BigDecimal, modifieddateDefault: => TypoLocalDateTime): BillofmaterialsRow =
    BillofmaterialsRow(
      productassemblyid = productassemblyid,
      componentid = componentid,
      enddate = enddate,
      unitmeasurecode = unitmeasurecode,
      bomlevel = bomlevel,
      billofmaterialsid = billofmaterialsid match {
                            case Defaulted.UseDefault => billofmaterialsidDefault
                            case Defaulted.Provided(value) => value
                          },
      startdate = startdate match {
                    case Defaulted.UseDefault => startdateDefault
                    case Defaulted.Provided(value) => value
                  },
      perassemblyqty = perassemblyqty match {
                         case Defaulted.UseDefault => perassemblyqtyDefault
                         case Defaulted.Provided(value) => value
                       },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object BillofmaterialsRowUnsaved {
  implicit lazy val decoder: Decoder[BillofmaterialsRowUnsaved] = Decoder.forProduct9[BillofmaterialsRowUnsaved, Option[ProductId], ProductId, Option[TypoLocalDateTime], UnitmeasureId, TypoShort, Defaulted[BillofmaterialsId], Defaulted[TypoLocalDateTime], Defaulted[BigDecimal], Defaulted[TypoLocalDateTime]]("productassemblyid", "componentid", "enddate", "unitmeasurecode", "bomlevel", "billofmaterialsid", "startdate", "perassemblyqty", "modifieddate")(BillofmaterialsRowUnsaved.apply)(Decoder.decodeOption(ProductId.decoder), ProductId.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), UnitmeasureId.decoder, TypoShort.decoder, Defaulted.decoder(BillofmaterialsId.decoder), Defaulted.decoder(TypoLocalDateTime.decoder), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[BillofmaterialsRowUnsaved] = Encoder.forProduct9[BillofmaterialsRowUnsaved, Option[ProductId], ProductId, Option[TypoLocalDateTime], UnitmeasureId, TypoShort, Defaulted[BillofmaterialsId], Defaulted[TypoLocalDateTime], Defaulted[BigDecimal], Defaulted[TypoLocalDateTime]]("productassemblyid", "componentid", "enddate", "unitmeasurecode", "bomlevel", "billofmaterialsid", "startdate", "perassemblyqty", "modifieddate")(x => (x.productassemblyid, x.componentid, x.enddate, x.unitmeasurecode, x.bomlevel, x.billofmaterialsid, x.startdate, x.perassemblyqty, x.modifieddate))(Encoder.encodeOption(ProductId.encoder), ProductId.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), UnitmeasureId.encoder, TypoShort.encoder, Defaulted.encoder(BillofmaterialsId.encoder), Defaulted.encoder(TypoLocalDateTime.encoder), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(TypoLocalDateTime.encoder))
}
