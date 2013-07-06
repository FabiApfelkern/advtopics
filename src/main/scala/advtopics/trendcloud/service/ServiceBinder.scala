package advtopics.trendcloud.service
import com.google.inject.AbstractModule

/**
 * This is the Guice configuration for 
 * production mode. It configures which 
 * actual class should be binded to 
 * which property marked as injected.
 * 
 */
class ServiceBinder extends AbstractModule {

  override protected def configure() = {
    // Bind the real TwitterReader
    bind(classOf[ServiceReader]).to(classOf[TwitterReader])
    //bind(classOf[ServiceReader]).to(classOf[FakeTwitterReader])
  }
  
} 