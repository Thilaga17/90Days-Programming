package SeleniumJava;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC01_BestBuy
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bestbuy.com/");

		driver.findElementByXPath("(//h4)[2]").click();
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class = 'c-close-icon  c-modal-close-icon']"))).click();
		
		driver.findElementByXPath("//button[@class = 'btn-unstyled menuHeader  flyBtn' and text() = 'Products']").click();
		
		driver.findElementByXPath("//button[@class = 'menu-item-button-61 ']").click();
		
		driver.findElementByXPath("//div[text() = 'iPhone']/parent::button").click();
		
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//a[text() = 'iPhone SE']").click();
		//Thread.sleep(3000);
		
		driver.findElementByXPath("//span[@data-rtb-sku = '6389069,6389070,6389071']").click();
		Thread.sleep(5000);		
		
		driver.findElementByXPath("//a[text() = 'Continue']").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("(//div[@class = 'c-rich-dropdown variation-dropdown'])[2]/button").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[@aria-label = '128GB. Available']").click();
		
		//driver.findElementByXPath("//div[@class = 'activated-pricing__see-details-section']/ a[text() = 'See details']").click();
		driver.findElementByXPath("(//button[contains(text(),'Add to Cart')])[1]").click();
		
		driver.findElementByXPath("//button[@class = 'carriers-page__carrier-choice-button' and @data-track = 'activate-later']").click();
		
		String Price1 = driver.findElementByXPath("(//span[@class = 'body-copy-lg v-fw-medium'])[4]").getText();
		System.out.println("Price1: " + Price1);
		
		driver.findElementByXPath("//button[@class = 'btn btn-primary btn-lg carriers-page__continue']").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//span[text() = 'Cart']").click();
		
		String Price2 = driver.findElementByXPath("//div[@class = 'price-summary__total-value']").getText();
		System.out.println("Price2(Total Price): "+ Price2);
		
		if(Price1.equals(Price2))
		{
			System.out.println("Both Prices are same");
		}
		else
		{
			System.out.println("Prices are different");
		}
		
		driver.findElementByXPath("//button[text() = 'Checkout']").click();
		Thread.sleep(5000);
		
		driver.findElementByXPath("//button[text() = 'Sign In']").click();
		
		String ErrorMessage = driver.findElementByXPath("//span[@id = 'fld-e-text']").getText();
		System.out.println("Error Message is " + ErrorMessage);
		
		
	}

}
