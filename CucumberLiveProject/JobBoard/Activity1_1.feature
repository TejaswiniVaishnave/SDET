@Activity1_1
Feature: Create a new user
 Scenario: Create a new user in Job Board page 

    Given User is on Login page
    When User enters "root" and "pa$$w0rd"
    And Read the page title
    And Locate the left hand menu and click the menu item that says Users
    And Locate the Add New button and click it
    And Fill in the necessary details and click add new user button
    Then Verify that the user was created
    And Close the browser