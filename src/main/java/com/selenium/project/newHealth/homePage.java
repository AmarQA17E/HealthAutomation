package com.selenium.project.newHealth;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class homePage {

	
		// TODO Auto-generated method stub
		public static String basedir= "C:\\Users\\user\\Desktop\\SelJavaInterview\\";
		public static WebDriver driver;
		
	public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
	  System.setProperty("webdriver.chrome.driver", basedir+"newHealth\\chromedriver-win64\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	 Thread.sleep(3000);
	 /******************************************************/
	 //dropDown();
	 
	 /******************************************************/
	// alertOrPopUpHandling();
	 
	 
	 /******************************************************/
	  // driver.get("https://www.facebook.com");
	 
	 // driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	 
	 /*****************************************************/
	/******** window handling ********************************/
	 
	 //windowsAndPopUpHandling();
	// windowsHandlingGoleImage();
	 newWindowHandle();
	 /*****************************************************/
	 /*****************************************************/
	 //driverClose();
	// driver.quit();
	 
	  }
		
		//calander handling ----makemytrip
		//drop down handling --- Etsy UK
       // form submission -- reddit.com
	
	public static void driverClose() {
		driver.close();
	}
		
	public static void dropDown() {
		
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		
	//	driver.get("https://ww.globalsqa.com/demo-site/select-dropdown-menu/");
		/*
		 * Select selDropDown= new Select(driver.findElement(By.tagName("select")));
		 * //WebElement dropD=driver.findElement(By.tagName("select"));
		 * selDropDown.selectByValue("IDN");
		 */
	
		try {
		 Select sel= new Select(null); 
		 sel.selectByIndex(0);
		}
		catch(Exception e) {
			System.out.println("next Code will run after try block execution");
		}
	    
	    new Select(driver.findElement(By.tagName("select"))).selectByIndex(10);
	    new Select(driver.findElement(By.tagName("select"))).selectByVisibleText("Bosnia and Herzegovina");
	    
	}
	
	public static void alertOrPopUpHandling() throws InterruptedException {
		/*
		 * Simple Alert 
		 * Prompt Alert 
		 * Confirmation Alert
		 
		 */
	
			
		driver.navigate().to("https://www.browserstack.com/users/sign_up");
		
		WebElement Element=driver.findElement(By.id("user_submit"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		
		js.executeScript("window.scroll(0,350)", "");  //-- down---//
		js.executeScript("window.scroll(0,-350)", "");  //--up--//
		js.executeScript("0, document.body.ScrollHeight", "");
		
		driver.findElement(By.id("user_submit")).click();
		
		Thread.sleep(5000);
		Alert alert= driver.switchTo().alert();
		Thread.sleep(5000);
		alert.accept();
	   
	
System.out.println("alert handling code executed in try block, exception is ignored, next LINE of code run uninturrpted");
	   
	   }
	public static void windowsAndPopUpHandling() throws InterruptedException {
		/*
		 * driver.navigate().to(
		 * "https://www.browserstack.com/guide/alerts-and-popups-in-selenium");
		 * 
		 * //driver.switchTo().alert().accept(); driver.findElement(By.xpath(
		 * "//div[@id='accept-cookie-notification-content']/button")).click();
		 * 
		 * WebElement element=driver.findElement(By.
		 * linkText("How to handle multiple windows in Selenium")); JavascriptExecutor
		 * js= (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].scrollIntoView", element );
		 * Thread.sleep(3000); element.click(); String title= driver.getTitle();
		 * System.out.println(title);
		 * 
		 * //---tab1----//
		 * driver.findElement(By.linkText("BrowserStack home page")).click(); String
		 * title2= driver.getTitle();
		 * 
		 * //---tab2----// System.out.println(title2);
		 * System.out.println("code executer");
		 */
		
		
		//parent window - url
		//child window1 - url may or may not
		//child window2 - url present
		//---https://www.edureka.co/blog/handle-multiple-windows-in-selenium/---//
		driver.get("https://www.edureka.co/blog/handle-multiple-windows-in-selenium/");
		String winHAND=driver.getWindowHandle();
		System.out.println(winHAND);
		//String getTextAlert=driver.switchTo().alert().getText();
		//System.out.println(getTextAlert);
		//driver.switchTo().alert().dismiss();
		driver.findElement(By.id("wzrk-cancel")).click();
		driver.findElement(By.xpath("//button[@class='close']/span")).click();
		driver.findElement(By.linkText("Explore Online Courses")).click();
		String winHAND2=driver.getWindowHandle();
	}
	
	public static void windowsHandlingGoleImage() {
		driver.navigate().to("https://www.google.com/search?sca_esv=8add31af34f47e86&q=keyword+driven+framework&tbm=isch&source=lnms&sa=X&ved=2ahUKEwiPoJXcmoWEAxXBdPUHHbzIAxcQ0pQJegQIDhAB&biw=1366&bih=607&dpr=1");
		String ParentWindowHandle= driver.getWindowHandle();
		driver.findElement(By.xpath("//div[contains(text(),'Scientech Easy')]")).click();
		
		Set<String> allWindowHandle= driver.getWindowHandles();
		for(String wh:allWindowHandle) {
			driver.switchTo().window(wh);
	     String title=driver.getTitle();
	     if(title.equalsIgnoreCase("Keyword Driven Framework in Selenium WebDriver - Scientech Easy")) {
	    	
	    		driver.findElement(By.linkText("Collections")).click();
	     }
			
		}
		System.out.println(ParentWindowHandle);
	//	driver.findElement(By.xpath("//div[@class='LAA3yd'and contains(text(), 'Scientech Easy')])")).click();
		try {
		driver.findElement(By.xpath("//div[contains(text(),'Scientech Easy')]")).click();
		}
		catch(Exception e) {
			System.out.println("Exception handled");
			
		}
		String Child1WindowHandle=driver.getWindowHandle();
		System.out.println(Child1WindowHandle);
		driver.findElement(By.linkText("Collections")).click();
	
		
	}
	
	
	public static void newWindowHandle() {
		driver.get("https://www.google.com/search?sca_esv=8add31af34f47e86&q=keyword+driven+framework&tbm=isch&source=lnms&sa=X&ved=2ahUKEwiPoJXcmoWEAxXBdPUHHbzIAxcQ0pQJegQIDhAB&biw=1366&bih=607&dpr=1");
		String ParentWindow=driver.getWindowHandle();
		driver.findElement(By.xpath("//div[contains(text(),'Scientech Easy')]")).click();
	
	//	driver.findElement(By.xpath("//div[contains(text(),'Automation Repository')]")).click();
	//	driver.findElement(By.xpath("//div[contains(text(),'BrowserStack')]")).click();
		Set<String> allWindowHandles=driver.getWindowHandles();
		for(String wh:allWindowHandles) {
			driver.switchTo().window(wh);
			String title=driver.getTitle();
			if(title.equalsIgnoreCase("Keyword Driven Framework in Selenium WebDriver - Scientech Easy")) {
				try {
				driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
				}
				catch(Exception e) {
					System.out.println("Advertisement Handles");
					
				}
				driver.findElement(By.linkText("Selenium")).click();
			
				//span[contains(text(),'Close')]
			}
		}
		driver.switchTo().window(ParentWindow);
		driver.findElement(By.xpath("//div[contains(text(),'Testsigma')]")).click();
	}
	public static void iFrameHandling() {
		
	}
	public static void formHandling() {
		
	}
	public static void exceptionHandling() {
		
	}
	
	public static void checkBoxHandling() {
		
	}
	
	public static void radioButtonHandling() {
		
	}
	public static void waitHandling() {
		
	}
}
