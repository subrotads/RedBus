package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[contains(@class,'inputAndSwapWrapper')]//div[contains(@class,'srcDestWrapper')]")
	WebElement from;
	
	@FindBy(xpath = "//input[@id='srcinput']")
	WebElement frmDe;
	
	@FindBy(xpath = "//div[@aria-label='Esplanade, Kolkata']")
	WebElement board;
	
	@FindBy(xpath = "//input[@id='destinput']")
	WebElement toDes;
	
	@FindBy(xpath = "//div[@aria-label='Tenzing Norgay Central Bus Stand, Siliguri']")
	WebElement drop;
	
	@FindBy(xpath = "//div[contains(@aria-label,'Select Date of Journey.')]")
	WebElement datePick;
	
	@FindBy(xpath = "//div[contains(@aria-label,'Friday, February 20, 2026')]")
	WebElement dateOfJou;
	
	@FindBy(xpath = "//button[@aria-label=\"Search buses\"]")
	WebElement searchBtn;
	
	@FindBy(xpath = "//li[@id='28436388']")
	WebElement bus;
	
	@FindBy(xpath = "//span[contains(@aria-label,'seat type sleeper')]")
	WebElement seatMap;
	
	@FindBy(xpath = "//span[@id='LB1W']")
	WebElement seatt;
	
	
	
	
	
	public void FromD() {
		wait.until(ExpectedConditions.elementToBeClickable(from)).click();
	}
	
	public void FromDest(String fromdes) {
		frmDe.sendKeys(fromdes);
		
	}
	
	public void Boardi() {
		wait.until(ExpectedConditions.elementToBeClickable(board)).click();
	}
	
	public void ToDesti(String todes) {
		toDes.sendKeys(todes);
	}
	
	public void Drop() {
		wait.until(ExpectedConditions.elementToBeClickable(drop)).click();
	}
	
	public void DatePicker(String date) {
		datePick.click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(dateOfJou)).click();
	}
	
	public void SearchButton() {
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
	}
	
	public void SelectBus() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)","");
		
		wait.until(ExpectedConditions.elementToBeClickable(bus)).click();
	}
	
	public void SeatMap() {
		wait.until(ExpectedConditions.visibilityOf(seatMap));
		
		List<WebElement> seats = driver.findElements(By.xpath("//span[contains(@aria-label,'seat status')]"));
		
		for (WebElement seat : seats) {
			String seatNumber = seat.getAttribute("id");
			if(seatNumber == null || seatNumber.isEmpty()) {
				seatNumber = seat.getText();
			}
			String seatClass = seat.getAttribute("aria-label");
			String status = null;
			if (seatClass.contains("seat status available")) {
				status = "Available";
			} else if (seatClass.contains("seat status sold")) {
				status = "Sold";
			}
			System.out.println("Seat Number: " + seatNumber + " | Status: " + status); 
		}
	}

		
	
	
	public void SelectSeat() {
	            
	            wait.until(ExpectedConditions.elementToBeClickable(seatt)).click();
	}
}



