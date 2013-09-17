package advtopics.trendcloud.models

import org.codehaus.jackson.annotate.JsonIgnoreProperties

/**
 * Model class which represents a track Object of soundcloud.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
case class SoundcloudTrack(
  val id: Integer, // val kind:String,
  val user_id: Integer,
 //val duration: Integer,
  //val commentable: Boolean,
  //val state: String,
  //val original_content_size: Integer,
  //val purchase_title: String,
  //val genre: String,
  val title: String,
  //val description: String,
  val uri: String,
  //val user: SoundcloudUser,*/
  //val permalink: String,
  //val artwork_url: String,
  //val waveform_url: String,*/
  //val stream_url: String,
  //val playback_count: Integer,
  //val download_count: Integer,
  //val favoritings_count: Integer,
  //val comment_count: Integer,
  val attachments_uri: String
  ) {

  def getTitle() : String = {
    title
  }
  
  def getUri(): String = {
    uri
  }
  
  def getId(): Integer ={
    id
  }
  
  def getUserId(): Integer = {
    user_id
  }
  
  def getAttachmentsUri: String = {
    attachments_uri
  }
}