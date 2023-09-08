/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.public.Name
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

object ProductmodelRepoImpl extends ProductmodelRepo {
  override def delete(productmodelid: ProductmodelId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.productmodel where "productmodelid" = ${ParameterValue(productmodelid, null, ProductmodelId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[ProductmodelFields, ProductmodelRow] = {
    DeleteBuilder("production.productmodel", ProductmodelFields)
  }
  override def insert(unsaved: ProductmodelRow)(implicit c: Connection): ProductmodelRow = {
    SQL"""insert into production.productmodel("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.productmodelid, null, ProductmodelId.toStatement)}::int4, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.catalogdescription, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml, ${ParameterValue(unsaved.instructions, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
       """
      .executeInsert(ProductmodelRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductmodelRowUnsaved)(implicit c: Connection): ProductmodelRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      Some((NamedParameter("catalogdescription", ParameterValue(unsaved.catalogdescription, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))), "::xml")),
      Some((NamedParameter("instructions", ParameterValue(unsaved.instructions, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))), "::xml")),
      unsaved.productmodelid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("productmodelid", ParameterValue(value, null, ProductmodelId.toStatement)), "::int4"))
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
      SQL"""insert into production.productmodel default values
            returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
         """
        .executeInsert(ProductmodelRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productmodel(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ProductmodelRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[ProductmodelFields, ProductmodelRow] = {
    SelectBuilderSql("production.productmodel", ProductmodelFields, ProductmodelRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductmodelRow] = {
    SQL"""select "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
          from production.productmodel
       """.as(ProductmodelRow.rowParser(1).*)
  }
  override def selectById(productmodelid: ProductmodelId)(implicit c: Connection): Option[ProductmodelRow] = {
    SQL"""select "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
          from production.productmodel
          where "productmodelid" = ${ParameterValue(productmodelid, null, ProductmodelId.toStatement)}
       """.as(ProductmodelRow.rowParser(1).singleOpt)
  }
  override def selectByIds(productmodelids: Array[ProductmodelId])(implicit c: Connection): List[ProductmodelRow] = {
    SQL"""select "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
          from production.productmodel
          where "productmodelid" = ANY(${productmodelids})
       """.as(ProductmodelRow.rowParser(1).*)
    
  }
  override def update(row: ProductmodelRow)(implicit c: Connection): Boolean = {
    val productmodelid = row.productmodelid
    SQL"""update production.productmodel
          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "catalogdescription" = ${ParameterValue(row.catalogdescription, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml,
              "instructions" = ${ParameterValue(row.instructions, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "productmodelid" = ${ParameterValue(productmodelid, null, ProductmodelId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[ProductmodelFields, ProductmodelRow] = {
    UpdateBuilder("production.productmodel", ProductmodelFields, ProductmodelRow.rowParser)
  }
  override def upsert(unsaved: ProductmodelRow)(implicit c: Connection): ProductmodelRow = {
    SQL"""insert into production.productmodel("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.productmodelid, null, ProductmodelId.toStatement)}::int4,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.catalogdescription, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml,
            ${ParameterValue(unsaved.instructions, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("productmodelid")
          do update set
            "name" = EXCLUDED."name",
            "catalogdescription" = EXCLUDED."catalogdescription",
            "instructions" = EXCLUDED."instructions",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
       """
      .executeInsert(ProductmodelRow.rowParser(1).single)
    
  }
}
