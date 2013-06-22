package advtopics.trendcloud.controller

import advtopics.trendcloud.controller.interfaces.Request
import javax.servlet.http.HttpServletRequest

class SimpleRequest(Name: String, req: HttpServletRequest) extends Request {
  def getReq: HttpServletRequest = req
  def getName: String = Name
}