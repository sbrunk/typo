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



sealed abstract class PgDependFieldValue[T](val name: String, val value: T)

object PgDependFieldValue {
  case class classid(override val value: /* oid */ Long) extends PgDependFieldValue("classid", value)
  case class objid(override val value: /* oid */ Long) extends PgDependFieldValue("objid", value)
  case class objsubid(override val value: Int) extends PgDependFieldValue("objsubid", value)
  case class refclassid(override val value: /* oid */ Long) extends PgDependFieldValue("refclassid", value)
  case class refobjid(override val value: /* oid */ Long) extends PgDependFieldValue("refobjid", value)
  case class refobjsubid(override val value: Int) extends PgDependFieldValue("refobjsubid", value)
  case class deptype(override val value: String) extends PgDependFieldValue("deptype", value)
}
