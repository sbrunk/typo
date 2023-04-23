/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import adventureworks.Defaulted
import adventureworks.production.productcategory.ProductcategoryId
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
import java.util.UUID

object ProductsubcategoryRepoImpl extends ProductsubcategoryRepo {
  override def delete(productsubcategoryid: ProductsubcategoryId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productsubcategory where productsubcategoryid = $productsubcategoryid".executeUpdate() > 0
  }
  override def insert(unsaved: ProductsubcategoryRowUnsaved)(implicit c: Connection): ProductsubcategoryRow = {
    val namedParameters = List(
      Some((NamedParameter("productcategoryid", ParameterValue.from(unsaved.productcategoryid)), "::int4")),
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
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
      SQL"""insert into production.productsubcategory default values
            returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into production.productsubcategory(${namedParameters.map{case (x, _) => "\"" + x.name + "\""}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[ProductsubcategoryRow] = {
    SQL"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate
          from production.productsubcategory
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ProductsubcategoryFieldOrIdValue[_]])(implicit c: Connection): List[ProductsubcategoryRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductsubcategoryFieldValue.productsubcategoryid(value) => NamedParameter("productsubcategoryid", ParameterValue.from(value))
          case ProductsubcategoryFieldValue.productcategoryid(value) => NamedParameter("productcategoryid", ParameterValue.from(value))
          case ProductsubcategoryFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ProductsubcategoryFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ProductsubcategoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate
                    from production.productsubcategory
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(productsubcategoryid: ProductsubcategoryId)(implicit c: Connection): Option[ProductsubcategoryRow] = {
    SQL"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate
          from production.productsubcategory
          where productsubcategoryid = $productsubcategoryid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(productsubcategoryids: Array[ProductsubcategoryId])(implicit c: Connection): List[ProductsubcategoryRow] = {
    implicit val toStatement: ToStatement[Array[ProductsubcategoryId]] =
      (s: PreparedStatement, index: Int, v: Array[ProductsubcategoryId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate
          from production.productsubcategory
          where productsubcategoryid = ANY($productsubcategoryids)
       """.as(rowParser.*)
  
  }
  override def update(row: ProductsubcategoryRow)(implicit c: Connection): Boolean = {
    val productsubcategoryid = row.productsubcategoryid
    SQL"""update production.productsubcategory
          set productcategoryid = ${row.productcategoryid},
              "name" = ${row.name},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where productsubcategoryid = $productsubcategoryid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(productsubcategoryid: ProductsubcategoryId, fieldValues: List[ProductsubcategoryFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductsubcategoryFieldValue.productcategoryid(value) => NamedParameter("productcategoryid", ParameterValue.from(value))
          case ProductsubcategoryFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ProductsubcategoryFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ProductsubcategoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.productsubcategory
                    set ${namedParams.map(x => s"\"${x.name}\" = {${x.name}}").mkString(", ")}
                    where productsubcategoryid = {productsubcategoryid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("productsubcategoryid", ParameterValue.from(productsubcategoryid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ProductsubcategoryRow] =
    RowParser[ProductsubcategoryRow] { row =>
      Success(
        ProductsubcategoryRow(
          productsubcategoryid = row[ProductsubcategoryId]("productsubcategoryid"),
          productcategoryid = row[ProductcategoryId]("productcategoryid"),
          name = row[Name]("name"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
