package advtopics.trendcloud.service

import advtopics.trendcloud.models.SoundcloudTrack

trait SoundcloudReaderInterface {

  def fetch(keyword:String): List[SoundcloudTrack]
}