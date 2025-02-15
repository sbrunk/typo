/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.productphoto` which has not been persisted yet */
case class ProductphotoRowUnsaved(
  /** Small image of the product. */
  thumbnailphoto: Option[TypoBytea],
  /** Small image file name. */
  thumbnailphotofilename: Option[/* max 50 chars */ String],
  /** Large image of the product. */
  largephoto: Option[TypoBytea],
  /** Large image file name. */
  largephotofilename: Option[/* max 50 chars */ String],
  /** Default: nextval('production.productphoto_productphotoid_seq'::regclass)
      Primary key for ProductPhoto records. */
  productphotoid: Defaulted[ProductphotoId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productphotoidDefault: => ProductphotoId, modifieddateDefault: => TypoLocalDateTime): ProductphotoRow =
    ProductphotoRow(
      thumbnailphoto = thumbnailphoto,
      thumbnailphotofilename = thumbnailphotofilename,
      largephoto = largephoto,
      largephotofilename = largephotofilename,
      productphotoid = productphotoid match {
                         case Defaulted.UseDefault => productphotoidDefault
                         case Defaulted.Provided(value) => value
                       },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductphotoRowUnsaved {
  implicit lazy val decoder: Decoder[ProductphotoRowUnsaved] = Decoder.forProduct6[ProductphotoRowUnsaved, Option[TypoBytea], Option[/* max 50 chars */ String], Option[TypoBytea], Option[/* max 50 chars */ String], Defaulted[ProductphotoId], Defaulted[TypoLocalDateTime]]("thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "productphotoid", "modifieddate")(ProductphotoRowUnsaved.apply)(Decoder.decodeOption(TypoBytea.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoBytea.decoder), Decoder.decodeOption(Decoder.decodeString), Defaulted.decoder(ProductphotoId.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[ProductphotoRowUnsaved] = Encoder.forProduct6[ProductphotoRowUnsaved, Option[TypoBytea], Option[/* max 50 chars */ String], Option[TypoBytea], Option[/* max 50 chars */ String], Defaulted[ProductphotoId], Defaulted[TypoLocalDateTime]]("thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "productphotoid", "modifieddate")(x => (x.thumbnailphoto, x.thumbnailphotofilename, x.largephoto, x.largephotofilename, x.productphotoid, x.modifieddate))(Encoder.encodeOption(TypoBytea.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoBytea.encoder), Encoder.encodeOption(Encoder.encodeString), Defaulted.encoder(ProductphotoId.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
}
