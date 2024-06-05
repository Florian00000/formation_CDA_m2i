
  Feature: Command Ordering

    as a customer i want to make a command form someone

    Scenario: Creation of an empty Command
      Given Customer who whant to command for Someone
      When a Command is make form Someone
      Then there is no product in the Command
      And the command come from Customer