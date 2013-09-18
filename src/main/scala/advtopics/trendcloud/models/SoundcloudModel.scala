package advtopics.trendcloud.models

import com.google.inject.Inject
import advtopics.trendcloud.service.SoundcloudReaderInterface
import com.google.inject.Inject
import org.codehaus.jackson.annotate.JsonIgnoreProperties

/**
 * This is model for encapsulating all data
 * retrieved from the Soundcloud API.
 * The actual reader is injected with Guice.
 */
class SoundcloudModel{

  @Inject
  var reader: SoundcloudReaderInterface = null
  
  /**
   * Fetch sounds on soundcloud.com by a given keyword.
   * @param keyword to search on soundcloud
   * @return a list of SoundcloudTracks can be empty
   */
  def readSounds(keyword:String): List[SoundcloudTrack] = {
    reader.fetch(keyword)
  }
}