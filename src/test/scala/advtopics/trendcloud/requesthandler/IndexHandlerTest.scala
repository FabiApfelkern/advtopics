package advtopics.trendcloud.requesthandler

import org.junit.Assert._
import org.junit.Before
import org.junit.Test
import advtopics.trendcloud.controller.interfaces.Request
import javax.servlet.http.HttpServletRequest
import org.mockito.Mockito._
import org.mockito.stubbing.Answer
import org.mockito.invocation.InvocationOnMock
import advtopics.trendcloud.models.TwitterModel
import advtopics.trendcloud.controller.Handler
import advtopics.trendcloud.models.TwitterModel
import org.junit.Before
import org.junit.Test


class IndexHandlerTest  {

  private class SampleRequest extends Request {
    def getReq: HttpServletRequest = null
    def getUrl: List[String] = List("test")
    def getParameter(name: String): String = "638242"
  }
  
  private var handler: IndexHandler = null
  private var request: Request = null
  val woeidOfBerlin: Integer = 638242
  
  @Before
  def instantiate: Unit = {
    handler = new IndexHandler
    request = new SampleRequest
    
    // Just an idea, is not included in the Test
    val mockTwitterModel = mock(classOf[TwitterModel])
    when(mockTwitterModel.readLatest(woeidOfBerlin)).thenAnswer(new Answer [Array[String]] {

      def answer(invocation: InvocationOnMock): Array[String] = {
        Array("ram", "sam", "kam")
      }
    })
  
  }
  
  @Test
  def processTest: Unit = {
	  val response = handler.process(request)
	  val para = response.getParameters
	  assertTrue(para.contains("array"));
  }
  

}