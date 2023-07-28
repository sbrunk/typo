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
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.util.UUID

object ProductsubcategoryRepoImpl extends ProductsubcategoryRepo {
  override def delete(productsubcategoryid: ProductsubcategoryId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productsubcategory where productsubcategoryid = $productsubcategoryid".executeUpdate() > 0
  }
  override def insert(unsaved: ProductsubcategoryRow)(implicit c: Connection): ProductsubcategoryRow = {
    SQL"""insert into production.productsubcategory(productsubcategoryid, productcategoryid, "name", rowguid, modifieddate)
          values (${unsaved.productsubcategoryid}::int4, ${unsaved.productcategoryid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
       """
      .executeInsert(ProductsubcategoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductsubcategoryRowUnsaved)(implicit c: Connection): ProductsubcategoryRow = {
    val namedParameters = List(
      Some((NamedParameter("productcategoryid", ParameterValue.from(unsaved.productcategoryid)), "::int4")),
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.productsubcategoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("productsubcategoryid", ParameterValue.from[ProductsubcategoryId](value)), "::int4"))
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
      SQL"""insert into production.productsubcategory default values
            returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
         """
        .executeInsert(ProductsubcategoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productsubcategory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(ProductsubcategoryRow.rowParser(1).single)
    }
    
  }
  override def selectAll(implicit c: Connection): List[ProductsubcategoryRow] = {
    SQL"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
          from production.productsubcategory
       """.as(ProductsubcategoryRow.rowParser(1).*)
  }
  override def selectById(productsubcategoryid: ProductsubcategoryId)(implicit c: Connection): Option[ProductsubcategoryRow] = {
    SQL"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
          from production.productsubcategory
          where productsubcategoryid = $productsubcategoryid
       """.as(ProductsubcategoryRow.rowParser(1).singleOpt)
  }
  override def selectByIds(productsubcategoryids: Array[ProductsubcategoryId])(implicit c: Connection): List[ProductsubcategoryRow] = {
    SQL"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
          from production.productsubcategory
          where productsubcategoryid = ANY($productsubcategoryids)
       """.as(ProductsubcategoryRow.rowParser(1).*)
    
  }
  override def update(row: ProductsubcategoryRow)(implicit c: Connection): Boolean = {
    val productsubcategoryid = row.productsubcategoryid
    SQL"""update production.productsubcategory
          set productcategoryid = ${row.productcategoryid}::int4,
              "name" = ${row.name}::"public"."Name",
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where productsubcategoryid = $productsubcategoryid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: ProductsubcategoryRow)(implicit c: Connection): ProductsubcategoryRow = {
    SQL"""insert into production.productsubcategory(productsubcategoryid, productcategoryid, "name", rowguid, modifieddate)
          values (
            ${unsaved.productsubcategoryid}::int4,
            ${unsaved.productcategoryid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productsubcategoryid)
          do update set
            productcategoryid = EXCLUDED.productcategoryid,
            "name" = EXCLUDED."name",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
       """
      .executeInsert(ProductsubcategoryRow.rowParser(1).single)
    
  }
}
