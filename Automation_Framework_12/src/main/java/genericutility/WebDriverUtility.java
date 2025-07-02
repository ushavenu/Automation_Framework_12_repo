package genericutility;

import java.io.File;
import java.io.IOException;
import java.nio.channels.Selector;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

/**
 * @author abhijith
 */
public class WebDriverUtility {
	/**
	 * This method is used to maximize the window
	 * 
	 * @param driver
	 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	public void selectByIndex(WebElement element, int index) {
		Select ref = new Select(element);
		ref.selectByIndex(index);
	}

	public void slectByValue(WebElement element, String value) {
		Select ref = new Select(element);
		ref.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select ref = new Select(element);
		ref.selectByVisibleText(text);
	}

	public String[] getAllOptions(WebElement element) {
		Select ref = new Select(element);
		List<WebElement> allOptions = ref.getOptions();
		String[] options = new String[allOptions.size()];

		for (int i = 0; i < allOptions.size(); i++) {
			options[i] = allOptions.get(i).getText();
		}
		return options;
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	public void switchToWindow(WebDriver driver, String expUrl) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id : allWindowIds) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(expUrl)) {
				break;
			}
		}
	}

	public void getPhoto(WebDriver driver) throws IOException {
		JavaUtility jUtil = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/" + jUtil.getSystemTime() + ".png");
		FileHandler.copy(temp, dest);
	}
	
	public void jsScroll(WebDriver driver,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo("+x+","+y+")");
	}
	
	

}
