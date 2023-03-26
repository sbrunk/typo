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
import java.time.ZonedDateTime
import org.postgresql.util.PGInterval
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatReplicationRow(
  pid: Option[Int],
  usesysid: Option[/* oid */ Long],
  usename: Option[String],
  applicationName: Option[String],
  clientAddr: Option[/* inet */ PGobject],
  clientHostname: Option[String],
  clientPort: Option[Int],
  backendStart: Option[ZonedDateTime],
  backendXmin: Option[/* xid */ PGobject],
  state: Option[String],
  sentLsn: Option[String],
  writeLsn: Option[String],
  flushLsn: Option[String],
  replayLsn: Option[String],
  writeLag: Option[PGInterval],
  flushLag: Option[PGInterval],
  replayLag: Option[PGInterval],
  syncPriority: Option[Int],
  syncState: Option[String],
  replyTime: Option[ZonedDateTime]
)

object PgStatReplicationRow {
  def rowParser(prefix: String): RowParser[PgStatReplicationRow] = { row =>
    Success(
      PgStatReplicationRow(
        pid = row[Option[Int]](prefix + "pid"),
        usesysid = row[Option[/* oid */ Long]](prefix + "usesysid"),
        usename = row[Option[String]](prefix + "usename"),
        applicationName = row[Option[String]](prefix + "application_name"),
        clientAddr = row[Option[/* inet */ PGobject]](prefix + "client_addr"),
        clientHostname = row[Option[String]](prefix + "client_hostname"),
        clientPort = row[Option[Int]](prefix + "client_port"),
        backendStart = row[Option[ZonedDateTime]](prefix + "backend_start"),
        backendXmin = row[Option[/* xid */ PGobject]](prefix + "backend_xmin"),
        state = row[Option[String]](prefix + "state"),
        sentLsn = row[Option[String]](prefix + "sent_lsn"),
        writeLsn = row[Option[String]](prefix + "write_lsn"),
        flushLsn = row[Option[String]](prefix + "flush_lsn"),
        replayLsn = row[Option[String]](prefix + "replay_lsn"),
        writeLag = row[Option[PGInterval]](prefix + "write_lag"),
        flushLag = row[Option[PGInterval]](prefix + "flush_lag"),
        replayLag = row[Option[PGInterval]](prefix + "replay_lag"),
        syncPriority = row[Option[Int]](prefix + "sync_priority"),
        syncState = row[Option[String]](prefix + "sync_state"),
        replyTime = row[Option[ZonedDateTime]](prefix + "reply_time")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatReplicationRow] = new OFormat[PgStatReplicationRow]{
    override def writes(o: PgStatReplicationRow): JsObject =
      Json.obj(
        "pid" -> o.pid,
      "usesysid" -> o.usesysid,
      "usename" -> o.usename,
      "application_name" -> o.applicationName,
      "client_addr" -> o.clientAddr,
      "client_hostname" -> o.clientHostname,
      "client_port" -> o.clientPort,
      "backend_start" -> o.backendStart,
      "backend_xmin" -> o.backendXmin,
      "state" -> o.state,
      "sent_lsn" -> o.sentLsn,
      "write_lsn" -> o.writeLsn,
      "flush_lsn" -> o.flushLsn,
      "replay_lsn" -> o.replayLsn,
      "write_lag" -> o.writeLag,
      "flush_lag" -> o.flushLag,
      "replay_lag" -> o.replayLag,
      "sync_priority" -> o.syncPriority,
      "sync_state" -> o.syncState,
      "reply_time" -> o.replyTime
      )

    override def reads(json: JsValue): JsResult[PgStatReplicationRow] = {
      JsResult.fromTry(
        Try(
          PgStatReplicationRow(
            pid = json.\("pid").toOption.map(_.as[Int]),
            usesysid = json.\("usesysid").toOption.map(_.as[/* oid */ Long]),
            usename = json.\("usename").toOption.map(_.as[String]),
            applicationName = json.\("application_name").toOption.map(_.as[String]),
            clientAddr = json.\("client_addr").toOption.map(_.as[/* inet */ PGobject]),
            clientHostname = json.\("client_hostname").toOption.map(_.as[String]),
            clientPort = json.\("client_port").toOption.map(_.as[Int]),
            backendStart = json.\("backend_start").toOption.map(_.as[ZonedDateTime]),
            backendXmin = json.\("backend_xmin").toOption.map(_.as[/* xid */ PGobject]),
            state = json.\("state").toOption.map(_.as[String]),
            sentLsn = json.\("sent_lsn").toOption.map(_.as[String]),
            writeLsn = json.\("write_lsn").toOption.map(_.as[String]),
            flushLsn = json.\("flush_lsn").toOption.map(_.as[String]),
            replayLsn = json.\("replay_lsn").toOption.map(_.as[String]),
            writeLag = json.\("write_lag").toOption.map(_.as[PGInterval]),
            flushLag = json.\("flush_lag").toOption.map(_.as[PGInterval]),
            replayLag = json.\("replay_lag").toOption.map(_.as[PGInterval]),
            syncPriority = json.\("sync_priority").toOption.map(_.as[Int]),
            syncState = json.\("sync_state").toOption.map(_.as[String]),
            replyTime = json.\("reply_time").toOption.map(_.as[ZonedDateTime])
          )
        )
      )
    }
  }
}
