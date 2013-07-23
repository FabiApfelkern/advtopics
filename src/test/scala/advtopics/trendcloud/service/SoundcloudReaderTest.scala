package advtopics.trendcloud.service

import org.junit.Before
import org.junit.Test

class SoundcloudReaderTest {

  private var scReader:FakeTwitterReader = null
  
  @Before
  def instantiate: Unit = {
	scReader = new FakeTwitterReader
  }

  @Test
  def fetchTest: Unit = {
	scReader.fetch.equals("Hallo Fake Twitter")
  }
  
}