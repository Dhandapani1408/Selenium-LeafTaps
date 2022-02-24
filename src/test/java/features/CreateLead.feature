@regression
Feature: Login For LeafTaps Application

  @smoke
  Scenario Outline: TC001 Positive Login Flow
    Given Enter the Username as <UserName>
    And Enter the password as <Password>
    When Click on the login button
    And Click on Leads menu
    And Click on Create Leads
    And Enter the CompanyName as <CompanyName>
    And Enter the FirstName as <FirstName>
    And Enter the LastName as <LastName>
    And Click on Submit for Create Leads
    Then Validate lead is created
    Examples: 
      | UserName         | Password | CompanyName | FirstName | LastName |
      | DemoCSR          | crmsfa   | TestLeaf    | TestQa    | Auto     |
