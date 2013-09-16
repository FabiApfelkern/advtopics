package advtopics.trendcloud.service

import org.apache.http.HttpStatus
import com.codahale.jerkson.Json._
import com.soundcloud.api.ApiWrapper
import com.soundcloud.api.Endpoints
import com.soundcloud.api.Http
import com.soundcloud.api.Request
import advtopics.trendcloud.Loggable
import advtopics.trendcloud.models.SoundcloudTrack
import com.codahale.jerkson.ParsingException
import org.codehaus.jackson.map.ObjectMapper
import advtopics.trendcloud.models.SoundcloudTrack

class SoundcloudReader extends SoundcloudReaderInterface with Loggable {

  /**
   * clientId for our app
   */
  val clientId: String = "bcf29defbcb57dff0d6f907f288f0790"
  /**
   * client secret for our app
   */
  val clientSec: String = "c2c5351bafa0ad7cfd3f0a77eadcbf00"

  /**
   * Fetches the music from soundcloud by a given keyword.
   * @param keyword
   * @return A list of SoundCloudTrack models. Can be empty!
   */
  def fetch(keyword: String): List[SoundcloudTrack] = {
    val wrapper = new ApiWrapper("bcf29defbcb57dff0d6f907f288f0790", "c2c5351bafa0ad7cfd3f0a77eadcbf00", null, null)
    logger.info("Search for sounds on SoundCloud with keyword: ")
    val resource = Request.to(Endpoints.TRACKS + ".json?q=" + keyword)
    val resp = wrapper.get(resource)
    logger.info("URI: " + wrapper.getURI(resource, true, false).toString())
    if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
      logger.info("SoundcloudReader - Statuscode: " + resp.getStatusLine().getStatusCode())

      val jsonInput = Http.formatJSON(Http.getString(resp))
      try {
        val sounds: List[SoundcloudTrack] = parse[List[SoundcloudTrack]](jsonInput.mkString)
      }
      catch {
        case ex: ParsingException => println(ex.getMessage())
      }
      //logger.info(sounds)
      //return sounds
      return List()
    } else {
      logger.error("Something went wrong: " + resp.getStatusLine().getStatusCode())
      return List()
    }

  }
}