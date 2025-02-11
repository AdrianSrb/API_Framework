Feature: Validation of Place API's - Test Suite

  Scenario: Add Place intro Google Maps - Test Case
    Given Add Place Payload
    When User calls "AddPlaceAPI" with Post http request
    Then The API call got success with status code is 200
    And "status" in response body is "OK"