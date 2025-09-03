package priyankaclass.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import priyankaclass.AbstarctComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement useremail=driver.findElement(By.id("userEmail"));
@FindBy(id="userEmail")
WebElement useremail;
@FindBy(id="userPassword")
WebElement password;
@FindBy(id="login")
WebElement submit;
public ProductCatalogue loginApplication(String email,String pswd)
{
	useremail.sendKeys(email);
	password.sendKeys(pswd);
	submit.click();
	ProductCatalogue productCatalogue=new ProductCatalogue(driver);
	return productCatalogue;
}
public void goTo()
{
	driver.get("https://rahulshettyacademy.com/client");
}
}
