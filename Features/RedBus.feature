Feature: Seat Selection on RedBus

Scenario Outline: User Select a Available Seat on RedBus
			Given User Launches the Chrome Browser
			Then User Opens URL "https://www.redbus.in/"
			And Click in the From field
			And User enters From location as "Kolkata"
			And User selects boarding point
			And User enters To location as "Siliguri"
			And User selects drop point
			And User click in the calender and select date as "February 2026, 20"
			And User click on the search button
			And User click to select bus
			And User check for seats available
			And User selected available seat
			And User close the browser
			
			
			
			
