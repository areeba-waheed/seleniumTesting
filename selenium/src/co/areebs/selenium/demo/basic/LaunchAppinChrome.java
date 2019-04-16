package co.areebs.selenium.demo.basic;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class LaunchAppinChrome {

	
	public static WebDriver firefoxDriver = null;
	public static WebDriver chromeDriver = null;

	public static void main(String[] args) throws InterruptedException{
		
		
		/*System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\eclipse-workspace\\selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.navigate().to("http://eventsplanner.azurewebsites.net/");
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("Events Planner")) {
			System.out.println("Title Matches");
		}else {
			System.out.println(title);
		}
		Thread.sleep(2000);
		/*WebElement register = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > button.btn.btn-primary.btn-lg.mr-2"));
		
		Actions action = new Actions(driver);
		action.moveToElement(register);
		action.click();
		action.perform();
		Thread.sleep(2000);*/
		
		
		/*WebElement findUsername = driver.findElement(By.name("Username"));
		findUsername.sendKeys("areebs");
		Thread.sleep(1000);
		WebElement findPassword = driver.findElement(By.name("Password"));
		findPassword.sendKeys("poop123");
		Thread.sleep(1000);
		WebElement login = driver.findElement(By.cssSelector("body > app-root > div > app-nav > nav > div > form > button"));
		Actions action = new Actions(driver);
		action.moveToElement(login);
		action.click();
		action.perform();*/
		
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
		
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\eclipse-workspace\\selenium\\driver\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
			
		chromeDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		chromeDriver.navigate().to("http://eventsplanner.azurewebsites.net/");
		
		testTitle(chromeDriver);
		testLogin(chromeDriver);
		testRegister(chromeDriver);
		testUpdateProfileInfo(chromeDriver);
		testEvents(chromeDriver);
		
		
		/*WebElement register = driver.findElement(By.cssSelector("body > app-root > div > app-home > div > div > div > button.btn.btn-primary.btn-lg.mr-2"));
		
		Actions action = new Actions(driver);
		action.moveToElement(register);
		action.click();
		action.perform();
		Thread.sleep(2000);*/
		
		
		
		
	}

	private static void testTitle(WebDriver driver) throws InterruptedException {
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("Events Planner")) {
			System.out.println("Title Matches");
		}else {
			System.out.println(title);
		}
		Thread.sleep(2000);
		
	}

	private static void testEvents(WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}

	private static void testUpdateProfileInfo(WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}

	private static void testRegister(WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}

	private static void testLogin(WebDriver driver) throws InterruptedException {
		WebElement findUsername = driver.findElement(By.name("Username"));
		findUsername.sendKeys("areebs");
		Thread.sleep(1000);
		WebElement findPassword = driver.findElement(By.name("Password"));
		findPassword.sendKeys("poop123");
		Thread.sleep(1000);
		WebElement login = driver.findElement(By.cssSelector("body > app-root > div > app-nav > nav > div > form > button"));
		Actions action = new Actions(driver);
		action.moveToElement(login);
		action.click();
		action.perform();
		
	}

}
