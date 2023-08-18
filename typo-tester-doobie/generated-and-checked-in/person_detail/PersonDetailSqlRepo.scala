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
  def opt(businessentityid: Option[/* user-picked */ BusinessentityId], modifiedAfter: Option[TypoLocalDateTime]): Stream[ConnectionIO, PersonDetailSqlRow]
  final def apply(businessentityid: /* user-picked */ BusinessentityId, modifiedAfter: TypoLocalDateTime): Stream[ConnectionIO, PersonDetailSqlRow] =
    opt(Option(businessentityid), Option(modifiedAfter))
}
