package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.TestSandBox;

public class TestSandboxsteps {

    TestSandBox sandboxPage = new TestSandBox();
    
    @Given("^I navigate to the sandbox page$")
    public void navigateToSandBoxSite(){
        sandboxPage.navigateToSandBox();
    }

    @And("^select a value from the dropdown$")
    public void selectState()
    {
        sandboxPage.selectCategory("Haryana");
    }
}
