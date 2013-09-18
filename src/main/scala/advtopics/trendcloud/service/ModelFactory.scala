package advtopics.trendcloud.service

import com.google.inject.Guice
import com.google.inject.Injector
import advtopics.trendcloud.Loggable

/**
 * This Model factory returns specific objects to
 * read from defined web services. The actual logic
 * for retrieving the data from the web service API is
 * injected with Guice. This factory injects the actual 
 * retrieving objects. Hence you should use it just
 * in production mode. For testing purposes it is advisable
 * to inject a mocked service class. 
 */
object ModelFactory extends Loggable{

  def getTwitterModel(): TwitterModel = {
    val injector = Guice.createInjector(new ServiceBinder)
    val twitter = injector.getInstance(classOf[TwitterModel])
    logger.info("return twitter model")
    twitter
  }
  
  def getSoundcloudModel(): SoundcloudModel = {
    logger.info("return soundcloud model")
    val injector = Guice.createInjector(new ServiceBinder)
    val soundcloud = injector.getInstance(classOf[SoundcloudModel])
    soundcloud
  } 
}