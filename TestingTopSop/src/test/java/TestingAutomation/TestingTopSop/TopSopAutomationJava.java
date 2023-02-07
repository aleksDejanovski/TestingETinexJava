package TestingAutomation.TestingTopSop;

import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TopSopAutomationJava{

	public WebDriver driver;
	public LandingPage landingPage;
	public ProductPage productpage;
	public String user;
	public String pass;
	
	@Test
	public void EndToEndTestIfNaplataCanBeProcesed()
	{
	
		
		landingPage.goTo();
		landingPage.clickNajava();
		landingPage.loginApp(user, pass);
		productpage.clickOsnovni();
		productpage.closeCookies();
		productpage.addToCard();
		productpage.clickCart();
		Assert.assertEquals(productpage.NaplataKopce.getText(), "НАПЛАТА");
	

	}
	@Test
	public void EndToEndTestBelow600Den()
	{
		
		
		landingPage.goTo();
		landingPage.clickNajava();
		landingPage.loginApp(user, pass);
		productpage = new ProductPage(driver);
		productpage.clickOsnovni();
		productpage.closeCookies();
		productpage.addToCard();
		productpage.clickCart();
		productpage.clickNaplata();
		productpage.ClickProdolzi();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("600 денари"));
		
		

	}
	@BeforeMethod
	public void BeforeMetod ()
	{
		user = "dejanovski_a@yahoo.com";
		pass = "ubavovreme1";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.manage().window().maximize();
		landingPage = new LandingPage (driver);
		productpage = new ProductPage(driver);
		user = "dejanovski_a@yahoo.com";
		pass = "ubavovreme1";
		
	}
	@org.testng.annotations.AfterMethod
	
	public void AfterMethod()
	{
		driver.quit();
		
	}
	@Test
	public void InvalidLoginCheck()
	{
		
		landingPage.goTo();
		landingPage.clickNajava();
		landingPage.loginApp(user, "2313232");
		Assert.assertTrue(landingPage.InvalidLoginText.getText().contains("Грешно корисничко име или лозинка!"));
	}
	@Test
	public void MlecniProizvodiCheck() throws InterruptedException
	{
		
		landingPage.goTo();
		landingPage.clickNajava();
		landingPage.loginApp(user, pass);
		productpage.ClickMlecni();
		productpage.closeCookies();
		productpage.ClickMleko();
		productpage.clickCart();
		Thread.sleep(2000);
		Assert.assertEquals(productpage.TitleOfProduct.getText(), "МЛЕКО +D3 витамин 3.2%м.м. BIMILK 1л.");
	}
	@Test
	public void PickProductFromOsnovniProizvodi()
	{
		
		
		landingPage.goTo();
		landingPage.clickNajava();
		landingPage.loginApp(user, pass);
		productpage = new ProductPage(driver);
		productpage.clickOsnovni();
		productpage.closeCookies();
		productpage.SelectProduct().click();
		Assert.assertTrue(productpage.NaslovProdukt.getText().contains("KOSTA D'ORO 0.75мл"));
		
		
	}
	@Test
	public void PickProductAsUserEntersProductName()
	{
		
		//user can enter product in test here bellow
		String produkt = "МАСЛО маслиново Extra vergine OLITALIA 1л";
		landingPage.goTo();
		landingPage.clickNajava();
		landingPage.loginApp(user, pass);
		productpage = new ProductPage(driver);
		productpage.clickOsnovni();
		productpage.closeCookies();
		productpage.SelectProductAsUserEnters(produkt).click();
		Assert.assertTrue(productpage.NaslovProdukt.getText().contains(produkt));
		
	}


}
