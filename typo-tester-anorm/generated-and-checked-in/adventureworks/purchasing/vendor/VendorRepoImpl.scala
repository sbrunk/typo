/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
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

object VendorRepoImpl extends VendorRepo {
  override def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = {
    SQL"""delete from purchasing.vendor where "businessentityid" = ${ParameterValue(businessentityid, null, BusinessentityId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[VendorFields, VendorRow] = {
    DeleteBuilder("purchasing.vendor", VendorFields)
  }
  override def insert(unsaved: VendorRow)(implicit c: Connection): VendorRow = {
    SQL"""insert into purchasing.vendor("businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate")
          values (${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.accountnumber, null, AccountNumber.toStatement)}::varchar, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.creditrating, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.preferredvendorstatus, null, Flag.toStatement)}::bool, ${ParameterValue(unsaved.activeflag, null, Flag.toStatement)}::bool, ${ParameterValue(unsaved.purchasingwebserviceurl, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
       """
      .executeInsert(VendorRow.rowParser(1).single)
    
  }
  override def insert(unsaved: VendorRowUnsaved)(implicit c: Connection): VendorRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("accountnumber", ParameterValue(unsaved.accountnumber, null, AccountNumber.toStatement)), "::varchar")),
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      Some((NamedParameter("creditrating", ParameterValue(unsaved.creditrating, null, TypoShort.toStatement)), "::int2")),
      Some((NamedParameter("purchasingwebserviceurl", ParameterValue(unsaved.purchasingwebserviceurl, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      unsaved.preferredvendorstatus match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("preferredvendorstatus", ParameterValue(value, null, Flag.toStatement)), "::bool"))
      },
      unsaved.activeflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("activeflag", ParameterValue(value, null, Flag.toStatement)), "::bool"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into purchasing.vendor default values
            returning "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
         """
        .executeInsert(VendorRow.rowParser(1).single)
    } else {
      val q = s"""insert into purchasing.vendor(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(VendorRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[VendorFields, VendorRow] = {
    SelectBuilderSql("purchasing.vendor", VendorFields, VendorRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[VendorRow] = {
    SQL"""select "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
          from purchasing.vendor
       """.as(VendorRow.rowParser(1).*)
  }
  override def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[VendorRow] = {
    SQL"""select "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
          from purchasing.vendor
          where "businessentityid" = ${ParameterValue(businessentityid, null, BusinessentityId.toStatement)}
       """.as(VendorRow.rowParser(1).singleOpt)
  }
  override def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[VendorRow] = {
    SQL"""select "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
          from purchasing.vendor
          where "businessentityid" = ANY(${businessentityids})
       """.as(VendorRow.rowParser(1).*)
    
  }
  override def update(row: VendorRow)(implicit c: Connection): Boolean = {
    val businessentityid = row.businessentityid
    SQL"""update purchasing.vendor
          set "accountnumber" = ${ParameterValue(row.accountnumber, null, AccountNumber.toStatement)}::varchar,
              "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "creditrating" = ${ParameterValue(row.creditrating, null, TypoShort.toStatement)}::int2,
              "preferredvendorstatus" = ${ParameterValue(row.preferredvendorstatus, null, Flag.toStatement)}::bool,
              "activeflag" = ${ParameterValue(row.activeflag, null, Flag.toStatement)}::bool,
              "purchasingwebserviceurl" = ${ParameterValue(row.purchasingwebserviceurl, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "businessentityid" = ${ParameterValue(businessentityid, null, BusinessentityId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[VendorFields, VendorRow] = {
    UpdateBuilder("purchasing.vendor", VendorFields, VendorRow.rowParser)
  }
  override def upsert(unsaved: VendorRow)(implicit c: Connection): VendorRow = {
    SQL"""insert into purchasing.vendor("businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate")
          values (
            ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.accountnumber, null, AccountNumber.toStatement)}::varchar,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.creditrating, null, TypoShort.toStatement)}::int2,
            ${ParameterValue(unsaved.preferredvendorstatus, null, Flag.toStatement)}::bool,
            ${ParameterValue(unsaved.activeflag, null, Flag.toStatement)}::bool,
            ${ParameterValue(unsaved.purchasingwebserviceurl, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "accountnumber" = EXCLUDED."accountnumber",
            "name" = EXCLUDED."name",
            "creditrating" = EXCLUDED."creditrating",
            "preferredvendorstatus" = EXCLUDED."preferredvendorstatus",
            "activeflag" = EXCLUDED."activeflag",
            "purchasingwebserviceurl" = EXCLUDED."purchasingwebserviceurl",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
       """
      .executeInsert(VendorRow.rowParser(1).single)
    
  }
}
