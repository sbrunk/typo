/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_type

import adventureworks.customtypes.TypoAclItem
import adventureworks.customtypes.TypoPgNodeTree
import adventureworks.customtypes.TypoRegproc
import adventureworks.customtypes.TypoShort
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgTypeRepoImpl extends PgTypeRepo {
  override def delete(oid: PgTypeId): ConnectionIO[Boolean] = {
    sql"""delete from pg_catalog.pg_type where "oid" = ${fromWrite(oid)(Write.fromPut(PgTypeId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgTypeFields, PgTypeRow] = {
    DeleteBuilder("pg_catalog.pg_type", PgTypeFields)
  }
  override def insert(unsaved: PgTypeRow): ConnectionIO[PgTypeRow] = {
    sql"""insert into pg_catalog.pg_type("oid", "typname", "typnamespace", "typowner", "typlen", "typbyval", "typtype", "typcategory", "typispreferred", "typisdefined", "typdelim", "typrelid", "typsubscript", "typelem", "typarray", "typinput", "typoutput", "typreceive", "typsend", "typmodin", "typmodout", "typanalyze", "typalign", "typstorage", "typnotnull", "typbasetype", "typtypmod", "typndims", "typcollation", "typdefaultbin", "typdefault", "typacl")
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgTypeId.put))}::oid, ${fromWrite(unsaved.typname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.typnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.typowner)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.typlen)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.typbyval)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.typtype)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.typcategory)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.typispreferred)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.typisdefined)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.typdelim)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.typrelid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.typsubscript)(Write.fromPut(TypoRegproc.put))}::regproc, ${fromWrite(unsaved.typelem)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.typarray)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.typinput)(Write.fromPut(TypoRegproc.put))}::regproc, ${fromWrite(unsaved.typoutput)(Write.fromPut(TypoRegproc.put))}::regproc, ${fromWrite(unsaved.typreceive)(Write.fromPut(TypoRegproc.put))}::regproc, ${fromWrite(unsaved.typsend)(Write.fromPut(TypoRegproc.put))}::regproc, ${fromWrite(unsaved.typmodin)(Write.fromPut(TypoRegproc.put))}::regproc, ${fromWrite(unsaved.typmodout)(Write.fromPut(TypoRegproc.put))}::regproc, ${fromWrite(unsaved.typanalyze)(Write.fromPut(TypoRegproc.put))}::regproc, ${fromWrite(unsaved.typalign)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.typstorage)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.typnotnull)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.typbasetype)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.typtypmod)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.typndims)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.typcollation)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.typdefaultbin)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree, ${fromWrite(unsaved.typdefault)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.typacl)(Write.fromPutOption(TypoAclItem.arrayPut))}::_aclitem)
          returning "oid", "typname", "typnamespace", "typowner", "typlen", "typbyval", "typtype", "typcategory", "typispreferred", "typisdefined", "typdelim", "typrelid", "typsubscript", "typelem", "typarray", "typinput", "typoutput", "typreceive", "typsend", "typmodin", "typmodout", "typanalyze", "typalign", "typstorage", "typnotnull", "typbasetype", "typtypmod", "typndims", "typcollation", "typdefaultbin", "typdefault", "typacl"
       """.query(PgTypeRow.read).unique
  }
  override def select: SelectBuilder[PgTypeFields, PgTypeRow] = {
    SelectBuilderSql("pg_catalog.pg_type", PgTypeFields, PgTypeRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgTypeRow] = {
    sql"""select "oid", "typname", "typnamespace", "typowner", "typlen", "typbyval", "typtype", "typcategory", "typispreferred", "typisdefined", "typdelim", "typrelid", "typsubscript", "typelem", "typarray", "typinput", "typoutput", "typreceive", "typsend", "typmodin", "typmodout", "typanalyze", "typalign", "typstorage", "typnotnull", "typbasetype", "typtypmod", "typndims", "typcollation", "typdefaultbin", "typdefault", "typacl" from pg_catalog.pg_type""".query(PgTypeRow.read).stream
  }
  override def selectById(oid: PgTypeId): ConnectionIO[Option[PgTypeRow]] = {
    sql"""select "oid", "typname", "typnamespace", "typowner", "typlen", "typbyval", "typtype", "typcategory", "typispreferred", "typisdefined", "typdelim", "typrelid", "typsubscript", "typelem", "typarray", "typinput", "typoutput", "typreceive", "typsend", "typmodin", "typmodout", "typanalyze", "typalign", "typstorage", "typnotnull", "typbasetype", "typtypmod", "typndims", "typcollation", "typdefaultbin", "typdefault", "typacl" from pg_catalog.pg_type where "oid" = ${fromWrite(oid)(Write.fromPut(PgTypeId.put))}""".query(PgTypeRow.read).option
  }
  override def selectByIds(oids: Array[PgTypeId]): Stream[ConnectionIO, PgTypeRow] = {
    sql"""select "oid", "typname", "typnamespace", "typowner", "typlen", "typbyval", "typtype", "typcategory", "typispreferred", "typisdefined", "typdelim", "typrelid", "typsubscript", "typelem", "typarray", "typinput", "typoutput", "typreceive", "typsend", "typmodin", "typmodout", "typanalyze", "typalign", "typstorage", "typnotnull", "typbasetype", "typtypmod", "typndims", "typcollation", "typdefaultbin", "typdefault", "typacl" from pg_catalog.pg_type where "oid" = ANY(${oids})""".query(PgTypeRow.read).stream
  }
  override def selectByUnique(typname: String, typnamespace: /* oid */ Long): ConnectionIO[Option[PgTypeRow]] = {
    sql"""select "typname", "typnamespace"
          from pg_catalog.pg_type
          where "typname" = ${fromWrite(typname)(Write.fromPut(Meta.StringMeta.put))} AND "typnamespace" = ${fromWrite(typnamespace)(Write.fromPut(Meta.LongMeta.put))}
       """.query(PgTypeRow.read).option
  }
  override def update(row: PgTypeRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_type
          set "typname" = ${fromWrite(row.typname)(Write.fromPut(Meta.StringMeta.put))}::name,
              "typnamespace" = ${fromWrite(row.typnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
              "typowner" = ${fromWrite(row.typowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
              "typlen" = ${fromWrite(row.typlen)(Write.fromPut(TypoShort.put))}::int2,
              "typbyval" = ${fromWrite(row.typbyval)(Write.fromPut(Meta.BooleanMeta.put))},
              "typtype" = ${fromWrite(row.typtype)(Write.fromPut(Meta.StringMeta.put))}::char,
              "typcategory" = ${fromWrite(row.typcategory)(Write.fromPut(Meta.StringMeta.put))}::char,
              "typispreferred" = ${fromWrite(row.typispreferred)(Write.fromPut(Meta.BooleanMeta.put))},
              "typisdefined" = ${fromWrite(row.typisdefined)(Write.fromPut(Meta.BooleanMeta.put))},
              "typdelim" = ${fromWrite(row.typdelim)(Write.fromPut(Meta.StringMeta.put))}::char,
              "typrelid" = ${fromWrite(row.typrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              "typsubscript" = ${fromWrite(row.typsubscript)(Write.fromPut(TypoRegproc.put))}::regproc,
              "typelem" = ${fromWrite(row.typelem)(Write.fromPut(Meta.LongMeta.put))}::oid,
              "typarray" = ${fromWrite(row.typarray)(Write.fromPut(Meta.LongMeta.put))}::oid,
              "typinput" = ${fromWrite(row.typinput)(Write.fromPut(TypoRegproc.put))}::regproc,
              "typoutput" = ${fromWrite(row.typoutput)(Write.fromPut(TypoRegproc.put))}::regproc,
              "typreceive" = ${fromWrite(row.typreceive)(Write.fromPut(TypoRegproc.put))}::regproc,
              "typsend" = ${fromWrite(row.typsend)(Write.fromPut(TypoRegproc.put))}::regproc,
              "typmodin" = ${fromWrite(row.typmodin)(Write.fromPut(TypoRegproc.put))}::regproc,
              "typmodout" = ${fromWrite(row.typmodout)(Write.fromPut(TypoRegproc.put))}::regproc,
              "typanalyze" = ${fromWrite(row.typanalyze)(Write.fromPut(TypoRegproc.put))}::regproc,
              "typalign" = ${fromWrite(row.typalign)(Write.fromPut(Meta.StringMeta.put))}::char,
              "typstorage" = ${fromWrite(row.typstorage)(Write.fromPut(Meta.StringMeta.put))}::char,
              "typnotnull" = ${fromWrite(row.typnotnull)(Write.fromPut(Meta.BooleanMeta.put))},
              "typbasetype" = ${fromWrite(row.typbasetype)(Write.fromPut(Meta.LongMeta.put))}::oid,
              "typtypmod" = ${fromWrite(row.typtypmod)(Write.fromPut(Meta.IntMeta.put))}::int4,
              "typndims" = ${fromWrite(row.typndims)(Write.fromPut(Meta.IntMeta.put))}::int4,
              "typcollation" = ${fromWrite(row.typcollation)(Write.fromPut(Meta.LongMeta.put))}::oid,
              "typdefaultbin" = ${fromWrite(row.typdefaultbin)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree,
              "typdefault" = ${fromWrite(row.typdefault)(Write.fromPutOption(Meta.StringMeta.put))},
              "typacl" = ${fromWrite(row.typacl)(Write.fromPutOption(TypoAclItem.arrayPut))}::_aclitem
          where "oid" = ${fromWrite(oid)(Write.fromPut(PgTypeId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgTypeFields, PgTypeRow] = {
    UpdateBuilder("pg_catalog.pg_type", PgTypeFields, PgTypeRow.read)
  }
  override def upsert(unsaved: PgTypeRow): ConnectionIO[PgTypeRow] = {
    sql"""insert into pg_catalog.pg_type("oid", "typname", "typnamespace", "typowner", "typlen", "typbyval", "typtype", "typcategory", "typispreferred", "typisdefined", "typdelim", "typrelid", "typsubscript", "typelem", "typarray", "typinput", "typoutput", "typreceive", "typsend", "typmodin", "typmodout", "typanalyze", "typalign", "typstorage", "typnotnull", "typbasetype", "typtypmod", "typndims", "typcollation", "typdefaultbin", "typdefault", "typacl")
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgTypeId.put))}::oid,
            ${fromWrite(unsaved.typname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.typnamespace)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.typowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.typlen)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.typbyval)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.typtype)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.typcategory)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.typispreferred)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.typisdefined)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.typdelim)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.typrelid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.typsubscript)(Write.fromPut(TypoRegproc.put))}::regproc,
            ${fromWrite(unsaved.typelem)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.typarray)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.typinput)(Write.fromPut(TypoRegproc.put))}::regproc,
            ${fromWrite(unsaved.typoutput)(Write.fromPut(TypoRegproc.put))}::regproc,
            ${fromWrite(unsaved.typreceive)(Write.fromPut(TypoRegproc.put))}::regproc,
            ${fromWrite(unsaved.typsend)(Write.fromPut(TypoRegproc.put))}::regproc,
            ${fromWrite(unsaved.typmodin)(Write.fromPut(TypoRegproc.put))}::regproc,
            ${fromWrite(unsaved.typmodout)(Write.fromPut(TypoRegproc.put))}::regproc,
            ${fromWrite(unsaved.typanalyze)(Write.fromPut(TypoRegproc.put))}::regproc,
            ${fromWrite(unsaved.typalign)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.typstorage)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.typnotnull)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.typbasetype)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.typtypmod)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.typndims)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.typcollation)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.typdefaultbin)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree,
            ${fromWrite(unsaved.typdefault)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.typacl)(Write.fromPutOption(TypoAclItem.arrayPut))}::_aclitem
          )
          on conflict ("oid")
          do update set
            "typname" = EXCLUDED."typname",
            "typnamespace" = EXCLUDED."typnamespace",
            "typowner" = EXCLUDED."typowner",
            "typlen" = EXCLUDED."typlen",
            "typbyval" = EXCLUDED."typbyval",
            "typtype" = EXCLUDED."typtype",
            "typcategory" = EXCLUDED."typcategory",
            "typispreferred" = EXCLUDED."typispreferred",
            "typisdefined" = EXCLUDED."typisdefined",
            "typdelim" = EXCLUDED."typdelim",
            "typrelid" = EXCLUDED."typrelid",
            "typsubscript" = EXCLUDED."typsubscript",
            "typelem" = EXCLUDED."typelem",
            "typarray" = EXCLUDED."typarray",
            "typinput" = EXCLUDED."typinput",
            "typoutput" = EXCLUDED."typoutput",
            "typreceive" = EXCLUDED."typreceive",
            "typsend" = EXCLUDED."typsend",
            "typmodin" = EXCLUDED."typmodin",
            "typmodout" = EXCLUDED."typmodout",
            "typanalyze" = EXCLUDED."typanalyze",
            "typalign" = EXCLUDED."typalign",
            "typstorage" = EXCLUDED."typstorage",
            "typnotnull" = EXCLUDED."typnotnull",
            "typbasetype" = EXCLUDED."typbasetype",
            "typtypmod" = EXCLUDED."typtypmod",
            "typndims" = EXCLUDED."typndims",
            "typcollation" = EXCLUDED."typcollation",
            "typdefaultbin" = EXCLUDED."typdefaultbin",
            "typdefault" = EXCLUDED."typdefault",
            "typacl" = EXCLUDED."typacl"
          returning "oid", "typname", "typnamespace", "typowner", "typlen", "typbyval", "typtype", "typcategory", "typispreferred", "typisdefined", "typdelim", "typrelid", "typsubscript", "typelem", "typarray", "typinput", "typoutput", "typreceive", "typsend", "typmodin", "typmodout", "typanalyze", "typalign", "typstorage", "typnotnull", "typbasetype", "typtypmod", "typndims", "typcollation", "typdefaultbin", "typdefault", "typacl"
       """.query(PgTypeRow.read).unique
  }
}
