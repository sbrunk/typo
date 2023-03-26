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



sealed abstract class PgOpfamilyFieldValue[T](val name: String, val value: T)

object PgOpfamilyFieldValue {
  case class oid(override val value: PgOpfamilyId) extends PgOpfamilyFieldValue("oid", value)
  case class opfmethod(override val value: /* oid */ Long) extends PgOpfamilyFieldValue("opfmethod", value)
  case class opfname(override val value: String) extends PgOpfamilyFieldValue("opfname", value)
  case class opfnamespace(override val value: /* oid */ Long) extends PgOpfamilyFieldValue("opfnamespace", value)
  case class opfowner(override val value: /* oid */ Long) extends PgOpfamilyFieldValue("opfowner", value)
}
