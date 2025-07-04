Feature: Language Search

  Scenario: Search name in a language
    Given I have 10 apples
    Then The main page is displayed
    When I search for "Gabriel García Márquez"
    And I change the search language to "SPANISH"
    And I click the search button
    Then The article page for "Gabriel García Márquez" is displayed
