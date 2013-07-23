package advtopics.trendcloud.models


import twitter4j.Trends
import advtopics.trendcloud.Loggable
import twitter4j.Twitter

class TwitterModel(twitter:twitter4j.Twitter) extends Loggable {

  
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