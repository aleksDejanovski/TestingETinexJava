package TestingAutomation.TestingTopSop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

WebDriver driver;
	
	public ProductPage (WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = "a[href='default.aspx?b=31']")
	WebElement OsnovniProizvodi;
	
	@FindBy (id = "closeCookiesMob")
	WebElement Cookies;
	
	@FindBy (css = "a[href='default.aspx?b=27']")
	WebElement MlecniProizvodi;

	
	@FindBy (css = "div[data-id='609011']")
	WebElement AddCart;
	
	@FindBy (css = "a[class='koshnichka_btn'] div[class='slika_kopc_menu']")
	WebElement Cart;
	
	@FindBy (css =".kopce_naplati2")
	WebElement NaplataKopce;
	
	@FindBy (id = "popup-article-submit")
	WebElement Prodolzi;
	
	@FindBy (css = "div[data-id='610263']")
	WebElement Mleko;
	
	@FindBy (css = ".title_item_koshnichka")
	WebElement TitleOfProduct;
	
	public void clickOsnovni()
	{
		OsnovniProizvodi.click();
	}
	
	public void closeCookies()
	{
		Cookies.click();
	}
	
	public void addToCard()
	{
		AddCart.click();
	}
	
	public void clickCart()
	{
		Cart.click();
	}
	
	public void clickNaplata()
	{
		NaplataKopce.click();
	}
	
	public void ClickProdolzi()
	{
		Prodolzi.click();
	}
	public void ClickMlecni()
	{
		MlecniProizvodi.click();
	}
	
	public void ClickMleko()
	{
		Mleko.click();
	}
	


	
	
}
