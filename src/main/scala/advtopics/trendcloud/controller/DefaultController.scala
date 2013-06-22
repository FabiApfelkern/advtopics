package advtopics.trendcloud.controller

import java.util.HashMap

import advtopics.trendcloud.controller.interfaces.Controller
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response

class DefaultController extends Controller 
{ 
  private val requestHandlers= new HashMap[String,RequestHandler]() 
   
  def getHandler(request:Request): RequestHandler={ 
	  
    if (!this.requestHandlers.containsKey(request.getName)){ 
     
        val msg= "Cannot find handler for ["+request.getName+"]" 
      throw new RuntimeException(msg) 
    } 
    requestHandlers.get(request.getName) 
  } 
  
  def addHandler(request:Request, requestHandler:RequestHandler):Unit={ 
 
    if (this.requestHandlers.containsKey(request.getName)){ 
      val msg= "A request handler with name ["+ 
        request.getName+"] has already been registered" 
      throw new RuntimeException(msg) 
    } 
    else  
      this.requestHandlers.put(request.getName, requestHandler) 
    return 
  }

  def processRequest(request: Request): Response = {

    var response: Response = {
      try {
        (getHandler(request).asInstanceOf[RequestHandler]).
          process(request)
      } catch {
        case ex: Exception => new ErrorResponse(request, ex)
      }
    }
    response
  } 
}