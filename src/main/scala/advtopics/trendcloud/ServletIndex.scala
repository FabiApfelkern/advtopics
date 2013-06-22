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
	  val request = new SimpleRequest("iven")
	  controller.addHandler(request, new ApplicationHandler)
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