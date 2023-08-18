/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import anorm.Column
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class AddresstypeRow(
  /** Primary key for AddressType records. */
  addresstypeid: AddresstypeId,
  /** Address type description. For example, Billing, Home, or Shipping. */
  name: Name,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object AddresstypeRow {
  implicit lazy val reads: Reads[AddresstypeRow] = Reads[AddresstypeRow](json => JsResult.fromTry(
      Try(
        AddresstypeRow(
          addresstypeid = json.\("addresstypeid").as(AddresstypeId.reads),
          name = json.\("name").as(Name.reads),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[AddresstypeRow] = RowParser[AddresstypeRow] { row =>
    Success(
      AddresstypeRow(
        addresstypeid = row(idx + 0)(AddresstypeId.column),
        name = row(idx + 1)(Name.column),
        rowguid = row(idx + 2)(Column.columnToUUID),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[AddresstypeRow] = OWrites[AddresstypeRow](o =>
    new JsObject(ListMap[String, JsValue](
      "addresstypeid" -> AddresstypeId.writes.writes(o.addresstypeid),
      "name" -> Name.writes.writes(o.name),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
