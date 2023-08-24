/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person_detail

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import fs2.Stream

trait PersonDetailSqlRepo {
  def apply(businessentityid: /* user-picked */ BusinessentityId, modifiedAfter: TypoLocalDateTime): Stream[ConnectionIO, PersonDetailSqlRow]
}
