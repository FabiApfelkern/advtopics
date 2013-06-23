package advtopics.trendcloud.controller

import java.util.HashMap

import advtopics.trendcloud.controller.interfaces.Controller
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response

class DefaultController extends Controller {
  val requestHandlers = new HashMap[String, RequestHandler]()

  /**
   * Get a RequestHandler for a specific request. The URL form the
   * request is uses to identify the right Handler.
   */
  def getHandler(request: Request): RequestHandler = {

    if (!this.requestHandlers.containsKey(request.getUrl(0))) {

      val msg = "Cannot find handler for [" + request.getUrl(0) + "]"
      throw new RuntimeException(msg)
    }
    requestHandlers.get(request.getUrl(0))
  }

  /**
   * Add a new handler to the controller. It is identified by
   * a string.
   */
  def addHandler(url: String, requestHandler: RequestHandler): Unit = {

    if (this.requestHandlers.containsKey(url)) {
      val msg = "A request handler with name [" +
        url + "] has already been registered"
      throw new RuntimeException(msg)
    } else
      this.requestHandlers.put(url, requestHandler)
    return
  }

  /**
   * Delegate a request to the responsible RequestHandler
   */
  def processRequest(request: Request): Response = {

    var response: Response = {
      try {
        (getHandler(request).asInstanceOf[RequestHandler]).process(request)
      } catch {
        case ex: Exception => new ErrorResponse(request, ex)
      }
    }
    response
  }
}