package advtopics.trendcloud

import org.apache.logging.log4j.{LogManager,Logger} 
 
trait Loggable { 
	lazy val logger:Logger = LogManager.getLogger(getClass()); 
}