package advtopics.trendcloud.controller

import org.junit.Assert._
import org.junit.Before
import org.junit.Test
import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response
import javax.servlet.http.HttpServletRequest
import scala.collection.mutable.HashMap
import advtopics.trendcloud.requesthandler.IndexHandler
import org.mockito.Mockito._
import com.google.inject.Inject
import org.mockito.stubbing.Answer
import org.mockito.invocation.InvocationOnMock
import advtopics.trendcloud.service.TwitterModel
import advtopics.trendcloud.service.ModelFactory
import org.scalatest.FunSuite


class RequestHandlerTest  {

  private class SampleRequest extends Request {
    def getReq: HttpServletRequest = null
    def getUrl: List[String] = List("test")
    def getParameter(name: String): String = "hallo"
  }
  
  private var handler: IndexHandler = null
  private var request: Request = null
  val woeidOfBerlin: Integer = 638242
  
  @Before
  def instantiate: Unit = {
    handler = new IndexHandler
    request = new SampleRequest
    
    val mockTwitterModel = mock(classOf[TwitterModel])
    when(mockTwitterModel.readLatest(woeidOfBerlin)).thenAnswer(new Answer [Array[String]] {

      def answer(invocation: InvocationOnMock): Array[String] = {
        Array("ram", "sam", "kam")
      }
    })

        
  }
  
  @Test
  def handlerTest: Unit = {
	  val response = handler.process(request)
	  assertEquals("1", "1")
	  
  }
  

}