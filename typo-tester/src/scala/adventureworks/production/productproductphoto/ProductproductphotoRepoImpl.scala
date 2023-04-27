/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productproductphoto

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.public.Flag
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object ProductproductphotoRepoImpl extends ProductproductphotoRepo {
  override def delete(compositeId: ProductproductphotoId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productproductphoto where productid = ${compositeId.productid} AND productphotoid = ${compositeId.productphotoid}".executeUpdate() > 0
  }
  override def insert(unsaved: ProductproductphotoRowUnsaved)(implicit c: Connection): ProductproductphotoRow = {
    val namedParameters = List(
      Some((NamedParameter("productid", ParameterValue.from(unsaved.productid)), "::int4")),
      Some((NamedParameter("productphotoid", ParameterValue.from(unsaved.productphotoid)), "::int4")),
      unsaved.primary match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("primary", ParameterValue.from[Flag](value)), """::"public"."Flag""""))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productproductphoto default values
            returning productid, productphotoid, "primary", modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into production.productproductphoto(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productid, productphotoid, "primary", modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[ProductproductphotoRow] = {
    SQL"""select productid, productphotoid, "primary", modifieddate
          from production.productproductphoto
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ProductproductphotoFieldOrIdValue[_]])(implicit c: Connection): List[ProductproductphotoRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductproductphotoFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case ProductproductphotoFieldValue.productphotoid(value) => NamedParameter("productphotoid", ParameterValue.from(value))
          case ProductproductphotoFieldValue.primary(value) => NamedParameter("primary", ParameterValue.from(value))
          case ProductproductphotoFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select productid, productphotoid, "primary", modifieddate
                    from production.productproductphoto
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(compositeId: ProductproductphotoId)(implicit c: Connection): Option[ProductproductphotoRow] = {
    SQL"""select productid, productphotoid, "primary", modifieddate
          from production.productproductphoto
          where productid = ${compositeId.productid} AND productphotoid = ${compositeId.productphotoid}
       """.as(rowParser.singleOpt)
  }
  override def update(row: ProductproductphotoRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productproductphoto
          set "primary" = ${row.primary}::"public"."Flag",
              modifieddate = ${row.modifieddate}::timestamp
          where productid = ${compositeId.productid} AND productphotoid = ${compositeId.productphotoid}
       """.executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: ProductproductphotoId, fieldValues: List[ProductproductphotoFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductproductphotoFieldValue.primary(value) => NamedParameter("primary", ParameterValue.from(value))
          case ProductproductphotoFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update production.productproductphoto
                    set ${namedParams.map(x => s"${quote}${x.name}${quote} = {${x.name}}").mkString(", ")}
                    where productid = {productid} AND productphotoid = {productphotoid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("productid", ParameterValue.from(compositeId.productid)), NamedParameter("productphotoid", ParameterValue.from(compositeId.productphotoid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ProductproductphotoRow] =
    RowParser[ProductproductphotoRow] { row =>
      Success(
        ProductproductphotoRow(
          productid = row[ProductId]("productid"),
          productphotoid = row[ProductphotoId]("productphotoid"),
          primary = row[Flag]("primary"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
