package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCategoryPage;
import util.BrowserFactory;

public class Test1 {

	
WebDriver driver;
	

String CategoryName =null;

	
	
	
	@Test
	@Parameters({"CategoryName","ColorName"})
	public void verifiedUserShouldBeAbleToAddCategory(String CategoryName,String ColorName) throws InterruptedException {
		
		driver = BrowserFactory.init();
		AddCategoryPage add = PageFactory.initElements(driver, AddCategoryPage.class);
		
		
		add.addCategoryName(CategoryName);
		add.clickAddCategoryButton();
		
		add.clickAddCategory1Button();
		Thread.sleep(3000);
		add.clickNevermindButton();
		
		add.insertCategory(CategoryName);
		
		
		BrowserFactory.teardown();
	}
		
}
