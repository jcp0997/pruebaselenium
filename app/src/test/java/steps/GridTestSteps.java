package steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.GridPage;

public class GridTestSteps {
    
    GridPage grid = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage()
    {
        //Thread.sleep(1000);
        grid.navigateToGrid();
    }

    @Then("^I can return the value I wanted$")
    public void returnValue()
    {
        String value = grid.getValueFromGrid(3, 2);

        Assert.assertEquals("1 a", value);
    }

    @Then("^I can validate the table is displayed$")
    public void theTableIsThere()
    {

        Assert.assertTrue("El elemento esta siendo mostrado", grid.cellStatus());
    }
}
