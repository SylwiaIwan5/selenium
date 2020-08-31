package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class BankWireOrderConfirmationPage {

    @FindBy(className = "navigation_page")
    private WebElement header;

    @FindBy(css = "p[class = 'cheque-indent']")
    private WebElement completeOrderCommunication;

    @FindBy(className = "button-exclusive btn btn-default")
    private WebElement backToOrdersButton;

    private WebDriver driver;

    public BankWireOrderConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        System.out.println("Opened bank wire order confirmation page");
    }

    public BankWireOrderConfirmationPage assertCommunication(WebDriver driver, String communication) {
        System.out.println("Checking if communication is proper");
        waitUntilElementIsVisible(driver, completeOrderCommunication);
        String paragraphAlertText = completeOrderCommunication.getText();
        assertEquals(paragraphAlertText, communication);
        System.out.println("Communication is correct and sounds: '" + communication + "'");
        return this;
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
