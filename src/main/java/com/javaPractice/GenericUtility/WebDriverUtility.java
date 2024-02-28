package com.javaPractice.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class contains all the generic methods related to web driver actions
 * @author Prashant
 *
 */

public class WebDriverUtility {
		/**
		 * 1) This method will maximize the window
		 * @param driver
		 */
		public void maximizeWindow(WebDriver driver) {
			driver.manage().window().maximize();
		}
		/**
		 * 2) This method will wait for 10 seconds for entire DOM (Document Object Model) structure to load
		 * @param driver
		 */
		public void waitForDOMToLoad(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		/**
		 * 3) This method will wait until a particular element becomes Visible
		 * @param driver
		 * @param ele
		 */
		public void waitForElementToBeVisible(WebDriver driver, WebElement ele) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
		/**
		 * 4) This method will wait until a particular element becomes Clickable and then perform click operation
		 * @param driver
		 * @param ele
		 */
		public void waitForElementToBeClickable(WebDriver driver, WebElement ele) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		}
		/**
		 * 5) This method is a custom wait where it will wait for particular element to perform click operation
		 * if the element is not interactive it will wait for 1 second
		 * @param driver
		 * @param ele
		 * @throws InterruptedException
		 */
		public void customWaitAndClickOnElement(WebDriver driver, WebElement ele) throws InterruptedException {
			int count=0;
			while(count<100) {
				try {
					ele.click();
					break;
				}
				catch(Exception e){
					Thread.sleep(1000);
					count++;
				}
			}
		}
		/**
		 * 6) This method will handle Drop Down by select class using index
		 * @param ele
		 * @param index
		 */
		public void handleDropDown(WebElement ele, int index) {
			Select s = new Select(ele);
			s.selectByIndex(index);
		}
		/**
		 * 7) This method will handle Drop Down by select class using Visible Text
		 * @param ele
		 * @param text
		 */
		public void handleDropDown(WebElement ele, String text) {  //6) & 7) Method Overloading
			Select s = new Select(ele);
			s.selectByVisibleText(text);
		}
		/**
		 * 8) This method will handle Drop Down by select class using Value
		 * @param value
		 * @param ele
		 */
		public void handleDropDown(String value, WebElement ele) {
			Select s = new Select(ele);
			s.selectByValue(value);
		}
		/**
		 * 9) This method will perform Mouse Hover action on a particular element
		 * @param driver
		 * @param ele
		 */
		public void mouseHover(WebDriver driver, WebElement ele) {
			Actions a = new Actions(driver);
			a.moveToElement(ele).perform();
		}
		/**
		 * 10) This method will perform double click on the page
		 * @param driver
		 */
		public void doubleClickOn(WebDriver driver) {
			Actions a = new Actions(driver);
			a.doubleClick().perform();
		}
		/**
		 * 11) This method will perform double click on a particular element
		 * @param driver
		 * @param ele
		 */
		public void doubleClickOn(WebDriver driver, WebElement ele) {
			Actions a = new Actions(driver);
			a.doubleClick(ele).perform();
		}
		/**
		 * 12) This method will perform right click on the page
		 * @param driver
		 */
		public void rightClickOn(WebDriver driver) {
			Actions a = new Actions(driver);
			a.contextClick().perform();
		}
		/**
		 * 13) This method will perform right click on a particular element
		 * @param driver
		 * @param ele
		 */
		public void rightClickOn(WebDriver driver, WebElement ele) {
			Actions a = new Actions(driver);
			a.contextClick(ele).perform();
		}
		/**
		 * 14) This method will perform Drag and Drop from source element location to
		 * target element location
		 * @param driver
		 * @param source
		 * @param target
		 */
		public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
			Actions a = new Actions(driver);
			a.dragAndDrop(source, target).perform();
		}
		/**
		 * 15) This method will press Enter key and release
		 * @throws AWTException
		 */
		public void pressEnter() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		/**
		 * 16) This method will accept the alert pop up
		 * @param driver
		 */
		public void alertPopupAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		/**
		 * 17) This method will dismiss the alert pop up
		 * @param driver
		 */
		public void alertPopupDismis(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		/**
		 * 18) This method will get the text of alert pop up
		 * @param driver
		 * @return
		 */
		public String alertPopupGetText(WebDriver driver) {
			String alertText = driver.switchTo().alert().getText();
			return alertText;
		}
		/**
		 * 19) This method will switch to frame based on frame index
		 * @param driver
		 * @param frameIndex
		 */
		public void switchToFrame(WebDriver driver, int frameIndex) {
			driver.switchTo().frame(frameIndex);
		}
		/**
		 * 20) This method will switch to frame based on frame name or id
		 * @param driver
		 * @param frameNameOrId
		 */
		public void switchToFrame(WebDriver driver, String frameNameOrId) {
			driver.switchTo().frame(frameNameOrId);
		}
		/**
		 * 21) This method will switch to frame based on frame element
		 * @param driver
		 * @param frameElement
		 */
		public void switchToFrame(WebDriver driver, WebElement frameElement) {
			driver.switchTo().frame(frameElement);
		}
		/**
		 * 22) This method will switch the control back to immediate parent frame
		 * @param driver
		 */
		public void switchToParentFrame(WebDriver driver) {
			driver.switchTo().parentFrame();
		}
		/**
		 * 23) This method will come out of all the frames
		 * @param driver
		 */
		public void switchBackFromFrames(WebDriver driver) {
			driver.switchTo().defaultContent();
		}
		/**
		 * 24) This method will switch control from one window to newly opened window
		 * @param driver
		 */
		public void switchToNewWindow(WebDriver driver) {
			Set<String> child = driver.getWindowHandles();
			for(String b:child) {
				driver.switchTo().window(b);
			}
		}
		/**
		 * 25) This method will switch control from one window to another window based on partial window title
		 * @param driver
		 * @param partialWinTitle
		 */
		public void switchToWindows(WebDriver driver, String partialWinTitle) {
			//Method-1
			//Step-1 Capture all the Windows IDs
			Set<String> winIds = driver.getWindowHandles();
			
			//Step-2 Extract individual Window ID
			for(String winId:winIds) {  //for each loop converting set<String> into String
				//Step-3 Capture the current Window Title
				String currentWinTitle = driver.switchTo().window(winId).getTitle();
				
				//Step-4 Compare the current Window Title with required Window Title
				if(currentWinTitle.contains(partialWinTitle)) {
					break;
				}
			}
			/*
			//Method-2
			//Step-1 Capture all the Windows IDs
			Set<String> winIds = driver.getWindowHandles();
			
			//Step-2 Iterate through all the Windows IDs
			Iterator<String> it = winIds.iterator();
			
			//Step-3 Navigate to each Windows and check the title
			while(it.hasNext()) {
				//Step-4 Capture the individual Window ID
				String winId = it.next();
				//Step-5 Capture current Window Title
				String currentWinTitle = driver.switchTo().window(winId).getTitle();
				//Step-6 Compare current Window Title with required Window Title
				if(currentWinTitle.contains(partialWinTitle)) {
					break;
				}
			}
			*/
		}
		/**
		 * 26) This method will take Screenshot and save it in Screenshots folder
		 * @param driver
		 * @param screenshotName
		 * @return
		 * @throws IOException
		 */
		public String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
			JavaUtility jUtil = new JavaUtility();
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(IConstantsUtility.ScreenshotsPath+jUtil.getSystemDateInFormat()+screenshotName+".png");
			FileUtils.copyFile(srcFile, destFile);  //From commons io dependency
			return destFile.getAbsolutePath();  //Get complete path of destFile which is used for extent Reports
		}
		/**
		 * 27) This method will Scroll down page for 500 units
		 * @param driver
		 */
		public void scrollAction(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)","");
		}
		/**
		 * 28) This method will scroll until the specific element
		 * @param driver
		 * @param ele
		 */
		public void scrollAction(WebDriver driver, WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].scrollIntoView(true);", ele);
			int y = ele.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+")", ele);
		}
		/**
		 * 29) This method will scroll until the element and click on the element
		 * @param driver
		 * @param ele
		 */
		public void javascriptClick(WebDriver driver, WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
		}
		
		/**
		 * 30) This method will provide total number of opened tabs
		 */
		public int getNumberOfOpenedTabs(WebDriver driver) {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			int numberOfOpenedTabs = tabs.size();
			return numberOfOpenedTabs;
		}
		
		/**
		 * 31) This method will open a new Blank Tab
		 */
		public void openNewTab(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.open()");
		}

}
