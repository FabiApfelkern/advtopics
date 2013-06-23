package advtopics.trendcloud.controller.interfaces

import javax.servlet.http.HttpServletRequest

trait Request {
	def getReq:HttpServletRequest
	def getUrl:List[String]
}