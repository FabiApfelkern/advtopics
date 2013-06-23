package advtopics.trendcloud.requesthandler

import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.SimpleResponse
import advtopics.trendcloud.controller.Handler

@Handler(url="iven")
class ApplicationHandler extends RequestHandler {

  def process(request: Request): Response = {
    val response = new SimpleResponse("output.html")
    response.setParameter("content", "Hallo Welt")

    response
  }
  


}