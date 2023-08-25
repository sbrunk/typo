/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_proc

import adventureworks.TypoAclItem
import adventureworks.TypoOidVector
import adventureworks.TypoPgNodeTree
import adventureworks.TypoRegproc
import anorm.ParameterMetaData
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgProcRepoImpl extends PgProcRepo {
  override def delete(oid: PgProcId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_proc where oid = ${ParameterValue(oid, null, PgProcId.toStatement)}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PgProcFields, PgProcRow] = {
    DeleteBuilder("pg_catalog.pg_proc", PgProcFields)
  }
  override def insert(unsaved: PgProcRow)(implicit c: Connection): PgProcRow = {
    SQL"""insert into pg_catalog.pg_proc(oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl)
          values (${ParameterValue(unsaved.oid, null, PgProcId.toStatement)}::oid, ${ParameterValue(unsaved.proname, null, ToStatement.stringToStatement)}::name, ${ParameterValue(unsaved.pronamespace, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.proowner, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.prolang, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.procost, null, ToStatement.floatToStatement)}::float4, ${ParameterValue(unsaved.prorows, null, ToStatement.floatToStatement)}::float4, ${ParameterValue(unsaved.provariadic, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.prosupport, null, TypoRegproc.toStatement)}::regproc, ${ParameterValue(unsaved.prokind, null, ToStatement.stringToStatement)}::char, ${ParameterValue(unsaved.prosecdef, null, ToStatement.booleanToStatement)}, ${ParameterValue(unsaved.proleakproof, null, ToStatement.booleanToStatement)}, ${ParameterValue(unsaved.proisstrict, null, ToStatement.booleanToStatement)}, ${ParameterValue(unsaved.proretset, null, ToStatement.booleanToStatement)}, ${ParameterValue(unsaved.provolatile, null, ToStatement.stringToStatement)}::char, ${ParameterValue(unsaved.proparallel, null, ToStatement.stringToStatement)}::char, ${ParameterValue(unsaved.pronargs, null, ToStatement.intToStatement)}::int2, ${ParameterValue(unsaved.pronargdefaults, null, ToStatement.intToStatement)}::int2, ${ParameterValue(unsaved.prorettype, null, ToStatement.longToStatement)}::oid, ${ParameterValue(unsaved.proargtypes, null, TypoOidVector.toStatement)}::oidvector, ${ParameterValue(unsaved.proallargtypes, null, ToStatement.optionToStatement(adventureworks.LongArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.LongParameterMetaData)))}::_oid, ${ParameterValue(unsaved.proargmodes, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_char, ${ParameterValue(unsaved.proargnames, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_text, ${ParameterValue(unsaved.proargdefaults, null, ToStatement.optionToStatement(TypoPgNodeTree.toStatement, TypoPgNodeTree.parameterMetadata))}::pg_node_tree, ${ParameterValue(unsaved.protrftypes, null, ToStatement.optionToStatement(adventureworks.LongArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.LongParameterMetaData)))}::_oid, ${ParameterValue(unsaved.prosrc, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.probin, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.prosqlbody, null, ToStatement.optionToStatement(TypoPgNodeTree.toStatement, TypoPgNodeTree.parameterMetadata))}::pg_node_tree, ${ParameterValue(unsaved.proconfig, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_text, ${ParameterValue(unsaved.proacl, null, ToStatement.optionToStatement(TypoAclItem.arrayToStatement, adventureworks.arrayParameterMetaData(TypoAclItem.parameterMetadata)))}::_aclitem)
          returning oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl
       """
      .executeInsert(PgProcRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[PgProcFields, PgProcRow] = {
    SelectBuilderSql("pg_catalog.pg_proc", PgProcFields, PgProcRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgProcRow] = {
    SQL"""select oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl
          from pg_catalog.pg_proc
       """.as(PgProcRow.rowParser(1).*)
  }
  override def selectById(oid: PgProcId)(implicit c: Connection): Option[PgProcRow] = {
    SQL"""select oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl
          from pg_catalog.pg_proc
          where oid = ${ParameterValue(oid, null, PgProcId.toStatement)}
       """.as(PgProcRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgProcId])(implicit c: Connection): List[PgProcRow] = {
    SQL"""select oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl
          from pg_catalog.pg_proc
          where oid = ANY(${oids})
       """.as(PgProcRow.rowParser(1).*)
    
  }
  override def selectByUnique(proname: String, proargtypes: TypoOidVector, pronamespace: /* oid */ Long)(implicit c: Connection): Option[PgProcRow] = {
    SQL"""select proname, proargtypes, pronamespace
          from pg_catalog.pg_proc
          where proname = ${ParameterValue(proname, null, ToStatement.stringToStatement)} AND proargtypes = ${ParameterValue(proargtypes, null, TypoOidVector.toStatement)} AND pronamespace = ${ParameterValue(pronamespace, null, ToStatement.longToStatement)}
       """.as(PgProcRow.rowParser(1).singleOpt)
    
  }
  override def update(row: PgProcRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_proc
          set proname = ${ParameterValue(row.proname, null, ToStatement.stringToStatement)}::name,
              pronamespace = ${ParameterValue(row.pronamespace, null, ToStatement.longToStatement)}::oid,
              proowner = ${ParameterValue(row.proowner, null, ToStatement.longToStatement)}::oid,
              prolang = ${ParameterValue(row.prolang, null, ToStatement.longToStatement)}::oid,
              procost = ${ParameterValue(row.procost, null, ToStatement.floatToStatement)}::float4,
              prorows = ${ParameterValue(row.prorows, null, ToStatement.floatToStatement)}::float4,
              provariadic = ${ParameterValue(row.provariadic, null, ToStatement.longToStatement)}::oid,
              prosupport = ${ParameterValue(row.prosupport, null, TypoRegproc.toStatement)}::regproc,
              prokind = ${ParameterValue(row.prokind, null, ToStatement.stringToStatement)}::char,
              prosecdef = ${ParameterValue(row.prosecdef, null, ToStatement.booleanToStatement)},
              proleakproof = ${ParameterValue(row.proleakproof, null, ToStatement.booleanToStatement)},
              proisstrict = ${ParameterValue(row.proisstrict, null, ToStatement.booleanToStatement)},
              proretset = ${ParameterValue(row.proretset, null, ToStatement.booleanToStatement)},
              provolatile = ${ParameterValue(row.provolatile, null, ToStatement.stringToStatement)}::char,
              proparallel = ${ParameterValue(row.proparallel, null, ToStatement.stringToStatement)}::char,
              pronargs = ${ParameterValue(row.pronargs, null, ToStatement.intToStatement)}::int2,
              pronargdefaults = ${ParameterValue(row.pronargdefaults, null, ToStatement.intToStatement)}::int2,
              prorettype = ${ParameterValue(row.prorettype, null, ToStatement.longToStatement)}::oid,
              proargtypes = ${ParameterValue(row.proargtypes, null, TypoOidVector.toStatement)}::oidvector,
              proallargtypes = ${ParameterValue(row.proallargtypes, null, ToStatement.optionToStatement(adventureworks.LongArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.LongParameterMetaData)))}::_oid,
              proargmodes = ${ParameterValue(row.proargmodes, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_char,
              proargnames = ${ParameterValue(row.proargnames, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_text,
              proargdefaults = ${ParameterValue(row.proargdefaults, null, ToStatement.optionToStatement(TypoPgNodeTree.toStatement, TypoPgNodeTree.parameterMetadata))}::pg_node_tree,
              protrftypes = ${ParameterValue(row.protrftypes, null, ToStatement.optionToStatement(adventureworks.LongArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.LongParameterMetaData)))}::_oid,
              prosrc = ${ParameterValue(row.prosrc, null, ToStatement.stringToStatement)},
              probin = ${ParameterValue(row.probin, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              prosqlbody = ${ParameterValue(row.prosqlbody, null, ToStatement.optionToStatement(TypoPgNodeTree.toStatement, TypoPgNodeTree.parameterMetadata))}::pg_node_tree,
              proconfig = ${ParameterValue(row.proconfig, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_text,
              proacl = ${ParameterValue(row.proacl, null, ToStatement.optionToStatement(TypoAclItem.arrayToStatement, adventureworks.arrayParameterMetaData(TypoAclItem.parameterMetadata)))}::_aclitem
          where oid = ${ParameterValue(oid, null, PgProcId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PgProcFields, PgProcRow] = {
    UpdateBuilder("pg_catalog.pg_proc", PgProcFields, PgProcRow.rowParser)
  }
  override def upsert(unsaved: PgProcRow)(implicit c: Connection): PgProcRow = {
    SQL"""insert into pg_catalog.pg_proc(oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl)
          values (
            ${ParameterValue(unsaved.oid, null, PgProcId.toStatement)}::oid,
            ${ParameterValue(unsaved.proname, null, ToStatement.stringToStatement)}::name,
            ${ParameterValue(unsaved.pronamespace, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.proowner, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.prolang, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.procost, null, ToStatement.floatToStatement)}::float4,
            ${ParameterValue(unsaved.prorows, null, ToStatement.floatToStatement)}::float4,
            ${ParameterValue(unsaved.provariadic, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.prosupport, null, TypoRegproc.toStatement)}::regproc,
            ${ParameterValue(unsaved.prokind, null, ToStatement.stringToStatement)}::char,
            ${ParameterValue(unsaved.prosecdef, null, ToStatement.booleanToStatement)},
            ${ParameterValue(unsaved.proleakproof, null, ToStatement.booleanToStatement)},
            ${ParameterValue(unsaved.proisstrict, null, ToStatement.booleanToStatement)},
            ${ParameterValue(unsaved.proretset, null, ToStatement.booleanToStatement)},
            ${ParameterValue(unsaved.provolatile, null, ToStatement.stringToStatement)}::char,
            ${ParameterValue(unsaved.proparallel, null, ToStatement.stringToStatement)}::char,
            ${ParameterValue(unsaved.pronargs, null, ToStatement.intToStatement)}::int2,
            ${ParameterValue(unsaved.pronargdefaults, null, ToStatement.intToStatement)}::int2,
            ${ParameterValue(unsaved.prorettype, null, ToStatement.longToStatement)}::oid,
            ${ParameterValue(unsaved.proargtypes, null, TypoOidVector.toStatement)}::oidvector,
            ${ParameterValue(unsaved.proallargtypes, null, ToStatement.optionToStatement(adventureworks.LongArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.LongParameterMetaData)))}::_oid,
            ${ParameterValue(unsaved.proargmodes, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_char,
            ${ParameterValue(unsaved.proargnames, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_text,
            ${ParameterValue(unsaved.proargdefaults, null, ToStatement.optionToStatement(TypoPgNodeTree.toStatement, TypoPgNodeTree.parameterMetadata))}::pg_node_tree,
            ${ParameterValue(unsaved.protrftypes, null, ToStatement.optionToStatement(adventureworks.LongArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.LongParameterMetaData)))}::_oid,
            ${ParameterValue(unsaved.prosrc, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.probin, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.prosqlbody, null, ToStatement.optionToStatement(TypoPgNodeTree.toStatement, TypoPgNodeTree.parameterMetadata))}::pg_node_tree,
            ${ParameterValue(unsaved.proconfig, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_text,
            ${ParameterValue(unsaved.proacl, null, ToStatement.optionToStatement(TypoAclItem.arrayToStatement, adventureworks.arrayParameterMetaData(TypoAclItem.parameterMetadata)))}::_aclitem
          )
          on conflict (oid)
          do update set
            proname = EXCLUDED.proname,
            pronamespace = EXCLUDED.pronamespace,
            proowner = EXCLUDED.proowner,
            prolang = EXCLUDED.prolang,
            procost = EXCLUDED.procost,
            prorows = EXCLUDED.prorows,
            provariadic = EXCLUDED.provariadic,
            prosupport = EXCLUDED.prosupport,
            prokind = EXCLUDED.prokind,
            prosecdef = EXCLUDED.prosecdef,
            proleakproof = EXCLUDED.proleakproof,
            proisstrict = EXCLUDED.proisstrict,
            proretset = EXCLUDED.proretset,
            provolatile = EXCLUDED.provolatile,
            proparallel = EXCLUDED.proparallel,
            pronargs = EXCLUDED.pronargs,
            pronargdefaults = EXCLUDED.pronargdefaults,
            prorettype = EXCLUDED.prorettype,
            proargtypes = EXCLUDED.proargtypes,
            proallargtypes = EXCLUDED.proallargtypes,
            proargmodes = EXCLUDED.proargmodes,
            proargnames = EXCLUDED.proargnames,
            proargdefaults = EXCLUDED.proargdefaults,
            protrftypes = EXCLUDED.protrftypes,
            prosrc = EXCLUDED.prosrc,
            probin = EXCLUDED.probin,
            prosqlbody = EXCLUDED.prosqlbody,
            proconfig = EXCLUDED.proconfig,
            proacl = EXCLUDED.proacl
          returning oid, proname, pronamespace, proowner, prolang, procost, prorows, provariadic, prosupport, prokind, prosecdef, proleakproof, proisstrict, proretset, provolatile, proparallel, pronargs, pronargdefaults, prorettype, proargtypes, proallargtypes, proargmodes, proargnames, proargdefaults, protrftypes, prosrc, probin, prosqlbody, proconfig, proacl
       """
      .executeInsert(PgProcRow.rowParser(1).single)
    
  }
}
