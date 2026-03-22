package testngprograms;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class ClearTrip {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void searchingFlights() throws InterruptedException {
		driver =new ChromeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		try {
		WebElement crossIcon=
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='pb-1 px-1 flex flex-middle nmx-1']"))));
				crossIcon.click();
				}
		catch(Exception e) {
			System.out.println("popup not displayed");
		}
		WebElement roundtrip=driver.findElement(By.id("roundtrip"));
				roundtrip.click();
				WebElement fromCity=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Where from?']")));
				fromCity.click();
				fromCity.sendKeys("Hyderabad");
				WebElement fromCitySelection=
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Hyderabad, IN - Rajiv Gandhi International (HYD)']")));
				fromCitySelection.click();
				WebElement toCity=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Where to?']")));
				toCity.sendKeys("Bengaluru");
				WebElement toCitySelection=
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Bengaluru, IN - Kempegowda International Airport (BLR)']")));
				toCitySelection.click();
				WebElement startDate=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@data-testid='dateSelectOnward']"))));
				startDate.click();
				List<WebElement> startDateSelection=driver.findElements(By.xpath("(//div[@class='DayPicker-Months']/div)[1]//div[(contains(@class,'DayPicker-Day')) and not (contains(@class,'DayPicker-Day--disabled')) and not (contains(@class,'DayPicker-Day--outside'))]"));
				wait.until(ExpectedConditions.visibilityOfAllElements(startDateSelection));
				startDateSelection.get(3).click();
				 List<WebElement> returnDateSelection = driver.findElements(By.xpath("(//div[@class='DayPicker-Months']/div)[2]//div[contains(@class,'DayPicker-Day') and not(contains(@class,'DayPicker-Day--disabled')) and not(contains(@class,'DayPicker-Day--outside'))]"));
						 wait.until(ExpectedConditions.visibilityOfAllElements(returnDateSelection));
				        returnDateSelection.get(5).click();
				WebElement searchFlights=driver.findElement(By.xpath("//h4[text()='Search flights']"));
				wait.until(ExpectedConditions.visibilityOf(searchFlights));
				searchFlights.click();
				 List<WebElement> checkingOfAssertion = driver.findElements(By.xpath("(//div[@class='sc-aXZVg hOLUjW sc-c657435f-0 cvqcfb mb-4 c-pointer br-4 w-100p pb-3'])"));
				 wait.until(ExpectedConditions.visibilityOfAllElements(checkingOfAssertion));
		        Assert.assertEquals(checkingOfAssertion.size()>0, true);
		        Reporter.log("testCase passed with HardAssertion");
	}
}
