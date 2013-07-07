package advtopics.trendcloud.service


import com.soundcloud.api.ApiWrapper
import com.soundcloud.api.Request
import com.soundcloud.api.Endpoints
import org.apache.http.HttpStatus
import com.soundcloud.api.Http

import com.codahale.jerkson.Json._

import advtopics.trendcloud.models.SoundcloudTrack

class SoundcloudReader extends ServiceReader {

  /**
   * clientId for our app
   */
  val clientId: String = "bacfabc4b3549c008c52ec19dd8576d3"
  /**
   * client secret for our app
   */
  val clientSec: String = "2ef79427f8124d7d15348b4406899642"
  /**
   *   API wrapper
   */  
  val wrapper = new ApiWrapper(clientId, clientSec, null, null)

  /**
   * Fetches the music from soundcloud by a given keyword.
   * @param keyword
   * @return A list auf SoundCloudTrack models. Can be empty!
   */
  def fetch(keyword:String): List[SoundcloudTrack] ={ 
     //logger.info("Search for sounds on SoundCloud with keyword: " +keyword)
    val resource = Request.to(Endpoints.TRACKS + ".json?q=" + keyword)
    val resp = wrapper.get(resource)
    //logger.info("Statuscode: "+resp.getStatusLine().getStatusCode())
    if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
      val jsonInput = Http.formatJSON(Http.getString(resp))
      val sounds:List[SoundcloudTrack] = parse[List[SoundcloudTrack]](jsonInput)
      //logger.info(sounds)
      return sounds
    } else {
      //logger.error("Something went wrong!")
      return List()
    }

  }
  
  def fetch(): String = {
    "Test Twitter!"
  }
  
}