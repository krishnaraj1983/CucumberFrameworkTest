package automation.framework.common;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;	
	
	protected void enterText(List elem,String inputValue ) {
		
		String locator = elem.get(1).toString();
		driver.findElement(By.id(locator)).sendKeys(inputValue);
	}
	
   protected void clickOnButton(List elem) {		
		String locator = elem.get(1).toString();		
		driver.findElement(By.cssSelector(locator)).click();
	}
	
   protected void clickOnEnterKey(List elem) {		
		String locator = elem.get(1).toString();		
		driver.findElement(By.cssSelector(locator)).click();
	}

   protected void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
   
   protected void waitForElement(List elem) {
	   String locator = elem.get(1).toString();		
	   WebDriverWait wait = new WebDriverWait(driver, 30); 	
	  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
   }
	
	public void waitForPeriod(int sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}
	
	
	
	
}
