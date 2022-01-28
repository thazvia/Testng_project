package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCategoryPage;
import page.DuplicateCategoryCheckPage;
import util.BrowserFactory;

public class Test2 {

	
WebDriver driver;
	

String CategoryName1 =null;

	
	
	
	@Test
	@Parameters({"CategoryName1"})
	public void UserShouldBeAbleToCheckDuplicateCategory(String CategoryName1) throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		DuplicateCategoryCheckPage DCPage = PageFactory.initElements(driver, DuplicateCategoryCheckPage.class);
		
		DCPage.addCategoryName(CategoryName1);
		DCPage.clickAddCategoryButton();
		DCPage.addCategoryNameAgain(CategoryName1);
		DCPage.clickAddCategoryButton();
		DCPage.clickNevermindButton();
		
		BrowserFactory.teardown();
	}
		
}
