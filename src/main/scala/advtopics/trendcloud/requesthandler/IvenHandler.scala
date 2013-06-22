package advtopics.trendcloud.requesthandler

import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.SimpleResponse
import advtopics.trendcloud.controller.Handler

@Handler(url="/bjoern")
class IvenHandler extends RequestHandler {
  
  def process(request: Request): Response = {
    var response = new SimpleResponse
    
    response.content = "Bjoern ist geil!"
    
    
   response 
  }

}