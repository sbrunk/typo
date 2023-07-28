/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_policy

import anorm.SqlStringInterpolation
import java.sql.Connection

object PgPolicyRepoImpl extends PgPolicyRepo {
  override def delete(oid: PgPolicyId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_policy where oid = $oid".executeUpdate() > 0
  }
  override def insert(unsaved: PgPolicyRow)(implicit c: Connection): PgPolicyRow = {
    SQL"""insert into pg_catalog.pg_policy(oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck)
          values (${unsaved.oid}::oid, ${unsaved.polname}::name, ${unsaved.polrelid}::oid, ${unsaved.polcmd}::char, ${unsaved.polpermissive}, ${unsaved.polroles}::_oid, ${unsaved.polqual}::pg_node_tree, ${unsaved.polwithcheck}::pg_node_tree)
          returning oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck
       """
      .executeInsert(PgPolicyRow.rowParser(1).single)
    
  }
  override def selectAll(implicit c: Connection): List[PgPolicyRow] = {
    SQL"""select oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck
          from pg_catalog.pg_policy
       """.as(PgPolicyRow.rowParser(1).*)
  }
  override def selectById(oid: PgPolicyId)(implicit c: Connection): Option[PgPolicyRow] = {
    SQL"""select oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck
          from pg_catalog.pg_policy
          where oid = $oid
       """.as(PgPolicyRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgPolicyId])(implicit c: Connection): List[PgPolicyRow] = {
    SQL"""select oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck
          from pg_catalog.pg_policy
          where oid = ANY($oids)
       """.as(PgPolicyRow.rowParser(1).*)
    
  }
  override def update(row: PgPolicyRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_policy
          set polname = ${row.polname}::name,
              polrelid = ${row.polrelid}::oid,
              polcmd = ${row.polcmd}::char,
              polpermissive = ${row.polpermissive},
              polroles = ${row.polroles}::_oid,
              polqual = ${row.polqual}::pg_node_tree,
              polwithcheck = ${row.polwithcheck}::pg_node_tree
          where oid = $oid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: PgPolicyRow)(implicit c: Connection): PgPolicyRow = {
    SQL"""insert into pg_catalog.pg_policy(oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.polname}::name,
            ${unsaved.polrelid}::oid,
            ${unsaved.polcmd}::char,
            ${unsaved.polpermissive},
            ${unsaved.polroles}::_oid,
            ${unsaved.polqual}::pg_node_tree,
            ${unsaved.polwithcheck}::pg_node_tree
          )
          on conflict (oid)
          do update set
            polname = EXCLUDED.polname,
            polrelid = EXCLUDED.polrelid,
            polcmd = EXCLUDED.polcmd,
            polpermissive = EXCLUDED.polpermissive,
            polroles = EXCLUDED.polroles,
            polqual = EXCLUDED.polqual,
            polwithcheck = EXCLUDED.polwithcheck
          returning oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck
       """
      .executeInsert(PgPolicyRow.rowParser(1).single)
    
  }
}
