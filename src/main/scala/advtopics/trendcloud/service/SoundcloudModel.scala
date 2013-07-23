package advtopics.trendcloud.service

import com.google.inject.Inject
import com.google.inject.name.Named

class SoundcloudModel @Inject() (@Named("soundcloudReader") reader:ServiceReader){

  def readSounds(): String = {
    reader.fetch("test")
  }
}