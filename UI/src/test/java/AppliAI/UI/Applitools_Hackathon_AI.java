
package AppliAI.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.awt.List;
import java.util.ArrayList;
import java.util.Properties;

import com.applitools.eyes.*;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

public class Applitools_Hackathon_AI{
	
	
public static WebDriver driver;


		// Initialize the Runner for your test.
		EyesRunner runner = new ClassicRunner();
		// Initialize the eyes SDK
		Eyes eyes = new Eyes(runner);
		
		

		@BeforeTest
		public void Initialization() {

		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver"
				+ ".exe");
		
		//Runtime.getRuntime().exec("C:\\SeleniumSetup\\AutoIT\\login_authen.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://demo.applitools.com/hackathon.html");
		driver.get("https://demo.applitools.com/hackathonV2.html");


		// Change the APPLITOOLS_API_KEY API key with yours
		eyes.setApiKey("zOK1005VPt94fky1Nygb1qrl27ugl1jWOv4tQS6qQTa4g110");
		eyes.open(driver, "Applitools_Hackathon", "Scenario_Pages");
		

		
		}
		
		
		
		
		
		
		
		//Login Page UI Elements Test
		//--------------------------------------------------------------
		@Test (priority=1)
		public void LoginPageUIElementsTest() throws InterruptedException
		{
			Thread.sleep(10000);
		
			eyes.checkWindow("Login Window - UI Elements Test");

		
		}
		
		
		
		
	
		
		
		
		
		//Data-Driven Test
		//--------------------------------------------------------------
		@Test (priority=2)
		public void DataDrivenTest()
		{
			
			driver.findElement(By.id("log-in")).click();
			eyes.checkWindow("Login Window - Data Driven Test 1");
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("abc");
			driver.findElement(By.id("log-in")).click();
			eyes.checkWindow("Login Window - Data Driven Test 2");
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("123");
			driver.findElement(By.id("log-in")).click();
			eyes.checkWindow("Login Window - Data Driven Test 3");
			
			
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("abc");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("123");
			driver.findElement(By.id("log-in")).click();
			System.out.println("Successfully Logged In");
		
		}

		
		
		
		

		
		
		
		
		
		//Table Sort Test
		//----------------------------------------------------------------------
		@Test (priority=3)
		public void TableSortTest() throws InterruptedException
		{
			Thread.sleep(10000);
		
			driver.findElement(By.id("amount")).click();
			
			eyes.checkWindow("Profile Page - Table Sort Test");
			

		
		}
		
		
		
		
		
		
		
		
		
		//Canvas Chart Test
		//--------------------------------------------------------------
		@Test (priority=4)
		public void CanvasChartTest() throws InterruptedException
		{
			Thread.sleep(10000);
			
			driver.findElement(By.id("showExpensesChart")).click();
			Thread.sleep(5000);
			
			eyes.checkWindow("Canvas Page - Canvas Chart Test 1");

	        
			
			
			driver.findElement(By.id("addDataset")).click();
			Thread.sleep(5000);
			
			eyes.checkWindow("Canvas Page - Canvas Chart Test 2");
		
		}

		
		
		
		
	
		
		
		
		
		//Dynamic Content Test
		//----------------------------------------------------------------------
		@Test (priority=5)
		public void DynamicContentTest()
		{
		
//			driver.navigate().to("https://demo.applitools.com/hackathon.html?showAd=true");
			driver.navigate().to("https://demo.applitools.com/hackathonV2.html?showAd=true");
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("gg");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("jj");
			driver.findElement(By.id("log-in")).click();
			System.out.println("Successfully Logged In to 2nd URL");
			
			
			//Images Present
			eyes.checkWindow("Dynamic Content Page - Dynamic Content Test");
			
		}

		
		
		
		
		
	    @AfterTest
	    public void terminateBrowser(){
	        driver.close();
	     // End the test.
	        eyes.close();
	    }
		
		
	
//}

}

