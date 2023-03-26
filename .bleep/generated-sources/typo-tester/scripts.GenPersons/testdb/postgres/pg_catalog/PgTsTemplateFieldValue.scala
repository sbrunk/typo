/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import org.postgresql.util.PGobject

sealed abstract class PgTsTemplateFieldValue[T](val name: String, val value: T)

object PgTsTemplateFieldValue {
  case class oid(override val value: PgTsTemplateId) extends PgTsTemplateFieldValue("oid", value)
  case class tmplname(override val value: String) extends PgTsTemplateFieldValue("tmplname", value)
  case class tmplnamespace(override val value: /* oid */ Long) extends PgTsTemplateFieldValue("tmplnamespace", value)
  case class tmplinit(override val value: /* regproc */ PGobject) extends PgTsTemplateFieldValue("tmplinit", value)
  case class tmpllexize(override val value: /* regproc */ PGobject) extends PgTsTemplateFieldValue("tmpllexize", value)
}
