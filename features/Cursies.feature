
Feature: verify the cursive feature

  Scenario: Click and verify the cursive link
    Given user login into the app
    When user clicks on Cursies link
    Then verify the page title "Cruises: Mercury Tours"
    Then Logout and close the browser
    
