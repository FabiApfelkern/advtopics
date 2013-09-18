package advtopics.trendcloud.models

import com.google.inject.Inject
import advtopics.trendcloud.service.SoundcloudReaderInterface
import com.google.inject.Inject
import org.codehaus.jackson.annotate.JsonIgnoreProperties

class SoundcloudModel{

  @Inject
  var reader: SoundcloudReaderInterface = null
  
  def readSounds(keyword:String): List[SoundcloudTrack] = {
    reader.fetch(keyword)
  }
}