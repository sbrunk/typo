/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
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

case class PasswordRow(
  /** Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Password for the e-mail account. */
  passwordhash: /* max 128 chars */ String,
  /** Random value concatenated with the password string before the password is hashed. */
  passwordsalt: /* max 10 chars */ String,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object PasswordRow {
  implicit lazy val reads: Reads[PasswordRow] = Reads[PasswordRow](json => JsResult.fromTry(
      Try(
        PasswordRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          passwordhash = json.\("passwordhash").as(Reads.StringReads),
          passwordsalt = json.\("passwordsalt").as(Reads.StringReads),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PasswordRow] = RowParser[PasswordRow] { row =>
    Success(
      PasswordRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        passwordhash = row(idx + 1)(Column.columnToString),
        passwordsalt = row(idx + 2)(Column.columnToString),
        rowguid = row(idx + 3)(Column.columnToUUID),
        modifieddate = row(idx + 4)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[PasswordRow] = OWrites[PasswordRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "passwordhash" -> Writes.StringWrites.writes(o.passwordhash),
      "passwordsalt" -> Writes.StringWrites.writes(o.passwordsalt),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
