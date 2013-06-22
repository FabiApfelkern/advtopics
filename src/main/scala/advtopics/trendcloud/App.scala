package advtopics.trendcloud

import twitter4j.TwitterFactory
import twitter4j.GeoLocation


object App extends Application {
  
  val twitter = TwitterFactory.getSingleton()
  val timeline = twitter.getPlaceTrends(638242);
  println(timeline.toString())

}
