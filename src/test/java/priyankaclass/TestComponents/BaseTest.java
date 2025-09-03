package priyankaclass.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import priyankaclass.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage;
public WebDriver intializeDriver() throws IOException
{
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\SeleniumNew\\src\\main\\java\\priyankaclass\\resources\\GlobalData.properties");
	prop.load(fis);
	String browserName = System.getProperty("browser");
	if (browserName.contains("chrome")) {
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless")){
		options.addArguments("headless");
		}		
		driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1440,900));//full screen

	} else if (browserName.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver",
				"/Users/rahulshetty//documents//geckodriver");
		driver = new FirefoxDriver();
		// Firefox
	} else if (browserName.equalsIgnoreCase("edge")) {
		// Edge
		System.setProperty("webdriver.edge.driver", "edge.exe");
		driver = new EdgeDriver();
	}

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;

}
@BeforeMethod
public LandingPage launchApplication() throws IOException
{
	driver=intializeDriver();
	landingpage=new LandingPage(driver);
	landingpage.goTo();
	return landingpage;
}
}
