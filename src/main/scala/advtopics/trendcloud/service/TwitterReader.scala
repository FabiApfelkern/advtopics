package advtopics.trendcloud.service

import advtopics.trendcloud.Loggable
import twitter4j.TwitterFactory

/**
 * Class which handels the fetching of twitter trends.
 */
class TwitterReader extends TwitterReaderInterface with Loggable{

  val twitter = TwitterFactory.getSingleton()

  /**
   * Fetch the trends of twitter by a given where on earth id (woeid) and returns them
   * as a array of strings.
   * @param An where on earth id
   * @return An array of string with the trends. Can be empty!
   */
  def fetch(woeid:Integer): Array[String] = {
    logger.info("Search for trends with woeid: " +woeid)
    val trends = twitter.getPlaceTrends(woeid)
    var trendsAsString: Array[String] = new Array[String](trends.getTrends().length)
    for (x <- trends.getTrends()) {
      //logger.info("Trend: " + x.getName())
      trendsAsString.+(x.getName())
    }
    trendsAsString
  }
  
}