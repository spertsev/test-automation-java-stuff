Feature: Login feature

  Scenario: Login as user
    When open home page
    And sign in as user with following credentials
    | user1@somedomain.com | Q1q2q3q4q5 |
    Then username "User One" is displayed on header bar

