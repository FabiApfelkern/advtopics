package advtopics.trendcloud.service
import com.google.inject.AbstractModule
import com.google.inject.name.Names
import advtopics.trendcloud.models.SoundcloudTrack

/**
 * This is the Guice configuration for 
 * production mode. It configures which 
 * actual class should be binded to 
 * which property marked as injected.
 * 
 */
class ServiceBinderTest extends AbstractModule {

  override protected def configure() = {
     bind(classOf[TwitterReaderInterface]).to(classOf[FakeTwitterReader])
     bind(classOf[SoundcloudReaderInterface]).to(classOf[FakeSoundcloudReader])
  }
  
} 