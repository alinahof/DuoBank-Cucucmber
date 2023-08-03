
@DBLogin
Feature: Data Base Login Test:

#  Background: Common for all steps:
#    Given I click on the SignUp link and fill out SignUpPage



  @DB
  Scenario: As a user has signed up. I want to verify the information has been stored properly in the data Base
    Then I retrieve the email
    And I verify the information is correct

    @DB
    Scenario: As a Sdet. I want to verify the DB has the following columns
      Given I retrieve the columns from Data Base
      Then I verify the columns