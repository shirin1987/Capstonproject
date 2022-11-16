package tek.sdet.framework.utilities;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import tek.sdet.framework.base.BaseSetup;

public class CommonUtility extends BaseSetup{
	
	
	public WebDriverWait explicitWait() {
		return new WebDriverWait(getDriver(),Duration.ofSeconds(20));
	}
	
	public WebElement waitTillClickable(WebElement element) {
		return this.explicitWait().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement waitTillClickable(By locator) {
		return this.explicitWait().until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public WebElement waitTillPresence(WebElement element) {
		return this.explicitWait().until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public WebElement waitTillPresence(By locator) {
		return this.explicitWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void click(WebElement element) {
		this.waitTillClickable(element).click();
	}
	public void click(By locator) {
		this.waitTillPresence(locator).click();
	}
	
	public void clearText(WebElement element) {
		this.waitTillPresence(element).clear();
	}
	
	public void sendText(WebElement element, String value) {
		this.waitTillPresence(element).sendKeys(value);
	}
	
	public String getElementText(WebElement element) {
		return this.waitTillPresence(element).getText();
	}
	
	public String getElementText(By by) {
		return this.waitTillPresence(by).getText();
	}
	
	public byte[] takeScreenShotAsBytes() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	}
	
	public void sendText(By by, String value) {
		this.waitTillPresence(by).sendKeys(value);
	}
	
	public String getTitle() {
		String title = getDriver().getTitle();
		return title;
	}
	
	public void sendValueByUsingJS(WebElement element, String value) {
		JavascriptExecutor js = ((JavascriptExecutor)getDriver());
		js.executeScript("arguments[0].value='" + value + "'", element);
	}
	
	public void clearTextUsingSendKeys(WebElement toClear) {
		toClear.sendKeys(Keys.CONTROL+"a");
		toClear.sendKeys(Keys.DELETE);
	}
	
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		
	}
	
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectByVisibleText(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByVisibleText(value);;
	}
	
	public String getAttribute(WebElement ele, String value) {
		String str = ele.getAttribute(value);
		return str;
	}
	
	public String getTagName(WebElement ele) {
		return ele.getTagName();
	}
	
	public String getText(WebElement ele) {
		return ele.getText();
	}
	
	 public void HighlightElement(WebElement ele) {
	        JavascriptExecutor js = (JavascriptExecutor) getDriver();
	        js.executeScript("arguments[0].style.border='3px solid red'", ele);
	        js.executeScript("arguments[0].style.border='1px white'", ele);
	    }
	 
	 public void dragAndDrop(WebElement from, WebElement target) {
		Actions actions = new Actions(getDriver());
		actions.dragAndDrop(from, target).build().perform();
	 }
	 
	 public void dragAndDrop(WebElement from, WebElement target, WebElement iframe) {
		 Actions actions = new Actions(getDriver());
		 getDriver().switchTo().frame(iframe);
		 actions.dragAndDrop(from, target).build().perform();
	 }
	
	 public  boolean isElementDisplayed(WebElement ele) {
	        if (ele.isDisplayed()) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	
	 public  boolean isElementNotDisplayed(WebElement ele) {
	        if (ele.isDisplayed()) {
	            return false;
	        } else {
	            return true;
	        }
	    }
	
	 
	 public  boolean isElementEnabled(WebElement ele) {
	        if (ele.isEnabled()) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	 
	 public  boolean isElementSelected(WebElement ele) {
	        if (ele.isSelected()) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	
	 public  void deselectByIndex(WebElement ele, int index) {
	        Select deselect = new Select(ele);
	        deselect.deselectByIndex(index);
	    }
	
	 public  void deselectByValue(WebElement ele, String value) {
	        Select deselect = new Select(ele);
	        deselect.deselectByValue(value);
	    }
	
	 public  void deselectByVisibleText(WebElement ele, String visibleText) {
	        Select deselect = new Select(ele);
	        deselect.deselectByVisibleText(visibleText);
	    }
	    
	  
	 public void moveToElement(WebElement element) {
		 Actions actions = new Actions(getDriver());
		 actions.moveToElement(element);
		 actions.build().perform();
	 }
	    
//	 public WebElement fluientWaitforElement(WebElement element, int timoutSec, int pollingSec) {
//	        FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(30))
//	                .pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class, TimeoutException.class)
//	                .ignoring(StaleElementReferenceException.class);
//	        for (int i = 0; i < 2; i++)
//	            fWait.until(ExpectedConditions.visibilityOf(element));
//	        return element;
//	    }
//	    
	   public void switchwindow(String pageTitle) {
	        String currentWindow = getDriver().getWindowHandle();
	        Set<String> handles = getDriver().getWindowHandles();
	        for (String winHandle : handles) {
	            String currentWindowTitle = getDriver().switchTo().window(winHandle).getTitle();
	            if (currentWindowTitle.equals(pageTitle)) {
	                break;
	            } else {
	                getDriver().switchTo().window(currentWindow);
	            }
	        }
	    }
	    
	   public void selectCalendarDateWithJS(String date, WebElement element) {
	        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
	        js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);
	   }
	
	  
	   public void clickWithJS(WebElement element) {
		   JavascriptExecutor js = ((JavascriptExecutor)getDriver());
		   js.executeScript("arguments[0].click();", element);
	   }
	
	   public void scrollPageDownWithJS() {

       JavascriptExecutor js = ((JavascriptExecutor) getDriver());
       js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	   }
	   
	   public String popUpGetText() {
		  Alert alert = getDriver().switchTo().alert();
		 return alert.getText();
	   }
	   
	   public void slowDown() {
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }}
	   
	   public boolean isNotDisplayed(WebElement ele) {
		   if(ele==null) {
			   return true;
		   } else {
			   return false;
		   }
	   }
	   
	   
//	   public boolean equal(WebElement ele, String str) {
		 
//		   for(int i=0;i<list.size();i++) {
//			   
//			   if(ele.equals(list.get(0).get(i))){
//				   return true;
//			   }
//			   
//			   return false;
//		   }
//		   }
//		   
//		   if(ele.equals(str)){
//			   return true;
//		   } else {
//			   return false;
//		   }
//		  
//		   
//	   }
		   
		
	   
}
