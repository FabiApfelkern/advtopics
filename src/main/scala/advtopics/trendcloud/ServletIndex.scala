package advtopics.trendcloud

import scala.collection.JavaConversions.mapAsScalaMap

import advtopics.trendcloud.controller.DefaultController
import advtopics.trendcloud.controller.HandlerLoader
import advtopics.trendcloud.controller.SimpleRequest
import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.view.ResponseRenderer
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * This is the main entry point, all HTTP requests are processed here
 * and are delegated to the responsible RequestHandler
 * 
 */
class ServletIndex extends HttpServlet with Loggable {

  val controller = new DefaultController

  // Getting the url mapping and adding it to the controller
  val map: java.util.Map[String, Object] = new HandlerLoader().find()
  map.foreach { f =>
    logger.info("Add RequestHandler for url: " + f._1);
    this.controller.addHandler(f._1, f._2.asInstanceOf[RequestHandler])
  }

  override def doGet(req: HttpServletRequest, res: HttpServletResponse) = {
    handleRequest(req, res)
  }

  override def doPost(req: HttpServletRequest, res: HttpServletResponse) = {
    handleRequest(req, res)
  }

  def handleRequest(req: HttpServletRequest, res: HttpServletResponse) =
    {
      logger.info("Handle request for: " + req.getServletPath());

      // Splitting the url into its parameter
      val url = this.getUrlParameter(req.getServletPath())
      val request = new SimpleRequest(url, req)
      val response = controller.processRequest(request)
      val responseRen = new ResponseRenderer(res)
      responseRen.send(response)

    }

  /**
   * Splits the url string into separated strings
   */
  def getUrlParameter(url: String): List[String] = {
    var list: List[String] = List()
    val array: Array[String] = url.split('/')
    array.foreach { a =>
      if (!a.equals("")) {
        list = list ::: List(a)
      }
    }
    if (list.length == 0) {
      List("")
    } else {
      list
    }

  }
  
} 