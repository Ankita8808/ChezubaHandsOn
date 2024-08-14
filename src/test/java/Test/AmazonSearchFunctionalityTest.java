package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchFunctionalityTest {
	
	 WebDriver driver;

	    @BeforeClass
	    public void setup() {
	   
	    	WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.amazon.in/");
	     
	    }
	    @Test
	    public void testSearchFunctionality() throws InterruptedException {
	        
	        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

	     
	        String searchTerm = "Selenium";
	        searchBox.sendKeys("Selenium");

	        Thread.sleep(2000);
	        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
	        searchButton.click();

	        Thread.sleep(3000);
	       
	        WebElement results = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
             Thread.sleep(3000);
	       
           
             String expectedText = "Results for '" + searchTerm + "'";
 	        String actualText = results.getText();
 	        Assert.assertEquals(actualText, expectedText, "The search results are as expected!");
	    }
	    @AfterClass
	    public void tearDown() {
	    
	        if (driver != null) {
	            driver.quit();
	        }

}
}