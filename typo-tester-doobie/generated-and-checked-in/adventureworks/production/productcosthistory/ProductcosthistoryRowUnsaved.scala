/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.productcosthistory` which has not been persisted yet */
case class ProductcosthistoryRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Product cost start date.
      Constraint CK_ProductCostHistory_EndDate affecting columns "enddate", "startdate":  (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Product cost end date.
      Constraint CK_ProductCostHistory_EndDate affecting columns "enddate", "startdate":  (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Standard cost of the product.
      Constraint CK_ProductCostHistory_StandardCost affecting columns "standardcost":  ((standardcost >= 0.00)) */
  standardcost: BigDecimal,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): ProductcosthistoryRow =
    ProductcosthistoryRow(
      productid = productid,
      startdate = startdate,
      enddate = enddate,
      standardcost = standardcost,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductcosthistoryRowUnsaved {
  implicit lazy val decoder: Decoder[ProductcosthistoryRowUnsaved] = Decoder.forProduct5[ProductcosthistoryRowUnsaved, ProductId, TypoLocalDateTime, Option[TypoLocalDateTime], BigDecimal, Defaulted[TypoLocalDateTime]]("productid", "startdate", "enddate", "standardcost", "modifieddate")(ProductcosthistoryRowUnsaved.apply)(ProductId.decoder, TypoLocalDateTime.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeBigDecimal, Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[ProductcosthistoryRowUnsaved] = Encoder.forProduct5[ProductcosthistoryRowUnsaved, ProductId, TypoLocalDateTime, Option[TypoLocalDateTime], BigDecimal, Defaulted[TypoLocalDateTime]]("productid", "startdate", "enddate", "standardcost", "modifieddate")(x => (x.productid, x.startdate, x.enddate, x.standardcost, x.modifieddate))(ProductId.encoder, TypoLocalDateTime.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeBigDecimal, Defaulted.encoder(TypoLocalDateTime.encoder))
}
