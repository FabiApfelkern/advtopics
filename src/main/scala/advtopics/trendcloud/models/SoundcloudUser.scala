package advtopics.trendcloud.models

import org.codehaus.jackson.annotate.JsonIgnoreProperties

/**
 * Model class which represents  a user of soundcloud.com
 *  @constructor create a new SoundcloudUser with a kind, permalink, username, uri, permalink_url, avatar_url.
  * @param kind the kind of user
  * @param permalink link to the user profile
  * @param username username at soundcloud of the user
  * @param uri to the user
  * @param permalink_url url to the user
  * @param avatar_link link to the avatar
 */
@JsonIgnoreProperties(ignoreUnknown = true)
case class SoundcloudUser(val id: Integer,
  val kind: String,
  val permalink: String,
  val username: String,
  val uri: String,
  val permalink_url: String,
  val avatar_url: String) 