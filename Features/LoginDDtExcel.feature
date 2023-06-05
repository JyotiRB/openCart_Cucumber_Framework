Feature: Login Data Driven with excel

  Scenario Outline: Login Data Driven
    Given User Launch browser
    And opens URL "https://demo.opencart.com/"
    When User navigate to MyAccount menu
    And click on Login
  
    Then check User navigates to MyAccount Page by passing Email and Password with excel row "<row_index>"
    Examples: 
      |row_index|
      |1|
      |2|
      |3|
