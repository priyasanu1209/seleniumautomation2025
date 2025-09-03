package priyankaclass.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import priyankaclass.TestComponents.BaseTest;
import priyankaclass.pageobjects.CartPage;
import priyankaclass.pageobjects.LandingPage;
import priyankaclass.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{

@Test
public void submitOrder() throws InterruptedException, IOException
{
		String productname="ZARA COAT 3";
		
		
ProductCatalogue productCatalogue=landingpage.loginApplication("priyasanu1209@gmail.com","Priya@123");

List<WebElement>products=productCatalogue.getProductList();
productCatalogue.addProductToCart(productname);
CartPage cartpage=productCatalogue.goToCartPage();

 Boolean Match=cartpage.VerifyProductDisplay(productname);
 cartpage.goToCheckout();
Assert.assertTrue(Match);
driver.findElement(By.cssSelector(".totalRow button")).click();
Actions a=new Actions(driver);
a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results ")));
driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
String message=driver.findElement(By.cssSelector(".hero-primary")).getText();
Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
driver.close();

	}

}
