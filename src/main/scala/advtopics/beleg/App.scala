package advtopics.beleg

import twitter4j.TwitterFactory


object App extends Application {
  
  val twitter = TwitterFactory.getSingleton()
  val timeline = twitter.getHomeTimeline()
  println(timeline.toString())

  
}
