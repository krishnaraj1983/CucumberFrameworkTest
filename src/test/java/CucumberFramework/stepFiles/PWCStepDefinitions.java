package CucumberFramework.stepFiles;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import CucumberFramework.model.Account;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import automation.framework.common.BasePage;
import  automation.framework.utils.*;

public class PWCStepDefinitions extends BasePage {
	
	HashMap<Integer, String> objval = new HashMap<Integer,String>();
	private  static HashMap<String, List<String>> elemRepo = null;
		
	
	@Before
	public void setup_firefox() throws IOException {
		
		System.setProperty("webdriver.gecko.driver",
			      new File("./src/test/resources/drivers/geckodriver.exe").getCanonicalPath());
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		this.driver = new FirefoxDriver(capabilities);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		
		File fi = new File("src\\test\\resources\\objectRepository\\"+"\\"+configProperties.getInstance().getProperty("element"));
		FileInputStream fis = new FileInputStream(fi.getAbsolutePath());
		elemRepo = new ReadCsv().readElementRepositoryByCsvFile(fi.getAbsolutePath().toString());
	}
	
	@After
	public void tearDown() throws InterruptedException {
		//this.driver.quit();
		/*this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;*/
	}
	
	
	
	@Given("^I navigate to the PwCDigitalPulse website$")
	public void user_navigates_to_pwc_website() throws Throwable {
		driver.get(configProperties.getInstance().getProperty("pwchost"));
		
	}
	
	@When("^I am viewing the ‘Home’ page$")
	public void homePageHeading() throws Throwable {
		
		List element =  elemRepo.get("heading");
		String locator = element.get(1).toString();
		String heading = driver.findElement(By.xpath(locator)).getAttribute("alt");
		Assert.assertNotNull("The object you enter return null", heading);

	}
	
	@Then("^I am presented with a carousel displaying 3 featured articles$")
	public void displaying_3_featured_articles() throws Throwable {
		
		List featuredArticles =  elemRepo.get("featuredArticles");
		String locator = featuredArticles.get(1).toString();
		
		List featuredArticlesText =  elemRepo.get("featuredArticlesText");
		String featuredArticlesTextLocator = featuredArticlesText.get(1).toString();
		
		List<WebElement> buttons = driver.findElements(By.cssSelector(locator));
		
		for(int i=0;i<buttons.size();i++) {
			//Thread.sleep(1000);
			waitForElement(featuredArticles);
			WebElement elem = buttons.get(i).findElement(By.xpath(featuredArticlesTextLocator));
			objval.put(i, elem.getText());					
		}
		
	}

	@And("^Clicking the ‘Next’ button on the carousel will load the next 3 featured articles$")
	public void ClickOnNext() throws Throwable {
		
		driver.findElement(By.cssSelector(".flex-next")).click();
		List featuredArticles =  elemRepo.get("featuredArticles");
		String locator = featuredArticles.get(1).toString();
		
		List featuredArticlesText =  elemRepo.get("featuredArticlesText");
		String featuredArticlesTextLocator = featuredArticlesText.get(1).toString();
		
		List<WebElement> buttons = driver.findElements(By.cssSelector(locator));
		
		for(int i=0;i<buttons.size();i++) {
			waitForElement(featuredArticles);
			WebElement element = buttons.get(i).findElement(By.xpath(".//div[@class='inner']/h2"));
			assertNotEquals("values are not matching", objval.get(i),element.getText());
					
		}
	}
	
	@And("^Clicking the ‘Previous’ button on the carousel will load the previous 3 featured articles$")
	public void ClickOnPrevious() throws Throwable {		
		driver.findElement(By.cssSelector(".flex-prev")).click();
		List articletable =  elemRepo.get("articletable");	
		waitForElement(articletable);
		String locator = elemRepo.get("articletable").get(1);;
		List<WebElement> articlesSize = driver.findElements(By.cssSelector(locator));
		
		for(int i=0;i<articlesSize.size();i++) {
			WebElement element = articlesSize.get(i).findElement(By.xpath(".//div[@class='inner']/h2"));
			assertEquals(element.getText(), objval.get(i), "values are not matching");					
		}		
	}	
	
	
	@Then("^I select ‘Contact us’ from the hamburger menu$")
	public void clickontheMenu() throws Throwable {
		driver.findElement(By.cssSelector("div.inner > div > i.btr.bt-bars.trigger")).click();
		Thread.sleep(1000);		
	}
	
	
	@Then("^I am taken to the ‘Contact us’ page$")
	public void contactUsMenu() throws Throwable {
		driver.findElement(By.id("menu-item-65")).click();
		
	}
	
	@Given("^I am presented with the below options for contacts$")
	public void verifyContactDetails(DataTable datatable) throws Throwable {
		List<WebElement> items = driver.findElements(By.cssSelector("div.row.flex > div"));
		List<Map<String, String>> list = datatable.asMaps(String.class, String.class);
		for(int i=0; i<list.size(); i++) {
			String expectedHeading = list.get(i).get("Heading").toString();
			String expectedContact = list.get(i).get("Contact").toString();			
			WebElement actualheading = items.get(i).findElement(By.xpath(".//h2"));
			String actualheadingtext = actualheading.getText();
			
			String stripped = actualheadingtext.replace("\n", " ").replace("\r", " ");
			assertTrue(stripped.contains(expectedHeading));
			
			if(expectedContact.length()>0) {
				WebElement conturl = items.get(i).findElement(By.xpath(".//a"));
				String contactUrlVal = conturl.getAttribute("href");
				assertTrue(contactUrlVal.contains(expectedContact));
				
			}			
		}		    
	}
	
	@And("^User clicks on the login button on homepage$")
	public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
		waitForPageLoaded();
		driver.findElement(By.xpath("//a[text()='Log In']")).click();
	}

		
	@When("^I click on the ‘Magnifying glass’ icon to perform a search$")
	public void clickonButton() throws Throwable {
		List searchButton =  elemRepo.get("searchButton");			
		clickOnButton(searchButton);
	}		
	
	@And("^I enter the text \"(.*)\"$") 
	public void enterValue(String SearchVal) { 
		List searchInput =  elemRepo.get("searchInput");		
		enterText(searchInput, SearchVal);	   
	}
	
	@And("^I submit the search$") 
	public void submit() { 
		driver.findElement(By.id("search-input")).sendKeys(Keys.ENTER);
	}	
	
	@Then("^I am taken to the search results page$")
	public void searchResults() throws Throwable {
		List searchPage =  elemRepo.get("searchPage");	
		waitForElement(searchPage);		
		WebElement searchPageHeading = driver.findElement(By.cssSelector("section.container.intro > div > div"));
		System.out.println(searchPageHeading.getText());
		Assert.assertNotNull("The object you enter return null", searchPageHeading.getText());
		
	}	
	
	@And("^I am presented with at least 1 search result$") 
	public void searchResult() { 
		int length = driver.findElements(By.cssSelector("section.container.content.main-content.padding > div >div")).size();
		Assert.assertTrue(length>=1);				
	}	

}
