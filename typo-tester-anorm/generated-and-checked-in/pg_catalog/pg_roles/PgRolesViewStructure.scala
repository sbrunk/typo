/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_roles

import adventureworks.TypoOffsetDateTime
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgRolesViewStructure[Row](val prefix: Option[String], val extract: Row => PgRolesViewRow, val merge: (Row, PgRolesViewRow) => Row)
  extends Relation[PgRolesViewFields, PgRolesViewRow, Row]
    with PgRolesViewFields[Row] { outer =>

  override val rolname = new OptField[String, Row](prefix, "rolname", None, Some("name"))(x => extract(x).rolname, (row, value) => merge(row, extract(row).copy(rolname = value)))
  override val rolsuper = new OptField[Boolean, Row](prefix, "rolsuper", None, None)(x => extract(x).rolsuper, (row, value) => merge(row, extract(row).copy(rolsuper = value)))
  override val rolinherit = new OptField[Boolean, Row](prefix, "rolinherit", None, None)(x => extract(x).rolinherit, (row, value) => merge(row, extract(row).copy(rolinherit = value)))
  override val rolcreaterole = new OptField[Boolean, Row](prefix, "rolcreaterole", None, None)(x => extract(x).rolcreaterole, (row, value) => merge(row, extract(row).copy(rolcreaterole = value)))
  override val rolcreatedb = new OptField[Boolean, Row](prefix, "rolcreatedb", None, None)(x => extract(x).rolcreatedb, (row, value) => merge(row, extract(row).copy(rolcreatedb = value)))
  override val rolcanlogin = new OptField[Boolean, Row](prefix, "rolcanlogin", None, None)(x => extract(x).rolcanlogin, (row, value) => merge(row, extract(row).copy(rolcanlogin = value)))
  override val rolreplication = new OptField[Boolean, Row](prefix, "rolreplication", None, None)(x => extract(x).rolreplication, (row, value) => merge(row, extract(row).copy(rolreplication = value)))
  override val rolconnlimit = new OptField[Int, Row](prefix, "rolconnlimit", None, Some("int4"))(x => extract(x).rolconnlimit, (row, value) => merge(row, extract(row).copy(rolconnlimit = value)))
  override val rolpassword = new OptField[String, Row](prefix, "rolpassword", None, None)(x => extract(x).rolpassword, (row, value) => merge(row, extract(row).copy(rolpassword = value)))
  override val rolvaliduntil = new OptField[TypoOffsetDateTime, Row](prefix, "rolvaliduntil", Some("text"), Some("timestamptz"))(x => extract(x).rolvaliduntil, (row, value) => merge(row, extract(row).copy(rolvaliduntil = value)))
  override val rolbypassrls = new OptField[Boolean, Row](prefix, "rolbypassrls", None, None)(x => extract(x).rolbypassrls, (row, value) => merge(row, extract(row).copy(rolbypassrls = value)))
  override val rolconfig = new OptField[Array[String], Row](prefix, "rolconfig", None, Some("_text"))(x => extract(x).rolconfig, (row, value) => merge(row, extract(row).copy(rolconfig = value)))
  override val oid = new OptField[/* oid */ Long, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolconnlimit, rolpassword, rolvaliduntil, rolbypassrls, rolconfig, oid)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgRolesViewRow, merge: (NewRow, PgRolesViewRow) => NewRow): PgRolesViewStructure[NewRow] =
    new PgRolesViewStructure(prefix, extract, merge)
}
