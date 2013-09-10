package advtopics.trendcloud.service

import com.google.inject.Guice

object ModelFactoryTest {

	def getTwitterModelTest():TwitterModel = {
	   val injector = Guice.createInjector(new ServiceBinderTest)
	   val twitter = injector.getInstance(classOf[TwitterModel])
	   twitter
	}
	
	def getSoundcloudModelTest(): SoundcloudModel = {
	   val injector = Guice.createInjector(new ServiceBinderTest)
	   val soundcloud = injector.getInstance(classOf[SoundcloudModel])
	   soundcloud
	}
}