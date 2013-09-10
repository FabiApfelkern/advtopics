package advtopics.trendcloud.service


import com.soundcloud.api.ApiWrapper
import com.soundcloud.api.Request
import com.soundcloud.api.Endpoints
import org.apache.http.HttpStatus
import com.soundcloud.api.Http
import com.codahale.jerkson.Json._
import advtopics.trendcloud.models.SoundcloudTrack
import advtopics.trendcloud.Loggable
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
   *   API wrapper
   */  
  val wrapper = new ApiWrapper(clientId, clientSec, null, null)

  /**
   * Fetches the music from soundcloud by a given keyword.
   * @param keyword
   * @return A list of SoundCloudTrack models. Can be empty!
   */
  def fetch(keyword:String): List[SoundcloudTrack] ={ 
    logger.info("Search for sounds on SoundCloud with keyword: " +keyword)
    val resource = Request.to(Endpoints.TRACKS + ".json?q=" + keyword)
    val resp = wrapper.get(resource)
    var sounds:List[SoundcloudTrack] = null
    if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
      logger.info("Statuscode: "+resp.getStatusLine().getStatusCode())
      val jsonInput = Http.getJSON(resp)
      logger.info(Http.getJSON(resp))
     // sounds = parse[List[SoundcloudTrack]](jsonInput)
      sounds
    } else {
      logger.error("Something went wrong!")
      List()
    }
    

  }
}