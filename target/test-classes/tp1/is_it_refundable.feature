Feature: Is it Refundable?
  Client wants to know if he can get refund
  Max values are saved in the constants file refundConstants.java

  Scenario: Refund can't be when there's no cash
    Given transaction done 30 days ago
    And Stock is 30
    And Cash is 10.0
    And Product is Not Damaged
    And Price is 40.0
    And NumberOfPieces is 3
    When I ask whether he can get refund
    Then I should be told "Nope"

  Scenario: Refund can't be when transaction happened more then 40 days ago
    Given transaction done 50 days ago
    And Stock is 30
    And Cash is 100.0
    And Product is Not Damaged
    And Price is 40.0
    And NumberOfPieces is 3
    When I ask whether he can get refund
    Then I should be told "Nope"

  Scenario: Refund can't be when there's no place in stock
    Given transaction done 30 days ago
    And Stock is 400
    And Cash is 100.0
    And Product is Not Damaged
    And Price is 40.0
    And NumberOfPieces is 3
    When I ask whether he can get refund
    Then I should be told "Nope"

  Scenario: Refund can't be when the product has been damaged by the client
    Given transaction done 30 days ago
    And Stock is 30
    And Cash is 100.0
    And Product is Damaged
    And Price is 40.0
    And NumberOfPieces is 3
    When I ask whether he can get refund
    Then I should be told "Nope"

  Scenario: Refund can happen when there's no problem
    Given transaction done 30 days ago
    And Stock is 30
    And Cash is 100.0
    And Product is Not Damaged
    And Price is 40.0
    And NumberOfPieces is 3
    When I ask whether he can get refund
    Then I should be told "Yup"
