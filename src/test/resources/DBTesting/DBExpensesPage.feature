Feature: Expenses Page data

  Background: Login to reach Expenses Page
    Given I log in with a valid credentials
    Then I navigate to Expenses Page


  @exp
  Scenario: Update Expenses Information
    Given I am on the Expenses page
    When I update my living situation to rental
    And I enter my monthly rental payment as "1000"
    And I save the information
    Then the information should be stored in the database


  @exp
  Scenario: The "rent_own_status" field should only allow two values, "Rent" and "Own"
    Given I am on the Expenses page
    And rent_own_status field should only allow two values, "Rent" and "Own"


  @exp
  Scenario: Validate positive numeric values in payment fields
    Given I am on the Expenses page
    When I enter a positive numeric value "500" into the monthly_rental_payment field
    And I enter a positive numeric value "1500" into the first_mortgage_total_payment field
    Then the monthly_rental_payment field should only contain a positive numeric value
    And the first_mortgage_total_payment field should only contain a positive numeric value


  @exp
  Scenario: Verify mapping of Expenses form fields to "tbl_mortgage" table
    Given I am on the Expenses page
    When the user enters valid data into the Expenses form fields
    And the user submits the form
    Then the data from the form fields should be correctly mapped to the tbl_mortgage table in the database
