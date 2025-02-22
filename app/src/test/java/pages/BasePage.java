package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    //Se crea instancia estática del webdriver

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private Actions action;

    static{
        
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10);
        System.setProperty("webdriver.chrome.driver", "C:/Users/jpena/Documents/Cursos/Curso de Testing/Selenium con Java y Cucumber/app/chromedriver");
        
    }

    public BasePage(WebDriver driver)
    {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
        // implicito
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void NavigateTo(String url)
    {
        driver.get(url);
    }

    public static void closeBrowser()
    {
        driver.quit();
    }

    private WebElement Find(String locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator)
    {
        Find(locator).click();
    }

    public void write(String locator, String textToWrite)
    {
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect)
    {
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect)
    {
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect)
    {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);

    }

    public void hoverOverElement(String locator)
    {
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator)
    {
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator)
    {
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int column)
    {
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend)
    {
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        Find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex)
    {
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame()
    {
        driver.switchTo().parentFrame();
    }

    public void dismissAlert()
    {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public String textFromElement(String locator)
    {
        return Find(locator).getText();
    }

    public boolean elementEnabled(String locator)
    {
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator)
    {
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator)
    {
        return Find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator)
    {
        return driver.findElements(By.className(locator));
    }

    public void goToLinkText(String linkText)
    {
        driver.findElement(By.linkText(linkText)).click();
    }

    public void selectNthElement(String locator, int index)
    {
        List<WebElement> results = driver.findElements(By.xpath(locator));
        results.get(index).click();
    }


    //public void validateText(String locator, String textToValidate)
    //{
        //Assert.assertEquals(textToValidate, Find(locator).getText());
    //}
}
