Feature: QA Model Management

  Scenario Outline: Scenario: Create a QA
    Given the client makes a POST request qa with name <name> and country <country>
    Then the response status code should be <code>
    Examples:
        | name    | country  | code |
        | "test1" | "Brazil" | 200  |

  Scenario Outline: Update a QA
    Given a QA with ID
    When a news info qa is  name <name> and country <country>
    Then the response status code should be <code>
    Examples:
      | name         | country  | code |
      | "testUptade" | "Brazil" | 200  |


  Scenario Outline: Delete a QA
    Given a QA with ID
    When the client makes a DELETE
    Then the response status code should be <code>
    Examples:
      | code |
      | 200  |

  Scenario Outline: Get All QAs
    When the client makes a get all QAs
    Then the response status code should be <code>
    Examples:
      | code |
      | 200  |
