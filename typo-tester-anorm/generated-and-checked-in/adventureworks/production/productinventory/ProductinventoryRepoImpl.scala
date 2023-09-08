/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import anorm.NamedParameter
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

object ProductinventoryRepoImpl extends ProductinventoryRepo {
  override def delete(compositeId: ProductinventoryId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.productinventory where "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND "locationid" = ${ParameterValue(compositeId.locationid, null, LocationId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[ProductinventoryFields, ProductinventoryRow] = {
    DeleteBuilder("production.productinventory", ProductinventoryFields)
  }
  override def insert(unsaved: ProductinventoryRow)(implicit c: Connection): ProductinventoryRow = {
    SQL"""insert into production.productinventory("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4, ${ParameterValue(unsaved.locationid, null, LocationId.toStatement)}::int2, ${ParameterValue(unsaved.shelf, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.bin, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.quantity, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
       """
      .executeInsert(ProductinventoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductinventoryRowUnsaved)(implicit c: Connection): ProductinventoryRow = {
    val namedParameters = List(
      Some((NamedParameter("productid", ParameterValue(unsaved.productid, null, ProductId.toStatement)), "::int4")),
      Some((NamedParameter("locationid", ParameterValue(unsaved.locationid, null, LocationId.toStatement)), "::int2")),
      Some((NamedParameter("shelf", ParameterValue(unsaved.shelf, null, ToStatement.stringToStatement)), "")),
      Some((NamedParameter("bin", ParameterValue(unsaved.bin, null, TypoShort.toStatement)), "::int2")),
      unsaved.quantity match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("quantity", ParameterValue(value, null, TypoShort.toStatement)), "::int2"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue(value, null, TypoUUID.toStatement)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productinventory default values
            returning "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
         """
        .executeInsert(ProductinventoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productinventory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ProductinventoryRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[ProductinventoryFields, ProductinventoryRow] = {
    SelectBuilderSql("production.productinventory", ProductinventoryFields, ProductinventoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductinventoryRow] = {
    SQL"""select "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
          from production.productinventory
       """.as(ProductinventoryRow.rowParser(1).*)
  }
  override def selectById(compositeId: ProductinventoryId)(implicit c: Connection): Option[ProductinventoryRow] = {
    SQL"""select "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
          from production.productinventory
          where "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND "locationid" = ${ParameterValue(compositeId.locationid, null, LocationId.toStatement)}
       """.as(ProductinventoryRow.rowParser(1).singleOpt)
  }
  override def update(row: ProductinventoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productinventory
          set "shelf" = ${ParameterValue(row.shelf, null, ToStatement.stringToStatement)},
              "bin" = ${ParameterValue(row.bin, null, TypoShort.toStatement)}::int2,
              "quantity" = ${ParameterValue(row.quantity, null, TypoShort.toStatement)}::int2,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND "locationid" = ${ParameterValue(compositeId.locationid, null, LocationId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[ProductinventoryFields, ProductinventoryRow] = {
    UpdateBuilder("production.productinventory", ProductinventoryFields, ProductinventoryRow.rowParser)
  }
  override def upsert(unsaved: ProductinventoryRow)(implicit c: Connection): ProductinventoryRow = {
    SQL"""insert into production.productinventory("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4,
            ${ParameterValue(unsaved.locationid, null, LocationId.toStatement)}::int2,
            ${ParameterValue(unsaved.shelf, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.bin, null, TypoShort.toStatement)}::int2,
            ${ParameterValue(unsaved.quantity, null, TypoShort.toStatement)}::int2,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("productid", "locationid")
          do update set
            "shelf" = EXCLUDED."shelf",
            "bin" = EXCLUDED."bin",
            "quantity" = EXCLUDED."quantity",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
       """
      .executeInsert(ProductinventoryRow.rowParser(1).single)
    
  }
}
