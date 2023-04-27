/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.Defaulted
import adventureworks.public.Name
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `production.productcategory` which has not been persisted yet */
case class ProductcategoryRowUnsaved(
  /** Category description. */
  name: Name,
  /** Default: nextval('production.productcategory_productcategoryid_seq'::regclass)
      Primary key for ProductCategory records. */
  productcategoryid: Defaulted[ProductcategoryId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productcategoryidDefault: => ProductcategoryId, rowguidDefault: => UUID, modifieddateDefault: => LocalDateTime): ProductcategoryRow =
    ProductcategoryRow(
      name = name,
      productcategoryid = productcategoryid match {
                            case Defaulted.UseDefault => productcategoryidDefault
                            case Defaulted.Provided(value) => value
                          },
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
object ProductcategoryRowUnsaved {
  implicit val oFormat: OFormat[ProductcategoryRowUnsaved] = new OFormat[ProductcategoryRowUnsaved]{
    override def writes(o: ProductcategoryRowUnsaved): JsObject =
      Json.obj(
        "name" -> o.name,
        "productcategoryid" -> o.productcategoryid,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductcategoryRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ProductcategoryRowUnsaved(
            name = json.\("name").as[Name],
            productcategoryid = json.\("productcategoryid").as[Defaulted[ProductcategoryId]],
            rowguid = json.\("rowguid").as[Defaulted[UUID]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
