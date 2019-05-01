package co.areebs.selenium.demo.basic;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {
	
	public static WebDriver driver = null;
	
	@Before
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\eclipse-workspace\\selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
			
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to("http://eventsplanner.azurewebsites.net/");
		driver.manage().window().maximize();
	}
	
	//@Test
	public void testTitle() {
		String title = driver.getTitle();		
		String actualTitle = "Events Planner";		
		assertEquals(title, actualTitle);
		driver.quit();
	}
	
	//@Test
	public void testALogin() throws InterruptedException {
		login();
		
		Thread.sleep(5000);
		String message = driver.getCurrentUrl();
		String actual = "https://eventsplanner.azurewebsites.net/events";
		assertEquals(actual, message);
		Thread.sleep(2000);
		logout();
		Thread.sleep(2000);
		driver.quit();
	}
	
	private void logout() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.cssSelector("body > app-root > div > app-nav > nav > div > div > a"));
		
		Actions action = new Actions(driver);
		action.moveToElement(dropdown);
		action.click();
		action.perform();
		Thread.sleep(2000);
		WebElement logout = driver.findElement(By.cssSelector("#navigationBar > div > div > div > a.dropdown-item.fa.fa-sign-out"));
		action.moveToElement(logout);
		action.click();
		action.perform();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
	}

	public void login() throws InterruptedException {
		Thread.sleep(1500);
		WebElement findUsername = driver.findElement(By.name("Username"));
		findUsername.sendKeys("aribers");
		Thread.sleep(2000);
		WebElement findPassword = driver.findElement(By.name("Password"));
		findPassword.sendKeys("poop123");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.cssSelector("body > app-root > div > app-nav > nav > div > form > button"));
		Actions action = new Actions(driver);
		action.moveToElement(login);
		action.click();
		action.perform();
		
	}
	
	@Test
	public void testBRegister() throws InterruptedException {
		Thread.sleep(1500);
		WebElement register = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > button.btn.btn-primary.btn-lg.mr-2"));
		
		Actions action = new Actions(driver);
		action.moveToElement(register);
		action.click();
		action.perform();
		Thread.sleep(2000);
		
		WebElement findUsername = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(3) > input"));
		findUsername.sendKeys("areebs");
		Thread.sleep(2000);
		
		WebElement findName = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(4) > input"));
		findName.sendKeys("Areeba");
		Thread.sleep(2000);
		
		WebElement findLastName = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(5) > input"));
		findLastName.sendKeys("Waheed");
		Thread.sleep(2000);
		
		WebElement findEmail = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(6) > input"));
		findEmail.sendKeys("areebs97@gmail.com");
		Thread.sleep(2000);
		
		WebElement confirmEmail = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(7) > input"));
		confirmEmail.sendKeys("areebs97@gmail.com");
		Thread.sleep(2000);
		
		WebElement password = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(9) > input"));
		password.sendKeys("poop123");
		Thread.sleep(2000);
		
		WebElement confirmPassword = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(10) > input"));
		confirmPassword.sendKeys("poop123");
		Thread.sleep(3000);
		
		/*WebElement registerbttn = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div.form-group.text-center > button.btn.btn-success"));
		Actions actionReg = new Actions(driver);
		actionReg.moveToElement(registerbttn);
		actionReg.click();
		actionReg.perform();
		
		String message = driver.getCurrentUrl();
		String actual = "https://eventsplanner.azurewebsites.net/members";
		assertEquals(message, actual);
		*/
		
		
		
		WebElement cancel = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div.form-group.text-center > button.btn.btn-success"));//("body > app-root > div > app-home > div > div > div > div > app-register > form > div.form-group.text-center > button.btn.btn-danger"));
		Actions actionCancel = new Actions(driver);
		actionCancel.moveToElement(cancel);
		actionCancel.click();
		actionCancel.perform();
		Thread.sleep(2000);
		/*findUsername.clear();
		findUsername.sendKeys("comp");
		Thread.sleep(2000);
		actionCancel.moveToElement(cancel);
		actionCancel.click();
		actionCancel.perform();
		Thread.sleep(2000);
		findEmail.clear();
		findEmail.sendKeys("areebawaheed@gmail.com");
		Thread.sleep(2000);
		confirmEmail.clear();
		confirmEmail.sendKeys("areebawaheed@gmail.com");
		Thread.sleep(2000);
		actionCancel.moveToElement(cancel);
		actionCancel.click();
		actionCancel.perform();
		Thread.sleep(2000);*/
		String message = driver.getCurrentUrl();
		String actual = "https://eventsplanner.azurewebsites.net/";
		assertEquals(actual, message);
		driver.quit();
	}

	@Test
	public void testCEditingProfile() throws InterruptedException {
		login();
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.cssSelector("body > app-root > div > app-nav > nav > div > div > a"));
		
		Actions action = new Actions(driver);
		action.moveToElement(dropdown);
		action.click();
		action.perform();
		Thread.sleep(2000);
		WebElement edit = driver.findElement(By.cssSelector("body > app-root > div > app-nav > nav > div > div > div > a.dropdown-item.fa.fa-user"));
		action.moveToElement(edit);
		action.click();
		action.perform();
		
		WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
		Thread.sleep(2000);
		lastName.clear();
		Thread.sleep(2000);
		lastName.sendKeys("Dobby");
		Thread.sleep(2000);
		WebElement save = driver.findElement(By.cssSelector("body > app-root > div > app-member-edit > div > div:nth-child(2) > div.col-sm-4 > div > div.card-footer > div > button"));
		Actions actionReg = new Actions(driver);
		actionReg.moveToElement(save);
		actionReg.click();
		actionReg.perform();
		Thread.sleep(2000);
		
		String message = driver.getCurrentUrl();
		String actual = "https://eventsplanner.azurewebsites.net/member/edit";
		assertEquals(message, actual);
		//System.out.println(driver.getWindowHandle());
		
		WebElement elemts = driver.findElement(By.cssSelector(".navbar-nav > li:nth-child(2) > a:nth-child(1)"));
		
		Actions action3 = new Actions(driver);
		action3.moveToElement(elemts);
		action3.click();
		action3.perform();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.quit();
	}
	
	//@Test
	public void testAddEvents() throws InterruptedException {
		login();
		addEvent();
	}
	
	private void addEvent() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		WebElement add = driver.findElement(By.cssSelector("#addButton"));
		Thread.sleep(3000);
		Actions action2 = new Actions(driver);
		action2.moveToElement(add);
		action2.click();
		action2.perform();
		Thread.sleep(2000);
		
		//make an event
		WebElement name = driver.findElement(By.cssSelector("div.form-group:nth-child(3) > input:nth-child(1)"));
		name.sendKeys("Graduation");
		Thread.sleep(2000);
		
		WebElement startDate = driver.findElement(By.cssSelector("div.form-group:nth-child(4) > input:nth-child(1)"));
		Actions action3 = new Actions(driver);
		action3.moveToElement(startDate);
		action3.click();
		action3.perform();
		
		WebElement date = driver.findElement(By.cssSelector("body > bs-datepicker-container > div > div > div > div > bs-days-calendar-view > bs-calendar-layout > div.bs-datepicker-body > table > tbody > tr:nth-child(3) > td:nth-child(7)"));
		
		action3.moveToElement(date);
		action3.click();
		action3.perform();
		Thread.sleep(2000);
		WebElement endDate = driver.findElement(By.cssSelector("#custom-modal-1 > div.jw-modal > div > app-value-add > form > div:nth-child(5) > input"));
	
		action3.moveToElement(endDate);
		action3.click();
		action3.perform();
		
		WebElement edate = driver.findElement(By.cssSelector("body > bs-datepicker-container > div > div > div > div > bs-days-calendar-view > bs-calendar-layout > div.bs-datepicker-body > table > tbody > tr:nth-child(3) > td:nth-child(7)"));
		
		action3.moveToElement(edate);
		action3.click();
		action3.perform();
		
		
		
		Thread.sleep(2000);
		
		WebElement location = driver.findElement(By.cssSelector("div.form-group:nth-child(6) > input:nth-child(1)"));
		location.sendKeys("California State University Northridge");
		Thread.sleep(2000);
		
		WebElement description = driver.findElement(By.cssSelector("div.form-group:nth-child(7) > input:nth-child(1)"));
		description.sendKeys("Graduation Ceremony of CECS department");
		Thread.sleep(2000);
		
		WebElement cancel = driver.findElement(By.cssSelector("#custom-modal-1 > div.jw-modal > div > app-value-add > form > div.form-group.text-center > button.btn.btn-success"));//("#custom-modal-1 > div.jw-modal > div > app-value-add > form > div.form-group.text-center > button.btn.btn-info"));
		
		Actions action4 = new Actions(driver);
		action4.moveToElement(cancel);
		action4.click();
		action4.perform();
		Thread.sleep(2000);
		
		
	}

	@Test 
	public void testDeleteEvents() throws InterruptedException {
		login();
		addEvent();
		WebElement event = driver.findElement(By.cssSelector("#calendar > div:nth-child(4) > mwl-calendar-month-view > div > div > div:nth-child(3) > div > mwl-calendar-month-cell:nth-child(6) > div.cal-cell-top.ng-star-inserted > span.cal-day-number"));
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(event);
		action.click();
		action.click();
		action.perform();
		Thread.sleep(2000);
		
		WebElement edit = driver.findElement(By.cssSelector(".fa-fw"));
		
		Actions action2 = new Actions(driver);
		action2.moveToElement(edit);
		action2.click();
		action2.perform();
		Thread.sleep(2000);
		WebElement delete = driver.findElement(By.cssSelector("button.btn:nth-child(2)"));
		Actions actionCancel = new Actions(driver);
		actionCancel.moveToElement(delete);
		actionCancel.click();
		actionCancel.perform();
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void testSearchEvents() throws InterruptedException {
		login();
		Thread.sleep(2000);
		WebElement find = driver.findElement(By.cssSelector("#search"));
		Thread.sleep(2000);
		find.sendKeys("Grad Fest");
		Thread.sleep(2000);
		WebElement gradfest = driver.findElement(By.cssSelector("mat-option.mat-option:nth-child(1) > span:nth-child(1)"));
		Actions action = new Actions(driver);
		action.moveToElement(gradfest);
		Thread.sleep(2000);
		action.click();
		action.perform();
		Thread.sleep(5000);
		String message = driver.getCurrentUrl();
		String actual = "https://eventsplanner.azurewebsites.net/events/1";
		assertEquals(actual, message);
		driver.quit();
		
	}
}
