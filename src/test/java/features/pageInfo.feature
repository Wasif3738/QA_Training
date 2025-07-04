Feature: Page Info

  Scenario: View information about Pages article
    Then The main page is displayed
    When I search for "Bengal tiger"
    And I click the search button
    And I click on the Tools menu
    And I select Page Information
    Then The information page for "Bengal tiger" is displayed
