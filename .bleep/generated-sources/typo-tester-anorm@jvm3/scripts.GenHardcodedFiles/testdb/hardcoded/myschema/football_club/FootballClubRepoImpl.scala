/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

import anorm.SqlStringInterpolation
import java.sql.Connection

object FootballClubRepoImpl extends FootballClubRepo {
  override def delete(id: FootballClubId)(implicit c: Connection): Boolean = {
    SQL"""delete from myschema.football_club where "id" = $id""".executeUpdate() > 0
  }
  override def insert(unsaved: FootballClubRow)(implicit c: Connection): FootballClubRow = {
    SQL"""insert into myschema.football_club("id", "name")
          values (${unsaved.id}::int8, ${unsaved.name})
          returning "id", "name"
       """
      .executeInsert(FootballClubRow.rowParser(1).single)
    
  }
  override def selectAll(implicit c: Connection): List[FootballClubRow] = {
    SQL"""select "id", "name"
          from myschema.football_club
       """.as(FootballClubRow.rowParser(1).*)
  }
  override def selectById(id: FootballClubId)(implicit c: Connection): Option[FootballClubRow] = {
    SQL"""select "id", "name"
          from myschema.football_club
          where "id" = $id
       """.as(FootballClubRow.rowParser(1).singleOpt)
  }
  override def selectByIds(ids: Array[FootballClubId])(implicit c: Connection): List[FootballClubRow] = {
    SQL"""select "id", "name"
          from myschema.football_club
          where "id" = ANY($ids)
       """.as(FootballClubRow.rowParser(1).*)
    
  }
  override def update(row: FootballClubRow)(implicit c: Connection): Boolean = {
    val id = row.id
    SQL"""update myschema.football_club
          set "name" = ${row.name}
          where "id" = $id
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: FootballClubRow)(implicit c: Connection): FootballClubRow = {
    SQL"""insert into myschema.football_club("id", "name")
          values (
            ${unsaved.id}::int8,
            ${unsaved.name}
          )
          on conflict ("id")
          do update set
            "name" = EXCLUDED."name"
          returning "id", "name"
       """
      .executeInsert(FootballClubRow.rowParser(1).single)
    
  }
}
