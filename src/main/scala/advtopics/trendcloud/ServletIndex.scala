package advtopics.trendcloud

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.PrintWriter
import java.io.InputStream
import advtopics.trendcloud.controller.DefaultController
import advtopics.trendcloud.requesthandler.ApplicationHandler
import advtopics.trendcloud.controller.SimpleRequest
import advtopics.trendcloud.controller.SimpleResponse
import org.apache.velocity.app.Velocity
import java.io.InputStreamReader
import org.apache.velocity.VelocityContext
import java.io.StringWriter
import org.reflections._
import org.reflections.util.ConfigurationBuilder
import java.util.Set
import advtopics.trendcloud.controller.HandlerLoader
import scala.collection.immutable.HashMap
import collection.JavaConversions._
import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.RequestHandler

class ServletIndex extends HttpServlet with Loggable{ 
   
  override def doGet(req: HttpServletRequest, res: HttpServletResponse) = { 
    handleRequest(req,res) 
  } 
 
  override def doPost(req: HttpServletRequest, res: HttpServletResponse) = { 
	  handleRequest(req,res) 
  }  
  
  def handleRequest(req: HttpServletRequest, res: HttpServletResponse)=  
  {
      val reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("output.vm"))
      val context = new VelocityContext
      val out:PrintWriter  = res.getWriter(); 
      
	  logger.info(req.getServletPath());
	  val controller =  new DefaultController
	  val request = new SimpleRequest(req.getServletPath(), req)

	  val map:java.util.Map[String, Object] = new HandlerLoader().find()
	  map.foreach{f => 
	       var request2 = new SimpleRequest(f._1, req)
	       controller.addHandler(request2, f._2.asInstanceOf[RequestHandler])
	  }
	  
	  val response = controller.processRequest(request).asInstanceOf[SimpleResponse]
	  logger.info(response.content)
	  
	  context.put("content", response.content)
      val writer = new StringWriter
      Velocity.evaluate(context, writer, "", reader)
       
      out.println(writer.toString) 
      out.close 
      
	  //req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").include(req, res) 
  } 
  
} 