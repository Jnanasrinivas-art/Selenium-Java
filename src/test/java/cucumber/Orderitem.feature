@tag
  Feature: Order the Item from Ecommerce website.

    Background:
      Given I landed on Ecommerce Page

    @Regression @Sanity
    Scenario: Positive Test for Submitting Order
      Given Login with username and password
      When Order the item and Submit the Order
      And do the payment
      Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page
