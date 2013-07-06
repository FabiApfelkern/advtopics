package advtopics.trendcloud.service

import com.google.inject.Inject

/**
 * This is model for encapsulating all data
 * retrieved from the Twitter API.
 * The actual reader is injected with Guice.
 */
class TwitterModel {

  @Inject
  var reader: ServiceReader = null

  def readLatest(): String = {
    reader.fetch()
  }

}