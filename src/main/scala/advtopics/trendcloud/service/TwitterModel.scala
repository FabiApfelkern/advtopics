package advtopics.trendcloud.service

import com.google.inject.Inject
import com.google.inject.name.Named

/**
 * This is model for encapsulating all data
 * retrieved from the Twitter API.
 * The actual reader is injected with Guice.
 */
class TwitterModel @Inject() (@Named("twitterReader") reader:ServiceReader){

  def readLatest(): String = {
    reader.fetch("test")
  }

}