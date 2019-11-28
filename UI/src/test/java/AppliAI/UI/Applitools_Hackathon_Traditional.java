
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

public class Applitools_Hackathon_Traditional{
	
	
public static WebDriver driver;


//public static void main(String[] args) throws InterruptedException {


		@BeforeTest
		public void Initialization() {

			System.setProperty("webdriver.chrome.driver", "./lib/chromedriver"
					+ ".exe");
		
		//Runtime.getRuntime().exec("C:\\SeleniumSetup\\AutoIT\\login_authen.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.applitools.com/hackathon.html");
		


		
		}
		
		
		
		
		
		
		
		//Login Page UI Elements Test
		//--------------------------------------------------------------
		@Test (priority=1)
		public void LoginPageUIElementsTest() throws InterruptedException
		{
			Thread.sleep(10000);
//			WebDriverWait wait = new WebDriverWait(driver,180);
//
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[1]/div[3]/button[1]")));
		
			String VerifyLoginHead= driver.findElement(By.xpath("//h4[@class='auth-header']")).getText().trim();
			Assert.assertEquals(VerifyLoginHead, "Login Form");
			System.out.println("Header Present");
			
			
			
			String VerifyUserNameLabel= driver.findElement(By.xpath("//form[1]/div[1]/label[1]")).getText().trim();
			Assert.assertEquals(VerifyUserNameLabel, "Username");
			System.out.println("Username Present");
			
			WebElement VerifyUserNameField = driver.findElement(By.id("username"));
			Assert.assertEquals(true, VerifyUserNameField.isDisplayed());
			System.out.println("Username Field Present");
			
			Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed(), "Username Field Present1");
			
			
			
			String VerifyPasswordLabel= driver.findElement(By.xpath("//form[1]/div[2]/label[1]")).getText().trim();
			Assert.assertEquals(VerifyPasswordLabel, "Password");
			System.out.println("Password Present");
			
			WebElement VerifyPasswordField = driver.findElement(By.id("password"));
			Assert.assertEquals(true, VerifyPasswordField.isDisplayed());
			System.out.println("Password Field Present");
			
			Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed(), "Password Field Present1");
			
			
			
			String VerifySignOnButton= driver.findElement(By.xpath("//form[1]/div[3]/button[1]")).getText().trim();
			Assert.assertEquals(VerifySignOnButton, "Log In");
			System.out.println("Login Button Present");
		
		}
		
		
		
		
		
		
		
		
		
		
		
		//Data-Driven Test
		//--------------------------------------------------------------
		@Test (priority=2)
		public void DataDrivenTest()
		{
			
			driver.findElement(By.id("log-in")).click();
			String LoginError1= driver.findElement(By.xpath("//div[contains(@id,'random_id_')]")).getText().trim();
			Assert.assertEquals(LoginError1, "Both Username and Password must be present");
			System.out.println("Error - Both Username and Password not Present");
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("papmajum@in.ibm.com");
			driver.findElement(By.id("log-in")).click();
			String LoginError2= driver.findElement(By.xpath("//div[contains(@id,'random_id_')]")).getText().trim();
			Assert.assertEquals(LoginError2, "Password must be present");
			System.out.println("Error - Password not Present");
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("Papapplitoolpass123");
			driver.findElement(By.id("log-in")).click();
			String LoginError3= driver.findElement(By.xpath("//div[contains(@id,'random_id_')]")).getText().trim();
			Assert.assertEquals(LoginError3, "Username must be present");
			System.out.println("Error - Username not Present");
			
			
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("papmajum@in.ibm.com");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("Papapplitoolpass123");
			driver.findElement(By.id("log-in")).click();
			System.out.println("Successfully Logged In");
		
		}

		
		
		
		
		
		
		
		
		
		
		
		//Table Sort Test
		//----------------------------------------------------------------------
		@Test (priority=3)
		public void TableSortTest() throws InterruptedException
		{
			Thread.sleep(10000);
		
			String VerifyBranchClosesIn = driver.findElement(By.id("time")).getText().trim();
			Assert.assertEquals(VerifyBranchClosesIn, "Your nearest branch closes in: 30m 5s");
			System.out.println("Branch Closes In Matched");
			
			String VerifyTotalBalance = driver.findElement(By.xpath("//div[@id='totalBalance']/div[2]/span[1]")).getText().trim();
			Assert.assertEquals(VerifyTotalBalance, "$350");
			System.out.println("Total Balance Matched");
			
			String VerifyCreditAvailable= driver.findElement(By.xpath("//div[@id='creditAvailable']/div[2]")).getText().trim();
			Assert.assertEquals(VerifyCreditAvailable, "$17,800");
			System.out.println("Credit Available Matched");
			
			String VerifyDueToday= driver.findElement(By.xpath("//div[contains(@class,'element-balances')]/div[5]/div[2]")).getText().trim();
			Assert.assertEquals(VerifyDueToday, "$180");
			System.out.println("Due Today Matched");
			
			
			driver.findElement(By.xpath("//span[contains(text(),'Credit cards')]")).click();
			System.out.println("Credit Card Menu Link Clicked");
			
			
			
			
			//SORT TABLE
			//---------------------------------------------------------------------------------------------
			
			driver.findElement(By.id("amount")).click();
			
			int rowCount = driver.findElements(By.xpath("//table[@id='transactionsTable']/tbody[1]/tr")).size();
			int colCount = driver.findElements(By.xpath("//table[@id='transactionsTable']/tbody[1]/tr[1]/*")).size();
			System.out.println("Number of Rows" +rowCount);
//			System.out.println("Number of Columns" +colCount);
			
			
			ArrayList<String> secondColumnList=new ArrayList<String>();
			
//			List<Integer> l = new ArrayList<>(); 
//	        l.add(10); 
//	        l.add(15); 
//	        l.add(20); 
//	        System.out.println(l);
			
		    //iterate through the list

	        for(int i=1;i<=rowCount;i++){
	    		String VerifySortTableText= driver.findElement(By.xpath("//table[@id='transactionsTable']/tbody[1]/tr["+i+"]/td[5]/span[1]")).getText().trim();
	    		System.out.println("Individual Number" +VerifySortTableText);
	    		
	    	    secondColumnList.add(VerifySortTableText);

	        }
//	        int orderFlag=0;
//	        int tempvalue = -999999999;
	        
//			System.out.println("Sort Numbers");
	        
//	        for(int i=0;i<rowCount;i++){
	    	    
//	        	if (tempvalue<=Integer.parseInt(secondColumnList.get(i).split(" USD")[0])) {
//	        		
//	        	}
//	        	else {
//	        		orderFlag=1;
//	        		break;
//	        	}
//	        	tempvalue=Integer.parseInt(secondColumnList.get(i));
//	    		System.out.print("," +secondColumnList.get(i));

//	        }
//	        if(orderFlag==0) {
//				Assert.assertTrue(true,"Numbers are Sorted in Ascending Order");
//	        }
//	       
//	        else {
//				Assert.assertFalse(false,"Numbers are NOT Sorted");
//	        }
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//Canvas Chart Test
		//--------------------------------------------------------------
		@Test (priority=4)
		public void CanvasChartTest() throws InterruptedException
		{
			Thread.sleep(10000);
			
			driver.findElement(By.id("showExpensesChart")).click();
			Thread.sleep(5000);
			
			String scriptElement = driver.getPageSource();
			
//			String scriptElement = driver.findElement(By.tagName("script")).getAttribute("outerHTML");

			
//			String bodyText = driver.findElement(By.xpath("//div[contains(@class,'element-')]/script")).getText();
//	        System.out.println("ScriptText" +scriptElement);

//			boolean flag = false;
			if (scriptElement.contains("label: '2017'")) {
//				flag = true;
				// This method will return True when the page title matches with specified string
				System.out.println("Label 2017 matched");
				Assert.assertTrue(true,"Label 2017 matched");
			} else {
				Assert.assertFalse(false, "2017 not matching with expected");
			}

	        

			if (scriptElement.contains("label: '2018'")) {
//				flag = true;
				// This method will return True when the page title matches with specified string
				System.out.println("Label 2018 matched");
				Assert.assertTrue(true, "2018 matching with expected");
			} else {
				Assert.assertFalse(false, "2018 not matching with expected");
			}

	        

			if (!scriptElement.contains("label: '2019'")) {
//				flag = true;
				// This method will return True when the page title matches with specified string
				System.out.println("Label 2019 not present as expected");
				Assert.assertTrue(true, "Label 2019 not present As Expected");
			} else {
				Assert.assertFalse(false, "Label 2019 present Not Expected");
			}


	        
			
			
			driver.findElement(By.id("addDataset")).click();
			Thread.sleep(5000);
			
			String scriptElement1 = driver.getPageSource();
			
			
			if (scriptElement1.contains("label: '2017'")) {
//				flag = true;
				// This method will return True when the page title matches with specified string
				System.out.println("Label 2017 matched");
				Assert.assertTrue(true, "Label 2017 matched");
			} else {
				Assert.assertFalse(false, "2017 not matching with expected");
			}

	        

			if (scriptElement1.contains("label: '2018'")) {
//				flag = true;
				// This method will return True when the page title matches with specified string
				System.out.println("Label 2018 matched");
				Assert.assertTrue(true, "Label 2018 matched");
			} else {
				Assert.assertFalse(false, "2018 not matching with expected");
			}

			
			
			if (scriptElement1.contains("label: '2019'")) {
//				flag = true;
				// This method will return True when the page title matches with specified string
				System.out.println("Label 2019 matched");
				Assert.assertTrue(true, "Label 2019 matched");
			} else {
				Assert.assertFalse(false, "2019 not matching with expected");
			}
		
		}

		
		
		
		
		
		
		
		
		
		
		
		//Dynamic Content Test
		//----------------------------------------------------------------------
		@Test (priority=5)
		public void DynamicContentTest()
		{
		
			driver.navigate().to("https://demo.applitools.com/hackathon.html?showAd=true");
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("gg");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("jj");
			driver.findElement(By.id("log-in")).click();
			System.out.println("Successfully Logged In to 2nd URL");
			
			
			//Images Present
			WebElement Image1 = driver.findElement(By.xpath("//div[@id='flashSale']/img[1]"));
			Assert.assertEquals(true, Image1.isDisplayed());
			System.out.println("Image1 Exists");
			 
			WebElement Image2 = driver.findElement(By.xpath("//div[@id='flashSale2']/img[1]"));
			Assert.assertEquals(true, Image2.isDisplayed());
			System.out.println("Image2 Exists");
			
		}

		
		
		
		
		
	    @AfterTest
	    public void terminateBrowser(){
	        driver.close();
	    }
		
		
	
//}

}

