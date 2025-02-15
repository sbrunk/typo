/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object SalesorderheadersalesreasonRepoImpl extends SalesorderheadersalesreasonRepo {
  override def delete(compositeId: SalesorderheadersalesreasonId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.salesorderheadersalesreason where "salesorderid" = ${ParameterValue(compositeId.salesorderid, null, SalesorderheaderId.toStatement)} AND "salesreasonid" = ${ParameterValue(compositeId.salesreasonid, null, SalesreasonId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    DeleteBuilder("sales.salesorderheadersalesreason", SalesorderheadersalesreasonFields)
  }
  override def insert(unsaved: SalesorderheadersalesreasonRow)(implicit c: Connection): SalesorderheadersalesreasonRow = {
    SQL"""insert into sales.salesorderheadersalesreason("salesorderid", "salesreasonid", "modifieddate")
          values (${ParameterValue(unsaved.salesorderid, null, SalesorderheaderId.toStatement)}::int4, ${ParameterValue(unsaved.salesreasonid, null, SalesreasonId.toStatement)}::int4, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "salesorderid", "salesreasonid", "modifieddate"::text
       """
      .executeInsert(SalesorderheadersalesreasonRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SalesorderheadersalesreasonRowUnsaved)(implicit c: Connection): SalesorderheadersalesreasonRow = {
    val namedParameters = List(
      Some((NamedParameter("salesorderid", ParameterValue(unsaved.salesorderid, null, SalesorderheaderId.toStatement)), "::int4")),
      Some((NamedParameter("salesreasonid", ParameterValue(unsaved.salesreasonid, null, SalesreasonId.toStatement)), "::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.salesorderheadersalesreason default values
            returning "salesorderid", "salesreasonid", "modifieddate"::text
         """
        .executeInsert(SalesorderheadersalesreasonRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salesorderheadersalesreason(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "salesorderid", "salesreasonid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(SalesorderheadersalesreasonRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    SelectBuilderSql("sales.salesorderheadersalesreason", SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalesorderheadersalesreasonRow] = {
    SQL"""select "salesorderid", "salesreasonid", "modifieddate"::text
          from sales.salesorderheadersalesreason
       """.as(SalesorderheadersalesreasonRow.rowParser(1).*)
  }
  override def selectById(compositeId: SalesorderheadersalesreasonId)(implicit c: Connection): Option[SalesorderheadersalesreasonRow] = {
    SQL"""select "salesorderid", "salesreasonid", "modifieddate"::text
          from sales.salesorderheadersalesreason
          where "salesorderid" = ${ParameterValue(compositeId.salesorderid, null, SalesorderheaderId.toStatement)} AND "salesreasonid" = ${ParameterValue(compositeId.salesreasonid, null, SalesreasonId.toStatement)}
       """.as(SalesorderheadersalesreasonRow.rowParser(1).singleOpt)
  }
  override def update(row: SalesorderheadersalesreasonRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.salesorderheadersalesreason
          set "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "salesorderid" = ${ParameterValue(compositeId.salesorderid, null, SalesorderheaderId.toStatement)} AND "salesreasonid" = ${ParameterValue(compositeId.salesreasonid, null, SalesreasonId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    UpdateBuilder("sales.salesorderheadersalesreason", SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow.rowParser)
  }
  override def upsert(unsaved: SalesorderheadersalesreasonRow)(implicit c: Connection): SalesorderheadersalesreasonRow = {
    SQL"""insert into sales.salesorderheadersalesreason("salesorderid", "salesreasonid", "modifieddate")
          values (
            ${ParameterValue(unsaved.salesorderid, null, SalesorderheaderId.toStatement)}::int4,
            ${ParameterValue(unsaved.salesreasonid, null, SalesreasonId.toStatement)}::int4,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("salesorderid", "salesreasonid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "salesorderid", "salesreasonid", "modifieddate"::text
       """
      .executeInsert(SalesorderheadersalesreasonRow.rowParser(1).single)
    
  }
}
