package advtopics.trendcloud.controller

import advtopics.trendcloud.controller.interfaces.Response
import scala.collection.mutable.HashMap

/**
 * This Response should be returned by a RequestHandler
 * and can be processed by the ResponseRenderer
 */
class SimpleResponse(template:String) extends Response{
  private val parameters = new HashMap[String, Any]()
  
  def setParameter(name:String,parameter:Any) = {
    this.parameters.put(name, parameter)
  }
  def getTemplate:String = template
  def getParameters:HashMap[String, Any] = this.parameters
 
}