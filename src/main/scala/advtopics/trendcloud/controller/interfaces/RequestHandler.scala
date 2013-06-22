package advtopics.trendcloud.controller.interfaces

trait RequestHandler {
  def process(request: Request): Response
}