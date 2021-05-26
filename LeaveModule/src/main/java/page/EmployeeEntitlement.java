package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeEntitlement {
	WebDriver driver;
@FindBy(id="menu_leave_viewLeaveEntitlements")
WebElement Emplt;
@FindBy(xpath = "//input[@name='entitlements[employee][empName]']")
WebElement empname;
@FindBy(id="entitlements_leave_type")
WebElement leavetype;
@FindBy(id="period")
WebElement leaveperiod;
@FindBy(id="searchBtn")
public WebElement btn;
public EmployeeEntitlement(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
}
public void viweempentitlement()
{
	Emplt.click();
}
public void empname(String username)
{
	empname.sendKeys(username);
}
public void btnclk()
{
	btn.click();
}

}
