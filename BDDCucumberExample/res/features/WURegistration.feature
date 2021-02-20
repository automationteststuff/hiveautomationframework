Feature: WU Registration Verify

  @SmokeTest
  Scenario Outline: Filling the Registration Form
    Given User launch the chrome broswer
    When user enter the application url
    Then verify user landing on home page
    And user enters first name as <firstname>
    And user enters middle name as <middlename>
    And user enters last name as <lastname>
    And user enters date of birth as <dob>
    And user click on submit button on the bottom of the section
    And user closes the apllication

    Examples: 
      | firstname | middlename | lastname | dob        |
      | Anil      | Kumar      | Reddy    | 17/06/1900 |

  @Sanity
  Scenario Outline: WU Registration Second Test
    Given User launch the chrome broswer
    When user enter the application url
    Then verify user landing on home page
    And user enters first name as <firstname>
    And user enters middle name as <middlename>
    And user enters last name as <lastname>
    And user enters date of birth as <dob>
    And user click on submit button on the bottom of the section
    And user closes the apllication

    Examples: 
      | firstname | middlename | lastname | dob        |
      | Sunil     | Kumar      | Reddy    | 17/06/1990 |
