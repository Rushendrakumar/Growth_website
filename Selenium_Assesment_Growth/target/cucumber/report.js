$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Contacts.feature");
formatter.feature({
  "line": 2,
  "name": "Check that form validation works on the contact page (/contact/)",
  "description": "",
  "id": "check-that-form-validation-works-on-the-contact-page-(/contact/)",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@ContactUs"
    }
  ]
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "user landed in growthengineering Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user clicks on button \"GET IN TOUCH\"",
  "keyword": "And "
});
formatter.match({
  "location": "Validating_links.user_landed_in_growthengineering_Home_Page()"
});
formatter.result({
  "duration": 65990577200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GET IN TOUCH",
      "offset": 23
    }
  ],
  "location": "Validating_links.user_clicks_on_button(String)"
});
formatter.result({
  "duration": 46026380400,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Validating the Get_in_Touchlink",
  "description": "",
  "id": "check-that-form-validation-works-on-the-contact-page-(/contact/);validating-the-get-in-touchlink",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@Contact"
    },
    {
      "line": 8,
      "name": "@Scenario_1"
    },
    {
      "line": 8,
      "name": "@Positive_Scenario"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "user enters the below details",
  "rows": [
    {
      "cells": [
        "First Name",
        "Last Name",
        "Work Email",
        "Telephone",
        "Company Name",
        "Country",
        "Learners",
        "Role Description",
        "Enquiry"
      ],
      "line": 11
    },
    {
      "cells": [
        "R",
        "Rushi",
        "test01@gmail.com",
        "9991112221",
        "techologies",
        "India",
        "0-500",
        "Director (HR, L\u0026D or Training)",
        "To share how I can help Growth Engineering"
      ],
      "line": 12
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "user should click on check box",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user clicks on logo closes the browser",
  "keyword": "And "
});
formatter.match({
  "location": "Contact_validation.user_enters_the_below_details(DataTable)"
});
formatter.result({
  "duration": 16845900,
  "status": "passed"
});
formatter.match({
  "location": "Contact_validation.user_should_click_on_check_box()"
});
formatter.result({
  "duration": 984900,
  "status": "passed"
});
formatter.match({
  "location": "Validating_links.user_closes_browser()"
});
formatter.result({
  "duration": 4179427400,
  "status": "passed"
});
});