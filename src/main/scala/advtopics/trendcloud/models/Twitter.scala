package advtopics.trendcloud.models

import twitter4j.TwitterFactory
import twitter4j.Trends
import advtopics.trendcloud.Loggable

/**
 * Loads tweets from twitter.com
 */
class Twitter extends Loggable {

  /**
   * Wrapper for twitter api
   */
  val twitter = TwitterFactory.getSingleton()
 
  //println(placeTrends.toString())
  
  /**
   * Returns a list of strings of twitter trends by a given woeid
   * @param woeid Where on earth id. Is needed to fetch trends to a special location
   * @return a list of strings with the twitter trends.
   */
  def getPlaceTrendsByWOEID(woeid : Integer): Array[String] = {
	  logger.info("Search for trends with woid: " +woeid)
	  val trends = twitter.getPlaceTrends(woeid)

	  var trendsAsString:Array[String] = new Array[String](trends.getTrends().length)
	  var i:Integer = 0;
	  for(x <- trends.getTrends() ){
	    logger.info("Trend: "+x.getName())
	    trendsAsString(i) = x.getName()
	    i += 1
	  }
	  trendsAsString
  }
}