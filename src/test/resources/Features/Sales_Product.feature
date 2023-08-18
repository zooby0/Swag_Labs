#Author : Muhammad zohaib
#Date : 17/Aug/2023
#Description: Swap Labs - Buy or Deny Product
@productBuyDeny
Feature: Verify buy or deny product functionality in Swag Labs site

  Scenario: Verify, user is able to buy product
    Given Browser is open
    And Naviagte to login page
    When Enter the username: "standard_user" and password: "secret_sauce"
    And Click on the login button
    When user buys several products
      | backpack      |
      | bike-light    |
      | bolt-t-shirt  |
      | fleece-jacket |
      | onesie        |
    When User removes bought products
      | backpack      |
      | bike-light    |
      | bolt-t-shirt  |
      | fleece-jacket |
      | onesie        |
    Then Logout page
