/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_available_extension_versions

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgAvailableExtensionVersionsViewRepo {
  def select: SelectBuilder[PgAvailableExtensionVersionsViewFields, PgAvailableExtensionVersionsViewRow]
  def selectAll(implicit c: Connection): List[PgAvailableExtensionVersionsViewRow]
}
