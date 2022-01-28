package page;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ValidateMonthPage extends BasePage{

WebDriver driver;
	
	public ValidateMonthPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS,using = "select[name='due_month']") WebElement Month_Element;
	
	public void validateMonthDropDown() {
		Select select = new Select(Month_Element);
		
		List ActualValue= new ArrayList();
		
		for(WebElement element : select.getOptions())
			ActualValue.add(element.getText());
		
		List ExpectedValue= new ArrayList();
		
		ExpectedValue.add("None");
		ExpectedValue.add("Jan");
		ExpectedValue.add("Feb");
		ExpectedValue.add("Mar");
		ExpectedValue.add("Apr");
		ExpectedValue.add("May");
		ExpectedValue.add("Jun");
		ExpectedValue.add("Jul");
		ExpectedValue.add("Aug");
		ExpectedValue.add("Sep");
		ExpectedValue.add("Oct");
		ExpectedValue.add("Nov");
		ExpectedValue.add("Dec");
		
		for(int i=0;i<ActualValue.size();i++)
		{
			System.out.println("ActualValue:" + ActualValue.get(i)+" & ExpectedValue:" + ExpectedValue.get(i));
			Assert.assertTrue(ActualValue.get(i).equals(ExpectedValue.get(i)));
			
		}
		
	}
	
	public void insertCategory(String month) throws InterruptedException {
		selectFromDropdown(Month_Element,month);
		Thread.sleep(3000);
	}
	

	
}
