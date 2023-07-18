Feature: Login with Valid Credentials

@sanity
  Scenario: Successful Login with Valid Credentials
    Given User will Launch the browser
    And opens the URL "https://automationexercise.com/"
    And click to Login button
    And User enters Email address as "raga.j1993@gmail.com" and the Password as "raga.j1993@gmail.coom"
    And Click on the Login button
    Then User navigates to home Page

# https://automationexercise.com/