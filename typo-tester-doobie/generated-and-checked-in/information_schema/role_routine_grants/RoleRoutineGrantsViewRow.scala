/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package role_routine_grants

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class RoleRoutineGrantsViewRow(
  /** Points to [[routine_privileges.RoutinePrivilegesViewRow.grantor]] */
  grantor: Option[SqlIdentifier],
  /** Points to [[routine_privileges.RoutinePrivilegesViewRow.grantee]] */
  grantee: Option[SqlIdentifier],
  /** Points to [[routine_privileges.RoutinePrivilegesViewRow.specificCatalog]] */
  specificCatalog: Option[SqlIdentifier],
  /** Points to [[routine_privileges.RoutinePrivilegesViewRow.specificSchema]] */
  specificSchema: Option[SqlIdentifier],
  /** Points to [[routine_privileges.RoutinePrivilegesViewRow.specificName]] */
  specificName: Option[SqlIdentifier],
  /** Points to [[routine_privileges.RoutinePrivilegesViewRow.routineCatalog]] */
  routineCatalog: Option[SqlIdentifier],
  /** Points to [[routine_privileges.RoutinePrivilegesViewRow.routineSchema]] */
  routineSchema: Option[SqlIdentifier],
  /** Points to [[routine_privileges.RoutinePrivilegesViewRow.routineName]] */
  routineName: Option[SqlIdentifier],
  /** Points to [[routine_privileges.RoutinePrivilegesViewRow.privilegeType]] */
  privilegeType: Option[CharacterData],
  /** Points to [[routine_privileges.RoutinePrivilegesViewRow.isGrantable]] */
  isGrantable: Option[YesOrNo]
)

object RoleRoutineGrantsViewRow {
  implicit lazy val decoder: Decoder[RoleRoutineGrantsViewRow] = Decoder.forProduct10[RoleRoutineGrantsViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[YesOrNo]]("grantor", "grantee", "specific_catalog", "specific_schema", "specific_name", "routine_catalog", "routine_schema", "routine_name", "privilege_type", "is_grantable")(RoleRoutineGrantsViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(CharacterData.decoder), Decoder.decodeOption(YesOrNo.decoder))
  implicit lazy val encoder: Encoder[RoleRoutineGrantsViewRow] = Encoder.forProduct10[RoleRoutineGrantsViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData], Option[YesOrNo]]("grantor", "grantee", "specific_catalog", "specific_schema", "specific_name", "routine_catalog", "routine_schema", "routine_name", "privilege_type", "is_grantable")(x => (x.grantor, x.grantee, x.specificCatalog, x.specificSchema, x.specificName, x.routineCatalog, x.routineSchema, x.routineName, x.privilegeType, x.isGrantable))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(CharacterData.encoder), Encoder.encodeOption(YesOrNo.encoder))
  implicit lazy val read: Read[RoleRoutineGrantsViewRow] = new Read[RoleRoutineGrantsViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable),
      (YesOrNo.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => RoleRoutineGrantsViewRow(
      grantor = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      grantee = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      specificCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      specificSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 3),
      specificName = SqlIdentifier.get.unsafeGetNullable(rs, i + 4),
      routineCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 5),
      routineSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 6),
      routineName = SqlIdentifier.get.unsafeGetNullable(rs, i + 7),
      privilegeType = CharacterData.get.unsafeGetNullable(rs, i + 8),
      isGrantable = YesOrNo.get.unsafeGetNullable(rs, i + 9)
    )
  )
}
