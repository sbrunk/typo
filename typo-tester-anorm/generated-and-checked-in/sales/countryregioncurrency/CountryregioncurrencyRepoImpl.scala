/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object CountryregioncurrencyRepoImpl extends CountryregioncurrencyRepo {
  override def delete(compositeId: CountryregioncurrencyId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.countryregioncurrency where countryregioncode = ${compositeId.countryregioncode} AND currencycode = ${compositeId.currencycode}".executeUpdate() > 0
  }
  override def insert(unsaved: CountryregioncurrencyRow)(implicit c: Connection): CountryregioncurrencyRow = {
    SQL"""insert into sales.countryregioncurrency(countryregioncode, currencycode, modifieddate)
          values (${unsaved.countryregioncode}, ${unsaved.currencycode}::bpchar, ${unsaved.modifieddate}::timestamp)
          returning countryregioncode, currencycode, modifieddate::text
       """
      .executeInsert(CountryregioncurrencyRow.rowParser(1).single)
    
  }
  override def insert(unsaved: CountryregioncurrencyRowUnsaved)(implicit c: Connection): CountryregioncurrencyRow = {
    val namedParameters = List(
      Some((NamedParameter("countryregioncode", ParameterValue.from(unsaved.countryregioncode)), "")),
      Some((NamedParameter("currencycode", ParameterValue.from(unsaved.currencycode)), "::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.countryregioncurrency default values
            returning countryregioncode, currencycode, modifieddate::text
         """
        .executeInsert(CountryregioncurrencyRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.countryregioncurrency(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning countryregioncode, currencycode, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(CountryregioncurrencyRow.rowParser(1).single)
    }
    
  }
  override def selectAll(implicit c: Connection): List[CountryregioncurrencyRow] = {
    SQL"""select countryregioncode, currencycode, modifieddate::text
          from sales.countryregioncurrency
       """.as(CountryregioncurrencyRow.rowParser(1).*)
  }
  override def selectById(compositeId: CountryregioncurrencyId)(implicit c: Connection): Option[CountryregioncurrencyRow] = {
    SQL"""select countryregioncode, currencycode, modifieddate::text
          from sales.countryregioncurrency
          where countryregioncode = ${compositeId.countryregioncode} AND currencycode = ${compositeId.currencycode}
       """.as(CountryregioncurrencyRow.rowParser(1).singleOpt)
  }
  override def update(row: CountryregioncurrencyRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.countryregioncurrency
          set modifieddate = ${row.modifieddate}::timestamp
          where countryregioncode = ${compositeId.countryregioncode} AND currencycode = ${compositeId.currencycode}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: CountryregioncurrencyRow)(implicit c: Connection): CountryregioncurrencyRow = {
    SQL"""insert into sales.countryregioncurrency(countryregioncode, currencycode, modifieddate)
          values (
            ${unsaved.countryregioncode},
            ${unsaved.currencycode}::bpchar,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (countryregioncode, currencycode)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning countryregioncode, currencycode, modifieddate::text
       """
      .executeInsert(CountryregioncurrencyRow.rowParser(1).single)
    
  }
}
