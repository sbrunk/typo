/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterMetaData
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object ProductRepoImpl extends ProductRepo {
  override def delete(productid: ProductId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.product where "productid" = ${ParameterValue(productid, null, ProductId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[ProductFields, ProductRow] = {
    DeleteBuilder("production.product", ProductFields)
  }
  override def insert(unsaved: ProductRow)(implicit c: Connection): ProductRow = {
    SQL"""insert into production.product("productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.productnumber, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.makeflag, null, Flag.toStatement)}::bool, ${ParameterValue(unsaved.finishedgoodsflag, null, Flag.toStatement)}::bool, ${ParameterValue(unsaved.color, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.safetystocklevel, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.reorderpoint, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.standardcost, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.listprice, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.size, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.sizeunitmeasurecode, null, ToStatement.optionToStatement(UnitmeasureId.toStatement, UnitmeasureId.parameterMetadata))}::bpchar, ${ParameterValue(unsaved.weightunitmeasurecode, null, ToStatement.optionToStatement(UnitmeasureId.toStatement, UnitmeasureId.parameterMetadata))}::bpchar, ${ParameterValue(unsaved.weight, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric, ${ParameterValue(unsaved.daystomanufacture, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.productline, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}::bpchar, ${ParameterValue(unsaved.`class`, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}::bpchar, ${ParameterValue(unsaved.style, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}::bpchar, ${ParameterValue(unsaved.productsubcategoryid, null, ToStatement.optionToStatement(ProductsubcategoryId.toStatement, ProductsubcategoryId.parameterMetadata))}::int4, ${ParameterValue(unsaved.productmodelid, null, ToStatement.optionToStatement(ProductmodelId.toStatement, ProductmodelId.parameterMetadata))}::int4, ${ParameterValue(unsaved.sellstartdate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.sellenddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp, ${ParameterValue(unsaved.discontinueddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp, ${ParameterValue(unsaved.rowguid, null, ToStatement.uuidToStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
       """
      .executeInsert(ProductRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductRowUnsaved)(implicit c: Connection): ProductRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      Some((NamedParameter("productnumber", ParameterValue(unsaved.productnumber, null, ToStatement.stringToStatement)), "")),
      Some((NamedParameter("color", ParameterValue(unsaved.color, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      Some((NamedParameter("safetystocklevel", ParameterValue(unsaved.safetystocklevel, null, TypoShort.toStatement)), "::int2")),
      Some((NamedParameter("reorderpoint", ParameterValue(unsaved.reorderpoint, null, TypoShort.toStatement)), "::int2")),
      Some((NamedParameter("standardcost", ParameterValue(unsaved.standardcost, null, ToStatement.scalaBigDecimalToStatement)), "::numeric")),
      Some((NamedParameter("listprice", ParameterValue(unsaved.listprice, null, ToStatement.scalaBigDecimalToStatement)), "::numeric")),
      Some((NamedParameter("size", ParameterValue(unsaved.size, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      Some((NamedParameter("sizeunitmeasurecode", ParameterValue(unsaved.sizeunitmeasurecode, null, ToStatement.optionToStatement(UnitmeasureId.toStatement, UnitmeasureId.parameterMetadata))), "::bpchar")),
      Some((NamedParameter("weightunitmeasurecode", ParameterValue(unsaved.weightunitmeasurecode, null, ToStatement.optionToStatement(UnitmeasureId.toStatement, UnitmeasureId.parameterMetadata))), "::bpchar")),
      Some((NamedParameter("weight", ParameterValue(unsaved.weight, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))), "::numeric")),
      Some((NamedParameter("daystomanufacture", ParameterValue(unsaved.daystomanufacture, null, ToStatement.intToStatement)), "::int4")),
      Some((NamedParameter("productline", ParameterValue(unsaved.productline, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "::bpchar")),
      Some((NamedParameter("class", ParameterValue(unsaved.`class`, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "::bpchar")),
      Some((NamedParameter("style", ParameterValue(unsaved.style, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "::bpchar")),
      Some((NamedParameter("productsubcategoryid", ParameterValue(unsaved.productsubcategoryid, null, ToStatement.optionToStatement(ProductsubcategoryId.toStatement, ProductsubcategoryId.parameterMetadata))), "::int4")),
      Some((NamedParameter("productmodelid", ParameterValue(unsaved.productmodelid, null, ToStatement.optionToStatement(ProductmodelId.toStatement, ProductmodelId.parameterMetadata))), "::int4")),
      Some((NamedParameter("sellstartdate", ParameterValue(unsaved.sellstartdate, null, TypoLocalDateTime.toStatement)), "::timestamp")),
      Some((NamedParameter("sellenddate", ParameterValue(unsaved.sellenddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))), "::timestamp")),
      Some((NamedParameter("discontinueddate", ParameterValue(unsaved.discontinueddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))), "::timestamp")),
      unsaved.productid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("productid", ParameterValue(value, null, ProductId.toStatement)), "::int4"))
      },
      unsaved.makeflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("makeflag", ParameterValue(value, null, Flag.toStatement)), "::bool"))
      },
      unsaved.finishedgoodsflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("finishedgoodsflag", ParameterValue(value, null, Flag.toStatement)), "::bool"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue(value, null, ToStatement.uuidToStatement)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.product default values
            returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
         """
        .executeInsert(ProductRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.product(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ProductRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[ProductFields, ProductRow] = {
    SelectBuilderSql("production.product", ProductFields, ProductRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductRow] = {
    SQL"""select "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
          from production.product
       """.as(ProductRow.rowParser(1).*)
  }
  override def selectById(productid: ProductId)(implicit c: Connection): Option[ProductRow] = {
    SQL"""select "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
          from production.product
          where "productid" = ${ParameterValue(productid, null, ProductId.toStatement)}
       """.as(ProductRow.rowParser(1).singleOpt)
  }
  override def selectByIds(productids: Array[ProductId])(implicit c: Connection): List[ProductRow] = {
    SQL"""select "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
          from production.product
          where "productid" = ANY(${productids})
       """.as(ProductRow.rowParser(1).*)
    
  }
  override def update(row: ProductRow)(implicit c: Connection): Boolean = {
    val productid = row.productid
    SQL"""update production.product
          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "productnumber" = ${ParameterValue(row.productnumber, null, ToStatement.stringToStatement)},
              "makeflag" = ${ParameterValue(row.makeflag, null, Flag.toStatement)}::bool,
              "finishedgoodsflag" = ${ParameterValue(row.finishedgoodsflag, null, Flag.toStatement)}::bool,
              "color" = ${ParameterValue(row.color, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              "safetystocklevel" = ${ParameterValue(row.safetystocklevel, null, TypoShort.toStatement)}::int2,
              "reorderpoint" = ${ParameterValue(row.reorderpoint, null, TypoShort.toStatement)}::int2,
              "standardcost" = ${ParameterValue(row.standardcost, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "listprice" = ${ParameterValue(row.listprice, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "size" = ${ParameterValue(row.size, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              "sizeunitmeasurecode" = ${ParameterValue(row.sizeunitmeasurecode, null, ToStatement.optionToStatement(UnitmeasureId.toStatement, UnitmeasureId.parameterMetadata))}::bpchar,
              "weightunitmeasurecode" = ${ParameterValue(row.weightunitmeasurecode, null, ToStatement.optionToStatement(UnitmeasureId.toStatement, UnitmeasureId.parameterMetadata))}::bpchar,
              "weight" = ${ParameterValue(row.weight, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric,
              "daystomanufacture" = ${ParameterValue(row.daystomanufacture, null, ToStatement.intToStatement)}::int4,
              "productline" = ${ParameterValue(row.productline, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}::bpchar,
              "class" = ${ParameterValue(row.`class`, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}::bpchar,
              "style" = ${ParameterValue(row.style, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}::bpchar,
              "productsubcategoryid" = ${ParameterValue(row.productsubcategoryid, null, ToStatement.optionToStatement(ProductsubcategoryId.toStatement, ProductsubcategoryId.parameterMetadata))}::int4,
              "productmodelid" = ${ParameterValue(row.productmodelid, null, ToStatement.optionToStatement(ProductmodelId.toStatement, ProductmodelId.parameterMetadata))}::int4,
              "sellstartdate" = ${ParameterValue(row.sellstartdate, null, TypoLocalDateTime.toStatement)}::timestamp,
              "sellenddate" = ${ParameterValue(row.sellenddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
              "discontinueddate" = ${ParameterValue(row.discontinueddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
              "rowguid" = ${ParameterValue(row.rowguid, null, ToStatement.uuidToStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "productid" = ${ParameterValue(productid, null, ProductId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[ProductFields, ProductRow] = {
    UpdateBuilder("production.product", ProductFields, ProductRow.rowParser)
  }
  override def upsert(unsaved: ProductRow)(implicit c: Connection): ProductRow = {
    SQL"""insert into production.product("productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.productnumber, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.makeflag, null, Flag.toStatement)}::bool,
            ${ParameterValue(unsaved.finishedgoodsflag, null, Flag.toStatement)}::bool,
            ${ParameterValue(unsaved.color, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.safetystocklevel, null, TypoShort.toStatement)}::int2,
            ${ParameterValue(unsaved.reorderpoint, null, TypoShort.toStatement)}::int2,
            ${ParameterValue(unsaved.standardcost, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.listprice, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.size, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.sizeunitmeasurecode, null, ToStatement.optionToStatement(UnitmeasureId.toStatement, UnitmeasureId.parameterMetadata))}::bpchar,
            ${ParameterValue(unsaved.weightunitmeasurecode, null, ToStatement.optionToStatement(UnitmeasureId.toStatement, UnitmeasureId.parameterMetadata))}::bpchar,
            ${ParameterValue(unsaved.weight, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric,
            ${ParameterValue(unsaved.daystomanufacture, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.productline, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}::bpchar,
            ${ParameterValue(unsaved.`class`, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}::bpchar,
            ${ParameterValue(unsaved.style, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}::bpchar,
            ${ParameterValue(unsaved.productsubcategoryid, null, ToStatement.optionToStatement(ProductsubcategoryId.toStatement, ProductsubcategoryId.parameterMetadata))}::int4,
            ${ParameterValue(unsaved.productmodelid, null, ToStatement.optionToStatement(ProductmodelId.toStatement, ProductmodelId.parameterMetadata))}::int4,
            ${ParameterValue(unsaved.sellstartdate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.sellenddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
            ${ParameterValue(unsaved.discontinueddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
            ${ParameterValue(unsaved.rowguid, null, ToStatement.uuidToStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("productid")
          do update set
            "name" = EXCLUDED."name",
            "productnumber" = EXCLUDED."productnumber",
            "makeflag" = EXCLUDED."makeflag",
            "finishedgoodsflag" = EXCLUDED."finishedgoodsflag",
            "color" = EXCLUDED."color",
            "safetystocklevel" = EXCLUDED."safetystocklevel",
            "reorderpoint" = EXCLUDED."reorderpoint",
            "standardcost" = EXCLUDED."standardcost",
            "listprice" = EXCLUDED."listprice",
            "size" = EXCLUDED."size",
            "sizeunitmeasurecode" = EXCLUDED."sizeunitmeasurecode",
            "weightunitmeasurecode" = EXCLUDED."weightunitmeasurecode",
            "weight" = EXCLUDED."weight",
            "daystomanufacture" = EXCLUDED."daystomanufacture",
            "productline" = EXCLUDED."productline",
            "class" = EXCLUDED."class",
            "style" = EXCLUDED."style",
            "productsubcategoryid" = EXCLUDED."productsubcategoryid",
            "productmodelid" = EXCLUDED."productmodelid",
            "sellstartdate" = EXCLUDED."sellstartdate",
            "sellenddate" = EXCLUDED."sellenddate",
            "discontinueddate" = EXCLUDED."discontinueddate",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
       """
      .executeInsert(ProductRow.rowParser(1).single)
    
  }
}
