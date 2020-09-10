package SeleniumJava;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC07_Nykaa
{
	@Test
	public void runNykaa() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.nykaa.com/");
		
		WebElement brands = driver.findElementByXPath("//a[text() = 'brands']");
		WebElement popular = driver.findElementByXPath("//a[text() = 'Popular']");
		Actions action = new Actions(driver);
		action.moveToElement(brands).perform();
		action.moveToElement(popular).perform();
		driver.findElementByXPath("//div[@id = 'brandCont_Popular']/ul/li[5]/a").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listhandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listhandles.get(1));
		System.out.println("Title of the new window is : " + driver.getTitle());
		
		driver.findElementByXPath("//i[@class='fa fa-angle-down']").click();
		driver.findElementByXPath("//div[@class = 'sort-container show-sort']/div[4]//span").click();
				
		driver.findElementByXPath("//div[@class ='filter-sidebar clearfix boundary-top']/div/div[1]/div[1]//div[@class = 'pull-right filter-options-toggle']/i").click();
		driver.findElementByXPath("//div[@class = 'slide-filter ']/div[1]//div[9]//label/span").click();
		WebElement filterApplied = driver.findElementByXPath("//ul[@class = 'pull-left applied-filter-lists']/li");
		System.out.println(filterApplied.getText());
		
		driver.findElementByXPath("//span[text() = 'LOreal Paris Colour Protect Shampoo']").click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> listhandles2 = new ArrayList<String>(windowHandles2);
		System.out.println(listhandles2.size());
		driver.switchTo().window(listhandles2.get(2));
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		
		WebElement size = driver.findElementByXPath("//label[@class = '   text-center']/span[text() = '175ml']");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(size)).click();
		size.click();
		
		String text = driver.findElementByXPath("//div[@class = 'clearfix product-des__details']/div[1]/div[1]/span[2]/span").getText();
		System.out.println(text);
		
		driver.findElementByXPath("(//button[@class = 'combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]").click();
		
		driver.findElementByXPath("//div[@class = 'AddBagIcon']").click();
		String text2 = driver.findElementByXPath("//div[@class = 'value medium-strong']").getText();
		System.out.println("GrandTotalAmount : " + text2);
		Thread.sleep(2000);
		
		WebElement proceed = driver.findElementByXPath("//div[@class = 'second-col']/button");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", proceed);
		/*
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(proceed)).click();
		*/
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> listhandles3 = new ArrayList<String>(windowHandles3);
		System.out.println(listhandles3.size());
		driver.switchTo().window(listhandles3.get(2));
		System.out.println(driver.getTitle());
		
		driver.findElementByXPath("//button[@class = 'btn full big']").click();
		
		String text3 = driver.findElementByXPath("//div[@class = 'layout horizontal center message flex-1']").getText();
		System.out.println(text3);
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
