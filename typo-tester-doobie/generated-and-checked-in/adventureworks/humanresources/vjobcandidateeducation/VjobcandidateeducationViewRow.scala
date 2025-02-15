/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateeducation

import adventureworks.customtypes.TypoLocalDate
import adventureworks.humanresources.jobcandidate.JobcandidateId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class VjobcandidateeducationViewRow(
  /** Points to [[jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: JobcandidateId,
  `Edu.Level`: /* nullability unknown */ Option[/* max 50 chars */ String],
  `Edu.StartDate`: /* nullability unknown */ Option[TypoLocalDate],
  `Edu.EndDate`: /* nullability unknown */ Option[TypoLocalDate],
  `Edu.Degree`: /* nullability unknown */ Option[/* max 50 chars */ String],
  `Edu.Major`: /* nullability unknown */ Option[/* max 50 chars */ String],
  `Edu.Minor`: /* nullability unknown */ Option[/* max 50 chars */ String],
  `Edu.GPA`: /* nullability unknown */ Option[/* max 5 chars */ String],
  `Edu.GPAScale`: /* nullability unknown */ Option[/* max 5 chars */ String],
  `Edu.School`: /* nullability unknown */ Option[/* max 100 chars */ String],
  `Edu.Loc.CountryRegion`: /* nullability unknown */ Option[/* max 100 chars */ String],
  `Edu.Loc.State`: /* nullability unknown */ Option[/* max 100 chars */ String],
  `Edu.Loc.City`: /* nullability unknown */ Option[/* max 100 chars */ String]
)

object VjobcandidateeducationViewRow {
  implicit lazy val decoder: Decoder[VjobcandidateeducationViewRow] = Decoder.forProduct13[VjobcandidateeducationViewRow, JobcandidateId, /* nullability unknown */ Option[/* max 50 chars */ String], /* nullability unknown */ Option[TypoLocalDate], /* nullability unknown */ Option[TypoLocalDate], /* nullability unknown */ Option[/* max 50 chars */ String], /* nullability unknown */ Option[/* max 50 chars */ String], /* nullability unknown */ Option[/* max 50 chars */ String], /* nullability unknown */ Option[/* max 5 chars */ String], /* nullability unknown */ Option[/* max 5 chars */ String], /* nullability unknown */ Option[/* max 100 chars */ String], /* nullability unknown */ Option[/* max 100 chars */ String], /* nullability unknown */ Option[/* max 100 chars */ String], /* nullability unknown */ Option[/* max 100 chars */ String]]("jobcandidateid", "Edu.Level", "Edu.StartDate", "Edu.EndDate", "Edu.Degree", "Edu.Major", "Edu.Minor", "Edu.GPA", "Edu.GPAScale", "Edu.School", "Edu.Loc.CountryRegion", "Edu.Loc.State", "Edu.Loc.City")(VjobcandidateeducationViewRow.apply)(JobcandidateId.decoder, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoLocalDate.decoder), Decoder.decodeOption(TypoLocalDate.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[VjobcandidateeducationViewRow] = Encoder.forProduct13[VjobcandidateeducationViewRow, JobcandidateId, /* nullability unknown */ Option[/* max 50 chars */ String], /* nullability unknown */ Option[TypoLocalDate], /* nullability unknown */ Option[TypoLocalDate], /* nullability unknown */ Option[/* max 50 chars */ String], /* nullability unknown */ Option[/* max 50 chars */ String], /* nullability unknown */ Option[/* max 50 chars */ String], /* nullability unknown */ Option[/* max 5 chars */ String], /* nullability unknown */ Option[/* max 5 chars */ String], /* nullability unknown */ Option[/* max 100 chars */ String], /* nullability unknown */ Option[/* max 100 chars */ String], /* nullability unknown */ Option[/* max 100 chars */ String], /* nullability unknown */ Option[/* max 100 chars */ String]]("jobcandidateid", "Edu.Level", "Edu.StartDate", "Edu.EndDate", "Edu.Degree", "Edu.Major", "Edu.Minor", "Edu.GPA", "Edu.GPAScale", "Edu.School", "Edu.Loc.CountryRegion", "Edu.Loc.State", "Edu.Loc.City")(x => (x.jobcandidateid, x.`Edu.Level`, x.`Edu.StartDate`, x.`Edu.EndDate`, x.`Edu.Degree`, x.`Edu.Major`, x.`Edu.Minor`, x.`Edu.GPA`, x.`Edu.GPAScale`, x.`Edu.School`, x.`Edu.Loc.CountryRegion`, x.`Edu.Loc.State`, x.`Edu.Loc.City`))(JobcandidateId.encoder, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoLocalDate.encoder), Encoder.encodeOption(TypoLocalDate.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[VjobcandidateeducationViewRow] = new Read[VjobcandidateeducationViewRow](
    gets = List(
      (JobcandidateId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoLocalDate.get, Nullability.Nullable),
      (TypoLocalDate.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VjobcandidateeducationViewRow(
      jobcandidateid = JobcandidateId.get.unsafeGetNonNullable(rs, i + 0),
      `Edu.Level` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      `Edu.StartDate` = TypoLocalDate.get.unsafeGetNullable(rs, i + 2),
      `Edu.EndDate` = TypoLocalDate.get.unsafeGetNullable(rs, i + 3),
      `Edu.Degree` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      `Edu.Major` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      `Edu.Minor` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      `Edu.GPA` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 7),
      `Edu.GPAScale` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 8),
      `Edu.School` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 9),
      `Edu.Loc.CountryRegion` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 10),
      `Edu.Loc.State` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 11),
      `Edu.Loc.City` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 12)
    )
  )
}
