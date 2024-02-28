package com.javaPractice.javaPractice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.javaPractice.GenericUtility.ExcelFileUtility;
import com.javaPractice.GenericUtility.JavaUtility;
import com.javaPractice.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CCLNew {
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
	
	@DataProvider(name="excelsheet")
	public Object[][] getData1() throws EncryptedDocumentException, IOException{
		Object[][] data = eUtil.readMultipleDataFromExcel("CCL");
		return data;
	}

	@Test(dataProvider = "excelsheet")
	public void test1(String phoneNumber, String password) throws EncryptedDocumentException, IOException, InterruptedException {
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

		List<WebElement> countdowns = driver
				.findElements(By.xpath("//div[text()='COUNTDOWN']/parent::*//div[@class='v']"));
		int numberOfCountdown = countdowns.size();
		System.out.println("Number of Countdown: " + numberOfCountdown);

		int j = 5;
		for (WebElement countdown : countdowns) {
			try {
				wUtil.waitForElementToBeVisible(driver, countdown);
				String countDown = countdown.getText().replaceAll("[\r\n]+", "");
				eUtil.writeDataIntoExcel("CCL1", i, j, countDown);
			} catch (Exception e) {
				// TODO: handle exception
			}
			j++;
		}

		List<WebElement> getIncomes = driver.findElements(By.xpath("//div[text()='Get Income']"));
		int numberOfGetIncome = getIncomes.size();
		System.out.println("Number of Elements: " + numberOfGetIncome);

		for (WebElement getIncome : getIncomes) {
			try {
				wUtil.scrollAction(driver, getIncome);
				wUtil.waitForElementToBeVisible(driver, getIncome);
				getIncome.click();
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
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
