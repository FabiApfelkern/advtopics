package advtopics.trendcloud.requesthandler

import advtopics.trendcloud.controller.Handler
import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.controller.SimpleResponse
import advtopics.trendcloud.service.ModelFactory
import advtopics.trendcloud.Loggable
import org.apache.logging.log4j.Logger


@Handler(url="soundcloud")
class SoundcloudHandler extends RequestHandler with Loggable {
  
  
  def process(request: Request): Response = {
    val response = new SimpleResponse("output.html")

    // Get a Soundcloud object to read from soundcloud
    val soundcloud = ModelFactory.getSoundcloudModel()
    response.setParameter("url", request.getParameter("tag"));
    logger.info(request.getReq.getParameter("tag"));
    response.setParameter("content", "test");
    //response.setParameter("content", soundcloud.searchForSoundsByKeyword("#Berlin"));

    response
  }

}