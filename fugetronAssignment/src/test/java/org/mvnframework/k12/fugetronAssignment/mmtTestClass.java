package org.mvnframework.k12.fugetronAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.mvnframework.k12.fugetronAssignment.mmtPageClass;

public class mmtTestClass {
	WebDriver driver;
	mmtPageClass obj;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = new ChromeDriver();
		obj = new mmtPageClass(driver);
		obj.openURL();
		Thread.sleep(3000);
	}

	@Test
	public void f() throws InterruptedException {
		// clicks on 'from' field and writes pretext
		obj.selectFrom(By.id("fromCity"), "Mumbai", By.xpath("//input[@aria-controls='react-autowhatever-1']"));

		// clicks on the name from the dynamic dropdown
		obj.clickFromDrop("Mumbai, India", By.xpath("//ul[@role='listbox']"), By.tagName("p"));

		// clicks on 'To' field and writes pretext
		obj.selectTo(By.cssSelector("div[role='combobox'] > .react-autosuggest__input"), "Goa",
				By.xpath("//input[@aria-controls='react-autowhatever-1']"));

		// clicks on the name from the dynamic dropdown
		obj.clickToDrop("Goa, India", By.id("react-autowhatever-1-section-0-item-1"), By.tagName("p"));

		// clicks on departure date
		obj.departDate(By.cssSelector(".DayPicker-Months > div:nth-of-type(1)"), By.tagName("p"), "10");

		// selecting roundtrip for return date then clicks on return date
		obj.returnDate(By.xpath("//label[@for='return']"), By.tagName("p"), "15");

		// selecting traveller class button
		driver.findElement(By.xpath("//label[@for='travellers']")).click();

		// selecting no of adults from traveller and class button
		obj.selectAdults(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']//li"), "2");

		// selecting no of children from traveller and class button
		obj.selectChildren(By.xpath("//p[@data-cy='childrenRange']//following-sibling::ul//li"), "5");

		// selecting no of infants from traveller and class button
		obj.selectInfants(By.xpath("//p[@data-cy='infantRange']//following-sibling::ul//li"), "2");

		// select traveller class
		driver.findElement(By.xpath("//li[@data-cy='travelClass-0']")).click();

		// click on apply button
		driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
