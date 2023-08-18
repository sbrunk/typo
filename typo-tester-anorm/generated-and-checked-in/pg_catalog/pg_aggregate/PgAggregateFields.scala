/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_aggregate

import adventureworks.TypoRegproc
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait PgAggregateFields[Row] {
  val aggfnoid: IdField[PgAggregateId, Row]
  val aggkind: Field[String, Row]
  val aggnumdirectargs: Field[Int, Row]
  val aggtransfn: Field[TypoRegproc, Row]
  val aggfinalfn: Field[TypoRegproc, Row]
  val aggcombinefn: Field[TypoRegproc, Row]
  val aggserialfn: Field[TypoRegproc, Row]
  val aggdeserialfn: Field[TypoRegproc, Row]
  val aggmtransfn: Field[TypoRegproc, Row]
  val aggminvtransfn: Field[TypoRegproc, Row]
  val aggmfinalfn: Field[TypoRegproc, Row]
  val aggfinalextra: Field[Boolean, Row]
  val aggmfinalextra: Field[Boolean, Row]
  val aggfinalmodify: Field[String, Row]
  val aggmfinalmodify: Field[String, Row]
  val aggsortop: Field[/* oid */ Long, Row]
  val aggtranstype: Field[/* oid */ Long, Row]
  val aggtransspace: Field[Int, Row]
  val aggmtranstype: Field[/* oid */ Long, Row]
  val aggmtransspace: Field[Int, Row]
  val agginitval: OptField[String, Row]
  val aggminitval: OptField[String, Row]
}
object PgAggregateFields extends PgAggregateStructure[PgAggregateRow](None, identity, (_, x) => x)

