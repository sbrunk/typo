package adventureworks.update_person_returning

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.withConnection
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.funsuite.AnyFunSuite

class UpdatePersonReturningSqlRepoTest extends AnyFunSuite with TypeCheckedTripleEquals {
  test("timestamp works") {
    withConnection { implicit c =>
      UpdatePersonReturningSqlRepoImpl(Some("1"), Some(TypoLocalDateTime.now))
    }
  }
}
