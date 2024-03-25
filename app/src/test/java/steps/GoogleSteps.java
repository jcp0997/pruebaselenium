package steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GooglePage;



public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("^I am on the Google search page$")
    public void navigateToGoogle(){
        google.NavigateToGoogle();
    }

    @When("^I enter a search criteria$")
    public void enterSearchCriteria(){
        google.enterSearchCriteria("Real Madrid");
    }


    @And("^click on the search button$")
    public void clickSearchButton(){
        google.clickGoogleSearch();
    }

    @Then("^the results match the criteria$")
    public void validateResults(){
        Assert.assertEquals("Todo", google.firstResult());
    }



}