package advtopics.trendcloud.models
import com.google.inject.AbstractModule
import advtopics.trendcloud.Loggable
import advtopics.trendcloud.service.SoundcloudReader
import advtopics.trendcloud.service.SoundcloudReaderInterface
import advtopics.trendcloud.service.TwitterReader
import advtopics.trendcloud.service.TwitterReaderInterface

/**
 * This is the Guice configuration for 
 * production mode. It configures which 
 * actual class should be binded to 
 * which property marked as injected.
 * 
 */
class ServiceBinder extends AbstractModule with Loggable{

  override protected def configure() = {
    logger.info("Bind service readers")
    // Bind the real TwitterReader
    bind(classOf[TwitterReaderInterface]).to(classOf[TwitterReader])
    // Bind the real SoundcloudReader
    bind(classOf[SoundcloudReaderInterface]).to(classOf[SoundcloudReader])
    logger.info("binding finished")
  }
  
} 