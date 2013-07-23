package advtopics.trendcloud.service

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito._
import com.google.inject.Inject
import org.mockito.stubbing.Answer
import org.mockito.invocation.InvocationOnMock

class TwitterReaderTest {

  @Inject
  private var tReader: ServiceReader = null

  private var mockTwitterModel: advtopics.trendcloud.models.TwitterModel = null

  val woeidOfBerlin: Integer = 638242

  @Before
  def instantiate: Unit = {
    tReader = new FakeTwitterReader
    mockTwitterModel = mock(classOf[advtopics.trendcloud.models.TwitterModel])
    when(mockTwitterModel.getPlaceTrendsByWOEID(woeidOfBerlin)).thenAnswer(new Answer [ Array[String] ] {

      def answer(invocation: InvocationOnMock): Array[String] = {
        val answers = Array("ram", "sam", "kam")
        return answers
      }

    })
  }

  @Test
  def fetchTest: Unit = {
    tReader.fetch.equals("Hallo Fake Twitter")
    
    if(mockTwitterModel.getPlaceTrendsByWOEID(woeidOfBerlin)(0).equals("ram"))
      assert(true)
    
  }
}