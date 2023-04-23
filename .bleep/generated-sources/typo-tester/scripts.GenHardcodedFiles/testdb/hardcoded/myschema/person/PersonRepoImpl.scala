/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import testdb.hardcoded.Defaulted
import testdb.hardcoded.myschema.Sector
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.marital_status.MaritalStatusId

object PersonRepoImpl extends PersonRepo {
  override def delete(id: PersonId)(implicit c: Connection): Boolean = {
    SQL"""delete from myschema.person where "id" = $id""".executeUpdate() > 0
  }
  override def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonRow = {
    val namedParameters = List(
      Some((NamedParameter("favourite_football_club_id", ParameterValue.from(unsaved.favouriteFootballClubId)), "")),
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), "")),
      Some((NamedParameter("nick_name", ParameterValue.from(unsaved.nickName)), "")),
      Some((NamedParameter("blog_url", ParameterValue.from(unsaved.blogUrl)), "")),
      Some((NamedParameter("email", ParameterValue.from(unsaved.email)), "")),
      Some((NamedParameter("phone", ParameterValue.from(unsaved.phone)), "")),
      Some((NamedParameter("likes_pizza", ParameterValue.from(unsaved.likesPizza)), "")),
      unsaved.maritalStatusId match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("marital_status_id", ParameterValue.from[MaritalStatusId](value)), ""))
      },
      Some((NamedParameter("work_email", ParameterValue.from(unsaved.workEmail)), "")),
      unsaved.sector match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("sector", ParameterValue.from[Sector](value)), "::myschema.sector"))
      }
    ).flatten
    
    if (namedParameters.isEmpty) {
      SQL"""insert into myschema.person default values
            returning "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into myschema.person(${namedParameters.map{case (x, _) => "\"" + x.name + "\""}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[PersonRow] = {
    SQL"""select "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
          from myschema.person
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[_]])(implicit c: Connection): List[PersonRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PersonFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case PersonFieldValue.favouriteFootballClubId(value) => NamedParameter("favourite_football_club_id", ParameterValue.from(value))
          case PersonFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PersonFieldValue.nickName(value) => NamedParameter("nick_name", ParameterValue.from(value))
          case PersonFieldValue.blogUrl(value) => NamedParameter("blog_url", ParameterValue.from(value))
          case PersonFieldValue.email(value) => NamedParameter("email", ParameterValue.from(value))
          case PersonFieldValue.phone(value) => NamedParameter("phone", ParameterValue.from(value))
          case PersonFieldValue.likesPizza(value) => NamedParameter("likes_pizza", ParameterValue.from(value))
          case PersonFieldValue.maritalStatusId(value) => NamedParameter("marital_status_id", ParameterValue.from(value))
          case PersonFieldValue.workEmail(value) => NamedParameter("work_email", ParameterValue.from(value))
          case PersonFieldValue.sector(value) => NamedParameter("sector", ParameterValue.from(value))
        }
        val q = s"""select "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
                    from myschema.person
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(id: PersonId)(implicit c: Connection): Option[PersonRow] = {
    SQL"""select "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
          from myschema.person
          where "id" = $id
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(ids: Array[PersonId])(implicit c: Connection): List[PersonRow] = {
    implicit val toStatement: ToStatement[Array[PersonId]] =
      (s: PreparedStatement, index: Int, v: Array[PersonId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int8", v.map(x => x.value: java.lang.Long)))
    
    SQL"""select "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
          from myschema.person
          where "id" = ANY($ids)
       """.as(rowParser.*)
  
  }
  override def update(row: PersonRow)(implicit c: Connection): Boolean = {
    val id = row.id
    SQL"""update myschema.person
          set favourite_football_club_id = ${row.favouriteFootballClubId},
              "name" = ${row.name},
              nick_name = ${row.nickName},
              blog_url = ${row.blogUrl},
              email = ${row.email},
              phone = ${row.phone},
              likes_pizza = ${row.likesPizza},
              marital_status_id = ${row.maritalStatusId},
              work_email = ${row.workEmail},
              sector = ${row.sector}
          where "id" = $id
       """.executeUpdate() > 0
  }
  override def updateFieldValues(id: PersonId, fieldValues: List[PersonFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PersonFieldValue.favouriteFootballClubId(value) => NamedParameter("favourite_football_club_id", ParameterValue.from(value))
          case PersonFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PersonFieldValue.nickName(value) => NamedParameter("nick_name", ParameterValue.from(value))
          case PersonFieldValue.blogUrl(value) => NamedParameter("blog_url", ParameterValue.from(value))
          case PersonFieldValue.email(value) => NamedParameter("email", ParameterValue.from(value))
          case PersonFieldValue.phone(value) => NamedParameter("phone", ParameterValue.from(value))
          case PersonFieldValue.likesPizza(value) => NamedParameter("likes_pizza", ParameterValue.from(value))
          case PersonFieldValue.maritalStatusId(value) => NamedParameter("marital_status_id", ParameterValue.from(value))
          case PersonFieldValue.workEmail(value) => NamedParameter("work_email", ParameterValue.from(value))
          case PersonFieldValue.sector(value) => NamedParameter("sector", ParameterValue.from(value))
        }
        val q = s"""update myschema.person
                    set ${namedParams.map(x => s"\"${x.name}\" = {${x.name}}").mkString(", ")}
                    where "id" = {id}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("id", ParameterValue.from(id)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[PersonRow] =
    RowParser[PersonRow] { row =>
      Success(
        PersonRow(
          id = row[PersonId]("id"),
          favouriteFootballClubId = row[FootballClubId]("favourite_football_club_id"),
          name = row[String]("name"),
          nickName = row[Option[String]]("nick_name"),
          blogUrl = row[Option[String]]("blog_url"),
          email = row[String]("email"),
          phone = row[String]("phone"),
          likesPizza = row[Boolean]("likes_pizza"),
          maritalStatusId = row[MaritalStatusId]("marital_status_id"),
          workEmail = row[Option[String]]("work_email"),
          sector = row[Sector]("sector")
        )
      )
    }
}
