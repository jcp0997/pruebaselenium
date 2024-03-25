package pages;

public class GooglePage extends BasePage{
    
    private String searchButton = "/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[4]/div[7]/center[1]/input[1]";
    private String searchTextField = "//textarea[@id='APjFqb']";
    private String firstResult = "//*[@id=\"hdtb-msb\"]/div[1]/div/div[1]/span/span";

    public GooglePage(){
        super(driver);
    }

    public void NavigateToGoogle()
    {
        NavigateTo("https://www.google.com");
    }

    public void clickGoogleSearch()
    {
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria)
    {
        write(searchTextField, criteria);
    }

    public String firstResult()
    {
        return textFromElement(firstResult);
    }
}
