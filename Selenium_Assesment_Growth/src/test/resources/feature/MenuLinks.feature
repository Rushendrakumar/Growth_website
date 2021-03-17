@Menulinks @Growth
Feature: Check that all menu links in the top navigation work(Our Products to Get in Touch)

  Background: 
    Given user landed in growthengineering Home Page

  @OurProducts @Scenario_1
  Scenario: Validating the ourproducts link
    When user clicks on link "Our Products"
    Then user should be landed into any one of the product which is mentioend in dropdown
    And user can be able to navigate to another link "The Academy LMS" under "Our Products" from dropdown from the present page
    And user clicks on logo closes the browser

  @OurApproach @Scenario_2
  Scenario Outline: Validating the OurApproach link
    When user can be able to navigate to another link "<Links>" under "<Parent>" from dropdown from the present page
    Then user should be landed into any one of the product which is mentioend in dropdown
    And user clicks on logo closes the browser

    Examples: 
      | Links           | Parent       |
      | Brain Science   | Our Approach |
      | Social Learning | Our Approach |

  @Resources @Scenario_3
  Scenario: Validating the Resources link
    When user clicks on link "Resources"
    Then user should be landed into any one of the product which is mentioend in dropdown
    And user clicks on logo closes the browser

  @Aboutus @Scenario_4
  Scenario: Validating the Aboutus link
    When user clicks on link "About Us"
    Then user should be landed into any one of the product which is mentioend in dropdown
    And user clicks on logo closes the browser

  @Get_in_Touch @Scenario_5
  Scenario: Validating the Get_in_Touchlink
    When user clicks on button "GET IN TOUCH"
    Then user should be landed into any one of the product which is mentioend in dropdown
    And user clicks on logo closes the browser
