package advtopics.trendcloud.requesthandler

import advtopics.trendcloud.controller.Handler
import advtopics.trendcloud.controller.SimpleResponse
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.service.ModelFactory
import advtopics.trendcloud.service.TwitterModel
import advtopics.trendcloud.Loggable

@Handler(url="")
class IndexHandler extends RequestHandler with Loggable{

  def process(request: Request): Response = {
    logger.info("Index Handler")
    val response = new SimpleResponse("index.vm")
    
    val woeidOfBerlin:Integer = 638242
    val twitterModel:TwitterModel = ModelFactory.getTwitterModel()
    var output:Array[String] = twitterModel.readLatest(woeidOfBerlin)
    response.setParameter("array", output)
    response
  }
  


}