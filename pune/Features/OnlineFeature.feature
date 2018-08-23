Feature: Online Registration Form Feature

Scenario: User fills the form using valid credentials

Given The user is in the registration page
When The user enters valid creadentials
Then user is redirected to payment page
And  message is displayed
