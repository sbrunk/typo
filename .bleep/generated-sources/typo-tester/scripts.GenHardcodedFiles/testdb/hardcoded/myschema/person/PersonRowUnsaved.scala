/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try
import testdb.hardcoded.Defaulted
import testdb.hardcoded.myschema.Sector
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.marital_status.MaritalStatusId

/** This class corresponds to a row in table `myschema.person` which has not been persisted yet */
case class PersonRowUnsaved(
  favouriteFootballClubId: FootballClubId,
  name: String,
  nickName: Option[String],
  blogUrl: Option[String],
  email: String,
  phone: String,
  likesPizza: Boolean,
  maritalStatusId: Defaulted[MaritalStatusId],
  workEmail: Option[String],
  sector: Defaulted[Sector]
) {
  def unsafeToRow(id: PersonId): PersonRow =
    PersonRow(
      id = id,
      favouriteFootballClubId = favouriteFootballClubId,
      name = name,
      nickName = nickName,
      blogUrl = blogUrl,
      email = email,
      phone = phone,
      likesPizza = likesPizza,
      maritalStatusId = maritalStatusId match {
                          case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                          case Defaulted.Provided(value) => value
                        },
      workEmail = workEmail,
      sector = sector match {
                 case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                 case Defaulted.Provided(value) => value
               }
    )
}
object PersonRowUnsaved {
  implicit val oFormat: OFormat[PersonRowUnsaved] = new OFormat[PersonRowUnsaved]{
    override def writes(o: PersonRowUnsaved): JsObject =
      Json.obj(
        "favourite_football_club_id" -> o.favouriteFootballClubId,
        "name" -> o.name,
        "nick_name" -> o.nickName,
        "blog_url" -> o.blogUrl,
        "email" -> o.email,
        "phone" -> o.phone,
        "likes_pizza" -> o.likesPizza,
        "marital_status_id" -> o.maritalStatusId,
        "work_email" -> o.workEmail,
        "sector" -> o.sector
      )
  
    override def reads(json: JsValue): JsResult[PersonRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PersonRowUnsaved(
            favouriteFootballClubId = json.\("favourite_football_club_id").as[FootballClubId],
            name = json.\("name").as[String],
            nickName = json.\("nick_name").toOption.map(_.as[String]),
            blogUrl = json.\("blog_url").toOption.map(_.as[String]),
            email = json.\("email").as[String],
            phone = json.\("phone").as[String],
            likesPizza = json.\("likes_pizza").as[Boolean],
            maritalStatusId = json.\("marital_status_id").as[Defaulted[MaritalStatusId]],
            workEmail = json.\("work_email").toOption.map(_.as[String]),
            sector = json.\("sector").as[Defaulted[Sector]]
          )
        )
      )
    }
  }
}
