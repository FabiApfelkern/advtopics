package advtopics.trendcloud.models

import org.codehaus.jackson.annotate.JsonIgnoreProperties

/**
 * Model class which represents  a user of soundcloud.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
case class SoundcloudUser(val id: Integer,
  val kind: String,
  val permalink: String,
  val username: String,
  val uri: String,
  val permalink_url: String,
  val avatar_url: String) 