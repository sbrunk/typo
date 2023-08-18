/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_privileges

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ColumnPrivilegesViewRow(
  grantor: Option[SqlIdentifier],
  grantee: Option[SqlIdentifier],
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier],
  privilegeType: Option[CharacterData],
  isGrantable: Option[YesOrNo]
)

object ColumnPrivilegesViewRow {
  implicit lazy val decoder: Decoder[ColumnPrivilegesViewRow] = Decoder.forProduct8[ColumnPrivilegesViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[YesOrNo]]("grantor", "grantee", "table_catalog", "table_schema", "table_name", "column_name", "privilege_type", "is_grantable")(ColumnPrivilegesViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(CharacterData.decoder), Decoder.decodeOption(YesOrNo.decoder))
  implicit lazy val encoder: Encoder[ColumnPrivilegesViewRow] = Encoder.forProduct8[ColumnPrivilegesViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[YesOrNo]]("grantor", "grantee", "table_catalog", "table_schema", "table_name", "column_name", "privilege_type", "is_grantable")(x => (x.grantor, x.grantee, x.tableCatalog, x.tableSchema, x.tableName, x.columnName, x.privilegeType, x.isGrantable))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(CharacterData.encoder), Encoder.encodeOption(YesOrNo.encoder))
  implicit lazy val read: Read[ColumnPrivilegesViewRow] = new Read[ColumnPrivilegesViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (YesOrNo.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ColumnPrivilegesViewRow(
      grantor = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      grantee = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      tableCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      tableSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 3),
      tableName = SqlIdentifier.get.unsafeGetNullable(rs, i + 4),
      columnName = SqlIdentifier.get.unsafeGetNullable(rs, i + 5),
      privilegeType = CharacterData.get.unsafeGetNullable(rs, i + 6),
      isGrantable = YesOrNo.get.unsafeGetNullable(rs, i + 7)
    )
  )
}
