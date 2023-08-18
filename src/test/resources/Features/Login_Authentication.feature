#Author : Muhammad zohaib
#Date : 16/Aug/2023
#Description: Swap Labs - User Authentication
@loginTest
Feature: Verify Login functionality in Swag Labs site

  Scenario Outline: Verify, user is able to Login successfully with valid credential
    Given Browser is open
    And Naviagte to login page
    When List of users enter the <username> and <password>
    And Click on the login button
    And User navigate to the Home page
    Then Logout page

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
