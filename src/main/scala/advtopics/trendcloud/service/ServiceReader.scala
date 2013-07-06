package advtopics.trendcloud.service

/**
 * Interface for a Web Service reader
 */
trait ServiceReader {
	def fetch(): String
}