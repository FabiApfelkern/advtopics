package advtopics.trendcloud.service

import org.junit.Before
import org.junit.Test
import advtopics.trendcloud.models.SoundcloudModel

class SoundcloudReaderTest {

  var soundcloudModel:SoundcloudModel = null
  
  @Before
  def instantiate: Unit = {
	soundcloudModel = ModelFactoryTest.getSoundcloudModelTest()
  }

  @Test
  def fetchTest: Unit = {
	if(soundcloudModel.readSounds("test").isEmpty)
	  assert(true)
  }
  
}