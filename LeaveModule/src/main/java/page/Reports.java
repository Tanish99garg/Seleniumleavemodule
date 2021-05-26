package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reports {
	
@FindBy(id="menu_leave_Reports")
WebElement report;
	
@FindBy(id="menu_leave_viewLeaveBalanceReport")
WebElement viewreports;
@FindBy(id="leave_balance_report_type")
WebElement generate;
@FindBy(name = "leave_balance[employee][empName]")
WebElement emp;
WebDriver driver;
public Reports(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	public void reportbtn()
	{
		report.click();
	}
	public void usageofleave()
	{
		viewreports.click();
	}
	public void geneatefor()
	{
		generate.click();
	}
	public void empname(String val)
	{
		emp.sendKeys(val);
	}

}
