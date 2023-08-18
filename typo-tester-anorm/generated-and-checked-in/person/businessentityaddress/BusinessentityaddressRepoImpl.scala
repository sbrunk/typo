/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

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

object BusinessentityaddressRepoImpl extends BusinessentityaddressRepo {
  override def delete(compositeId: BusinessentityaddressId)(implicit c: Connection): Boolean = {
    SQL"delete from person.businessentityaddress where businessentityid = ${compositeId.businessentityid} AND addressid = ${compositeId.addressid} AND addresstypeid = ${compositeId.addresstypeid}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    DeleteBuilder("person.businessentityaddress", BusinessentityaddressFields)
  }
  override def insert(unsaved: BusinessentityaddressRow)(implicit c: Connection): BusinessentityaddressRow = {
    SQL"""insert into person.businessentityaddress(businessentityid, addressid, addresstypeid, rowguid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.addressid}::int4, ${unsaved.addresstypeid}::int4, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, addressid, addresstypeid, rowguid, modifieddate::text
       """
      .executeInsert(BusinessentityaddressRow.rowParser(1).single)
    
  }
  override def insert(unsaved: BusinessentityaddressRowUnsaved)(implicit c: Connection): BusinessentityaddressRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("addressid", ParameterValue.from(unsaved.addressid)), "::int4")),
      Some((NamedParameter("addresstypeid", ParameterValue.from(unsaved.addresstypeid)), "::int4")),
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
      SQL"""insert into person.businessentityaddress default values
            returning businessentityid, addressid, addresstypeid, rowguid, modifieddate::text
         """
        .executeInsert(BusinessentityaddressRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.businessentityaddress(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, addressid, addresstypeid, rowguid, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser(Success(_)))
        .executeInsert(BusinessentityaddressRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    SelectBuilderSql("person.businessentityaddress", BusinessentityaddressFields, BusinessentityaddressRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[BusinessentityaddressRow] = {
    SQL"""select businessentityid, addressid, addresstypeid, rowguid, modifieddate::text
          from person.businessentityaddress
       """.as(BusinessentityaddressRow.rowParser(1).*)
  }
  override def selectById(compositeId: BusinessentityaddressId)(implicit c: Connection): Option[BusinessentityaddressRow] = {
    SQL"""select businessentityid, addressid, addresstypeid, rowguid, modifieddate::text
          from person.businessentityaddress
          where businessentityid = ${compositeId.businessentityid} AND addressid = ${compositeId.addressid} AND addresstypeid = ${compositeId.addresstypeid}
       """.as(BusinessentityaddressRow.rowParser(1).singleOpt)
  }
  override def update(row: BusinessentityaddressRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update person.businessentityaddress
          set rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND addressid = ${compositeId.addressid} AND addresstypeid = ${compositeId.addresstypeid}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    UpdateBuilder("person.businessentityaddress", BusinessentityaddressFields, BusinessentityaddressRow.rowParser)
  }
  override def upsert(unsaved: BusinessentityaddressRow)(implicit c: Connection): BusinessentityaddressRow = {
    SQL"""insert into person.businessentityaddress(businessentityid, addressid, addresstypeid, rowguid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.addressid}::int4,
            ${unsaved.addresstypeid}::int4,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, addressid, addresstypeid)
          do update set
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, addressid, addresstypeid, rowguid, modifieddate::text
       """
      .executeInsert(BusinessentityaddressRow.rowParser(1).single)
    
  }
}
