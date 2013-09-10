package advtopics.trendcloud.service

trait TwitterReaderInterface {

  def fetch(woeid:Integer): Array[String]{}
}