Feature: Example feature

  Scenario: Example scenario name
    Given I open wikipedia
    When I search for "kite"
    And I press submit search button
    Then I can see the results page
