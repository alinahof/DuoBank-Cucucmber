
@DBLogin
Feature: Data Base Login Test:

  Background: Common for all steps:
    Given I click on the SignUp link
    Then I fill out the SignUp page
    And I get Registration successful message



  Scenario: As a user has signed up. I want to verify the information has been stored properly in the data Base

    When I log into the Data Base
    Then I retrieve the "username" and "email"
    And I verify the information is correct