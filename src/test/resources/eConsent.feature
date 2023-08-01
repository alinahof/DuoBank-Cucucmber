Feature: eConsent Page

  Background: I'm on eConsent page
    Given I choose credit report option

  @econsent @smoke
    Scenario: Verify first name, last name, email fields are required
      When I Leave the first name, last name, email fields field empty
      Then I should see a warning message
#
  @econsent
      Scenario Outline: Verify email format
        When I enter invalid "<email>"  format
        Then I should see a email warning message
    Examples:
    |email|
    |john123|
    |john.gmail|

  @econsent
    Scenario: Verify first name, last name fields accept only letters
      When I enter numbers in first name, last name fields
      Then I should see first name, last name warning messages


  @econsent
  Scenario: Verify first name, last name, email fields' placeholders are correct
    When I Leave the first name, last name, email fields field empty
    Then I should see correct placeholders

  @econsent
  Scenario: Verify there are 2 radio buttons "Agree" and "Don't Agree"
      When I Leave the first name, last name, email fields field empty
      Then I should see two radio buttons Agree and Don't Agree
#
  @econsent
  Scenario: Verify that "Agree" is selected by default
        When I'm on the Econsent page
        Then Agree should be selected
#
  @econsent @smoke
  Scenario: Verify "Agree" functionality
    When I select agree and Next
    Then I should be redirected to the next page

  @econsent @smoke
  Scenario: Verify " Don't Agree" functionality
    When I select don't agree and Next
    Then I should be redirected to the main application page

  @econsent
    Scenario: Verify that the user should not be able to submit the eConsent agreement without selecting one of the radio buttons
    When I'm on the Econsent page
      Then I should see an error message
#








