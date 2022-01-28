package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DuplicateCategoryCheckPage extends BasePage {

	
WebDriver driver;
	
	public DuplicateCategoryCheckPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS,using = "input[name='categorydata']") WebElement Add_Category_Element;
	@FindBy(how = How.CSS,using = "input[value='Add category']") WebElement Add_Category_Button_Element;
	@FindBy(how = How.LINK_TEXT,using = "Nevermind") WebElement Nevermind_Button_Element;
	@FindBy(how = How.LINK_TEXT,using = "Yes") WebElement Yes_Button_Element;
	@FindBy(how = How.CSS,using = "div.controls>:nth-last-child(3)") WebElement new_category_Element;
	
	
String enteredName;
	
	public String getEnteredName() {
		return enteredName;
	}

	
	public void addCategoryName(String CategoryName) throws InterruptedException {
		enteredName=CategoryName+generateRandomNum(999);
		Add_Category_Element.sendKeys(enteredName);
		Thread.sleep(3000);
	}
	public void clickAddCategoryButton() throws InterruptedException {
		Add_Category_Button_Element.click();
		Thread.sleep(3000);
	}
	
	public void addCategoryNameAgain(String CategoryName) throws InterruptedException {
		String enteredCategoryName=new_category_Element.getText();
		System.out.println(" First Added category is "+enteredCategoryName);
		Assert.assertEquals(enteredCategoryName, enteredName, "Entered name does not exist!!");
		Add_Category_Element.sendKeys(enteredName);
		Thread.sleep(3000);
	}
	
	
	public void clickNevermindButton() throws InterruptedException {
		Nevermind_Button_Element.click();
		String enteredCategoryName=new_category_Element.getText();
		System.out.println("Second Added category is "+enteredCategoryName);
		
		System.out.println("The category you want to add already exists: <duplicated category name>.");
		
		Thread.sleep(3000);
	}
	
	

}
