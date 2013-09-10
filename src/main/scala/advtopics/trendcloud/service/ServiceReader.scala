package advtopics.trendcloud.service

/**
 * Interface for a Web Service reader
 */
trait ServiceReader[T, R] {
	def fetch(anyType:T): R
}