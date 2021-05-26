package StepDefination;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import Base.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.AddEmployeeforentitlement;
import page.AssignPage;
import page.EmployeeEntitlement;
import page.LeaveList;
import page.Loginpage;
import page.MyLeave;
import page.Reports;

public class leave2 extends TestBase {

	Loginpage login;
	AddEmployeeforentitlement Assignentitle;
	EmployeeEntitlement chckemp;
	AssignPage asgnpage;
	LeaveList list;
	Reports repo;
	MyLeave myl;

	public leave2() {
		super();
	}

	@Given("^Users on the login page$")
	public void users_on_the_login_page() throws Throwable {
		Browser_Initialization();
	}

	@When("^pages of the Title is OrangeHRM$")
	public void pages_of_the_Title_is_OrangeHRM() throws Throwable {
		String actualtitle = driver.getTitle();
		String title = "OrangeHRM";
		assertEquals(actualtitle, title);
		System.out.print("title matched");

	}

	@Then("^enter userids  password$")
	public void enter_userids_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		login = new Loginpage(driver);
		login.username("admin");
		login.password("admin123");
	}

	@Then("^Clicks on the Login button$")
	public void clicks_on_the_Login_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		login.btnclk();
	}

	@Then("^select leaves Module$")
	public void select_leaves_Module() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		login.leavemodule();
	}

	@Given("^Admin is on Adds entilements page$")
	public void admin_is_on_Adds_entilements_page() throws Throwable {
		Thread.sleep(3000);
		Assignentitle = new AddEmployeeforentitlement(driver);

		Assignentitle.click_on_entitle();
		Assignentitle.click_on_add_entitle();
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^enter \"([^\"]*)\" name$")
	public void enter_name(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// Write code here that turns the phrase above into concrete actions

		WebElement name = driver.findElement(By.xpath("//input[@name='entitlements[employee][empName]']"));
		Thread.sleep(5000);
		name.sendKeys(arg1);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();

	}

	@Then("^Selects leaves type$")
	public void selects_leaves_type() throws Throwable {
		Thread.sleep(2000);
		Select sel = new Select(driver.findElement(By.id("entitlements_leave_type")));
		sel.selectByValue("8");

	}

	@Then("^Add number of entitlement$")
	public void Select_Leave_periods() throws InterruptedException {
		Thread.sleep(2000);
		Assignentitle.number("10");
	}

	@Then("^Clicks on the Save button$")
	public void clicks_on_the_Save_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebDriverWait w = new WebDriverWait(driver, 100);
		w.until(ExpectedConditions.elementToBeClickable(Assignentitle.btnsave));
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(3000);
		Assignentitle.save();
		Thread.sleep(5000);

	}

	@Given("^Admin is on Employees entitlement page$")
	public void admin_is_on_Employees_entitlement_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assignentitle = new AddEmployeeforentitlement(driver);
		Assignentitle.click_on_entitle();
		chckemp = new EmployeeEntitlement(driver);
		chckemp.viweempentitlement();

	}

	@Then("^Enters \"([^\"]*)\" name$")
	public void enters_name(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(4000);
		chckemp.empname(arg1);
	}

	@Then("^Selects Leave type$")
	public void selects_Leave_period() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Select sel = new Select(driver.findElement(By.id("entitlements_leave_type")));
		sel.selectByValue("8");
		Thread.sleep(3000);

	}

	@Then("^Click on the Searchs button$")
	public void click_on_the_Searchs_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		chckemp.btnclk();
		Thread.sleep(5000);
	}

	@Given("^admin is on assign leaves page$")
	public void admin_is_on_assign_leaves_page() throws Throwable {
		Thread.sleep(10000);
		asgnpage = new AssignPage(driver);
		asgnpage.assignpage();
	}

	@Then("^enters valid name of the employee$")
	public void enters_invalid_name_of_the_employee() throws Throwable, IOException {
		// Write code here that turns the phrase above into concrete actions
		File src = new File(
				"C:\\Users\\tangarg\\eclipse-workspace\\LeaveModule\\src\\test\\resources\\Excel\\leave.xlsx");

		// Load Excel sheet in the form of bites
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = wb.getSheetAt(0);
		String Data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		asgnpage.empname(Data0);

	}

	@Then("^enter Leave types$")
	public void enter_Leave_types() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
		Select sel = new Select(driver.findElement(By.xpath("//select[@name='assignleave[txtLeaveType]']")));
		sel.selectByValue("8");
	}

	@Then("^selects Date \\(from\\)$")
	public void selects_Date_from() throws Throwable {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("assignleave_txtFromDate")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")).click();
		Select select1 = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")));
		select1.selectByVisibleText("Oct");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")).click();
		Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")));
		select2.selectByVisibleText("2021");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[2]/a")).click();// 22oct
	}

	@Then("^select Dates \\(to\\)$")
	public void select_Dates_to() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("assignleave_txtToDate")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")).click();
		Select select1 = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")));
		select1.selectByVisibleText("Oct");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")).click();
		Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")));
		select2.selectByVisibleText("2021");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();// 24oct

	}

	@Then("^write a comments$")
	public void write_a_comments() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		File src = new File(
				"C:\\Users\\tangarg\\eclipse-workspace\\LeaveModule\\src\\test\\resources\\Excel\\leave.xlsx");

		// Load Excel sheet in the form of bites
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet2 = wb.getSheetAt(0);
		String Data0 = sheet2.getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.id("assignleave_txtComment")).sendKeys(Data0);
//		 driver.findElement(By.id("assignBtn")).click();
//		 driver.findElement(By.xpath("//input[@value='Assign']")).click();

	}

	@Then("^clicks on the assign button$")
	public void clicks_on_the_assign_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"assignBtn\"]")).click();
		Thread.sleep(5000);

	}

	@Given("^User on a Leave page$")
	public void user_on_a_Leave_page() throws Throwable {
		Thread.sleep(3000);
		list = new LeaveList(driver);
		list.leavelistpage();

	}

	@Then("^Selects Date \\(form\\)$")
	public void selects_Date_form() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("calFromDate")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[2]/a")).click();
	}

	@Then("^Selects Date \\(to\\)$")
	public void selects_Date_to() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("calToDate")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[7]/a")).click();
	}

	@Then("^Select the check box$")
	public void select_the_check_box() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		list.checkbox();
	}

	@Then("^Enter employee name$")
	public void enter_employee_name() throws Throwable {
		File src = new File(
				"C:\\Users\\tangarg\\eclipse-workspace\\LeaveModule\\src\\test\\resources\\Excel\\leave.xlsx");

		// Load Excel sheet in the form of bites
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = wb.getSheetAt(0);
		String Data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		driver.findElement(By.name("leaveList[txtEmployee][empName]")).sendKeys(Data0);
	}

	@Then("^Select sub unit$")
	public void select_sub_unit() throws Throwable {
		Select sel = new Select(driver.findElement(By.id("leaveList_cmbSubunit")));
		sel.selectByValue("0");
	}

	@Then("^click on the Search$")
	public void click_on_the_Search() throws Throwable {
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(4000);
	}

	@Given("^Users on a Leave page$")
	public void users_on_a_Leave_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(5000);
		list = new LeaveList(driver);
		list.leavelistpage();
		Thread.sleep(3000);

	}

	@Then("^Selects Dates \\(form\\)$")
	public void selects_Dates_form() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("calFromDate")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")).click();
		Select select1 = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")));
		select1.selectByVisibleText("Oct");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")).click();
		Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")));
		select2.selectByVisibleText("2023");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[2]/a")).click();// 22oct
	}

	@Then("^Selects Dates \\(to\\)$")
	public void selects_Dates_to() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("calToDate")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")).click();
		Select select1 = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")));
		select1.selectByVisibleText("Oct");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")).click();
		Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")));
		select2.selectByVisibleText("2024");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[2]/a")).click();// 22oct
	}

	@Then("^Selects the check box$")
	public void selects_the_check_box() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		list.checkbox();
	}

	@Then("^Enters valid employee name$")
	public void enters_employee_name() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		File src = new File(
				"C:\\Users\\tangarg\\eclipse-workspace\\LeaveModule\\src\\test\\resources\\Excel\\leave.xlsx");

		// Load Excel sheet in the form of bites
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet1 = wb.getSheetAt(0);
		String Data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		driver.findElement(By.name("leaveList[txtEmployee][empName]")).sendKeys(Data0);

	}

	@Then("^Select sub units$")
	public void select_sub_units() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Select sel = new Select(driver.findElement(By.id("leaveList_cmbSubunit")));
		sel.selectByValue("0");
	}

	@Then("^click on the Searchs$")
	public void click_on_the_Searchs() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(10000);
	}

	@Given("^User on leave Entitlement and usage$")
	public void user_on_leave_Entitlement_and_usage() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		repo = new Reports(driver);
		repo.reportbtn();
		repo.usageofleave();
		Thread.sleep(3000);
	}

	@Then("^Selects Generate for$")
	public void selects_Generate_for() throws Throwable {
		Select sel = new Select(driver.findElement(By.id("leave_balance_report_type")));
		sel.selectByValue("2");

	}

	@Then("^Enter  employee's' name$")
	public void enter_employee_s_name() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		repo.empname("Aaliyah Haq");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

	}

	@Then("^Select Date$")
	public void select_Date() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Select sel = new Select(driver.findElement(By.id("period")));
		sel.selectByValue("2021-01-01$$2021-12-31");
	}

	@Then("^click on the Search but$")
	public void click_on_the_Search_but() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		driver.findElement(By.id("viewBtn")).click();
		Thread.sleep(3000);
	}

	@Given("^user on the myb leave page$")
	public void user_on_the_myb_leave_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		myl = new MyLeave(driver);
		myl.myleavepage();

	}

	@Then("^Select date from colum$")
	public void select_date_from_colum() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("calFromDate")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")).click();
		Select select1 = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")));
		select1.selectByVisibleText("Jan");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")).click();
		Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")));
		select2.selectByVisibleText("2021");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();// 24oct

	}

	@Then("^Select date to colum$")
	public void select_date_to_colum() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("calToDate")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")).click();
		Select select1 = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")));
		select1.selectByVisibleText("Dec");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")).click();
		Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")));
		select2.selectByVisibleText("2021");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();// 24oct
	}

	@Then("^Select status$")
	public void select_status() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
//	    myl.checkbox();
		Thread.sleep(1000);
	}

	@Then("^Search the leave$")
	public void search_the_leave() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		myl.button();
	}

}
