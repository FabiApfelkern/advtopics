package advtopics.trendcloud.service

import advtopics.trendcloud.models.SoundcloudTrack
import com.soundcloud.api.Http
import com.soundcloud.api.Request
import com.soundcloud.api.Endpoints
import advtopics.trendcloud.models.SoundcloudTrack

/**
 * Fake soundcloud reader for testing the soundcloud model.
 */
class FakeSoundcloudReader extends SoundcloudReaderInterface{

  
  /**
   * Fetches the music from soundcloud by a given keyword.
   * @param keyword
   * @return A list of SoundCloudTrack models. Can be empty!
   */
  def fetch(keyword:String): List[SoundcloudTrack] ={ 
		 List()
  }
}