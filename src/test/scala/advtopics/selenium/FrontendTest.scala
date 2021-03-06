package advtopics.selenium

import org.junit._
import org.junit.Assert._
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import junit.framework.Assert
import com.thoughtworks.selenium.Selenium

@Ignore
class FrontendTest {
  
  def url = "http://localhost:8080/beleg/"
  var driver:WebDriver = null
  
  @Before
  def init: Unit = {
    driver = new HtmlUnitDriver
    driver.get(url)
    (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.tagName("title"))) 	
    
  }

  @Test
  def HomepageTest = {
    driver.get(url)
    val title = driver.getTitle()
    assertEquals("TrendCloud", title)

    val link:WebElement = driver.findElement(By.id("trend1"))
    val linkText = link.getText
    
    link.click()
 
    val location = driver.getCurrentUrl()
    assertTrue(location.contains(linkText))
    
  }

  @After
  def after: Unit = {
    driver.quit
  }
  
}