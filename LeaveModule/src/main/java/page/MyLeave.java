package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyLeave {
	@FindBy(id="menu_leave_viewMyLeaveList")
	WebElement mylve;
	@FindBy(xpath = "//*[@id=\"leaveList_chkSearchFilter_checkboxgroup_allcheck\"]")
	WebElement checkbox;
	@FindBy(id="btnSearch")
	WebElement btn;
	WebDriver driver;
	public MyLeave(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void myleavepage()
	{
		mylve.click();
	}
	public void checkbox()
	{
		checkbox.click();
	}
	public void button()
	{
		btn.click();
	}

}
