package steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AmazonSearchPage;

public class AmazonSearchSteps {
    
    AmazonSearchPage amazon = new AmazonSearchPage();

    @Given("^the user navigates to www.amazon.com$")
    public void navigateToAmazon()
    {
        amazon.navigateToAmazon();
    }

    @And("^searches for (.+)$")
    public void enterSearchCriteria(String criteria)
    {
        amazon.enterSearchCriteria(criteria);
        amazon.clickSearch();
    }

    @When("^navigates to the page number (.+)$")
    public void navigateToSecondPage(String pageNumber)
    {
        amazon.goToPage(pageNumber);
    }

    @And("^selects the third item$")
    public void selectThirdItem()
    {
        amazon.pick3rdItem();
    }

    @Then("^the user would be able to add it to the cart$")
    public void itemCanBeAddedToTheCart()
    {
        amazon.addToCart();
        Assert.assertEquals("Agregado al carrito", amazon.addedToCartMessage());
    }
}
