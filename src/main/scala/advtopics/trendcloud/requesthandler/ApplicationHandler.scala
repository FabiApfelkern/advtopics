package advtopics.trendcloud.requesthandler

import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.SimpleResponse

class ApplicationHandler extends RequestHandler {
  
  def process(request: Request): Response = {
    var response = new SimpleResponse
    
    response.content = "Iven ist geil!"
    
    
   response 
  }

}