/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attrdef

import adventureworks.customtypes.TypoPgNodeTree
import adventureworks.customtypes.TypoShort
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait PgAttrdefFields[Row] {
  val oid: IdField[PgAttrdefId, Row]
  val adrelid: Field[/* oid */ Long, Row]
  val adnum: Field[TypoShort, Row]
  val adbin: Field[TypoPgNodeTree, Row]
}
object PgAttrdefFields extends PgAttrdefStructure[PgAttrdefRow](None, identity, (_, x) => x)

