
@DBLogin
Feature: Data Base Login Test:

#  Background: Common for all steps:
#    Given I click on the SignUp link and fill out SignUpPage



  @DB @smoke
  Scenario: As a user has signed up. I want to verify the information has been stored properly in the data Base
    Then I retrieve the email
    And I verify the information is correct

    @DB @smoke
    Scenario: As a Sdet. I want to verify the DB has the following columns
      Given I retrieve the columns from Data Base
      Then I verify the columns

     @DB @smoke
      Scenario: Verify that there is a timestamp column in the DB and it works properly
        Given I retrieve the timestamp column from the DB
        Then I verify that the TimeStamp column is functioning properly

       @DB
       Scenario: Verify that the data base doesn't have duplicate emails
         Given I retrieve the emails from Data Base and verify there arent duplicates

         @DB
         Scenario: Verify that passwords are encrypted and stored in database properly
           Given I retrieve password from database and verify its encrypted

           @SignUp
           Scenario: The Application should be able to handle multiple signups
             Given I can sign up multiple times for the application and verify on the data base
