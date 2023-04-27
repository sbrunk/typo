/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import adventureworks.Defaulted
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object LocationRepoImpl extends LocationRepo {
  override def delete(locationid: LocationId)(implicit c: Connection): Boolean = {
    SQL"""delete from production."location" where locationid = $locationid""".executeUpdate() > 0
  }
  override def insert(unsaved: LocationRowUnsaved)(implicit c: Connection): LocationRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.locationid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("locationid", ParameterValue.from[LocationId](value)), "::int4"))
      },
      unsaved.costrate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("costrate", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.availability match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("availability", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production."location" default values
            returning locationid, "name", costrate, availability, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into production."location"(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning locationid, "name", costrate, availability, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[LocationRow] = {
    SQL"""select locationid, "name", costrate, availability, modifieddate
          from production."location"
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[LocationFieldOrIdValue[_]])(implicit c: Connection): List[LocationRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case LocationFieldValue.locationid(value) => NamedParameter("locationid", ParameterValue.from(value))
          case LocationFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case LocationFieldValue.costrate(value) => NamedParameter("costrate", ParameterValue.from(value))
          case LocationFieldValue.availability(value) => NamedParameter("availability", ParameterValue.from(value))
          case LocationFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select locationid, "name", costrate, availability, modifieddate
                    from production."location"
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(locationid: LocationId)(implicit c: Connection): Option[LocationRow] = {
    SQL"""select locationid, "name", costrate, availability, modifieddate
          from production."location"
          where locationid = $locationid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(locationids: Array[LocationId])(implicit c: Connection): List[LocationRow] = {
    implicit val toStatement: ToStatement[Array[LocationId]] =
      (s: PreparedStatement, index: Int, v: Array[LocationId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select locationid, "name", costrate, availability, modifieddate
          from production."location"
          where locationid = ANY($locationids)
       """.as(rowParser.*)
  
  }
  override def update(row: LocationRow)(implicit c: Connection): Boolean = {
    val locationid = row.locationid
    SQL"""update production."location"
          set "name" = ${row.name}::"public"."Name",
              costrate = ${row.costrate}::numeric,
              availability = ${row.availability}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where locationid = $locationid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(locationid: LocationId, fieldValues: List[LocationFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case LocationFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case LocationFieldValue.costrate(value) => NamedParameter("costrate", ParameterValue.from(value))
          case LocationFieldValue.availability(value) => NamedParameter("availability", ParameterValue.from(value))
          case LocationFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update production."location"
                    set ${namedParams.map(x => s"${quote}${x.name}${quote} = {${x.name}}").mkString(", ")}
                    where locationid = {locationid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("locationid", ParameterValue.from(locationid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[LocationRow] =
    RowParser[LocationRow] { row =>
      Success(
        LocationRow(
          locationid = row[LocationId]("locationid"),
          name = row[Name]("name"),
          costrate = row[BigDecimal]("costrate"),
          availability = row[BigDecimal]("availability"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
