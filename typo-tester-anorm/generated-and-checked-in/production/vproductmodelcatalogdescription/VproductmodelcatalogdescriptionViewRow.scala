/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductmodelcatalogdescription

import adventureworks.TypoLocalDateTime
import adventureworks.production.productmodel.ProductmodelId
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

case class VproductmodelcatalogdescriptionViewRow(
  /** Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[productmodel.ProductmodelRow.name]] */
  name: Option[Name],
  Summary: Option[String],
  manufacturer: Option[String],
  copyright: Option[/* max 30 chars */ String],
  producturl: Option[/* max 256 chars */ String],
  warrantyperiod: Option[/* max 256 chars */ String],
  warrantydescription: Option[/* max 256 chars */ String],
  noofyears: Option[/* max 256 chars */ String],
  maintenancedescription: Option[/* max 256 chars */ String],
  wheel: Option[/* max 256 chars */ String],
  saddle: Option[/* max 256 chars */ String],
  pedal: Option[/* max 256 chars */ String],
  bikeframe: Option[String],
  crankset: Option[/* max 256 chars */ String],
  pictureangle: Option[/* max 256 chars */ String],
  picturesize: Option[/* max 256 chars */ String],
  productphotoid: Option[/* max 256 chars */ String],
  material: Option[/* max 256 chars */ String],
  color: Option[/* max 256 chars */ String],
  productline: Option[/* max 256 chars */ String],
  style: Option[/* max 256 chars */ String],
  riderexperience: Option[/* max 1024 chars */ String],
  /** Points to [[productmodel.ProductmodelRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[productmodel.ProductmodelRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object VproductmodelcatalogdescriptionViewRow {
  implicit lazy val reads: Reads[VproductmodelcatalogdescriptionViewRow] = Reads[VproductmodelcatalogdescriptionViewRow](json => JsResult.fromTry(
      Try(
        VproductmodelcatalogdescriptionViewRow(
          productmodelid = json.\("productmodelid").toOption.map(_.as(ProductmodelId.reads)),
          name = json.\("name").toOption.map(_.as(Name.reads)),
          Summary = json.\("Summary").toOption.map(_.as(Reads.StringReads)),
          manufacturer = json.\("manufacturer").toOption.map(_.as(Reads.StringReads)),
          copyright = json.\("copyright").toOption.map(_.as(Reads.StringReads)),
          producturl = json.\("producturl").toOption.map(_.as(Reads.StringReads)),
          warrantyperiod = json.\("warrantyperiod").toOption.map(_.as(Reads.StringReads)),
          warrantydescription = json.\("warrantydescription").toOption.map(_.as(Reads.StringReads)),
          noofyears = json.\("noofyears").toOption.map(_.as(Reads.StringReads)),
          maintenancedescription = json.\("maintenancedescription").toOption.map(_.as(Reads.StringReads)),
          wheel = json.\("wheel").toOption.map(_.as(Reads.StringReads)),
          saddle = json.\("saddle").toOption.map(_.as(Reads.StringReads)),
          pedal = json.\("pedal").toOption.map(_.as(Reads.StringReads)),
          bikeframe = json.\("bikeframe").toOption.map(_.as(Reads.StringReads)),
          crankset = json.\("crankset").toOption.map(_.as(Reads.StringReads)),
          pictureangle = json.\("pictureangle").toOption.map(_.as(Reads.StringReads)),
          picturesize = json.\("picturesize").toOption.map(_.as(Reads.StringReads)),
          productphotoid = json.\("productphotoid").toOption.map(_.as(Reads.StringReads)),
          material = json.\("material").toOption.map(_.as(Reads.StringReads)),
          color = json.\("color").toOption.map(_.as(Reads.StringReads)),
          productline = json.\("productline").toOption.map(_.as(Reads.StringReads)),
          style = json.\("style").toOption.map(_.as(Reads.StringReads)),
          riderexperience = json.\("riderexperience").toOption.map(_.as(Reads.StringReads)),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VproductmodelcatalogdescriptionViewRow] = RowParser[VproductmodelcatalogdescriptionViewRow] { row =>
    Success(
      VproductmodelcatalogdescriptionViewRow(
        productmodelid = row(idx + 0)(Column.columnToOption(ProductmodelId.column)),
        name = row(idx + 1)(Column.columnToOption(Name.column)),
        Summary = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        manufacturer = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        copyright = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        producturl = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        warrantyperiod = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        warrantydescription = row(idx + 7)(Column.columnToOption(Column.columnToString)),
        noofyears = row(idx + 8)(Column.columnToOption(Column.columnToString)),
        maintenancedescription = row(idx + 9)(Column.columnToOption(Column.columnToString)),
        wheel = row(idx + 10)(Column.columnToOption(Column.columnToString)),
        saddle = row(idx + 11)(Column.columnToOption(Column.columnToString)),
        pedal = row(idx + 12)(Column.columnToOption(Column.columnToString)),
        bikeframe = row(idx + 13)(Column.columnToOption(Column.columnToString)),
        crankset = row(idx + 14)(Column.columnToOption(Column.columnToString)),
        pictureangle = row(idx + 15)(Column.columnToOption(Column.columnToString)),
        picturesize = row(idx + 16)(Column.columnToOption(Column.columnToString)),
        productphotoid = row(idx + 17)(Column.columnToOption(Column.columnToString)),
        material = row(idx + 18)(Column.columnToOption(Column.columnToString)),
        color = row(idx + 19)(Column.columnToOption(Column.columnToString)),
        productline = row(idx + 20)(Column.columnToOption(Column.columnToString)),
        style = row(idx + 21)(Column.columnToOption(Column.columnToString)),
        riderexperience = row(idx + 22)(Column.columnToOption(Column.columnToString)),
        rowguid = row(idx + 23)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 24)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[VproductmodelcatalogdescriptionViewRow] = OWrites[VproductmodelcatalogdescriptionViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productmodelid" -> Writes.OptionWrites(ProductmodelId.writes).writes(o.productmodelid),
      "name" -> Writes.OptionWrites(Name.writes).writes(o.name),
      "Summary" -> Writes.OptionWrites(Writes.StringWrites).writes(o.Summary),
      "manufacturer" -> Writes.OptionWrites(Writes.StringWrites).writes(o.manufacturer),
      "copyright" -> Writes.OptionWrites(Writes.StringWrites).writes(o.copyright),
      "producturl" -> Writes.OptionWrites(Writes.StringWrites).writes(o.producturl),
      "warrantyperiod" -> Writes.OptionWrites(Writes.StringWrites).writes(o.warrantyperiod),
      "warrantydescription" -> Writes.OptionWrites(Writes.StringWrites).writes(o.warrantydescription),
      "noofyears" -> Writes.OptionWrites(Writes.StringWrites).writes(o.noofyears),
      "maintenancedescription" -> Writes.OptionWrites(Writes.StringWrites).writes(o.maintenancedescription),
      "wheel" -> Writes.OptionWrites(Writes.StringWrites).writes(o.wheel),
      "saddle" -> Writes.OptionWrites(Writes.StringWrites).writes(o.saddle),
      "pedal" -> Writes.OptionWrites(Writes.StringWrites).writes(o.pedal),
      "bikeframe" -> Writes.OptionWrites(Writes.StringWrites).writes(o.bikeframe),
      "crankset" -> Writes.OptionWrites(Writes.StringWrites).writes(o.crankset),
      "pictureangle" -> Writes.OptionWrites(Writes.StringWrites).writes(o.pictureangle),
      "picturesize" -> Writes.OptionWrites(Writes.StringWrites).writes(o.picturesize),
      "productphotoid" -> Writes.OptionWrites(Writes.StringWrites).writes(o.productphotoid),
      "material" -> Writes.OptionWrites(Writes.StringWrites).writes(o.material),
      "color" -> Writes.OptionWrites(Writes.StringWrites).writes(o.color),
      "productline" -> Writes.OptionWrites(Writes.StringWrites).writes(o.productline),
      "style" -> Writes.OptionWrites(Writes.StringWrites).writes(o.style),
      "riderexperience" -> Writes.OptionWrites(Writes.StringWrites).writes(o.riderexperience),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
