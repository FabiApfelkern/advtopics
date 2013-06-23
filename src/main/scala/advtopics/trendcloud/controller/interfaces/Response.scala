package advtopics.trendcloud.controller.interfaces

import scala.collection.mutable.HashMap

trait Response {
  def getTemplate: String
  def getParameters: HashMap[String, Any]
}