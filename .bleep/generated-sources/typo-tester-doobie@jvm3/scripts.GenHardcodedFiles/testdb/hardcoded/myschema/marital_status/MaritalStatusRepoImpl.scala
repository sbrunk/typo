/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragments
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object MaritalStatusRepoImpl extends MaritalStatusRepo {
  override def delete(id: MaritalStatusId): ConnectionIO[Boolean] = {
    sql"""delete from myschema.marital_status where "id" = ${fromWrite(id)(Write.fromPut(MaritalStatusId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[MaritalStatusFields, MaritalStatusRow] = {
    DeleteBuilder("myschema.marital_status", MaritalStatusFields)
  }
  override def insert(unsaved: MaritalStatusRow): ConnectionIO[MaritalStatusRow] = {
    sql"""insert into myschema.marital_status("id")
          values (${fromWrite(unsaved.id)(Write.fromPut(MaritalStatusId.put))}::int8)
          returning "id"
       """.query(MaritalStatusRow.read).unique
  }
  override def select: SelectBuilder[MaritalStatusFields, MaritalStatusRow] = {
    SelectBuilderSql("myschema.marital_status", MaritalStatusFields, MaritalStatusRow.read)
  }
  override def selectAll: Stream[ConnectionIO, MaritalStatusRow] = {
    sql"""select "id" from myschema.marital_status""".query(MaritalStatusRow.read).stream
  }
  override def selectById(id: MaritalStatusId): ConnectionIO[Option[MaritalStatusRow]] = {
    sql"""select "id" from myschema.marital_status where "id" = ${fromWrite(id)(Write.fromPut(MaritalStatusId.put))}""".query(MaritalStatusRow.read).option
  }
  override def selectByIds(ids: Array[MaritalStatusId]): Stream[ConnectionIO, MaritalStatusRow] = {
    sql"""select "id" from myschema.marital_status where "id" = ANY(${ids})""".query(MaritalStatusRow.read).stream
  }
  override def selectByFieldValues(fieldValues: List[MaritalStatusFieldOrIdValue[?]]): Stream[ConnectionIO, MaritalStatusRow] = {
    val where = fragments.whereAndOpt(
      fieldValues.map {
        case MaritalStatusFieldValue.id(value) => fr""""id" = ${fromWrite(value)(Write.fromPut(MaritalStatusId.put))}"""
      }
    )
    sql"""select "id" from myschema.marital_status $where""".query(MaritalStatusRow.read).stream
  }
  override def update: UpdateBuilder[MaritalStatusFields, MaritalStatusRow] = {
    UpdateBuilder("myschema.marital_status", MaritalStatusFields, MaritalStatusRow.read)
  }
  override def upsert(unsaved: MaritalStatusRow): ConnectionIO[MaritalStatusRow] = {
    sql"""insert into myschema.marital_status("id")
          values (
            ${fromWrite(unsaved.id)(Write.fromPut(MaritalStatusId.put))}::int8
          )
          on conflict ("id")
          do update set
            
          returning "id"
       """.query(MaritalStatusRow.read).unique
  }
}
