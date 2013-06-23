package advtopics.trendcloud.controller

import advtopics.trendcloud.controller.interfaces.Response
import advtopics.trendcloud.controller.interfaces.Request
import scala.collection.mutable.HashMap

/**
 * This is the standard ErrorResponsem which renders the Error template
 */
class ErrorResponse(originalRequest:Request, originalException:Exception) extends Response{ 
  def getTemplate: String = "error.html"
  def getParameters: HashMap[String, Any] = new HashMap
  def getOriginalRequest:Request= originalRequest 
  def getOriginalException:Exception= originalException 
   
} 