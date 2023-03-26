/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTypeRow(
  oid: PgTypeId,
  typname: String,
  typnamespace: /* oid */ Long,
  typowner: /* oid */ Long,
  typlen: Int,
  typbyval: Boolean,
  typtype: String,
  typcategory: String,
  typispreferred: Boolean,
  typisdefined: Boolean,
  typdelim: String,
  typrelid: /* oid */ Long,
  typsubscript: /* regproc */ PGobject,
  typelem: /* oid */ Long,
  typarray: /* oid */ Long,
  typinput: /* regproc */ PGobject,
  typoutput: /* regproc */ PGobject,
  typreceive: /* regproc */ PGobject,
  typsend: /* regproc */ PGobject,
  typmodin: /* regproc */ PGobject,
  typmodout: /* regproc */ PGobject,
  typanalyze: /* regproc */ PGobject,
  typalign: String,
  typstorage: String,
  typnotnull: Boolean,
  typbasetype: /* oid */ Long,
  typtypmod: Int,
  typndims: Int,
  typcollation: /* oid */ Long,
  typdefaultbin: Option[/* pg_node_tree */ PGobject],
  typdefault: Option[String],
  typacl: Option[Array[/* aclitem */ PGobject]]
)

object PgTypeRow {
  def rowParser(prefix: String): RowParser[PgTypeRow] = { row =>
    Success(
      PgTypeRow(
        oid = row[PgTypeId](prefix + "oid"),
        typname = row[String](prefix + "typname"),
        typnamespace = row[/* oid */ Long](prefix + "typnamespace"),
        typowner = row[/* oid */ Long](prefix + "typowner"),
        typlen = row[Int](prefix + "typlen"),
        typbyval = row[Boolean](prefix + "typbyval"),
        typtype = row[String](prefix + "typtype"),
        typcategory = row[String](prefix + "typcategory"),
        typispreferred = row[Boolean](prefix + "typispreferred"),
        typisdefined = row[Boolean](prefix + "typisdefined"),
        typdelim = row[String](prefix + "typdelim"),
        typrelid = row[/* oid */ Long](prefix + "typrelid"),
        typsubscript = row[/* regproc */ PGobject](prefix + "typsubscript"),
        typelem = row[/* oid */ Long](prefix + "typelem"),
        typarray = row[/* oid */ Long](prefix + "typarray"),
        typinput = row[/* regproc */ PGobject](prefix + "typinput"),
        typoutput = row[/* regproc */ PGobject](prefix + "typoutput"),
        typreceive = row[/* regproc */ PGobject](prefix + "typreceive"),
        typsend = row[/* regproc */ PGobject](prefix + "typsend"),
        typmodin = row[/* regproc */ PGobject](prefix + "typmodin"),
        typmodout = row[/* regproc */ PGobject](prefix + "typmodout"),
        typanalyze = row[/* regproc */ PGobject](prefix + "typanalyze"),
        typalign = row[String](prefix + "typalign"),
        typstorage = row[String](prefix + "typstorage"),
        typnotnull = row[Boolean](prefix + "typnotnull"),
        typbasetype = row[/* oid */ Long](prefix + "typbasetype"),
        typtypmod = row[Int](prefix + "typtypmod"),
        typndims = row[Int](prefix + "typndims"),
        typcollation = row[/* oid */ Long](prefix + "typcollation"),
        typdefaultbin = row[Option[/* pg_node_tree */ PGobject]](prefix + "typdefaultbin"),
        typdefault = row[Option[String]](prefix + "typdefault"),
        typacl = row[Option[Array[/* aclitem */ PGobject]]](prefix + "typacl")
      )
    )
  }

  implicit val oFormat: OFormat[PgTypeRow] = new OFormat[PgTypeRow]{
    override def writes(o: PgTypeRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "typname" -> o.typname,
      "typnamespace" -> o.typnamespace,
      "typowner" -> o.typowner,
      "typlen" -> o.typlen,
      "typbyval" -> o.typbyval,
      "typtype" -> o.typtype,
      "typcategory" -> o.typcategory,
      "typispreferred" -> o.typispreferred,
      "typisdefined" -> o.typisdefined,
      "typdelim" -> o.typdelim,
      "typrelid" -> o.typrelid,
      "typsubscript" -> o.typsubscript,
      "typelem" -> o.typelem,
      "typarray" -> o.typarray,
      "typinput" -> o.typinput,
      "typoutput" -> o.typoutput,
      "typreceive" -> o.typreceive,
      "typsend" -> o.typsend,
      "typmodin" -> o.typmodin,
      "typmodout" -> o.typmodout,
      "typanalyze" -> o.typanalyze,
      "typalign" -> o.typalign,
      "typstorage" -> o.typstorage,
      "typnotnull" -> o.typnotnull,
      "typbasetype" -> o.typbasetype,
      "typtypmod" -> o.typtypmod,
      "typndims" -> o.typndims,
      "typcollation" -> o.typcollation,
      "typdefaultbin" -> o.typdefaultbin,
      "typdefault" -> o.typdefault,
      "typacl" -> o.typacl
      )

    override def reads(json: JsValue): JsResult[PgTypeRow] = {
      JsResult.fromTry(
        Try(
          PgTypeRow(
            oid = json.\("oid").as[PgTypeId],
            typname = json.\("typname").as[String],
            typnamespace = json.\("typnamespace").as[/* oid */ Long],
            typowner = json.\("typowner").as[/* oid */ Long],
            typlen = json.\("typlen").as[Int],
            typbyval = json.\("typbyval").as[Boolean],
            typtype = json.\("typtype").as[String],
            typcategory = json.\("typcategory").as[String],
            typispreferred = json.\("typispreferred").as[Boolean],
            typisdefined = json.\("typisdefined").as[Boolean],
            typdelim = json.\("typdelim").as[String],
            typrelid = json.\("typrelid").as[/* oid */ Long],
            typsubscript = json.\("typsubscript").as[/* regproc */ PGobject],
            typelem = json.\("typelem").as[/* oid */ Long],
            typarray = json.\("typarray").as[/* oid */ Long],
            typinput = json.\("typinput").as[/* regproc */ PGobject],
            typoutput = json.\("typoutput").as[/* regproc */ PGobject],
            typreceive = json.\("typreceive").as[/* regproc */ PGobject],
            typsend = json.\("typsend").as[/* regproc */ PGobject],
            typmodin = json.\("typmodin").as[/* regproc */ PGobject],
            typmodout = json.\("typmodout").as[/* regproc */ PGobject],
            typanalyze = json.\("typanalyze").as[/* regproc */ PGobject],
            typalign = json.\("typalign").as[String],
            typstorage = json.\("typstorage").as[String],
            typnotnull = json.\("typnotnull").as[Boolean],
            typbasetype = json.\("typbasetype").as[/* oid */ Long],
            typtypmod = json.\("typtypmod").as[Int],
            typndims = json.\("typndims").as[Int],
            typcollation = json.\("typcollation").as[/* oid */ Long],
            typdefaultbin = json.\("typdefaultbin").toOption.map(_.as[/* pg_node_tree */ PGobject]),
            typdefault = json.\("typdefault").toOption.map(_.as[String]),
            typacl = json.\("typacl").toOption.map(_.as[Array[/* aclitem */ PGobject]])
          )
        )
      )
    }
  }
}
