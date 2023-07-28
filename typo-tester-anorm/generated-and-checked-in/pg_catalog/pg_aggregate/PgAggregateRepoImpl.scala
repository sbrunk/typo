/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_aggregate

import anorm.SqlStringInterpolation
import java.sql.Connection

object PgAggregateRepoImpl extends PgAggregateRepo {
  override def delete(aggfnoid: PgAggregateId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_aggregate where aggfnoid = $aggfnoid".executeUpdate() > 0
  }
  override def insert(unsaved: PgAggregateRow)(implicit c: Connection): PgAggregateRow = {
    SQL"""insert into pg_catalog.pg_aggregate(aggfnoid, aggkind, aggnumdirectargs, aggtransfn, aggfinalfn, aggcombinefn, aggserialfn, aggdeserialfn, aggmtransfn, aggminvtransfn, aggmfinalfn, aggfinalextra, aggmfinalextra, aggfinalmodify, aggmfinalmodify, aggsortop, aggtranstype, aggtransspace, aggmtranstype, aggmtransspace, agginitval, aggminitval)
          values (${unsaved.aggfnoid}::regproc, ${unsaved.aggkind}::char, ${unsaved.aggnumdirectargs}::int2, ${unsaved.aggtransfn}::regproc, ${unsaved.aggfinalfn}::regproc, ${unsaved.aggcombinefn}::regproc, ${unsaved.aggserialfn}::regproc, ${unsaved.aggdeserialfn}::regproc, ${unsaved.aggmtransfn}::regproc, ${unsaved.aggminvtransfn}::regproc, ${unsaved.aggmfinalfn}::regproc, ${unsaved.aggfinalextra}, ${unsaved.aggmfinalextra}, ${unsaved.aggfinalmodify}::char, ${unsaved.aggmfinalmodify}::char, ${unsaved.aggsortop}::oid, ${unsaved.aggtranstype}::oid, ${unsaved.aggtransspace}::int4, ${unsaved.aggmtranstype}::oid, ${unsaved.aggmtransspace}::int4, ${unsaved.agginitval}, ${unsaved.aggminitval})
          returning aggfnoid, aggkind, aggnumdirectargs, aggtransfn, aggfinalfn, aggcombinefn, aggserialfn, aggdeserialfn, aggmtransfn, aggminvtransfn, aggmfinalfn, aggfinalextra, aggmfinalextra, aggfinalmodify, aggmfinalmodify, aggsortop, aggtranstype, aggtransspace, aggmtranstype, aggmtransspace, agginitval, aggminitval
       """
      .executeInsert(PgAggregateRow.rowParser(1).single)
    
  }
  override def selectAll(implicit c: Connection): List[PgAggregateRow] = {
    SQL"""select aggfnoid, aggkind, aggnumdirectargs, aggtransfn, aggfinalfn, aggcombinefn, aggserialfn, aggdeserialfn, aggmtransfn, aggminvtransfn, aggmfinalfn, aggfinalextra, aggmfinalextra, aggfinalmodify, aggmfinalmodify, aggsortop, aggtranstype, aggtransspace, aggmtranstype, aggmtransspace, agginitval, aggminitval
          from pg_catalog.pg_aggregate
       """.as(PgAggregateRow.rowParser(1).*)
  }
  override def selectById(aggfnoid: PgAggregateId)(implicit c: Connection): Option[PgAggregateRow] = {
    SQL"""select aggfnoid, aggkind, aggnumdirectargs, aggtransfn, aggfinalfn, aggcombinefn, aggserialfn, aggdeserialfn, aggmtransfn, aggminvtransfn, aggmfinalfn, aggfinalextra, aggmfinalextra, aggfinalmodify, aggmfinalmodify, aggsortop, aggtranstype, aggtransspace, aggmtranstype, aggmtransspace, agginitval, aggminitval
          from pg_catalog.pg_aggregate
          where aggfnoid = $aggfnoid
       """.as(PgAggregateRow.rowParser(1).singleOpt)
  }
  override def selectByIds(aggfnoids: Array[PgAggregateId])(implicit c: Connection): List[PgAggregateRow] = {
    SQL"""select aggfnoid, aggkind, aggnumdirectargs, aggtransfn, aggfinalfn, aggcombinefn, aggserialfn, aggdeserialfn, aggmtransfn, aggminvtransfn, aggmfinalfn, aggfinalextra, aggmfinalextra, aggfinalmodify, aggmfinalmodify, aggsortop, aggtranstype, aggtransspace, aggmtranstype, aggmtransspace, agginitval, aggminitval
          from pg_catalog.pg_aggregate
          where aggfnoid = ANY($aggfnoids)
       """.as(PgAggregateRow.rowParser(1).*)
    
  }
  override def update(row: PgAggregateRow)(implicit c: Connection): Boolean = {
    val aggfnoid = row.aggfnoid
    SQL"""update pg_catalog.pg_aggregate
          set aggkind = ${row.aggkind}::char,
              aggnumdirectargs = ${row.aggnumdirectargs}::int2,
              aggtransfn = ${row.aggtransfn}::regproc,
              aggfinalfn = ${row.aggfinalfn}::regproc,
              aggcombinefn = ${row.aggcombinefn}::regproc,
              aggserialfn = ${row.aggserialfn}::regproc,
              aggdeserialfn = ${row.aggdeserialfn}::regproc,
              aggmtransfn = ${row.aggmtransfn}::regproc,
              aggminvtransfn = ${row.aggminvtransfn}::regproc,
              aggmfinalfn = ${row.aggmfinalfn}::regproc,
              aggfinalextra = ${row.aggfinalextra},
              aggmfinalextra = ${row.aggmfinalextra},
              aggfinalmodify = ${row.aggfinalmodify}::char,
              aggmfinalmodify = ${row.aggmfinalmodify}::char,
              aggsortop = ${row.aggsortop}::oid,
              aggtranstype = ${row.aggtranstype}::oid,
              aggtransspace = ${row.aggtransspace}::int4,
              aggmtranstype = ${row.aggmtranstype}::oid,
              aggmtransspace = ${row.aggmtransspace}::int4,
              agginitval = ${row.agginitval},
              aggminitval = ${row.aggminitval}
          where aggfnoid = $aggfnoid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: PgAggregateRow)(implicit c: Connection): PgAggregateRow = {
    SQL"""insert into pg_catalog.pg_aggregate(aggfnoid, aggkind, aggnumdirectargs, aggtransfn, aggfinalfn, aggcombinefn, aggserialfn, aggdeserialfn, aggmtransfn, aggminvtransfn, aggmfinalfn, aggfinalextra, aggmfinalextra, aggfinalmodify, aggmfinalmodify, aggsortop, aggtranstype, aggtransspace, aggmtranstype, aggmtransspace, agginitval, aggminitval)
          values (
            ${unsaved.aggfnoid}::regproc,
            ${unsaved.aggkind}::char,
            ${unsaved.aggnumdirectargs}::int2,
            ${unsaved.aggtransfn}::regproc,
            ${unsaved.aggfinalfn}::regproc,
            ${unsaved.aggcombinefn}::regproc,
            ${unsaved.aggserialfn}::regproc,
            ${unsaved.aggdeserialfn}::regproc,
            ${unsaved.aggmtransfn}::regproc,
            ${unsaved.aggminvtransfn}::regproc,
            ${unsaved.aggmfinalfn}::regproc,
            ${unsaved.aggfinalextra},
            ${unsaved.aggmfinalextra},
            ${unsaved.aggfinalmodify}::char,
            ${unsaved.aggmfinalmodify}::char,
            ${unsaved.aggsortop}::oid,
            ${unsaved.aggtranstype}::oid,
            ${unsaved.aggtransspace}::int4,
            ${unsaved.aggmtranstype}::oid,
            ${unsaved.aggmtransspace}::int4,
            ${unsaved.agginitval},
            ${unsaved.aggminitval}
          )
          on conflict (aggfnoid)
          do update set
            aggkind = EXCLUDED.aggkind,
            aggnumdirectargs = EXCLUDED.aggnumdirectargs,
            aggtransfn = EXCLUDED.aggtransfn,
            aggfinalfn = EXCLUDED.aggfinalfn,
            aggcombinefn = EXCLUDED.aggcombinefn,
            aggserialfn = EXCLUDED.aggserialfn,
            aggdeserialfn = EXCLUDED.aggdeserialfn,
            aggmtransfn = EXCLUDED.aggmtransfn,
            aggminvtransfn = EXCLUDED.aggminvtransfn,
            aggmfinalfn = EXCLUDED.aggmfinalfn,
            aggfinalextra = EXCLUDED.aggfinalextra,
            aggmfinalextra = EXCLUDED.aggmfinalextra,
            aggfinalmodify = EXCLUDED.aggfinalmodify,
            aggmfinalmodify = EXCLUDED.aggmfinalmodify,
            aggsortop = EXCLUDED.aggsortop,
            aggtranstype = EXCLUDED.aggtranstype,
            aggtransspace = EXCLUDED.aggtransspace,
            aggmtranstype = EXCLUDED.aggmtranstype,
            aggmtransspace = EXCLUDED.aggmtransspace,
            agginitval = EXCLUDED.agginitval,
            aggminitval = EXCLUDED.aggminitval
          returning aggfnoid, aggkind, aggnumdirectargs, aggtransfn, aggfinalfn, aggcombinefn, aggserialfn, aggdeserialfn, aggmtransfn, aggminvtransfn, aggmfinalfn, aggfinalextra, aggmfinalextra, aggfinalmodify, aggmfinalmodify, aggsortop, aggtranstype, aggtransspace, aggmtranstype, aggmtransspace, agginitval, aggminitval
       """
      .executeInsert(PgAggregateRow.rowParser(1).single)
    
  }
}
