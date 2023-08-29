/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
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

object SalesorderdetailRepoImpl extends SalesorderdetailRepo {
  override def delete(compositeId: SalesorderdetailId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.salesorderdetail where "salesorderid" = ${ParameterValue(compositeId.salesorderid, null, SalesorderheaderId.toStatement)} AND "salesorderdetailid" = ${ParameterValue(compositeId.salesorderdetailid, null, ToStatement.intToStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[SalesorderdetailFields, SalesorderdetailRow] = {
    DeleteBuilder("sales.salesorderdetail", SalesorderdetailFields)
  }
  override def insert(unsaved: SalesorderdetailRow)(implicit c: Connection): SalesorderdetailRow = {
    SQL"""insert into sales.salesorderdetail("salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.salesorderid, null, SalesorderheaderId.toStatement)}::int4, ${ParameterValue(unsaved.salesorderdetailid, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.carriertrackingnumber, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.orderqty, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4, ${ParameterValue(unsaved.specialofferid, null, SpecialofferId.toStatement)}::int4, ${ParameterValue(unsaved.unitprice, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.unitpricediscount, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.rowguid, null, ToStatement.uuidToStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text
       """
      .executeInsert(SalesorderdetailRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SalesorderdetailRowUnsaved)(implicit c: Connection): SalesorderdetailRow = {
    val namedParameters = List(
      Some((NamedParameter("salesorderid", ParameterValue(unsaved.salesorderid, null, SalesorderheaderId.toStatement)), "::int4")),
      Some((NamedParameter("carriertrackingnumber", ParameterValue(unsaved.carriertrackingnumber, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      Some((NamedParameter("orderqty", ParameterValue(unsaved.orderqty, null, TypoShort.toStatement)), "::int2")),
      Some((NamedParameter("productid", ParameterValue(unsaved.productid, null, ProductId.toStatement)), "::int4")),
      Some((NamedParameter("specialofferid", ParameterValue(unsaved.specialofferid, null, SpecialofferId.toStatement)), "::int4")),
      Some((NamedParameter("unitprice", ParameterValue(unsaved.unitprice, null, ToStatement.scalaBigDecimalToStatement)), "::numeric")),
      unsaved.salesorderdetailid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("salesorderdetailid", ParameterValue(value, null, ToStatement.intToStatement)), "::int4"))
      },
      unsaved.unitpricediscount match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("unitpricediscount", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
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
      SQL"""insert into sales.salesorderdetail default values
            returning "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text
         """
        .executeInsert(SalesorderdetailRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salesorderdetail(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(SalesorderdetailRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[SalesorderdetailFields, SalesorderdetailRow] = {
    SelectBuilderSql("sales.salesorderdetail", SalesorderdetailFields, SalesorderdetailRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalesorderdetailRow] = {
    SQL"""select "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text
          from sales.salesorderdetail
       """.as(SalesorderdetailRow.rowParser(1).*)
  }
  override def selectById(compositeId: SalesorderdetailId)(implicit c: Connection): Option[SalesorderdetailRow] = {
    SQL"""select "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text
          from sales.salesorderdetail
          where "salesorderid" = ${ParameterValue(compositeId.salesorderid, null, SalesorderheaderId.toStatement)} AND "salesorderdetailid" = ${ParameterValue(compositeId.salesorderdetailid, null, ToStatement.intToStatement)}
       """.as(SalesorderdetailRow.rowParser(1).singleOpt)
  }
  override def update(row: SalesorderdetailRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.salesorderdetail
          set "carriertrackingnumber" = ${ParameterValue(row.carriertrackingnumber, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              "orderqty" = ${ParameterValue(row.orderqty, null, TypoShort.toStatement)}::int2,
              "productid" = ${ParameterValue(row.productid, null, ProductId.toStatement)}::int4,
              "specialofferid" = ${ParameterValue(row.specialofferid, null, SpecialofferId.toStatement)}::int4,
              "unitprice" = ${ParameterValue(row.unitprice, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "unitpricediscount" = ${ParameterValue(row.unitpricediscount, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "rowguid" = ${ParameterValue(row.rowguid, null, ToStatement.uuidToStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "salesorderid" = ${ParameterValue(compositeId.salesorderid, null, SalesorderheaderId.toStatement)} AND "salesorderdetailid" = ${ParameterValue(compositeId.salesorderdetailid, null, ToStatement.intToStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[SalesorderdetailFields, SalesorderdetailRow] = {
    UpdateBuilder("sales.salesorderdetail", SalesorderdetailFields, SalesorderdetailRow.rowParser)
  }
  override def upsert(unsaved: SalesorderdetailRow)(implicit c: Connection): SalesorderdetailRow = {
    SQL"""insert into sales.salesorderdetail("salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.salesorderid, null, SalesorderheaderId.toStatement)}::int4,
            ${ParameterValue(unsaved.salesorderdetailid, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.carriertrackingnumber, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.orderqty, null, TypoShort.toStatement)}::int2,
            ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4,
            ${ParameterValue(unsaved.specialofferid, null, SpecialofferId.toStatement)}::int4,
            ${ParameterValue(unsaved.unitprice, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.unitpricediscount, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.rowguid, null, ToStatement.uuidToStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("salesorderid", "salesorderdetailid")
          do update set
            "carriertrackingnumber" = EXCLUDED."carriertrackingnumber",
            "orderqty" = EXCLUDED."orderqty",
            "productid" = EXCLUDED."productid",
            "specialofferid" = EXCLUDED."specialofferid",
            "unitprice" = EXCLUDED."unitprice",
            "unitpricediscount" = EXCLUDED."unitpricediscount",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text
       """
      .executeInsert(SalesorderdetailRow.rowParser(1).single)
    
  }
}
