package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PageObjects.HomePage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
	
	WebDriver driver;
	HomePage homepage;
	
	@Given("User Launches the Chrome Browser")
	public void user_launches_the_chrome_browser() {
	    WebDriverManager.chromedriver().setup();
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--headless=new");
	    options.addArguments("--window-size=1920,1080");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("user-agent=Mozilla/5.0(Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
	    options.addArguments("--disable-blink-features=AutomationControlled");
	    driver = new ChromeDriver(options);
	    
	    homepage = new HomePage(driver);
	    
	}

	@Then("User Opens URL {string}")
	public void user_opens_url(String url) {
	   driver.get(url);
	}

	@Then("Click in the From field")
	public void click_in_the_from_field() {
	    homepage.FromD();
	}

	@Then("User enters From location as {string}")
	public void user_enters_from_location_as(String abcd) {
	    homepage.FromDest(abcd);
	}
	
	@Then("User selects boarding point")
	public void user_selects_boarding_point() {
	    homepage.Boardi();
	}
	
	@Then("User enters To location as {string}")
	public void user_enters_to_location_as(String dcba) {
	    homepage.ToDesti(dcba);
	}
	
	@Then("User selects drop point")
	public void user_selects_drop_point() {
	    homepage.Drop();
	}
	
	@Then("User click in the calender and select date as {string}")
	public void user_click_in_the_calender_and_select_date_as(String date) {
	    homepage.DatePicker(date);
	}
	
	@Then("User click on the search button")
	public void user_click_on_the_search_button() {
	    homepage.SearchButton();
	}
	
	@Then("User click to select bus")
	public void user_click_to_select_bus() {
	    homepage.SelectBus();
	}
	
	@Then("User check for seats available")
	public void user_check_for_seats_available() {
	    homepage.SeatMap();
	}

	
	@Then("User selected available seat")
	public void user_selected_available_seat() {
	    homepage.SelectSeat();
	}

	@Then("User close the browser")
	public void user_close_the_browser() {
	    driver.close();
	    driver.quit();
	}
}


