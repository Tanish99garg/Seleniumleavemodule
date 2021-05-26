package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			
			FileInputStream fis = new FileInputStream
					("C:\\Users\\tangarg\\eclipse-workspace\\LeaveModule\\src\\main\\resources\\config\\config.properties");
			prop.load(fis);
			
			}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void Browser_Initialization(){
		
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
				
		}
		else if
		(BrowserName.equals("Firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
				
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(TestUtil.page_load_time, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(TestUtil.Implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
		
	}
	

}
