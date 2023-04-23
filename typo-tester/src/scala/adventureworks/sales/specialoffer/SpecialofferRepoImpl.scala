/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import adventureworks.Defaulted
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
import java.util.UUID

object SpecialofferRepoImpl extends SpecialofferRepo {
  override def delete(specialofferid: SpecialofferId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.specialoffer where specialofferid = $specialofferid".executeUpdate() > 0
  }
  override def insert(unsaved: SpecialofferRowUnsaved)(implicit c: Connection): SpecialofferRow = {
    val namedParameters = List(
      Some((NamedParameter("description", ParameterValue.from(unsaved.description)), "")),
      unsaved.discountpct match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("discountpct", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      Some((NamedParameter("type", ParameterValue.from(unsaved.`type`)), "")),
      Some((NamedParameter("category", ParameterValue.from(unsaved.category)), "")),
      Some((NamedParameter("startdate", ParameterValue.from(unsaved.startdate)), "::timestamp")),
      Some((NamedParameter("enddate", ParameterValue.from(unsaved.enddate)), "::timestamp")),
      unsaved.minqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("minqty", ParameterValue.from[Int](value)), "::int4"))
      },
      Some((NamedParameter("maxqty", ParameterValue.from(unsaved.maxqty)), "::int4")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.specialoffer default values
            returning specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into sales.specialoffer(${namedParameters.map{case (x, _) => "\"" + x.name + "\""}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[SpecialofferRow] = {
    SQL"""select specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate
          from sales.specialoffer
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[SpecialofferFieldOrIdValue[_]])(implicit c: Connection): List[SpecialofferRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SpecialofferFieldValue.specialofferid(value) => NamedParameter("specialofferid", ParameterValue.from(value))
          case SpecialofferFieldValue.description(value) => NamedParameter("description", ParameterValue.from(value))
          case SpecialofferFieldValue.discountpct(value) => NamedParameter("discountpct", ParameterValue.from(value))
          case SpecialofferFieldValue.`type`(value) => NamedParameter("type", ParameterValue.from(value))
          case SpecialofferFieldValue.category(value) => NamedParameter("category", ParameterValue.from(value))
          case SpecialofferFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case SpecialofferFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case SpecialofferFieldValue.minqty(value) => NamedParameter("minqty", ParameterValue.from(value))
          case SpecialofferFieldValue.maxqty(value) => NamedParameter("maxqty", ParameterValue.from(value))
          case SpecialofferFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SpecialofferFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate
                    from sales.specialoffer
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(specialofferid: SpecialofferId)(implicit c: Connection): Option[SpecialofferRow] = {
    SQL"""select specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate
          from sales.specialoffer
          where specialofferid = $specialofferid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(specialofferids: Array[SpecialofferId])(implicit c: Connection): List[SpecialofferRow] = {
    implicit val toStatement: ToStatement[Array[SpecialofferId]] =
      (s: PreparedStatement, index: Int, v: Array[SpecialofferId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate
          from sales.specialoffer
          where specialofferid = ANY($specialofferids)
       """.as(rowParser.*)
  
  }
  override def update(row: SpecialofferRow)(implicit c: Connection): Boolean = {
    val specialofferid = row.specialofferid
    SQL"""update sales.specialoffer
          set description = ${row.description},
              discountpct = ${row.discountpct},
              "type" = ${row.`type`},
              category = ${row.category},
              startdate = ${row.startdate},
              enddate = ${row.enddate},
              minqty = ${row.minqty},
              maxqty = ${row.maxqty},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where specialofferid = $specialofferid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(specialofferid: SpecialofferId, fieldValues: List[SpecialofferFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SpecialofferFieldValue.description(value) => NamedParameter("description", ParameterValue.from(value))
          case SpecialofferFieldValue.discountpct(value) => NamedParameter("discountpct", ParameterValue.from(value))
          case SpecialofferFieldValue.`type`(value) => NamedParameter("type", ParameterValue.from(value))
          case SpecialofferFieldValue.category(value) => NamedParameter("category", ParameterValue.from(value))
          case SpecialofferFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case SpecialofferFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case SpecialofferFieldValue.minqty(value) => NamedParameter("minqty", ParameterValue.from(value))
          case SpecialofferFieldValue.maxqty(value) => NamedParameter("maxqty", ParameterValue.from(value))
          case SpecialofferFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SpecialofferFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update sales.specialoffer
                    set ${namedParams.map(x => s"\"${x.name}\" = {${x.name}}").mkString(", ")}
                    where specialofferid = {specialofferid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("specialofferid", ParameterValue.from(specialofferid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[SpecialofferRow] =
    RowParser[SpecialofferRow] { row =>
      Success(
        SpecialofferRow(
          specialofferid = row[SpecialofferId]("specialofferid"),
          description = row[String]("description"),
          discountpct = row[BigDecimal]("discountpct"),
          `type` = row[String]("type"),
          category = row[String]("category"),
          startdate = row[LocalDateTime]("startdate"),
          enddate = row[LocalDateTime]("enddate"),
          minqty = row[Int]("minqty"),
          maxqty = row[Option[Int]]("maxqty"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
