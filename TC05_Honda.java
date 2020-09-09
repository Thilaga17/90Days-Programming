package SeleniumJava;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC05_Honda {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.honda2wheelersindia.com/");
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//button[@class = 'close']").click();
		
		driver.findElementByXPath("//a[@id = 'link_Scooter']").click();
		driver.findElementByXPath("//div[@id = 'scooter']/div[1]/div/div[1]/div//img").click();
		driver.findElementByXPath("//a[text() = 'Specifications']").click();
		Thread.sleep(3000);
		
		WebElement engine = driver.findElementByXPath("//a[text() = 'ENGINE']");
		Actions builder = new Actions(driver);
		builder.moveToElement(engine).perform();
		
		String text = driver.findElementByXPath("//div[@class = 'engine part-2 axx']/ul/li[3]/span[2]").getText().replaceAll("[^\\d.]", "");
		float val1 = Float.parseFloat(text);
		System.out.println("Displacement Value of engine(DIO) : " + val1);
		Thread.sleep(3000);
		
		driver.findElementByXPath("//a[@id = 'link_Scooter']").click();
		driver.findElementByXPath("//div[@id = 'scooter']/div[1]/div/div[3]/div//img").click();
		driver.findElementByXPath("//a[text() = 'Specifications']").click();
		Thread.sleep(3000);
		
		WebElement engine1 = driver.findElementByXPath("//a[text() = 'ENGINE']");
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(engine1).build().perform();
		
		String text2 = driver.findElementByXPath("//div[@class = 'engine part-4 axx']/ul/li[3]/span[2]").getText().replaceAll("[^\\d.]", "");
		float val2 = Float.parseFloat(text2);
		System.out.println("Displacement Value of engine(Activa 125): " + val2);
				
		if(val1>val2)
		{
			System.out.println("DIO has better Displacement Value");
		}
		else
		{
			System.out.println("ACTIVA 125 has better Displacement Value");
		}
		
		
		driver.findElementByXPath("//ul[@class = 'nav navbar-nav']//a[text() = 'FAQ']").click();
		driver.findElementByXPath("//a[text() = 'Activa 125 BS-VI']").click();
		driver.findElementByXPath("//ul[@class = 'nav nav-pills tabb-design  ']/li[6]/a").click();
		
		WebElement scooter = driver.findElementByXPath("//select[@id = 'ModelID6']/option[2]");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(scooter));
		
		driver.findElementByXPath("//button[@id = 'submit6']").click();
		
		driver.findElementByLinkText("Click here to know the price of Activa 125 BS-VI.").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listHandles.get(1));
		
		WebElement state = driver.findElementByXPath("//select[@id = 'StateID']");
		Select s = new Select(state);
		s.selectByVisibleText("Tamil Nadu");
		
		WebElement city = driver.findElementByXPath("//select[@id = 'CityID']");
		Select s1 = new Select(city);
		s1.selectByIndex(6);
		
		driver.findElementByXPath("//button[text() = 'Search']").click();
		Thread.sleep(3000);
		
		List<WebElement> table = driver.findElementsByXPath("//table[@id = 'gvshow']/tbody/tr");
		int size = table.size();
		System.out.println(size);
		
		Set<String> values = new LinkedHashSet<String>();
			
		for(int i =1; i<= size;i++)
		{
			//String details = driver.findElementByXPath("//table[@id = 'gvshow']/tbody/tr["+i+"]/td[2]").getText();
			//System.out.println(details);
			for(int j=1;j<=3;j++)
			{
			List<WebElement> rows = driver.findElementsByXPath("//table[@id = 'gvshow']/tbody/tr["+i+"]/td["+j+"]");
			
			for (WebElement eachVal : rows) 
			{
				String text1 = eachVal.getText();
				System.out.println(text1);
				values.add(text1);
			}
			}
		}
		System.out.println(values);
		driver.quit();
		
		
		
				
		
		
		
		
	}

}
