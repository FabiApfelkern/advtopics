package advtopics.trendcloud.service

/**
 * Just a dummy to test Guice
 */
class FakeTwitterReader extends ServiceReader {
	def fetch(): String = {
	  "Hallo Fake Twitter"
	}
}