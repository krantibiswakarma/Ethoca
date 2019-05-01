Feature: Test the checkout and create account functionality

Background: 
	Given that the user is in the landing page

@sanity
Scenario:
	When the user clicks the "Women" tab and selects "Summer Dresses"
	Then the "Summer Dresses" page should open
	When the user quick views the "Printed Chiffon Dress"
	Then the "Printed Chiffon Dress" product details should open
	When the user selects size "M" and adds it to cart
	Then the product should be successfully added to the cart
	When the user goes to the cart and clics checkout
	Then the "Order" page should open
	When the user clicks proceed to checkout button
	Then the "Login" page should open
	When the user enters the email "test@random.com" and clicks create an account
	Then the user should be taken to the "YOUR PERSONAL INFORMATION" screen
	When the user enters title as "Mr", first name as "First", last name as "Last", password as "password", address as "5576 Trenton Avenue", city as "Cinncinatti", state as "Ohio", postal code as "12345", country as "United States", mobile number as "1234567890" and alias as "alias" and clicks register
	And the user clicks proceed to checkout button to process address
	And the user accepts the terms of service
	And the user clicks proceed to checkout button to process carrier
	Then the user should be be able to see the correct order on the payment tab