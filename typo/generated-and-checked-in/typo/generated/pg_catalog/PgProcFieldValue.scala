/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import org.postgresql.util.PGobject

sealed abstract class PgProcFieldValue[T](val name: String, val value: T)

object PgProcFieldValue {
  case class oid(override val value: PgProcId) extends PgProcFieldValue("oid", value)
  case class proname(override val value: String) extends PgProcFieldValue("proname", value)
  case class pronamespace(override val value: /* oid */ Long) extends PgProcFieldValue("pronamespace", value)
  case class proowner(override val value: /* oid */ Long) extends PgProcFieldValue("proowner", value)
  case class prolang(override val value: /* oid */ Long) extends PgProcFieldValue("prolang", value)
  case class procost(override val value: Float) extends PgProcFieldValue("procost", value)
  case class prorows(override val value: Float) extends PgProcFieldValue("prorows", value)
  case class provariadic(override val value: /* oid */ Long) extends PgProcFieldValue("provariadic", value)
  case class prosupport(override val value: /* regproc */ PGobject) extends PgProcFieldValue("prosupport", value)
  case class prokind(override val value: String) extends PgProcFieldValue("prokind", value)
  case class prosecdef(override val value: Boolean) extends PgProcFieldValue("prosecdef", value)
  case class proleakproof(override val value: Boolean) extends PgProcFieldValue("proleakproof", value)
  case class proisstrict(override val value: Boolean) extends PgProcFieldValue("proisstrict", value)
  case class proretset(override val value: Boolean) extends PgProcFieldValue("proretset", value)
  case class provolatile(override val value: String) extends PgProcFieldValue("provolatile", value)
  case class proparallel(override val value: String) extends PgProcFieldValue("proparallel", value)
  case class pronargs(override val value: Int) extends PgProcFieldValue("pronargs", value)
  case class pronargdefaults(override val value: Int) extends PgProcFieldValue("pronargdefaults", value)
  case class prorettype(override val value: /* oid */ Long) extends PgProcFieldValue("prorettype", value)
  case class proargtypes(override val value: /* oidvector */ PGobject) extends PgProcFieldValue("proargtypes", value)
  case class proallargtypes(override val value: Option[Array[/* oid */ Long]]) extends PgProcFieldValue("proallargtypes", value)
  case class proargmodes(override val value: Option[Array[String]]) extends PgProcFieldValue("proargmodes", value)
  case class proargnames(override val value: Option[Array[String]]) extends PgProcFieldValue("proargnames", value)
  case class proargdefaults(override val value: Option[/* pg_node_tree */ PGobject]) extends PgProcFieldValue("proargdefaults", value)
  case class protrftypes(override val value: Option[Array[/* oid */ Long]]) extends PgProcFieldValue("protrftypes", value)
  case class prosrc(override val value: String) extends PgProcFieldValue("prosrc", value)
  case class probin(override val value: Option[String]) extends PgProcFieldValue("probin", value)
  case class prosqlbody(override val value: Option[/* pg_node_tree */ PGobject]) extends PgProcFieldValue("prosqlbody", value)
  case class proconfig(override val value: Option[Array[String]]) extends PgProcFieldValue("proconfig", value)
  case class proacl(override val value: Option[Array[/* aclitem */ PGobject]]) extends PgProcFieldValue("proacl", value)
}
