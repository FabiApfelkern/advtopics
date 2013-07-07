package advtopics.trendcloud.models

import org.codehaus.jackson.annotate.JsonIgnoreProperties

/**
 * Model class which represents a track Object of soundcloud.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
case class SoundcloudTrack ( val id:Integer,// val kind:String,
 // val created_at:String,
  val user_id:Integer,
  val duration:Integer,
  val commentable:Boolean,
  val state:String,
  val original_content_size:Integer,
 /* val sharing:String,
  val tag_list:String,
  val permalink:String,*/
  /*val streamable:Boolean,
  val embeddable_by:String,
  val downloadable:Boolean,
  val purchase_url:String,*/
  //val label_id:Integer,
  val purchase_title:String,
  val genre:String,
  val title:String,
  val description:String,
  //val label_name:String,
  //val release:String,
  //val track_type:String,
  //val key_signature:String,
  //val isrc:String,
  //val video_url:String,
  //val bpm:Integer,
  /*val release_year:Integer,
  val release_month:Integer,
  val release_day:Integer,
  val original_format:String,
  val license:String,*/
  val uri:String,
  val user:SoundcloudUser,
  val permalink_url:String,
  val artwork_url:String,
  val waveform_url:String,
  val stream_url:String,
  val playback_count:Integer,
  val download_count:Integer,
  val favoritings_count:Integer,
  val comment_count:Integer,
  val attachments_uri:String) {
  
  /*var id:Integer
  var created_at:String
  var user_id:Integer
  var duration:Integer
  var commentable:Boolean
  var state:String
  var original_content_size:Integer
  var sharing:String
  var tag_list:String
  var permalink:String
  var streamable:Boolean
  var embeddable_by:String
  var downloadable:Boolean
  var purchase_url:String
  var label_id:Integer
  var purchase_title:String
  var genre:String
  var title:String
  var description:String
  var label_name:String
  var release:String
  var track_type:String
  var key_signature:String
  var isrc:String
  var video_url:String
  var bpm:String
  var release_year:Integer
  var release_month:Integer
  var release_day:Integer
  var original_format:String
  var license:String
  var uri:String
  var user:SoundcloudUser
  var permalink_url:String
  var artwork_url:String
  var waveform_url:String
  var stream_url:String
  var playback_count:Integer
  var download_count:Integer
  var favoritings_count:Integer
  var comment_count:Integer
  var attachments_uri:String */
}