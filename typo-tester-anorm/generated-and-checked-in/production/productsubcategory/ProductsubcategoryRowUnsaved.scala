/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.Name
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `production.productsubcategory` which has not been persisted yet */
case class ProductsubcategoryRowUnsaved(
  /** Product category identification number. Foreign key to ProductCategory.ProductCategoryID.
      Points to [[productcategory.ProductcategoryRow.productcategoryid]] */
  productcategoryid: ProductcategoryId,
  /** Subcategory description. */
  name: Name,
  /** Default: nextval('production.productsubcategory_productsubcategoryid_seq'::regclass)
      Primary key for ProductSubcategory records. */
  productsubcategoryid: Defaulted[ProductsubcategoryId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productsubcategoryidDefault: => ProductsubcategoryId, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): ProductsubcategoryRow =
    ProductsubcategoryRow(
      productcategoryid = productcategoryid,
      name = name,
      productsubcategoryid = productsubcategoryid match {
                               case Defaulted.UseDefault => productsubcategoryidDefault
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
object ProductsubcategoryRowUnsaved {
  implicit lazy val reads: Reads[ProductsubcategoryRowUnsaved] = Reads[ProductsubcategoryRowUnsaved](json => JsResult.fromTry(
      Try(
        ProductsubcategoryRowUnsaved(
          productcategoryid = json.\("productcategoryid").as(ProductcategoryId.reads),
          name = json.\("name").as(Name.reads),
          productsubcategoryid = json.\("productsubcategoryid").as(Defaulted.reads(ProductsubcategoryId.reads)),
          rowguid = json.\("rowguid").as(Defaulted.reads(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[ProductsubcategoryRowUnsaved] = OWrites[ProductsubcategoryRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "productcategoryid" -> ProductcategoryId.writes.writes(o.productcategoryid),
      "name" -> Name.writes.writes(o.name),
      "productsubcategoryid" -> Defaulted.writes(ProductsubcategoryId.writes).writes(o.productsubcategoryid),
      "rowguid" -> Defaulted.writes(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
