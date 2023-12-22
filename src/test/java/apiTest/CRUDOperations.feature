Feature: This feature will be used to test the CRUD oprtaions on employee springboot application using Rest Assured

  #Scenario: This scenario will test the Get operation on Employee DB
    #Given I have the endpoint as "http://3.84.15.226:8088/employees"
    #When I perform the Get operation
    #Then I should get the response as 200

  Scenario: This scenario will test the Post operation on Employee DB
    Given I have the endpoint as "http://3.84.15.226:8088/employees"
    When I perform the Post operation with below data
      | firstName | Tushar      |
      | lastName  | Gupta       |
      | salary    |        3000 |
      | email     | abc@xyz.com |
    Then I should get the response as 201
    And the fname should be "Tushar" in response
