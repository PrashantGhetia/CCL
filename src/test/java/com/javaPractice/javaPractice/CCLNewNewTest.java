package com.javaPractice.javaPractice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.javaPractice.GenericUtility.ExcelFileUtility;
import com.javaPractice.GenericUtility.JavaUtility;
import com.javaPractice.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CCLNewNewTest {
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
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@DataProvider(name = "excelsheet")
	public Object[][] getData1() throws EncryptedDocumentException, IOException {
		Object[][] data = eUtil.readMultipleDataFromExcel("CCL");
		return data;
	}

	@Test(dataProvider = "excelsheet")
	public void test1(String phoneNumber, String password)
			throws EncryptedDocumentException, IOException, InterruptedException {

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

		int numberOfActiveProjects = driver
				.findElements(By.xpath("//div[@class='var-skeleton__data']//div[@class='on-going-item ad-padding']"))
				.size();

		int l = 10;
		float todayExpectedIncomeOfAllProjects = 0.0f;
		float totalInvestmentOfAllProjects = 0.0f;
		float expectedTotalIncomeOfAllProjects = 0.0f;
		float actualTotalIncomeTillNowOfAllProjects = 0.0f;
		float totalRemainingIncomeOfAllProjects = 0.0f;

		for (int k = 1; k <= numberOfActiveProjects; k++) {
			WebElement investmentInProjectElement = driver
					.findElement(By.xpath("(//div[text()='INVESTATION']/following-sibling::*)[" + k + "]"));
			wUtil.waitForElementToBeVisible(driver, investmentInProjectElement);
			Float investmentInProject = Float.parseFloat(
					driver.findElement(By.xpath("(//div[text()='INVESTATION']/following-sibling::*)[" + k + "]"))
							.getText().replaceAll("[^0-9]", ""));
			String startDateOfProject = driver
					.findElement(By.xpath("((//div[text()='CYCLE'])[" + k + "]/following-sibling::div)[2]")).getText();
			String startDateTimeOfProject = LocalDateTime
					.parse(startDateOfProject, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
					.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
			String endDateOfProject = driver
					.findElement(By.xpath("((//div[text()='CYCLE'])[" + k + "]/following-sibling::div)[1]")).getText();
			String endDateTimeOfProject = LocalDateTime
					.parse(endDateOfProject, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
					.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
			eUtil.writeDataIntoExcel("CCL1(New)", i, l,
					String.valueOf(investmentInProject) + " \n" + wUtil.convertStringWithWhitespaceIntoMultipleLinesString(startDateTimeOfProject), 2);
			Float dailyIncomeOfProject = Float.parseFloat(
					driver.findElement(By.xpath("((//div[text()='INCOME'])[" + k + "]/following-sibling::div)[1]"))
							.getText().replaceAll("[^0-9]", ""));
			eUtil.writeDataIntoExcel("CCL1(New)", i, l + 2, String.valueOf(dailyIncomeOfProject), 1);
			Float actualTotalIncomeTillNowOfProject = Float.parseFloat(
					driver.findElement(By.xpath("((//div[text()='INCOME'])[" + k + "]/following-sibling::div)[2]"))
							.getText().replaceAll("[^0-9]", ""));
			eUtil.writeDataIntoExcel("CCL1(New)", i, l + 3, String.valueOf(actualTotalIncomeTillNowOfProject), 1);
			Float expectedTotalIncomeOfProject = wUtil.daysBetweenDates(startDateOfProject, endDateOfProject)
					* dailyIncomeOfProject;
			eUtil.writeDataIntoExcel("CCL1(New)", i, l + 1,
					String.valueOf(expectedTotalIncomeOfProject) + " \n" + wUtil.convertStringWithWhitespaceIntoMultipleLinesString(endDateTimeOfProject), 2);
			Float totalRemainingIncomeOfProject = expectedTotalIncomeOfProject - actualTotalIncomeTillNowOfProject;
			eUtil.writeDataIntoExcel("CCL1(New)", i, l + 4, String.valueOf(totalRemainingIncomeOfProject), 1);
			String countdown = driver
					.findElement(By.xpath("(//div[text()='COUNTDOWN']/parent::*//div[@class='v'])[" + k + "]"))
					.getText().replaceAll("[\r\n]+", "");
			eUtil.writeDataIntoExcel("CCL1(New)", i, l + 5, countdown, 1);

			todayExpectedIncomeOfAllProjects += dailyIncomeOfProject;
			totalInvestmentOfAllProjects += investmentInProject;
			expectedTotalIncomeOfAllProjects += expectedTotalIncomeOfProject;
			actualTotalIncomeTillNowOfAllProjects += actualTotalIncomeTillNowOfProject;
			totalRemainingIncomeOfAllProjects += totalRemainingIncomeOfProject;

			WebElement getIncome = driver.findElement(By.xpath("(//div[text()='Get Income'])[" + k + "]"));
			try {
				wUtil.scrollAction(driver, getIncome);
				wUtil.waitForElementToBeVisible(driver, getIncome);
				wUtil.javascriptClick(driver, getIncome);
			} catch (Exception e) {
			}

			l += 6;
		}

		WebElement my = driver.findElement(By.xpath("//span[text()='My']"));
		wUtil.waitForElementToBeVisible(driver, my);
		my.click();

		Thread.sleep(5000);
		String balance = driver.findElement(By.xpath("//div[@class='balance']//span")).getText();
		
		eUtil.writeDataIntoExcel("CCL1(New)", i, 3, balance + " \n" + wUtil.convertStringWithWhitespaceIntoMultipleLinesString(formatter.format(date)), 2);
		//eUtil.writeDataIntoExcel("CCL1(New)", i, 3, balance + " \n" + formatter.format(date));
		Float todayIncome = Float
				.parseFloat(driver.findElement(By.xpath("(//div[text()='Income : '])[2]//span")).getText());
		eUtil.writeDataIntoExcel("CCL1(New)", i, 9, String.valueOf(todayIncome), 1);
		eUtil.writeDataIntoExcel("CCL1(New)", i, 8, String.valueOf(todayExpectedIncomeOfAllProjects), 1);
		eUtil.writeDataIntoExcel("CCL1(New)", i, 4, String.valueOf(totalInvestmentOfAllProjects), 1);
		eUtil.writeDataIntoExcel("CCL1(New)", i, 5, String.valueOf(expectedTotalIncomeOfAllProjects), 1);
		eUtil.writeDataIntoExcel("CCL1(New)", i, 6, String.valueOf(actualTotalIncomeTillNowOfAllProjects), 1);
		eUtil.writeDataIntoExcel("CCL1(New)", i, 7, String.valueOf(totalRemainingIncomeOfAllProjects), 1);

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
