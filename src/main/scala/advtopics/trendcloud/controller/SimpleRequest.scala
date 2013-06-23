package advtopics.trendcloud.controller

import advtopics.trendcloud.controller.interfaces.Request
import javax.servlet.http.HttpServletRequest

/**
 * This is a basic request, which can be handled by a RequestHandler
 */
class SimpleRequest(url: List[String], req: HttpServletRequest) extends Request {
  def getReq: HttpServletRequest = req
  def getUrl: List[String] = url
}