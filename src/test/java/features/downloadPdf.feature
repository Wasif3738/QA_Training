Feature: Download PDF

  Scenario: Download Wikipedia article as PDF
    When I greet the user
    Given I have 5 apples
    Then The main page is displayed
    When I search for "Albert Einstein"
    And I click the search button
    And I click on the Tools menu
    And I select option Download as PDF
    And I click the Download button
    Then The PDF file is downloaded successfully
