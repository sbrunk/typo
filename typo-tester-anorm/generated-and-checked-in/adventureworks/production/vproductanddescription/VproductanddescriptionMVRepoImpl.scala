/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductanddescription

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object VproductanddescriptionMVRepoImpl extends VproductanddescriptionMVRepo {
  override def select: SelectBuilder[VproductanddescriptionMVFields, VproductanddescriptionMVRow] = {
    SelectBuilderSql("production.vproductanddescription", VproductanddescriptionMVFields, VproductanddescriptionMVRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[VproductanddescriptionMVRow] = {
    SQL"""select "productid", "name", "productmodel", "cultureid", "description"
          from production.vproductanddescription
       """.as(VproductanddescriptionMVRow.rowParser(1).*)
  }
}
