/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object ProductcategoryRepoImpl extends ProductcategoryRepo {
  override def delete(productcategoryid: ProductcategoryId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productcategory where productcategoryid = $productcategoryid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[ProductcategoryFields, ProductcategoryRow] = {
    DeleteBuilder("production.productcategory", ProductcategoryFields)
  }
  override def insert(unsaved: ProductcategoryRow)(implicit c: Connection): ProductcategoryRow = {
    SQL"""insert into production.productcategory(productcategoryid, "name", rowguid, modifieddate)
          values (${unsaved.productcategoryid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning productcategoryid, "name", rowguid, modifieddate::text
       """
      .executeInsert(ProductcategoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductcategoryRowUnsaved)(implicit c: Connection): ProductcategoryRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.productcategoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("productcategoryid", ParameterValue.from[ProductcategoryId](value)), "::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productcategory default values
            returning productcategoryid, "name", rowguid, modifieddate::text
         """
        .executeInsert(ProductcategoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productcategory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productcategoryid, "name", rowguid, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser(Success(_)))
        .executeInsert(ProductcategoryRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[ProductcategoryFields, ProductcategoryRow] = {
    SelectBuilderSql("production.productcategory", ProductcategoryFields, ProductcategoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductcategoryRow] = {
    SQL"""select productcategoryid, "name", rowguid, modifieddate::text
          from production.productcategory
       """.as(ProductcategoryRow.rowParser(1).*)
  }
  override def selectById(productcategoryid: ProductcategoryId)(implicit c: Connection): Option[ProductcategoryRow] = {
    SQL"""select productcategoryid, "name", rowguid, modifieddate::text
          from production.productcategory
          where productcategoryid = $productcategoryid
       """.as(ProductcategoryRow.rowParser(1).singleOpt)
  }
  override def selectByIds(productcategoryids: Array[ProductcategoryId])(implicit c: Connection): List[ProductcategoryRow] = {
    SQL"""select productcategoryid, "name", rowguid, modifieddate::text
          from production.productcategory
          where productcategoryid = ANY($productcategoryids)
       """.as(ProductcategoryRow.rowParser(1).*)
    
  }
  override def update(row: ProductcategoryRow)(implicit c: Connection): Boolean = {
    val productcategoryid = row.productcategoryid
    SQL"""update production.productcategory
          set "name" = ${row.name}::"public"."Name",
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where productcategoryid = $productcategoryid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[ProductcategoryFields, ProductcategoryRow] = {
    UpdateBuilder("production.productcategory", ProductcategoryFields, ProductcategoryRow.rowParser)
  }
  override def upsert(unsaved: ProductcategoryRow)(implicit c: Connection): ProductcategoryRow = {
    SQL"""insert into production.productcategory(productcategoryid, "name", rowguid, modifieddate)
          values (
            ${unsaved.productcategoryid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productcategoryid)
          do update set
            "name" = EXCLUDED."name",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning productcategoryid, "name", rowguid, modifieddate::text
       """
      .executeInsert(ProductcategoryRow.rowParser(1).single)
    
  }
}
