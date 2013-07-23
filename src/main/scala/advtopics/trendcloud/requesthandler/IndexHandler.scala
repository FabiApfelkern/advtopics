package advtopics.trendcloud.requesthandler

import advtopics.trendcloud.controller.Handler
import advtopics.trendcloud.controller.SimpleResponse
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.models.TwitterModel
import twitter4j.TwitterFactory

@Handler(url="")
class IndexHandler extends RequestHandler {

  def process(request: Request): Response = {
    val response = new SimpleResponse("index.html")
    
    val woeidOfBerlin:Integer = 638242
    val twitterModel = new TwitterModel(TwitterFactory.getSingleton())
    var output:Array[String] = twitterModel.getPlaceTrendsByWOEID(woeidOfBerlin)
    response.setParameter("array", output)

    response
  }
  


}