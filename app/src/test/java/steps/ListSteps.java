package steps;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ListPage;

public class ListSteps {
    ListPage list = new ListPage();

    @Given("^I navigate to the list page$")
    public void navigateToGridPage()
    {
        //Thread.sleep(1000);
        list.navigateToListPage();
    }

    @When("^I search (.+) in the list$")
    public void searchTheList(String state) throws InterruptedException
    {
        list.enterSearchCriteria(state);
    }

    @Then("^I can find (.+) in the list$")
    public void theCityIsThere(String city)
    {
        List<String> lista = list.getAllSearchResults();
        boolean textIsThere = lista.contains(city);

        if(textIsThere)
        {
            System.out.println("The Text is on the list: PASSED.");
        }
        else{
            throw new Error("The Text is not on the list: FAILED.");
        }

    }
}
