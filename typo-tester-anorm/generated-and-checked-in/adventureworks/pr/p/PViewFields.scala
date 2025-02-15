/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package p

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.product.ProductId
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait PViewFields[Row] {
  val id: Field[ProductId, Row]
  val productid: Field[ProductId, Row]
  val name: Field[Name, Row]
  val productnumber: Field[/* max 25 chars */ String, Row]
  val makeflag: Field[Flag, Row]
  val finishedgoodsflag: Field[Flag, Row]
  val color: OptField[/* max 15 chars */ String, Row]
  val safetystocklevel: Field[TypoShort, Row]
  val reorderpoint: Field[TypoShort, Row]
  val standardcost: Field[BigDecimal, Row]
  val listprice: Field[BigDecimal, Row]
  val size: OptField[/* max 5 chars */ String, Row]
  val sizeunitmeasurecode: OptField[UnitmeasureId, Row]
  val weightunitmeasurecode: OptField[UnitmeasureId, Row]
  val weight: OptField[BigDecimal, Row]
  val daystomanufacture: Field[Int, Row]
  val productline: OptField[/* bpchar, max 2 chars */ String, Row]
  val `class`: OptField[/* bpchar, max 2 chars */ String, Row]
  val style: OptField[/* bpchar, max 2 chars */ String, Row]
  val productsubcategoryid: OptField[ProductsubcategoryId, Row]
  val productmodelid: OptField[ProductmodelId, Row]
  val sellstartdate: Field[TypoLocalDateTime, Row]
  val sellenddate: OptField[TypoLocalDateTime, Row]
  val discontinueddate: OptField[TypoLocalDateTime, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object PViewFields extends PViewStructure[PViewRow](None, identity, (_, x) => x)

