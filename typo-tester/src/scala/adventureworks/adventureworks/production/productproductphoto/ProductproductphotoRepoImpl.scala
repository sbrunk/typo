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
    SQL"""delete from production.productproductphoto where productid = ${compositeId.productid}, productphotoid = ${compositeId.productphotoid}""".executeUpdate() > 0
  }
  override def insert(compositeId: ProductproductphotoId, unsaved: ProductproductphotoRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      unsaved.primary match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("primary", ParameterValue.from[Flag](value)))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into production.productproductphoto(productid, productphotoid, ${namedParameters.map(_.name).mkString(", ")})
          values (${compositeId.productid}, ${compositeId.productphotoid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
    """
      .on(namedParameters :_*)
      .execute()
  
  }
  override def selectAll(implicit c: Connection): List[ProductproductphotoRow] = {
    SQL"""select productid, productphotoid, primary, modifieddate from production.productproductphoto""".as(rowParser.*)
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
        val q = s"""select * from production.productproductphoto where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(compositeId: ProductproductphotoId)(implicit c: Connection): Option[ProductproductphotoRow] = {
    SQL"""select productid, productphotoid, primary, modifieddate from production.productproductphoto where productid = ${compositeId.productid}, productphotoid = ${compositeId.productphotoid}""".as(rowParser.singleOpt)
  }
  override def update(compositeId: ProductproductphotoId, row: ProductproductphotoRow)(implicit c: Connection): Boolean = {
    SQL"""update production.productproductphoto
          set primary = ${row.primary},
              modifieddate = ${row.modifieddate}
          where productid = ${compositeId.productid}, productphotoid = ${compositeId.productphotoid}""".executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: ProductproductphotoId, fieldValues: List[ProductproductphotoFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductproductphotoFieldValue.primary(value) => NamedParameter("primary", ParameterValue.from(value))
          case ProductproductphotoFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.productproductphoto
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where productid = ${compositeId.productid}, productphotoid = ${compositeId.productphotoid}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
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
  val idRowParser: RowParser[ProductproductphotoId] =
    RowParser[ProductproductphotoId] { row =>
      Success(
        ProductproductphotoId(
          productid = row[ProductId]("productid"),
          productphotoid = row[ProductphotoId]("productphotoid")
        )
      )
    }
}
