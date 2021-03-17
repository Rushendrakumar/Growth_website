package reusability_Growth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	protected WebDriver driver;
	Properties prop = new Properties();
	
		
	public void browserConfigurations() {
		try {
		FileInputStream input=new FileInputStream("C:\\Eclipse\\Selenium_Practise\\Selenium_Assesment_Growth\\Config.properties");
		prop.load(input);
		String URL = prop.getProperty("env1");
		String chromeBrowser = prop.getProperty("chrome");
		 File path=new File(chromeBrowser);
		System.setProperty("webdriver.chrome.driver", path.getAbsolutePath());
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.get(URL);
		driver.manage().window().maximize();
		String title = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		if(title.equalsIgnoreCase("Growth Engineering - Online Learning Engagement Experts")) {
			System.out.println("Title matched" + ": " + title);
	}
		else
			System.out.println("Title changed check the tile" + ": " + title);
		}
		catch(Exception e){
			e.printStackTrace();
}
	}
	public void clickElement(String element) {
		try {
			waitUnitlVisible(element);
			driver.findElement(By.xpath(element)).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void sendElement(String element, String value) {
		try {
			driver.findElement(By.xpath(element)).sendKeys(value);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getPageTitle() {
		 String title = null;
	  	 try {
	  		title = driver.getTitle();
	  	 }
	  	 catch(Exception e) {
	  		 e.printStackTrace();
	  		 
	  	 }
	  	
		return title;
	}
	public void waitUnitlVisible(String element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void waitUnitlClickable(String element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,50);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void screenShotCapture(WebDriver driver){
    try {
    	 FileInputStream input=new FileInputStream("C:\\Eclipse\\Selenium_Practise\\Selenium_Assesment_Growth\\Config.properties");
	     prop.load(input);
		 TakesScreenshot screen=((TakesScreenshot)driver);
		 File src=screen.getScreenshotAs(OutputType.FILE);
		 File dest=new File(prop.getProperty("screen")+System.currentTimeMillis()+".png");
		 FileUtils.copyFile(src, dest);

		}
    catch(Exception e) {
			e.printStackTrace();
		}
	}
	 public String getExcel(int row,int col,String dataType) throws Exception {
	 FileInputStream config =new FileInputStream("C:\\Eclipse\\Selenium_Practise\\Selenium_Assesment_Growth\\Config.properties");
	 prop.load(config);
	 String input1=null;
	 FileInputStream input=new FileInputStream(prop.getProperty("excel"));
     XSSFWorkbook workbook=new XSSFWorkbook(input);
	 XSSFSheet sheet=workbook.getSheet("Sheet1");
	 if(dataType.equals("integer")) {
	 String s=sheet.getRow(row).getCell(col).getRawValue();
	 input1=s;
	 }
	 else if(dataType.equals("string")) {
	 String s=sheet.getRow(row).getCell(col).getStringCellValue();
	 input1=s;
	 }
	 return input1;
	 }

	 public void putExcel(int row,int col,String outPut) throws Exception {
	 FileInputStream config =new FileInputStream("C:\\Eclipse\\Selenium_Practise\\Selenium_Assesment_Growth\\Config.properties");
	 prop.load(config);
	 FileInputStream input=new FileInputStream(prop.getProperty("excel"));
	 XSSFWorkbook workbook=new XSSFWorkbook(input);
	 XSSFSheet sheet=workbook.getSheet("Sheet1");
	 XSSFRow r=sheet.createRow(row);
	 XSSFCell c=r.createCell(col);
	 c.setCellValue(outPut);
	 FileOutputStream output=new FileOutputStream(prop.getProperty("excel"));
	 workbook.write(output);
	 input.close();
	 }
	 
	 public void moveToElement(String element) {
		 try {
		Actions actions = new Actions(driver);
		 WebElement function = driver.findElement(By.xpath(element));
		 actions.moveToElement(function).perform();
	 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 }
	 public void testPass() throws Exception {
		putExcel(1,3,"PASS");
		}
	 public void testFail() throws Exception {
			putExcel(1,3,"FAIL");
			}
	 public void testPass1() throws Exception {
			putExcel(2,3,"PASS");
			}
		 public void testFail1() throws Exception {
				putExcel(2,3,"FAIL");
				}
	 
  public void scrollDown(int time){
   try {
  	 JavascriptExecutor scroll = (JavascriptExecutor) driver;
   	scroll.executeScript("window.scrollBy(0,n)");
   }
   catch(Exception e) {
 		e.printStackTrace();
 	}
  }
  public void SelectByValue(String element, String value){
	   try {
	  	 Select drop = new Select(driver.findElement(By.xpath(element)));
	  	 drop.selectByValue(value);
	   }
	   catch(Exception e) {
	 		e.printStackTrace();
	 	}
	  }
  
   public void scrollUP(int time){
    try {
    	JavascriptExecutor scroll = (JavascriptExecutor) driver;
   	scroll.executeScript("window.scrollBy(0,-n)");
   }
  catch(Exception e) {
  		e.printStackTrace();
  	}    
   }
   
   public void actionMoveToElement(WebElement element) {
  	 try {
  		 Actions act = new Actions(driver);
  		 act.moveToElement(element).build().perform();
  	 }
  	 catch(Exception e) {
  		 e.printStackTrace();
  	 }
   }
   public void actionKeyFunctions() {
  	 try {
  		 Actions act = new Actions(driver);
  		 act.sendKeys(Keys.ESCAPE).build().perform();
  	 }
  	 catch(Exception e) {
  		 e.printStackTrace();
  	 }
   }
   public void browserClose() {
  	 try {
  		 driver.close();
  	 }
  	 catch(Exception e) {
  		 e.printStackTrace();
  		 
  	 }
   }
  	public void alert() {
  		
  	  	 try {
  	  		WebElement pop = driver.findElement(By.xpath("//*[@id='elementor-popup-modal-46363']/div"));
  	  		 if(pop.isDisplayed()) {
  	  		 waitUnitlVisible("//*[@id='elementor-popup-modal-46363']/div");
  	  	 driver.findElement(By.xpath("//*[contains(text(),'No Thanks!')]")).click();
  	  	 Thread.sleep(10000);
  	  		 }
  	  		 else {
  	  			 System.out.println("No popup arrived");
  	  		 }
  	  	 }
  	  	 catch(Exception e) {
  	  		 e.printStackTrace();
  	  		 
  	  	 }
   }
  
	
}
