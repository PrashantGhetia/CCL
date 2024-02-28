package com.javaPractice.javaPractice;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;  

import com.javaPractice.GenericUtility.ExcelFileUtility;
import com.javaPractice.GenericUtility.JavaUtility;
import com.javaPractice.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CCL {
	WebDriverUtility wUtil = new WebDriverUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	JavaUtility jUtil = new JavaUtility();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	WebDriver driver = null;
	int i = 1;
	@BeforeTest
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(dataProvider="excelsheet") //Read from Excel sheet
	public void CCLDatas(String phoneNumber, String password) {
			System.out.println(phoneNumber+"-"+password);
	}
	@DataProvider(name="excelsheet")
	public Object[][] getData1() throws EncryptedDocumentException, IOException{
		Object[][] data = eUtil.readMultipleDataFromExcel("CCL");
		return data;
	}
	@Test(dataProvider = "excelsheet")
	public void newtest(String phoneNumber, String password) throws EncryptedDocumentException, IOException, InterruptedException {
		driver.get("https://www.ccl-trusr.com/index.html#/auth/sign-in");
		
		WebElement phoneTextField = driver.findElement(By.id("var-input-9"));
		wUtil.waitForElementToBeVisible(driver, phoneTextField);
		phoneTextField.sendKeys(phoneNumber);
		
		WebElement passwordTextField = driver.findElement(By.id("var-input-14"));
		wUtil.waitForElementToBeVisible(driver, passwordTextField);
		passwordTextField.sendKeys(password);
		
		WebElement signin = driver.findElement(By.xpath("//div[text()='Sign In']"));
		wUtil.waitForElementToBeVisible(driver, signin);
		signin.click();
		
		WebElement position = driver.findElement(By.xpath("//span[text()='Position']"));
		wUtil.waitForElementToBeVisible(driver, position);
		position.click();
		
		WebElement countdown = driver.findElement(By.xpath("//div[text()='COUNTDOWN']/parent::*//div[@class='v']"));
		wUtil.waitForElementToBeVisible(driver, countdown);
		String countDown = countdown.getText().replaceAll("[\r\n]+", "");
		eUtil.writeDataIntoExcel("CCL1", i, 5, countDown);
		
		try {
			WebElement getIncome = driver.findElement(By.xpath("//div[text()='Get Income']"));
			wUtil.scrollAction(driver, getIncome);
			wUtil.waitForElementToBeVisible(driver, getIncome);
			getIncome.click();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		finally {
			WebElement my = driver.findElement(By.xpath("//span[text()='My']"));
			wUtil.waitForElementToBeVisible(driver, my);
			my.click();
			
			Thread.sleep(5000);
			WebElement balance = driver.findElement(By.xpath("//div[@class='balance']//span"));
			wUtil.waitForElementToBeVisible(driver, balance);
			
			eUtil.writeDataIntoNewExcel("CCL1", i, 3, formatter.format(date));
			eUtil.writeDataIntoNewExcel("CCL1", i, 4, balance.getText());
			
			WebElement signout = driver.findElement(By.xpath("//div[text()='Sign Out']"));
			wUtil.waitForElementToBeVisible(driver, signout);
			wUtil.javascriptClick(driver, signout);
			
			WebElement confirm = driver.findElement(By.xpath("//div[text()='Confirm']"));
			wUtil.waitForElementToBeVisible(driver, confirm);
			confirm.click();
			driver.navigate().refresh();
			i++;
		}
	}
	@Test
	public void test1() throws EncryptedDocumentException, IOException, InterruptedException {
		for(int i = 1; i<eUtil.getRowCount("CCL"); i++) {
			driver.get("https://www.ccl-trusr.com/index.html#/auth/sign-in");
			
			WebElement phoneTextField = driver.findElement(By.id("var-input-9"));
			wUtil.waitForElementToBeVisible(driver, phoneTextField);
			String phoneNumber = "";
			if (eUtil.cellType("CCL", i, 1) == CellType.STRING) {
				phoneNumber = eUtil.readStringDataFromExcel("CCL", i, 1);
			} else if (eUtil.cellType("CCL", i, 1) == CellType.NUMERIC) {
				phoneNumber = eUtil.readNumericDataFromExcel("CCL", i, 1);
			}
			phoneTextField.sendKeys(phoneNumber);
			
			WebElement passwordTextField = driver.findElement(By.id("var-input-14"));
			wUtil.waitForElementToBeVisible(driver, passwordTextField);
			
			String password = "";
			if (eUtil.cellType("CCL", i, 2) == CellType.STRING) {
				password = eUtil.readStringDataFromExcel("CCL", i, 2);
			} else if (eUtil.cellType("CCL", i, 2) == CellType.NUMERIC) {
				password = eUtil.readNumericDataFromExcel("CCL", i, 2);
			}
			passwordTextField.sendKeys(password);
			
			WebElement signin = driver.findElement(By.xpath("//div[text()='Sign In']"));
			wUtil.waitForElementToBeVisible(driver, signin);
			signin.click();
			
			WebElement position = driver.findElement(By.xpath("//span[text()='Position']"));
			wUtil.waitForElementToBeVisible(driver, position);
			position.click();
			
			WebElement countdown = driver.findElement(By.xpath("//div[text()='COUNTDOWN']/parent::*//div[@class='v']"));
			wUtil.waitForElementToBeVisible(driver, countdown);
			String countDown = countdown.getText().replaceAll("[\r\n]+", "");
			eUtil.writeDataIntoExcel("CCL", i, 5, countDown);
			
			try {
				WebElement getIncome = driver.findElement(By.xpath("//div[text()='Get Income']"));
				wUtil.scrollAction(driver, getIncome);
				wUtil.waitForElementToBeVisible(driver, getIncome);
				getIncome.click();
			} catch (Exception e) {
				//e.printStackTrace();
			}
			
			finally {
				WebElement my = driver.findElement(By.xpath("//span[text()='My']"));
				wUtil.waitForElementToBeVisible(driver, my);
				my.click();
				
				Thread.sleep(5000);
				WebElement balance = driver.findElement(By.xpath("//div[@class='balance']//span"));
				wUtil.waitForElementToBeVisible(driver, balance);
				
				eUtil.writeDataIntoNewExcel("CCL", i, 3, formatter.format(date));
				eUtil.writeDataIntoNewExcel("CCL", i, 4, balance.getText());
				
				WebElement signout = driver.findElement(By.xpath("//div[text()='Sign Out']"));
				wUtil.waitForElementToBeVisible(driver, signout);
				wUtil.javascriptClick(driver, signout);
				
				WebElement confirm = driver.findElement(By.xpath("//div[text()='Confirm']"));
				wUtil.waitForElementToBeVisible(driver, confirm);
				confirm.click();
				driver.navigate().refresh();
			}
		}
		
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
