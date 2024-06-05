import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Command;
import org.junit.Assert;

public class CommandSteps {

    private Command command;
    @Given("Customer who whant to command for Someone")
    public void customerWhoWhantToCommandForSomeone() {
        command = new Command();
        command.setFrom("Customer");
    }

    @When("a Command is make form Someone")
    public void aCommandIsMakeFormSomeone() {

        command.setTo("Somemone");
    }

    @Then("there is no product in the Command")
    public void thereIsNoProductInTheCommand() {
        Assert.assertTrue(command.getProducts().isEmpty());
    }

    @And("the command come from Customer")
    public void theCommandComeFromCustomer() {
        Assert.assertEquals("Customer",command.getFrom());
    }
}
