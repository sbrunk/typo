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
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait PgTypeFields[Row] {
  val oid: IdField[PgTypeId, Row]
  val typname: Field[String, Row]
  val typnamespace: Field[/* oid */ Long, Row]
  val typowner: Field[/* oid */ Long, Row]
  val typlen: Field[TypoShort, Row]
  val typbyval: Field[Boolean, Row]
  val typtype: Field[String, Row]
  val typcategory: Field[String, Row]
  val typispreferred: Field[Boolean, Row]
  val typisdefined: Field[Boolean, Row]
  val typdelim: Field[String, Row]
  val typrelid: Field[/* oid */ Long, Row]
  val typsubscript: Field[TypoRegproc, Row]
  val typelem: Field[/* oid */ Long, Row]
  val typarray: Field[/* oid */ Long, Row]
  val typinput: Field[TypoRegproc, Row]
  val typoutput: Field[TypoRegproc, Row]
  val typreceive: Field[TypoRegproc, Row]
  val typsend: Field[TypoRegproc, Row]
  val typmodin: Field[TypoRegproc, Row]
  val typmodout: Field[TypoRegproc, Row]
  val typanalyze: Field[TypoRegproc, Row]
  val typalign: Field[String, Row]
  val typstorage: Field[String, Row]
  val typnotnull: Field[Boolean, Row]
  val typbasetype: Field[/* oid */ Long, Row]
  val typtypmod: Field[Int, Row]
  val typndims: Field[Int, Row]
  val typcollation: Field[/* oid */ Long, Row]
  val typdefaultbin: OptField[TypoPgNodeTree, Row]
  val typdefault: OptField[String, Row]
  val typacl: OptField[Array[TypoAclItem], Row]
}
object PgTypeFields extends PgTypeStructure[PgTypeRow](None, identity, (_, x) => x)

