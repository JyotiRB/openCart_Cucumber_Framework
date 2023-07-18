Feature: Login Data Driven

  Scenario Outline: Login Data Driven
   Given User will Launch the browser
    And opens the URL "https://automationexercise.com/"
    And click to Login button
    And he will  enters Email address as "<email>"  and the Password as  "<password>"
    And Click on the Login button
    Then User navigates to home Page

    Examples: 
      | email              | password           |
      | nith.jyo@gmail.com | nith.jyo@gmail.com |
      | nith.jyo@gmail.com | 123@234            |
