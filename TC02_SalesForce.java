package SeleniumJava;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC02_SalesForce
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//To disable notification in the webPage
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		
		driver.findElementByXPath("//input[@id = 'username']").sendKeys("samdavid@testleaf.com");
		driver.findElementByXPath("//input[@id = 'password']").sendKeys("samchennai92");
		
		driver.findElementByXPath("//input[@id = 'Login']").click();
		Thread.sleep(5000);
				
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[text() = 'Create']")))).click();
		
		driver.findElementByXPath("//a[@title = 'User']").click();
		Thread.sleep(5000);
		
		driver.switchTo().frame(0);
		
		driver.findElementByXPath("//input[@id = 'name_lastName']").sendKeys("K");
		
		driver.findElementByXPath("//input[@id = 'Alias']").sendKeys("abc");
		driver.findElementByXPath("//input[@id = 'Alias']").clear();
		driver.findElementByXPath("//input[@id = 'Alias']").sendKeys("abc");
		
		driver.findElementByXPath("//input[@id = 'Email']").sendKeys("thilaga8@gmail.com");
		
		driver.findElementByXPath("//input[@id = 'Username']").sendKeys("Thilagavathy");
				
		driver.findElementByXPath("//input[@id = 'CommunityNickname']").sendKeys("Niviiiiaabb");
		driver.findElementByXPath("//input[@id = 'CommunityNickname']").clear();
		driver.findElementByXPath("//input[@id = 'CommunityNickname']").sendKeys("Niviiiiaabb");
		
		/*
		WebElement role = driver.findElementByXPath("//select[@id = 'role']");
		Select s = new Select(role);
		s.selectByVisibleText("CEO");
		*/
		
		WebElement uLicense = driver.findElementByXPath("//select[@id = 'user_license_id']");
		Select s1 = new Select(uLicense);
		s1.selectByIndex(0);
		
		WebElement profile = driver.findElementByXPath("//select[@id = 'Profile']");
		Select s2 = new Select(profile);
		s2.selectByIndex(0);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//New Window of Delegated Approver Part
		driver.findElementByXPath("//img[@class = 'lookupIcon' and @alt = 'Delegated Approver Lookup (New Window)']").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(windowHandles);
		System.out.println("Number of Windows : " + listHandles);
		String newWindow = listHandles.get(1);
		driver.switchTo().window(newWindow);
		Thread.sleep(5000);
		
		WebElement resultFrame = driver.findElementByXPath("//frame[@id = 'resultsFrame']");
		driver.switchTo().frame(resultFrame);
		
		driver.findElementByXPath("(//a[@class= ' dataCell '])[1]").click();
		
		// Switch to Old Window
		driver.switchTo().window(listHandles.get(0));
		
		driver.switchTo().frame(0);
		
		//New Window of Manager Part
		driver.findElementByXPath("//img[@class = 'lookupIcon' and @alt = 'Manager Lookup (New Window)']").click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> listHandles2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(listHandles2.get(1));
		
		WebElement resultFrame1 = driver.findElementByXPath("//frame[@id = 'resultsFrame']");
		driver.switchTo().frame(resultFrame1);
		
		driver.findElementByXPath("//a[text() = 'avu']").click();
		
		driver.switchTo().window(listHandles2.get(0));
		
		driver.switchTo().frame(0);		
			
		driver.findElementByXPath("//td [ @id = 'topButtonRow']/input[@class = 'btn' and @value = ' Save ']").click();
		Thread.sleep(3000);
		
		WebElement frameName = driver.findElementByXPath("//iframe[@title= 'User: K ~ Salesforce - Developer Edition']");
		
		driver.switchTo().frame(frameName);
		
		String text = driver.findElementByXPath("//table[@class = 'detailList']/tbody/tr[3]/td[2]/a").getText();
		
		System.out.println("User is created with email : " +text );
		
	}

}
