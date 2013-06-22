package advtopics.trendcloud.controller.interfaces

trait Controller {
  def processRequest(request: Request): Response
  def addHandler(request: Request, requestHandler: RequestHandler): Unit
}