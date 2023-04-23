/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
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

object ShoppingcartitemRepoImpl extends ShoppingcartitemRepo {
  override def delete(shoppingcartitemid: ShoppingcartitemId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.shoppingcartitem where shoppingcartitemid = $shoppingcartitemid".executeUpdate() > 0
  }
  override def insert(unsaved: ShoppingcartitemRowUnsaved)(implicit c: Connection): ShoppingcartitemRow = {
    val namedParameters = List(
      Some((NamedParameter("shoppingcartid", ParameterValue.from(unsaved.shoppingcartid)), "")),
      unsaved.quantity match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("quantity", ParameterValue.from[Int](value)), "::int4"))
      },
      Some((NamedParameter("productid", ParameterValue.from(unsaved.productid)), "::int4")),
      unsaved.datecreated match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("datecreated", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.shoppingcartitem default values
            returning shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into sales.shoppingcartitem(${namedParameters.map{case (x, _) => "\"" + x.name + "\""}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[ShoppingcartitemRow] = {
    SQL"""select shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate
          from sales.shoppingcartitem
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ShoppingcartitemFieldOrIdValue[_]])(implicit c: Connection): List[ShoppingcartitemRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ShoppingcartitemFieldValue.shoppingcartitemid(value) => NamedParameter("shoppingcartitemid", ParameterValue.from(value))
          case ShoppingcartitemFieldValue.shoppingcartid(value) => NamedParameter("shoppingcartid", ParameterValue.from(value))
          case ShoppingcartitemFieldValue.quantity(value) => NamedParameter("quantity", ParameterValue.from(value))
          case ShoppingcartitemFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case ShoppingcartitemFieldValue.datecreated(value) => NamedParameter("datecreated", ParameterValue.from(value))
          case ShoppingcartitemFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate
                    from sales.shoppingcartitem
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(shoppingcartitemid: ShoppingcartitemId)(implicit c: Connection): Option[ShoppingcartitemRow] = {
    SQL"""select shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate
          from sales.shoppingcartitem
          where shoppingcartitemid = $shoppingcartitemid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(shoppingcartitemids: Array[ShoppingcartitemId])(implicit c: Connection): List[ShoppingcartitemRow] = {
    implicit val toStatement: ToStatement[Array[ShoppingcartitemId]] =
      (s: PreparedStatement, index: Int, v: Array[ShoppingcartitemId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate
          from sales.shoppingcartitem
          where shoppingcartitemid = ANY($shoppingcartitemids)
       """.as(rowParser.*)
  
  }
  override def update(row: ShoppingcartitemRow)(implicit c: Connection): Boolean = {
    val shoppingcartitemid = row.shoppingcartitemid
    SQL"""update sales.shoppingcartitem
          set shoppingcartid = ${row.shoppingcartid},
              quantity = ${row.quantity},
              productid = ${row.productid},
              datecreated = ${row.datecreated},
              modifieddate = ${row.modifieddate}
          where shoppingcartitemid = $shoppingcartitemid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(shoppingcartitemid: ShoppingcartitemId, fieldValues: List[ShoppingcartitemFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ShoppingcartitemFieldValue.shoppingcartid(value) => NamedParameter("shoppingcartid", ParameterValue.from(value))
          case ShoppingcartitemFieldValue.quantity(value) => NamedParameter("quantity", ParameterValue.from(value))
          case ShoppingcartitemFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case ShoppingcartitemFieldValue.datecreated(value) => NamedParameter("datecreated", ParameterValue.from(value))
          case ShoppingcartitemFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update sales.shoppingcartitem
                    set ${namedParams.map(x => s"\"${x.name}\" = {${x.name}}").mkString(", ")}
                    where shoppingcartitemid = {shoppingcartitemid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("shoppingcartitemid", ParameterValue.from(shoppingcartitemid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ShoppingcartitemRow] =
    RowParser[ShoppingcartitemRow] { row =>
      Success(
        ShoppingcartitemRow(
          shoppingcartitemid = row[ShoppingcartitemId]("shoppingcartitemid"),
          shoppingcartid = row[String]("shoppingcartid"),
          quantity = row[Int]("quantity"),
          productid = row[ProductId]("productid"),
          datecreated = row[LocalDateTime]("datecreated"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
