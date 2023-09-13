Feature: E2E Scenario
  Scenario: Normal Checkout process and confirm order
    Given user logged in to the app
    When user add ipod to the cart
    And user do checkout process and confirm order
    Then order should be placed
    And user logout


