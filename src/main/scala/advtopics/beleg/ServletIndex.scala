package advtopics.beleg

import javax.servlet.http.HttpServlet 
import javax.servlet.http.HttpServletRequest 
import javax.servlet.http.HttpServletResponse 
import java.io.PrintWriter 
import java.io.InputStream 
 
class ServletIndex extends HttpServlet with Loggable{ 
   
  override def doGet(req: HttpServletRequest, res: HttpServletResponse) = { 
    handleRequest(req,res) 
  } 
 
  override def doPost(req: HttpServletRequest, res: HttpServletResponse) = { 
	  handleRequest(req,res) 
  }  
  
  def handleRequest(req: HttpServletRequest, res: HttpServletResponse)=  
  { 
	  logger.info(req.getServletPath());
	  req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").include(req, res) 
  } 
  
} 