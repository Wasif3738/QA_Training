Feature: Alerts
  I am a user
  I want to handle alert
  To be able to accept is

  Scenario: Alert handling
    Given I go to 'JavaScript Alerts' on the main page
    When I generate JS alert on the JavaScript Alert page
    And I accept the alert
    Then Success message is displayed on the JavaScript Alert page