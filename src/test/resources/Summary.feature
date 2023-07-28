Feature: Summary page review & edit

      As a user I should be able to review and edit every section of the loan application

    Background: Common for all steps
      Given I log in with credentials
      Then I click on the mortgage application
      Then I fill out preapproval section
      Then I fill out personal information section
      Then I fill out the expenses page
      Then I fill out Employment&Income page
      Then I fill out credit report
      Then I fill out eConsent page


  Scenario: Review Edit PreApproval Inquiry
    Given I click on the Preapproval
    Then I save loan application