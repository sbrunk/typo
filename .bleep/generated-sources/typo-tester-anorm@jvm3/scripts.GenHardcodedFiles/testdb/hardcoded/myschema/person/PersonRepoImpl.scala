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
import anorm.ParameterMetaData
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import testdb.hardcoded.customtypes.Defaulted
import testdb.hardcoded.myschema.Number
import testdb.hardcoded.myschema.Sector
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.marital_status.MaritalStatusId
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PersonRepoImpl extends PersonRepo {
  override def delete(id: PersonId)(implicit c: Connection): Boolean = {
    SQL"""delete from myschema.person where "id" = ${ParameterValue(id, null, PersonId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilder("myschema.person", PersonFields)
  }
  override def insert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    SQL"""insert into myschema.person("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number")
          values (${ParameterValue(unsaved.id, null, PersonId.toStatement)}::int8, ${ParameterValue(unsaved.favouriteFootballClubId, null, FootballClubId.toStatement)}, ${ParameterValue(unsaved.name, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.nickName, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.blogUrl, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.email, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.phone, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.likesPizza, null, ToStatement.booleanToStatement)}, ${ParameterValue(unsaved.maritalStatusId, null, MaritalStatusId.toStatement)}, ${ParameterValue(unsaved.workEmail, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.sector, null, Sector.toStatement)}::myschema.sector, ${ParameterValue(unsaved.favoriteNumber, null, Number.toStatement)}::myschema.number)
          returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
       """
      .executeInsert(PersonRow.rowParser(1).single)
    
  }
  override def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonRow = {
    val namedParameters = List(
      Some((NamedParameter("favourite_football_club_id", ParameterValue(unsaved.favouriteFootballClubId, null, FootballClubId.toStatement)), "")),
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, ToStatement.stringToStatement)), "")),
      Some((NamedParameter("nick_name", ParameterValue(unsaved.nickName, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      Some((NamedParameter("blog_url", ParameterValue(unsaved.blogUrl, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      Some((NamedParameter("email", ParameterValue(unsaved.email, null, ToStatement.stringToStatement)), "")),
      Some((NamedParameter("phone", ParameterValue(unsaved.phone, null, ToStatement.stringToStatement)), "")),
      Some((NamedParameter("likes_pizza", ParameterValue(unsaved.likesPizza, null, ToStatement.booleanToStatement)), "")),
      Some((NamedParameter("work_email", ParameterValue(unsaved.workEmail, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      unsaved.id match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("id", ParameterValue(value, null, PersonId.toStatement)), "::int8"))
      },
      unsaved.maritalStatusId match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("marital_status_id", ParameterValue(value, null, MaritalStatusId.toStatement)), ""))
      },
      unsaved.sector match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("sector", ParameterValue(value, null, Sector.toStatement)), "::myschema.sector"))
      },
      unsaved.favoriteNumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("favorite_number", ParameterValue(value, null, Number.toStatement)), "::myschema.number"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into myschema.person default values
            returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
         """
        .executeInsert(PersonRow.rowParser(1).single)
    } else {
      val q = s"""insert into myschema.person(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(PersonRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderSql("myschema.person", PersonFields, PersonRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PersonRow] = {
    SQL"""select "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
          from myschema.person
       """.as(PersonRow.rowParser(1).*)
  }
  override def selectById(id: PersonId)(implicit c: Connection): Option[PersonRow] = {
    SQL"""select "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
          from myschema.person
          where "id" = ${ParameterValue(id, null, PersonId.toStatement)}
       """.as(PersonRow.rowParser(1).singleOpt)
  }
  override def selectByIds(ids: Array[PersonId])(implicit c: Connection): List[PersonRow] = {
    SQL"""select "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
          from myschema.person
          where "id" = ANY(${ids})
       """.as(PersonRow.rowParser(1).*)
    
  }
  override def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[?]])(implicit c: Connection): List[PersonRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParameters = nonEmpty.map{
          case PersonFieldValue.id(value) => NamedParameter("id", ParameterValue(value, null, PersonId.toStatement))
          case PersonFieldValue.favouriteFootballClubId(value) => NamedParameter("favourite_football_club_id", ParameterValue(value, null, FootballClubId.toStatement))
          case PersonFieldValue.name(value) => NamedParameter("name", ParameterValue(value, null, ToStatement.stringToStatement))
          case PersonFieldValue.nickName(value) => NamedParameter("nick_name", ParameterValue(value, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData)))
          case PersonFieldValue.blogUrl(value) => NamedParameter("blog_url", ParameterValue(value, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData)))
          case PersonFieldValue.email(value) => NamedParameter("email", ParameterValue(value, null, ToStatement.stringToStatement))
          case PersonFieldValue.phone(value) => NamedParameter("phone", ParameterValue(value, null, ToStatement.stringToStatement))
          case PersonFieldValue.likesPizza(value) => NamedParameter("likes_pizza", ParameterValue(value, null, ToStatement.booleanToStatement))
          case PersonFieldValue.maritalStatusId(value) => NamedParameter("marital_status_id", ParameterValue(value, null, MaritalStatusId.toStatement))
          case PersonFieldValue.workEmail(value) => NamedParameter("work_email", ParameterValue(value, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData)))
          case PersonFieldValue.sector(value) => NamedParameter("sector", ParameterValue(value, null, Sector.toStatement))
          case PersonFieldValue.favoriteNumber(value) => NamedParameter("favorite_number", ParameterValue(value, null, Number.toStatement))
        }
        val quote = '"'.toString
        val q = s"""select "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
                    from myschema.person
                    where ${namedParameters.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        SimpleSql(SQL(q), namedParameters.map(_.tupled).toMap, RowParser.successful)
          .as(PersonRow.rowParser(1).*)
    }
    
  }
  override def update(row: PersonRow)(implicit c: Connection): Boolean = {
    val id = row.id
    SQL"""update myschema.person
          set "favourite_football_club_id" = ${ParameterValue(row.favouriteFootballClubId, null, FootballClubId.toStatement)},
              "name" = ${ParameterValue(row.name, null, ToStatement.stringToStatement)},
              "nick_name" = ${ParameterValue(row.nickName, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              "blog_url" = ${ParameterValue(row.blogUrl, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              "email" = ${ParameterValue(row.email, null, ToStatement.stringToStatement)},
              "phone" = ${ParameterValue(row.phone, null, ToStatement.stringToStatement)},
              "likes_pizza" = ${ParameterValue(row.likesPizza, null, ToStatement.booleanToStatement)},
              "marital_status_id" = ${ParameterValue(row.maritalStatusId, null, MaritalStatusId.toStatement)},
              "work_email" = ${ParameterValue(row.workEmail, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              "sector" = ${ParameterValue(row.sector, null, Sector.toStatement)}::myschema.sector,
              "favorite_number" = ${ParameterValue(row.favoriteNumber, null, Number.toStatement)}::myschema.number
          where "id" = ${ParameterValue(id, null, PersonId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilder("myschema.person", PersonFields, PersonRow.rowParser)
  }
  override def updateFieldValues(id: PersonId, fieldValues: List[PersonFieldValue[?]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParameters = nonEmpty.map{
          case PersonFieldValue.favouriteFootballClubId(value) => NamedParameter("favourite_football_club_id", ParameterValue(value, null, FootballClubId.toStatement))
          case PersonFieldValue.name(value) => NamedParameter("name", ParameterValue(value, null, ToStatement.stringToStatement))
          case PersonFieldValue.nickName(value) => NamedParameter("nick_name", ParameterValue(value, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData)))
          case PersonFieldValue.blogUrl(value) => NamedParameter("blog_url", ParameterValue(value, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData)))
          case PersonFieldValue.email(value) => NamedParameter("email", ParameterValue(value, null, ToStatement.stringToStatement))
          case PersonFieldValue.phone(value) => NamedParameter("phone", ParameterValue(value, null, ToStatement.stringToStatement))
          case PersonFieldValue.likesPizza(value) => NamedParameter("likes_pizza", ParameterValue(value, null, ToStatement.booleanToStatement))
          case PersonFieldValue.maritalStatusId(value) => NamedParameter("marital_status_id", ParameterValue(value, null, MaritalStatusId.toStatement))
          case PersonFieldValue.workEmail(value) => NamedParameter("work_email", ParameterValue(value, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData)))
          case PersonFieldValue.sector(value) => NamedParameter("sector", ParameterValue(value, null, Sector.toStatement))
          case PersonFieldValue.favoriteNumber(value) => NamedParameter("favorite_number", ParameterValue(value, null, Number.toStatement))
        }
        val quote = '"'.toString
        val q = s"""update myschema.person
                    set ${namedParameters.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where "id" = {id}
                 """
        SimpleSql(SQL(q), namedParameters.map(_.tupled).toMap ++ List(("id", ParameterValue(id, null, PersonId.toStatement))), RowParser.successful)
          .executeUpdate() > 0
    }
    
  }
  override def upsert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    SQL"""insert into myschema.person("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number")
          values (
            ${ParameterValue(unsaved.id, null, PersonId.toStatement)}::int8,
            ${ParameterValue(unsaved.favouriteFootballClubId, null, FootballClubId.toStatement)},
            ${ParameterValue(unsaved.name, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.nickName, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.blogUrl, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.email, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.phone, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.likesPizza, null, ToStatement.booleanToStatement)},
            ${ParameterValue(unsaved.maritalStatusId, null, MaritalStatusId.toStatement)},
            ${ParameterValue(unsaved.workEmail, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.sector, null, Sector.toStatement)}::myschema.sector,
            ${ParameterValue(unsaved.favoriteNumber, null, Number.toStatement)}::myschema.number
          )
          on conflict ("id")
          do update set
            "favourite_football_club_id" = EXCLUDED."favourite_football_club_id",
            "name" = EXCLUDED."name",
            "nick_name" = EXCLUDED."nick_name",
            "blog_url" = EXCLUDED."blog_url",
            "email" = EXCLUDED."email",
            "phone" = EXCLUDED."phone",
            "likes_pizza" = EXCLUDED."likes_pizza",
            "marital_status_id" = EXCLUDED."marital_status_id",
            "work_email" = EXCLUDED."work_email",
            "sector" = EXCLUDED."sector",
            "favorite_number" = EXCLUDED."favorite_number"
          returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
       """
      .executeInsert(PersonRow.rowParser(1).single)
    
  }
}
