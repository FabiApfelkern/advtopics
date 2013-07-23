package advtopics.trendcloud.service
import com.google.inject.AbstractModule
import com.google.inject.name.Names

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
    bind(classOf[ServiceReader]).annotatedWith(Names.named("twitterReader")).to(classOf[TwitterReader])
    bind(classOf[ServiceReader]).annotatedWith(Names.named("soundcloudReader")).to(classOf[SoundcloudReader])
  }
  
} 