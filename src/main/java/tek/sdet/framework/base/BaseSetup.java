package tek.sdet.framework.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import tek.sdet.framework.config.Browser;
import tek.sdet.framework.config.ChromeBrowser;
import tek.sdet.framework.config.ChromeHeadless;
import tek.sdet.framework.config.EdgeBrowser;
import tek.sdet.framework.config.FireFoxBrowser;
import tek.sdet.framework.utilities.ReadYamlFiles;

public class BaseSetup {

	// What we have in this class?
	// In this class we are gonna define the property of WebDriver.
	// We are gonna define which browser we are gonna use.
	// This class is gonna act as parent of other classes.
	
	private static WebDriver webDriver;
	private final ReadYamlFiles enviromentVariables;
	public static Logger logger;
	
	
	// inside this constructor we are going to read the yaml file
	// we need to get the file path from the enviroment configration 
	// and also need to get the file path for log4j
	
	public BaseSetup() {                             // address of yaml file that we stored
		String filePath = System.getProperty("user.dir")+"/src/main/resources/env_config.yml";
		                                             // address of log4j that we stored
		String log4jPath = System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
		
		try {
			enviromentVariables = ReadYamlFiles.getInstance(filePath);
		} catch (FileNotFoundException e) {
			System.out.println("Failed for Load environment context. check possible file path errors");
            throw new RuntimeException("Failed for Load environment context with message " + e.getMessage());
        }
		
		
		logger = logger.getLogger("logger_File");
		PropertyConfigurator.configure(log4jPath);
		
	}
	
	public WebDriver getDriver() {
		return webDriver;
	}
	
	public void setupBrowser() {
		HashMap uiProperties = enviromentVariables.getYamlProperty("ui");
		String url = uiProperties.get("url").toString().toLowerCase();
		Browser browser;
		switch (uiProperties.get("browser").toString().toLowerCase()) {
		case "chrome":
			if ((boolean) uiProperties.get("headless")) {
				browser = new ChromeHeadless();
			} else {
				browser = new ChromeBrowser();
			}
			webDriver = browser.openBrowser(url);
			break;
		case "firefox":
			browser = new FireFoxBrowser();
			webDriver = browser.openBrowser(url);
			break;
		case "edge":
			browser = new EdgeBrowser();
			webDriver = browser.openBrowser(url);
			break;
		default:
			throw new RuntimeException("Unknown Browser check environment properties");
		}
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void quitBrowser() {
		if(webDriver !=null)
			webDriver.quit();
	}
	
	
	
	
	

}
