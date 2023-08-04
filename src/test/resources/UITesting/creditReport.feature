Feature: Credit report page


  @credit
  Scenario: I'm on the credit report page
    When I fill out credit report
    Then I'm redirected to the Econsent page