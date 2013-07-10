package advtopics.trendcloud.requesthandler

import advtopics.trendcloud.controller.Handler
import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.controller.SimpleResponse
import advtopics.trendcloud.service.ModelFactory


@Handler(url="soundcloud")
class SoundcloudHandler extends RequestHandler {
  
  
  def process(request: Request): Response = {
    val response = new SimpleResponse("output.html")
    // Get a Soundcloud object to read from soundcloud
    val soundcloud = ModelFactory.getSoundcloudModel()
    response.setParameter("content", soundcloud.searchForSoundsByKeyword("#Berlin"));

    response
  }

}