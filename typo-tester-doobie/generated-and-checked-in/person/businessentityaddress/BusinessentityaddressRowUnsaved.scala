/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.address.AddressId
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.businessentity.BusinessentityId
import io.circe.Decoder
import io.circe.Encoder
import java.util.UUID

/** This class corresponds to a row in table `person.businessentityaddress` which has not been persisted yet */
case class BusinessentityaddressRowUnsaved(
  /** Primary key. Foreign key to BusinessEntity.BusinessEntityID.
      Points to [[businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary key. Foreign key to Address.AddressID.
      Points to [[address.AddressRow.addressid]] */
  addressid: AddressId,
  /** Primary key. Foreign key to AddressType.AddressTypeID.
      Points to [[addresstype.AddresstypeRow.addresstypeid]] */
  addresstypeid: AddresstypeId,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): BusinessentityaddressRow =
    BusinessentityaddressRow(
      businessentityid = businessentityid,
      addressid = addressid,
      addresstypeid = addresstypeid,
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object BusinessentityaddressRowUnsaved {
  implicit lazy val decoder: Decoder[BusinessentityaddressRowUnsaved] = Decoder.forProduct5[BusinessentityaddressRowUnsaved, BusinessentityId, AddressId, AddresstypeId, Defaulted[UUID], Defaulted[TypoLocalDateTime]]("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")(BusinessentityaddressRowUnsaved.apply)(BusinessentityId.decoder, AddressId.decoder, AddresstypeId.decoder, Defaulted.decoder(Decoder.decodeUUID), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[BusinessentityaddressRowUnsaved] = Encoder.forProduct5[BusinessentityaddressRowUnsaved, BusinessentityId, AddressId, AddresstypeId, Defaulted[UUID], Defaulted[TypoLocalDateTime]]("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")(x => (x.businessentityid, x.addressid, x.addresstypeid, x.rowguid, x.modifieddate))(BusinessentityId.encoder, AddressId.encoder, AddresstypeId.encoder, Defaulted.encoder(Encoder.encodeUUID), Defaulted.encoder(TypoLocalDateTime.encoder))
}
