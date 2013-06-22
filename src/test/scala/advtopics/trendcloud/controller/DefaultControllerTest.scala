package advtopics.trendcloud.controller

import org.junit.Assert._
import org.junit.Before
import org.junit.Test

import advtopics.trendcloud.controller.interfaces.Request
import advtopics.trendcloud.controller.interfaces.RequestHandler
import advtopics.trendcloud.controller.interfaces.Response

class DefaultControllerTest {

  private class SampleRequest(Name: String) extends Request {
    def getName: String = Name
    def this() = this("TestRequest")
  }
  private class SampleHandler extends RequestHandler {
    def process(request: Request): Response = new SampleResponse
  }

  private class SampleResponse extends Response {}

  private var controller: DefaultController = null
  private var request: Request = null
  private var handler: RequestHandler = null

  @Before
  def instantiate: Unit = {
    controller = new DefaultController
    request = new SampleRequest
    handler = new SampleHandler
    controller.addHandler(request, handler)
  }

  @Test
  def getHandlerTest: Unit = {

    val handler2 = controller.getHandler(request)
    assertSame("Handler we get should be the same we set", handler, handler2)
  }
  @Test
  def ProcessRequestTest = {

    val response = controller.processRequest(request)
    assertNotNull("Must not return a null response", response)
    assertEquals("Response should be of type SampleResponse",
      classOf[SampleResponse], response.getClass)
  }

}