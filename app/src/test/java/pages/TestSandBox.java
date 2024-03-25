package pages;

public class TestSandBox extends BasePage {

    private String categoryDropdown = "//div[contains(text(),'Select State')]";

    public TestSandBox()
    {
        super(driver);
    }

    public void navigateToSandBox()
    {
        NavigateTo("https://demoqa.com/automation-practice-form");
    }

    public void selectCategory(String category)
    {
        selectFromDropdownByValue(categoryDropdown, category);
    }
}
