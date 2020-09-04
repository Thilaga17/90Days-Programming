package SeleniumJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC03_AmazonIn
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		
		driver.findElementByXPath("//input[@id = 'twotabsearchtextbox']").sendKeys("outslayer");
		Thread.sleep(2000);
		
		driver.findElementByXPath("//div[@id = 'issDiv0']/span[text() = ' punching bag']").click();
		Thread.sleep(2000);
		
		//Getting How many items(prices) in the page
		List<WebElement> Prices = driver.findElementsByXPath("//span[@class = 'a-price-whole']");
		int size = Prices.size();
		System.out.println(size);
		
		//Created new list to store all the prices
		List<Integer> list = new ArrayList<Integer>();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Fetching Price of all items one by one
		for (WebElement eachPrice : Prices)
		{
			//list.add(Integer.parseInt(e.getText()));
			String text = eachPrice.getText();	
			String text1 = text.replaceAll("[^0-9]", "");
			System.out.println(text1);
			list.add(Integer.parseInt(text1));
		}
		System.out.println("After adding all the prices in the list");
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println("After Sorting the Prices");
		System.out.println(list);
		
		Integer maxprice = Collections.max(list);
		
		System.out.println("The Maximum Price is " + maxprice);
		String maxprice1 = String.format("%,d", maxprice);
		Thread.sleep(5000);
				
		driver.findElementByXPath("//span[text() = '"+maxprice1+"']").click();
		
		Set<String> handles = driver.getWindowHandles();
		List<String> handles1 = new ArrayList<String>(handles);
		System.out.println(handles1.size());
		
		String value = handles1.get(1);
		driver.switchTo().window(value);
				
		Thread.sleep(5000);
		driver.findElementByXPath("//input[@id = 'add-to-cart-button']").click();
		
		driver.findElementByXPath("//a[@id = 'hlb-ptc-btn-native']").click();
		
		driver.switchTo().defaultContent();
		
		driver.findElementByXPath("//input[@id = 'continue']").click();
		
		String text = driver.findElementByXPath("(//div[@class = 'a-alert-content'])[2]").getText();
		
		System.out.println(text);
					
	}

}
