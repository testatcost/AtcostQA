package pom.atcost.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pom.atcost.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory 
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Register Account')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'logo')]")
	WebElement atcostLogo;
	@FindBy(linkText = "Log out")
	public
	WebElement logoutBtn;
	
	@FindBy(xpath="//div[contains(@class , 'alert alert-danger')]")
	public
	WebElement loginAlertMsg;

	//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}


		//Actions:
public String validateLoginPageTitle(){
	return driver.getTitle();
}

public boolean validateLogoutbtn(){
	return logoutBtn.isDisplayed();
}
public boolean validateAtcostImage(){
	return atcostLogo.isDisplayed();
}

public void clickonlogin() throws InterruptedException{
	driver.findElement(By.id(("popup_login"))).click();  
    Thread.sleep(7000);
    WebElement fr =  driver.findElement(By.xpath("//iframe[@class='cboxIframe']")); 
    driver.switchTo().frame(fr);
    
}
public Homepage login(String un, String pwd) throws InterruptedException{
	
	clickonlogin();
	email.sendKeys(un);
	password.sendKeys(pwd);
	loginBtn.click();
	    	//JavascriptExecutor js = (JavascriptExecutor)driver;
	    	//js.executeScript("arguments[0].click();", loginBtn);
	    	
	return new Homepage();
}


public String validateLoginLogout() {
	logoutBtn.click();
	return driver.getTitle();
}

}