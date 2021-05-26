package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	@FindBy(id="txtUsername")
	WebElement txtusername;
	@FindBy(id="txtPassword")
	WebElement password;
	@FindBy(id="btnLogin")
	WebElement btn;
	@FindBy(xpath = "//*[@id=\"menu_leave_viewLeaveModule\"]/b")
	WebElement leave;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void username(String username)
	{
		txtusername.sendKeys(username);
		
	}
	public void password(String password)
	{
		this.password.sendKeys(password);
		
	}
	public void btnclk()
	{
		btn.click();
	}
	public void leavemodule()
	{
		leave.click();
		
	}
	
	

}
