package advtopics.trendcloud.requesthandler

import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.SimpleResponse
import advtopics.trendcloud.controller.Handler

@Handler(url="")
class IndexHandler extends RequestHandler {

  def process(request: Request): Response = {
    val response = new SimpleResponse("index.html")
    
    var output:Array[String] = Array("Eins", "Zwei", "Drei", "Vier")
    response.setParameter("array", output)

    response
  }
  


}