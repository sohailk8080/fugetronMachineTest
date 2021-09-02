package org.mvnframework.k12.fugetronAssignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mmtPageClass {
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait;

	public mmtPageClass(WebDriver driver) {
		this.driver = driver;
	}
	//open URL
	public void openURL() {
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");

	}
	//Typing city name in "from" field
	public void selectFrom(By locator, String pretext, By locator1) throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']")));
		driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		WebElement txtField = wait.until(ExpectedConditions.elementToBeClickable(locator));
		txtField.click();
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='autopop__wrap makeFlex column defaultCursor']")));
		WebElement from = wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
		from.sendKeys(pretext);
		Thread.sleep(2000);
	}
	//selecting from "from" dropdown
	public void clickFromDrop(String searchText, By locator, By locator1) {
		wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		// String innerHTML= element.getAttribute("innerHTML");
		// System.out.println(innerHTML);
		List<WebElement> autoList = element.findElements(locator1);
		for (WebElement autoText : autoList) {
			if (autoText.getText().equals(searchText)) {
				System.out.println("Selected: " + autoText.getText());
				wait.until(ExpectedConditions.visibilityOf(autoText));
				autoText.click();
				break;
			}
		}

	}
	//Typing city name in "to" field
	public void selectTo(By locator, String pretext, By locator1) throws InterruptedException {
		// wait=new WebDriverWait(driver,10);
		WebElement txtField = wait.until(ExpectedConditions.elementToBeClickable(locator));
		txtField.click();
		WebElement to = wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
		to.sendKeys(pretext);
		Thread.sleep(2000);

	}
	//selecting from "to" dropdown
	public void clickToDrop(String searchText, By locator, By locator1) {
		wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		List<WebElement> autoList = element.findElements(locator1);
		for (WebElement autoText : autoList) {
			if (autoText.getText().equals(searchText)) {
				System.out.println("Selected: " + autoText.getText());
				wait.until(ExpectedConditions.visibilityOf(autoText));
				autoText.click();
				break;
			}
		}
	}
	// selecting departure date
	public void departDate(By locator, By locator1, String date) throws InterruptedException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		List<WebElement> allDates = driver.findElements(locator1);
		for (WebElement dateClick : allDates) {
			if (dateClick.getText().equals(date)) {
				WebElement btnClick = wait.until(ExpectedConditions.elementToBeClickable(dateClick));
				btnClick.click();
				break;
			}
		}
		Thread.sleep(2000);
	}
	// selecting return date
	public void returnDate(By locator, By locator1, String date) throws InterruptedException {
		// wait=new WebDriverWait(driver,10);
		driver.findElement(By.cssSelector("[data-cy='roundTrip']")).click();
		;
		// Thread.sleep(2000);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
		List<WebElement> allDates = driver.findElements(locator1);
		// wait.until(ExpectedConditions.visibilityOfAllElements(allDates));
		for (WebElement dateClick : allDates) {
			if (dateClick.getText().equals(date)) {
				WebElement btnClick = wait.until(ExpectedConditions.visibilityOf(dateClick));
				btnClick.click();
				break;
			}
		}
	}
	// selecting no of adults
	public void selectAdults(By locator, String no) {
		List<WebElement> adults = driver.findElements(locator);
		for (WebElement selAdults : adults) {
			if (selAdults.getText().equals(no)) {
				selAdults.click();
				break;
			}
		}
	}

	// selecting no of children from traveller and class button
	public void selectChildren(By locator, String no) {
		List<WebElement> children = driver
				.findElements(locator);
		for (WebElement selChildren : children) {
			if (selChildren.getText().equals(no)) {
				selChildren.click();
				break;
			}
		}
	}

	// selecting no of infants from traveller and class button
	public void selectInfants(By locator, String no) {
		List<WebElement> infants = driver
				.findElements(locator);
		for (WebElement selinfants : infants) {
			if (selinfants.getText().equals(no)) {
				selinfants.click();
				break;
			}
		}
	}

	// select traveller class
	public void selectClass() {
		driver.findElement(By.xpath("//li[@data-cy='travelClass-0']")).click();
	}

	// click on apply button
	public void selectAdults() {
		driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
	}

}
