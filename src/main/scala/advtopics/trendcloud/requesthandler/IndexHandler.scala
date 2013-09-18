package advtopics.trendcloud.requesthandler

import advtopics.trendcloud.controller.Handler
import advtopics.trendcloud.controller.SimpleResponse
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.models.ModelFactory
import advtopics.trendcloud.models.TwitterModel
import advtopics.trendcloud.Loggable
import advtopics.trendcloud.models.ModelFactory

@Handler(url="")
class IndexHandler extends RequestHandler with Loggable{
  
  def process(request: Request): Response = {
    logger.info("Index Handler")
    val response = new SimpleResponse("index.vm")

    var customWoeid = 638242
    logger.info("Parameter for WOEID: " + request.getParameter("woeid"));
    
    if (request.getParameter("woeid") != null) {
      customWoeid = Integer.parseInt(request.getParameter("woeid"))
    }


    val twitterModel: TwitterModel = ModelFactory.getTwitterModel()
    var output: Array[String] = twitterModel.readLatest(customWoeid)
    response.setParameter("array", output)
    response
  }
  


}