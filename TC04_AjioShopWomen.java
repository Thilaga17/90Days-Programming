package SeleniumJava;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC04_AjioShopWomen {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/shop/women");
		//Thread.sleep(10000);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		WebElement women = driver.findElementByXPath("//a[text() = 'WOMEN']");
		//WebElement categories = driver.findElementByXPath("(//a[text() = 'CATEGORIES'])[2]");
		/*
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement women1 = wait1.until(ExpectedConditions.visibilityOf(women));
		
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement categories1 = wait2.until(ExpectedConditions.visibilityOf(categories));
		*/
		
		Actions act = new Actions(driver);
		act.moveToElement(women).perform();
		//act.moveToElement(categories1).perform();
		
		WebElement kurtas = driver.findElementByXPath("(//span[text() = 'ETHNIC WEAR']/following::a[text() = 'Kurtas'])[1]");
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait3.until(ExpectedConditions.visibilityOf(kurtas)).click();		
		
		driver.findElementByXPath("//span[text() = 'brands']").click();
		
		driver.findElementByXPath("//label[@for = 'AJIO']").click();
		
		List<WebElement> ajioBrands = driver.findElementsByXPath("//div[@class = 'brand']");
		System.out.println(ajioBrands.size());
		
		List<String> listAjio = new ArrayList<String>();
		
		for (WebElement eachDress : ajioBrands)
		{
			String text = eachDress.getText();
			listAjio.add(text);
		}
		System.out.println(listAjio);
		System.out.println("Total no. of Kurtas : " + listAjio.size());
		
		driver.findElementByXPath("//select/option[text() = 'Discount']").click();
		
		driver.findElementByXPath("(//div[@class = 'preview']/div[@class = 'imgHolder']/img)[1]").click();
		Thread.sleep(3000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		System.out.println(window.size());
		String newWindow = window.get(1);
		driver.switchTo().window(newWindow);
		
		driver.findElementByXPath("//span[text() = 'ADD TO BAG']").click();
		
		String text = driver.findElementByXPath("//span[@class = 'msg-content']").getText();
		System.out.println("Error Message When clicking on ADD TO BAG : " + text);
		
		driver.findElementByXPath("(//div[@class = 'circle size-variant-item size-instock '])[2]").click();
		
		driver.findElementByXPath("//span[text() = 'ADD TO BAG']").click();
		
		
		
		
		
		
	}

}
