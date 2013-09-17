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
    val response = new SimpleResponse("soundcloud.vm")
	logger.info("TAG: " +request.getParameter("tag"));
    // Get a Soundcloud object to read from soundcloud
    val soundcloud = ModelFactory.getSoundcloudModel()
    val sounds = soundcloud.readSounds(request.getParameter("tag"))
    logger.info("readed sounds");
    if(sounds != null)
    {
    	logger.info("read sounds size: " +sounds.size)
    	logger.info("first sound id: " +sounds(0).id)
    }
    response.setParameter("array", sounds.toArray)
    response
  }

}