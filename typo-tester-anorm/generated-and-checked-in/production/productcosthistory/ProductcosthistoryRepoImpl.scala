/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

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
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object ProductcosthistoryRepoImpl extends ProductcosthistoryRepo {
  override def delete(compositeId: ProductcosthistoryId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productcosthistory where productid = ${compositeId.productid} AND startdate = ${compositeId.startdate}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    DeleteBuilder("production.productcosthistory", ProductcosthistoryFields)
  }
  override def insert(unsaved: ProductcosthistoryRow)(implicit c: Connection): ProductcosthistoryRow = {
    SQL"""insert into production.productcosthistory(productid, startdate, enddate, standardcost, modifieddate)
          values (${unsaved.productid}::int4, ${unsaved.startdate}::timestamp, ${unsaved.enddate}::timestamp, ${unsaved.standardcost}::numeric, ${unsaved.modifieddate}::timestamp)
          returning productid, startdate::text, enddate::text, standardcost, modifieddate::text
       """
      .executeInsert(ProductcosthistoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductcosthistoryRowUnsaved)(implicit c: Connection): ProductcosthistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("productid", ParameterValue.from(unsaved.productid)), "::int4")),
      Some((NamedParameter("startdate", ParameterValue.from(unsaved.startdate)), "::timestamp")),
      Some((NamedParameter("enddate", ParameterValue.from(unsaved.enddate)), "::timestamp")),
      Some((NamedParameter("standardcost", ParameterValue.from(unsaved.standardcost)), "::numeric")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productcosthistory default values
            returning productid, startdate::text, enddate::text, standardcost, modifieddate::text
         """
        .executeInsert(ProductcosthistoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productcosthistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productid, startdate::text, enddate::text, standardcost, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser(Success(_)))
        .executeInsert(ProductcosthistoryRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    SelectBuilderSql("production.productcosthistory", ProductcosthistoryFields, ProductcosthistoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductcosthistoryRow] = {
    SQL"""select productid, startdate::text, enddate::text, standardcost, modifieddate::text
          from production.productcosthistory
       """.as(ProductcosthistoryRow.rowParser(1).*)
  }
  override def selectById(compositeId: ProductcosthistoryId)(implicit c: Connection): Option[ProductcosthistoryRow] = {
    SQL"""select productid, startdate::text, enddate::text, standardcost, modifieddate::text
          from production.productcosthistory
          where productid = ${compositeId.productid} AND startdate = ${compositeId.startdate}
       """.as(ProductcosthistoryRow.rowParser(1).singleOpt)
  }
  override def update(row: ProductcosthistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productcosthistory
          set enddate = ${row.enddate}::timestamp,
              standardcost = ${row.standardcost}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where productid = ${compositeId.productid} AND startdate = ${compositeId.startdate}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    UpdateBuilder("production.productcosthistory", ProductcosthistoryFields, ProductcosthistoryRow.rowParser)
  }
  override def upsert(unsaved: ProductcosthistoryRow)(implicit c: Connection): ProductcosthistoryRow = {
    SQL"""insert into production.productcosthistory(productid, startdate, enddate, standardcost, modifieddate)
          values (
            ${unsaved.productid}::int4,
            ${unsaved.startdate}::timestamp,
            ${unsaved.enddate}::timestamp,
            ${unsaved.standardcost}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productid, startdate)
          do update set
            enddate = EXCLUDED.enddate,
            standardcost = EXCLUDED.standardcost,
            modifieddate = EXCLUDED.modifieddate
          returning productid, startdate::text, enddate::text, standardcost, modifieddate::text
       """
      .executeInsert(ProductcosthistoryRow.rowParser(1).single)
    
  }
}
