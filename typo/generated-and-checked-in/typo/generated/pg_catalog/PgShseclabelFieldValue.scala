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



sealed abstract class PgShseclabelFieldValue[T](val name: String, val value: T)

object PgShseclabelFieldValue {
  case class objoid(override val value: /* oid */ Long) extends PgShseclabelFieldValue("objoid", value)
  case class classoid(override val value: /* oid */ Long) extends PgShseclabelFieldValue("classoid", value)
  case class provider(override val value: String) extends PgShseclabelFieldValue("provider", value)
  case class label(override val value: String) extends PgShseclabelFieldValue("label", value)
}
