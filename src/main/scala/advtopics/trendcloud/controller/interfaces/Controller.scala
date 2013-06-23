package advtopics.trendcloud.controller.interfaces

trait Controller {
  def processRequest(request: Request): Response
  def addHandler(url: String, requestHandler: RequestHandler): Unit
}