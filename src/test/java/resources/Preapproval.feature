


Feature: Preapproval Information

  As a user I want to fill out the preapproval section of the application

  Background: Common steps for all scenarios
    Given I log in with credentials

@login
  Scenario: Fill out preapproval section of the application
    Given I click on the mortgage application
    Then I fill out preapproval section
