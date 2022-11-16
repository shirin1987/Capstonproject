package tek.sdet.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeHeadless implements Browser{
	
	// why this class
	// if we want to make a browser headless, we must use from it`s options. for Chrome browser
	// we use 'ChromeOptions'. this option has few argument and access us to make our browser headless
	// what is headless: the execution will be happen, but we will not see.

	@Override
	public WebDriver openBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		return driver;
	}
	
	

}
