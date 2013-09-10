package advtopics.trendcloud.service

/**
 * Fake twitter reader for testing the model.
 */
class FakeTwitterReader extends TwitterReaderInterface {
  /**
   * Fetch the trends of twitter by a given where on earth id (woeid) and returns them
   * as a array of strings.
   * @param An where on earth id
   * @return An array of string with the trends. Can be empty!
   */
  def fetch(woeid: Integer): Array[String] = {
    Array("ram", "sam", "kam")
  }
}