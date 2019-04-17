package co.areebs.selenium.demo.basic;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LaunchAppinChrome {

	
	public static WebDriver firefoxDriver = null;
	public static WebDriver chromeDriver = null;

	public static void main(String[] args) throws InterruptedException{
		
		//firefoxTest();
		chromeTest();
	
	}

	private static void chromeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\eclipse-workspace\\selenium\\driver\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
			
		chromeDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		chromeDriver.navigate().to("http://eventsplanner.azurewebsites.net/");
		
		testTitle(chromeDriver);
		testLogin(chromeDriver);
		//testRegister(chromeDriver);
		testUpdateProfileInfo(chromeDriver);
		testEvents(chromeDriver);
		
	}

	private static void firefoxTest() throws InterruptedException {
		System.out.println("Welcome to Maven World");
	    System.setProperty("webdriver.gecko.driver", "D:\\Program Files\\geckodriver.exe");
	    firefoxDriver = new FirefoxDriver();   
		
		firefoxDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		firefoxDriver.navigate().to("http://eventsplanner.azurewebsites.net/");
		
		testTitle(firefoxDriver);
		testLogin(firefoxDriver);
		testRegister(firefoxDriver);
		testUpdateProfileInfo(firefoxDriver);
		testEvents(firefoxDriver);
		
	}

	private static void testTitle(WebDriver driver) throws InterruptedException {
		String title = driver.getTitle();		
		String actualTitle = "Events Planner";		
		assertEquals(title, actualTitle);
		
		/*if(title.equalsIgnoreCase("Events Planner")) {
			System.out.println("Title Matches");
		}else {
			System.out.println(title);
		}
		Thread.sleep(2000);*/
		
		
		
	}

	private static void testEvents(WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}

	private static void testUpdateProfileInfo(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		
		WebElement dropdown = driver.findElement(By.cssSelector("body > app-root > div > app-nav > nav > div > div > a"));
		
		Actions action = new Actions(driver);
		action.moveToElement(dropdown);
		action.click();
		action.perform();
		Thread.sleep(500);
		WebElement edit = driver.findElement(By.cssSelector("body > app-root > div > app-nav > nav > div > div > div > a.dropdown-item.fa.fa-user"));
		action.moveToElement(edit);
		action.click();
		action.perform();
		
		WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
		Thread.sleep(500);
		lastName.clear();
		Thread.sleep(500);
		lastName.sendKeys("Dobby");
		Thread.sleep(1000);
		WebElement save = driver.findElement(By.cssSelector("body > app-root > div > app-member-edit > div > div:nth-child(2) > div.col-sm-4 > div > div.card-footer > div > button"));
		Actions actionReg = new Actions(driver);
		actionReg.moveToElement(save);
		actionReg.click();
		actionReg.perform();
		Thread.sleep(1000);
		
		String message = driver.getCurrentUrl();
		String actual = "https://eventsplanner.azurewebsites.net";
		//assertEquals(message, actual);
		//System.out.println(driver.getWindowHandle());
	}

	private static void testRegister(WebDriver driver) throws InterruptedException {

		WebElement register = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > button.btn.btn-primary.btn-lg.mr-2"));
		
		Actions action = new Actions(driver);
		action.moveToElement(register);
		action.click();
		action.perform();
		Thread.sleep(2000);
		
		WebElement findUsername = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(3) > input"));
		findUsername.sendKeys("areebs");
		Thread.sleep(1000);
		
		WebElement findName = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(4) > input"));
		findName.sendKeys("Areeba");
		Thread.sleep(1000);
		
		WebElement findLastName = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(5) > input"));
		findLastName.sendKeys("Waheed");
		Thread.sleep(1000);
		
		WebElement findEmail = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(6) > input"));
		findEmail.sendKeys("areebs97@gmail.com");
		Thread.sleep(1000);
		
		WebElement confirmEmail = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(7) > input"));
		confirmEmail.sendKeys("areebs97@gmail.com");
		Thread.sleep(1000);
		
		WebElement password = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(9) > input"));
		password.sendKeys("poop123");
		Thread.sleep(1000);
		
		WebElement confirmPassword = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div:nth-child(10) > input"));
		confirmPassword.sendKeys("poop123");
		Thread.sleep(1000);
		
		/*WebElement registerbttn = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div.form-group.text-center > button.btn.btn-success"));
		Actions actionReg = new Actions(driver);
		actionReg.moveToElement(registerbttn);
		actionReg.click();
		actionReg.perform();
		
		String message = driver.getCurrentUrl();
		String actual = "https://eventsplanner.azurewebsites.net/members";
		assertEquals(message, actual);
		*/
		
		
		
		WebElement cancel = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > div > app-register > form > div.form-group.text-center > button.btn.btn-danger"));
		Actions actionCancel = new Actions(driver);
		actionCancel.moveToElement(cancel);
		actionCancel.click();
		actionCancel.perform();
		Thread.sleep(1000);
		String message = driver.getCurrentUrl();
		String actual = "https://eventsplanner.azurewebsites.net";
		assertEquals(message, actual);
		//driver.quit();
		
	}

	private static void testLogin(WebDriver driver) throws InterruptedException {
		WebElement findUsername = driver.findElement(By.name("Username"));
		findUsername.sendKeys("aribers");
		Thread.sleep(1000);
		WebElement findPassword = driver.findElement(By.name("Password"));
		findPassword.sendKeys("poop123");
		Thread.sleep(1000);
		WebElement login = driver.findElement(By.cssSelector("body > app-root > div > app-nav > nav > div > form > button"));
		Actions action = new Actions(driver);
		action.moveToElement(login);
		action.click();
		action.perform();
		Thread.sleep(1000);
		String message = driver.getCurrentUrl();
		String actual = "https://eventsplanner.azurewebsites.net/events";
		assertEquals(message, actual);
		
		//driver.quit();
		
	}

}
