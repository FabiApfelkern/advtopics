package advtopics.trendcloud.requesthandler

import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.SimpleResponse
import advtopics.trendcloud.controller.Handler
import advtopics.trendcloud.service.ModelFactory
import advtopics.trendcloud.Loggable

@Handler(url="twitter")
class ApplicationHandler extends RequestHandler with Loggable {

  def process(request: Request): Response = {
    val response = new SimpleResponse("output.html")
    logger.info("ApplicationHandler")
    // Get a Twitter model to read from Twitter
    val woeidOfBerlin:Integer = 638242
    val twitter = ModelFactory.getTwitterModel()
    response.setParameter("content", twitter.readLatest(woeidOfBerlin));

    response
  }
 
}