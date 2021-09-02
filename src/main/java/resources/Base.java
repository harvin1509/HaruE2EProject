package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties properties=new Properties();
		FileInputStream fileinputstream=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\HaruE2EProject\\src\\main\\java\\AcademyHaru\\HaruE2EProject\\data.properties");
		
		//my property file is responsible to pull the values from data.proerties, so there is a method to give knowledge and  
		//will pass fileinputstream
		
		properties.load(fileinputstream);
		String browserName=properties.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {}
		else if(browserName.equals("IE")) {}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
