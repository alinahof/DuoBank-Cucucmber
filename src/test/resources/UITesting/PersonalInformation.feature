Feature: As a user I want to fill out personal information section of the application

  Background:
    Given I log in with credentials
    Given I click on the mortgage application
    Then I fill out preapproval section

    @personal
    Scenario: I fill out the personal information section of application
      Given I fill out personal information section

