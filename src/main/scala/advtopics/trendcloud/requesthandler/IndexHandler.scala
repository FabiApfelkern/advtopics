package advtopics.trendcloud.requesthandler

import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.SimpleResponse
import advtopics.trendcloud.controller.Handler
import advtopics.trendcloud.models.Twitter
import advtopics.trendcloud.models.Twitter

@Handler(url="")
class IndexHandler extends RequestHandler {

  def process(request: Request): Response = {
    val response = new SimpleResponse("index.html")
    
    //var output:Array[String] = Array("Eins", "Zwei", "Drei", "Vier")
    val woeidOfBerlin:Integer = 638242
    val twitter = new Twitter
    var output = twitter.getPlaceTrendsByWOEID(woeidOfBerlin)
    response.setParameter("array", output)

    response
  }
  


}