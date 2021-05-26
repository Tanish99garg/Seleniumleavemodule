package page;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeeforentitlement {
	WebDriver driver;
	@FindBy(id="menu_leave_Entitlements")
	WebElement Entitlement;
	@FindBy(id="dialogUpdateEntitlementConfirmBtn")
	WebElement pop_up;
	@FindBy(id="menu_leave_addLeaveEntitlement")
	WebElement AddEntitlement;
	@FindBy(xpath = "//input[@name='entitlements[employee][empName]']")
	WebElement employee;
	@FindBy(id="entitlements_entitlement")
	WebElement NoEntitlement;
	@FindBy(id="btnSave")
	public WebElement btnsave;
	public AddEmployeeforentitlement(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void click_on_entitle()
	{
		Entitlement.click();
	}
	public void click_on_add_entitle()
	{
		AddEntitlement.click();
	}

	public void number(String number)
	{
		NoEntitlement.sendKeys(number);
	}
	public void save() throws InterruptedException
	{
//		btnsave.click();
//		Thread.sleep(5000);
		pop_up.click();
	}
	
}
