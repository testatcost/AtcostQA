package pom.atcost.testcases;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.atcost.base.TestBase;
import pom.atcost.pages.Homepage;
import pom.atcost.pages.LoginPage;
import pom.atcost.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	Homepage homePage;
	
	Workbook wb;
	Sheet sh1;
	int numrow;
	String username;
	String password;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Atcost.in | Your money buys a LOT MORE ... With Us");
	}
	
	@Test(priority=3 )
	public void loginTest() throws Exception{
		
		for(int row=1; row <=2;row++)
		{
			username = TestUtil.getCellData(row, 0);
		System.out.println("Username "+username);
	
		password = TestUtil.getCellData(row, 1);
		System.out.println("pwd "+password);
		
		homePage = loginPage.login(username , password );
		String actualUrl="http://www.atcostretail.co.in/index.php?route=account/account"; 
		  String expectedUrl= driver.getCurrentUrl(); if(actualUrl.equalsIgnoreCase(expectedUrl)) { 
		  System.out.println("Test passed"); 
		  String LgoutTitle = loginPage.validateLoginLogout();} else { System.out.println("Login failed for :" +username); } }   }
		
		
	
	
//@Test(priority=2)
//public void logoutTest() throws Exception{
		
//	String sUserName = TestUtil.getCellData(1, 1);
//	 String sPassword = TestUtil.getCellData(1, 2);
     //  homePage = loginPage.login(username , password );
   //     String LgoutTitle = loginPage.validateLoginLogout();} 
	

	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}

}
