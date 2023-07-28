/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime
import java.util.UUID

object SalestaxrateRepoImpl extends SalestaxrateRepo {
  override def delete(salestaxrateid: SalestaxrateId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.salestaxrate where salestaxrateid = $salestaxrateid".executeUpdate() > 0
  }
  override def insert(unsaved: SalestaxrateRow)(implicit c: Connection): SalestaxrateRow = {
    SQL"""insert into sales.salestaxrate(salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate)
          values (${unsaved.salestaxrateid}::int4, ${unsaved.stateprovinceid}::int4, ${unsaved.taxtype}::int2, ${unsaved.taxrate}::numeric, ${unsaved.name}::"public"."Name", ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
       """
      .executeInsert(SalestaxrateRow.rowParser(1).single)
  
  }
  override def insert(unsaved: SalestaxrateRowUnsaved)(implicit c: Connection): SalestaxrateRow = {
    val namedParameters = List(
      Some((NamedParameter("stateprovinceid", ParameterValue.from(unsaved.stateprovinceid)), "::int4")),
      Some((NamedParameter("taxtype", ParameterValue.from(unsaved.taxtype)), "::int2")),
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.salestaxrateid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("salestaxrateid", ParameterValue.from[SalestaxrateId](value)), "::int4"))
      },
      unsaved.taxrate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("taxrate", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.salestaxrate default values
            returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
         """
        .executeInsert(SalestaxrateRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salestaxrate(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(SalestaxrateRow.rowParser(1).single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[SalestaxrateRow] = {
    SQL"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
          from sales.salestaxrate
       """.as(SalestaxrateRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[SalestaxrateFieldOrIdValue[_]])(implicit c: Connection): List[SalestaxrateRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SalestaxrateFieldValue.salestaxrateid(value) => NamedParameter("salestaxrateid", ParameterValue.from(value))
          case SalestaxrateFieldValue.stateprovinceid(value) => NamedParameter("stateprovinceid", ParameterValue.from(value))
          case SalestaxrateFieldValue.taxtype(value) => NamedParameter("taxtype", ParameterValue.from(value))
          case SalestaxrateFieldValue.taxrate(value) => NamedParameter("taxrate", ParameterValue.from(value))
          case SalestaxrateFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case SalestaxrateFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SalestaxrateFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
                    from sales.salestaxrate
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(SalestaxrateRow.rowParser(1).*)
    }
  
  }
  override def selectById(salestaxrateid: SalestaxrateId)(implicit c: Connection): Option[SalestaxrateRow] = {
    SQL"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
          from sales.salestaxrate
          where salestaxrateid = $salestaxrateid
       """.as(SalestaxrateRow.rowParser(1).singleOpt)
  }
  override def selectByIds(salestaxrateids: Array[SalestaxrateId])(implicit c: Connection): List[SalestaxrateRow] = {
    implicit val toStatement: ToStatement[Array[SalestaxrateId]] =
      (s: PreparedStatement, index: Int, v: Array[SalestaxrateId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
          from sales.salestaxrate
          where salestaxrateid = ANY($salestaxrateids)
       """.as(SalestaxrateRow.rowParser(1).*)
  
  }
  override def update(row: SalestaxrateRow)(implicit c: Connection): Boolean = {
    val salestaxrateid = row.salestaxrateid
    SQL"""update sales.salestaxrate
          set stateprovinceid = ${row.stateprovinceid}::int4,
              taxtype = ${row.taxtype}::int2,
              taxrate = ${row.taxrate}::numeric,
              "name" = ${row.name}::"public"."Name",
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where salestaxrateid = $salestaxrateid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(salestaxrateid: SalestaxrateId, fieldValues: List[SalestaxrateFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SalestaxrateFieldValue.stateprovinceid(value) => NamedParameter("stateprovinceid", ParameterValue.from(value))
          case SalestaxrateFieldValue.taxtype(value) => NamedParameter("taxtype", ParameterValue.from(value))
          case SalestaxrateFieldValue.taxrate(value) => NamedParameter("taxrate", ParameterValue.from(value))
          case SalestaxrateFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case SalestaxrateFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SalestaxrateFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update sales.salestaxrate
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where salestaxrateid = {salestaxrateid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("salestaxrateid", ParameterValue.from(salestaxrateid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: SalestaxrateRow)(implicit c: Connection): SalestaxrateRow = {
    SQL"""insert into sales.salestaxrate(salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate)
          values (
            ${unsaved.salestaxrateid}::int4,
            ${unsaved.stateprovinceid}::int4,
            ${unsaved.taxtype}::int2,
            ${unsaved.taxrate}::numeric,
            ${unsaved.name}::"public"."Name",
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (salestaxrateid)
          do update set
            stateprovinceid = EXCLUDED.stateprovinceid,
            taxtype = EXCLUDED.taxtype,
            taxrate = EXCLUDED.taxrate,
            "name" = EXCLUDED."name",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
       """
      .executeInsert(SalestaxrateRow.rowParser(1).single)
  
  }
}
