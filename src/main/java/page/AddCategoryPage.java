package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCategoryPage extends BasePage {

	
WebDriver driver;
	
	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS,using = "input[name='categorydata']") WebElement Add_Category_Element;
	@FindBy(how = How.CSS,using = "input[value='Add category']") WebElement Add_Category_Button_Element;
	@FindBy(how = How.CSS,using = "select[name='category']") WebElement Category_Select_Element;
	@FindBy(how = How.CSS,using = "select[name='colour']") WebElement select_color_Element;
	@FindBy(how = How.LINK_TEXT,using = "Add the category with this colour") WebElement add_Category_with_color_Element;
	@FindBy(how = How.CSS,using = "div.controls>:nth-last-child(3)") WebElement new_category_Element;
	@FindBy(how = How.LINK_TEXT,using = "Nevermind") WebElement Nevermind_Button_Element;
	
	
String enteredName;
	
	public String getEnteredName() {
		return enteredName;
	}

	public void selectColor(String color) throws InterruptedException {
		selectFromDropdown(select_color_Element,color);
		Thread.sleep(3000);
	}
	
	
	public void addCategoryName(String CategoryName) throws InterruptedException {
		enteredName=CategoryName+generateRandomNum(999);
		Add_Category_Element.sendKeys(enteredName);
		Thread.sleep(3000);
	}
	public void clickAddCategoryButton() {
		
		Add_Category_Button_Element.click();
		String enteredCategoryName=new_category_Element.getText();
		System.out.println("Added category is "+enteredCategoryName);
		Assert.assertEquals(enteredCategoryName, enteredName, "Entered name does not exist!!");
		
	}
	
	public void clickAddCategoryWithColorButton() throws InterruptedException {
		add_Category_with_color_Element.click();
		System.out.println("The category added with the color.");
		
		Thread.sleep(3000);
	}
	
	public void insertCategory(String Category) throws InterruptedException {
		selectFromDropdown(Category_Select_Element,enteredName);
		System.out.println("category is added under category list");
		Thread.sleep(3000);
	}
	
	public void clickAddCategory1Button() {
		new_category_Element.click();
	}
	
	public void clickNevermindButton() throws InterruptedException {
		Nevermind_Button_Element.click();
	
		Thread.sleep(3000);
	}
	
	

}
