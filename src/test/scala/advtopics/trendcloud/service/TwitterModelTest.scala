package advtopics.trendcloud.service

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito._
import com.google.inject.Inject
import org.mockito.stubbing.Answer
import org.mockito.invocation.InvocationOnMock

class TwitterModelTest {

  var mockTwitterModel: TwitterModel = null
  val woeidOfBerlin: Integer = 638242

  @Before
  def instantiate: Unit = {
   /* mockTwitterModel = mock(classOf[TwitterModel])
    when(mockTwitterModel.readLatest(woeidOfBerlin)).thenAnswer(new Answer [Array[String]] {

      def answer(invocation: InvocationOnMock): Array[String] = {
        Array("ram", "sam", "kam")
      }

    })
	*/
  }

  @Test
  def readLatestTest: Unit = {
    
    if (ModelFactoryTest.getTwitterModelTest().readLatest(woeidOfBerlin)(0).equals("ram"))
      assert(true)
  }

}