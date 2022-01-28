package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCategoryPage;
import page.DuplicateCategoryCheckPage;
import page.ValidateMonthPage;
import util.BrowserFactory;

public class Test3 {

	
WebDriver driver;
	

	
	@Test
	@Parameters({"mon1","mon2","mon3","mon4","mon5","mon6","mon7","mon8","mon9","mon10","mon11","mon12"})
	public void UserShouldBeAbleToVlidateMonthDropDown(String mon1,String mon2,String mon3,String mon4,String mon5,String mon6,String mon7,String mon8,String mon9,String mon10,String mon11,String mon12) throws InterruptedException  {
		
		driver = BrowserFactory.init();
		
		ValidateMonthPage VMPage = PageFactory.initElements(driver, ValidateMonthPage.class);

		VMPage.insertCategory(mon1);
		VMPage.insertCategory(mon2);
		VMPage.insertCategory(mon3);
		VMPage.insertCategory(mon4);
		VMPage.insertCategory(mon5);
		VMPage.insertCategory(mon6);
		VMPage.insertCategory(mon7);
		VMPage.insertCategory(mon8);
		VMPage.insertCategory(mon9);
		VMPage.insertCategory(mon10);
		VMPage.insertCategory(mon11);
		VMPage.insertCategory(mon12);
		VMPage.validateMonthDropDown();
		
		BrowserFactory.teardown();
	}
		
}
