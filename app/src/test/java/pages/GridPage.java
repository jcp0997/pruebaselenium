package pages;

public class GridPage extends BasePage {
    
    private String cell = "";
    private String mainTable = "";

    public GridPage(){
        super(driver);
    }

    public void navigateToGrid()
    {
        NavigateTo("https://www.google.com");
    }

    public String getValueFromGrid(int row, int column)
    {
        return getValueFromTable(cell, row, column);
    }

    public boolean cellStatus()
    {
        return elementIsDisplayed(mainTable);
    }
}
