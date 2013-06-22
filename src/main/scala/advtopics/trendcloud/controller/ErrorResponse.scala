package advtopics.trendcloud.controller

import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.controller.interfaces.Request

class ErrorResponse (originalRequest:Request, originalException:Exception) extends Response{ 
   
  def getOriginalRequest:Request= originalRequest 
  def getOriginalException:Exception= originalException 
   
} 