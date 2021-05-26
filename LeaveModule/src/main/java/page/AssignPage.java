package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignPage {
	@FindBy(id="menu_leave_assignLeave")
	WebElement assign;
	@FindBy(xpath="//input[@name='assignleave[txtEmployee][empName]']")
	WebElement empname;
	@FindBy(id="assignleave_txtComment")
	WebElement comment;
	@FindBy(id="assignBtn")
	WebElement assignbtn;
	 WebDriver driver;	
	
	public AssignPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void assignpage()
	{
		assign.click();
	}
	public void empname(String name)
	{
		empname.sendKeys(name);
		
	}
	public void btnasgn()
	{
		assign.click();
	}

}
