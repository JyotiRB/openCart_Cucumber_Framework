Feature: Login Data Driven with excel

  Scenario Outline: Login Data Driven with excel
    Given User will Launch the browser
    And opens the URL "https://automationexercise.com/"
    And click to Login button
   
  
   
  
    Then check User navigates to home Page by passing Email and Password with excel row "<row_index>"
     And click on Login
    Examples: 
      |row_index|
      |1|
      |2|
      |3|
