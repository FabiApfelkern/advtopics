package advtopics.trendcloud.service

import com.google.inject.Guice 
import com.google.inject.Injector 

/**
 * This Model factory returns specific objects to
 * read from defined web services. The actual logic
 * for retrieving the data from the web service API is
 * injected with Guice. This factory injects the actual 
 * retrieving objects. Hence you should use it just
 * in production mode. For testing purposes it is advisable
 * to inject a mocked service class. 
 */
object ModelFactory {

  def getTwitterModel(): TwitterModel = {
    val injector = Guice.createInjector(new ServiceBinder)
    val twitter = injector.getInstance(classOf[TwitterModel])
    twitter
  }
  
}