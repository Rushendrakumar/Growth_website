@ContactUs
Feature: Check that form validation works on the contact page (/contact/)

  Background: 
    Given user landed in growthengineering Home Page
    And user clicks on button "GET IN TOUCH"

  @Contact @Scenario_1 @Positive_Scenario
  Scenario: Validating the Get_in_Touchlink
    When user enters the below details
      | First Name | Last Name | Work Email       | Telephone  | Company Name | Country | Learners | Role Description               | Enquiry                                    |
      | R          | Rushi     | test01@gmail.com | 9991112221 | techologies  | India   | 0-500    | Director (HR, L&D or Training) | To share how I can help Growth Engineering |
    Then user should click on check box
    And user clicks on logo closes the browser

  @Contact @Scenario_2 @Negative_Scenario @dropdown_fields
  Scenario: Validating the Get_in_Touchlink
    When user enters the below details
      | First Name | Last Name | Work Email | Telephone  | Company Name | Country | Learners | Role Description | Enquiry |
      | R          | Rushi     | test01     | 9991112221 | techologies  | India   | 0-500    |                  |         |
    Then user should get the inline error message if misses for any dropdown "Role Description", "Enquiry" field "Please select an option from the dropdown menu."
    And user clicks on logo closes the browser

  @Contact @Scenario_3 @Negative_Scenario @text_fields
  Scenario: Validating the Get_in_Touchlink
    When user enters the below details
      | First Name | Last Name | Work Email | Telephone  | Company Name | Country | Learners | Role Description               | Enquiry                                    |
      | R          | Rushi     |            | 9991112221 |              | India   | 0-500    | Director (HR, L&D or Training) | To share how I can help Growth Engineering |
    Then user should get the inline error message if misses for any text "Last Name","Company Name","Work Email" field "Please complete this required field."
    And user clicks on logo closes the browser
