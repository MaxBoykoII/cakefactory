package bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration
public class CatalogSteps {
    @Given("the catalog contains {int} items")
    public void setCatalogItems(int itemCount) {

    }

    @When("I navigate to the landing page")
    public void openLandingPage() {

    }

    @Then("I see a list of all {int} items with title and price")
    public void verifyItems(int itemCount) {}
}
