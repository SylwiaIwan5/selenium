package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SearchResultsPage {

    @FindBy(css = "div[class='product-container'] a[class='product-name']")
    private WebElement labelProductName;

    @FindBy(css = "p[class='alert alert-warning']")
    private WebElement labelParagraphAlert;

    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        System.out.println("Opened search results page");
    }

    public SearchResultsPage assertProductName(WebDriver driver, String expectedProductName) {
        System.out.println("Checking if product name is correct");
        waitUntilElementIsVisible(driver, labelProductName);
        String actualProductName = labelProductName.getText();
        assertEquals(expectedProductName, actualProductName);
        System.out.println("Product name was correct " + expectedProductName);
        return this;
    }

    public SearchResultsPage assertCommunication(WebDriver driver, String expectedCommunication) {
        System.out.println("Checking if communication is proper");
        waitUntilElementIsVisible(driver, labelParagraphAlert);
        String actualCommunication = labelParagraphAlert.getText();
        assertEquals(expectedCommunication, actualCommunication);
        System.out.println("Communication is correct and sounds: '" + expectedCommunication + "'");
        return this;
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
