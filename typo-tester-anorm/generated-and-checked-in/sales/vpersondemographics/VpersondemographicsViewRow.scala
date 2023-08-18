/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vpersondemographics

import adventureworks.TypoLocalDate
import adventureworks.TypoMoney
import adventureworks.person.businessentity.BusinessentityId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class VpersondemographicsViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  totalpurchaseytd: Option[TypoMoney],
  datefirstpurchase: Option[TypoLocalDate],
  birthdate: Option[TypoLocalDate],
  maritalstatus: Option[/* max 1 chars */ String],
  yearlyincome: Option[/* max 30 chars */ String],
  gender: Option[/* max 1 chars */ String],
  totalchildren: Option[Int],
  numberchildrenathome: Option[Int],
  education: Option[/* max 30 chars */ String],
  occupation: Option[/* max 30 chars */ String],
  homeownerflag: Option[Boolean],
  numbercarsowned: Option[Int]
)

object VpersondemographicsViewRow {
  implicit lazy val reads: Reads[VpersondemographicsViewRow] = Reads[VpersondemographicsViewRow](json => JsResult.fromTry(
      Try(
        VpersondemographicsViewRow(
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          totalpurchaseytd = json.\("totalpurchaseytd").toOption.map(_.as(TypoMoney.reads)),
          datefirstpurchase = json.\("datefirstpurchase").toOption.map(_.as(TypoLocalDate.reads)),
          birthdate = json.\("birthdate").toOption.map(_.as(TypoLocalDate.reads)),
          maritalstatus = json.\("maritalstatus").toOption.map(_.as(Reads.StringReads)),
          yearlyincome = json.\("yearlyincome").toOption.map(_.as(Reads.StringReads)),
          gender = json.\("gender").toOption.map(_.as(Reads.StringReads)),
          totalchildren = json.\("totalchildren").toOption.map(_.as(Reads.IntReads)),
          numberchildrenathome = json.\("numberchildrenathome").toOption.map(_.as(Reads.IntReads)),
          education = json.\("education").toOption.map(_.as(Reads.StringReads)),
          occupation = json.\("occupation").toOption.map(_.as(Reads.StringReads)),
          homeownerflag = json.\("homeownerflag").toOption.map(_.as(Reads.BooleanReads)),
          numbercarsowned = json.\("numbercarsowned").toOption.map(_.as(Reads.IntReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VpersondemographicsViewRow] = RowParser[VpersondemographicsViewRow] { row =>
    Success(
      VpersondemographicsViewRow(
        businessentityid = row(idx + 0)(Column.columnToOption(BusinessentityId.column)),
        totalpurchaseytd = row(idx + 1)(Column.columnToOption(TypoMoney.column)),
        datefirstpurchase = row(idx + 2)(Column.columnToOption(TypoLocalDate.column)),
        birthdate = row(idx + 3)(Column.columnToOption(TypoLocalDate.column)),
        maritalstatus = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        yearlyincome = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        gender = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        totalchildren = row(idx + 7)(Column.columnToOption(Column.columnToInt)),
        numberchildrenathome = row(idx + 8)(Column.columnToOption(Column.columnToInt)),
        education = row(idx + 9)(Column.columnToOption(Column.columnToString)),
        occupation = row(idx + 10)(Column.columnToOption(Column.columnToString)),
        homeownerflag = row(idx + 11)(Column.columnToOption(Column.columnToBoolean)),
        numbercarsowned = row(idx + 12)(Column.columnToOption(Column.columnToInt))
      )
    )
  }
  implicit lazy val writes: OWrites[VpersondemographicsViewRow] = OWrites[VpersondemographicsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "totalpurchaseytd" -> Writes.OptionWrites(TypoMoney.writes).writes(o.totalpurchaseytd),
      "datefirstpurchase" -> Writes.OptionWrites(TypoLocalDate.writes).writes(o.datefirstpurchase),
      "birthdate" -> Writes.OptionWrites(TypoLocalDate.writes).writes(o.birthdate),
      "maritalstatus" -> Writes.OptionWrites(Writes.StringWrites).writes(o.maritalstatus),
      "yearlyincome" -> Writes.OptionWrites(Writes.StringWrites).writes(o.yearlyincome),
      "gender" -> Writes.OptionWrites(Writes.StringWrites).writes(o.gender),
      "totalchildren" -> Writes.OptionWrites(Writes.IntWrites).writes(o.totalchildren),
      "numberchildrenathome" -> Writes.OptionWrites(Writes.IntWrites).writes(o.numberchildrenathome),
      "education" -> Writes.OptionWrites(Writes.StringWrites).writes(o.education),
      "occupation" -> Writes.OptionWrites(Writes.StringWrites).writes(o.occupation),
      "homeownerflag" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.homeownerflag),
      "numbercarsowned" -> Writes.OptionWrites(Writes.IntWrites).writes(o.numbercarsowned)
    ))
  )
}
