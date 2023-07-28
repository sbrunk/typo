/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object ProductmodelillustrationRepoImpl extends ProductmodelillustrationRepo {
  override def delete(compositeId: ProductmodelillustrationId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productmodelillustration where productmodelid = ${compositeId.productmodelid} AND illustrationid = ${compositeId.illustrationid}".executeUpdate() > 0
  }
  override def insert(unsaved: ProductmodelillustrationRow)(implicit c: Connection): ProductmodelillustrationRow = {
    SQL"""insert into production.productmodelillustration(productmodelid, illustrationid, modifieddate)
          values (${unsaved.productmodelid}::int4, ${unsaved.illustrationid}::int4, ${unsaved.modifieddate}::timestamp)
          returning productmodelid, illustrationid, modifieddate::text
       """
      .executeInsert(ProductmodelillustrationRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductmodelillustrationRowUnsaved)(implicit c: Connection): ProductmodelillustrationRow = {
    val namedParameters = List(
      Some((NamedParameter("productmodelid", ParameterValue.from(unsaved.productmodelid)), "::int4")),
      Some((NamedParameter("illustrationid", ParameterValue.from(unsaved.illustrationid)), "::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productmodelillustration default values
            returning productmodelid, illustrationid, modifieddate::text
         """
        .executeInsert(ProductmodelillustrationRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productmodelillustration(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productmodelid, illustrationid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(ProductmodelillustrationRow.rowParser(1).single)
    }
    
  }
  override def selectAll(implicit c: Connection): List[ProductmodelillustrationRow] = {
    SQL"""select productmodelid, illustrationid, modifieddate::text
          from production.productmodelillustration
       """.as(ProductmodelillustrationRow.rowParser(1).*)
  }
  override def selectById(compositeId: ProductmodelillustrationId)(implicit c: Connection): Option[ProductmodelillustrationRow] = {
    SQL"""select productmodelid, illustrationid, modifieddate::text
          from production.productmodelillustration
          where productmodelid = ${compositeId.productmodelid} AND illustrationid = ${compositeId.illustrationid}
       """.as(ProductmodelillustrationRow.rowParser(1).singleOpt)
  }
  override def update(row: ProductmodelillustrationRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productmodelillustration
          set modifieddate = ${row.modifieddate}::timestamp
          where productmodelid = ${compositeId.productmodelid} AND illustrationid = ${compositeId.illustrationid}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: ProductmodelillustrationRow)(implicit c: Connection): ProductmodelillustrationRow = {
    SQL"""insert into production.productmodelillustration(productmodelid, illustrationid, modifieddate)
          values (
            ${unsaved.productmodelid}::int4,
            ${unsaved.illustrationid}::int4,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productmodelid, illustrationid)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning productmodelid, illustrationid, modifieddate::text
       """
      .executeInsert(ProductmodelillustrationRow.rowParser(1).single)
    
  }
}
