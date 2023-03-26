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



sealed abstract class PgTsConfigMapFieldValue[T](val name: String, val value: T)

object PgTsConfigMapFieldValue {
  case class mapcfg(override val value: /* oid */ Long) extends PgTsConfigMapFieldValue("mapcfg", value)
  case class maptokentype(override val value: Int) extends PgTsConfigMapFieldValue("maptokentype", value)
  case class mapseqno(override val value: Int) extends PgTsConfigMapFieldValue("mapseqno", value)
  case class mapdict(override val value: /* oid */ Long) extends PgTsConfigMapFieldValue("mapdict", value)
}
