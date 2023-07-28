/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentitycontact

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object BusinessentitycontactRepoImpl extends BusinessentitycontactRepo {
  override def delete(compositeId: BusinessentitycontactId)(implicit c: Connection): Boolean = {
    SQL"delete from person.businessentitycontact where businessentityid = ${compositeId.businessentityid} AND personid = ${compositeId.personid} AND contacttypeid = ${compositeId.contacttypeid}".executeUpdate() > 0
  }
  override def insert(unsaved: BusinessentitycontactRow)(implicit c: Connection): BusinessentitycontactRow = {
    SQL"""insert into person.businessentitycontact(businessentityid, personid, contacttypeid, rowguid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.personid}::int4, ${unsaved.contacttypeid}::int4, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, personid, contacttypeid, rowguid, modifieddate
       """
      .executeInsert(BusinessentitycontactRow.rowParser(1).single)
  
  }
  override def insert(unsaved: BusinessentitycontactRowUnsaved)(implicit c: Connection): BusinessentitycontactRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("personid", ParameterValue.from(unsaved.personid)), "::int4")),
      Some((NamedParameter("contacttypeid", ParameterValue.from(unsaved.contacttypeid)), "::int4")),
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
      SQL"""insert into person.businessentitycontact default values
            returning businessentityid, personid, contacttypeid, rowguid, modifieddate
         """
        .executeInsert(BusinessentitycontactRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.businessentitycontact(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, personid, contacttypeid, rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(BusinessentitycontactRow.rowParser(1).single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[BusinessentitycontactRow] = {
    SQL"""select businessentityid, personid, contacttypeid, rowguid, modifieddate
          from person.businessentitycontact
       """.as(BusinessentitycontactRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[BusinessentitycontactFieldOrIdValue[_]])(implicit c: Connection): List[BusinessentitycontactRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case BusinessentitycontactFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case BusinessentitycontactFieldValue.personid(value) => NamedParameter("personid", ParameterValue.from(value))
          case BusinessentitycontactFieldValue.contacttypeid(value) => NamedParameter("contacttypeid", ParameterValue.from(value))
          case BusinessentitycontactFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case BusinessentitycontactFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select businessentityid, personid, contacttypeid, rowguid, modifieddate
                    from person.businessentitycontact
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(BusinessentitycontactRow.rowParser(1).*)
    }
  
  }
  override def selectById(compositeId: BusinessentitycontactId)(implicit c: Connection): Option[BusinessentitycontactRow] = {
    SQL"""select businessentityid, personid, contacttypeid, rowguid, modifieddate
          from person.businessentitycontact
          where businessentityid = ${compositeId.businessentityid} AND personid = ${compositeId.personid} AND contacttypeid = ${compositeId.contacttypeid}
       """.as(BusinessentitycontactRow.rowParser(1).singleOpt)
  }
  override def update(row: BusinessentitycontactRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update person.businessentitycontact
          set rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND personid = ${compositeId.personid} AND contacttypeid = ${compositeId.contacttypeid}
       """.executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: BusinessentitycontactId, fieldValues: List[BusinessentitycontactFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case BusinessentitycontactFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case BusinessentitycontactFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update person.businessentitycontact
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where businessentityid = {businessentityid} AND personid = {personid} AND contacttypeid = {contacttypeid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("businessentityid", ParameterValue.from(compositeId.businessentityid)), NamedParameter("personid", ParameterValue.from(compositeId.personid)), NamedParameter("contacttypeid", ParameterValue.from(compositeId.contacttypeid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: BusinessentitycontactRow)(implicit c: Connection): BusinessentitycontactRow = {
    SQL"""insert into person.businessentitycontact(businessentityid, personid, contacttypeid, rowguid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.personid}::int4,
            ${unsaved.contacttypeid}::int4,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, personid, contacttypeid)
          do update set
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, personid, contacttypeid, rowguid, modifieddate
       """
      .executeInsert(BusinessentitycontactRow.rowParser(1).single)
  
  }
}
