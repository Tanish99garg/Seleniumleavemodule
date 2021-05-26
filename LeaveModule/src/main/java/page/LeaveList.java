package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaveList {
	WebDriver driver;
	@FindBy(id="menu_leave_viewLeaveList")
	WebElement lvelist;
	@FindBy(id="leaveList_chkSearchFilter_checkboxgroup_allcheck")
	WebElement checkbox;
	
	
	public void leavelistpage()
	{
		lvelist.click();
	}
	public void checkbox()
	{
		checkbox.click();
	}
	public LeaveList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
