package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ListPage extends BasePage{
    
    private String searchField = "";
    private String searchResults = "";

    public ListPage(){
        super(driver);
    }

    public void navigateToListPage()
    {
        NavigateTo("www.google.com");
    }

    public void enterSearchCriteria(String state) throws InterruptedException
    {
        try {
            //Thread.sleep(600);
            write(searchField, state);
        } catch (NoSuchElementException e) {
            System.out.println("The WebElement Search Field couldn´t be found");
            e.printStackTrace();
        }
        
    }

    public List<String> getAllSearchResults()
    {
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringsFromList = new ArrayList<String>();
        for(WebElement e:list)
        {
            stringsFromList.add(e.getText());
        }
        return stringsFromList;
    }
}
