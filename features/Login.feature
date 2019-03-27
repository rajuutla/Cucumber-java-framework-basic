#Author: your.email@your.domain.com

@login
Feature: Login feature for the new tours site
 
  @smoke
  Scenario: Verify the successful login
    Given user login into the app
    Then verify the page title "Find a Flight: Mercury Tours:"
    Then Logout and close the browser
