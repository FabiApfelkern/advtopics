package advtopics.trendcloud.models

import twitter4j.TwitterFactory
import twitter4j.Trends
import advtopics.trendcloud.Loggable

class Twitter extends Loggable {

  val twitter = TwitterFactory.getSingleton()
 
  //println(placeTrends.toString())
  
  
  def getPlaceTrendsByWOID(woid : Integer): Trends = {
	  logger.info("Search for trends with woid: " +woid)
	  twitter.getPlaceTrends(woid)
  }
}